package com.plemiannyk.procrastination;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FXMLController {

    @FXML
    private Slider volumeSlider;

    @FXML
    private Label labelName;

    @FXML
    private VBox vBox;

    @FXML
    private Label labelSlider;

    @FXML
    private MediaView mediaView;

    Database db = new Database();
    @FXML
    private Button Reg_button;

    @FXML
    private Button Exit_button;

    @FXML
    private Button Su_button;
    @FXML
    private TextArea friends_textarea;

    @FXML
    private Button Back_button;

    @FXML
    private Button Login_button;

    @FXML
    private TextField Login_field;
    @FXML
    private TextField Pass_field;

    @FXML
    private Button Otherlabs_button;

    @FXML
    private Button friends_button;

    @FXML
    private TextArea friendslist;
    @FXML
    private TextField show_friends_button;



    @FXML
    private void Login_logic(ActionEvent event) throws IOException {
        //Close current
        Stage stage = (Stage) Login_button.getScene().getWindow();
        // do what you have to do
        stage.close();
        String check = Pass_field.getText().toString();
        String check_tf = Login_field.getId();

        boolean circle = false;
        switch (Pass_field.getText()) {
            case ("admin"):
                switch (Login_field.getText()) {
                    case ("admin"):
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("User.getName");
                        stage.setScene(new Scene(root1));
                        stage.show();
                        break;
                    default:
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Wrong password/login");
                        alert.setHeaderText("You have entered wrond password/login");
                        alert.showAndWait();
                        FXMLLoader fxmlLoader_2 = new FXMLLoader(ModuleLayer.Controller.class.getResource("Welcome.fxml"));
                        Scene scene = new Scene(fxmlLoader_2.load());
                        stage.setTitle("OSBB");
                        stage.setScene(scene);
                        stage.show();
                        break;
                }
                break;

            default:

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Wrong password/login");
                alert.setHeaderText("You have entered wrond password/login");
                alert.showAndWait();
                FXMLLoader fxmlLoader_2 = new FXMLLoader(this.getClass().getResource("Welcome.fxml"));
                Scene scene = new Scene(fxmlLoader_2.load());
                stage.setTitle("OSBB");
                stage.setScene(scene);
                stage.show();
                break;
        }


    }


    @FXML
    private void Reg_initialization(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.Reg_button.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("account.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("User.getName");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void Otherlabs_opener(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.Otherlabs_button.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Otherlabs.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Other labs");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void Reg_opener(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.Su_button.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Registration.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("User.getName");
        stage.setScene(new Scene(root));
        stage.show();
    }


    @FXML
    public void Exit(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.Exit_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Back_opener(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.Back_button.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("account.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Welcome");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void friends_opener(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.friends_button.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Friendslist.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    private void showfriends() throws IOException {
        friendslist.setText(db.print_users());
    }
    @FXML
    void openAudio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("music.fxml"));
        Scene scene = new Scene(root, 600, 200);
        Stage stage = new Stage();
        stage.setResizable ( false );

        stage.setTitle("Audio Player");
        //Image icon = new Image("/Users/Роман/IdeaProjects/Addressbook/src/main/resources/com/example/addressbook/icon2.pg");
        //stage.getIcons().add(icon);
        //stage.setResizable(false);

        stage.setScene(scene);

        stage.show();

    }
    @FXML
    void openVideo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("vidosiki.fxml"));
        Scene scene = new Scene(root, 730, 600);
        Stage stage = new Stage();
        stage.setResizable ( false );

        stage.setTitle("Video Player");
        //Image icon = new Image("/Users/Роман/IdeaProjects/Addressbook/src/main/resources/com/example/addressbook/icon2.pg");
        //stage.getIcons().add(icon);
        //stage.setResizable(false);

        stage.setScene(scene);

        stage.show();

    }





}
