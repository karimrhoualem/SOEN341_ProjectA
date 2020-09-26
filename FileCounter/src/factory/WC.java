package factory;

public class WC extends CountChars {
    CountChars countChars = new CountChars();
    CountWords countWords = new CountWords();
    CountLines countLines = new CountLines();

    public void Count(String[] args) {
        countChars.CheckConditions(args);
        System.out.println("----------------------------------------------------------------------------------------");
        countWords.CheckConditions(args);
        System.out.println("----------------------------------------------------------------------------------------");
        countLines.CheckConditions(args);
    }
}
