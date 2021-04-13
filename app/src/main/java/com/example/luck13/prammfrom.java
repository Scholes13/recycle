package com.example.luck13;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class prammfrom extends AppCompatActivity {
    Button btnSave, btnHapus;
    EditText etNama, etNim, etPhone, etEmail, etPassword;
    RadioButton rbPria, rbWanita;
    CheckBox amcc, himsi, koma;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prammfrom);

        //inisiasi
        btnSave = (Button) findViewById(R.id.btnSave);
        btnHapus = (Button) findViewById(R.id.btnHapus);
        etNama = (EditText) findViewById(R.id.etNama);
        etNim = (EditText) findViewById(R.id.etNIM);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        rbPria = (RadioButton) findViewById(R.id.rbPria);
        rbWanita = (RadioButton) findViewById(R.id.rbWanita);
        amcc = (CheckBox) findViewById(R.id.amcc);
        himsi = (CheckBox) findViewById(R.id.himsi);
        koma = (CheckBox) findViewById(R.id.koma);
        spinner = (Spinner) findViewById(R.id.spinner);

        btnSave.setOnClickListener((View.OnClickListener) v -> {

            //Action Inputan
            String inputnama = String.valueOf(etNama.getText().toString());
            String inputnim = String.valueOf(etNim.getText().toString());
            String inputemail = String.valueOf(etNim.getText().toString());
            String inputphone = String.valueOf(etPhone.getText().toString());
            String inputprodi = String.valueOf(spinner.getSelectedItem().toString());
            String jk;
            if (rbPria.isChecked()) {
                jk = "Pria";
            } else {
                jk = "Wanita";
            }
            String UKM = " ";
            if (amcc.isChecked()) {
                UKM += "AMCC \n";
            }
            if (himsi.isChecked()) {
                UKM += "HIMSI \n";
            }
            if (koma.isChecked()) {
                UKM += "KOMA \n";
            }
            //Proses pengiriman data ke outputform
            Intent myIntent = new Intent(prammfrom.this, outputform.class);
            Bundle paket = new Bundle();
            paket.putString("Nama", inputnama);
            paket.putString("nim", inputnim);
            paket.putString("email", inputemail);
            paket.putString("hp", inputphone);
            paket.putString("prodi", inputprodi);
            paket.putString("jenkel", jk);
            paket.putString("UKM", UKM);
            myIntent.putExtras(paket);
            startActivity(myIntent);

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
                    if (etPassword.getText().toString().length() == -0) {
                        etPassword.setError("Password Tidak Boleh Kosong");
                    } else {
                        Toast.makeText(prammfrom.this, "Passowrd Berhasil", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
}
