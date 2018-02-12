package us.mattgreen;

import java.util.*;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String line;
        String[] words;
        Object wordFound;
        //   String[] fields;
        int topPlace = 0;
        String word = "";

        while ((line = indata.fileReadLine()) != null) {
            line = line.replace(",", "").replace(".", "")
                    .replace(";", "").replace(":", "")
                    .replace("'", "").replace("\"", "")
                    .replace("-", "").replace("!", "")
                    .replace("#", "").replace("(", "")
                    .replace(")", "").replace("?", "")
                    .replace("_", "").replace("?", "")
                    .toLowerCase().trim();
            words = line.split(" ");
            for (String s : words) {
                wordFound = map.get(s);
                if (wordFound == null) {
                    map.put(s, new Integer(1));
                } else {
                    map.put(s, map.get(s) + 1);
                }

            }

        }
            int count = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > topPlace) {
                    topPlace = entry.getValue();
                    word = entry.getKey();
                }
                if (entry.getValue() == 1) {
                    count++;

                }
            }

            System.out.println("Word: " + word + " " + "\nNumber of times used: " + topPlace);
            System.out.println(count);

        }

    }
