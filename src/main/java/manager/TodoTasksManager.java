package manager;

import domain.*;

public class TodoTasksManager {
    public TodoTaskList createNewTaskList(){
        return new TodoTaskList();
    }
    public int addTasks(TodoTaskList tl, Task t, int userId){
        int taskId = tl.getTasks().size()+1;
        t.setTaskId(taskId);
        t.setUserId(userId);
        tl.getTasks().add(t);
        ActivityLog activityLog = new ActivityLog(t.getTaskId(), ActivityLogTag.ADDITION, "");
        tl.getActivityLogs().add(activityLog);
        return taskId;
    }
    public void modifyTask(TodoTaskList tl, Task t) throws Exception{
        try {
            Task taskFromList = tl.getTasks().stream().filter(task -> task.getTaskId() == t.getTaskId()).findFirst().get();
            taskFromList.setFromTask(t);
            ActivityLog activityLog = new ActivityLog(t.getTaskId(), ActivityLogTag.MODIFICATION, "");
            tl.getActivityLogs().add(activityLog);
        }
        catch (Exception ex){
            throw new Exception("Exception while modifying. "+ex.getMessage());
        }
    }
    public void markTaskCompleted(TodoTaskList tl, int taskId) throws Exception{
        try {
            Task taskFromList = tl.getTasks().stream().filter(task -> task.getTaskId() == taskId).findFirst().get();
            taskFromList.setStatus(TaskStatus.COMPLETED);
            removeTask(tl, taskId);
            ActivityLog activityLog = new ActivityLog(taskId, ActivityLogTag.COMPLETED, "");
            tl.getActivityLogs().add(activityLog);
        }
        catch (Exception ex){
            throw new Exception("Exception while modifying. "+ex.getMessage());
        }
    }
    public void removeTask(TodoTaskList tl, int taskId) throws Exception {
        try {
            Task taskFromList = tl.getTasks().stream().filter(task -> task.getTaskId() == taskId).findFirst().get();
            tl.getTasks().remove(taskFromList);
            ActivityLog activityLog = new ActivityLog(taskId, ActivityLogTag.REMOVAL, "");
            tl.getActivityLogs().add(activityLog);
        }
        catch (Exception ex){
            throw new Exception("Exception while removal. "+ex.getMessage());
        }
    }
}
