package Counters;

import CounterFactory.CounterFactory;
import CounterFactory.ICounter;

public class CharCount {
    public static void main(String[] args) {
        CounterFactory counterFactory = new CounterFactory();

        ICounter charCounter = counterFactory.getCounter("CHARCOUNTER");
        charCounter.Count(args);
    }
}
