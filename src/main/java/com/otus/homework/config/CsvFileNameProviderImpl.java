package com.otus.homework.config;

public class CsvFileNameProviderImpl implements CsvFileNameProvider {
    private final CsvHolder csvHolder;

    public CsvFileNameProviderImpl(CsvHolder csvHolder) {
        this.csvHolder = csvHolder;
    }

    public String getFileName(String locale) {
        return csvHolder.getCsv().get(locale);
    }
}

