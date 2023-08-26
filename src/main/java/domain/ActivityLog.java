package domain;

import java.util.Date;

public class ActivityLog {
    int taskId;
    ActivityLogTag logTag;
    Date timestamp;
    String remark;

    public ActivityLog(int taskId, ActivityLogTag logTag, String remark) {
        this.taskId = taskId;
        this.logTag = logTag;
        this.remark = remark;
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return "ActivityLog{" +
                "taskId=" + taskId +
                ", logTag=" + logTag +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
