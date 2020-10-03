package programs;

import factory.Factory;
import factory.IConfigureCounter;

public class WC {
    public static void main(String[] args) {
        Factory factory = new Factory();

        IConfigureCounter WC = factory.getFactoryType("WC");
        WC.Run(args);
    }
}
