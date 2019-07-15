package hw7.testData;

import hw7.entities.Users;

public class UsersData {
    public static Users PITER_CHAILOVSKII = new Users().set(s -> {
        s.setLogin("epam");
        s.setPassword("1234");
        s.setFullName("PITER CHAILOVSKII");
    });
}
