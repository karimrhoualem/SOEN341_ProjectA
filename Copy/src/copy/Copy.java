package copy;// copy.Copy.java - copy.Copy sourceFile to destinationFile
import java.io.*;

public class Copy {
    private static int EOF = -1;
    private static File srcFile = null;
    private static File dstFile = null;
    private static String srcFilename = "<srcFilename>";
    private static String dstFilename = "<dstFilename>";

    public static void main(String[] args) throws IOException {
        // Check the number of arguments.
        // In Java, the command name 'copy' is considered as an argument.
        if ( args.length != 2 ) {
            System.out.println("Usage: copy <src> <dst>" );
            return;
        }

        // Check if arguments are valid, if the srcFile exists, and if can create the dstFile.
        if (args[0] != null) { // Check <src>
            srcFilename = args[0];
            System.out.println("copy: srcFilename = '" + srcFilename + "'");
            srcFile = new File(srcFilename);
            if (!srcFile.canRead()) {
                System.out.println("copy: Cannot open srcFile '" + srcFilename + "'");
                return;
            }
        } 
		else {
            System.out.println("copy: [OK] srcFilename = '" + srcFilename + "'");
        }

        if (args[1] != null) { // Check <dst>
            dstFilename = args[1];
            dstFile = new File(dstFilename);
        } 
		else {
            System.out.println("copy: [OK] dstFilename = '" + dstFilename + "'");
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

        System.out.println("copy: done.");
    }
}
