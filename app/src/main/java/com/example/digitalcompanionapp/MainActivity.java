package com.example.digitalcompanionapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button enemyGridsBtn;
    Button collectBtn;
    Button buildBtn;
    Button sabotageBtn;
    TextView goldAmountText;
    TextView woodAmountText;
    TextView stoneAmountText;
    TextView goldMineAmountText;
    TextView treeReserveAmountText;
    TextView quarryAmountText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        enemyGridsBtn = findViewById(R.id.btn_enemyGrids);
        collectBtn = findViewById(R.id.btn_collect);
        buildBtn = findViewById(R.id.btn_build);
        sabotageBtn = findViewById(R.id.btn_sabotage);
        goldAmountText = findViewById(R.id.goldAmountText);
        woodAmountText = findViewById(R.id.woodAmountText);
        stoneAmountText = findViewById(R.id.stoneAmountText);
        goldMineAmountText = findViewById(R.id.goldMineAmountText);
        treeReserveAmountText = findViewById(R.id.treeReserveAmountText);
        quarryAmountText = findViewById(R.id.quarryAmountText);
    }
    public void enemyGrids(View v){

    }
    public void collect(View v){

    }
    public void build(View v){

    }
    public void sabotage(View v){

    }
}