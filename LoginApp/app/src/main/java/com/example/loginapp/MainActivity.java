package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText uName;
    private EditText uPassword;
    private Button bLogin;
    private TextView uAttemptInfo;

    private String Username = "Admin";
    private String Password = "12345678";

    boolean isValid = false;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uName = findViewById(R.id.uName);
        uPassword = findViewById(R.id.uPassword);
        bLogin = findViewById(R.id.bLogin);
        uAttemptInfo = findViewById(R.id.uAttemtpInfo);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputName = uName.getText().toString();
                String inputPassword = uPassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter all the details correctly!", Toast.LENGTH_SHORT).show();
                }else {

                    isValid = validate(inputName, inputPassword);
                    if (!isValid){

                        counter--;

                        Toast.makeText(MainActivity.this,"Incorrect credentials entered!", Toast.LENGTH_SHORT).show();

                        uAttemptInfo.setText( "No. of attempt remaining: " + counter);

                        if (counter == 0){
                            bLogin.setEnabled(false);
                        }

                    }else {
                        Toast.makeText(MainActivity.this,"Login successful!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }

    private boolean validate(String name, String password){

        if(name.equals(Username) && password.equals(Password)){
            return true;
        }

        return false;
    }
}