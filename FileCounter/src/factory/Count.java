package factory;

import administrator_template.Administrator;
import command_line_strategy.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Count extends Administrator implements IConfigureCounter {
    protected int _count;

    Context helpOption = new Context(new HelpOptionStrategy());
    Context bannerOption = new Context(new BannerOptionStrategy());
    Context verboseOption = new Context(new VerboseOptionStrategy());
    Context noOption = new Context(new NoOptionStrategy());

    String srcFileName = null;
    FileInputStream fileInputStream = null;
    BufferedReader reader = null;

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

            if (verboseOption.executeStrategy(args)) {
                StartCounter(args);
                return;
            }
            else if (noOption.executeStrategy(args)) {
                StartCounter(args);
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

    public void CatchAllErrorMessage() {
        System.out.println();
        System.out.println("Unforeseen error occurred.");
        UsageMessage();
        System.out.println();
    }
}
