package com.fernandochristyanto.mytodos.app.main.screens.addtodo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fernandochristyanto.mytodos.R;
import com.fernandochristyanto.mytodos.app.main.viewmodel.MainViewModel;
import com.fernandochristyanto.mytodos.model.Todo;

import java.lang.ref.WeakReference;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddTodoScreen extends Fragment {
    private MainViewModel mainViewModel;
    
    @BindView (R.id.et_task_name)
    EditText etTaskName;
    @BindView (R.id.btn_add)
    Button btnAddTodo;
    
    public static Fragment newInstance () {
        return new AddTodoScreen();
    }
    
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.screen_add_todo, container, false);
        ButterKnife.bind(this, view);
        
        // Get viewmodel from provider
        mainViewModel = new ViewModelProvider(Objects.requireNonNull(this.getActivity())).get(MainViewModel.class);
        
        // Initialize listeners
        btnAddTodo.setOnClickListener(new OnButtonAddClickedListener(etTaskName, mainViewModel));
        return view;
    }
    
    static class OnButtonAddClickedListener implements View.OnClickListener {
        private WeakReference<EditText> etTaskName;
        private WeakReference<MainViewModel> mainViewModel;
        
        OnButtonAddClickedListener (EditText etTaskName, MainViewModel mainViewModel) {
            this.etTaskName = new WeakReference<>(etTaskName);
            this.mainViewModel = new WeakReference<>(mainViewModel);
        }
        
        @Override
        public void onClick (View view) {
            String taskName = etTaskName.get().getText().toString();
            mainViewModel.get().addTodo(new Todo(taskName));
            
            etTaskName.get().setText("");
        }
    }
}
