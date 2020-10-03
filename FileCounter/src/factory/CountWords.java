package factory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountWords extends Count implements IConfigureCounter {
    private static boolean isSpace(int c) {
        return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
    }

    @Override
    public void StartCounter(String[] args) throws IOException {
        if (args.length == 1) {
            srcFileName = args[0];
            fileInputStream = new FileInputStream((srcFileName));
            reader = new BufferedReader(new InputStreamReader(fileInputStream));

            int character;
            _count = 0;
            boolean inWord = false;

            while ((character = reader.read()) != -1) {
                if(!isSpace(character)) {
                    if (!inWord) {
                        inWord = true;
                        ++_count;
                    }
                } else {
                    inWord = false;
                }
            }

            System.out.println("Total words read: " + _count + ".");
        }
        else if (args.length == 2) {
            srcFileName = args[1];
            fileInputStream = new FileInputStream((srcFileName));
            reader = new BufferedReader(new InputStreamReader(fileInputStream));

            int character;
            _count = 0;
            boolean inWord = false;

            while ((character = reader.read()) != -1) {
                if(!isSpace(character)) {
                    if (!inWord) {
                        inWord = true;
                        ++_count;
                    }
                } else {
                    inWord = false;
                }
            }

            System.out.println("Total words read: " + _count + ".");
            Verbose(_count);
        }
    }

    @Override
    public void Verbose(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print('W');
        }
        System.out.println();
    }

    @Override
    public void GeneralUsageInformation() {
        System.out.println("WordCount <src>\t" + "Passed with one file source as an argument and no options. Displays information about the file.");
        System.out.println("General Usage Examples:");
        System.out.println("\tjava WordCount file1.txt");
        System.out.println();
    }

    @Override
    public void HelpOptionInformation() {
        System.out.println("-h, -?, -help\t" + "Passed with no arguments and displays helpful information.");
        System.out.println("Help Option Examples:");
        System.out.println("\tjava WordCount -h" + "\tor,");
        System.out.println("\tjava WordCount -help" + "\tor,");
        System.out.println("\tjava WordCount -?");
        System.out.println();
    }

    @Override
    public void BannerOptionInformation() {
        System.out.println("-b, -banner\t" + "Passed with no arguments and displays version and copyright information.");
        System.out.println("Banner Option Examples:");
        System.out.println("\tjava WordCount -b" + "\tor,");
        System.out.println("\tjava WordCount -banner");
        System.out.println();
    }

    @Override
    public void VerboseOptionInformation() {
        System.out.println("-v, -verbose\t" + "Passed with one file source as an argument and displays the most detailed information about the file.");
        System.out.println("Verbose Option Examples:");
        System.out.println("\tjava WordCount -v file1.txt" + "\tor,");
        System.out.println("\tjava WordCount -verbose file2.txt");
        System.out.println();
    }

    @Override
    public void BannerMessage() {
        System.out.println("CountWords Version 2.0.0.0");
        System.out.println("Copyright (C) Karim Rhoualem 2020. All Rights Reserved.");
        System.out.println("Written by Karim Rhoualem.");
        System.out.println();
    }
}