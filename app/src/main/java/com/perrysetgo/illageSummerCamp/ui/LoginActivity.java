package com.perrysetgo.illageSummerCamp.ui;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.perrysetgo.illageSummerCamp.R;
//import com.parse.LogInCallback;
//import com.parse.ParseException;
//import com.parse.ParseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.nameInput) EditText mNameEdit;
    @Bind(R.id.passwordInput) EditText mPasswordEdit;
    @Bind(R.id.loginButton) Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

//        mLoginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //ParseUser newUser = new ParseUser();
//                ParseUser.logInInBackground(mNameEdit.getText().toString(), mPasswordEdit.getText().toString(), new LogInCallback() {
//                    public void done(ParseUser user, ParseException e) {
//                        if (user != null) {
//                            Toast.makeText(LoginActivity.this, "Welcome " + ParseUser.getCurrentUser().getUsername(), Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                            startActivity(intent);
//                        } else {
//                            Toast.makeText(LoginActivity.this, "Login credentials incorrect.", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//            }
//        });
    }
}
