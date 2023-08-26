import domain.ActivityLog;
import domain.Task;
import manager.UserManager;

import java.util.Date;
import java.util.List;

public class TodoTaskTrackingSystem {
    UserManager userManager;
    public TodoTaskTrackingSystem(){
        userManager = new UserManager();
    }
    public int createUser(String name){
        return userManager.createUser(name);
    }
    public int addTask(int userId, Task t) throws Exception{
        return userManager.addTask(userId, t);
    }
    public void modifyTask(Task t) throws Exception {
        userManager.modifyTask(t);
    }
    public void removeTask(int userId, int taskId) throws Exception {
        userManager.removeTask(userId, taskId);
    }
    public Task getTask(int userId, int taskId) throws Exception {
        return userManager.getTask(userId, taskId);
    }
    public List<Task> listTasks(int userId) throws Exception {
        return userManager.getAllTaskForUser(userId);
    }
    public List<ActivityLog> getActivityLog(int userId, Date start, Date end) throws Exception {
        return userManager.getActivityLog(userId, start, end);
    }
}
