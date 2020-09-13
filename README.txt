Project : Cerence coding assignment
        Read wordlist.txt file and search for all the six letter words which are composed of two concatenated smaller words

Approach -1 : Readable -- src\main\java\readable
    1) Read wordlist.text file : src\main\resources\wordlist.txt
    2) Load all the words into ArrayList
    3) Search six letter words in ArrayList
    4) Iterate over six letter word and check if prefix and suffix present in the list
          e.g. six letter word - admire
               Prefix       Suffix
               ------       ------
                a           dmire
                ad          mire
                adm         ire
                admi        re
                admir       e

    5) If present - Add six letter word + prefix + suffix in new ArrayList
    6) Print size of ArrayList as total six letter words having shorter word in the dictionary
    7) Print sample ten words


Approach -2 : Performance improvement --  src\main\java\performance
    1) Read wordlist.text file : src\main\resources\wordlist.txt
    2) Load all the words in HashSet
    3) Load six letter words in ConcurrentHashMap<String, List<String>>
    4) Get six letter word from ConcurrentHashMap
    5) Iterate over six letter word and check if prefix and suffix present in the HashSet
    6) If present - Update the ArrayList in ConcurrentHashMap with prefix and suffix
    7) If not present - Remove the six letter word from ConcurrentHashMap
    8) Print size of ConcurrentHashMap as total six letter words having shorter word in the dictionary
    9) Print sample ten words


Sample output of Approach -1: readable\ApplicationReadable.java application
---------------------------------------------------------------------------------
Total count of six letter words which have shorter words in the dictionary => 693
Ten example words are given below :
('action','act','ion')
('adages','ad','ages')
('addend','add','end')
('adding','ad','ding')
('adduct','ad','duct')
('adhere','ad','here')
('adjoin','ad','join')
('adjure','ad','jure')
('adjust','ad','just')
('admire','ad','mire')

Total execution time milliSeconds => 12974

Sample output of Approach -2 : performance\ApplicationPerformance.java application
----------------------------------------------------------------------------------
Total count of six letter words which have shorter words in the dictionary => 693
Ten example words are given below :
upload [up, load]
sunset [sun, set]
regain [re, gain]
inmate [in, mate]
embody [em, body]
ascent [as, cent]
adrift [ad, rift]
bemoan [be, moan]
madmen [mad, men]
reform [re, form]

Total execution time in milliSeconds => 246