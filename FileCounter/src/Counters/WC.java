package Counters;

import CounterFactory.CounterFactory;
import CounterFactory.ICounter;

public class WC {
    public static void main(String[] args) {
        CounterFactory counterFactory = new CounterFactory();

        ICounter WC = counterFactory.getCounter("WC");
        WC.Count(args);
    }
}
