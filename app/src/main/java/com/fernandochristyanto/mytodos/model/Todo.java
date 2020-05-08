package com.fernandochristyanto.mytodos.model;

import androidx.annotation.Nullable;

public class Todo {
    private Todo(){}
    
    public Todo (String taskName) {
        this.taskName = taskName;
    }
    
    private String taskName;
    
    public String getTaskName () {
        return taskName;
    }
    
    public void setTaskName (String taskName) {
        this.taskName = taskName;
    }
    
    @Override
    public boolean equals (@Nullable Object obj) {
        if(!(obj instanceof Todo))
            throw new IllegalArgumentException();
        
        final Todo other = (Todo) obj;
        return this.getTaskName().equals(other.getTaskName());
    }
}
