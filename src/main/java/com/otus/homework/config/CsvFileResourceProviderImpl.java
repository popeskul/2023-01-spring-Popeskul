package com.otus.homework.config;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component("csvFileNameProvider")
public class CsvFileResourceProviderImpl implements CsvFileResourceProvider {
    private final ResourceLoader resourceLoader;
    private static final String FILE_NAME_PATTERN = "classpath:questions_answers_%s.csv";

    public CsvFileResourceProviderImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource getCsvFileResource(String locale) {
        String fileName = String.format(FILE_NAME_PATTERN, locale);
        return resourceLoader.getResource(fileName);
    }
}
