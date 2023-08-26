package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
    int taskId;
    List<String> tags;
    Date deadline;
    Date startDate;
    int userId;
    TaskStatus status;

    public Task(List<String> tags, Date deadline){
        this.tags = new ArrayList<>();
        this.tags.addAll(tags);
        this.deadline = deadline;
        this.status = TaskStatus.PENDING;
    }

    public Task(int taskId, List<String> tags, Date deadline, int userId){
        this.taskId = taskId;
        this.tags = new ArrayList<>();
        this.tags.addAll(tags);
        this.deadline = deadline;
        this.userId = userId;
        this.status = TaskStatus.PENDING;
    }

    public Task(int taskId, List<String> tags, Date deadline, Date startDate, int userId){
        this.taskId = taskId;
        this.tags = new ArrayList<>();
        this.tags.addAll(tags);
        this.deadline = deadline;
        this.startDate = startDate;
        this.userId = userId;
        this.status = TaskStatus.PENDING;
    }

    public void setFromTask(Task t){
        this.tags = new ArrayList<>();
        this.tags.addAll(t.getTags());
        this.deadline = t.deadline;
        this.startDate = t.startDate;
        this.status = t.status;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public List<String> getTags() {
        return tags;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getUserId() {
        return userId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", tags=" + tags +
                ", deadline=" + deadline +
                ", startDate=" + startDate +
                ", userId=" + userId +
                ", status=" + status +
                '}';
    }
}
