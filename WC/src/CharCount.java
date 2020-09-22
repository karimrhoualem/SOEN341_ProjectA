import java.io.*;

public class CharCount {
    public static void CountCharacters(String[] args) {
        String srcFileName = null;
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;

        if (args[0] != null) {
            try {
                int count = 0;

                srcFileName = args[0];
                fileInputStream = new FileInputStream((srcFileName));
                reader = new BufferedReader(new InputStreamReader(fileInputStream));

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

