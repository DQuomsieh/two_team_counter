import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Interface extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Label displayScoreOne, displayScoreTwo, teamOne, teamTwo, teamOneName, teamTwoName;
    TextField inputTeamOne, inputTeamTwo;
    Button btnStart, btnDone, btnExit;
    GridPane mainPane, secondPane;

    @Override
    public void start(Stage primaryStage) {

        mainPane = new GridPane();

        inputTeamOne = new TextField();
        inputTeamTwo = new TextField();
        inputTeamOne.setPromptText("enter team name");
        inputTeamTwo.setPromptText("enter team name");

        btnStart = new Button("start!");
        btnDone = new Button("done");
        btnExit = new Button("exit");

        teamOne = new Label("team one");
        teamTwo = new Label("team two");

        mainPane.setAlignment(Pos.CENTER);
        mainPane.setHgap(10);
        mainPane.setVgap(10);

        mainPane.add(teamOne, 1, 0);
        mainPane.add(inputTeamOne, 1,1);
        mainPane.add(teamTwo, 3, 0);
        mainPane.add(inputTeamTwo, 3, 1);
        mainPane.add(btnStart, 2, 2);

        attachCode();
        setWidths();
        setMainStyles();

        Scene scene = new Scene(mainPane, 385, 150);
        primaryStage.setTitle("Score Counter");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    void showScoreBoard(){
        Stage stage = new Stage();
        secondPane = new GridPane();

        if(inputTeamTwo.getText().isEmpty()) {
            teamTwoName.setText("Team Two");
        } else
            teamTwoName = new Label(inputTeamTwo.getText());

        if(inputTeamOne.getText().isEmpty()){
            teamOneName.setText("Team One");
        }
        else
            teamOneName = new Label(inputTeamOne.getText());

        displayScoreOne = new Label("0");
        displayScoreTwo = new Label("0");

        secondPane.add(teamOneName,0, 0);
        secondPane.add(displayScoreOne, 0,1);
        secondPane.add(teamTwoName, 1, 0);
        secondPane.add(displayScoreTwo, 1, 1);



        setScoreStyles();
        setScoreWidths();
        setScoreHeights();

        Scene scene = new Scene(secondPane, 385, 300);

        scene.setOnKeyPressed(e -> {
            int temp;
            if(e.getCode() == KeyCode.J){
                temp = Integer.valueOf(displayScoreOne.getText()) + 1;
                displayScoreOne.setText(String.valueOf(temp));
            } else if(e.getCode() == KeyCode.K){
                temp = Integer.valueOf(displayScoreTwo.getText()) + 1;
                displayScoreTwo.setText(String.valueOf(temp));
            } else if(e.getCode() == KeyCode.N){
                temp = Integer.valueOf(displayScoreOne.getText()) - 1;
                displayScoreOne.setText(String.valueOf(temp));
            } else if(e.getCode() == KeyCode.M){
                temp = Integer.valueOf(displayScoreTwo.getText()) - 1;
                displayScoreTwo.setText(String.valueOf(temp));
            }
        });

        stage.setScene(scene);
        stage.show();
    }


    void setScoreStyles(){

        teamOneName.setStyle("-fx-background-color: #333333; -fx-padding: 5px; -fx-border-color:  #3D3D3D; -fx-text-fill: #DADADA");
        teamOneName.setAlignment(Pos.CENTER);

        teamTwoName.setStyle("-fx-background-color: #333333; -fx-padding: 5px; -fx-border-color:  #3D3D3D; -fx-text-fill: #DADADA");
        teamTwoName.setAlignment(Pos.CENTER);

        secondPane.setAlignment(Pos.CENTER);
        secondPane.setStyle("-fx-background-color: #444444; -fx-border-color: #3D3D3D");

        displayScoreOne.setStyle("-fx-background-color: #333333; -fx-padding: 5px; -fx-border-color:  #3D3D3D; -fx-text-fill: #DADADA; -fx-font-size: 50px");
        displayScoreOne.setAlignment(Pos.CENTER);
        displayScoreTwo.setStyle("-fx-background-color: #333333; -fx-padding: 5px; -fx-border-color:  #3D3D3D; -fx-text-fill: #DADADA; -fx-font-size: 50px");
        displayScoreTwo.setAlignment(Pos.CENTER);
    }

    void setScoreWidths(){
        secondPane.setPrefWidth(385);

        teamOneName.setPrefWidth(160);
        teamTwoName.setPrefWidth(160);

        displayScoreOne.setPrefWidth(160);
        displayScoreTwo.setPrefWidth(160);
    }

    void setScoreHeights(){
        secondPane.setPrefHeight(200);
        displayScoreOne.setPrefHeight(200);
        displayScoreTwo.setPrefHeight(200);
    }

    void setWidths(){
        inputTeamTwo.setPrefWidth(135);
        inputTeamOne.setPrefWidth(135);
        btnStart.setPrefWidth(70);
    }

    void attachCode(){
        btnStart.setOnAction(event -> showScoreBoard());
//        btnExit.setOnAction(event -> );
//        btnDone.setOnAction(event -> );
    }


    void setMainStyles(){
        teamOne.setStyle("-fx-text-fill: #DADADA");
        teamTwo.setStyle("-fx-text-fill: #DADADA");

        inputTeamOne.setStyle("-fx-background-color: #333333; -fx-padding: 5px; -fx-border-color:  #3D3D3D; -fx-text-fill: #DADADA");
        inputTeamTwo.setStyle("-fx-background-color: #333333; -fx-padding: 5px; -fx-border-color:  #3D3D3D; -fx-text-fill: #DADADA");

        btnStart.setStyle("-fx-background-color: #6DC072; -fx-padding: 5px; -fx-background-radius: 0px; -fx-text-fill: #DADADA");

        mainPane.setStyle("-fx-background-color: #444444; -fx-border-color: #3D3D3D");
    }
}
