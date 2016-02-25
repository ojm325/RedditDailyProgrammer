import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omar on 2/24/2016.
 *
 * [2016-02-22] Challenge #255 [Easy] Playing with light switches
 * https://www.reddit.com/r/dailyprogrammer/comments/46zm8m/20160222_challenge_255_easy_playing_with_light/
 */
public class PlayingWithLightSwitches {
    static int n = 0;
    static List<Boolean>switches = new ArrayList<>();

    public static int solve(String fileName) {
        fileReader(fileName);
        return countLightsOn();
    }

    private static int countLightsOn() {
        int count = 0;
        for(int i = 0; i < n; i++){
            if(switches.get(i).equals(true)){
                count++;
            }
        }

        return count;
    }

    public static void switchLights(int[] turnOn){
        int firstNum = turnOn[0];
        int secondNum = turnOn[1];

        if(turnOn[0] > turnOn[1]){
            firstNum = turnOn[1];
            secondNum = turnOn[0];
        }

        for(int i = firstNum; i <= secondNum; i++){
            switches.set(i, !switches.get(i));
        }
    }

    public static void fileReader(String fileName){
        List<String>textLines;
        List<String>text = new ArrayList<>();

        try{
            String filePath = "C:\\Users\\Omar\\IdeaProjects\\RedditDailyProgrammer\\test\\java\\PlayingWithLightSwitchesInputs\\"+fileName;
            textLines = Files.readAllLines(Paths.get(filePath));

            for(int i = 0; i < textLines.size(); i++) {
                int[]turnOn = new int[2];
                int j = 0;
                boolean firstLine = false;

                for(String num : textLines.get(i).split(" ")){
                    if(i == 0){
                        n = Integer.parseInt(num);
                        for(int k = 0; k < n; k++){
                            switches.add(false);
                        }
                        firstLine = true;
                    }else{
                        int temp = Integer.parseInt(num);
                        turnOn[j] = temp;
                        j++;
                    }
                }

                if(!firstLine) {
                    switchLights(turnOn);
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
