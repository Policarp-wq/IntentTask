package com.policarp.intenttask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.policarp.intenttask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    static final String KEY = "key";
    static final int REQUEST_CODE = 123;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String txt = getIntent().getStringExtra(KEY);
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
        binding.GO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(KEY, binding.ET.getText().toString());
                startActivityForResult(intent, REQUEST_CODE);
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