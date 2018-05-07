package id.kuis_rahman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    SharedPreferences session;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        session= getSharedPreferences("JAKS", Context.MODE_PRIVATE);

        TextView txtId= findViewById(R.id.ID);
        TextView txtKeluar= findViewById(R.id.txtKeluar);

        Button btnCekSaldo= findViewById(R.id.btnCekSaldo);
        Button btnTransfer= findViewById(R.id.btnTransfer);

        txtId.setText(session.getString("ID", ""));

        btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Transfer.class));
                finish();
            }
        });

        txtKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor= session.edit();

                editor.clear();
                editor.commit();
                startActivity(new Intent(Home.this, MainActivity.class));
                finish();
            }
        });

        btnCekSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Cek_Saldo.class));
                finish();
            }
        });
    }
}
