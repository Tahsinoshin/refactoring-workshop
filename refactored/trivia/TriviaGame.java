package workshop.trivia;

import java.util.ArrayList;
import java.util.List;

public class TriviaGame {
    private final ArrayList<Player> players = new ArrayList<>();
    private List<Questions> questions;

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame(List<Questions> questions) {
        this.questions = questions;
    }

    public TriviaGame() {
        for (int i = 0; i < 50; i++) {
            for (Questions questions: questions)
            {
                questions.addQuestion(i);
            }
        }
    }

    public void add(String playerName) {
        players.add(new Player(playerName, 0, 0, false));
        announce(currentPlayer().getPlayerName()+ " was added");
        announce("They are player number " + this.players.size());
    }

    public void roll(int roll) {
        announce(currentPlayer().getPlayerName() + " is the current player");
        announce("They have rolled a " + roll);

        if (currentPlayer().havePenalty()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

               announce(currentPlayer().getPlayerName() + " is getting out of the penalty box");
                /**places[currentPlayer] += roll;*/

                currentPlayer().changePlace(roll);

               announce(currentPlayer().getPlayerName()
                        + "'s new location is "
                        + currentPlayer().getPlace());
                announce("The category is " + currentCategory());
                askQuestion();
            } else {
                announce(currentPlayer().getPlayerName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            currentPlayer().changePlace(roll);

            announce(currentPlayer().getPlayerName() + "'s new location is " + currentPlayer().getPlace());
            announce("The category is " + currentCategory());
            askQuestion();
        }

    }

    private Player currentPlayer() {
        return players.get(currentPlayer);
    }

    private void askQuestion() {
        String questionToBeAnnounced = "";
        for(Questions question: questions){
            if(question.matches(currentPlayer().getPlace()))
                questionToBeAnnounced = question.askQuestion();
        }
        announce(questionToBeAnnounced);
    }

    private String currentCategory() {
        String returnString = "";
        for(Questions question: questions){
            if(question.matches(currentPlayer().getPlace()))
                returnString = question.getCatagory();
        }
        return  returnString;
    }

    public boolean wasCorrectlyAnswered() {
        boolean winner = checkPenaltyIfWinner();
        nextPlayer();
        return winner;
    }

    private boolean checkPenaltyIfWinner() {
        if (currentPlayer().havePenalty()) {
            if (isGettingOutOfPenaltyBox) {
                isCorrectThenGetCoin();
                return currentPlayer().didPlayerWin();
            } else {
                return true;
            }
        } else {
            isCorrectThenGetCoin();
            return currentPlayer().didPlayerWin();
        }
    }

    private void isCorrectThenGetCoin() {
        announce("Answer was correct!!!!");
        currentPlayer().incrementPurse();
        announce(currentPlayer().getPlayerName() + " now has " + currentPlayer().getPurse() + " Gold Coins.");
    }

    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size())
            currentPlayer = 0;
    }

    public void wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(currentPlayer().getPlayerName() + " was sent to the penalty box");
        currentPlayer().givePenalty();
        nextPlayer();
    }

   private void announce(Object message) {
       System.out.println(message);
   }
}