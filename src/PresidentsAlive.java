import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Omar on 3/17/2016.
 *
 * [2016-03-07] Challenge #257 [Easy] In what year were most presidents alive?
 * https://www.reddit.com/r/dailyprogrammer/comments/49aatn/20160307_challenge_257_easy_in_what_year_were/
 */
public class PresidentsAlive {
    public static void main(String[] args){
        parseInput("PresidentsAliveInput.txt");
        List<President> presidents = parseInput("PresidentsAliveInput.txt");

        Calendar aliveDate = new GregorianCalendar(1700, 1, 1);
        int numPresAlive = 0;
        int mostAliveYear = 0;

        while(aliveDate.getWeekYear() < 2016){
            int tempNumPresAlive = 0;
            for(President pres : presidents){
                if((pres.birthDate.getWeekYear() < aliveDate.getWeekYear())
                    && pres.deathDate.getWeekYear() > aliveDate.getWeekYear()){
                    tempNumPresAlive++;
                }
            }

            if(tempNumPresAlive > numPresAlive){
                numPresAlive = tempNumPresAlive;
                mostAliveYear = aliveDate.getWeekYear();
            }

            aliveDate.setWeekDate(aliveDate.getWeekYear()+1, 1, 1);
        }

        System.out.println("YEAR: "+mostAliveYear+ ", PRESIDENTS ALIVE: "+numPresAlive);
    }

    public static List<President> parseInput(String fileName){
        List<String>textLines;
        List<President>presidents = new ArrayList<>();
        String[] m = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> months = Arrays.asList(m);

        try{
            String filePath = "C:\\Users\\Omar\\IdeaProjects\\RedditDailyProgrammer\\test\\java\\"+fileName;
            textLines = Files.readAllLines(Paths.get(filePath));

            for(int i = 1; i < textLines.size()-1; i++) {
                String[] columns = textLines.get(i).split(",");
                String name = columns[0];
                String[] bd = columns[1].split(" ");
                String[] dd = columns[3].split(" ");
                //Doing this for argument's sake
                Calendar deathDate = new GregorianCalendar(2017, 1, 1);

                if(dd.length == 4){
                    deathDate = new GregorianCalendar(Integer.parseInt(dd[3]), Integer.parseInt(dd[2]), months.indexOf(dd[1])+1);
                }

                Calendar birthDate = new GregorianCalendar(Integer.parseInt(bd[3]), Integer.parseInt(bd[2]), months.indexOf(bd[1])+1);

                President pres = new President(name, birthDate, deathDate);
                presidents.add(pres);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return presidents;
    }
}

class President{
    String president;
    Calendar birthDate;
    Calendar deathDate;

    public President(String president,
                     Calendar birthDate,
                     Calendar deathDate){
        this.president = president;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

}
