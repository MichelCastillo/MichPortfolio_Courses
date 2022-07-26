package com.mich.core.core;

import com.mich.core.core.services.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoreApplicationTests {

	@Autowired
	private PaymentService service;

	@Test
	void contextLoads() {
	}

	@Test
	public void testDependencyInjection(){
		assertNotNull(service);
	}

}
