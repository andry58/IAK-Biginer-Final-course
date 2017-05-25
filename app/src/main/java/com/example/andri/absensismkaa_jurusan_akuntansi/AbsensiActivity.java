package com.example.andri.absensismkaa_jurusan_akuntansi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;


public class AbsensiActivity extends AppCompatActivity {



    private RadioGroup radioGroupNb;
    private RadioButton radioGroup;


    EditText mTextNama;

    Button mButtonKirim;


    Spinner mSpinnerHari;
    List<String> mListHari = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        radioGroupNb= (RadioGroup)
                findViewById(R.id.radioGroupNb);


        mTextNama = (EditText) findViewById(R.id.mTextNama);

        mButtonKirim = (Button) findViewById(R.id.mButtonKirim);


        mSpinnerHari = (Spinner) findViewById(R.id.mSpinnerHari);
        mListHari.add("-------");
        mListHari.add("Senin");
        mListHari.add("Selasa");
        mListHari.add("Rabu");
        mListHari.add("KAmis");
        mListHari.add("Jum'at");
        mListHari.add("Sabtu");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mListHari);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerHari.setAdapter(dataAdapter);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }



        public void onClickkrim(View view){
            int selectedId = radioGroupNb.getCheckedRadioButtonId();

            radioGroup = (RadioButton) findViewById(selectedId);
            String to = "andriyansyah58@gmail.com";
        String subject = "Bahwa siswa yang bernama "+mTextNama.getText().toString();
        String message = "keterangan :pada hari "
                           + mSpinnerHari.getSelectedItem()
                +"  Bahwa Keterangannya siswa Tersebut "
                +   radioGroup.getText();




        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Kirim email dengan"));
    }

    public void onClickReset(View v) {

        mTextNama.setText("");

    }


}
