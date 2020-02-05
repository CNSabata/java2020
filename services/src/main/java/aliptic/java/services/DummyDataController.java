package aliptic.java.services;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DummyDataController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DummyDataController.class);

	private final static String GET_DUMMY_DATA = "http://dummy.restapiexample.com/api/v1/employees";
	private RestTemplate restTemplate;

	@Autowired
	public DummyDataController(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}
	
	@Bean
	public RestTemplate myRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@GetMapping(value = "/dummydata/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map getTest() {
		LOGGER.debug("/dummydata/test - debut");
		Map res = restTemplate.getForObject(GET_DUMMY_DATA, Map.class);
		return res;
	}
	
	@GetMapping(value = "/dummydata/test2", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map getTest2(RestTemplate myRestTemplate) {
		LOGGER.debug("/dummydata/test2 - debut");
		Map res = restTemplate.getForObject(GET_DUMMY_DATA, Map.class);
		return res;
	}
}
