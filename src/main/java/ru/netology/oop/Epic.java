package ru.netology.oop;

public class Epic extends Task {

    private String[] subTasks;

    public Epic(int id, String[] subTasks) {
        super(id);
        this.subTasks = subTasks;
    }

    public String[] getSubTasks() {
        return subTasks;
    }

    @Override
    public boolean matches(String query) {
        if (query.length() == 0) {
            return false;
        }
        for (String task : subTasks) {
            if (task.contains(query)) {
                return true;
            }
        }
        return false;
    }
}

