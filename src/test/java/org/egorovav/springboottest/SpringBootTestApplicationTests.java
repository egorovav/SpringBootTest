package org.egorovav.springboottest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
class SpringBootTestApplicationTests {

	@Autowired
	private AppProperty appProperty;

	@Test
	void contextLoads() {
	}

	@Test
	public void propertyTest() {
		assertNotNull(appProperty);
		assertEquals("/test.csv", appProperty.getPath());
		assertEquals(3, appProperty.getPassValue());
	}

}
