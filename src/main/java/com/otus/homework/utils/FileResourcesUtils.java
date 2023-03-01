package com.otus.homework.utils;

import com.otus.homework.config.LocaleHolder;
import org.springframework.context.MessageSource;

import java.io.InputStream;

public class FileResourcesUtils {
    private final MessageSource messageSource;
    private final LocaleHolder localeHolder;

    public FileResourcesUtils(MessageSource messageSource, LocaleHolder localeHolder) {
        this.messageSource = messageSource;
        this.localeHolder = localeHolder;
    }

    // get a file from the resources folder
    // works everywhere, IDEA, unit test and JAR file.
    public InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException(messageSource.getMessage("error.file.not.found", new String[]{fileName}, localeHolder.getLocale()));
        } else {
            return inputStream;
        }
    }
}