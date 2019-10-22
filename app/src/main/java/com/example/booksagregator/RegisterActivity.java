package com.example.booksagregator;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.booksagregator.validator.UserRegisterValidation;

public class RegisterActivity extends AppCompatActivity {

    Button goToLoginPanel;

    EditText username, password, email, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_panel);

        goToLoginPanel = findViewById(R.id.button_go_to_login_activity);
        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);
        email = findViewById(R.id.email_input);
        age = findViewById(R.id.age_input);

        goToLoginPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean inputFlag;

                UserRegisterValidation userRegisterValidation = new UserRegisterValidation();
                inputFlag = userRegisterValidation.validiate(password.getText().toString(), username.getText().toString(), email.getText().toString());

                if(inputFlag){
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    RegisterActivity.this.startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
