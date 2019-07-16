package com.example.cursos.veranoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre,edad;
    Spinner genero;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.txtNombre);
        edad= findViewById(R.id.txtEdad);
        agregar=findViewById(R.id.btnAdd);
        genero=(Spinner) findViewById(R.id.spinnerGenero);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource( this, R.array.array_spinner,R.layout.support_simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genero.setAdapter(adapter);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnAdd:

                        if(nombre.getText().toString().trim().length()==0)
                            nombre.setError("Nombre Requerido");

                        if(edad.getText().toString().trim().length()==0)
                            edad.setError("Edad Requerida");

                        Toast.makeText(MainActivity.this, nombre.getText().toString()+"\n"+edad.getText().toString()+"\n"+genero.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                        clean();
                        break;
                }
            }
        });

    }

    private void clean(){
        nombre.setText("");
        edad.setText("");
        genero.setSelection(0);
    }
}
