import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Controller {

    //final variables
    private final DateTimeFormatter dateDisplayFormat = DateTimeFormatter.ofPattern("dd MMM");
    private final DateTimeFormatter dateCalcFormat = DateTimeFormatter.ofPattern("MMdd");
    private final LocalDateTime now = LocalDateTime.now();
    private final String[] months = new String[]{
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
    //Global variables
    private ObservableList<BirthdayNode> observableList;
    private String filename;
    // GUI variables
    @FXML
    public Label dateLabel;
    public ListView<BirthdayNode> nameView;
    public Text displayedNameText;
    public Text displayedDateText;
    public TextArea displayedDetailsArea;

    //Initialize method
    public void initialize(){
        //Setting label to current date
        dateLabel.setText("Current Date: "+dateDisplayFormat.format(now));

        // Creating data structure
        filename = "Java/Birthdays.txt";
        readfile(filename);
        nameView.setItems(observableList);


        //Create buttons/ panels for each birthday
        nameView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BirthdayNode>() {
            @Override
            public void changed(ObservableValue<? extends BirthdayNode> observable, BirthdayNode oldValue, BirthdayNode newValue) {
                //Save the old stuff
                if (oldValue!=null){
                    oldValue.setNotes(displayedDetailsArea.getText());
                }
                //Load the new stuff
                if (newValue!=null){
                    displayedNameText.setText(newValue.getName());
                    displayedDateText.setText(newValue.getDay() + " " +months[newValue.getMonth()-1]);
                    displayedDetailsArea.setText(newValue.getNotes());
                }
                else{
                    displayedNameText.setText("");
                    displayedDateText.setText("");
                    displayedDetailsArea.setText("");
                }
            };
        });
    }


    private void readfile(String filename){
        BirthdayNode[] birthdayNodes = new BirthdayNode[0];
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
                String details = line.split(",")[2];
                birthdayNodes[i].setNotes(details);
            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
        if(birthdayNodes.length!=0){
            Arrays.sort(birthdayNodes);
        }
        observableList = FXCollections.observableArrayList(birthdayNodes);
    }

    public void open(){
        readfile("Java/Birthdays.txt");
        nameView.setItems(observableList);
    }
    public void save(){
        nameView.getSelectionModel().getSelectedItem().setNotes(displayedDetailsArea.getText());
        try {
            FileWriter saveWriter = new FileWriter(filename);

            saveWriter.write(observableList.size()+"\n");
            for (int i=0; i< observableList.size(); i++){
                saveWriter.write(observableList.get(i).getSaveLine()+"\n");
            }
            saveWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void saveAs(){

    }
}
