package factory;

import administrator_template.Administrator;
import command_line_strategy.BannerCommandLineOption;
import command_line_strategy.HelpCommandLineOption;
import command_line_strategy.NoCommandLineOption;
import command_line_strategy.VerboseCommandLineOption;

import java.io.*;

public class CountWords extends Administrator implements IRunFactory {
    private int _nWords;

    HelpCommandLineOption helpCommandLineOption = new HelpCommandLineOption();
    BannerCommandLineOption bannerCommandLineOption = new BannerCommandLineOption();
    VerboseCommandLineOption verboseCommandLineOption = new VerboseCommandLineOption();
    NoCommandLineOption noCommandLineOption = new NoCommandLineOption();

    String srcFileName = null;
    FileInputStream fileInputStream = null;
    BufferedReader reader = null;

    private static boolean isSpace(int c) {
        return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
    }

    public void CheckConditions(String[] args) {
        try {
            // Verify whether help or banner option has been specified from the command line.
            if (helpCommandLineOption.CheckOption(args)) {
                UsageMessage();
                return;
            }
            else if (bannerCommandLineOption.CheckOption(args)) {
                BannerMessage();
                return;
            }

            if (verboseCommandLineOption.CheckOption(args)) {
                Run(args);
                return;
            }
            else if (noCommandLineOption.CheckOption(args)) {
                Run(args);
                return;
            }

            CatchAllErrorMessage();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
            UsageMessage();
            return;
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            UsageMessage();
            return;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            UsageMessage();
            return;
        }
        finally {
            try {
                reader.close();
                fileInputStream.close();
            }
            catch (NullPointerException npe) {
                if (npe.getMessage() != null) {
                    System.out.println(npe.getMessage());
                }
                return;
            }
            catch (IOException ioe) {
                if (ioe.getMessage() != null) {
                    System.out.println(ioe.getMessage());
                }
                return;
            }
            catch(Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    @Override
    public void Run(String[] args) throws IOException {
        if (args.length == 1) {
            srcFileName = args[0];
            fileInputStream = new FileInputStream((srcFileName));
            reader = new BufferedReader(new InputStreamReader(fileInputStream));

            int character;
            _nWords = 0;
            boolean inWord = false;

            while ((character = reader.read()) != -1) {
                if(!isSpace(character)) {
                    if (!inWord) {
                        inWord = true;
                        ++_nWords;
                    }
                } else {
                    inWord = false;
                }
            }

            System.out.println("Total words read: " + _nWords + ".");
        }
        else if (args.length == 2) {
            srcFileName = args[1];
            fileInputStream = new FileInputStream((srcFileName));
            reader = new BufferedReader(new InputStreamReader(fileInputStream));

            int character;
            _nWords = 0;
            boolean inWord = false;

            while ((character = reader.read()) != -1) {
                if(!isSpace(character)) {
                    if (!inWord) {
                        inWord = true;
                        ++_nWords;
                    }
                } else {
                    inWord = false;
                }
            }

            System.out.println("Total words read: " + _nWords + ".");
            Verbose(_nWords);
        }
    }

    @Override
    public void Verbose(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print('W');
        }
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

    @Override
    public void CatchAllErrorMessage() {
        System.out.println();
        System.out.println("Unforeseen error occurred.");
        UsageMessage();
        System.out.println();
    }
}