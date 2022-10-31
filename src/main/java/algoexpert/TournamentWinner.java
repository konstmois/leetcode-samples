package algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// https://www.algoexpert.io/questions/tournament-winner
public class TournamentWinner {

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> scores = new HashMap<>();
        String leader = null;
        int leaderScore = 0;
        for (int i = 0; i < competitions.size(); i++) {
            String winner = competitions.get(i).get(results.get(i) == 1 ? 0 : 1);
            int currWinnerScore = 1;
            if (scores.containsKey(winner)) {
                currWinnerScore = scores.get(winner) + 1;
                scores.put(winner, currWinnerScore);
            } else {
                scores.put(winner, currWinnerScore);
            }
            if (leaderScore < currWinnerScore) {
                leader = winner;
                leaderScore = currWinnerScore;
            }
        }
        return leader;
    }
}
