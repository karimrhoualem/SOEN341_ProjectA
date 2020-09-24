import java.io.*;

public class WC {
    public static void main(String[] args) {
        if (args.length == 1 && (args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help"))) {
            PrintHelpMessage();
            return;
        }

        if (args.length != 1) {
            System.out.println("Error: Incorrect number of arguments provided at command line.\n");
            PrintHelpMessage();
            return;
        }

        if (args[0] != null) {
            CharCount(args[0]);
            WordCount(args[0]);
            LineCount(args[0]);
        }
    }

    public static void PrintHelpMessage() {
        System.out.println("Usage:");
        System.out.println("\tjava WC <src>\n");
        System.out.println("Help Options:");
        System.out.println("\tjava WC -h" + "\tor,");
        System.out.println("\tjava WC -?" + "\tor,");
        System.out.println("\tjava WC -help\n");
        System.out.println("Examples:");
        System.out.println("\tjava WC file1.txt");
        System.out.println("\tjava WC program1.java\n");
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

                while (reader.read() != -1) {
                    count++;
                }

                System.out.println("Total characters read: " + count + ".");
            }
            catch (FileNotFoundException fnfe) {
                System.out.println(fnfe.getMessage());
                PrintHelpMessage();
            }
            catch (IOException ioe) {
                System.out.println(ioe.getMessage());
                PrintHelpMessage();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                PrintHelpMessage();
            }
            finally {
                try {
                    reader.close();
                    fileInputStream.close();
                }
                catch (NullPointerException | IOException npe) {
                    if (npe.getMessage() != null) {
                        System.out.println(npe.getMessage());
                    }
                    System.exit(0);
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
                System.out.println(fnfe.getMessage());
                PrintHelpMessage();
            }
            catch (IOException ioe) {
                System.out.println(ioe.getMessage());
                PrintHelpMessage();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                PrintHelpMessage();
            }
            finally {
                try {
                    reader.close();
                    fileInputStream.close();
                }
                catch (NullPointerException | IOException npe) {
                    if (npe.getMessage() != null) {
                        System.out.println(npe.getMessage());
                    }
                    System.exit(0);
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

                String line = reader.readLine();
                while (line != null) {
                    count++;
                    line = reader.readLine();
                }

                System.out.println("Total line count is: " + count + ".");
            }
            catch (FileNotFoundException fnfe) {
                System.out.println(fnfe.getMessage());
                PrintHelpMessage();
            }
            catch (IOException ioe) {
                System.out.println(ioe.getMessage());
                PrintHelpMessage();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                PrintHelpMessage();
            }
            finally {
                try {
                    reader.close();
                    fileInputStream.close();
                }
                catch (NullPointerException | IOException npe) {
                    if (npe.getMessage() != null) {
                        System.out.println(npe.getMessage());
                    }
                    System.exit(0);
                }
            }
        }
    }
}
