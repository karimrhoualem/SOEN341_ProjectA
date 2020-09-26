package programs;

import factory.Factory;
import factory.IRunFactory;

public class CharCount {
    public static void main(String[] args) {
        Factory factory = new Factory();

        IRunFactory charCounter = factory.getFactoryType("CHARCOUNT");
        charCounter.CheckConditions(args);
    }
}
