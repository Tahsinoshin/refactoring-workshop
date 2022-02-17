package workshop;

public class Player {

    private final String playerName;
    private int place=0;
    private int purse=0;
    private boolean inPenaltyBox=false;


    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlace() {
        return place;
    }
    public void changePlace(int roll){
        place+=roll;
    }

    public int getPurse() {
        return purse;
    }
    public  void incrementPurse(){
        purse++;
    }

    public boolean havePenalty() {
        return inPenaltyBox;
    }

    public void givePenalty(){
        inPenaltyBox=true;
    }

    public boolean didPlayerWin() {
        return !(getPurse() == 6);
    }
}
