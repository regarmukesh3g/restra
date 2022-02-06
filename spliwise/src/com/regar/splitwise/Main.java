package com.regar.splitwise;

import com.regar.splitwise.controllers.UserController;
import com.regar.splitwise.models.Group;
import com.regar.splitwise.models.User;
import com.regar.splitwise.services.BillingService;
import com.regar.splitwise.services.GroupService;
import com.regar.splitwise.services.UserService;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        UserService userService = new UserService();
        UserController userController = new UserController(userService);

        User mukesh = userService.createUser(1, "Mukesh");
        User vikas = userService.createUser(2, "Vikas");

        GroupService groupService = new GroupService(0);
        List<User> memberList = new ArrayList<>();
        memberList.add(mukesh);
        memberList.add(vikas);
        Group puneWFH = groupService.createGroup("PuneWFH", memberList);
        int amount = 100;

        BillingService billingService = new BillingService();

        int billId = billingService.addExpense(mukesh,100,puneWFH);

    }
}
