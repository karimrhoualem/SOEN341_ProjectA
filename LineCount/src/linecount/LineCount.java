package linecount;

import java.io.*;

public class LineCount {
    public static void main(String[] args) {
        if (args.length == 1 && (args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help"))) {
            System.out.println("Usage: charcount.CharCount <src>");
            System.out.println("Examples:");
            System.out.println("\tcharcount.CharCount file1.txt");
            System.out.println("\tcharcount.CharCount program1.java");
            return;
        }

        if (args.length != 1) {
            System.out.println("Usage: charcount.CharCount <src>\n");
            return;
        }

        String srcFileName = null;
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;

        if (args[0] != null) {
            try {
                int count = 0;

                srcFileName = args[0];
                fileInputStream = new FileInputStream((srcFileName));
                reader = new BufferedReader(new InputStreamReader(fileInputStream));

                System.out.println("Reading lines in " + srcFileName + ".");

                String line = reader.readLine();
                while (line != null) {
                    count++;
                    line = reader.readLine();
                }

                System.out.println("Total line count is: " + count + ".");
            }
            catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    reader.close();
                    fileInputStream.close();
                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}
