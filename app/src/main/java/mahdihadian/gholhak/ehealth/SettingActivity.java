package mahdihadian.gholhak.ehealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class SettingActivity extends AppCompatActivity {

    Toolbar toolbar_settings;
    ImageButton back;


    Spinner spinner_language;
    Button save_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        bind();
        setSupportActionBar(toolbar_settings);

        back.setOnClickListener(V->{
            finish();
        });

        ArrayAdapter<CharSequence> languages = ArrayAdapter
                .createFromResource(this, R.array.languages, android.R.layout.simple_spinner_dropdown_item);
        spinner_language.setAdapter(languages);

        save_info.setOnClickListener(v->{
            // get language changes and save it into sharedprefs
            startActivity(new Intent(this, MainActivity.class));
        });
    }

    private void bind() {
        spinner_language = findViewById(R.id.spinner_language);
        save_info = findViewById(R.id.save_info);

        toolbar_settings = findViewById(R.id.toolbar_settings);
        back= findViewById(R.id.back);

    }
}
