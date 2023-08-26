package repository;

import domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users;
    static UserRepository userRepository;
    public static UserRepository getInstance(){
        if(userRepository==null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }
    private UserRepository(){
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }
}
