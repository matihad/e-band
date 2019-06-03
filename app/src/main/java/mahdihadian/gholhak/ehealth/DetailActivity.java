package mahdihadian.gholhak.ehealth;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {


    TextView patient_name, patient_age, patient_status,
            txt_beat, txt_temp, txt_blood_pressure, txt_oxygen;
    Toolbar toolbar_detail;
    ImageButton back;
    LinearLayout linearInfo;
    ImageView avatarDetailProfile;


    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";
    public static final String KEY_STATUS = "status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar(toolbar_detail);
        bind();
        changeStatusBarColor();
        setPatientInfo();
        back.setOnClickListener(V -> {
            finish();
        });

    }
    private void changeStatusBarColor(){
        // yani az android 5 be bala age bashe device karbar
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
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

        linearInfo = findViewById(R.id.linearInfo);

        avatarDetailProfile = findViewById(R.id.avatarDetailProfile);
    }

    private void setPatientInfo() {
        // Received data from mainAct
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString(KEY_NAME);
        int age = bundle.getInt(KEY_AGE);
        String status = bundle.getString(KEY_STATUS);

       // Received Image from MainAct
        byte[] byteArray = bundle.getByteArray("picture");

        Bitmap bmp = null;
        if (byteArray != null) {
            bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        ImageView image = findViewById(R.id.avatarDetailProfile);
        image.setImageBitmap(bmp);

        patient_name.setText(name);
        patient_status.setText(status);
        patient_age.setText(age + " years old");

        if (status != null) {
            switch (status) {
                case "Good":
                    toolbar_detail.setBackgroundColor(Color.rgb(56, 142, 60));
                    linearInfo.setBackgroundResource(R.drawable.bg_info_detail);
                    linearInfo.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(56, 142, 60)));
                    break;

                case "Normal":
                    toolbar_detail.setBackgroundColor(Color.rgb(2, 136, 209));
                    linearInfo.setBackgroundResource(R.drawable.bg_info_detail);
                    linearInfo.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(2, 136, 209)));

                    break;

                case "Warning":
                    toolbar_detail.setBackgroundColor(Color.rgb(251, 192, 45));
                    linearInfo.setBackgroundResource(R.drawable.bg_info_detail);
                    linearInfo.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(251, 192, 45)));
                    break;

                case "Risk":
                    toolbar_detail.setBackgroundColor(Color.rgb(211, 47, 47));
                    linearInfo.setBackgroundResource(R.drawable.bg_info_detail);
                    linearInfo.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(211, 47, 47)));
                    break;

                default:
                    break;
            }

        }


    }

}

