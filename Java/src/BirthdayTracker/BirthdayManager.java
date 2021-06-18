package BirthdayTracker;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BirthdayManager {
    private String[] months = new String[]{
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };
    private BirthdayNode birthdayNode = new BirthdayNode();
    private String filename;

    public BirthdayManager(String filename){
        this.filename = filename;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            while((line=bufferedReader.readLine())!=null){
                //System.out.println(line.split(",")[0]+": "+line.split(",")[1]);
                int date = Integer.parseInt(line.split(",")[1]);
                String name = line.split(",")[0];
                System.out.println(name+": "+date%100+" "+months[(date/100)-1]);
            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }

    }
}
