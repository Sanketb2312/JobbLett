package jobblett.ui;

/**
 * An enum for switching scene easier.
 *
 */
public enum JobblettScenes {
  LOGIN("Login.fxml"),
  CREATE_USER("CreateUser.fxml"), 
  USER_HOME("UserHome.fxml"),
  JOIN_GROUP("JoinGroup.fxml"), 
  CREATE_GROUP("CreateGroup.fxml"),
  GROUP_HOME("GroupHome.fxml"), 
  SHIFT_VIEW("ShiftView.fxml"),
  UPDATE_SHIFT("UpdateShift.fxml");

  private final String filename;

  JobblettScenes(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }


}
