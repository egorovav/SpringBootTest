package org.egorovav.springboottest;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

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
	public void propertyRuTest() {

		Locale locale = LocaleContextHolder.getLocale();
		if("ru".equals(locale.getLanguage())) {
			assertEquals("/test_ru_test.csv", appProperty.getPath());
			assertEquals(11, appProperty.getPassValue());
		} else {
			assertEquals("/test_test.csv", appProperty.getPath());
			assertEquals(10, appProperty.getPassValue());
		}

	}

}
