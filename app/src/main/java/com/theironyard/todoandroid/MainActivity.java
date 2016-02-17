package com.theironyard.todoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> items;

    ListView list;
    EditText text;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) { // equivilent to main method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activities are like ios panels

        list = (ListView) findViewById(R.id.listView); // same as FMXL
        text = (EditText) findViewById(R.id.editText); // same as FMXL
        addButton = (Button) findViewById(R.id.button); // same as FMXL

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);// android.r are assests built into android
        list.setAdapter(items);

        addButton.setOnClickListener(this); // go to appcompactactivity to add implements
        list.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String item = text.getText().toString();
        items.add(item);
        text.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }
}
