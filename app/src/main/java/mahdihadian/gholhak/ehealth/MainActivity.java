package mahdihadian.gholhak.ehealth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mahdihadian.gholhak.ehealth.Utils.ListAdapter;
import mahdihadian.gholhak.ehealth.Utils.UserModel;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    String emoji_risk = "\uD83D\uDEA8", emoji_warning = "\uD83D\uDD14", emoji_normal = "\uD83D\uDE01", emoji_good = "\uD83E\uDD24";
    ImageButton toggle, btn_more;
    ListView detail_list;
    List<UserModel> userModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
        setSupportActionBar(toolbar);

        toggle.setOnClickListener(V -> {
            if (!mDrawer.isDrawerOpen(Gravity.START)) {
                mDrawer.openDrawer(Gravity.START);
            }
        });

        btn_more.setOnClickListener(V->{
            onPopupButtonClick(btn_more);
        });

        userModels = new ArrayList<>();


        UserModel u1 = new UserModel("Farhad", "Good" + emoji_good, 25, 35.5, 62);
        UserModel u2 = new UserModel("Ali", "Risk" + emoji_risk, 45, 85.5, 77);
        UserModel u3 = new UserModel("Sara", "Good" + emoji_good, 99, 86, 35);
        UserModel u4 = new UserModel("Hasan", "Warning" + emoji_warning, 35, 40.8, 50);
        UserModel u5 = new UserModel("Mahdi", "Good" + emoji_good, 21, 35, 80);
        UserModel u6 = new UserModel("Hadi", "normal" + emoji_normal, 36, 70.3, 31);
        UserModel u7 = new UserModel("Firooz", "Risk" + emoji_risk, 63, 35.5, 62);
        UserModel u8 = new UserModel("Shadi", "Good" + emoji_good, 40, 35.5, 73);
        UserModel u9 = new UserModel("Taha", "Warning" + emoji_warning, 25, 63.5, 22);
        UserModel u10 = new UserModel("Danial", "Good" + emoji_good, 27, 37.4, 44);

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

        detail_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,userModels.get(position).getName(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.KEY_NAME, userModels.get(position).getName());
                intent.putExtra(DetailActivity.KEY_AGE, userModels.get(position).getAge());
                intent.putExtra(DetailActivity.KEY_STATUS, userModels.get(position).getStatus());
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
                Toast.makeText(MainActivity.this,  item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        popup.show();
    }



}
