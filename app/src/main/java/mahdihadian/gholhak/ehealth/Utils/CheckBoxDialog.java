package mahdihadian.gholhak.ehealth.Utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import mahdihadian.gholhak.ehealth.R;

public class CheckBoxDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.fragment_checkbox, null);
        mBuilder.setView(v);
        CheckBox check1 = v.findViewById(R.id.check1);
        CheckBox check2 = v.findViewById(R.id.check2);
        CheckBox check3 = v.findViewById(R.id.check3);
        CheckBox check4 = v.findViewById(R.id.check4);
        CheckBox check5 = v.findViewById(R.id.check5);

        mBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "1:" + check1.isChecked() + "\n2:" + check2.isChecked()
                        + "\n3:" + check3.isChecked() + "\n4:" + check4.isChecked()
                        + "\n5:" + check5.isChecked(), Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });

        return mBuilder.create();
    }
}
