package ru.otus.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties(prefix = "application")
public class AppProps {
    private Locale locale;
    private Integer neededAnswers;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Integer getNeededAnswers() {
        return neededAnswers;
    }

    public void setNeededAnswers(Integer neededAnswers) {
        this.neededAnswers = neededAnswers;
    }
}
