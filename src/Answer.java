import java.util.ArrayList;
import java.util.List;

public class Answer {
    List<String> uniqueWords;

    Text text;

    public Answer(List<String> uniqueWords, Text text) {
        this.uniqueWords = uniqueWords;
        this.text = text;
    }

    public void printAnswer(){

        List<String> answer = new ArrayList<String>(text.getAnswer());
        int count = 0;
        for(String uniqueWord :uniqueWords){
            count = 0;
        for(String word : answer){

        if (word.equalsIgnoreCase(uniqueWord)) {
            count++;
        }
        }System.out.println(uniqueWord + " - "+count);}

    }
}
