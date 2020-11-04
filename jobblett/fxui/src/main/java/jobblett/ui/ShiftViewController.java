package jobblett.ui;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import jobblett.core.JobShift;
import jobblett.core.User;

import static jobblett.ui.JobblettScenes.*;


public class ShiftViewController extends SceneController {

  @FXML
  Label groupName;

  @FXML
  ListView<JobShift> shifts;

  @FXML
  Button backToGroup;

  @FXML
  Button newShiftButton;

  @FXML
  Button editShiftButton;

  @FXML
  Button deleteShiftButton;


  @FXML
  CheckBox toggleUserFilterCheckBox;

  @FXML
  public void initialize(){
    shifts.setCellFactory(shifts -> new JobShiftListCell());
    shifts.getSelectionModel().selectedItemProperty().addListener(listener -> updateButtons());
  }

  @Override
  public void onSceneDisplayed() {
    // Sets group name on top of the screen
    groupName.setText(getActiveGroup().getGroupName());
    toggleUserFilterCheckBox.setSelected(false);
    updateView();
    updateButtons();
    setButtonVisibility();
  }

  private void setButtonVisibility(){
    List<Button> buttons = List.of(newShiftButton, editShiftButton, deleteShiftButton);
    boolean visible = getActiveGroup().isAdmin(getActiveUser());
    for(Button button : buttons)
      button.setVisible(visible);
  }

  @FXML
  public void backButton() {
    switchScene(GROUP_HOME_ID);
  }

  @FXML
  public void goToCreateShift() {
    switchScene(UPDATE_SHIFT_ID);
  }

  @FXML
  public void goToEditShift(){
    JobShift selectedJobShift = shifts.getSelectionModel().getSelectedItem();
    UpdateShiftController newController = (UpdateShiftController) UPDATE_SHIFT_ID.getController();
    newController.setActiveJobShift(selectedJobShift);
    switchScene(UPDATE_SHIFT_ID);
  }

  @FXML
  public void handleDeleteShift(){
    int index = shifts.getSelectionModel().getSelectedIndex();
    JobShift selectedJobShift = shifts.getItems().get(index);
    if (selectedJobShift != null) {
      getActiveGroup().getJobShifts().remove(selectedJobShift);
      updateView();
    }
  }

  @FXML
  public void toggleUserFilter(ActionEvent event){
    CheckBox checkBox = (CheckBox) event.getSource();
    if(checkBox.isSelected())
      updateView(getActiveUser());
    else
      updateView();
  }

  // Burde kanskje bruke observable for å kalle på denne metoden
  // Lists all job shifts
  private void updateView() {
    //Endre metode navn kanskje?
    updateView(getActiveGroup().getJobShifts().getJobShifts());
  }

  private void updateView(User user) {
    updateView(getActiveGroup().getJobShifts().getJobShifts(user));
  }

  private void updateView(List<JobShift> shifts){
    this.shifts.getItems().clear();
    for (JobShift shift : shifts)
      this.shifts.getItems().add(shift);
  }

  private void updateButtons() {
    boolean disable = shifts.getSelectionModel().getSelectedIndex() == -1;
    editShiftButton.setDisable(disable);
    deleteShiftButton.setDisable(disable);
  }

  @Override
  public void styleIt() {
    super.styleIt();
    newShiftButton.setSkin(new ButtonAnimationSkin(newShiftButton));
    editShiftButton.setSkin(new ButtonAnimationSkin(editShiftButton));
    deleteShiftButton.setSkin(new ButtonAnimationSkin(deleteShiftButton));
    backToGroup.setSkin(new ButtonAnimationSkin(backToGroup));
  }
}