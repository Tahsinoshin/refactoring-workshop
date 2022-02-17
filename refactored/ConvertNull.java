package workshop;

import java.util.List;

public class ConvertNull implements CharacterConverter{


    //stringfy convertedLine array and push into result
    //reset convertedLine


    private void pushACharacterToTheOutput(List<String> convertedLine, char characterToConvert) {
    }


    @Override
    public boolean checkCharacter(String source) {
        return false;
    }

    @Override
    public String convertCharacter() {
        return  pushACharacterToTheOutput(result,convertedLine);
    }
}
