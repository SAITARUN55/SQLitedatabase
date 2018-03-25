package com.example.saitarun.sqlitedatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_age;
    ContentValues values=new ContentValues();
    DatabaseHelper1 databaseHelper1;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         et_name=(EditText)findViewById(R.id.et_user);
        et_age=(EditText)findViewById(R.id.et_age);
        result=(TextView)findViewById(R.id.textView);
        databaseHelper1=new DatabaseHelper1(MainActivity.this);

    }

    public void saveData(View view) {
        String name=et_name.getText().toString();
        int age=Integer.parseInt(et_age.getText().toString());


        values.put(DatabaseHelper1.COLUMN_1,name);
        values.put(DatabaseHelper1.COLUMN_2,age);
        long i=databaseHelper1.insertData(values);
        if(i!=-1){
            Toast.makeText(this, "ROW INSERTED", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "INSERTION FAILURE", Toast.LENGTH_SHORT).show();
        }

    }

    public void retreive(View view) {
        Cursor c=databaseHelper1.retreiveData();
        if(c!=null){
            StringBuffer sb=new StringBuffer();
            c.moveToFirst();
            do {
                sb.append(c.getString(1)+":"+c.getInt(2)+"\n");
            }while (c.moveToNext());

            result.setText(sb.toString());
        }
        else {
            Toast.makeText(this, "No Information is retrieved", Toast.LENGTH_SHORT).show();
        }
    }
}
