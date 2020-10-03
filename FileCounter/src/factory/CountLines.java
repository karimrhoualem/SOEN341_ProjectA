package factory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountLines extends Count implements IConfigureCounter {
    @Override
    public void StartCounter(String[] args) throws IOException {
        if (args.length == 1) {
            srcFileName = args[0];
            fileInputStream = new FileInputStream((srcFileName));
            reader = new BufferedReader(new InputStreamReader(fileInputStream));

            _count = 0;

            String line = reader.readLine();
            while (line != null) {
                _count++;
                line = reader.readLine();
            }

            System.out.println("Total line count is: " + _count + ".");
        }
        else if (args.length == 2) {
            srcFileName = args[1];
            fileInputStream = new FileInputStream((srcFileName));
            reader = new BufferedReader(new InputStreamReader(fileInputStream));

            _count = 0;

            String line = reader.readLine();
            while (line != null) {
                _count++;
                line = reader.readLine();
            }

            System.out.println("Total line count is: " + _count + ".");
            Verbose(_count);
        }
    }

    @Override
    public void Verbose(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print('L');
        }
    }

    @Override
    public void GeneralUsageInformation() {
        System.out.println("LineCount <src>\t" + "Passed with one file source as an argument and no options. Displays information about the file.");
        System.out.println("General Usage Examples:");
        System.out.println("\tjava LineCount file1.txt");
        System.out.println();
    }

    @Override
    public void HelpOptionInformation() {
        System.out.println("-h, -?, -help\t" + "Passed with no arguments and displays helpful information.");
        System.out.println("Help Option Examples:");
        System.out.println("\tjava LineCount -h" + "\tor,");
        System.out.println("\tjava LineCount -help" + "\tor,");
        System.out.println("\tjava LineCount -?");
        System.out.println();
    }

    @Override
    public void BannerOptionInformation() {
        System.out.println("-b, -banner\t" + "Passed with no arguments and displays version and copyright information.");
        System.out.println("Banner Option Examples:");
        System.out.println("\tjava LineCount -b" + "\tor,");
        System.out.println("\tjava LineCount -banner");
        System.out.println();
    }

    @Override
    public void VerboseOptionInformation() {
        System.out.println("-v, -verbose\t" + "Passed with one file source as an argument and displays the most detailed information about the file.");
        System.out.println("Verbose Option Examples:");
        System.out.println("\tjava LineCount -v file1.txt" + "\tor,");
        System.out.println("\tjava LineCount -verbose file2.txt");
        System.out.println();
    }

    @Override
    public void BannerMessage() {
        System.out.println("CountLines Version 2.0.0.0");
        System.out.println("Copyright (C) Karim Rhoualem 2020. All Rights Reserved.");
        System.out.println("Written by Karim Rhoualem.");
        System.out.println();
    }
}