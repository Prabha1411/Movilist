package com.example.prabhakarananbazhag.mlist.activities.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import com.example.prabhakarananbazhag.mlist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.constraint.Constraints.TAG;

public class LoginActivity extends Activity {
 public static final String MyPREFECENCES = "mypref";
    public static final String Name="namekey";
    public static final String Email = "emailkey";
    public static final String Pass = "passkey";
    SharedPreferences sharedPreferences;
    @BindView(R.id.input_email)
    EditText input_email;
    @BindView(R.id.input_password)
    EditText input_password;
    @BindView(R.id.bt1)
    Button button;
    @BindView(R.id.linksignup)
    TextView linksignup;
    @BindView(R.id.input_name)
    EditText input_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences(MyPREFECENCES, Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam=input_name.getText().toString();
                String em = input_email.getText().toString();
                String pa = input_password.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Name,nam);
                editor.putString(Email, em);
                editor.putString(Pass, pa);
                editor.commit();
               SharedPreferences set=getSharedPreferences(MyPREFECENCES,MODE_PRIVATE);
               String namvalue=set.getString("namekey1","");
               String emlvalue=set.getString("emailkey1","");
               String pasvalue=set.getString("passskey1","");
              // Log.i(namvalue,TAG);
               // Log.i(emlvalue,TAG);
               // Log.i(pasvalue,TAG);
               /*if((nam!=namvalue)&&(em==emlvalue)&&(pa==pasvalue)){
                   Toast.makeText(getApplicationContext(), " uccessfull", Toast.LENGTH_LONG).show();
                   Intent i = new Intent(LoginActivity.this, MainActivity.class);
                   startActivity(i);

               }
else{
                   Toast.makeText(getApplicationContext(), " UnSuccessfull", Toast.LENGTH_LONG).show();

               }*/



              //  Intent i = new Intent(LoginActivity.this, MainActivity.class);
              //      startActivity(i);



            }
        });
        linksignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(s);
            }
        });
    }
}
