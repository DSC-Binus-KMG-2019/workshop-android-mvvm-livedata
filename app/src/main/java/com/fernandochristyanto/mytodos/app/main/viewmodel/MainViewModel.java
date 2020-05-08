package com.fernandochristyanto.mytodos.app.main.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fernandochristyanto.mytodos.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Todo>> _todos = new MutableLiveData<>();
    
    public LiveData<List<Todo>> getTodos() {
        return _todos;
    }
    
    public void addTodo(final Todo todo){
        List<Todo> existing;
        if(_todos.getValue() == null) existing = new ArrayList<>();
        else existing = new ArrayList<>(_todos.getValue());
        existing.add(todo);
        _todos.postValue(existing);
    }
}
