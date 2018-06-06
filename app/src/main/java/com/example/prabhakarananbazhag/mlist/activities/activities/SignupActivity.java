package com.example.prabhakarananbazhag.mlist.activities.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.prabhakarananbazhag.mlist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.prabhakarananbazhag.mlist.activities.activities.LoginActivity.Name;

public class SignupActivity extends Activity {
    public static final String MyPREFECENCES = "mypref";
    SharedPreferences sharedPreferences;
    public static final String Name1="namekey1";
    public static final String Email1 = "emailkey1";
    public static final String Pass1 = "passkey1";

    @BindView(R.id.input_name2)
    EditText input_name;
    @BindView(R.id.input_email2)
    EditText input_email;
    @BindView(R.id.input_password2)
    EditText input_password;
    @BindView(R.id.btn_create)
    AppCompatButton btn_signup;
    @BindView(R.id.link_login)
    TextView link_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences(MyPREFECENCES, Context.MODE_PRIVATE);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam=input_name.getText().toString();
                String em = input_email.getText().toString();
                String pa = input_password.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
               // editor.putString(Name1,nam);
                editor.putString("namekey1",nam);
                editor.putString("emailkey1", em);
                editor.putString("passkey1", pa);
                editor.commit();
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        /*link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(s);
            }
        });*/
    }
}