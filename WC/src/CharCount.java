import java.io.*;

public class CharCount {
    public static void CountCharacters(String[] args) {
        String srcFileName = null;
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;

        try {
            if (args[0] != null) {
                int count = 0;

                srcFileName = args[0];
                fileInputStream = new FileInputStream((srcFileName));
                reader = new BufferedReader(new InputStreamReader(fileInputStream));

                while (reader.read() != -1) {
                    count++;
                }

                System.out.println("Total characters read: " + count + ".");
            }
        }
        catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
            Administrator.Messages.HelpMessage();
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            Administrator.Messages.HelpMessage();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            Administrator.Messages.HelpMessage();
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
                System.exit(0);
            }
            catch (IOException ioe) {
                if (ioe.getMessage() != null) {
                    System.out.println(ioe.getMessage());
                }
                System.exit(0);
            }
            catch(Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
                System.exit(0);
            }
        }
    }
}

