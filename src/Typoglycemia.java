import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Omar on 1/29/2016.
 *
 * [2015-11-09] Challenge #240 [Easy] Typoglycemia
 * https://www.reddit.com/r/dailyprogrammer/comments/3s4nyq/20151109_challenge_240_easy_typoglycemia/
 */
public class Typoglycemia {
    public static void main(String[] args) {
        List<String>text = fileReader("TypoglycemiaInput1.txt");

        System.out.println("---Original Text---");
        for(String word : text){
            System.out.print(word + " ");
        }
        System.out.println("");

        scramble(text);
    }

    public static void scramble(List<String> text){
        List<String>scrambledText = new ArrayList<>();

        for(int i = 0; i < text.size(); i++){
            String[] letters = text.get(i).split("");
            String newWord = "";

            if(letters.length > 1) {
                // Because a word may end with a period, comma, etc., this will get the true last letter
                // and make one final arrangement at the end of the main for loop.
                int lastLetterPosition = -1;
                if(!Character.isAlphabetic(letters[letters.length-1].charAt(0))){
                    lastLetterPosition = letters.length-2;
                    //System.out.println(letters[lastLetterPosition]);
                }


                String[] scrambledLetters = Arrays.copyOfRange(letters, 1, letters.length - 1);

                Random rnd = ThreadLocalRandom.current();
                for (int j = scrambledLetters.length - 1; j > 0; j--) {
                    int pos;
                    if(j == 2){
                        pos = rnd.nextInt(j);
                    }else {
                        pos = rnd.nextInt(j + 1);
                    }

                    // We have this here to handle words with apostrophes like won't or doesn't
                    if((Character.isAlphabetic(scrambledLetters[j].charAt(0)) && Character.isAlphabetic(scrambledLetters[pos].charAt(0)))
                    ||(lastLetterPosition != j) || lastLetterPosition != pos){
                        String letter = scrambledLetters[pos];
                        scrambledLetters[pos] = scrambledLetters[j];
                        scrambledLetters[j] = letter;

                        if(lastLetterPosition != -1){
                            //System.out.println(lastLetterPosition+ " "+j+" "+pos+ " || "+letter+ " || " +scrambledLetters);
                        }
                    }

                    //System.out.println(pos+"||"+letters.length);
                }

                for (int j = 0; j < letters.length; j++) {
                    if((j == 0) || (j == letters.length-1)){
                        newWord += letters[j];
                    }else{
                        newWord += scrambledLetters[j-1];
                    }
                }
            }else{
                newWord = ""+letters[0];
            }

            scrambledText.add(newWord);
        }

        System.out.println("---Scrambled Text---");
        for(String word : scrambledText){
            System.out.print(word + " ");
        }

    }

    public static List fileReader(String fileName){
        List<String>textLines;
        List<String>text = new ArrayList<>();

        try{
            String filePath = "/Users/omar/Documents/RedditDailyProgrammer/test/java/TypoglycemiaInputs/"+fileName;
            textLines = Files.readAllLines(Paths.get(filePath));

            for(int i = 0; i < textLines.size(); i++) {
                for(String word : textLines.get(i).split(" ")){
                    text.add(word);
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return text;
    }
}