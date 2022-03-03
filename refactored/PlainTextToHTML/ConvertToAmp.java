package workshop.htmlConverter;

public class ConvertToAmp implements CharacterConverter{
    @Override
    public boolean checkCharacter(char source) {
        return source== '&';
    }

    @Override
    public String convertCharacter() {
        return "&amp;";
    }
}
