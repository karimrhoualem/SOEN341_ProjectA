import java.io.IOException;

public class WC {
    public static void main(String[] args) throws IOException {
        if (Administrator.CheckArgsConditions.isHelpOption(args)) {
            Administrator.Messages.HelpMessage();
            return;
        }

        if (Administrator.CheckArgsConditions.isIncorrectArgLength(args)) {
            Administrator.Messages.InvalidNumberOfArgs();
            Administrator.Messages.UsageMessage();
            return;
        }

        if (Administrator.CheckArgsConditions.isArgNotNull(args)) {
            Administrator.Messages.PrintInformation(args);
        }
    }
}