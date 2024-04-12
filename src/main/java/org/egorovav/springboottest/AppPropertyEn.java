package org.egorovav.springboottest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "test.en")
public class AppPropertyEn extends AppProperty {
}
