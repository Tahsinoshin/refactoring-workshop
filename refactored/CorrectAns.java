package workshop;

import java.util.ArrayList;

public class CorrectAns implements Answer{

    ArrayList<Player> players = new ArrayList<>();
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    Announcement announcement;

    @Override
    public Player currentPlayer() {
        return players.get(currentPlayer);
    }

    @Override
    public boolean generateAnswer() {
        if (currentPlayer().havePenalty()) {
            if (isGettingOutOfPenaltyBox) {
                announcement.announce("Answer was correct!!!!");
                currentPlayer().incrementPurse();


                announcement.announce(currentPlayer().getPlayerName()
                        + " now has "
                        + currentPlayer().getPurse()
                        + " Gold Coins.");

                boolean winner = currentPlayer().didPlayerWin();
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;

                return winner;
            } else {
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;
                return true;
            }


        } else {

            announcement.announce("Answer was correct!!!!");
            currentPlayer().incrementPurse();
            announcement.announce(currentPlayer().getPlayerName()
                    + " now has "
                    + currentPlayer().getPurse()
                    + " Gold Coins.");

            boolean winner = currentPlayer().didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;

            return winner;
        }
    }
}
