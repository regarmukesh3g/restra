package application;

import models.User;
import services.RestaurentApplicationService;
import services.UserService;

public class RestraApplication {

  public static void main(String[] args) {

    UserService userService = new UserService();
    User user = userService.getUser();

    RestaurentApplicationService restaurentApplicationService = new RestaurentApplicationService();

    restaurentApplicationService.placeOrder(restaurent,user);
  }
}
