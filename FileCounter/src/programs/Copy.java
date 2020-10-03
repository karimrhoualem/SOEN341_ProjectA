package programs;// copy.Copy.java - copy.Copy sourceFile to destinationFile
import factory.Factory;
import factory.IConfigureCounter;

import java.io.*;

public class Copy {
    public static void main(String[] args) throws IOException {
        Factory factory = new Factory();

        IConfigureCounter copy = factory.getFactoryType("COPY");
        copy.Run(args);
    }
}
