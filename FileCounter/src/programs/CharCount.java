package programs;

import factory.Factory;
import factory.IConfigureCounter;

public class CharCount {
    public static void main(String[] args) {
        Factory factory = new Factory();

        IConfigureCounter charCounter = factory.getFactoryType("CHARCOUNT");
        charCounter.Run(args);
    }
}