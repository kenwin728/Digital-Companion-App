package com.example.digitalcompanionapp;

import android.content.Intent;
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
        Intent intent = new Intent(MainActivity.this, EnemyGridActivity.class);
        startActivity(intent);
    }
    public void collect(View v){
        View view;
        int building, resource;
        // Gold Collection
        view = findViewById(R.id.goldMineAmountText);
        building = 30 * Integer.parseInt(((TextView) view).getText().toString());
        view = findViewById(R.id.goldAmountText);
        resource = building + Integer.parseInt(((TextView) view).getText().toString());
        ((TextView) view).setText(String.valueOf(resource));

        // Wood Collection
        view = findViewById(R.id.treeReserveAmountText);
        building = 25 * Integer.parseInt(((TextView) view).getText().toString());
        view = findViewById(R.id.woodAmountText);
        resource = building + Integer.parseInt(((TextView) view).getText().toString());
        ((TextView) view).setText(String.valueOf(resource));

        // Wood Collection
        view = findViewById(R.id.quarryAmountText);
        building = 20 * Integer.parseInt(((TextView) view).getText().toString());
        view = findViewById(R.id.stoneAmountText);
        resource = building + Integer.parseInt(((TextView) view).getText().toString());
        ((TextView) view).setText(String.valueOf(resource));
    }
    public void build(View v){
        //ill make the 4 buttons first
    }
    public void sabotage(View v){
        View goldView, woodView, stoneView;
        int gold, wood, stone;

        goldView = findViewById(R.id.goldAmountText);
        gold = Integer.parseInt(((TextView) goldView).getText().toString());
        woodView = findViewById(R.id.woodAmountText);
        wood = Integer.parseInt(((TextView) woodView).getText().toString());
        stoneView = findViewById(R.id.stoneAmountText);
        stone = Integer.parseInt(((TextView) stoneView).getText().toString());

        if (gold < 150 || wood < 150 || stone < 150){
            //a popup saying sabotage cant happen pops up
        } else {
            gold -= 150;
            wood -= 150;
            stone -= 150;
            ((TextView) goldView).setText(String.valueOf(gold));
            ((TextView) woodView).setText(String.valueOf(wood));
            ((TextView) stoneView).setText(String.valueOf(stone));
        }
    }
}