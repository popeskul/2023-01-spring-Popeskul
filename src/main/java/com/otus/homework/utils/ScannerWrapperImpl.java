package com.otus.homework.utils;

import java.util.Scanner;

public class ScannerWrapperImpl implements ScannerWrapper {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }
}
