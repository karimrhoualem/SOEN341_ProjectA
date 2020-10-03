package command_line_strategy;

public class BannerOptionStrategy implements IOptionStrategy {

    @Override
    public boolean CheckOption(String[] args) {
        return (args.length == 1 && (args[0].equals("-b") || args[0].equals("-banner"))) ? true : false;
    }

    @Override
    public boolean CheckCopyOption(String[] args) {
        return (args.length == 1 && (args[0].equals("-b") || args[0].equals("-banner"))) ? true : false;
    }
}
