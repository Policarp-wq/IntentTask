package com.policarp.intenttask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.policarp.intenttask.databinding.ActivityFirstBinding;
import com.policarp.intenttask.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {
    public static final String KEY = "key";
    static final int REQUEST_CODE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThirdBinding binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String txt = getIntent().getStringExtra(KEY);
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
        binding.Activity3GoTo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSecond = new Intent(ThirdActivity.this, SecondActivity.class);
                toSecond.putExtra(KEY, "Hello from third");
                startActivityForResult(toSecond, REQUEST_CODE);
            }
        });
        binding.Activity3GoTo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFirst = new Intent(ThirdActivity.this, FirstActivity.class);
                toFirst.putExtra(KEY, "Hello from third");
                startActivityForResult(toFirst, REQUEST_CODE);
            }
        });
        binding.Back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(KEY, "Back from third");
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