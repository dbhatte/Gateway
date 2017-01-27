package com.devendra.gateway.controller;

/**
 * Created by devendra on 27/01/2017.
 */

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.jsonpath.JsonPath;

@TestComponent
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate template;


    @Test
    public void testRequest() throws Exception {
        String body = template.getForEntity(UserController.MERGED_URL + "?id=1", String.class).getBody();

        String id = JsonPath.parse(body).read("$.id", String.class);
        assertThat(id, containsString("1"));

        String city = JsonPath.parse(body).read("$.address.city", String.class);
        assertThat(city, containsString("Gwenborough"));

        String title = JsonPath.parse(body).read("$.posts[0].title", String.class);
        assertThat(title, containsString("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));

    }

}
