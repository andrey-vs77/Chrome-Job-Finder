package com.sanda.chrome.freelancehunt;

import com.sanda.chrome.domain.entity.Job;
import com.sanda.chrome.domain.entity.Skills;
import com.sanda.chrome.freelancehunt.restful.objects.Project;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cdc89 on 19.02.2017.
 */
public class JobAdapter {

    Job job;
    Project project;

    public JobAdapter(Project project) {
        this.project = project;
        job = new Job();
    }

    public Job convert() {
        parseStringAttribute(project.getUrl(), "url");
        parseStringAttribute(project.getName(), "title");
        parseStringAttribute(project.getDescription(), "description");
        parseStringAttribute(project.getPublication_time().toString(), "posted");
        parseDateAttribute(new Date(), "parseDate");
        parseProjectSkillsAttribute(project.getSkills().values(),"skills");
        return job;
    }

    private void parseProjectSkillsAttribute(Collection collectionAttribute, String jobAttributeName){
        if (collectionAttribute!=null){
            Set<Skills> skillsSet=new HashSet<>();
            for (Object element:collectionAttribute){
                Skills skills=new Skills((String)element);
                skills.setJob(job);
                skillsSet.add(skills);
            }
            set(jobAttributeName, skillsSet);
        }
    }

    private void parseDateAttribute(Date dateAttribute, String jobAttributeName) {
        if (dateAttribute != null) {
            set(jobAttributeName, dateAttribute);
        }
    }

    private void parseStringAttribute(String projectAttribute, String jobAttributeName) {
        String value = prepareString(projectAttribute);
        if (value != null) {
            set(jobAttributeName, value);
        }
    }

    private String prepareString(String str) {
        return str != null ? str.toLowerCase().trim() : null;
    }

    public boolean set(String attr, Object value) {
        Class<?> clazz = job.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(attr);
                field.setAccessible(true);
                field.set(job, value);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }
}
