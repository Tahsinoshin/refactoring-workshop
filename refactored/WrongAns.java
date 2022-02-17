package workshop;

import java.util.ArrayList;

public class WrongAns implements Answer{
    ArrayList<Player> players = new ArrayList<>();
    int currentPlayer = 0;
    Announcement announcement;

    @Override
    public Player currentPlayer() {
        return players.get(currentPlayer);
    }

    @Override
    public boolean generateAnswer() {
        announcement.announce("Question was incorrectly answered");
        announcement.announce(currentPlayer().getPlayerName() + " was sent to the penalty box");
        currentPlayer().givePenalty();

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }
}
