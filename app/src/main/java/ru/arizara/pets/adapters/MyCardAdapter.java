package ru.arizara.pets.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;

import ru.arizara.pets.R;
import ru.arizara.pets.classes.Pets;

public class MyCardAdapter extends RecyclerView.Adapter<MyCardHolder>{
    private List<Pets> list;
    private Context mContext;

    public MyCardAdapter(Context context) {
        this.mContext = context;
    }
    @NonNull
    @Override
    public MyCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // создание элемента списка, если место на экране есть
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_card_item, parent, false);
        return new MyCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCardHolder holder, int position) {
        // получение отображаемого элемента
        Pets pets = list.get(position);
        // установка значений в элемент списка
        holder.name.setText(pets.name);
        holder.kind.setText(pets.kind.toString());
        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(pets.kind.draw()));

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItems(position);
            }
        });
        holder.btn_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // создание диалогового окна
                MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(mContext);
                // наполнение окна
                dialogBuilder.setMessage( pets.description );
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
    public void setItems(List<Pets> pets) {
        list=pets;
        // обновить экран
        notifyDataSetChanged();
    }

    public void addItems(List<Pets> pets) {
        list.addAll(pets);
        notifyDataSetChanged();
    }

    public void deleteItems(int i) {
        list.remove(i);
        notifyDataSetChanged();
    }
}
