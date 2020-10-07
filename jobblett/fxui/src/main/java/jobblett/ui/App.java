package jobblett.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(final Stage primaryStage) throws Exception {
    final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
    final Parent parent = fxmlLoader.load();
    primaryStage.setScene(new Scene(parent));
    primaryStage.show();
  }

  public static void main(final String[] args) {
    launch(args);
  }
}