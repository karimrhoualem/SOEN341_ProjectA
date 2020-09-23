import java.io.*;

public class LineCount {
    public static void CountLines(String[] args) {
        String srcFileName = null;
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;

        if (args[0] != null) {
            try {
                int count = 0;

                srcFileName = args[0];
                fileInputStream = new FileInputStream((srcFileName));
                reader = new BufferedReader(new InputStreamReader(fileInputStream));

                String line = reader.readLine();
                while (line != null) {
                    count++;
                    line = reader.readLine();
                }

                System.out.println("Total line count is: " + count + ".");
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
}
