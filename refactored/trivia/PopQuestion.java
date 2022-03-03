package workshop.trivia;

import java.util.ArrayList;
import java.util.List;

public class PopQuestion implements Questions {
    List<String> questionStack = new ArrayList<>();

    @Override
    public boolean matches(int number) {
        return number % 4 == 0;
    }

    @Override
    public String getCatagory() {
        return "Pop";
    }

    @Override
    public void addQuestion(int number) {
        questionStack.add("Pop Question " + number);
    }

    @Override
    public String askQuestion() {
        return questionStack.remove(0);
    }
}
