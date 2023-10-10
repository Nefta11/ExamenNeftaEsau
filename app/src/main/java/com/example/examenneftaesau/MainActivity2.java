package com.example.examenneftaesau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText name;
    private EditText secondName;
    private EditText lastName;
    private Button save;
    private Button inicio;

    private String savedName;
    private String savedSecondName;
    private String savedLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name);
        secondName = findViewById(R.id.second_name);
        lastName = findViewById(R.id.last_name);
        save = findViewById(R.id.save);
        inicio = findViewById(R.id.inicio);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = name.getText().toString().trim();
                String inputSecondName = secondName.getText().toString().trim();
                String inputLastName = lastName.getText().toString().trim();

                if (inputName.isEmpty() || inputSecondName.isEmpty() || inputLastName.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                } else if (!inputSecondName.equals(inputLastName)) {
                    Toast.makeText(MainActivity2.this, "Los campos 'secondName' y 'lastName' no coinciden", Toast.LENGTH_SHORT).show();
                } else {
                    savedName = inputName;
                    savedSecondName = inputSecondName;
                    savedLastName = inputLastName;

                    // Aquí puedes guardar los datos en una tarea o en una base de datos
                    // Por ejemplo, puedes usar SharedPreferences o SQLite para almacenar los datos
                    // Luego, muestra un mensaje de registro exitoso

                    Toast.makeText(MainActivity2.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                }
            }
        });

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cuando se hace clic en "Iniciar Sesión", regresa a la pantalla de MainActivity
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finaliza esta actividad para no volver a ella desde la pantalla principal
            }
        });
    }
}
