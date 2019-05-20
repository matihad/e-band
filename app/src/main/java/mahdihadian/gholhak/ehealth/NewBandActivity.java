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
    Button add_device;
    EditText patient_name, patient_age,
    patient_weight, device_address,
    patient_sex, patient_bloodType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_band);
        bind();

        setSupportActionBar(toolbar_add_device);

        back.setOnClickListener(V -> {
            finish();
        });

        add_device.setOnClickListener(v -> {
            if (!(patient_name.toString().equals("")) && !(patient_age.toString().equals(""))
                    && !(patient_weight.toString().equals("")) && !(device_address.toString().equals("")
                    && !(patient_sex.toString().equals("") && !(patient_bloodType.toString().equals("")))))
            {

                startActivity(new Intent(this, VerifyBandActivity.class));
                // send data to db then show in main activity

            }
        });

    }

    private void bind() {
        patient_name = findViewById(R.id.patient_name);
        patient_age = findViewById(R.id.patient_age);
        patient_weight = findViewById(R.id.patient_weight);
        device_address = findViewById(R.id.device_address);
        add_device = findViewById(R.id.add_device);
        patient_sex = findViewById(R.id.patient_sex);
        patient_bloodType = findViewById(R.id.patient_bloodType);

        toolbar_add_device = findViewById(R.id.toolbar_add_device);
        back = findViewById(R.id.back);
    }
}
