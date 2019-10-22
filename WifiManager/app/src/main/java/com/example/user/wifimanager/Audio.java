package com.example.user.wifimanager;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Audio extends AppCompatActivity {
    private AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_manager);
        Button mode=findViewById(R.id.mode);
        Button ringer=findViewById(R.id.ringer);
        Button silent=findViewById(R.id.silent);
        Button vibrate=findViewById(R.id.vibrate);
        audioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        Permission();
        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mod=audioManager.getRingerMode();
                if(mod==AudioManager.RINGER_MODE_NORMAL)
                    Toast.makeText(Audio.this, "Normal", Toast.LENGTH_SHORT).show();
                else if(mod==AudioManager.RINGER_MODE_SILENT)
                    Toast.makeText(Audio.this, "Silent", Toast.LENGTH_SHORT).show();
                else if(mod==AudioManager.RINGER_MODE_VIBRATE)
                    Toast.makeText(Audio.this, "Vibrate", Toast.LENGTH_SHORT).show();
            }
        });

        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            }
        });

        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            }
        });

        ringer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            }
        });
    }

    private void Permission() {
        NotificationManager nm=(NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M&& !nm.isNotificationPolicyAccessGranted()){
            Intent i=new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivity(i);
        }
    }
}
