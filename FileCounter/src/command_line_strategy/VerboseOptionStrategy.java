package command_line_strategy;

public class VerboseOptionStrategy implements IOptionStrategy {

    @Override
    public boolean CheckOption(String[] args) {
        return (args.length == 2 && (args[0].equals("-v") || args[0].equals("-verbose"))) ? true : false;
    }

    @Override
    public boolean CheckCopyOption(String[] args) {
        return false;
    }
}
