import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class MyFile {
    String httpsURL;
    String filename;



    public MyFile(String httpsURL, String filename) {
        this.httpsURL = httpsURL;
        this.filename = filename;
    }

    public String getText()  {

    try{BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
    URL myurl = new URL(httpsURL);
    HttpsURLConnection con = (HttpsURLConnection) myurl.openConnection();
        con.setRequestProperty ( "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0" );
    InputStream ins = con.getInputStream();
    InputStreamReader isr = new InputStreamReader(ins, "UTF-8");
    BufferedReader in = new BufferedReader(isr);
    String inputLine;

    // Write each line into the file
        while ((inputLine = in.readLine()) != null) {
        bw.write(inputLine);
    }
        in.close();
        bw.close();}catch (Exception e){

    }
        //read file to string
        String value="";
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            Optional<String> optional = stream.findFirst();
            value = optional.isPresent() ? optional.get() : null;
             } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))  {
             value = reader.readLine();
        }catch (Exception e){

        }

        return value;
}

}
