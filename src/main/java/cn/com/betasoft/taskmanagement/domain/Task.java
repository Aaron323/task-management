package cn.com.betasoft.taskmanagement.domain;


import java.util.Date;

public class Task {
    private Long id;
    private String name;
    private Date startTime;
    private Date stopTime;
    private Integer duration;
    private Integer progress;
    private Integer priority;
    private Long resourceId;

    public Task() {
    }

    public Task(Long id, String name, Date startTime, Date stopTime, Integer duration, Integer progress, Integer priority, Long resourceId) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.duration = duration;
        this.progress = progress;
        this.priority = priority;
        this.resourceId = resourceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", stopTime=" + stopTime +
                ", duration=" + duration +
                ", progress=" + progress +
                ", priority=" + priority +
                ", resourceId=" + resourceId +
                '}';
    }
}
