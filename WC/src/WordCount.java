import java.io.*;

public class WordCount {

    private static boolean isSpace(int c) {
        return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
    }

    public static void CountWords(String[] args) {
        String srcFileName = null;
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;

        if (args[0] != null) {
            try {
                srcFileName = args[0];
                fileInputStream = new FileInputStream((srcFileName));
                reader = new BufferedReader(new InputStreamReader(fileInputStream));

                int character;
                int nWords = 0;
                boolean inWord = false;

                while ((character = reader.read()) != -1) {
                    if(!isSpace(character)) {
                        if (!inWord) {
                            inWord = true;
                            ++nWords;
                        }
                    } else {
                        inWord = false;
                    }
                }

                System.out.println("Total words read: " + nWords + ".");
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
