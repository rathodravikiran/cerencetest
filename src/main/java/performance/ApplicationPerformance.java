package performance;

public class ApplicationPerformance {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        WordDictionarySearch wordDictionarySearch = new WordDictionarySearch();

        wordDictionarySearch.readDictionary();

        System.out.println("Total execution time in milliSeconds => " + (System.currentTimeMillis() - startTime));
    }
}
