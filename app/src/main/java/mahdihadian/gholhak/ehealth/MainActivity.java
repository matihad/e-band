package mahdihadian.gholhak.ehealth;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import mahdihadian.gholhak.ehealth.Utils.ListAdapter;
import mahdihadian.gholhak.ehealth.Utils.UserModel;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    ImageButton toggle, btn_more;
    ListView detail_list;
    List<UserModel> userModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
        setSupportActionBar(toolbar);
        generateList();


        detail_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                showNotification(MainActivity.this, "Title", "Body", intent);
                return false;
            }
        });
        toggle.setOnClickListener(V -> {
            if (!mDrawer.isDrawerOpen(Gravity.START)) {
                mDrawer.openDrawer(Gravity.START);
            }
        });
        btn_more.setOnClickListener(V -> {
            onPopupButtonClick(btn_more);
        });
        detail_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.KEY_NAME, userModels.get(position).getName());
                intent.putExtra(DetailActivity.KEY_AGE, userModels.get(position).getAge());
                intent.putExtra(DetailActivity.KEY_STATUS, userModels.get(position).getStatus());

                //TODO ->   Send avatar to detailAct
                // Convert Bitmap to Byte Array:-
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.image_profile);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                //Pass byte array into intent:-
                intent.putExtra("picture", byteArray);

                startActivity(intent);
            }
        });
        nvDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.add_device:
                        startActivity(new Intent(MainActivity.this, NewBandActivity.class));
                        break;

                    case R.id.settings:
                        startActivity(new Intent(MainActivity.this, SettingActivity.class));
                        break;

                    case R.id.about_us:
                        startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
                        break;

                }
                return true;
            }

        });

    }


    public void showNotification(Context context, String title, String body, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.about_icon_email)
                .setContentTitle(title)
                .setContentText(body);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntent(intent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        mBuilder.setContentIntent(resultPendingIntent);
        notificationManager.notify(notificationId, mBuilder.build());
    }

    //    baraye in method bayad parameter bezarim ke age
    //    yeki az item haye kebab menu entekhab shod bar un asas sort kone dobare
    private void generateList() {
        userModels = new ArrayList<>();
        UserModel u1 = new UserModel("Farhad", "Normal", 25, 35.5, 62);
        UserModel u2 = new UserModel("Ali", "Risk", 45, 85.5, 77);
        UserModel u3 = new UserModel("Sara", "Good", 99, 86, 35);
        UserModel u4 = new UserModel("Hasan", "Warning", 35, 40.8, 50);
        UserModel u5 = new UserModel("Mahdi", "Good", 21, 35, 80);
        UserModel u6 = new UserModel("Hadi", "Normal", 36, 70.3, 31);
        UserModel u7 = new UserModel("Firooz", "Risk", 63, 35.5, 62);
        UserModel u8 = new UserModel("Shadi", "Good", 40, 35.5, 73);
        UserModel u9 = new UserModel("Taha", "Warning", 25, 63.5, 22);
        UserModel u10 = new UserModel("Danial", "Good", 27, 37.4, 44);

        userModels.add(u1);
        userModels.add(u2);
        userModels.add(u3);
        userModels.add(u4);
        userModels.add(u5);
        userModels.add(u6);
        userModels.add(u7);
        userModels.add(u8);
        userModels.add(u9);
        userModels.add(u10);

        ListAdapter listAdapter = new ListAdapter(this, userModels);
        detail_list.setAdapter(listAdapter);
    }

    void bind() {
        nvDrawer = findViewById(R.id.nvView);
        toggle = findViewById(R.id.toggle);
        toolbar = findViewById(R.id.toolbar);
        mDrawer = findViewById(R.id.drawer_layout);
        detail_list = findViewById(R.id.detail_list);
        btn_more = findViewById(R.id.btn_more);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onPopupButtonClick(View button) {
        PopupMenu popup = new PopupMenu(this, button);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
//                switch mizarim ke harkudum bud parameter pass bedim be methode
//                generateList(String "sort by age");
//                generateList(String "sort by name");
//                generateList(String "sort by status");
                return true;
            }
        });
        popup.show();
    }


}
