package app.online.classes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class VideoLactureActivity extends AppCompatActivity
{
    Dialog queryDialog;
    Button btnQurey,btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_lacture);
custActionBar();
        queryDialog= new BottomSheetDialog(this,R.style.SheetDialog);
        queryDialog.setContentView(R.layout.dialog_query);
        queryDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        queryDialog.setCanceledOnTouchOutside(false);
        queryDialog.setCancelable(false);

        btnQurey=(Button)queryDialog.findViewById(R.id.btnQuery);
        btnQurey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),"Your Query Submitted Successfully",Toast.LENGTH_LONG).show();
                queryDialog.dismiss();
                //startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        });

        btnClose=(Button)queryDialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                queryDialog.dismiss();
                //startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        });
    }

    public void getQuery(View view)
    {
        queryDialog.show();
    }

    public void custActionBar()
    {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        //actionBar.setSubtitle("Video Lecture");
        actionBar.setTitle("Video Lecture");
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        //actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(255, 102, 102)));
        actionBar.show();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
