package org.egorovav.springboottest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "test")
public class AppProperty {

    private String path;

    private int passValue;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPassValue() {
        return passValue;
    }

    public void setPassValue(int passValue) {
        this.passValue = passValue;
    }
}
