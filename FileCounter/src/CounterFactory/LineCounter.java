package CounterFactory;

import CounterAdministratorTemplate.Administrator;
import CounterCommandLineStrategy.BannerCommandLineOption;
import CounterCommandLineStrategy.HelpCommandLineOption;
import CounterCommandLineStrategy.NoCommandLineOption;
import CounterCommandLineStrategy.VerboseCommandLineOption;

import java.io.*;

public class LineCounter extends Administrator implements ICounter {
    private int _count;

    HelpCommandLineOption helpCommandLineOption = new HelpCommandLineOption();
    BannerCommandLineOption bannerCommandLineOption = new BannerCommandLineOption();
    VerboseCommandLineOption verboseCommandLineOption = new VerboseCommandLineOption();
    NoCommandLineOption noCommandLineOption = new NoCommandLineOption();

    String srcFileName = null;
    FileInputStream fileInputStream = null;
    BufferedReader reader = null;

    public void Count(String[] args) {
        try {
            if (helpCommandLineOption.CheckOption(args)) {
                UsageMessage();
                return;
            }
            else if (bannerCommandLineOption.CheckOption(args)) {
                BannerMessage();
                return;
            }

            if (verboseCommandLineOption.CheckOption(args)) {
                RunCounter(args);
                return;
            }
            else if (noCommandLineOption.CheckOption(args)) {
                RunCounter(args);
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
    public void RunCounter(String[] args) throws IOException {
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
        System.out.println("LineCounter Version 2.0.0.0");
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