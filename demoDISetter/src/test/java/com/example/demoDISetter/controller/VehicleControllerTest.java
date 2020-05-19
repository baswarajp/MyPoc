package com.example.demoDISetter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demoDISetter.model.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = VehicleController.class)
class VehicleControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	private VehicleController vehicleController;

	Vehicle v = new Vehicle(1, "firstName", "lastName", 21, "city", "state", "country", 123, "vehicleType",
			"vehicleModel", "insTime", new Date());

	String exampleCourseJson = "{\"id\":\"1\",\"firstName\":\"ABC\",\"lastName\":\"DEF\",\"age\":\21\",\"city\":\"HYD\",\"state\":\"TS\",\"country\":\"IND\",\"mobile\":\"456\",\"vehicleType\":\"bike\",\"vehicleModel\":\"xyz\",\"insTime\":\"ghn\",,\"date\":\"18-05-2020\"}";

	@Test
	public void getByName() throws Exception {

		Mockito.when(vehicleController.getByName(Mockito.anyString())).thenReturn(v);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getByName/Sheryl")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		ObjectMapper map = new ObjectMapper();
		String expected = map.writeValueAsString(v);
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		verify(vehicleController).getByName(Mockito.anyString());
	}

	@Test
	public void getAll() throws Exception {

		List<Vehicle> vs = new ArrayList<>();
		vs.add(v);

		Mockito.when(vehicleController.getAll()).thenReturn(vs);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAll").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		ObjectMapper map = new ObjectMapper();
		String expected = map.writeValueAsString(vs);
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		verify(vehicleController).getAll();
	}

	/*
	 * @Test public void testAdd() throws Exception {
	 * Mockito.when(vehicleController.add(Mockito.any(Vehicle.class))).thenReturn(v)
	 * ; RequestBuilder requestBuilder =
	 * MockMvcRequestBuilders.post("/insert").accept(MediaType.APPLICATION_JSON)
	 * .content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);
	 * MvcResult result = mvc.perform(requestBuilder).andReturn();
	 * 
	 * System.out.println(result.getResponse().getContentAsString()); ObjectMapper
	 * map = new ObjectMapper(); String expected = map.writeValueAsString(v);
	 * JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),
	 * false);
	 * 
	 * }
	 */

	@Test
	public void testUpdate() throws Exception {
		Mockito.when(vehicleController.update(Mockito.anyInt())).thenReturn(v);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/update/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		ObjectMapper map = new ObjectMapper();
		String expected = map.writeValueAsString(v);
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		verify(vehicleController).update(Mockito.anyInt());
	}

	@Test
	public void testDelete() throws Exception {
		String v = "deleted";
		Mockito.when(vehicleController.delete(Mockito.anyInt())).thenReturn(v);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.delete("/delete/1")).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(status, HttpStatus.OK.value());
		verify(vehicleController).delete(Mockito.anyInt());
		// System.out.println(mvcResult.getResponse().getContentAsString());
		// JSONAssert.assertEquals(v, mvcResult.getResponse().getContentAsString(),
		// false);
	}

}
