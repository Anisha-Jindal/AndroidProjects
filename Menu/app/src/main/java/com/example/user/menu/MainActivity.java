package com.example.user.menu;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        { case R.id.about:
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
            break;
            case R.id.help:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
            break;
            case R.id.settings:
                Toast.makeText(this, "Settings"
                        , Toast.LENGTH_SHORT).show();
                break;
            case R.id.Contact:
                Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show();
  default:
      Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();      }
                return true;

    }
}
