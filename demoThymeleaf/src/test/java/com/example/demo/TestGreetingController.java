/**
 * 
 */
package com.example.demo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestGreetingController {

	@Autowired
	private MockMvc mvc;

	/**
	 * {@link com.example.demo.GreetingController#greeting(java.lang.String, org.springframework.ui.Model)}
	 * のためのテスト・メソッド。
	 * @throws Exception 
	 */
	@Test
	public void testGreeting() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.TEXT_HTML ))
		.andExpect(status().isOk());
		//.andExpect(content(). );
		//fail("まだ実装されていません");
	}

}
