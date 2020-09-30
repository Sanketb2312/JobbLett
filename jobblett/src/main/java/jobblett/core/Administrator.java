package jobblett.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Administrator extends AbstractUser{

    private GroupList groupList;
    private Employee employee;

    @JsonCreator
    public Administrator(
            @JsonProperty("userName") String userName,
            @JsonProperty("password") String password,
            @JsonProperty("givenName") String givenName,
            @JsonProperty("familyName") String familyName
    ){
        super(userName, password, givenName, familyName);
        groupList = new GroupList();
    }

    private void addOrRemoveEmployee(Group group, Employee employee){
        if(!groupList.getGroups(employee).contains(group))
            if(groupList.getGroup(group.getGroupID())!=null)
                group.addUser(employee);
    }

    private void removeEmployeeFromGroup(Group group, Employee employee){
        if(groupList.getGroups(employee).contains(group))
            if(groupList.getGroup(group.getGroupID())!=null)
                group.removeUser(employee);

    }

    public void setShiftForEmployee(Employee employee){

    }


}
