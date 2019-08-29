package com.example.prabhakarananbazhag.mlist.activities.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.prabhakarananbazhag.mlist.R;
import com.example.prabhakarananbazhag.mlist.activities.Detail;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends Activity {
    SharedPreferences sharedPreferences;
    @BindView(R.id.input_email)
    EditText input_email;
    @BindView(R.id.input_password)
    EditText input_password;
    @BindView(R.id.bt1)
    Button button;
    @BindView(R.id.contentView)
    View activityRootView;

    @BindView(R.id.linksignup)
    TextView linksignup;
    @BindView(R.id.spinner)
    Spinner Spinner;

    public AwesomeValidation awesomeValidation;
    public static String userName;
    public Boolean isEdited = false;
    List<String> spinnerArray = new ArrayList<String>();
    List<String> spinnerArray1 = new ArrayList<String>();
    private String u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences(getString(R.string.MovieListFile), 0);
        spinnerArray.add("item2");
        spinnerArray1.add("item3");
        spinnerArray1.add("item4");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray1);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
                if (heightDiff < dpToPx(LoginActivity.this, 200)) { // if more than 200 dp, it's probably a keyboard...
                    // ... do something here
                    if (input_email.getText().toString().length() == 10) {
                        Spinner.setAdapter(adapter);
                    } else {
                        Spinner.setAdapter(adapter1);
                    }
                    //   Toast.makeText(LoginActivity.this, "Registration Successfull", Toast.LENGTH_LONG).show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = input_email.getText().toString();
                String pa = input_password.getText().toString();


                SharedPreferences set = getSharedPreferences(getString(R.string.MovieListFile), 0);
                if (set.contains(em)) {
                    Gson gson = new Gson();
                    String json = set.getString(em, "");
                    Log.i("json", json);

                    Detail detail = gson.fromJson(json, Detail.class);
                    awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
                    awesomeValidation.addValidation(LoginActivity.this, R.id.input_email, Patterns.EMAIL_ADDRESS, R.string.emailerror);


                    if ((pa.equals(detail.pass)) && (em.equals(detail.email))) {
                        userName = em;
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        SharedPreferences.Editor editor = getSharedPreferences(getString(R.string.MovieListFile), 0).edit();
                        editor.putBoolean(getString(R.string.isLoggedIn), true);
                        editor.putString(getString(R.string.isLoggedUser), em);
                        editor.commit();
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), " Invalid Username or Password", Toast.LENGTH_LONG).show();

                    }
                } else {
                    Toast.makeText(getApplicationContext(), " Create account", Toast.LENGTH_LONG).show();
                }
            }


        });
        linksignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent s = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(s);
                finish();

            }
        });

    }

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (input_email.getText().toString().length() == 10) {
            Toast.makeText(LoginActivity.this, "Registration Successfull", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(LoginActivity.this, "UNSuccessfull", Toast.LENGTH_LONG).show();
        }
    }
}
