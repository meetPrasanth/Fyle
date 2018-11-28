package com.fyle.fylechallenge.integration.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fyle.fylechallenge.constants.ServiceConstants;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Log4j2
public class FyleIntegrationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getBankByIfsc() throws Exception {
		log.traceEntry();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bank-info")
				.param(ServiceConstants.IFSC, "ABHY0065004").contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		log.traceExit(result.getResponse().getContentAsString());
	}
	
	@Test
	public void getBankByNameAndCity() throws Exception {
		log.traceEntry();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bank-info/branches")
				.param(ServiceConstants.NAME, "ALLAHABAD BANK")
				.param(ServiceConstants.CITY, "KOLKATA")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		log.traceExit(result.getResponse().getContentAsString());
	}
}
