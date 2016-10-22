package com.example.bridgeit.autocompletetextview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mData;
    private AutoCompleteTextView mAutoCmp;
    private Button mOk;
    String[] mArray = {"Android","Java","ASP.NET","JDBC","J2EE","SQL"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOk = (Button)findViewById(R.id.button);
        mData = (TextView)findViewById(R.id.text);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,mArray);
        mAutoCmp = (AutoCompleteTextView)findViewById(R.id.auto_cmp);
        //begin searching from 1st char
        mAutoCmp.setThreshold(1);

        //setting the adapter data into the AutoCompleteTextView
        mAutoCmp.setAdapter(adapter);
        mAutoCmp.setTextColor(Color.RED);

        //Display the selected item in toast
        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, mAutoCmp.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
