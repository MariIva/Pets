package ru.arizara.pets.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

import ru.arizara.pets.R;
import ru.arizara.pets.classes.Pets;

public class MyListAdapter extends RecyclerView.Adapter<MyListHolder>{
    private List<Pets> list ;
    private Context mContext;

    public MyListAdapter(Context context) {
        this.mContext = context;
    }
    @NonNull
    @Override
    public MyListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_list_item, parent, false);
        return new MyListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListHolder holder, int position) {
        // получение отображаемого элемента
        Pets pets = list.get(position);
        // установка значений в элемент списка
        holder.name.setText(pets.name);
        holder.kind.setText(pets.kind.toString());
        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(pets.kind.draw()));

        // слушатель на клик на строку
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // создание диалогового окна
                MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(mContext);
                // наполнение окна
                dialogBuilder.setMessage( pets.description );
                dialogBuilder.setNegativeButton("Удалить", (dialog, which) -> {
                    deleteItems(position);
                });
                // показ окна
                dialogBuilder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // вспомогательные методы для обновлеия списка
    public void addItems(List<Pets> pets) {
        list.addAll(pets);
        // обновить экран
        notifyDataSetChanged();
    }
    public void setItems(List<Pets> pets) {
        list=pets;
        notifyDataSetChanged();
    }

    public void deleteItems(int i) {
        list.remove(i);
        notifyDataSetChanged();
    }
}
