package com.example.app_res_vuel.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app_res_vuel.R;
import com.example.app_res_vuel.fragments.LoginUIFragment;
import com.example.app_res_vuel.fragments.RegisterUIFragment;

public class LoginActivity extends AppCompatActivity {
    private TextView txtView_LogRegisUI;
    private EditText txtEmail;
    private EditText txtPass;
    private TextView btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*
        txtEmail =(EditText) findViewById(R.id.txt_username);
        txtPass=(EditText) findViewById(R.id.txt_pass);
        */
        this.txtView_LogRegisUI = (TextView) findViewById(R.id.txtView_LogRegisUI);

        this.btnLogin = (TextView) findViewById(R.id.btn_Login);
        /*
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user="", pass="";

                user=txtEmail.getText().toString();
                pass=txtPass.getText().toString();
                if(user.equals("admin") && pass.equals("admin")) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }


            }
        });

         */
        this.getFragmentClick(new LoginUIFragment());
        this.txtViewSpannable();
    }

    private void txtViewSpannable() {
        /*
        fragLogin=¿Si, no tienes una Cuenta?.. Registrar
        fragRegis=Ya cuento con una Cuenta... Login
         */
        String fragRegis = getResources().getString(R.string.fragRegis);
        String fragLogin = getResources().getString(R.string.fragLogin);
        String valuetxtView = this.txtView_LogRegisUI.getText().toString();
        SpannableString spannString = new SpannableString(fragLogin);
        ClickableSpan clickSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                if (fragLogin.equals(txtView_LogRegisUI.getText().toString()))  getFragmentClick(new RegisterUIFragment());
                else getFragmentClick(new LoginUIFragment());
            }
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };
        if(valuetxtView.contains("Registrar"))
            spannString.setSpan(clickSpan,
                    fragLogin.indexOf('R'),
                    fragLogin.length(),
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        else spannString.setSpan(clickSpan,
                fragLogin.indexOf('L'),
                fragLogin.length(),
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        this.txtView_LogRegisUI.setText(spannString);
        this.txtView_LogRegisUI.setMovementMethod(LinkMovementMethod.getInstance());
    }
    private void getFragmentClick(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_in, // enter
                        R.anim.fade_out, // exit
                        R.anim.fade_in, // popEnter
                        R.anim.slide_out // popExit
                )
                .replace(R.id.frag_LoginRegisUI, fragment)
                .addToBackStack(null)
                .commit();
    }
}