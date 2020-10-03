package factory;

import java.io.IOException;

public interface IConfigureCounter {
    public void Run(String[] args);
    public void StartCounter(String[] args) throws IOException;
    public void Verbose(int count);
}