package com.fernandochristyanto.mytodos.app.main.screens.todolist;

import androidx.recyclerview.widget.DiffUtil;

import com.fernandochristyanto.mytodos.model.Todo;

import java.util.List;

public class TodosDiffCallback extends DiffUtil.Callback {
    private final List<Todo> oldList;
    private final List<Todo> newList;
    
    TodosDiffCallback (List<Todo> oldList, List<Todo> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }
    
    @Override
    public int getOldListSize () {
        return oldList.size();
    }
    
    @Override
    public int getNewListSize () {
        return newList.size();
    }
    
    @Override
    public boolean areItemsTheSame (int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getTaskName().equals(newList.get(newItemPosition).getTaskName());
    }
    
    @Override
    public boolean areContentsTheSame (int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}