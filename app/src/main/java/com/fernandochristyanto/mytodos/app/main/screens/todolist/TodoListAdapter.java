package com.fernandochristyanto.mytodos.app.main.screens.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandochristyanto.mytodos.R;
import com.fernandochristyanto.mytodos.model.Todo;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {
    private List<Todo> todos = Collections.emptyList();
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_todo, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position) {
        holder.bind(todos.get(position));
    }
    
    @Override
    public int getItemCount () {
        return todos.size();
    }
    
    void updateTodos (List<Todo> newTodos) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new TodosDiffCallback(this.todos, newTodos));
        this.todos = newTodos;
        diffResult.dispatchUpdatesTo(this);
    }
    
    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView (R.id.tv_task_name)
        TextView tvTaskName;
        
        ViewHolder (@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        
        void bind (Todo todo) {
            tvTaskName.setText(todo.getTaskName());
        }
    }
}
