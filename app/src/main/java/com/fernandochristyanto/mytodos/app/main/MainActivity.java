package com.fernandochristyanto.mytodos.app.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.fernandochristyanto.mytodos.R;
import com.fernandochristyanto.mytodos.app.main.screens.addtodo.AddTodoScreen;
import com.fernandochristyanto.mytodos.app.main.screens.todolist.TodoListScreen;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.layout_top, AddTodoScreen.newInstance())
                .add(R.id.layout_bottom, TodoListScreen.newInstance())
                .commit();
    }
}
