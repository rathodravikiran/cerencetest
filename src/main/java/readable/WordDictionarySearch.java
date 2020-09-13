package readable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordDictionarySearch {

    private List<String> wordList = new ArrayList<>();
    private List<String> wordsWith6LetterList = new ArrayList<>();
    private final int LETTER_COUNT = 6;

    public void readDictionary() {

        InputStream inputStream = WordDictionarySearch.class.getClassLoader().getResourceAsStream("wordlist" + ".txt");

        if (null != inputStream) {
            try {
                BufferedReader readFile = new BufferedReader(new InputStreamReader(inputStream));
                String word;

                while ((word = readFile.readLine()) != null) {
                    if (word.length() > 0)
                        wordList.add(word);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (wordList.size() > 0)
                searchWord(); //Get six letter words from List and find shorter words

            printWordCount();
        }
    }

    //Get six letter words from ArrayList
    private void searchWord() {
        for (String currentWord : wordList) {
            if (currentWord.length() == LETTER_COUNT) {
                findShorterWords(currentWord);
            }
        }
    }

    //Find concatenated shorter words
    private void findShorterWords(String currentWord) {
        String prefix;
        String suffix;

        for (int i = 0; i < currentWord.length() - 1; i++) {
            prefix = currentWord.substring(0, i + 1);
            suffix = currentWord.substring(i + 1);
            if (wordList.contains(prefix) && wordList.contains(suffix)) {
                String finalWord = "(" + "'" + currentWord + "'" + "," + "'" + prefix + "'" + "," + "'" + suffix + "'" + ")";
                wordsWith6LetterList.add(finalWord);
                break;
            }
        }
    }

    //Print total word count and ten example words
    private void printWordCount() {
        System.out.println("Total count of six letter words which have shorter words in the dictionary => " +
                wordsWith6LetterList.size());
        System.out.println("Ten example words are given below :");
        for (int i = 0; i < 10; i++) {
            System.out.println(wordsWith6LetterList.get(i));
        }
        System.out.println();
    }
}
