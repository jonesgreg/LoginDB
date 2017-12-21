package com.example.gregoryjones.logindb;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;

public class myLoginActivity extends AppCompatActivity {


    public static final String RESULT_TAG = "result_tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        File databaseFile = getDatabasePath(TableItems.DB_NAME_FULL);
        final SQLiteDatabase database =  SQLiteDatabase.openOrCreateDatabase(databaseFile,null);

        Button bt = (Button) findViewById(R.id.button);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText username_block = (EditText) findViewById(R.id.editText_name);
                    EditText password_block = (EditText) findViewById(R.id.editText_pwd);
                    String username_value = username_block.getText().toString();
                    String password_value = password_block.getText().toString();

                    Cursor cursor = database.rawQuery("select * from login where USERNAME = ? and PASSWORD = ?", new String[]{username_value, password_value});
                    boolean result = false;

                    if (cursor != null) {
                        if (cursor.moveToNext()) {
                            result = true;


                        } Log.e(RESULT_TAG, "SUCCESSSFULLY LOGGGIN");
                        cursor.close();

                        Intent intent = new Intent();
                        intent.putExtra(RESULT_TAG, result);
                        setResult(RESULT_OK, intent);
                        finish();
                        Toast.makeText(myLoginActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(myLoginActivity.this, "Failed Login", Toast.LENGTH_SHORT).show();

                    }
                }

            });
       }

}
