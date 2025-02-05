package com.ontariotechu.sofe3980U;

//import com.ontariotechu.sofe3980U.HelloController;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class) //specifies the class to be tested
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/hello")) //performs a GET request to the URL /hello.
		.andExpect(status().isOk())     //checks that the response is ok.
		.andExpect(view().name("hello")) //checks that the response uses the hello.html template.
		.andExpect(model().attribute("name", "World")); //checks that the attribute name within the template is set to the value "World".
    }
	
    @Test
    public void helloWithName() throws Exception {
        this.mvc.perform(get("/hello?name=Doe"))
		.andExpect(status().isOk())
		.andExpect(view().name("hello"))
		.andExpect(model().attribute("name", "Doe"));
    }
}