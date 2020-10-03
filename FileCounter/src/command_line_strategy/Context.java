package command_line_strategy;

public class Context {
    private IOptionStrategy strategy;

    public Context(IOptionStrategy strategy){
        this.strategy = strategy;
    }

    public boolean executeStrategy(String[] args){
        return strategy.CheckOption(args);
    }

    public boolean executeCopyStrategy(String[] args) {
        return strategy.CheckCopyOption(args);
    }
}
