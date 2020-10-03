package factory;

import java.io.IOException;

public class WC extends Count implements IConfigureCounter {
    Factory factory = new Factory();
    IConfigureCounter charCounter = factory.getFactoryType("CHARCOUNT");
    IConfigureCounter wordCounter = factory.getFactoryType("WORDCOUNT");
    IConfigureCounter lineCounter = factory.getFactoryType("LINECOUNT");

    @Override
    public void StartCounter(String[] args) throws IOException {
        charCounter.Run(args);
        wordCounter.Run(args);
        lineCounter.Run(args);
        System.out.println();
    }

    @Override
    public void Verbose(int count) {
        charCounter.Verbose(count);
        wordCounter.Verbose(count);
        lineCounter.Verbose(count);
    }

    @Override
    public void GeneralUsageInformation() {
        System.out.println("WC <src>\t" + "Passed with one file source as an argument and no options. Displays information about the file.");
        System.out.println("General Usage Examples:");
        System.out.println("\tjava WC file1.txt");
        System.out.println();
    }

    @Override
    public void HelpOptionInformation() {
        System.out.println("-h, -?, -help\t" + "Passed with no arguments and displays helpful information.");
        System.out.println("Help Option Examples:");
        System.out.println("\tjava WC -h" + "\tor,");
        System.out.println("\tjava WC -help" + "\tor,");
        System.out.println("\tjava WC -?");
        System.out.println();
    }

    @Override
    public void BannerOptionInformation() {
        System.out.println("-b, -banner\t" + "Passed with no arguments and displays version and copyright information.");
        System.out.println("Banner Option Examples:");
        System.out.println("\tjava WC -b" + "\tor,");
        System.out.println("\tjava WC -banner");
        System.out.println();
    }

    @Override
    public void VerboseOptionInformation() {
        System.out.println("-v, -verbose\t" + "Passed with one file source as an argument and displays the most detailed information about the file.");
        System.out.println("Verbose Option Examples:");
        System.out.println("\tjava WC -v file1.txt" + "\tor,");
        System.out.println("\tjava WC -verbose file2.txt");
        System.out.println();
    }

    @Override
    public void BannerMessage() {
        System.out.println("WC Version 2.0.0.0");
        System.out.println("Copyright (C) Karim Rhoualem 2020. All Rights Reserved.");
        System.out.println("Written by Karim Rhoualem.");
        System.out.println();
    }
}