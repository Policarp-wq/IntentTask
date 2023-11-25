package com.policarp.intenttask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.policarp.intenttask.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {

    public static final String KEY = "key";
    public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFirstBinding binding = ActivityFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.Activity1GoTo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSecond = new Intent(FirstActivity.this, SecondActivity.class);
                toSecond.putExtra(KEY, "Hello from first");
                startActivityForResult(toSecond, REQUEST_CODE);
            }
        });
        binding.Activity1GoTo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toThird = new Intent(FirstActivity.this, ThirdActivity.class);
                toThird.putExtra(KEY, "Hello from first");
                startActivityForResult(toThird, REQUEST_CODE);
            }
        });
        binding.Back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(KEY, "Back from first");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String a = data.getStringExtra(KEY);
            Toast.makeText(this, a, Toast.LENGTH_LONG).show();
        }
    }
}