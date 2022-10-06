package stepsdefintion.CreateUser;

import static org.testng.Assert.assertEquals;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import common.ApiUtils;
import common.JsonUltils;
import common.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;

public class CheckCreateUserSusscessfullySteps {
	String url, method, requestBodyName;
	int actualStatusCode ;
	String actualResponseBody;
	@Given("I have Url and method and requestBody")
	public void i_have_url_and_method_and_request_body(List<Map<String, String>> resquestDatas) {
	  for(Map<String, String> requestData: resquestDatas) {
		  url = requestData.get("url");
		  method = requestData.get("method");
		  requestBodyName= requestData.get("requestBodyName");
	  }
	}
	@When("I send the request with valid data")
	public void i_send_the_request_with_valid_data() {
		ApiUtils apiUtils = new ApiUtils();
		JsonUltils jsonUtils = new JsonUltils();
		String requestBody = jsonUtils.readJsonFile("C:\\Users\\truyendtt\\Documents\\GitHub\\ApiProject\\ReqresApiProject\\src\\main\\resources\\CreateUser\\" + requestBodyName);
		Response<Integer, String> result = apiUtils.sendRequest(method, url, requestBody);
		actualStatusCode = result.getStatusCode();
		actualResponseBody= result.getResponseBody();
		System.out.println("------------------"+actualResponseBody);

	}

	@Then("The reponse returns status {string} and responsebody {string} and {string}")
	public void the_reponse_returns_status_and_responsebody_and(String expectedStatuscode, String expectedJob, String ExpectedName) {
	   assertEquals(actualStatusCode, Integer.parseInt(expectedStatuscode));
	}

	
}
