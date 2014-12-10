package com.fate.thedecider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            showAbout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void launchCoinFlip(View view) {
        startActivity(new Intent(getApplicationContext(), CoinFlip.class));
    }

    public void launchDiceRoll(View view) {
        startActivity(new Intent(getApplicationContext(), DiceRoll.class));
    }

    public void launchDrawNames(View view) {
        startActivity(new Intent(getApplicationContext(), DrawNames.class));
    }

    public void showAbout() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.about_dialog_title)
                .setMessage(R.string.about)
                .show();
    }


}
