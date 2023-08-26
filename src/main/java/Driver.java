import domain.ActivityLog;
import domain.Task;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        try {
            TodoTaskTrackingSystem taskTrackingSystem = new TodoTaskTrackingSystem();
            int userId1 = taskTrackingSystem.createUser("Saurabh");
            int userId2 = taskTrackingSystem.createUser("Atul");

            Task t1 = new Task(Arrays.asList("Tag1", "Tag2"), new Date());
            Task t2 = new Task(Arrays.asList("Tag3", "Tag4"), new Date());
            Task t3 = new Task(Arrays.asList("Tag6", "Tag6"), new Date());

            int u1t1 = 0, u1t2 = 0, u2t1 = 0, u2t2 = 0;

            u1t1 = taskTrackingSystem.addTask(userId1, t1);
            u1t2 = taskTrackingSystem.addTask(userId1, t2);


            u2t1 = taskTrackingSystem.addTask(userId2, t2);
            u2t2 = taskTrackingSystem.addTask(userId2, t3);

            List<Task> allTasks = taskTrackingSystem.listTasks(2);
            System.out.println("Listing all tasks for user 2:\n" + allTasks);


            Task task = null;
            task = taskTrackingSystem.getTask(userId1, u1t1);
            System.out.println("Printing the task: \n" + task);

            Task modTask = new Task(Arrays.asList("Tag9"), new Date());
            modTask.setUserId(1);
            modTask.setTaskId(u1t1);
            taskTrackingSystem.modifyTask(modTask);
            task = taskTrackingSystem.getTask(userId1, u1t1);

            System.out.println("Printing the task after modification: \n" + task);



            allTasks = taskTrackingSystem.listTasks(1);
            System.out.println("Listing all tasks for user 1:\n" + allTasks);


            taskTrackingSystem.removeTask(1, 1);

            allTasks = taskTrackingSystem.listTasks(1);
            System.out.println("Listing all tasks for user 1 after removal:\n" + allTasks);

            List<ActivityLog> activityLogs = taskTrackingSystem
                    .getActivityLog(1, new Date(new Date().getTime() - (1000 * 60 * 60 * 24)), new Date());
            System.out.println("Printing activity log for user 1:\n" + activityLogs);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
