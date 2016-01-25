import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Omar on 1/24/2016.
 *
 * [2015-12-14] Challenge # 245 [Easy] Date Dilemma
 * https://www.reddit.com/r/dailyprogrammer/comments/3wshp7/20151214_challenge_245_easy_date_dilemma/
 */
public class DateDilemma {
    public String validate(String str){
        List<String> date = new ArrayList();
        int month;
        int day;
        int year;

        if(str.contains(" ")){
            String[] d = str.split(" ");
            date = Arrays.asList(d);
        }else if(str.contains("-")){
            String[] d = str.split("-");
            date = Arrays.asList(d);
        }else if(str.contains("/")){
            String[] d = str.split("/");
            date = Arrays.asList(d);
        }

        if(Integer.parseInt(date.get(0)) > 1000){
            year = Integer.parseInt(date.get(0));
            month = Integer.parseInt(date.get(1));
            day = Integer.parseInt(date.get(2));
        }else{
            month = Integer.parseInt(date.get(0));
            day = Integer.parseInt(date.get(1));
            year = Integer.parseInt(date.get(2));
        }

        String formattedDate = stringFormatter(month, day, year);

        return formattedDate;
    }

    public String stringFormatter(int m, int d, int y){
        String month;
        String day;
        String year;

        if(m < 10){
            month = "0"+m;
        }else{
            month = ""+m;
        }

        if(d < 10){
            day = "0"+d;
        }else{
            day = ""+d;
        }

        // Assuming all dates are from 2000 and after...
        if(y < 10){
            year = "200"+y;
        }else if(y >= 10 && y < 100){
            year = "20"+y;
        }else{
            year = ""+y;
        }

        String str = year+"-"+month+"-"+day;

        return str;

    }
}
