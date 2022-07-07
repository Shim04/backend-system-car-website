package com.udacity.pricing;

import com.udacity.pricing.entity.Price;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAPrice() {
		long id = 1L;
		String baseURL = "http://localhost:" + port + "/prices/";
		Price price = restTemplate.getForObject(baseURL + id, Price.class);
		assertNotNull(price);
		assertEquals(price.getPrice(), new BigDecimal(3563));
		assertEquals(price.getCurrency(), "EUR");
	}
}
