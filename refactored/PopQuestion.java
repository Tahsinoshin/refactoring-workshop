package workshop;

public class PopQuestion implements Questions{
    @Override
    public boolean matches(int number) {
        return number%4 == 0;
    }

    @Override
    public String generateResponse() {
        return "Pop";
    }
}
