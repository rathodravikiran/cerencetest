package readable;

public class ApplicationReadable {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        WordDictionarySearch wordDictionarySearch = new WordDictionarySearch();

        wordDictionarySearch.readDictionary();

        System.out.println("Total execution time milliSeconds => " + (System.currentTimeMillis() - startTime));
    }
}
