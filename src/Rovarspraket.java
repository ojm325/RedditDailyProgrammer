import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by omar on 1/27/16.
 *
 * [2015-04-27] Challenge #212 [Easy] Rövarspråket
 * https://www.reddit.com/r/dailyprogrammer/comments/341c03/20150427_challenge_212_easy_r%C3%B6varspr%C3%A5ket/
 */
public class Rovarspraket {
    // Easier to do it this way rather than having several lines calling .add
    String[] c = {"B", "C", "D", "F", "G", "H", "J", "K", "L",
            "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Z",
            "b", "c", "d", "f", "g", "h", "j", "k", "l",
            "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z"};
    List<String> consonants = Arrays.asList(c);

    public String solve(String str){
        String output = "";
        String[] phrase = str.split("");

        for(int i = 0; i < phrase.length; i++){
            if(consonants.contains(phrase[i])){
                output += phrase[i] + "o" +phrase[i].toLowerCase();
            }else{
                output += phrase[i];
            }
        }

        return output;
    }

    public String decode(String str){
        String output = "";
        String[] phrase = str.split("");

        for(int i = 0; i < phrase.length-2; i++){
            if(consonants.contains(phrase[i])
                    && phrase[i+1].equals("o")
                    && consonants.contains(phrase[i+2])){
                phrase[i+1] = phrase[i+2] = "";

            }
        }

        for(int i = 0; i < phrase.length; i++){
            output += phrase[i];
        }
        return output;
    }
}
