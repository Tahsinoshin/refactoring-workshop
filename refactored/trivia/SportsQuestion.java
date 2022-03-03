package workshop.trivia;

import java.util.ArrayList;
import java.util.List;

public class SportsQuestion implements Questions {
    List<String> questionStack = new ArrayList<>();

    @Override
    public boolean matches(int number) {
        return (number % 4 == 2);
    }

    @Override
    public String getCatagory() {
        return "Sports";
    }

    @Override
    public void addQuestion(int number) {
        questionStack.add("Sports Question " + number);
    }

    @Override
    public String askQuestion() {
        return questionStack.remove(0);
    }
}
