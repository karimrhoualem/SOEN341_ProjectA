package CounterCommandLineStrategy;

public class BannerCommandLineOption implements ICommandLineOptionStrategy {

    @Override
    public boolean CheckOption(String[] args) {
        return (args.length == 1 && (args[0].equals("-b") || args[0].equals("-banner"))) ? true : false;

    }
}
