package pl.apka.databasedemo;

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
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Events", MODE_PRIVATE,null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR, year INT(4))");

            sqLiteDatabase.execSQL("INSERT INTO events (name, year) VALUES ('WWII', 1939)");
            sqLiteDatabase.execSQL("INSERT INTO events (name, year) VALUES ('WWI', 1914)");
            sqLiteDatabase.execSQL("INSERT INTO events (name, year) VALUES ('Moon landing', 1969)");

            Cursor c = sqLiteDatabase.rawQuery("SELECT ")

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
