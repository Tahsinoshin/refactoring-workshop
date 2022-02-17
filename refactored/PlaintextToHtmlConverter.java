package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {

    private CharacterConverter characterConverters;

    public PlaintextToHtmlConverter(CharacterConverter characterConverters) {
        super();
        this.characterConverters= characterConverters;
    }

    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    private String read() throws IOException {
        Path filePath = Paths.get("sample.txt");
        byte[] fileByteArray = Files.readAllBytes(filePath);
        return new String(fileByteArray);
    }

    private String basicHtmlEncode(String source) {

        int i = 0;
        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();
        char characterToConvert = ' ';

        for ( characterToConvert : source.toCharArray()) {
            if(characterConverters.checkCharacter(characterToConvert)) result= CharacterConverter.convertCharacter();


        }

        String finalResult = String.join("<br />", result);
        return finalResult;
    }


}