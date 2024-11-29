package com.example.digitalcompanionapp;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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
    TextView gameNameText;
    TextView goldAmountText;
    TextView woodAmountText;
    TextView stoneAmountText;
    TextView goldMineAmountText;
    TextView treeReserveAmountText;
    TextView quarryAmountText;
    LinearLayout listOfResourcesLL;
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
        gameNameText = findViewById(R.id.gameName);
        goldAmountText = findViewById(R.id.goldAmountText);
        woodAmountText = findViewById(R.id.woodAmountText);
        stoneAmountText = findViewById(R.id.stoneAmountText);
        goldMineAmountText = findViewById(R.id.goldMineAmountText);
        treeReserveAmountText = findViewById(R.id.treeReserveAmountText);
        quarryAmountText = findViewById(R.id.quarryAmountText);
        listOfResourcesLL = findViewById(R.id.ll_listOfResources);

        // Create a GradientDrawable for the border
        GradientDrawable borderDrawable = new GradientDrawable();
        borderDrawable.setColor(Color.TRANSPARENT); // Background color inside the border
        borderDrawable.setStroke(10, Color.BLACK); // Border width (in pixels) and color

        // Set the drawable as the background of the TextView
        gameNameText.setBackground(borderDrawable);
        listOfResourcesLL.setBackground(borderDrawable);
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