package com.example.a3rdassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a3rdassignment.Model.Student;
import com.example.a3rdassignment.ui.Student.StudentFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editUsername, editPassword;
    Button btnLogin;
    String Username, Password;
    CheckBox showPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = findViewById(R.id.username);
        editPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);
        showPassword= findViewById(R.id.checkbox);

        btnLogin.setOnClickListener(this);

        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked)
                {
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else {
                    editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Username = editUsername.getText().toString();
        Password = editPassword.getText().toString();
        if (validate()) {
            if (Username.equals("admin") && Password.equals("admin")) {
                Toast.makeText(MainActivity.this, "Username and Password is correct", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, NavigationActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                editUsername.setError("Username or password is incorrect");
                editUsername.requestFocus();
            }
        }

    }

    private boolean validate() {
        if (TextUtils.isEmpty(Username)) {
            editUsername.setError("Please Enter Username");
            editUsername.requestFocus();
            return false;

        }
        if (TextUtils.isEmpty(Password)) {
            editPassword.setError("Please Enter Passward");
            editPassword.requestFocus();
            return false;
        }
return true;
    }
}




