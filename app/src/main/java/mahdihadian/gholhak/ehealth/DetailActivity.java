package mahdihadian.gholhak.ehealth;

import android.os.Handler;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import com.txusballesteros.SnakeView;

public class DetailActivity extends AppCompatActivity {


    TextView patient_name, patient_age, patient_status;

    Toolbar toolbar_detail;
    ImageButton back;


    // heartBipChart
    private TextView txt_beat, txt_temp;
    private SnakeView chart_snake, chart_bodyTemp;
    private int position = 0;
    private boolean stop = false;


    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";
    public static final String KEY_STATUS = "status";


    //    a range between 60-100
    private float[] values = new float[]{
            70, 71, 74, 80, 73, 75, 82, 64, 69, 70,
            68, 72, 78, 70, 75, 74, 69, 73, 77, 58,
            73, 65, 74, 76, 72, 78, 71, 74, 67, 64,
            78, 73, 67, 66, 64, 71, 72, 86, 72, 68,
            70, 82, 84, 68, 71, 77, 78, 83, 66, 70,
            82, 73, 78, 78, 81, 78, 80, 75, 79, 81,
            71, 83, 63, 70, 75, 69, 62, 75, 66, 68,
            57, 61, 84, 61, 77, 62, 71, 68, 69, 79,
            76, 87, 78, 73, 89, 81, 73, 64, 65, 73,
            69, 57, 79, 78, 80, 79, 81, 73, 74, 84,
            83, 82, 85, 86, 77, 72, 79, 59, 64, 65,
            82, 64, 70, 83, 89, 69, 73, 84, 76, 79,
            81, 80, 74, 77, 66, 68, 77, 79, 78, 77
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        bind();
//        generateHeartBeatValue();

        setSupportActionBar(toolbar_detail);

        back.setOnClickListener(V -> {
            finish();
        });

        // Received data from mainAct
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString(KEY_NAME);
        int age = bundle.getInt(KEY_AGE);
        String status = bundle.getString(KEY_STATUS);

        patient_name.setText(name);
        patient_status.setText(status);
        patient_age.setText(String.valueOf(age));

    }


    private void bind() {

        patient_name = findViewById(R.id.patient_name);
        patient_age = findViewById(R.id.patient_age);
        patient_status = findViewById(R.id.patient_status);


        toolbar_detail = findViewById(R.id.toolbar_detail);
        back = findViewById(R.id.back);


//            chart_snake = findViewById(R.id.chart_snake);
//            chart_bodyTemp = findViewById(R.id.chart_bodyTemp);
//            chart_snake.setMaxValue(100);
//            chart_snake.setMinValue(50);
//            txt_temp = findViewById(R.id.txt_temp);
//            txt_beat = findViewById(R.id.txt_beat);
    }


    @Override
    protected void onStart() {
        super.onStart();
        stop = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        stop = true;
    }

//        private void generateHeartBeatValue () {
//            if (position < (values.length - 1)) {
//                position++;
//            } else {
//                position = 0;
//            }
//            double value = values[position];
//            chart_snake.addValue((float) value);
//            txt_beat.setText(((int) value + ""));
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    if (!stop) {
//                        generateHeartBeatValue();
//                    }
//                }
//            }, 1000);

}

