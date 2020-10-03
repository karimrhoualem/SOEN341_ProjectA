package factory;

import java.io.IOException;

public class WC implements IConfigureCounter {
    Factory factory = new Factory();
    IConfigureCounter charCounter = factory.getFactoryType("CHARCOUNT");
    IConfigureCounter wordCounter = factory.getFactoryType("WORDCOUNT");
    IConfigureCounter lineCounter = factory.getFactoryType("LINECOUNT");

    @Override
    public void Run(String[] args) {
        charCounter.Run(args);
        System.out.println("----------------------------------------------------------------------------------------");
        wordCounter.Run(args);
        System.out.println("----------------------------------------------------------------------------------------");
        lineCounter.Run(args);
    }

    @Override
    public void StartCounter(String[] args) throws IOException {

    }

    @Override
    public void Verbose(int count) {

    }
}
