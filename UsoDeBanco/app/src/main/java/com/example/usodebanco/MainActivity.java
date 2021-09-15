package com.example.usodebanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void salvar(View view) {
        //identificando pelo id
        EditText nome =  findViewById(R.id.nome);
        EditText idade = findViewById(R.id.idade);

        //pegando os conteudos
        String nomeDigitado = nome.getText().toString();
        String idadeDigitada = idade.getText().toString();

        //salvar no banco
        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        databaseHelper.inserir(nomeDigitado, Integer.valueOf(idadeDigitada));

        Intent intent = new Intent(this, DetailsActivity.class);

        startActivity(intent);

        Toast.makeText(this, "Aluno inserido com sucesso!", Toast.LENGTH_SHORT).show();

    }
}
