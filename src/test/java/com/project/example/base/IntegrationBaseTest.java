package com.project.example.base;

import com.project.example.ExampleApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ExampleApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class IntegrationBaseTest {

    @Value("${local.server.port}")
    protected Integer port;

    public String getBaseUrl(){
        return String.format("http://localhost:%d", port);
    }


}