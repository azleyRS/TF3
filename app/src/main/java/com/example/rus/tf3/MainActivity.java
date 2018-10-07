package com.example.rus.tf3;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Реализовать добавление тестовых работников
                 */
                adapter.addWorker(WorkerGenerator.generateWorker());
            }
        });


        /**
         * Реализовать адаптер, выбрать любой LayoutManager и прикрутить это всё к RecyclerView
         *
         * Тестовые данные для отображения генерятся WorkerGenerator
         */
    }

    private void init() {
        recyclerView  = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        adapter = new MyAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        MyItemTouchHelperCallback myItemTouchHelperCallback = new MyItemTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(myItemTouchHelperCallback);
        touchHelper.attachToRecyclerView(recyclerView);
        MyItemDecoration itemDecoration = new MyItemDecoration(this, R.dimen.item_space);
        recyclerView.addItemDecoration(itemDecoration);
    }
}
