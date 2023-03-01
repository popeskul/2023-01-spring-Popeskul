package com.otus.homework.config;

import org.springframework.core.io.Resource;

public interface CsvFileResourceProvider {
    Resource getCsvFileResource(String locale);
}
