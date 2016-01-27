import java.util.*;

/**
 * Created by Omar on 1/26/2016.
 *
 * [2015-11-18] Challenge # 242 [Intermediate] VHS recording problem
 * https://www.reddit.com/r/dailyprogrammer/comments/3u6o56/20151118_challenge_242_intermediate_vhs_recording/
 */
public class VHSRecordingProblem {
    public String solveMain(List<String> file, String questionType){
        List<TVShow> shows = new ArrayList<>();
        List<TVShow> recordedShows = new ArrayList<>();

        for(int i = 0; i < file.size(); i++){
            String[] times = file.get(i).split(" ");

            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            String name = "";
            if(times.length > 2){
                for(int j = 2; j < times.length; j++){
                    name += times[j]+" ";
                }
            }

            TVShow show = new TVShow(start, end, name);
            shows.add(show);
        }

        Collections.sort(shows, new Comparator<TVShow>() {
            @Override
            public int compare(TVShow o1, TVShow o2) {
                return o1.endTime - o2.endTime;
            }
        });

        /*
        for (TVShow t: shows) {
            System.out.print("SHOW: " + t.startTime + " - " + t.endTime+" || ");
        }
        System.out.println("");
        */

        while (shows.size() > 0){
            TVShow show = shows.remove(0);

            if(recordedShows.isEmpty()){
                recordedShows.add(show);
            }else{
                if (show.startTime >= recordedShows.get(recordedShows.size()-1).endTime) {
                    recordedShows.add(show);
                }
            }

        }

        /*
        System.out.println("----");
        for (TVShow t: recordedShows) {
            System.out.print("SHOW: " + t.startTime + " - " + t.endTime+" || ");
        }
        System.out.println("");
        System.out.println("~~~~~~~~DONE~~~~~~~~");
        */

        if(questionType.equals("Normal")) {
            return ""+recordedShows.size();
        }else if(questionType.equals("Bonus 1")){
            String output = "";
            for (TVShow s: recordedShows) {
                output += s.name+"\n";
            }
            return output;
        }else if(questionType.equals("Bonus 2")){
            return null;
        }

        return null;
    }
}

class TVShow{
    int startTime;
    int endTime;
    String name;
    public TVShow(int startTime, int endTime, String name){
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
    }
}