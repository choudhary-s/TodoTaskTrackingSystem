package manager;

import domain.ActivityLog;
import domain.Task;
import domain.TodoTaskList;
import domain.User;
import repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {
    UserRepository userRepository;
    TodoTasksManager todoTasksManager;
    public UserManager(){
        userRepository = UserRepository.getInstance();
        todoTasksManager = new TodoTasksManager();
    }
    public int createUser(String name){
        int userId = userRepository.getUsers().size()+1;
        User user = new User(userId, name);
        userRepository.getUsers().add(user);
        return userId;
    }
    public int addTask(int userId, Task t)throws Exception{
        User user = searchUserById(userId);
        TodoTaskList tl = user.getTodoList();
        return todoTasksManager.addTasks(tl,t, userId);
    }
    public void modifyTask(Task t) throws Exception {
        User user = searchUserById(t.getUserId());
        TodoTaskList tl = user.getTodoList();
        todoTasksManager.modifyTask(tl, t);
    }
    public void markTaskComplete(int userID, int taskId) throws Exception {
        User user = searchUserById(userID);
        TodoTaskList tl = user.getTodoList();
        todoTasksManager.markTaskCompleted(tl, taskId);
    }
    public void removeTask(int userId, int taskId) throws Exception {
        User user = searchUserById(userId);
        TodoTaskList tl = user.getTodoList();
        todoTasksManager.removeTask(tl, taskId);
    }
    public List<Task> getAllTaskForUser(int userId) throws Exception{
        User user = searchUserById(userId);
        TodoTaskList tl = user.getTodoList();
        return tl.getTasks();
    }
//    public List<Task> getAllTaskForUser(int userId, FilterCriteria fc, String val) throws Exception{
//        User user = searchUserById(userId);
//        TodoTaskList tl = user.getTodoList();
//        return tl.getTasks().stream().filter(task -> task.getStatus().toString().equals(val));
//    }
    public List<ActivityLog> getActivityLog(int userId, Date start, Date end) throws Exception{
        User user = searchUserById(userId);
        List<ActivityLog> al = user.getTodoList().getActivityLogs();
        return al.stream()
                .filter(activityLog -> activityLog.getTimestamp().getTime()>start.getTime() && activityLog.getTimestamp().getTime()< end.getTime()).collect(Collectors.toList());
    }
    public Task getTask(int userId, int taskId) throws Exception{
        User user = searchUserById(userId);
        TodoTaskList tl = user.getTodoList();
        try {
            return tl.getTasks().stream().filter(task -> task.getTaskId() == taskId).findFirst().get();
        }
        catch (Exception ex){
            throw new Exception("No such task for the user");
        }
    }
    public User searchUserById(int id) throws Exception {
        try{
            return userRepository.getUsers().stream().filter(user -> user.getUserId()==id).findFirst().get();
        }
        catch (Exception ex){
            throw new Exception("No such user in the repository");
        }
    }
}
