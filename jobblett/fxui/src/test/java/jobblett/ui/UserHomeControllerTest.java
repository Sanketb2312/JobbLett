package jobblett.ui;

import static jobblett.ui.JobblettScenes.CREATE_GROUP_ID;
import static jobblett.ui.JobblettScenes.GROUP_HOME_ID;
import static jobblett.ui.JobblettScenes.JOIN_GROUP_ID;
import static jobblett.ui.JobblettScenes.USER_HOME_ID;

import jobblett.core.Group;
import jobblett.core.User;
import org.junit.jupiter.api.Test;

public class UserHomeControllerTest extends JobbLettTest {

  @Override protected JobblettScenes giveID() {
    return USER_HOME_ID;
  }

  @Override protected User giveActiveUser() {
    return user1;
  }

  @Override protected Group giveActiveGroup() {
    return null;
  }

  @Test public void testGroupsView_initialGroup() {
    uiAssertions.assertListViewHasItem("groups", group1);
  }

  @Test public void testGoTo_GroupHome() {
    clickOn(uiAssertions.findListCell(0));
    uiAssertions.assertOnScene(GROUP_HOME_ID);
  }

  @Test public void testGoTo_JoinGroup() {
    clickOn("#joinGroupButton");
    uiAssertions.assertOnScene(JOIN_GROUP_ID);
  }

  @Test public void testGoTo_CreateGroup() {
    clickOn("#createGroupButton");
    uiAssertions.assertOnScene(CREATE_GROUP_ID);
  }
}
