package apiTests;


import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import helpers.ServiceHelper;
import io.restassured.response.Response;

public class Apitest {

	ServiceHelper service = new ServiceHelper();

	@Test
	public void Getalluser() {
		Response response = service.getUserlist();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void Getuser() throws FileNotFoundException {
		Response response = service.getuser();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.jsonPath().getString("data.id"), "1");
	}

	@Test
	public void Getresourcelist() {
		Response response = service.get_resource_list();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void Getresource() throws FileNotFoundException {
		Response response = service.get_resource();
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("data.id"), "1");
	}

	@Test
	public void Createuser() throws FileNotFoundException {
		Response response = service.Create_user();
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertFalse(response.jsonPath().getString("id").isEmpty());
	}

	@Test
	public void Register() throws FileNotFoundException {
		Response response = service.register_user();
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertFalse(response.jsonPath().getString("id").isEmpty());
		Assert.assertFalse(response.jsonPath().getString("token").isEmpty());
	}
	@Test
	public void Uncussessful_Register() throws FileNotFoundException {
		Response response = service.unsuccessful_register();
		Assert.assertEquals(response.getStatusCode(), 400);
		Assert.assertEquals(response.jsonPath().getString("error"), "Missing password");
	}
	@Test
	public void login() throws FileNotFoundException {
		Response response=service.login();
		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertNotNull(response.jsonPath().getString("token"));
	}
	@Test
	public void Unsuccessful_login() throws FileNotFoundException {
		Response response = service.Unsuccessful_login();
		Assert.assertEquals(response.getStatusCode(), 400);
		Assert.assertEquals(response.jsonPath().getString("error"), "Missing password");
	}
}
