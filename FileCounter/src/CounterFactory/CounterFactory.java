package CounterFactory;

public class CounterFactory {
    public ICounter getCounter(String counterType){
        if(counterType == null){
            return null;
        }

        if(counterType.equalsIgnoreCase("CHARCOUNTER")){
            return new CharCounter();
        }
        else if(counterType.equalsIgnoreCase("WORDCOUNTER")){
            return new WordCounter();
        }
        else if(counterType.equalsIgnoreCase("LINECOUNTER")){
            return new LineCounter();
        }
        else if(counterType.equalsIgnoreCase("WC")){
            return new WC();
        }

        return null;
    }
}
