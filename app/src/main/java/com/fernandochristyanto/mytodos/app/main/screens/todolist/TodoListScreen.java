package com.fernandochristyanto.mytodos.app.main.screens.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandochristyanto.mytodos.R;
import com.fernandochristyanto.mytodos.app.main.viewmodel.MainViewModel;
import com.fernandochristyanto.mytodos.model.Todo;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class TodoListScreen extends Fragment {
    @BindView (R.id.rv_todos)
    RecyclerView rvTodos;
    
    private MainViewModel mainViewModel;
    private TodoListAdapter todoListAdapter;
    
    public static Fragment newInstance () {
        return new TodoListScreen();
    }
    
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.screen_todo_list, container, false);
        ButterKnife.bind(this, view);
        
        mainViewModel = new ViewModelProvider(Objects.requireNonNull(this.getActivity())).get(MainViewModel.class);
        
        todoListAdapter = new TodoListAdapter();
        rvTodos.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvTodos.setAdapter(todoListAdapter);
        
        initializeListeners();
        return view;
    }
    
    private void initializeListeners () {
        mainViewModel.getTodos().observe(getViewLifecycleOwner(), new Observer<List<Todo>>() {
            @Override
            public void onChanged (List<Todo> todos) {
                Timber.i("Received new todo!");
                todoListAdapter.updateTodos(todos);
            }
        });
    }
}
