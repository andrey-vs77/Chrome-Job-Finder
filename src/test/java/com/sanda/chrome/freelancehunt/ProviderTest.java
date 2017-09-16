package com.sanda.chrome.freelancehunt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cdc89 on 19.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProviderTest {

    @Autowired
    ProviderHunt provider;

    @Test
    public void processProjectsTest() {
        provider.processProjects("https://api.freelancehunt.com/projects?skills=13,99,103,85,121");
    }
}