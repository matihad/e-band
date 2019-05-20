package mahdihadian.gholhak.ehealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VerifyBandActivity extends AppCompatActivity {

    EditText verify_code;
    Button verify_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_band);
        bind();

        verify_check.setOnClickListener(v -> {
//            if (verify_code.getText() == "server verify code")
                startActivity(new Intent(VerifyBandActivity.this, MainActivity.class));
//            else Toast.makeText(this, "Verify code is wrong", Toast.LENGTH_SHORT).show();
        });
    }

    private void bind() {
        verify_check = findViewById(R.id.verify_check);
        verify_code = findViewById(R.id.verify_code);
    }
}
