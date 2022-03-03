package workshop.trivia;

import java.util.ArrayList;
import java.util.List;

public class ScienceQuestion implements Questions {
    List<String> questionStack = new ArrayList<>();

    @Override
    public boolean matches(int number) {
        return (number % 4 == 1);
    }

    @Override
    public String getCatagory() {
        return "Science";
    }

    @Override
    public void addQuestion(int number) {
        questionStack.add("Science Question " + number);
    }

    @Override
    public String askQuestion() {
        return questionStack.remove(0);
    }
}
