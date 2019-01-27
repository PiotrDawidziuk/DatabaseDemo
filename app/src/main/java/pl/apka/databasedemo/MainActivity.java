package pl.apka.databasedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE,null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Jon', 39)");
            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Joe', 45)");
            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Ava', 23)");

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users",null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();

            while (c != null) {
                Log.i("Results - name ",c.getString(nameIndex));
                Log.i("Results - age ", Integer.toString(c.getInt(ageIndex)));
                c.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
