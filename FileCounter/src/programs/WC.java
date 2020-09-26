package programs;

import factory.Factory;
import factory.IRunFactory;

public class WC {
    public static void main(String[] args) {
        Factory factory = new Factory();

        IRunFactory WC = factory.getFactoryType("WC");
        WC.CheckConditions(args);
    }
}
