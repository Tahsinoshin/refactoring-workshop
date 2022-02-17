package workshop;

public class ScienceQuestion implements Questions{
    @Override
    public boolean matches(int number) {
        return number%4==1;
    }

    @Override
    public String generateResponse() {
        return "Science";
    }
}
