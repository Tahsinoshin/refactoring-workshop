package workshop.trivia;

import java.util.ArrayList;
import java.util.List;

public class RockQuestion implements Questions {
    List<String> questionStack = new ArrayList<>();

    @Override
    public boolean matches(int number) {
        return (number % 4 == 3);
    }

    @Override
    public String getCatagory() {
        return "Rock";
    }

    @Override
    public void addQuestion(int number) {
        questionStack.add("Rock Question " + number);
    }

    @Override
    public String askQuestion() {
        return questionStack.remove(0);
    }
}
