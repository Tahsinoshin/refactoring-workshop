package workshop;

import java.util.ArrayList;
import java.util.List;

public class ConvertToNewLine implements CharacterConverter{
    private  void addANewLine(List<String> result, List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }
    @Override
    public boolean checkCharacter(char source) {
        return addANewLine(result,convertedLine);
    }

    @Override
    public String convertCharacter() {
        return null;
    }
}
