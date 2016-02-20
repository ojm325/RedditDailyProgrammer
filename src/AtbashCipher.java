import java.awt.*;
import java.util.Arrays;

/**
 * Created by Omar on 2/20/2016.
 *
 * [2016-02-16] Challenge #254 [Easy] Atbash Cipher
 * https://www.reddit.com/r/dailyprogrammer/comments/45w6ad/20160216_challenge_254_easy_atbash_cipher/
 */
public class AtbashCipher {

    public static String solve(String str){
        String[] plain = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] strSplit = str.split("");
        String answer = "";
        //System.out.println(plain.length);

        for(int i = 0; i < strSplit.length; i++){
            if(Arrays.asList(plain).contains(strSplit[i])) {
                int cipherNum;
                //System.out.println(cipherNum+ "::" +Arrays.asList(plain).indexOf(strSplit[i]));

                if(Arrays.asList(plain).indexOf(strSplit[i]) >= 26){
                    int letterIndex = Arrays.asList(plain).indexOf(strSplit[i].toUpperCase());
                    cipherNum = plain.length - letterIndex;
                }else{
                    cipherNum = plain.length/2 - Arrays.asList(plain).indexOf(strSplit[i]);
                }

                answer = answer + plain[cipherNum-1];
            }else{
                answer = answer + strSplit[i];
            }
        }

        return answer;
    }
}
