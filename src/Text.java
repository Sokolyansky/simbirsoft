import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Text {
    List<Character> separators;
    MyFile myFile;
    String separator = "";
    public Text(List<Character> separators, MyFile myFile) throws Exception {
        this.separators = separators;
        this.myFile = myFile;
        volume = myFile.getText();
    }
    String volume;
    private static final char[] escapeChars = { '<', '(', '[', '{', '\\', '^', '-', '=', '$', '!', '|', ']', '}', ')', '?', '*', '+', '.', '>' };

    private static String regexEscape(char character) {
        for (char escapeChar : escapeChars) {
            if (character == escapeChar) {
                return "\\" + character;
            }
        }
        return String.valueOf(character);
    }

    public List<String> getAnswer(){
        String volume = myFile.getText();



        List<String> words = new ArrayList<String>();
        for(Character cHar : separators)
        {
           separator= separator.concat(regexEscape(cHar));
        }
        separator="["+separator+"]";

        String src = volume;
        for (String s: src.split(separator)) {
            words.add(s);

        }
        return words;

    }
}
