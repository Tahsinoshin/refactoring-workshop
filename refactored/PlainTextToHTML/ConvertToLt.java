package workshop.htmlConverter;

public class ConvertToLt implements CharacterConverter{


    @Override
    public boolean checkCharacter(char source) {
        return source == '<';
    }

    @Override
    public String convertCharacter() {
        return "&lt;";
    }
}
