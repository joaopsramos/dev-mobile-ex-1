package main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ex_1.R;

import main.model.User;

public class LoginActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        User.createUsers();

        TextView username_input = findViewById(R.id.username);
        TextView password_input = findViewById(R.id.password);

        findViewById(R.id.loginButton).setOnClickListener((view) -> {
            Log.d(TAG, "login clicked");
            Log.d(TAG, username_input.getText().toString());
            Log.d(TAG, password_input.getText().toString());

            User found_user = User.login(username_input.getText().toString(), password_input.getText().toString());

            if (found_user == null) {
                System.out.println("Wrong username/password, please try again.");
            } else {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}