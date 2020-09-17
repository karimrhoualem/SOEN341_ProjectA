import java.io.*;

public class WC {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: CharCount <src>\n");
            return;
        }

        if (args[0] != null) {
            try {
                CharCount(args[0]);
                WordCount(args[0]);
                LineCount(args[0]);
            }
            catch (Exception e) {

            }
        }
    }

    public static void CharCount(String args) {
        String srcFileName = null;
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;

        if (args != null) {
            try {
                int count = 0;

                srcFileName = args;
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

    private static boolean isSpace(int c) {
        return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
    }

    public static void WordCount(String args) {
        String srcFileName = null;
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;

        if (args != null) {
            try {
                srcFileName = args;
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

    public static void LineCount(String args) {
        String srcFileName = null;
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;

        if (args != null) {
            try {
                int count = 0;

                srcFileName = args;
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
