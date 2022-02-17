package workshop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TriviaGame {
    //ArrayList<String> playerName = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    List<Questions> questions ;
    Questions nullQuestion;
    Answer correctAnswer = new CorrectAns();
    Answer wrongAnswer = new WrongAns();
    Announcement announcement;

    //int[] places = new int[6];
    //int[] purses = new int[6];
    //boolean[] inPenaltyBox = new boolean[6];

    LinkedList  popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame(List<Questions> questions) {
        this.questions = questions;
    }

    /** public TriviaGame() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    /** public String createRockQuestion(int index) {
        return "Rock Question " + index;
    } */

    public boolean isPlayable() {
        return (players.size() >= 2);
    }

    public boolean add(String playerName) {


        //this.playerName.add(playerName);
        Player player= new Player(playerName);
        players.add(player);
        
        
        
       // places[players.size()] = 0;
        //purses[players.size()] = 0;
       // inPenaltyBox[players.size()] = false;

        announcement.announce(currentPlayer().getPlayerName()+ " was added");
        announcement.announce("They are player number " + this.players.size());
                
                
        return true;
    }

    /**public int player.size() {
        return playerName.size();
    }*/

    public void roll(int roll) {
        announcement.announce(players.get(currentPlayer).getPlayerName() + " is the current player");
        announcement.announce("They have rolled a " + roll);

        if (currentPlayer().havePenalty()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

               announcement.announce(players.get(currentPlayer).getPlayerName() + " is getting out of the penalty box");
                /**places[currentPlayer] += roll;*/

                currentPlayer().changePlace(roll);
                if (currentPlayer().getPlace() > 11)
                    currentPlayer().changePlace(-12);


               announcement.announce(currentPlayer().getPlayerName()
                        + "'s new location is "
                        + currentPlayer().getPlace());
                announcement.announce("The category is " + currentCategory());
                askQuestion();
            } else {
                announcement.announce(currentPlayer().getPlayerName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            currentPlayer().changePlace(roll);
            if (currentPlayer().getPlace() > 11)
                currentPlayer().changePlace(-12);

            announcement.announce(currentPlayer().getPlayerName()
                    + "'s new location is "
                    + currentPlayer().getPlace());
            announcement.announce("The category is " + currentCategory());
            askQuestion();
        }

    }

    public Player currentPlayer(){
        return players.get(currentPlayer);
    }

    private void askQuestion() {

        if (currentCategory() =="Pop" )
            announcement.announce(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            announcement.announce(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            announcement.announce(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            announcement.announce(rockQuestions.removeFirst());
    }


    private String currentCategory() {

        String returnString = nullQuestion.generateResponse();

        for(Questions question: questions){
            if(question.matches(currentPlayer().getPlace())) returnString= question.generateResponse();
        }
        return  returnString;

        /** if (currentPlayer().getPlace() == 0) return "Pop";
        if (currentPlayer().getPlace() == 4) return "Pop";
        if (currentPlayer().getPlace() == 8) return "Pop";
        if (currentPlayer().getPlace() == 1) return "Science";
        if (currentPlayer().getPlace() == 5) return "Science";
        if (currentPlayer().getPlace() == 9) return "Science";
        if (currentPlayer().getPlace() == 2) return "Sports";
        if (currentPlayer().getPlace() == 6) return "Sports";
        if (currentPlayer().getPlace() == 10) return "Sports";
        return "Rock";*/


    }

    /**public boolean wasCorrectlyAnswered() {
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
    }*/

   /** public boolean wrongAnswer() {
        announcement.announce("Question was incorrectly answered");
        announcement.announce(currentPlayer().getPlayerName() + " was sent to the penalty box");
        currentPlayer().givePenalty();

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }*/

    /** private boolean didPlayerWin() {
        return !(currentPlayer().getPurse() == 6);
    }*/

   /** protected void announce(Object message) {
        System.out.println(message);
    }*/
}