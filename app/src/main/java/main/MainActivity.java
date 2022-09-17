package main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.example.ex_1.R;
import com.example.ex_1.databinding.ActivityMainBinding;

import main.model.User;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private ActivityMainBinding layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = DataBindingUtil.setContentView(this, R.layout.activity_main);

        User user = User.getUserById(getIntent().getIntExtra("userId", -1));
        Log.d(TAG, user.getName());
        layout.setUser(user);
    }
}