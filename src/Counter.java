import java.util.ArrayList;
import java.util.List;

public class Counter {
    public static void main(String[] args) throws Exception {
        String httpsURL = "https://www.simbirsoft.com/";
        String filename = "h:\\filename.html";
        List<String> uniqueWords = new ArrayList<String>();
        uniqueWords.add("РАЗРАБОТКА");
        uniqueWords.add("ПРОГРАМНОГО");
        uniqueWords.add("ОБЕСПЕЧЕНИЯ");
        List<Character> separators = new ArrayList<Character>();
        separators.add(' ');
        separators.add(',');
        separators.add('.');
        separators.add('!');
        separators.add('?');
        separators.add('"');
        separators.add(';');
        separators.add(':');
        separators.add('[');
        separators.add(']');
        separators.add('(');
        separators.add(')');
        separators.add('\n');
        separators.add('\r');
        separators.add('\t');

        MyFile myFile = new MyFile(httpsURL, filename);
        Text text = new Text(separators, myFile);
        Answer test = new Answer(uniqueWords, text);

           test.printAnswer();

    }
}
