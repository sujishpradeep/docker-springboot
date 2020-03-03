package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.resource.HelloResource;


@RunWith(SpringJUnit4ClassRunner.class)
public class HelloResourceTest {

	private MockMvc mockMvc;

	@InjectMocks
	private HelloResource helloResource;

	@Before
	public void setup() throws Exception{
		// TODO Auto-generated method stub
		mockMvc = MockMvcBuilders.standaloneSetup(helloResource).build();

	}

	@Test
	public void testHelloWorld() throws Exception{

		mockMvc.perform(get("/rest/docker/hello")).andExpect(status().isOk()).andExpect(content().string("Hello Youtube"));

	}
	
    @Test
    public void testHelloWorldJson() throws Exception {
        mockMvc.perform(get("/rest/docker/hello/json")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", Matchers.is("trance")))
                .andExpect(jsonPath("$.value", Matchers.is("100")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }

}
