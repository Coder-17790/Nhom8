package com.example.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Nguyễn Hoàng Tuấn"); // Thiết lập tiêu đề
        actionBar.setLogo(R.drawable.ic_action_name);
        actionBar.setDisplayHomeAsUpEnabled(true); //Tạo nút quay lại
        actionBar.setDisplayUseLogoEnabled(false);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void click_go(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.app_bar_search:
                Toast.makeText(getApplicationContext(), "Tìm kiếm", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Nguyễn Hoàng Tuấn", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Trần Quang Hậu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(), "Nguyễn Nguyên Bảo", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(getApplicationContext(), "Đoàn Xuân Tuấn", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item5:
                Toast.makeText(getApplicationContext(), "Từ Công Trường", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.app_shared:
                Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}