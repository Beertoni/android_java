package com.example.aplicacaoconsumirapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aplicacaoconsumirapi.config.RetrofitConfig;
import com.example.aplicacaoconsumirapi.model.User;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void irPraSegundaTela(View view) {

        EditText editText = findViewById(R.id.edicao);

        String numero = editText.getText().toString();

        RetrofitConfig retrofitConfig = new RetrofitConfig();

        final TextView tv = findViewById(R.id.texto);

        Call<User> users = retrofitConfig.getUserService()
                .buscarUsuarioPorId(numero);

        users.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if(user == null){
                    tv.setText("USUARIO NAO ENCONTRADO\n" +
                            "TENTE UM DIFERENTE!");
                }else{
                    tv.setText("ID: " + user.getId() + "\n" + "NAME: " + user.getName()  + "\n" + "AGE: " + user.getAge() + "\n" + "JOB: " + user.getJob());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                tv.setText("USUARIO NAO ENCONTRADO\n" +
                        "TENTE UM DIFERENTE!");
            }
        });
    }
}
