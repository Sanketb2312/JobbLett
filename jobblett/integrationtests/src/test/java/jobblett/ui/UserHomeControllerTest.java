package jobblett.ui;

import jobblett.core.User;
import org.junit.jupiter.api.Test;

import static jobblett.ui.JobblettScenes.*;

public abstract class UserHomeControllerTest extends JobbLettTest {

  @Override public JobblettScenes giveId() {
    return USER_HOME;
  }

  @Override public User optionalActiveUser() {
    return user1;
  }

  @Test public void testGroupsView_initialGroup() {
    uiAssertions.assertListViewHasItem("groups", group1.getGroupId());
  }

  @Test public void testGoTo_GroupHome() {
    clickOn(uiAssertions.findListCell(0));
    uiAssertions.assertOnScene(GROUP_HOME);
  }

  @Test public void testGoTo_JoinGroup() {
    clickOn("#joinGroupButton");
    uiAssertions.assertOnScene(JOIN_GROUP);
  }

  @Test public void testGoTo_CreateGroup() {
    clickOn("#createGroupButton");
    uiAssertions.assertOnScene(CREATE_GROUP);
  }
}
