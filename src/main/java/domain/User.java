package domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    int userId;
    String name;
    TodoTaskList todoList;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.todoList = new TodoTaskList();
    }

    public int getUserId() {
        return userId;
    }

    public TodoTaskList getTodoList() {
        return todoList;
    }
}
