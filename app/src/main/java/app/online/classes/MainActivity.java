package app.online.classes;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import app.online.classes.bean.BannerBean;

public class MainActivity extends AppCompatActivity
{
    private AppBarConfiguration mAppBarConfiguration;

    RecyclerView recBanner;
    BannerAdapter bannerAdapter;
    ArrayList<BannerBean>bannerBeans=new ArrayList<>();
    int max = 0;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        recBanner=(RecyclerView)findViewById(R.id.recBanner);
        BannerBean bb=new BannerBean("1","Get Video","0","Now play all your lecture with out any interruption click to view");
        bannerBeans.add(bb);
        bb=new BannerBean("2","Get Material","1","Now View all your lecture with out any interruption click detail to read and download your notes.");
        bannerBeans.add(bb);

        bannerAdapter=new BannerAdapter(MainActivity.this,bannerBeans);
        bannerAdapter = new BannerAdapter(MainActivity.this,bannerBeans);
        recBanner.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recBanner.setAdapter(bannerAdapter);
        max = bannerAdapter.getItemCount();
        updateBanner();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_lecture, R.id.nav_notes,
                R.id.nav_login, R.id.nav_notification)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void updateBanner() {
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask doTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @SuppressWarnings("unchecked")
                    public void run() {
                        try {
                            //Toast.makeText(getApplicationContext(),"one more",Toast.LENGTH_LONG).show();
                            refreshBanner(i);
                            i++;
                            if (i > max) {
                                i = 0;
                            }
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                        }
                    }
                });
            }
        };
        //timer.schedule(doTask, 0, "Your time 10 minute");
        //timer.schedule(doTask,50000,0);
        timer.schedule(doTask, 2000);
    }

    void refreshBanner(final int i)
    {
        recBanner.post(new Runnable() {
            @Override
            public void run() {
                recBanner.smoothScrollToPosition(i);
                updateBanner();
            }
        });
    }

    void gotoNext(int ref)
    {
        if(ref==1)
        {
                startActivity(new Intent(MainActivity.this,VideoLactureActivity.class));
        }else
        {
                startActivity(new Intent(MainActivity.this,NotesActivity.class));
        }
    }
}
