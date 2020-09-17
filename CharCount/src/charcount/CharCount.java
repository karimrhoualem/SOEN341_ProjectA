package charcount;

import java.io.*;

public class CharCount {
    public static void main(String[] args) {
        String srcFileName = null;
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;

        if (args.length != 1) {
            System.out.println("Usage: charcount.CharCount <src>\n");
            return;
        }

        if (args[0] != null) {
            try {
                int count = 0;

                srcFileName = args[0];
                fileInputStream = new FileInputStream((srcFileName));
                reader = new BufferedReader(new InputStreamReader(fileInputStream));

                System.out.println("Reading characters in " + srcFileName + ".");

                while (reader.read() != -1) {
                    count++;
                }

                System.out.println("Total characters read: " + count + ".");
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
