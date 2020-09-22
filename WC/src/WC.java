public class WC {
    public static void main(String[] args) {
        if (args.length == 1 && (args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help"))) {
            System.out.println("Usage: WC <src>");
            System.out.println("Examples:");
            System.out.println("\tWC file1.txt");
            System.out.println("\tWC program1.java");
            return;
        }

        if (args.length != 1) {
            System.out.println("Usage: WC <src>\n");
            return;
        }

        if (args[0] != null) {
            CharCount.CountCharacters(args);
            WordCount.CountWords(args);
            LineCount.CountLines(args);
        }
    }
}