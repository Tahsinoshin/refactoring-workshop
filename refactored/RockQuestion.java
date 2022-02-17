package workshop;

public class RockQuestion implements Questions{
    @Override
    public boolean matches(int number) {
        return false;
    }

    @Override
    public String generateResponse() {
        return "Rock";
    }

}
