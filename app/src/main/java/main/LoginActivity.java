package main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ex_1.R;
import com.example.ex_1.databinding.ActivityLoginBinding;

import main.model.User;

public class LoginActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private ActivityLoginBinding layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = DataBindingUtil.setContentView(this, R.layout.activity_login);

        TextView username= findViewById(R.id.username);
        TextView password= findViewById(R.id.password);

        User.createUsers();

        findViewById(R.id.loginButton).setOnClickListener((view) -> {
            Log.d(TAG, "login clicked");
            Log.d(TAG, username.getText().toString());
            Log.d(TAG, password.getText().toString());

            layout.setErrorMsg("");

            User user = User.login(username.getText().toString(), password.getText().toString());

            if (user == null) {
                layout.setErrorMsg("Usuário ou senha inváidos, tente novamente.");
            } else {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                Log.d(TAG, user.getId() + "joao");
                intent.putExtra("userId", user.getId());

                startActivity(intent);
            }
        });
    }
}