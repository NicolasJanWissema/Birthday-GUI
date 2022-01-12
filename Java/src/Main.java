import BirthdayTracker.BirthdayData;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {
    private final DateTimeFormatter dateDisplayFormat = DateTimeFormatter.ofPattern("dd MMM");
    private final DateTimeFormatter dateCalcFormat = DateTimeFormatter.ofPattern("MMdd");
    private final LocalDateTime now = LocalDateTime.now();

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    // GUI variables
    public Label dateLabel;


    //Initialize method
    public void initialize(){
        // Creating data structure
        BirthdayData birthdayManager = new BirthdayData("Java/Birthdays.txt");
        //Setting label to current date
        dateLabel.setText("Current Date: "+dateDisplayFormat.format(now));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //primaryStage.setResizable(false);

        primaryStage.setTitle("Birthday Planner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void delete(){

    }
    public void edit(){

    }
    public void save(){

    }
}
