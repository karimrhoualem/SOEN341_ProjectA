package factory;

import java.io.IOException;

public interface IRunFactory {
    public void CheckConditions(String[] args);
    public void Run(String[] args) throws IOException;
    public void Verbose(int count);
}
