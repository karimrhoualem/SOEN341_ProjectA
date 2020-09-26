package factory;

public class Factory {
    public IRunFactory getFactoryType(String counterType){
        if(counterType == null){
            return null;
        }

        if(counterType.equalsIgnoreCase("CHARCOUNT")){
            return new CountChars();
        }
        else if(counterType.equalsIgnoreCase("WORDCOUNT")){
            return new CountWords();
        }
        else if(counterType.equalsIgnoreCase("LINECOUNT")){
            return new CountLines();
        }
        else if(counterType.equalsIgnoreCase("WC")){
            return new WC();
        }
        else if(counterType.equalsIgnoreCase("COPY")){
            return new CopyFile();
        }

        return null;
    }
}
