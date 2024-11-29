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
    TextView errorMessage;
    LinearLayout listOfResourcesLL;
    LinearLayout listOfBuildOptionsLL;
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
        listOfBuildOptionsLL = findViewById(R.id.ll_listOfBuildingOptions);
        sabotageBtn = findViewById(R.id.btn_sabotage);
        gameNameText = findViewById(R.id.gameName);
        goldAmountText = findViewById(R.id.goldAmountText);
        woodAmountText = findViewById(R.id.woodAmountText);
        stoneAmountText = findViewById(R.id.stoneAmountText);
        goldMineAmountText = findViewById(R.id.goldMineAmountText);
        treeReserveAmountText = findViewById(R.id.treeReserveAmountText);
        quarryAmountText = findViewById(R.id.quarryAmountText);
        listOfResourcesLL = findViewById(R.id.ll_listOfResources);
        errorMessage = findViewById(R.id.errorMessage);

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
        int building, resource;
        // Gold Collection
        building = 30 * Integer.parseInt(((TextView) goldMineAmountText).getText().toString());
        resource = building + Integer.parseInt(((TextView) goldAmountText).getText().toString());
        ((TextView) goldAmountText).setText(String.valueOf(resource));

        // Wood Collection
        building = 25 * Integer.parseInt(((TextView) treeReserveAmountText).getText().toString());
        resource = building + Integer.parseInt(((TextView) woodAmountText).getText().toString());
        ((TextView) woodAmountText).setText(String.valueOf(resource));

        // Stone Collection
        building = 20 * Integer.parseInt(((TextView) quarryAmountText).getText().toString());
        resource = building + Integer.parseInt(((TextView) stoneAmountText).getText().toString());
        ((TextView) stoneAmountText).setText(String.valueOf(resource));

        errorMessage.setVisibility(View.GONE);
    }
    public void build_catapult(View v){
        int gold, wood, stone;

        gold = Integer.parseInt(((TextView) goldAmountText).getText().toString());
        wood = Integer.parseInt(((TextView) woodAmountText).getText().toString());
        stone = Integer.parseInt(((TextView) stoneAmountText).getText().toString());

        if (gold < 50 || wood < 100 || stone < 70){
            //a popup saying catapult cant be built pops up
            errorMessage.setVisibility(View.VISIBLE);
        } else {
            gold -= 50;
            wood -= 100;
            stone -= 70;
            ((TextView) goldAmountText).setText(String.valueOf(gold));
            ((TextView) woodAmountText).setText(String.valueOf(wood));
            ((TextView) stoneAmountText).setText(String.valueOf(stone));
            errorMessage.setVisibility(View.GONE);
        }
    }

    public void build_goldMine(View v){
        int gold, goldMine_cnt;
        gold = Integer.parseInt(((TextView) goldAmountText).getText().toString());

        if (gold < 80){
            //a popup saying goldmine cant be built pops up
            errorMessage.setVisibility(View.VISIBLE);
        } else {
            gold -= 80;
            ((TextView) goldAmountText).setText(String.valueOf(gold));
            goldMine_cnt = 1 + Integer.parseInt(((TextView) goldMineAmountText).getText().toString());
            ((TextView) goldMineAmountText).setText(String.valueOf(goldMine_cnt));
            errorMessage.setVisibility(View.GONE);
        }
    }

    public void build_treeReserve(View v){
        int gold, treeReserve_cnt;
        gold = Integer.parseInt(((TextView) goldAmountText).getText().toString());

        if (gold < 60){
            //a popup saying treereserve cant be built pops up
            errorMessage.setVisibility(View.VISIBLE);
        } else {
            gold -= 60;
            ((TextView) goldAmountText).setText(String.valueOf(gold));
            treeReserve_cnt = 1 + Integer.parseInt(((TextView) treeReserveAmountText).getText().toString());
            ((TextView) treeReserveAmountText).setText(String.valueOf(treeReserve_cnt));
            errorMessage.setVisibility(View.GONE);
        }
    }

    public void build_quarry(View v){
        int gold, quarry_cnt;
        gold = Integer.parseInt(((TextView) goldAmountText).getText().toString());

        if (gold < 70){
            //a popup saying quarry cant be built pops up
            errorMessage.setVisibility(View.VISIBLE);
        } else {
            gold -= 70;
            ((TextView) goldAmountText).setText(String.valueOf(gold));
            quarry_cnt = 1 + Integer.parseInt(((TextView) quarryAmountText).getText().toString());
            ((TextView) quarryAmountText).setText(String.valueOf(quarry_cnt));
            errorMessage.setVisibility(View.GONE);
        }
    }
    public void sabotage(View v){
        int gold, wood, stone;

        gold = Integer.parseInt(((TextView) goldAmountText).getText().toString());
        wood = Integer.parseInt(((TextView) woodAmountText).getText().toString());
        stone = Integer.parseInt(((TextView) stoneAmountText).getText().toString());

        if (gold < 150 || wood < 150 || stone < 150){
            //a popup saying sabotage cant happen pops up
            errorMessage.setVisibility(View.VISIBLE);
        } else {
            gold -= 150;
            wood -= 150;
            stone -= 150;
            ((TextView) goldAmountText).setText(String.valueOf(gold));
            ((TextView) woodAmountText).setText(String.valueOf(wood));
            ((TextView) stoneAmountText).setText(String.valueOf(stone));
            errorMessage.setVisibility(View.GONE);
        }
    }
}