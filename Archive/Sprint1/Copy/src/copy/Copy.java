package copy;// copy.Copy.java - copy.Copy sourceFile to destinationFile
import java.io.*;

public class Copy {
    private static int EOF = -1;
    private static File srcFile = null;
    private static File dstFile = null;
    private static String srcFilename = "<srcFilename>";
    private static String dstFilename = "<dstFilename>";

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            if (args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help")) {
                System.out.println("Usage: copy <src> <dst>");
                System.out.println("Examples:");
                System.out.println("\tCopy file1.txt file2.txt");
                System.out.println("\tCopy program1.java program2.java");
            }
            else {
                System.out.println("Invalid arguments provided.");
                System.out.println("Use -?, -h, or -help for help.");
                System.out.println("Usage: Copy <src> <dst>");
            }
            return;
        }

        // Check the number of arguments.
        // In Java, the command name 'copy' is considered as an argument.
        if (args.length != 2) {
            System.out.println("Usage: Copy <src> <dst>" );
            return;
        }

        // Check if arguments are valid, if the srcFile exists, and if can create the dstFile.
        if (args[0] != null) { // Check <src>
            srcFilename = args[0];
            System.out.println("Copy: srcFilename = '" + srcFilename + "'");
            srcFile = new File(srcFilename);
            if (!srcFile.canRead()) {
                System.out.println("Copy: Cannot open srcFile '" + srcFilename + "'");
                return;
            }
        } 
		else {
            System.out.println("Copy: [OK] srcFilename = '" + srcFilename + "'");
        }

        if (args[1] != null) { // Check <dst>
            dstFilename = args[1];
            dstFile = new File(dstFilename);
        } 
		else {
            System.out.println("Copy: [OK] dstFilename = '" + dstFilename + "'");
        }

        FileInputStream srcStream = new FileInputStream(srcFile);
        FileOutputStream dstStream = new FileOutputStream(dstFile);

        // Execute the copy.
        int c;

        while ( (c = srcStream.read()) != EOF ) {
            dstStream.write(c);
            System.out.print('.');
        }

        // Close and flush all the files.
        srcStream.close();
        dstStream.close();

        System.out.println("Copy: done.");
    }
}
