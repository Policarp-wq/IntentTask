package com.policarp.intenttask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.policarp.intenttask.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    public static final String KEY = "key";
    static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String txt = getIntent().getStringExtra(KEY);
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
        binding.Activity2GoTo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSecond = new Intent(SecondActivity.this, FirstActivity.class);
                toSecond.putExtra(KEY, "Hello from second");
                startActivityForResult(toSecond, REQUEST_CODE);
            }
        });
        binding.Activity2GoTo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toThird = new Intent(SecondActivity.this, ThirdActivity.class);
                toThird.putExtra(KEY, "Hello from second");
                startActivityForResult(toThird, REQUEST_CODE);
            }
        });
        binding.Back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(KEY, "Back from second");
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