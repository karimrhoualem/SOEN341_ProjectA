package factory;

import administrator_template.Administrator;
import command_line_strategy.*;

import java.io.*;

public class CopyFile extends Administrator implements IConfigureCounter {
    int EOF = -1;
    File srcFile = null;
    File dstFile = null;
    String srcFilename = "<srcFilename>";
    String dstFilename = "<dstFilename>";
    FileInputStream srcStream = null;
    FileOutputStream dstStream = null;

    Context helpOption = new Context(new HelpOptionStrategy());
    Context bannerOption = new Context(new BannerOptionStrategy());
    Context noOption = new Context(new NoOptionStrategy());

    @Override
    public void Run(String[] args) {
        try {
            // Verify whether help or banner option has been specified from the command line.
            if (helpOption.executeStrategy(args)) {
                UsageMessage();
                return;
            }
            else if (bannerOption.executeStrategy(args)) {
                BannerMessage();
                return;
            }

            if (noOption.executeCopyStrategy(args)) {
                StartCounter(args);
                return;
            }

            CatchAllErrorMessage();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
            UsageMessage();
            System.exit(0);
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            UsageMessage();
            System.exit(0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            UsageMessage();
            System.exit(0);
        }
        finally {
            try {
                srcStream.close();
                dstStream.close();
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
    public void StartCounter(String[] args) throws IOException {
        if (args[0] != null) { // Check <src>
            srcFilename = args[0];

            srcFile = new File(srcFilename);

            if (!srcFile.canRead()) {
                System.out.println("Copy: Cannot open srcFile '" + srcFilename + "'");
                return;
            }
        }

        if (args[1] != null) { // Check <dst>
            dstFilename = args[1];
            dstFile = new File(dstFilename);
        }

        srcStream = new FileInputStream(srcFile);
        dstStream = new FileOutputStream(dstFile);

        // Execute the copy.
        System.out.println("Copying " + srcFilename + " to " + dstFilename + ".");

        int c;

        while ( (c = srcStream.read()) != EOF ) {
            dstStream.write(c);
            System.out.print('.');
        }

        System.out.println();
        System.out.println("Copy: done.");
    }

    @Override
    public void Verbose(int count) {
    }

    @Override
    public void GeneralUsageInformation() {
        System.out.println("Copy <src> <dest>\t" + "Passed with two files, a source and an argument and no options. Copies the contents of the source file into the destination file..");
        System.out.println("General Usage Examples:");
        System.out.println("\tjava Copy file1.txt file2.txt");
        System.out.println();
    }

    @Override
    public void HelpOptionInformation() {
        System.out.println("-h, -?, -help\t" + "Passed with no arguments and displays helpful information.");
        System.out.println("Help Option Examples:");
        System.out.println("\tjava Copy -h" + "\tor,");
        System.out.println("\tjava Copy -help" + "\tor,");
        System.out.println("\tjava Copy -?");
        System.out.println();
    }

    @Override
    public void BannerOptionInformation() {
        System.out.println("-b, -banner\t" + "Passed with no arguments and displays version and copyright information.");
        System.out.println("Banner Option Examples:");
        System.out.println("\tjava Copy -b" + "\tor,");
        System.out.println("\tjava Copy -banner");
        System.out.println();
    }

    @Override
    public void VerboseOptionInformation() {
    }

    @Override
    public void BannerMessage() {
        System.out.println("Copy Version 2.0.0.0");
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
