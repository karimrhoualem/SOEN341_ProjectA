package programs;

import factory.Factory;
import factory.IConfigureCounter;

public class LineCount {
    public static void main(String[] args) {
        Factory factory = new Factory();

        IConfigureCounter lineCounter = factory.getFactoryType("LINECOUNT");
        lineCounter.Run(args);
    }
}
