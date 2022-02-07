package ru.arizara.pets.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.arizara.pets.R;

public class MyCardHolder extends RecyclerView.ViewHolder{

    public TextView name;
    public TextView kind;
    public ImageView imageView;
    public Button btn_delete;
    public Button btn_des;

    public MyCardHolder(@NonNull View itemView) {
        super(itemView);
        // получение всех элементов
        name = (TextView) itemView.findViewById(R.id.card_item_text);
        kind = (TextView) itemView.findViewById(R.id.card_item_secondary_text);
        imageView = (ImageView) itemView.findViewById(R.id.card_item_icon);
        btn_des = (Button) itemView.findViewById(R.id.card_btn_des);
        btn_delete = (Button) itemView.findViewById(R.id.card_btn_delete);

    }
}
