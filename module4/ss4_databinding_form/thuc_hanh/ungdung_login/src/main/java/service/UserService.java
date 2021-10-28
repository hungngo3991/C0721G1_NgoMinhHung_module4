package service;

import model.Login;
import model.User;
import repository.UserRepository;

public class UserService {
    public static User checkLogin (Login login) {
        return UserRepository.checkLogin(login);
    }
}
