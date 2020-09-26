package CounterFactory;

public class WC extends CharCounter {
    CharCounter charCounter = new CharCounter();
    WordCounter wordCounter = new WordCounter();
    LineCounter lineCounter = new LineCounter();

    public void Count(String[] args) {
        charCounter.Count(args);
        System.out.println("----------------------------------------------------------------------------------------");
        wordCounter.Count(args);
        System.out.println("----------------------------------------------------------------------------------------");
        lineCounter.Count(args);
    }
}
