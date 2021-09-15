package com.example.usodebanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<Aluno> alunos = databaseHelper.trazer();

        ListView listView = findViewById(R.id.charlinhos);

        //adaptador para pegar do banco e colocar na lista
        List<Map<String,Object>> alunosConvertido =
                new ArrayList<>();
        for(Aluno a: alunos){
            Map<String,Object> mapa = new HashMap<>();
            mapa.put("nome", a.getNome());
            mapa.put("idade", a.getIdade());
            alunosConvertido.add(mapa);
        }

        ListAdapter adaptador = new SimpleAdapter(this,
                alunosConvertido,
                R.layout.item,
                new String[]{"nome","idade"},
                new int[]{R.id.nomeItem, R.id.idadeItem});
        listView.setAdapter(adaptador);
    }

    public void voltar(View view) {
        Intent i =  new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
