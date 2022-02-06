package com.regar.splitwise.services;

import com.regar.splitwise.models.Group;
import com.regar.splitwise.models.User;
import java.util.List;

public class GroupService {
  private int sequence;

  public GroupService(int sequence) {
    this.sequence = sequence;
  }

  public Group createGroup(String groupName, List<User> memberList) {

    int nextSequence = this.sequence+1;
    this.sequence++;
    return new Group(nextSequence,groupName,memberList);

  }


}
