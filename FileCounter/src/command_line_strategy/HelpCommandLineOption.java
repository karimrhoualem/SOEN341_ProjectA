package command_line_strategy;

public class HelpCommandLineOption implements ICommandLineOptionStrategy {

    @Override
    public boolean CheckOption(String[] args) {
        return (args.length == 1 && (args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help"))) ? true : false;
    }
}
