package com.fate.thedecider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;


public class DrawNames extends ActionBarActivity {

    private boolean replacement = true;
    private ArrayList<String> names;
    private String pickedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_names);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_draw_names, menu);
        menu.findItem(R.id.replace_names).setChecked(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        item.setChecked(true);

        //noinspection SimplifiableIfStatement
        if (id == R.id.remove_names) {
            replacement = false;
        } else if (id == R.id.replace_names) {
            replacement = true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void enterNames(View view) {
        TextView textView = (TextView) findViewById(R.id.text_field);
        String rawText = textView.getText().toString();

        if (rawText.length() > 0) {
            names = new ArrayList<>(Arrays.asList(rawText.split(",")));

            for (int i = 0; i < names.size(); i++) {
                names.set(i, names.get(i).trim());
            }

            getName();
            showDialog();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), R.string.nothing_entered, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void showDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.name_drawn_dialog)
                .setMessage(pickedName)
                .setPositiveButton(R.string.draw_name_dialog_positive, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        getName();
                        showDialog();
                    }
                })
                .setNegativeButton(R.string.draw_name_diallog_negative, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                })
                .show();
    }

    public void resetList(View view) {
        TextView textView = (TextView) findViewById(R.id.text_field);
        textView.setText("");
    }

    public void getName() {
        Random random = new Random();

        if (names.size() == 0) {
            pickedName = getResources().getString(R.string.exhausted);
        } else {
            int index = random.nextInt(names.size());
            pickedName = names.get(index);

            if (!replacement) {
                names.remove(index);
            }
        }
    }
}
