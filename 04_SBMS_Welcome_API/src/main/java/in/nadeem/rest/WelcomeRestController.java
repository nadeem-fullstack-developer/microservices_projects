package in.nadeem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.nadeem.feign.GreetFeignClient;

@RestController
public class WelcomeRestController {

	@Autowired
	private GreetFeignClient greetClient;

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		/*
		 * RestTemplate rt = new RestTemplate(); ResponseEntity<String> forEntity =
		 * rt.getForEntity("http://localhost:8081/greet", String.class);
		 * 
		 * String greetResponse = forEntity.getBody(); return greetResponse + ", " +
		 * "welcome to Microservices Practise";
		 * 
		 */
		String greetResp = greetClient.invokeGreetApi();

		return greetResp + ", " + "Welcome to Microservices Practise";
	}
}
