package com.example.digitalcompanionapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button enemyGridsBtn1, enemyGridsBtn2, enemyGridsBtn3;
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
    EditText goldEditText;
    EditText stoneEditText;
    EditText woodEditText;
    EditText goldMineEditText;
    EditText treeReserveEditText;
    EditText quarryEditText;

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
        enemyGridsBtn1 = findViewById(R.id.btn_enemyGrids1);
        enemyGridsBtn2 = findViewById(R.id.btn_enemyGrids2);
        enemyGridsBtn3 = findViewById(R.id.btn_enemyGrids3);
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
        goldEditText = findViewById(R.id.editText_gold);
        woodEditText = findViewById(R.id.editText_wood);
        stoneEditText = findViewById(R.id.editText_stone);
        goldMineEditText = findViewById(R.id.editText_goldMine);
        treeReserveEditText = findViewById(R.id.editText_treeReserve);
        quarryEditText = findViewById(R.id.editText_quarry);

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
        /*
        int number = (int) v.getTag();  // Use (int) to cast the tag as an integer.
        if (number == 1) {
            intent.putExtra("grid_type", "grid1");
        } else if (number == 2) {
            intent.putExtra("grid_type", "grid2");
        } else {
            intent.putExtra("grid_type", "grid3");
        }

         */
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

    public void updateGold(View v){
        String goldString = goldEditText.getText().toString().trim();
        if (goldString.isEmpty()){
            Toast.makeText(MainActivity.this, "No input!", Toast.LENGTH_SHORT).show();
        }
        else{
            int gold = Integer.parseInt(goldString);
            goldAmountText.setText(String.valueOf(gold));
        }
        goldEditText.setText("");
    }
    public void updateStone(View v){
        String stoneString =stoneEditText.getText().toString().trim();
        if (stoneString.isEmpty()){
            Toast.makeText(MainActivity.this, "No input!", Toast.LENGTH_SHORT).show();
        }
        else{
            int stone = Integer.parseInt(stoneString);
            stoneAmountText.setText(String.valueOf(stone));
        }
        stoneEditText.setText("");
    }
    public void updateWood(View v){
        String woodString = woodEditText.getText().toString().trim();
        if (woodString.isEmpty()){
            Toast.makeText(MainActivity.this, "No input!", Toast.LENGTH_SHORT).show();
        }
        else{
            int wood = Integer.parseInt(woodString);
            woodAmountText.setText(String.valueOf(wood));
        }
        woodEditText.setText("");
    }
    public void updateGoldMine(View v){
        String goldMineString = goldMineEditText.getText().toString().trim();
        if (goldMineString.isEmpty()){
            Toast.makeText(MainActivity.this, "No input!", Toast.LENGTH_SHORT).show();
        }
        else{
            int goldMine = Integer.parseInt(goldMineString);
            goldMineAmountText.setText(String.valueOf(goldMine));
        }
        goldMineEditText.setText("");
    }
    public void updateTreeReserve(View v){
        String treeReserveString = treeReserveEditText.getText().toString().trim();
        if (treeReserveString.isEmpty()){
            Toast.makeText(MainActivity.this, "No input!", Toast.LENGTH_SHORT).show();
        }
        else{
            int treeReserve = Integer.parseInt(treeReserveString);
            treeReserveAmountText.setText(String.valueOf(treeReserve));
        }
        treeReserveEditText.setText("");
    }
    public void updateQuarry(View v){
        String quarryString = quarryEditText.getText().toString().trim();
        if (quarryString.isEmpty()){
            Toast.makeText(MainActivity.this, "No input!", Toast.LENGTH_SHORT).show();
        }
        else{
            int quarry = Integer.parseInt(quarryString);
            quarryAmountText.setText(String.valueOf(quarry));
        }
        quarryEditText.setText("");
    }
}