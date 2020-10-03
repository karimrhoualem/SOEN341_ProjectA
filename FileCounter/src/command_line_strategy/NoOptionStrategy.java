package command_line_strategy;

public class NoOptionStrategy implements IOptionStrategy {
    @Override
    public boolean CheckOption(String[] args) {
        return (args.length == 1 && !(args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help")) &&
                !(args.length == 1 && (args[0].equals("-b") || args[0].equals("-banner"))) && args[0] != null) ? true : false;
    }

    public boolean CheckCopyOption(String[] args) {
        return (args.length == 2 && !(args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help") ||
                args[1].equals("-?") || args[1].equals("-h") || args[1].equals("-help")) &&
                !(args[0].equals("-b") || args[0].equals("-banner") || args[1].equals("-b") || args[1].equals("-banner")) &&
                args[0] != null && args[1] != null) ? true : false;
    }
}
