package CounterFactory;

import java.io.IOException;

public interface ICounter {
    public void Count(String[] args);
    public void Verbose(int count);
    public void RunCounter(String[] args) throws IOException;
}
