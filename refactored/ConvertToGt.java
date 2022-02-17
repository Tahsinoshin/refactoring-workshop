package workshop;

public class ConvertToGt implements CharacterConverter{
    @Override
    public boolean checkCharacter(char source) {
        return source== '>';
    }

    @Override
    public String convertCharacter() {
        return "&gt;";
    }
}
