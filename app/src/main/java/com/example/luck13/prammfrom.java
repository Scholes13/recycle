package com.example.luck13;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.Normalizer;

public class prammfrom extends AppCompatActivity {
    Button btnSave, btnHapus;
    EditText etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prammfrom);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(prammfrom.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
        btnHapus = findViewById(R.id.btnHapus);
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(prammfrom.this);
                //untuk membuat tittle
                alertDialogBuilder.setTitle("Peringatan Data Anda Akan Di Hapus !!");
                //Buat Pesan
                alertDialogBuilder.setMessage(" Apakah anda yakin untuk menghapus data ?")
                        .setIcon(R.drawable.logoamikom)
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Data Terhapus", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                // Untuk Buat Dialognya
                AlertDialog alertDialog = alertDialogBuilder.create();
                // Untuk menampilkan
                alertDialog.show();
            }
        });
        etPassword = findViewById(R.id.etPassword);
        etPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPassword.getText().toString().length()==-0){
                    etPassword.setError("Password Tidak Boleh Kosong");
                }else {
                    Toast.makeText(prammfrom.this,"Passowrd Berhasil",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
