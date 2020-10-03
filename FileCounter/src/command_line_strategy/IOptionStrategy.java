package command_line_strategy;

public interface IOptionStrategy {
    public boolean CheckOption(String[] args);
    public boolean CheckCopyOption(String[] args);
}