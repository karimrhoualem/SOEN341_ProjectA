public class Administrator {

    public static class CheckArgsConditions {
        public static boolean isHelpOption(String[] args) {
            return (args.length == 1 && (args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help"))) ? true : false;
        }

        public static boolean isIncorrectArgLength(String[] args) {
            return (args.length != 1) ? true : false;
        }

        public static boolean isArgNotNull(String[] args) {
            return (args[0] != null) ? true : false;
        }
    }

    public static class Messages {
        public static void InvalidNumberOfArgs() {
            System.out.println("Error: Incorrect number of arguments provided at command line.\n");
        }

        public static void HelpMessage() {
            UsageMessage();
            HelpMessageExamples();
        }

        private static void HelpMessageExamples() {
            System.out.println("Examples:");
            System.out.println("\tjava WC file1.txt");
            System.out.println("\tjava WC program1.java\n");
        }

        public static void UsageMessage() {
            System.out.println("Usage:");
            System.out.println("\tjava WC <src>\n");
            System.out.println("Help Options:");
            System.out.println("\tjava WC -h" + "\tor,");
            System.out.println("\tjava WC -?" + "\tor,");
            System.out.println("\tjava WC -help");
        }

        public static void PrintInformation(String[] args) {
            CharCount.CountCharacters(args);
            WordCount.CountWords(args);
            LineCount.CountLines(args);
        }
    }
}
