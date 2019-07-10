package mahdihadian.gholhak.ehealth;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.File;
import java.util.List;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class SettingActivity extends AppCompatActivity {

    Toolbar toolbar_settings;
    ImageButton back;
    AppCompatEditText emergency_number;
    Spinner spinner_language;
    Button save_info;

    RoundedImageView avatar;
    TextView choosePic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        bind();
        setSupportActionBar(toolbar_settings);

        back.setOnClickListener(V->{
            startActivity(new Intent(this, MainActivity.class));
        });

        ArrayAdapter<CharSequence> languages = ArrayAdapter
                .createFromResource(this, R.array.languages, android.R.layout.simple_spinner_dropdown_item);
        spinner_language.setAdapter(languages);

        save_info.setOnClickListener(v->{
            // get language changes and save it into sharedprefs
            startActivity(new Intent(this, MainActivity.class));
        });



        choosePic.setOnClickListener(v -> {
            //show dialog
            getPermissions();
            showAlertDialog(v);
        });


    }

    private void bind() {
        spinner_language = findViewById(R.id.spinner_language);
        save_info = findViewById(R.id.save_info);
        emergency_number = findViewById(R.id.emergency_number);
        toolbar_settings = findViewById(R.id.toolbar_settings);
        back= findViewById(R.id.back);

        avatar = findViewById(R.id.avatar);
        choosePic = findViewById(R.id.choosePic);
    }

    public void showAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true)
                .setSingleChoiceItems(new String[]{"Open Gallery", "Open Camera", "Remove current image"}, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            EasyImage.openGallery(SettingActivity.this, 0);
                            dialog.dismiss();
                        }
                        if (which == 1) {
                            EasyImage.openCamera(SettingActivity.this, 0);
                            dialog.dismiss();
                        }

                        if (which == 2) {
                            //    avatar.setVisibility(View.INVISIBLE);
                            avatar.setImageResource(android.R.color.transparent);
                            dialog.dismiss();
                        }
                    }
                });
        builder.show();
    }

    void getPermissions() {

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE

                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

            }
        }).check();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                Glide.with(SettingActivity.this).load(imageFile).into(avatar);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
