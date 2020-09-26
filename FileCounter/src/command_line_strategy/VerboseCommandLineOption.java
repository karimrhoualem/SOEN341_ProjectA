package command_line_strategy;

public class VerboseCommandLineOption implements ICommandLineOptionStrategy {

    @Override
    public boolean CheckOption(String[] args) {
        return (args.length == 2 && (args[0].equals("-v") || args[0].equals("-verbose"))) ? true : false;
    }
}
