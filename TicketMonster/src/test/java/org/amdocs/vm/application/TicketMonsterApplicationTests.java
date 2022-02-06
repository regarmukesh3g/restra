package org.amdocs.vm.application;

import org.amdocs.vm.application.user.User;
import org.amdocs.vm.application.user.UserController;
import org.amdocs.vm.application.user.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

@SpringBootTest
class TicketMonsterApplicationTests {

    UserService userService = Mockito.mock(UserService.class);
    UserController u1 = new UserController(userService);


    @Test
    void testUser1() {
        Mockito.when(userService.getUserById(Mockito.anyString())).thenReturn(Optional.of(new User("id","firstName","MiddleIni","lastName")));
        final ResponseEntity<User> responseEntity = this.u1.getUser("id");
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
//        assertEquals(u1.getUserById("1"),new Optional<User>(new User("1", "usr1", "middle1", "lastName1")));
//        assertEquals u1.getUserById("1") == new Optional<User> User("1", "usr1", "middle1", "lastName1");
    }

}
