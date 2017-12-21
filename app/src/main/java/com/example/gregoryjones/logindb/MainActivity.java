package com.example.gregoryjones.logindb;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_CODE = 2;




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
        //***THIS CODE CRASHES THE APP
        SQLiteDatabase database = null;


        DBOpenHelper dbhelper = new DBOpenHelper(this);
        database = dbhelper.getWritableDatabase();
        Toast.makeText(this, "DB has been created", Toast.LENGTH_SHORT).show();

      /*  Cursor cursor = database.query(TableItems.TABLE_NAME, TableItems.ALL_COL,null,null,null,null,null);
        StringBuilder result = new StringBuilder();

        while (cursor.moveToNext()){
            result.append(cursor.getString(cursor.getColumnIndex(TableItems.COL_ID))+ " ");
            result.append(cursor.getString(cursor.getColumnIndex(TableItems.COL_PWD))+ " ");
            result.append(cursor.getInt(cursor.getColumnIndex(TableItems.COL_NAME))+ "\n ");

        }

        TextView tv = (TextView) findViewById(R.id.tvdisplay);
        tv.setText(result.toString());*/


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
        switch(item.getItemId()) {
            case R.id.action_Settings:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
        } switch (item.getItemId()) {
            case R.id.action_Login:
                Intent intent = new Intent(MainActivity.this, myLoginActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

        } switch (item.getItemId()) {
            case R.id.action_Register:
                Intent intent = new Intent(MainActivity.this, myRegisterActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data.getBooleanExtra(myLoginActivity.RESULT_TAG, false)) {

            }

        }


    }



}