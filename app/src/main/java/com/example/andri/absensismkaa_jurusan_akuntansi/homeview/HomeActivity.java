package com.example.andri.absensismkaa_jurusan_akuntansi.homeview;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.andri.absensismkaa_jurusan_akuntansi.AboutActivity;
import com.example.andri.absensismkaa_jurusan_akuntansi.AbsensiActivity;
import com.example.andri.absensismkaa_jurusan_akuntansi.R;
import com.example.andri.absensismkaa_jurusan_akuntansi.listview.JadwalActivity;

public class HomeActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }




    public void onClickBuku(View view){
        Intent intent = new Intent(this,AbsensiActivity.class);
        startActivity(intent);

    }

    public void onClicklab(View view){
        Intent intent = new Intent(this, JadwalActivity.class);
        startActivity(intent);
    }

    public void onClickoter(View view){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        //Checking for fragment count on backstack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this,"Please click BACK again to exit apps.", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();
            return;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.absen:
                //TODO order apps
                Intent intent = new Intent(this, AbsensiActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                //TODO about apps
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                break;
            case R.id.exit:
                //TODO exit apps
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Anda yakin mau keluar ?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog quit = builder.create();
                quit.show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
