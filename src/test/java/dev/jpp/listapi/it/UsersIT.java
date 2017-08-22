package dev.jpp.listapi.it;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import dev.jpp.listapi.ListApiApplication;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ListApiApplication.class)
//@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class UsersIT {
//	@Autowired
//    private MockMvc mvc;
// 
//	@Test
	public void getAllUsers_whenGetUsers_thenStatus200() throws Exception {
//		mvc.perform(get("/users/ping")
//	      .contentType(MediaType.APPLICATION_JSON))
//	      .andExpect(status().isOk())
//	      .andExpect(content()
//	      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//	      .andExpect(jsonPath("$[0].name", is("bob")));
		
//		mvc.perform(get("/users/ping")
//			      .contentType(MediaType.APPLICATION_JSON))
//			      .andExpect(status().isOk())
//			      .andExpect(content()
//			      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//			      .andExpect(jsonPath("$[0].name", is("bob")));
	}
}
