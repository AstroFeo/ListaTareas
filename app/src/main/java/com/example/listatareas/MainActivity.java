package com.example.listatareas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox[] tareas;
    private Button[] botonesEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tareas = new CheckBox[]{
                findViewById(R.id.tarea),
                findViewById(R.id.tarea2),
                findViewById(R.id.tarea3),
                findViewById(R.id.tarea4),
                findViewById(R.id.tarea5)
        };

        botonesEliminar = new Button[]{
                findViewById(R.id.x),
                findViewById(R.id.x2),
                findViewById(R.id.x3),
                findViewById(R.id.x4),
                findViewById(R.id.x5)
        };
        for(Button x : botonesEliminar) {
            x.setVisibility(View.INVISIBLE);
            x.setEnabled(false);
        }

        for (int i = 0; i < tareas.length; i++) {
            int index = i;

            tareas[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tareas[index].isChecked()) {
                        botonesEliminar[index].setEnabled(true);
                        botonesEliminar[index].setVisibility(View.VISIBLE);
                    } else {
                        botonesEliminar[index].setEnabled(false);
                        botonesEliminar[index].setVisibility(View.INVISIBLE);
                    }
                }
            });
        }

        for (int i = 0; i < botonesEliminar.length; i++) {
            int index = i;
            botonesEliminar[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Tarea Eliminada", Toast.LENGTH_SHORT).show();
                    tareas[index].setVisibility(View.INVISIBLE);
                    botonesEliminar[index].setVisibility(View.INVISIBLE);
                }
            });
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
