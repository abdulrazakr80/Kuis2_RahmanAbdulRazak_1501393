package id.kuis_rahman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    SharedPreferences session;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Rahman abdul razak
        * 1501393*/

        session= getSharedPreferences("JAKS", Context.MODE_PRIVATE);


        final EditText txtID= findViewById(R.id.txtID);
        final EditText txtPassword= findViewById(R.id.txtPassword);
        Button btnRegister= findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ID= String.valueOf(txtID.getText());
                final String Password= String.valueOf(txtPassword.getText());

                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<Akun> call = apiService.buat_account(ID, Password);
                call.enqueue(new Callback<Akun>() {
                    @Override
                    public void onResponse(@NonNull Call<Akun> call, @NonNull Response<Akun> response) {
                        editor= session.edit();

                        editor.putString("ID", ID);
                        editor.putString("Password", Password);
                        editor.commit();
                        startActivity(new Intent(MainActivity.this, Home.class));
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Akun> call, Throwable t) {
                        Log.e("FK", "onFailure: ", t);
                        Toast.makeText(MainActivity.this, "Ada Yang Salah", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}
