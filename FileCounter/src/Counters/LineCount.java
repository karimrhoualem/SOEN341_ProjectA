package Counters;

import CounterFactory.CounterFactory;
import CounterFactory.ICounter;

public class LineCount {
    public static void main(String[] args) {
        CounterFactory counterFactory = new CounterFactory();

        ICounter lineCounter = counterFactory.getCounter("LINECOUNTER");
        lineCounter.Count(args);
    }
}
