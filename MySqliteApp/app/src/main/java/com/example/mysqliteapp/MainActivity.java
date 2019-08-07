package com.example.mysqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText mName, mEmail,mID;
Button mBtnSave, mBtnview , mBtnDelete;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.editname);
        mEmail = findViewById(R.id.editEmail);
        mID = findViewById(R.id.editID);

        mBtnSave = findViewById(R.id.btnSave);
        mBtnview = findViewById(R.id.btnView);
        mBtnDelete =  findViewById(R.id.btnDel);

        //creating database
        db = openOrCreateDatabase("Users" , MODE_PRIVATE , null);
        //create a table
        db.execSQL("CREATE TABLE IF NOT EXISTS  majina(name VARCHAR , email VARCHAR , id_number VARCHAR)");

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //receive data
                String jina = mName.getText().toString();
                String arafa = mEmail.getText().toString();
                String kitambulisho = mID.getText().toString().trim();

                if(jina.isEmpty() || arafa.isEmpty() || kitambulisho.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill in the information required", Toast.LENGTH_SHORT).show();
                }else{
                    db.execSQL("INSERT INTO majina VALUES ('"+jina+"', ' "+arafa+" ' , '"+kitambulisho+"')");
                    Toast.makeText(MainActivity.this, "User saved successfully", Toast.LENGTH_SHORT).show();
                    //clear the text
                    mName.setText(" ");
                    mEmail.setText(" ");
                    mID.setText(" ");
                }
            }
        });
    }
}
