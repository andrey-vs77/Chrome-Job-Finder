package com.sanda.chrome.domain;

import com.sanda.chrome.domain.entity.Job;
import com.sanda.chrome.domain.entity.Skills;
import com.sanda.chrome.domain.entity.StopWord;
import com.sanda.chrome.domain.repo.SkillsRepository;
import com.sanda.chrome.domain.service.JobService;
import com.sanda.chrome.domain.service.SkillsService;
import com.sanda.chrome.domain.service.StopWordService;
import com.sanda.chrome.util.SiteProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by cdc89 on 05.02.2017.
 */
@Component
public class Provider implements SiteProcessor {

  private static final Logger log = LoggerFactory.getLogger(Provider.class);
  private final String MAIL_SENDER = "andrey.serkes@gmail.com";
  private final String MAIL_RECEIVER = "andrey.serkes@gmail.com";
  private final String UPWORK_PREFIX = "https://www.upwork.com";
  private final int MAX_LENGTH_DESC = 200;

  @Autowired
  JobService jobService;
  @Autowired
  SkillsService skillsService;
  @Autowired
  StopWordService stopWordService;
  @Autowired
  JavaMailSender mailSender;

  public String processNewJobJson(Job newJob) throws IllegalAccessException {
    String jobUrl = newJob.getUrl();
    if (jobService.findByUrl(jobUrl) != null) {
      return "old";
    }
    fieldToLowerCase(newJob);
    Job savedJob = jobService.save(newJob);
    newJob.getSkills().stream().map(s -> {
      try {
        fieldToLowerCase(s);
      } catch (IllegalAccessException e) {
      }
      s.setJob(savedJob);
      return s;
    }).forEach(s -> skillsService.save(s));
    return "new";
  }

  private String prepareString(String input) {
    return input.trim().toLowerCase();
  }

  public void emailNewJobsNoStopWords() throws IllegalAccessException {
    List<Job> newJobs = jobService.findByViewed(false);
    newJobs = removeJobsWithStopWords(newJobs);
    if (newJobs.size() == 0) {
      checkChrome(newJobs);
      return;
    }
    String mailContent = prepareMailContent(newJobs);
    sendMail(MAIL_SENDER, MAIL_RECEIVER, "new jobs", mailContent);
    newJobs.stream().map(s -> {
      s.setViewed(true);
      return s;
    }).forEach(jobService::save);
    log.info("emailNewJobsNoStopWords() finish");
  }

  /**
   * check if there are not new jobs in 30 minutes and send email if condition is true
   */
  private void checkChrome(List<Job> newJobs) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    cal.add(Calendar.MINUTE, -30);
    Date checkTime = cal.getTime();
    List<Job> latestJob = new ArrayList<>();
    newJobs.stream().filter(d -> {
      return d.getParseDate().after(checkTime);
    }).forEach(latestJob::add);
    if (latestJob.size() == 0) {
      String mailContent = "In 30 mintunes there are not new jobs. Please check Chrome";
      sendMail(MAIL_SENDER, MAIL_RECEIVER, "CHECK CHROME", mailContent);
    }
  }

  private String prepareMailContent(List<Job> newJobs) {
    StringBuilder mailContent = new StringBuilder();
    for (Job job : newJobs) {
      mailContent.append("=================================\n");
      mailContent.append(String.format("%s\n", job.getTitle()));
      if (!job.getUrl().startsWith("http")) {
        mailContent.append(String.format("%s%s\n", UPWORK_PREFIX, job.getUrl()));
      } else {
        mailContent.append(String.format("%s\n", job.getUrl()));
      }
      String description = job.getDescription().length() > MAX_LENGTH_DESC ? job.getDescription()
          .substring(0, MAX_LENGTH_DESC) : job.getDescription();
      mailContent.append(String.format("%s...\n", description));
    }
    return mailContent.toString();
  }

  public void emailUnViewedJobsWithStopWords() throws IllegalAccessException {
    List<Job> newJobs = jobService.findByViewed(false);
    newJobs = getJobsWithStopWords(newJobs);
    if (newJobs.size() == 0) {
      return;
    }
    String mailContent = prepareMailContent(newJobs);
    sendMail(MAIL_SENDER, MAIL_RECEIVER, "new jobs with STOP WORDS", mailContent);
    for (Job job : newJobs) {
      job.setViewed(true);
      jobService.save(job);
    }
  }

  private List<Job> getJobsWithStopWords(List<Job> jobs) throws IllegalAccessException {
    ListIterator<Job> it = jobs.listIterator();
    log.info("getJobsWithStopWords() - remove jobs which do not have stop words :");
    while (it.hasNext()) {
      Job el = it.next();
      if (!findStopWord(el)) {
        log.debug(
            String.format("job title - %s; description - %s;", el.getTitle(), el.getDescription()));
        it.remove();
      }
    }
    return jobs;
  }

  protected void sendMail(String from, String to, String subject, String content) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(from);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(content);
    mailSender.send(message);
  }

  public void sendEmailNotice(String subject, String notice) {
    sendMail(MAIL_SENDER, MAIL_RECEIVER, subject, notice);
  }

  private List<Job> removeJobsWithStopWords(List<Job> jobs) throws IllegalAccessException {
    ListIterator<Job> it = jobs.listIterator();
    log.info("removeJobsWithStopWords() - remove jobs which have stop words :");
    while (it.hasNext()) {
      Job el = it.next();
      if (findStopWord(el)) {
        log.debug(
            String.format("job title - %s; description - %s;", el.getTitle(), el.getDescription()));
        it.remove();
      }
    }
    return jobs;
  }

  private boolean findStopWordInObject(Object input, String stopWord)
      throws IllegalAccessException {
    Class<?> clazz = input.getClass();
    for (Field field : clazz.getDeclaredFields()) {
      if (field.getType().isAssignableFrom(String.class)) {
        field.setAccessible(true);
        if (field.get(input) == null) {
          return false;
        }
        String value = field.get(input).toString();
        if (value.contains(prepareString(stopWord))) {
          log.debug(String.format("stop word - %s;", stopWord));
          return true;
        }
      }
    }
    return false;
  }

  private void fieldToLowerCase(Object input) throws IllegalAccessException {
    Class<?> clazz = input.getClass();
    for (Field field : clazz.getDeclaredFields()) {
      if (field.getType().isAssignableFrom(String.class)) {
        field.setAccessible(true);
        String value = field.get(input) == null ? "" : field.get(input).toString();
        value = prepareString(value);
        field.set(input, value);
      }
    }
  }

  private boolean findStopWord(Job job) throws IllegalAccessException {
    List<StopWord> stopWordList = stopWordService.findAll();
    for (StopWord stopWord : stopWordList) {
      //find stop word in job
      if (findStopWordInObject(job, stopWord.getWord())) {
        return true;
      }
      //find stop word in skills
      for (Skills skill : job.getSkills()) {
        if (findStopWordInObject(skill, stopWord.getWord())) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public void process(String url) throws IllegalAccessException {
    emailNewJobsNoStopWords();
  }
}
