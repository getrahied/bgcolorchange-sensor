package com.example.devsufy;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;
public class MainActivity extends AppCompatActivity implements
        SensorEventListener {
    SensorManager manager;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout=(LinearLayout)findViewById(R.id.layout);
        manager=(SensorManager)this.getSystemService(SENSOR_SERVICE);
        Sensor a=manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x=event.values[0];
        float y=event.values[1];
        if(x < 0){
            layout.setBackgroundColor(Color.YELLOW);
        } else if(x>0){
            layout.setBackgroundColor(Color.RED);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterListener(this);
    }
}
