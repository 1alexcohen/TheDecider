package com.fate.thedecider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;


public class DiceRoll extends ActionBarActivity {

    private int numDice = 1;
    private TextView resultText1;
    private TextView resultText2;
    private TextView resultText3;
    private TextView resultText4;
    private TextView resultText5;
    private TextView resultText6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_roll);

        resultText1 = (TextView) findViewById(R.id.result_text1);
        resultText2 = (TextView) findViewById(R.id.result_text2);
        resultText3 = (TextView) findViewById(R.id.result_text3);
        resultText4 = (TextView) findViewById(R.id.result_text4);
        resultText5 = (TextView) findViewById(R.id.result_text5);
        resultText6 = (TextView) findViewById(R.id.result_text6);

        showNumbers();
        hideNumbers();
    }

    private void hideNumbers() {
        switch (numDice + 1) {
            case 1:
                resultText1.setVisibility(View.INVISIBLE);
            case 2:
                resultText2.setVisibility(View.INVISIBLE);
            case 3:
                resultText3.setVisibility(View.INVISIBLE);
            case 4:
                resultText4.setVisibility(View.INVISIBLE);
            case 5:
                resultText5.setVisibility(View.INVISIBLE);
            case 6:
                resultText6.setVisibility(View.INVISIBLE);
            case 7:
                break;
        }
    }

    private void showNumbers() {
        resultText1.setVisibility(View.VISIBLE);
        resultText2.setVisibility(View.VISIBLE);
        resultText3.setVisibility(View.VISIBLE);
        resultText4.setVisibility(View.VISIBLE);
        resultText5.setVisibility(View.VISIBLE);
        resultText6.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dice_roll, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_set_dice) {
            final CharSequence[] items = {"1", "2", "3", "4", "5", "6"};

            new AlertDialog.Builder(this)
                    .setTitle(R.string.set_dice_dialog_title)
                    .setItems(items, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int item) {
                            numDice = Integer.parseInt(items[item].toString());
                            showNumbers();
                            hideNumbers();
                        }
                    })
                    .show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void rollDice(View view) {
        Random random = new Random();

        resultText1.setText(getResources().getString(R.string.die1) + " " + (random.nextInt(6) + 1));
        resultText2.setText(getResources().getString(R.string.die2) + " " + (random.nextInt(6) + 1));
        resultText3.setText(getResources().getString(R.string.die3) + " " + (random.nextInt(6) + 1));
        resultText4.setText(getResources().getString(R.string.die4) + " " + (random.nextInt(6) + 1));
        resultText5.setText(getResources().getString(R.string.die5) + " " + (random.nextInt(6) + 1));
        resultText6.setText(getResources().getString(R.string.die6) + " " + (random.nextInt(6) + 1));
    }
}
