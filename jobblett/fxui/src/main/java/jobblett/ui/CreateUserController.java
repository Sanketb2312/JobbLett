package jobblett.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jobblett.core.User;

public class CreateUserController extends SceneController {

  @FXML
  Button createAccountButton;

  @FXML
  TextField username;

  @FXML
  PasswordField password;

  @FXML
  TextField givenName;

  @FXML
  TextField familyName;

  @FXML
  Label errorMessage;

  @FXML
  Button goBackButton;

  @Override
  public void styleIt() {
    super.styleIt();
    goBackButton.setSkin(new ButtonAnimationSkin(goBackButton));
    createAccountButton.setSkin(new ButtonAnimationSkin(createAccountButton));
  }

  @FXML
  public void createAccount() {
    String username = this.username.getText();
    String password = this.password.getText();
    String givenName = this.givenName.getText();
    String familyName = this.familyName.getText();

    try{
      User newUser = new User(username, password, givenName, familyName);
      getAccess().add(newUser);
      mainController.setActiveUser(newUser);
      mainController.setScene(App.USER_HOME_ID);
    } catch (Exception e) {
      errorMessage.setText(e.getMessage());
    }
  }

  @FXML
  public void goToLogIn(){
    mainController.setScene(App.LOGIN_ID);
  }
}
