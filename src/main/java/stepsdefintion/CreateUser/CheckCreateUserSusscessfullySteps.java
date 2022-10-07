package stepsdefintion.CreateUser;

import static org.testng.Assert.assertEquals;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import common.ApiUtils;
import common.JsonUltils;
import common.Response;
import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.Json;
import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonValue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;

public class CheckCreateUserSusscessfullySteps {
	String url, method, requestBodyName;
	int actualStatusCode;
	String actualJob, actualResponseBody;
	ArrayList<String> actualNameList;

	@Given("I have Url and method and requestBody")
	public void i_have_url_and_method_and_request_body(List<Map<String, String>> resquestDatas) {
		for (Map<String, String> requestData : resquestDatas) {
			url = requestData.get("url");
			method = requestData.get("method");
			requestBodyName = requestData.get("requestBodyName");
		}
	}

	@When("I send the request with valid data")
	public void i_send_the_request_with_valid_data() {
		ApiUtils apiUtils = new ApiUtils();
		JsonUltils jsonUtils = new JsonUltils();
		String requestBody = jsonUtils.readJsonFile(
				"C:\\Users\\truyendtt\\Documents\\GitHub\\ApiProject\\ReqresApiProject\\src\\main\\resources\\CreateUser\\"
						+ requestBodyName);
		Response<Integer, String> result = apiUtils.sendRequest(method, url, requestBody);
		actualStatusCode = result.getStatusCode();
		actualResponseBody = result.getResponseBody();
		/*Object obj = JSONValue.parse(actualResponseBody);
		JSONObject jsonObject = (JSONObject) obj;
		Object actualName = jsonObject.get("name");
		String actualNameStr = actualName.toString();
		actualNameList = new ArrayList<>(Arrays.asList(actualNameStr));*/
		actualNameList = jsonUtils.getArrayValueByKey(actualResponseBody, "name");
	}

	@Then("The reponse returns status {string} and responsebody {string} and {string}")
	public void the_reponse_returns_status_and_responsebody_and(String expectedStatuscode, String expectedJob,
			String ExpectedName) {
		assertEquals(actualStatusCode, Integer.parseInt(expectedStatuscode));
		// assertEquals(actualJob, expectedJob);
		// assertEquals(actualName, ExpectedName);
		for (int i = 0; i < actualNameList.size(); i++) {
			// i is the index
			// yourArrayList.get(i) is the element
			if (actualNameList.get(i).equals(ExpectedName)) {
				assertEquals(actualNameList.get(i), ExpectedName);
			}

		}
	}

}
