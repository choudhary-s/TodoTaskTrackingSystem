package domain;

import java.util.ArrayList;
import java.util.List;

public class TodoTaskList {
    List<Task> tasks;
    List<ActivityLog> activityLogs;
    public TodoTaskList(){
        tasks = new ArrayList<>();
        activityLogs = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<ActivityLog> getActivityLogs() {
        return activityLogs;
    }
}
