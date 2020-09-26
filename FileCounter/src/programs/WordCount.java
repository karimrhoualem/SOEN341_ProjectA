package programs;

import factory.Factory;
import factory.IRunFactory;

public class WordCount {
    public static void main(String[] args) {
        Factory factory = new Factory();

        IRunFactory wordCounter = factory.getFactoryType("WORDCOUNT");
        wordCounter.CheckConditions(args);
    }
}
