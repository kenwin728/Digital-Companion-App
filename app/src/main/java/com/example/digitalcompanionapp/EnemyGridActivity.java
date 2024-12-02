package com.example.digitalcompanionapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EnemyGridActivity extends AppCompatActivity {
    TextView gameNameText;

    TextView enemyText;
    GridLayout enemyGridLL;
    private ImageButton[][] enemyTile = new ImageButton[6][6];
    Button Rerererewindddd;

    private String enemy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enemy_grid);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gameNameText = findViewById(R.id.E_gameName);
        enemyText = findViewById(R.id.enemyName);
        Rerererewindddd = findViewById(R.id.resetBtn);
        enemyGridLL = findViewById(R.id.ll_EnemyGrid);

        // Create a GradientDrawable for the border
        GradientDrawable borderDrawable = new GradientDrawable();
        borderDrawable.setColor(Color.TRANSPARENT); // Background color inside the border
        borderDrawable.setStroke(10, Color.BLACK); // Border width (in pixels) and color

        gameNameText.setBackground(borderDrawable);
        enemyGridLL.setBackground(borderDrawable);

        Intent intent = getIntent();
        enemy = intent.getStringExtra("grid_type");

        if (enemy != null) {
            switch (enemy) {
                case "grid1":
                    // Customize for grid 1
                    enemyText.setText("Enemy 1");
                    break;
                case "grid2":
                    // Customize for grid 2
                    enemyText.setText("Enemy 2");
                    break;
                case "grid3":
                    // Customize for grid 3
                    enemyText.setText("Enemy 3");
                    break;
            }
        }

        // It's a 6x6 grid
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {

                ImageButton butt_on = new ImageButton(this);
                butt_on.setLayoutParams(new GridLayout.LayoutParams());
                butt_on.setBackgroundColor(Color.parseColor("#b08f5a"));
                //butt_on.setImageDrawable(null);
                butt_on.setScaleType(ImageButton.ScaleType.FIT_CENTER);
                butt_on.setPadding(0, 0, 0, 0);

                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(row, 1);
                params.columnSpec = GridLayout.spec(col, 1);
                params.width = 0;
                params.height = 0;
                params.setMargins(10, 10, 10, 10);
                params.rowSpec = GridLayout.spec(row, 1f); // Stretch buttons evenly
                params.columnSpec = GridLayout.spec(col, 1f);
                butt_on.setLayoutParams(params);

                // Add a unique tag to each button (optional)
                butt_on.setTag(row + "," + col);

                butt_on.setOnClickListener(new View.OnClickListener() {
                    private int state = 0;

                    @Override
                    public void onClick(View v) {
                        state++;
                        if (state == 3){
                            state = 0;
                        }
                        if (state == 1 || butt_on.getDrawable() == null) {
                            butt_on.setImageResource(R.drawable.guess);
                            state = 1;
                        } else if (state == 0) {
                            butt_on.setImageDrawable(null);
                        } else {
                            butt_on.setImageResource(R.drawable.destroyed);
                        }
                    }
                });

                enemyGridLL.addView(butt_on);
                enemyTile[row][col] = butt_on;
            }
        }
        Rerererewindddd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset(); // Does exactly like it says
            }
        });
    }
    private void reset() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                ImageButton butt_on = enemyTile[row][col];
                if (butt_on.getDrawable() != null) {
                    butt_on.setImageDrawable(null);
                }
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences("enemygrid_data" + enemy, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Save the state of each button in the grid (6x6 grid)
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                ImageButton button = enemyTile[row][col];
                // Save the state of the button: null, guess, or destroyed
                String state = getButtonState(button);
                editor.putString(row + "," + col, state);  // Using the position as key
            }
        }
        editor.apply();  // Save the changes
    }

    private String getButtonState(ImageButton button) {
        if (button.getDrawable() == null) {
            return "null";
        } else if (button.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.guess).getConstantState())) {
            return "guess";
        } else if (button.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.destroyed).getConstantState())) {
            return "destroyed";
        }
        return "null";  // Default state
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("enemy_grid_data", MODE_PRIVATE);
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                ImageButton button = enemyTile[row][col];
                String state = sharedPreferences.getString(row + "," + col, "null");
                update(button, state);
            }
        }
    }

    private void update(ImageButton button, String state) {
        if (state.equals("null")) {
            button.setImageDrawable(null);
        } else if (state.equals("guess")) {
            button.setImageResource(R.drawable.guess);
        } else {
            button.setImageResource(R.drawable.destroyed);
        }
    }
}