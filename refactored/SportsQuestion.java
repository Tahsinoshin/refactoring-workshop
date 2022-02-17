package workshop;

public class SportsQuestion implements Questions{
    @Override
    public boolean matches(int number) {
        return number%4==2;
    }

    @Override
    public String generateResponse() {
        return "Sports";
    }
}
