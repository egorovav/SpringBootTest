package org.egorovav.springboottest;

public interface MessageFactory {

    String getMessage(String key, Object... args);

    default String getMessage(String key) {
        return getMessage(key, new Object[]{});
    }
}
