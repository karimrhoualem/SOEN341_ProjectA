package command_line_strategy;

public class HelpOptionStrategy implements IOptionStrategy {

    @Override
    public boolean CheckOption(String[] args) {
        return (args.length == 1 && (args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help"))) ? true : false;
    }

    @Override
    public boolean CheckCopyOption(String[] args) {
        return (args.length == 1 && (args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help"))) ? true : false;
    }
}
