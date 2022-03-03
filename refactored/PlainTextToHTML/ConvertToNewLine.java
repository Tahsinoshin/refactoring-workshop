package workshop.htmlConverter;

import java.util.ArrayList;
import java.util.List;

public class ConvertToNewLine implements CharacterConverter{

    @Override
    public boolean checkCharacter(char source) {
        return (source == '\n');
    }

    @Override
    public String convertCharacter() {
        return null;
    }
}
