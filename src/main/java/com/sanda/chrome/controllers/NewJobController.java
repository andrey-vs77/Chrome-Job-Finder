package com.sanda.chrome.controllers;

import com.sanda.chrome.domain.Provider;
import com.sanda.chrome.domain.entity.Job;
import com.sanda.chrome.util.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by cdc89 on 03.02.2017.
 */
@Controller
public class NewJobController {
    @Autowired
    Provider jobProvider;
    private static final Logger log = LoggerFactory.getLogger(NewJobController.class);

    @RequestMapping(value = "/job/new", method = RequestMethod.POST)
    public
    @ResponseBody
    String save(@RequestBody Job request, Model model) throws IOException, ServletException, IllegalAccessException {
        log.debug(request.getTitle());
//        request.getSkills().stream().map(s -> s.getSkill()).forEach(System.out::println);
        String result = jobProvider.processNewJobJson(request);
        String resultJson = String.format("{\"result\": \"%s\"}",result);
        log.debug(String.format("resultJson - %s",resultJson));
        return resultJson;
    }
}
