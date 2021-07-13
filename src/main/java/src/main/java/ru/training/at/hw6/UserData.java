package src.main.java.ru.training.at.hw6;

import src.main.java.ru.training.at.hw6.entities.User;

public class UserData {
    public static User DEFAULT_USER = new User().set(
            u -> {
                u.userName = "Roman";
                u.password = "Jdi1234";
                u.userNameLogged = "ROMAN IOVLEV";
            });
}
