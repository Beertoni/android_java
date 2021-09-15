package com.example.usodebanco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context){
        super(context, "aula5", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE =
                "CREATE TABLE ALUNO (ID INTEGER" +
                " PRIMARY KEY AUTOINCREMENT, " +
                "NOME TEXT NOT NULL, " +
                "IDADE INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ALUNO");
        onCreate(sqLiteDatabase);
    }

    //inserir dado no banco
    public void inserir(String nome, int idade){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("NOME", nome);
        contentValues.put("IDADE", idade);
        sqLiteDatabase.insert("ALUNO", null, contentValues);
    }

    //trazer dados do banco
    public List<Aluno> trazer(){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        List<Aluno> alunos = new ArrayList<>();

        String query = "select * from ALUNO";

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        while(cursor.moveToNext()){
            Aluno aluno =  new Aluno();
            aluno.setIdade(cursor.getInt(cursor.getColumnIndex("IDADE")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("NOME")));

            alunos.add(aluno);
        }
        return alunos;
    }
}
