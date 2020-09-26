package Counters;

import CounterFactory.CounterFactory;
import CounterFactory.ICounter;

public class WordCount {
    public static void main(String[] args) {
        CounterFactory counterFactory = new CounterFactory();

        ICounter wordCounter = counterFactory.getCounter("WORDCOUNTER");
        wordCounter.Count(args);
    }
}
