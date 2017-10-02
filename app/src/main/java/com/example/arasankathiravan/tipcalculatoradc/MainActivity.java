package com.example.arasankathiravan.tipcalculatoradc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button fifteenPercent;
    Button twentyPercent;
    Button twentyFivePercent;
    TextView total;
    EditText totalBillAmount;

    Double money;
    Double totalWithTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        totalBillAmount = (EditText)findViewById(R.id.totalBillAmount);
        fifteenPercent = (Button)findViewById(R.id.fifteenPercent);
        twentyPercent = (Button)findViewById(R.id.twentyPercent);
        twentyFivePercent = (Button)findViewById(R.id.twentyFivePercent);
        total = (TextView)findViewById(R.id.total);

        totalWithTip = 1.00;

        fifteenPercent.setOnClickListener(this);
        twentyPercent.setOnClickListener(this);
        twentyFivePercent.setOnClickListener(this);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        money = Double.parseDouble(totalBillAmount.getText().toString());

        if (view.getId() == fifteenPercent.getId()){
            totalWithTip = money * .15;
            totalWithTip = Math.round(totalWithTip *100.0) / 100.0;
            total.setText("$" +totalWithTip.toString());
        }

        if (view.getId() == twentyPercent.getId()){
            totalWithTip = money * .2;
            totalWithTip = Math.round(totalWithTip *100.0) / 100.0;
            total.setText("$" + totalWithTip.toString());
        }

        if (view.getId() == twentyFivePercent.getId()){
            totalWithTip = money * .25;
            totalWithTip = Math.round(totalWithTip *100.0) / 100.0;
            total.setText("$" + totalWithTip.toString());
        }
    }
}
