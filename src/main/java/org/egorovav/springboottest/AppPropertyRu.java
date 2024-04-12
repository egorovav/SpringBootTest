package org.egorovav.springboottest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "test.ru")
public class AppPropertyRu extends AppProperty {
}
