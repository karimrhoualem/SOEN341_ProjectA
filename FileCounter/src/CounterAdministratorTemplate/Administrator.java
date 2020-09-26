package CounterAdministratorTemplate;

public abstract class Administrator {
    public abstract void GeneralUsageInformation();
    public abstract void HelpOptionInformation();
    public abstract void BannerOptionInformation();
    public abstract void VerboseOptionInformation();
    public abstract void BannerMessage();
    public abstract void CatchAllErrorMessage();

    // Template Method
    public final void UsageMessage() {
        System.out.println();
        GeneralUsageInformation();
        HelpOptionInformation();
        BannerOptionInformation();
        VerboseOptionInformation();
    }
}
