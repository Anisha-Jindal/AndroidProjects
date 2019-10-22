package com.example.user.wifimanager;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Bluetooth extends AppCompatActivity {
private BluetoothAdapter ba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        Button on=findViewById(R.id.bon);
        Button off=findViewById(R.id.boff);
        ba=BluetoothAdapter.getDefaultAdapter();

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ba.isEnabled()){
                    Intent on=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(on,0);
                    Toast.makeText(Bluetooth.this, "Turned on", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(Bluetooth.this, "Already on", Toast.LENGTH_SHORT).show();
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ba.disable();
                Toast.makeText(Bluetooth.this, "Turned off", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
