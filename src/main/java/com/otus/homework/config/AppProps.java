package com.otus.homework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;
import java.util.Map;

@ConfigurationProperties(prefix = "application")
public class AppProps implements LocaleHolder, CsvHolder {
    private Locale locale;
    private Map<String, String> csv;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getLocaleString() {
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    public Map<String, String> getCsv() {
        return csv;
    }

    public void setCsv(Map<String, String> qnaCsv) {
        this.csv = qnaCsv;
    }
}
