package wordcount;

import java.io.*;

public class WordCount {

    private static boolean isSpace(int c) {
        return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
    }

    public static void main(String[] args) {
        if (args.length == 1 && (args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help"))) {
            System.out.println("Usage: wordcount.WordCount <src>");
            System.out.println("Examples:");
            System.out.println("\twordcount.WordCount file1.txt");
            System.out.println("\twordcount.WordCount program1.java");
            return;
        }

        if (args.length != 1) {
            System.out.println("Usage: wordcount.WordCount <src>\n");
            return;
        }

        String srcFileName = null;
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;

        if (args[0] != null) {
            try {
                srcFileName = args[0];
                fileInputStream = new FileInputStream((srcFileName));
                reader = new BufferedReader(new InputStreamReader(fileInputStream));

                System.out.println("Reading words in " + srcFileName + ".");

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
