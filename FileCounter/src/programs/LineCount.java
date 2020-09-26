package programs;

import factory.Factory;
import factory.IRunFactory;

public class LineCount {
    public static void main(String[] args) {
        Factory factory = new Factory();

        IRunFactory lineCounter = factory.getFactoryType("LINECOUNT");
        lineCounter.CheckConditions(args);
    }
}
