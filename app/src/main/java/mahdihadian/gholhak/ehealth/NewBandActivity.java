package mahdihadian.gholhak.ehealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class NewBandActivity extends AppCompatActivity {

    Toolbar toolbar_add_device;
    ImageButton back;


    EditText patient_name, patient_age, patient_weight, device_address;
    Button add_device;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_band);
        bind();

        setSupportActionBar(toolbar_add_device);

        back.setOnClickListener(V->{
            finish();
        });

        add_device.setOnClickListener(v->{
            if (!(patient_name.toString().equals("")) && !(patient_age.toString().equals(""))
                    && !(patient_weight.toString().equals("")) && !(device_address.toString().equals("")) ){

                Toast.makeText(this, "new device has been added", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                // send data to db and show in main activity

            }


        });

    }

    private void bind() {
        patient_name = findViewById(R.id.patient_name);
        patient_age = findViewById(R.id.patient_age);
        patient_weight = findViewById(R.id.patient_weight);
        device_address = findViewById(R.id.device_address);
        add_device = findViewById(R.id.add_device);

        toolbar_add_device = findViewById(R.id.toolbar_add_device);
        back = findViewById(R.id.back);
    }
}
