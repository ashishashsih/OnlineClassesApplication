package app.online.classes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SplashActivity extends AppCompatActivity
{
//    SchoolDbOpenHelper sdoh;
//    Context context=this;
//    SQLiteDatabase db;
//    ShimmerFrameLayout sfl;
//    long Delay=2000;
    Dialog loginDialog;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loginDialog= new BottomSheetDialog(this,R.style.SheetDialog);
        loginDialog.setContentView(R.layout.dialog_login);
        loginDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        loginDialog.setCanceledOnTouchOutside(false);
        loginDialog.setCancelable(false);
        btnLogin=(Button)loginDialog.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.dismiss();
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        });
    }

    public void login(View view)
    {
        loginDialog.show();
    }
}
