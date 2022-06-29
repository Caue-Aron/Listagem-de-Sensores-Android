package br.ifsc.edu.aula0306;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager mysensor;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista);

        mysensor = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        List<Sensor> listasensores = mysensor.getSensorList(Sensor.TYPE_ALL);

        ArrayList<String> txt = new ArrayList<String>();

        for(Sensor s: listasensores){
            txt.add(s.getName());
        }

        String[] texto = txt.toArray(new String[0]);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_list_item_1, texto
        );
        lista.setAdapter(adapter);
    }
}
