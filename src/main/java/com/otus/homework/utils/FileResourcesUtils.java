package com.otus.homework.utils;

import java.io.*;

public class FileResourcesUtils {
    private static final String ERROR_MESSAGE_NOT_FOUND = "File not found! ";

    // get a file from the resources folder
    // works everywhere, IDEA, unit test and JAR file.
    public InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_FOUND + fileName);
        } else {
            return inputStream;
        }
    }
}