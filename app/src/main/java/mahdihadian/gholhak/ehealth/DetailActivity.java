package mahdihadian.gholhak.ehealth;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {


    TextView patient_name, patient_age, patient_status,
            txt_beat, txt_temp, txt_blood_pressure, txt_oxygen;
    Toolbar toolbar_detail;
    ImageButton back;

    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";
    public static final String KEY_STATUS = "status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar(toolbar_detail);
        bind();
        setPatientInfo();
        back.setOnClickListener(V -> {
            finish();
        });

    }

    private void bind() {

        patient_name = findViewById(R.id.patient_name);
        patient_age = findViewById(R.id.patient_age);
        patient_status = findViewById(R.id.patient_status);
        toolbar_detail = findViewById(R.id.toolbar_detail);
        back = findViewById(R.id.back);
        txt_temp = findViewById(R.id.txt_temp);
        txt_beat = findViewById(R.id.txt_beat);
        txt_blood_pressure = findViewById(R.id.txt_blood_pressure);
        txt_oxygen = findViewById(R.id.txt_oxygen);

    }

    private void setPatientInfo() {
        // Received data from mainAct
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString(KEY_NAME);
        int age = bundle.getInt(KEY_AGE);
        String status = bundle.getString(KEY_STATUS);

        patient_name.setText(name);
        patient_status.setText(status);
        patient_age.setText(String.valueOf(age));

    }

}

