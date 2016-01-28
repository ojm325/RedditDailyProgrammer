/**
 * Created by Omar on 1/28/2016.
 *
 * [2015-11-02] Challenge #239 [Easy] A Game of Threes
 * https://www.reddit.com/r/dailyprogrammer/comments/3r7wxz/20151102_challenge_239_easy_a_game_of_threes/
 */
public class AGameOfThrees {
    public static void main(String[] args) {
        solve(100);
        solve(31337357);
    }
    public static void solve(int num){
        while(num != 1){
            String str = "";
            if(num%3 == 0){
                num = num / 3;
                str = " 0";
            }else{
                if(num%3 == 1){
                    num--;
                    str = " -1";
                }else{
                    num++;
                    str =  " 1";
                }
            }

            if(num == 1){ str = "";}

            System.out.println(num +str);
        }
        System.out.println("-------");
    }
}
