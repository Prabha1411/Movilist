package com.example.prabhakarananbazhag.mlist.activities.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.LocaleList;
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
    /*public static final String Name="namekey";
    public static final String Email = "emailkey";
    public static final String Pass = "passkey";*/
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
    public AwesomeValidation awesomeValidation;


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
                editor.putString("namekey",nam);
                editor.putString("emailkey", em);
                editor.putString("passkey", pa);
                editor.commit();
               SharedPreferences set=getSharedPreferences(MyPREFECENCES,MODE_PRIVATE);
               String namvalue=set.getString("namekey1","");
               String emlvalue=set.getString("emailkey1","");
               String pasvalue=set.getString("passkey1","");

               //String nameentered = nam.toString();
              // String namecheck = namvalue.toString();
             //  String password=pa.toString();
              // String passwordchk=pasvalue.toString();
                //(nameentered.equals(namecheck))&&(password.equals(passwordchk))&&
                awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
                awesomeValidation.addValidation(LoginActivity.this, R.id.input_name,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
                awesomeValidation.addValidation(LoginActivity.this, R.id.input_email, Patterns.EMAIL_ADDRESS, R.string.emailerror);

                if(awesomeValidation.validate()){
                    //Toast.makeText(LoginActivity.this, "Registration Successfull", Toast.LENGTH_LONG).show();
                }


               if((namvalue.equals(nam))&&(pasvalue.equals(pa))&&(emlvalue.equals(em))){
                   Intent i = new Intent(LoginActivity.this, MainActivity.class);
                   startActivity(i);
               }

                else{
                   Toast.makeText(getApplicationContext(), " Invalid Username or Password", Toast.LENGTH_LONG).show();

               }

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
