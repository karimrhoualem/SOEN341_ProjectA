package programs;

import factory.Factory;
import factory.IConfigureCounter;

public class WordCount {
    public static void main(String[] args) {
        Factory factory = new Factory();

        IConfigureCounter wordCounter = factory.getFactoryType("WORDCOUNT");
        wordCounter.Run(args);
    }
}
