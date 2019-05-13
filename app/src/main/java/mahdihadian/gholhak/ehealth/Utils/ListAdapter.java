package mahdihadian.gholhak.ehealth.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mahdihadian.gholhak.ehealth.R;

public class ListAdapter extends BaseAdapter {

    Context mContext;
    List<UserModel> userModels;

    public ListAdapter(Context mContext, List<UserModel> userModels) {
        this.mContext = mContext;
        this.userModels = userModels;
    }

    @Override
    public int getCount() {
        return userModels.size();
    }

    @Override
    public Object getItem(int position) {
        return userModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.list_detail, parent, false);

        TextView txt_name = convertView.findViewById(R.id.txt_name);
        TextView txt_age = convertView.findViewById(R.id.txt_age);
        TextView txt_status = convertView.findViewById(R.id.txt_status);
        TextView txt_heart_beat = convertView.findViewById(R.id.txt_heart_beat);
        TextView txt_blood_pressure = convertView.findViewById(R.id.txt_blood_pressure);

        txt_name.setText(userModels.get(position).getName());
        txt_age.setText(String.valueOf(userModels.get(position).getAge())+" Years old");
        txt_status.setText(userModels.get(position).getStatus());
        txt_heart_beat.setText(String.valueOf(userModels.get(position).getHeartBeat()));
        txt_blood_pressure.setText(String.valueOf(userModels.get(position).getBloodPressure()));

        return convertView;

    }

}
