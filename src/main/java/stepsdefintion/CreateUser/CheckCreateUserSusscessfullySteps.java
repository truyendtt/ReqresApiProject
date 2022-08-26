package stepsdefintion.CreateUser;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CheckCreateUserSusscessfullySteps {
	String url, method, requestBodyName;
//	@Given("I have Url and method and requestBody")
	public void i_have_url_and_method_and_request_body(List<Map<String, String>> resquestDatas) {
	  for(Map<String, String> requestData: resquestDatas) {
		  url = requestData.get("url");
		  method = requestData.get("method");
		  requestBodyName= requestData.get("requestBodyName");
	  }
	}

//	@Then("The reponse returns status {string} and responsebody {string} and {string}")
	public void the_reponse_returns_status_and_responsebody_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
	   
	}

	
}
