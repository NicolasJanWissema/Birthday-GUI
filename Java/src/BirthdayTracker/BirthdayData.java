package BirthdayTracker;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BirthdayData {
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
    private String filename;
    private BirthdayNode[] birthdayNodes;

    public BirthdayData(String filename){
        this.filename = filename;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            int num = Integer.parseInt(bufferedReader.readLine());
            birthdayNodes = new BirthdayNode[num];

            for(int i=0; i<num; i++){
                line=bufferedReader.readLine();
                int date = Integer.parseInt(line.split(",")[1]);
                String name = line.split(",")[0];
                birthdayNodes[i] = new BirthdayNode(name,date);
            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
        if(birthdayNodes!=null){
            Arrays.sort(birthdayNodes);
        }
    }
    public void insert(){

    }
    public void find(){

    }
    public void displayBirthdays(){

    }
}
