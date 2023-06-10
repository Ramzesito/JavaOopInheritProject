package ru.netology.oop;

public class Meeting extends Task {

    private String topic;
    private String project;
    private String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        if (query.length() == 0) {
            return false;
        }
        return (topic.contains(query) || project.contains(query) || start.contains(query));
    }
}
