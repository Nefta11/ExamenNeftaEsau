package com.example.examenneftaesau;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private EditText edtNumber;
    private Button btnMultiply;
    private ListView lvResults;
    private ArrayAdapter<String> adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber = findViewById(R.id.edt_number);
        btnMultiply = findViewById(R.id.btn_multiply);
        lvResults = findViewById(R.id.lv_results);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvResults.setAdapter(adapter);

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el número ingresado por el usuario
                String numberText = edtNumber.getText().toString();
                int number = Integer.parseInt(numberText);

                // Limpiar la lista de resultados
                adapter.clear();

                // Realizar la multiplicación y agregar resultados a la lista
                for (int i = 1; i <= 10; i++) {
                    int result = number * i;
                    adapter.add(number + " x " + i + " = " + result);
                }
            }
        });
    }
}
