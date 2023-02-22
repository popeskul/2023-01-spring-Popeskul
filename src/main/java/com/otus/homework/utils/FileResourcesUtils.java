package com.otus.homework.utils;

import com.otus.homework.config.AppProps;
import org.springframework.context.MessageSource;

import java.io.InputStream;

public class FileResourcesUtils {
    private final MessageSource messageSource;
    private final AppProps props;

    public FileResourcesUtils(MessageSource messageSource, AppProps props) {
        this.messageSource = messageSource;
        this.props = props;
    }

    // get a file from the resources folder
    // works everywhere, IDEA, unit test and JAR file.
    public InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException(messageSource.getMessage("error.file.not.found", new String[]{fileName}, props.getLocale()));
        } else {
            return inputStream;
        }
    }
}