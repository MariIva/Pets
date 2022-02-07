package ru.arizara.pets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ru.arizara.pets.adapters.MyCardAdapter;
import ru.arizara.pets.adapters.MyCardHolder;
import ru.arizara.pets.adapters.MyListAdapter;
import ru.arizara.pets.classes.Pets;

public class MainActivity extends AppCompatActivity {
    private List<Pets> pets = new ArrayList<>();

    RecyclerView rv;
    CheckBox cb;
    FloatingActionButton button;
    MyCardAdapter cardAdapter;
    MyListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pets.addAll(Pets.createList());

        cb = (CheckBox) findViewById(R.id.checkBox);
        button = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        initRecyclerView();

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setManagerAndAdapter();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( !cb.isChecked()) {
                    listAdapter.addItems(Pets.createList());
                }
                else{
                    cardAdapter.addItems(Pets.createList());
                }
            }
        });
    }

    private void initRecyclerView() {
        rv = findViewById(R.id.rv);
        setManagerAndAdapter();
    }
    private void setManagerAndAdapter() {
        if ( !cb.isChecked()) {
            // способ отображения списка в столбик
            rv.setLayoutManager(new LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL, false));
            // создание и устанвока адаптера
            listAdapter = new MyListAdapter(this);
            listAdapter.setItems(pets);
            rv.setAdapter(listAdapter);
        }
        else{
            // способ отображения списка в таблице
            rv.setLayoutManager(new GridLayoutManager(this, 2,
                    GridLayoutManager.VERTICAL, false));
            // создание и устанвока адаптера
            cardAdapter = new MyCardAdapter(this);
            cardAdapter.setItems(pets);
            rv.setAdapter(cardAdapter);
        }

    }
}