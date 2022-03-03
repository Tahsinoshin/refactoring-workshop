package workshop.htmlConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {

    private List<CharacterConverter> characterConverters = new ArrayList<>();
    private ConvertToNewLine convertToNewLine = new ConvertToNewLine();

    public PlaintextToHtmlConverter(List<CharacterConverter> characterConverters) {
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
        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();

        for (char characterToConvert : source.toCharArray()) {
            for (CharacterConverter characterConverter : characterConverters) {
                if(characterConverter.checkCharacter(characterToConvert)) {
                    convertedLine.add(characterConverter.convertCharacter());
                }
            }
            if (convertToNewLine.checkCharacter(characterToConvert)) {
                addANewLine(result, convertedLine);
            }

        }



        addANewLine(result, convertedLine);
        return String.join("<br />", result);
    }

    private  void addANewLine(List<String> result, List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine.clear();
    }

}