package ru.arizara.pets.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.arizara.pets.R;

public class MyListHolder extends RecyclerView.ViewHolder{

    public TextView name;
    public TextView kind;
    public ImageView imageView;

    public MyListHolder(@NonNull View itemView) {
        super(itemView);
        // получение всех элементов
        name = (TextView) itemView.findViewById(R.id.list_item_text);
        kind = (TextView) itemView.findViewById(R.id.list_item_secondary_text);
        imageView = (ImageView) itemView.findViewById(R.id.list_item_icon);

    }
}
