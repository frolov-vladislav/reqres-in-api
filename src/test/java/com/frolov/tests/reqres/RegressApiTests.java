package com.frolov.tests.reqres;

import com.frolov.tests.reqres.api.Api;
import com.frolov.tests.reqres.lombok.User;
import com.frolov.tests.reqres.lombok.UserData;
import org.junit.jupiter.api.Test;

import static com.frolov.tests.reqres.TestData.firstName;
import static com.frolov.tests.reqres.TestData.job;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RegressApiTests {
    Api api = new Api();

    @Test
    public void getSingleUser() {
        UserData data = api.getUser(2);
        assertEquals("Janet", data.getUser().getFirstName());
    }

    @Test
    public void negativeSingleUser() {
        UserData data = api.getUser(53453);
        assertNull(data.getUser());
    }

    @Test
    public void create() {
        User responseData = api.createUser(new User(firstName, job));
        assertEquals(responseData.getFirstName(), firstName);
    }

    @Test
    public void update() {
        User user = new User(firstName, job);
        User createData = api.createUser(user);
        User updatedUser = new User("New name", "New job");
        User updateData = api.update(updatedUser, createData.getId());
        assertEquals(updatedUser.getJob(), updateData.getJob());
        assertEquals(updatedUser.getFirstName(), updateData.getFirstName());
    }

    @Test
    public void resourceNamesContains() {
        api.checkResourceName("fuchsia rose");
    }
}