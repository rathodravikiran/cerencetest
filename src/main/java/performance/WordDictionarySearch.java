package performance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WordDictionarySearch {

    private Set<String> wordSet = new HashSet<>();
    private Map<String, List<String>> wordsWith6LetterMap = new ConcurrentHashMap<>();
    private final int LETTER_COUNT = 6;

    public void readDictionary() {

        InputStream inputStream = WordDictionarySearch.class.getClassLoader().getResourceAsStream("wordlist" + ".txt");

        if (null != inputStream) {
            try {
                BufferedReader readFile = new BufferedReader(new InputStreamReader(inputStream));
                String word;

                while ((word = readFile.readLine()) != null) {
                    if (word.length() > 0) {
                        wordSet.add(word);
                        if (word.length() == LETTER_COUNT)
                            wordsWith6LetterMap.put(word, new ArrayList<>());
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

            if (wordsWith6LetterMap.size() > 0)
                searchWord();

            printWordCount();
        }
    }

    //Get all the six letter words from ConcurrentMap
    private void searchWord() {
        for (String currentWord : wordsWith6LetterMap.keySet()) {
            if (!findShorterWords(currentWord))
                wordsWith6LetterMap.remove(currentWord);
        }
    }

    //Find concatenated shorter words
    private boolean findShorterWords(String currentWord) {

        boolean wordFound = false;

        for (int i = 0; i < currentWord.length() - 1; i++) {

            if (wordSet.contains(currentWord.substring(0, i + 1)) && wordSet.contains(currentWord.substring(i + 1))) {
                wordsWith6LetterMap.get(currentWord).add(currentWord.substring(0, i + 1));
                wordsWith6LetterMap.get(currentWord).add(currentWord.substring(i + 1));
                wordFound = true;
                break;

            }
        }

        return wordFound;
    }

    //Print total word count and ten example words
    private void printWordCount() {
        System.out.println("Total count of six letter words which have shorter words in the dictionary => " +
                wordsWith6LetterMap.size());
        System.out.println("Ten example words are given below :");
        int count = 0;
        for (String key : wordsWith6LetterMap.keySet()) {
            System.out.println(key + " " + wordsWith6LetterMap.get(key));
            count++;
            if (count == 10) break;
        }
        System.out.println();
    }
}
