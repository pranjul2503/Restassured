package helpers;

import java.io.FileNotFoundException;

import constants.Endpoint;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.Configmanager;
import utils.User_jsonCreater;
import utils.Yamlreader;

public class ServiceHelper {
	public static String BaseURL = Configmanager.readProperty("BaseUrl");
	public ServiceHelper() {
		RestAssured.baseURI = BaseURL;
	}

	public Response getUserlist() {
		System.out.println(BaseURL);
		Response response = RestAssured
				.given().log().all()
					.get(Endpoint.LIST_USERS);
		return response;
	}
	public Response getuser() throws FileNotFoundException {
		System.out.println(BaseURL);
		Response response = RestAssured
				.given().log().all()
					.pathParam("id",Yamlreader.getValue("id"))
					.get(Endpoint.GET_SINGLE_USER);
		return response;
	}
	public Response get_resource_list() {
		Response response = RestAssured
				.given().log().all()
					.get(Endpoint.Get_Resource_list);
		return response;
	}
	public Response get_resource() throws FileNotFoundException {
		Response response = RestAssured
				.given().log().all()
					.pathParam("resource", Yamlreader.getValue("resource"))
					.get(Endpoint.Get_Resource);
		return response;
	}
	public Response Create_user() throws FileNotFoundException {
		
		Response response = RestAssured
				.given().log().all().header("content-Type", "application/json")
				.body(User_jsonCreater.Object_creater("name","job"))
				.when()
					.post(Endpoint.Create_user);
		return response;
	}
	public Response register_user() throws FileNotFoundException{
		Response response = RestAssured
				.given().log().all().header("content-Type", "application/json")
				.body(User_jsonCreater.Object_creater("email","password"))
				.when()
					.post(Endpoint.Register);
		return response;
	}
	public Response unsuccessful_register() throws FileNotFoundException{
		Response response = RestAssured
				.given().log().all().header("content-Type", "application/json")
				.body(User_jsonCreater.Object_creater("email"))
				.when()
					.post(Endpoint.Register);
		return response;
	}
	public Response login() throws FileNotFoundException {
		Response response = RestAssured
				.given().log().all().header("content-Type", "application/json")
				.body(User_jsonCreater.Object_creater("email","password"))
				.when()
					.post(Endpoint.Login);
		return response;
		
	}
	public Response Unsuccessful_login() throws FileNotFoundException {
		Response response = RestAssured
				.given().log().all().header("content-Type", "application/json")
				.body(User_jsonCreater.Object_creater("email"))
				.when()
					.post(Endpoint.Login);
		return response;
	}
}
