package com.example.iverson.pruebacuatro;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.iverson.pruebacuatro.adapter.PortionsAdapter;
import com.example.iverson.pruebacuatro.models.PortionFields;
import com.example.iverson.pruebacuatro.network.BackgroundFood;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PortionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.portionRv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new PortionsAdapter();

        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_food);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                ImageButton button = (ImageButton) dialog.findViewById(R.id.saveBtn);
                final EditText editText = (EditText) dialog.findViewById(R.id.nameEt);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = editText.getText().toString();
                        if (name.trim().length() > 0){
                            new BackgroundPortion().execute(name);
                        } else {
                            Toast.makeText(MainActivity.this, "Agrega tu alimento", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    private class BackgroundPortion extends BackgroundFood {
        @Override
        protected void onPostExecute(List<PortionFields> portionFieldses) {
            if (portionFieldses != null) {
                adapter.update(portionFieldses);
            }
        }
    }
}