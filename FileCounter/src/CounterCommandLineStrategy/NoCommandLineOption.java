package CounterCommandLineStrategy;

public class NoCommandLineOption implements ICommandLineOptionStrategy {
    @Override
    public boolean CheckOption(String[] args) {
        return (args.length == 1 && !(args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help")) &&
                !(args.length == 1 && (args[0].equals("-b") || args[0].equals("-banner"))) && args[0] != null) ? true : false;
    }
}
