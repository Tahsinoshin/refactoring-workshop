package workshop.trivia;

public interface Questions {
    public boolean matches(int number);
    public String getCatagory();
    public void addQuestion(int number);
    public String askQuestion();
}
