package com.example.prabhakarananbazhag.mlist.activities.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabhakarananbazhag.mlist.R;
import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//import static com.example.prabhakarananbazhag.mlist.activities.activities.LoginActivity.Name;

public class SignupActivity extends Activity implements Validator.ValidationListener {

    public static final String MyPREFECENCES = "mypref";
    SharedPreferences sharedPreferences;
    /*public static final String Name1="namekey1";
    public static final String Email1 = "emailkey1";
    public static final String Pass1 = "passkey1";*/

    @Order(1)
    @NotEmpty
    @BindView(R.id.input_name2)
    EditText input_name;

    @Order(2)
    @NotEmpty
    @Email
    @BindView(R.id.input_email2)
    EditText input_email;

    @Order(3)
    @NotEmpty
    @Password
    @BindView(R.id.input_password2)
    EditText input_password;

    @BindView(R.id.btn_create)
    AppCompatButton btn_signup;


    @BindView(R.id.link_login)
    TextView link_login;

    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);
        validator = new Validator(this);
        validator.setValidationListener(this);
        validator.setValidationMode(Validator.Mode.BURST);

        sharedPreferences = getSharedPreferences(MyPREFECENCES, Context.MODE_PRIVATE);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();
            }
        });
        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(s);
            }
        });
    }

    private void signUp() {
        String nam=input_name.getText().toString();
        String em = input_email.getText().toString();
        String pa = input_password.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("namekey1",nam);
        editor.putString("emailkey1", em);
        editor.putString("passkey1", pa);
        editor.commit();
        //  awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //  awesomeValidation.addValidation(SignupActivity.this, R.id.input_name,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        //  awesomeValidation.addValidation(SignupActivity.this, R.id.input_email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        //awesomeValidation.addValidation(SignupActivity.this, R.id.input_password, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.passworderror);
        //  if(awesomeValidation.validate()){
        //      Toast.makeText(SignupActivity.this, "Registration Successfull", Toast.LENGTH_LONG).show();
        //  }
        Intent i = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(i);
    }

    @Override
    public void onValidationSucceeded() {
        signUp();
    }

    public void onValidationFailed(List<ValidationError> errors) {
        final ValidationError validationError = errors.get(0);
        final List<Rule> failedRules = validationError.getFailedRules();
        final Rule rule = failedRules.get(0);
        final String message = rule.getMessage(this);
        final View view = validationError.getView();
        ViewParent parentView = view.getParent();
        if (parentView instanceof FrameLayout) {
            setErrorMessage(view, message);
        } else if (view instanceof EditText) {
            view.requestFocus();
            ((EditText) view).setError(message);
        } else {
            view.requestFocus();
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    private void setErrorMessage(View view, String errorMessage) {
        // Getting deep in to the exact parent of edit text
        ViewParent parentView = view.getParent();
        View superView = (View) parentView.getParent();
        TextInputLayout textInputLayout = (TextInputLayout) superView;
        textInputLayout.requestFocus();
        textInputLayout.setErrorEnabled(true);
        textInputLayout.setError(errorMessage);
    }
}