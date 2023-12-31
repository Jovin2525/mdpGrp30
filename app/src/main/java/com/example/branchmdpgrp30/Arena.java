package com.example.branchmdpgrp30;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.animation.ObjectAnimator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Arena extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    private static final String TAG = "Arena:DEBUG";
    public static boolean firstStart = true;

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putFloat("obs1X", findViewById(R.id.obstacle1).getTranslationX());
        editor.putFloat("obs1Y", findViewById(R.id.obstacle1).getTranslationY());
        editor.putFloat("obs1Rotation", findViewById(R.id.obstacle1).getRotation());

        editor.putFloat("obs2X", findViewById(R.id.obstacle2).getTranslationX());
        editor.putFloat("obs2Y", findViewById(R.id.obstacle2).getTranslationY());
        editor.putFloat("obs2Rotation", findViewById(R.id.obstacle2).getRotation());

        editor.putFloat("obs3X", findViewById(R.id.obstacle3).getTranslationX());
        editor.putFloat("obs3Y", findViewById(R.id.obstacle3).getTranslationY());
        editor.putFloat("obs3Rotation", findViewById(R.id.obstacle3).getRotation());

        editor.putFloat("obs4X", findViewById(R.id.obstacle4).getTranslationX());
        editor.putFloat("obs4Y", findViewById(R.id.obstacle4).getTranslationY());
        editor.putFloat("obs4Rotation", findViewById(R.id.obstacle4).getRotation());

        editor.putFloat("obs5X", findViewById(R.id.obstacle5).getTranslationX());
        editor.putFloat("obs5Y", findViewById(R.id.obstacle5).getTranslationY());
        editor.putFloat("obs5Rotation", findViewById(R.id.obstacle5).getRotation());

        editor.putFloat("obs6X", findViewById(R.id.obstacle6).getTranslationX());
        editor.putFloat("obs6Y", findViewById(R.id.obstacle6).getTranslationY());
        editor.putFloat("obs6Rotation", findViewById(R.id.obstacle6).getRotation());

        editor.putFloat("obs7X", findViewById(R.id.obstacle7).getTranslationX());
        editor.putFloat("obs7Y", findViewById(R.id.obstacle7).getTranslationY());
        editor.putFloat("obs7Rotation", findViewById(R.id.obstacle7).getRotation());

        editor.putFloat("obs8X", findViewById(R.id.obstacle8).getTranslationX());
        editor.putFloat("obs8Y", findViewById(R.id.obstacle8).getTranslationY());
        editor.putFloat("obs8Rotation", findViewById(R.id.obstacle8).getRotation());

        editor.putFloat("carX", findViewById(R.id.car).getTranslationX());
        editor.putFloat("carY", findViewById(R.id.car).getTranslationY());
        editor.putFloat("carRotation", findViewById(R.id.car).getRotation());

        int x = (int) (car.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
        int y = (int) (car.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;

        editor.putString("x_tv", String.valueOf(car_x.getText()));
        editor.putString("y_tv", String.valueOf(car_y.getText()));
        editor.putString("car_dir", String.valueOf(car_dir.getText()));
        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        obstacle1.setX(sharedPreferences.getFloat("obs1X", 0.0f));
        obstacle1.setY(sharedPreferences.getFloat("obs1Y", 0.0f));
        obstacle1.setRotation((sharedPreferences.getFloat("obs1Rotation", 0.0f)));

        obstacle2.setX(sharedPreferences.getFloat("obs2X", 0.0f));
        obstacle2.setY(sharedPreferences.getFloat("obs2Y", 0.0f));
        obstacle2.setRotation((sharedPreferences.getFloat("obs2Rotation", 0.0f)));

        obstacle3.setX(sharedPreferences.getFloat("obs3X", 0.0f));
        obstacle3.setY(sharedPreferences.getFloat("obs3Y", 0.0f));
        obstacle3.setRotation((sharedPreferences.getFloat("obs3Rotation", 0.0f)));

        obstacle4.setX(sharedPreferences.getFloat("obs4X", 0.0f));
        obstacle4.setY(sharedPreferences.getFloat("obs4Y", 0.0f));
        obstacle4.setRotation((sharedPreferences.getFloat("obs4Rotation", 0.0f)));

        obstacle5.setX(sharedPreferences.getFloat("obs5X", 0.0f));
        obstacle5.setY(sharedPreferences.getFloat("obs5Y", 0.0f));
        obstacle5.setRotation((sharedPreferences.getFloat("obs5Rotation", 0.0f)));

        obstacle6.setX(sharedPreferences.getFloat("obs6X", 0.0f));
        obstacle6.setY(sharedPreferences.getFloat("obs6Y", 0.0f));
        obstacle6.setRotation((sharedPreferences.getFloat("obs6Rotation", 0.0f)));

        obstacle7.setX(sharedPreferences.getFloat("obs7X", 0.0f));
        obstacle7.setY(sharedPreferences.getFloat("obs7Y", 0.0f));
        obstacle7.setRotation((sharedPreferences.getFloat("obs7Rotation", 0.0f)));

        obstacle8.setX(sharedPreferences.getFloat("obs8X", 0.0f));
        obstacle8.setY(sharedPreferences.getFloat("obs8Y", 0.0f));
        obstacle8.setRotation((sharedPreferences.getFloat("obs8Rotation", 0.0f)));

        car.setX(sharedPreferences.getFloat("carX", 0.0f));
        car.setY(sharedPreferences.getFloat("carY", 0.0f));
        car.setRotation(sharedPreferences.getFloat("carRotation", 0.0f));

        car_x.setText((sharedPreferences.getString("x_tv", "")));
        car_y.setText((sharedPreferences.getString("y_tv", "")));
        car_dir.setText((sharedPreferences.getString("car_dir", "")));
        Log.d(TAG, "obs1X: " + Float.toString(sharedPreferences.getFloat("obs1X", 0.0f)));
    }

    private static final int SNAP_GRID_INTERVAL = 35;
    private static final int ANIMATOR_DURATION = 100;

    /*
     * start from (1,1)
     * NOTE: remember to invert y
     */
    private final int INITIAL_X = 1 * SNAP_GRID_INTERVAL - SNAP_GRID_INTERVAL;
    private final int INITIAL_Y = 18 * SNAP_GRID_INTERVAL - SNAP_GRID_INTERVAL;

    private boolean canSetObstacles = false;
    private String curMode = "IDLE";

    Button IRButton, SPButton, resetButton, setButton, timerButton; //saveButton,preset1Button;
    ImageView obstacle1, obstacle2, obstacle3, obstacle4, obstacle5, obstacle6, obstacle7, obstacle8, car;
    TextView statusWindow, car_x, car_y, car_dir;

    Map<Integer, ImageView> obstacles;

    // RecyclerView
    ArrayList<String> s1 = new ArrayList<String>();
    ArrayList<Integer> images = new ArrayList<Integer>();
    RecyclerView recyclerView;

    protected void onPause() {
        super.onPause();
        Log.d("onpause", "OnPause() called");
        saveData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Restore saved instance state
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");

        setContentView(R.layout.arena);

        // start listening for incoming messages
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, new IntentFilter("incomingMessage"));

        initObstacles();
        initButtons();
        initMovementButtons();

        if (!firstStart) {
            loadData();
        } else {
            firstStart = false;
            saveData();
        }
        showReceived = findViewById(R.id.chatlog_tv);;
        showReceived.setMovementMethod(new ScrollingMovementMethod());
    }
    private String getDirection(int orientation){
        if (orientation == 0) {
            return "N";
        } else if (orientation == 90) {
            return "E";
        } else if (orientation == 180) {
            return "S";
        } else if (orientation == 270) {
            return "W";
        } else {
            return "N";
        }
    }

    private String getObstacleSend(int xCoord, int yCoordFinal, int rotateOrAdd, String direction, String obstacleNo){
        String infoToSend= "Error, No Info";
        switch (rotateOrAdd){
            case 0: //rotate
                if(xCoord > 19 || yCoordFinal > 19 || yCoordFinal < 0){
                    infoToSend = "ROTATE," + obstacleNo + ",Out Of Grid," + direction;
                }
                else{
                    infoToSend = "ROTATE," + obstacleNo + ",(" + xCoord + "," + yCoordFinal + ")," + direction;
                }
                break;
            case 1: //add or sub
                if(xCoord > 19 || yCoordFinal > 19 || yCoordFinal < 0){
                    infoToSend = "SUB," + obstacleNo;
                }
                else{
                    infoToSend = "ADD," + obstacleNo + ",(" + xCoord + "," + yCoordFinal + ")," + direction;
                }
                break;
            default:
                break;
        }
        return infoToSend;
    }

    /**
     * Initializes obstacles and setup listeners
     */
    private void initObstacles() {
        car = findViewById(R.id.car);
        car_x = findViewById(R.id.x_tv);
        car_y = findViewById(R.id.y_tv);
        car_dir = findViewById(R.id.dir_tv);
        obstacle1 = findViewById(R.id.obstacle1);
        obstacle2 = findViewById(R.id.obstacle2);
        obstacle3 = findViewById(R.id.obstacle3);
        obstacle4 = findViewById(R.id.obstacle4);
        obstacle5 = findViewById(R.id.obstacle5);
        obstacle6 = findViewById(R.id.obstacle6);
        obstacle7 = findViewById(R.id.obstacle7);
        obstacle8 = findViewById(R.id.obstacle8);

        obstacles = new HashMap<Integer, ImageView>() {
            {
                put(0, car);
                put(1, obstacle1);
                put(2, obstacle2);
                put(3, obstacle3);
                put(4, obstacle4);
                put(5, obstacle5);
                put(6, obstacle6);
                put(7, obstacle7);
                put(8, obstacle8);
            }
        };




        car.setOnClickListener(view -> {
            car.setRotation((car.getRotation() + 90) % 360);
            updateXYDirText();
        });

        obstacle1.setOnClickListener(view -> {
            obstacle1.setRotation((obstacle1.getRotation() + 90) % 360);
            int orientation = (int) obstacle1.getRotation();
//            String direction = getDirection(orientation);
            String infoToSend = "";
            byte[] bytes = null;
            int xCoord = (int) (obstacle1.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
            int yCoord = (int) (obstacle1.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
            int yCoordFinal = 20 - yCoord;

            switch (((orientation / 90) % 4 + 4) % 4) {
                case 0:
                    obstacle1.setImageResource(Helper.resources.get("o1n"));
//                    infoToSend = "ROTATE,Obstacle1," + direction;
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "N", "Obstacle1");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 1:
                    obstacle1.setImageResource(Helper.resources.get("o1e"));
//                    infoToSend = "ROTATE,Obstacle1," + direction;
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "E", "Obstacle1");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 2:
                    obstacle1.setImageResource(Helper.resources.get("o1s"));
//                    infoToSend = "ROTATE,Obstacle1," + direction;
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "S", "Obstacle1");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 3:
                    obstacle1.setImageResource(Helper.resources.get("o1w"));
//                    infoToSend = "ROTATE,Obstacle1," + direction;
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "W", "Obstacle1");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
            }
        });

        obstacle2.setOnClickListener(view -> {
            obstacle2.setRotation((obstacle2.getRotation() + 90) % 360);
            int orientation = (int) obstacle2.getRotation();
            String infoToSend = "";
            byte[] bytes = null;
            int xCoord = (int) (obstacle2.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
            int yCoord = (int) (obstacle2.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
            int yCoordFinal = 20 - yCoord;

            switch (((orientation / 90) % 4 + 4) % 4) {
                case 0:
                    obstacle2.setImageResource(Helper.resources.get("o2n"));
//                    infoToSend = "ROTATE,Obstacle2,N";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "N", "Obstacle2");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 1:
                    obstacle2.setImageResource(Helper.resources.get("o2e"));
//                    infoToSend = "ROTATE,Obstacle2,E";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "E", "Obstacle2");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 2:
                    obstacle2.setImageResource(Helper.resources.get("o2s"));
//                    infoToSend = "ROTATE,Obstacle2,S";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "S", "Obstacle2");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 3:
                    obstacle2.setImageResource(Helper.resources.get("o2w"));
//                    infoToSend = "ROTATE,Obstacle2,W";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "W", "Obstacle2");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
            }
        });

        obstacle3.setOnClickListener(view -> {
            obstacle3.setRotation((obstacle3.getRotation() + 90) % 360);
            int orientation = (int) obstacle3.getRotation();
            String infoToSend = "";
            byte[] bytes = null;
            int xCoord = (int) (obstacle3.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
            int yCoord = (int) (obstacle3.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
            int yCoordFinal = 20 - yCoord;
            switch (((orientation / 90) % 4 + 4) % 4) {
                case 0:
                    obstacle3.setImageResource(Helper.resources.get("o3n"));
//                    infoToSend = "ROTATE,Obstacle3,N";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "N", "Obstacle3");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 1:
                    obstacle3.setImageResource(Helper.resources.get("o3e"));
//                    infoToSend = "ROTATE,Obstacle3,E";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "E", "Obstacle3");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 2:
                    obstacle3.setImageResource(Helper.resources.get("o3s"));
//                    infoToSend = "ROTATE,Obstacle3,S";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "S", "Obstacle3");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 3:
                    obstacle3.setImageResource(Helper.resources.get("o3w"));
//                    infoToSend = "ROTATE,Obstacle3,W";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "W", "Obstacle3");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
            }
        });

        obstacle4.setOnClickListener(view -> {
            obstacle4.setRotation((obstacle4.getRotation() + 90) % 360);
            int orientation = (int) obstacle4.getRotation();
            String infoToSend = "";
            byte[] bytes = null;
            int xCoord = (int) (obstacle4.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
            int yCoord = (int) (obstacle4.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
            int yCoordFinal = 20 - yCoord;
            switch (((orientation / 90) % 4 + 4) % 4) {
                case 0:
                    obstacle4.setImageResource(Helper.resources.get("o4n"));
//                    infoToSend = "ROTATE,Obstacle4,N";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "N", "Obstacle4");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 1:
                    obstacle4.setImageResource(Helper.resources.get("o4e"));
//                    infoToSend = "ROTATE,Obstacle4,E";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "E", "Obstacle4");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 2:
                    obstacle4.setImageResource(Helper.resources.get("o4s"));
//                    infoToSend = "ROTATE,Obstacle4,S";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "S", "Obstacle4");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 3:
                    obstacle4.setImageResource(Helper.resources.get("o4w"));
//                    infoToSend = "ROTATE,Obstacle4,W";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "W", "Obstacle4");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
            }
        });

        obstacle5.setOnClickListener(view -> {
            obstacle5.setRotation((obstacle5.getRotation() + 90) % 360);
            int orientation = (int) obstacle5.getRotation();
            String infoToSend = "";
            byte[] bytes = null;
            int xCoord = (int) (obstacle5.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
            int yCoord = (int) (obstacle5.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
            int yCoordFinal = 20 - yCoord;
            switch (((orientation / 90) % 4 + 4) % 4) {
                case 0:
                    obstacle5.setImageResource(Helper.resources.get("o5n"));
//                    infoToSend = "ROTATE,Obstacle5,N";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "N", "Obstacle5");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 1:
                    obstacle5.setImageResource(Helper.resources.get("o5e"));
//                    infoToSend = "ROTATE,Obstacle5,E";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "E", "Obstacle5");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 2:
                    obstacle5.setImageResource(Helper.resources.get("o5s"));
//                    infoToSend = "ROTATE,Obstacle5,S";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "S", "Obstacle5");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 3:
                    obstacle5.setImageResource(Helper.resources.get("o5w"));
//                    infoToSend = "ROTATE,Obstacle5,W";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "W", "Obstacle5");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
            }
        });

        obstacle6.setOnClickListener(view -> {
            obstacle6.setRotation((obstacle6.getRotation() + 90) % 360);
            int orientation = (int) obstacle6.getRotation();
            String infoToSend = "";
            byte[] bytes = null;
            int xCoord = (int) (obstacle6.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
            int yCoord = (int) (obstacle6.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
            int yCoordFinal = 20 - yCoord;
            switch (((orientation / 90) % 4 + 4) % 4) {
                case 0:
                    obstacle6.setImageResource(Helper.resources.get("o6n"));
//                    infoToSend = "ROTATE,Obstacle6,N";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "N", "Obstacle6");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 1:
                    obstacle6.setImageResource(Helper.resources.get("o6e"));
//                    infoToSend = "ROTATE,Obstacle6,E";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "E", "Obstacle6");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 2:
                    obstacle6.setImageResource(Helper.resources.get("o6s"));
//                    infoToSend = "ROTATE,Obstacle6,S";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "S", "Obstacle6");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 3:
                    obstacle6.setImageResource(Helper.resources.get("o6w"));
//                    infoToSend = "ROTATE,Obstacle6,W";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "W", "Obstacle6");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
            }
        });

        obstacle7.setOnClickListener(view -> {
            obstacle7.setRotation((obstacle7.getRotation() + 90) % 360);
            int orientation = (int) obstacle7.getRotation();
            String infoToSend = "";
            byte[] bytes = null;
            int xCoord = (int) (obstacle7.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
            int yCoord = (int) (obstacle7.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
            int yCoordFinal = 20 - yCoord;
            switch (((orientation / 90) % 4 + 4) % 4) {
                case 0:
                    obstacle7.setImageResource(Helper.resources.get("o7n"));
//                    infoToSend = "ROTATE,Obstacle7,N";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "N", "Obstacle7");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 1:
                    obstacle7.setImageResource(Helper.resources.get("o7e"));
//                    infoToSend = "ROTATE,Obstacle7,E";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "E", "Obstacle7");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 2:
                    obstacle7.setImageResource(Helper.resources.get("o7s"));
//                    infoToSend = "ROTATE,Obstacle7,S";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "S", "Obstacle7");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 3:
                    obstacle7.setImageResource(Helper.resources.get("o7w"));
//                    infoToSend = "ROTATE,Obstacle7,W";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "W", "Obstacle7");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
            }
        });

        obstacle8.setOnClickListener(view -> {
            obstacle8.setRotation((obstacle8.getRotation() + 90) % 360);
            int orientation = (int) obstacle8.getRotation();
            String infoToSend = "";
            byte[] bytes = null;
            int xCoord = (int) (obstacle8.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
            int yCoord = (int) (obstacle8.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
            int yCoordFinal = 20 - yCoord;
            switch (((orientation / 90) % 4 + 4) % 4) {
                case 0:
                    obstacle8.setImageResource(Helper.resources.get("o8n"));
//                    infoToSend = "ROTATE,Obstacle8,N";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "N", "Obstacle8");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 1:
                    obstacle8.setImageResource(Helper.resources.get("o8e"));
//                    infoToSend = "ROTATE,Obstacle8,E";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "E", "Obstacle8");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 2:
                    obstacle8.setImageResource(Helper.resources.get("o8s"));
//                    infoToSend = "ROTATE,Obstacle8,S";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "S", "Obstacle8");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
                case 3:
                    obstacle8.setImageResource(Helper.resources.get("o8w"));
//                    infoToSend = "ROTATE,Obstacle8,W";
                    infoToSend = getObstacleSend(xCoord, yCoordFinal, 0, "W", "Obstacle8");
                    bytes = infoToSend.getBytes(Charset.defaultCharset());
                    BluetoothService.write(bytes);
                    break;
            }
        });


        car.setOnTouchListener(new View.OnTouchListener() {
            int x = 0;
            int y = 0;
            int dx = 0;
            int dy = 0;
            int orientation;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!canSetObstacles) {
                    return false;
                }
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getX();
                        y = (int) event.getY();
                        orientation = (int) car.getRotation();
                        car.setRotation(0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = (int) event.getX() - x;
                        dy = (int) event.getY() - y;

                        car.setX(car.getX() + dx);
                        car.setY(car.getY() + dy);
                        break;
                    case MotionEvent.ACTION_UP:
                        int snapToX = ((int) ((car.getX() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        int snapToY = ((int) ((car.getY() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        Log.d(TAG, "robot is at " + snapToX + "," + snapToY);

                        car.setX(snapToX);
                        car.setY(snapToY);
                        int xCoord = (int) (car.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
                        int yCoord = (int) (car.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
                        // (0,0) starts from top left hence invert y
                        int yCoordFinal = 20 - yCoord - 1;
                        updateXYDirText();
                        car.setRotation(orientation % 360);
                        String direction = getDirection(orientation);
                        String infoToSend = "Error, no info added";
                        if(xCoord > 18 || yCoordFinal > 18 || yCoordFinal < 1){
                            infoToSend = "SUB,robot";
                        }
                        else{
                            infoToSend = "ADD,robot,(" + xCoord + "," + yCoordFinal + ")," + direction;
                        }
                        byte[] bytes = infoToSend.getBytes(Charset.defaultCharset());
                        BluetoothService.write(bytes);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        obstacle1.setOnTouchListener(new View.OnTouchListener() {
            int x = 0;
            int y = 0;
            int dx = 0;
            int dy = 0;
            int orientation;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!canSetObstacles) {
                    return false;
                }
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getX();
                        y = (int) event.getY();
                        orientation = (int) obstacle1.getRotation();
                        obstacle1.setRotation(0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = (int) event.getX() - x;
                        dy = (int) event.getY() - y;

                        obstacle1.setX(obstacle1.getX() + dx);
                        obstacle1.setY(obstacle1.getY() + dy);
                        break;
                    case MotionEvent.ACTION_UP:
                        int snapToX = ((int) ((obstacle1.getX() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        int snapToY = ((int) ((obstacle1.getY() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                         Log.d(TAG, "obstacle1 is at " + snapToX + "," + snapToY);
                        obstacle1.setX(snapToX);
                        obstacle1.setY(snapToY);
                        obstacle1.setRotation(orientation % 360);
                        String direction = getDirection(orientation);
                        int xCoord = (int) (obstacle1.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
                        int yCoord = (int) (obstacle1.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
                        // (0,0) starts from top left hence invert y
                        int yCoordFinal = 20 - yCoord;
                        String infoToSend = "";
                        infoToSend = getObstacleSend(xCoord, yCoordFinal, 1, direction, "Obstacle1");
//                        if(xCoord > 19 || yCoordFinal > 19 || yCoordFinal < 0){
//                            infoToSend = "SUB,Obstacle1";
//                        }
//                        else{
//                            infoToSend = "ADD,Obstacle1,(" + xCoord + "," + yCoordFinal + ")"+ "," + direction;
//                        }
                        byte[] bytes = infoToSend.getBytes(Charset.defaultCharset());
                        BluetoothService.write(bytes);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        obstacle2.setOnTouchListener(new View.OnTouchListener() {
            int x = 0;
            int y = 0;
            int dx = 0;
            int dy = 0;
            int orientation;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!canSetObstacles) {
                    return false;
                }
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getX();
                        y = (int) event.getY();
                        orientation = (int) obstacle2.getRotation();
                        obstacle2.setRotation(0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = (int) event.getX() - x;
                        dy = (int) event.getY() - y;

                        obstacle2.setX(obstacle2.getX() + dx);
                        obstacle2.setY(obstacle2.getY() + dy);
                        break;
                    case MotionEvent.ACTION_UP:
                        int snapToX = ((int) ((obstacle2.getX() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        int snapToY = ((int) ((obstacle2.getY() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        // Log.d(TAG, "obstacle2 is at " + snapToX + "," + snapToY);
                        obstacle2.setX(snapToX);
                        obstacle2.setY(snapToY);
                        obstacle2.setRotation(orientation % 360);
                        String direction = getDirection(orientation);
                        int xCoord = (int) (obstacle2.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
                        int yCoord = (int) (obstacle2.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
                        // (0,0) starts from top left hence invert y
                        int yCoordFinal = 20 - yCoord;
                        String infoToSend = "";
                        infoToSend = getObstacleSend(xCoord, yCoordFinal, 1, direction, "Obstacle2");
                        byte[] bytes = infoToSend.getBytes(Charset.defaultCharset());
                        BluetoothService.write(bytes);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        obstacle3.setOnTouchListener(new View.OnTouchListener() {
            int x = 0;
            int y = 0;
            int dx = 0;
            int dy = 0;
            int orientation;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!canSetObstacles) {
                    return false;
                }
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getX();
                        y = (int) event.getY();
                        orientation = (int) obstacle3.getRotation();
                        obstacle3.setRotation(0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = (int) event.getX() - x;
                        dy = (int) event.getY() - y;

                        obstacle3.setX(obstacle3.getX() + dx);
                        obstacle3.setY(obstacle3.getY() + dy);
                        break;
                    case MotionEvent.ACTION_UP:
                        int snapToX = ((int) ((obstacle3.getX() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        int snapToY = ((int) ((obstacle3.getY() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        // Log.d(TAG, "obstacle3 is at " + snapToX + "," + snapToY);
                        obstacle3.setX(snapToX);
                        obstacle3.setY(snapToY);
                        obstacle3.setRotation(orientation % 360);
                        String direction = getDirection(orientation);
                        int xCoord = (int) (obstacle3.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
                        int yCoord = (int) (obstacle3.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
                        // (0,0) starts from top left hence invert y
                        int yCoordFinal = 20 - yCoord;
                        String infoToSend = "";
                        infoToSend = getObstacleSend(xCoord, yCoordFinal, 1, direction, "Obstacle3");
                        byte[] bytes = infoToSend.getBytes(Charset.defaultCharset());
                        BluetoothService.write(bytes);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        obstacle4.setOnTouchListener(new View.OnTouchListener() {
            int x = 0;
            int y = 0;
            int dx = 0;
            int dy = 0;
            int orientation;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!canSetObstacles) {
                    return false;
                }
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getX();
                        y = (int) event.getY();
                        orientation = (int) obstacle4.getRotation();
                        obstacle4.setRotation(0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = (int) event.getX() - x;
                        dy = (int) event.getY() - y;

                        obstacle4.setX(obstacle4.getX() + dx);
                        obstacle4.setY(obstacle4.getY() + dy);
                        break;
                    case MotionEvent.ACTION_UP:
                        int snapToX = ((int) ((obstacle4.getX() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        int snapToY = ((int) ((obstacle4.getY() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        // Log.d(TAG, "obstacle4 is at " + snapToX + "," + snapToY);
                        obstacle4.setX(snapToX);
                        obstacle4.setY(snapToY);
                        obstacle4.setRotation(orientation % 360);
                        String direction = getDirection(orientation);
                        int xCoord = (int) (obstacle4.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
                        int yCoord = (int) (obstacle4.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
                        // (0,0) starts from top left hence invert y
                        int yCoordFinal = 20 - yCoord;
                        String infoToSend = "";
                        infoToSend = getObstacleSend(xCoord, yCoordFinal, 1, direction, "Obstacle4");
                        byte[] bytes = infoToSend.getBytes(Charset.defaultCharset());
                        BluetoothService.write(bytes);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        obstacle5.setOnTouchListener(new View.OnTouchListener() {
            int x = 0;
            int y = 0;
            int dx = 0;
            int dy = 0;
            int orientation;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!canSetObstacles) {
                    return false;
                }
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getX();
                        y = (int) event.getY();
                        orientation = (int) obstacle5.getRotation();
                        obstacle5.setRotation(0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = (int) event.getX() - x;
                        dy = (int) event.getY() - y;

                        obstacle5.setX(obstacle5.getX() + dx);
                        obstacle5.setY(obstacle5.getY() + dy);
                        break;
                    case MotionEvent.ACTION_UP:
                        int snapToX = ((int) ((obstacle5.getX() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        int snapToY = ((int) ((obstacle5.getY() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        // Log.d(TAG, "obstacle5 is at " + snapToX + "," + snapToY);
                        obstacle5.setX(snapToX);
                        obstacle5.setY(snapToY);
                        obstacle5.setRotation(orientation % 360);
                        String direction = getDirection(orientation);
                        int xCoord = (int) (obstacle5.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
                        int yCoord = (int) (obstacle5.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
                        // (0,0) starts from top left hence invert y
                        int yCoordFinal = 20 - yCoord;
                        String infoToSend = "";
                        infoToSend = getObstacleSend(xCoord, yCoordFinal, 1, direction, "Obstacle5");
                        byte[] bytes = infoToSend.getBytes(Charset.defaultCharset());
                        BluetoothService.write(bytes);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        obstacle6.setOnTouchListener(new View.OnTouchListener() {
            int x = 0;
            int y = 0;
            int dx = 0;
            int dy = 0;
            int orientation;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!canSetObstacles) {
                    return false;
                }
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getX();
                        y = (int) event.getY();
                        orientation = (int) obstacle6.getRotation();
                        obstacle6.setRotation(0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = (int) event.getX() - x;
                        dy = (int) event.getY() - y;

                        obstacle6.setX(obstacle6.getX() + dx);
                        obstacle6.setY(obstacle6.getY() + dy);
                        break;
                    case MotionEvent.ACTION_UP:
                        int snapToX = ((int) ((obstacle6.getX() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        int snapToY = ((int) ((obstacle6.getY() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        // Log.d(TAG, "obstacle6 is at " + snapToX + "," + snapToY);
                        obstacle6.setX(snapToX);
                        obstacle6.setY(snapToY);
                        obstacle6.setRotation(orientation % 360);
                        String direction = getDirection(orientation);
                        int xCoord = (int) (obstacle6.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
                        int yCoord = (int) (obstacle6.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
                        // (0,0) starts from top left hence invert y
                        int yCoordFinal = 20 - yCoord;
                        String infoToSend = "";
                        infoToSend = getObstacleSend(xCoord, yCoordFinal, 1, direction, "Obstacle6");
                        byte[] bytes = infoToSend.getBytes(Charset.defaultCharset());
                        BluetoothService.write(bytes);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        obstacle7.setOnTouchListener(new View.OnTouchListener() {
            int x = 0;
            int y = 0;
            int dx = 0;
            int dy = 0;
            int orientation;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!canSetObstacles) {
                    return false;
                }
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getX();
                        y = (int) event.getY();
                        orientation = (int) obstacle7.getRotation();
                        obstacle7.setRotation(0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = (int) event.getX() - x;
                        dy = (int) event.getY() - y;

                        obstacle7.setX(obstacle7.getX() + dx);
                        obstacle7.setY(obstacle7.getY() + dy);
                        break;
                    case MotionEvent.ACTION_UP:
                        int snapToX = ((int) ((obstacle7.getX() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        int snapToY = ((int) ((obstacle7.getY() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        // Log.d(TAG, "obstacle7 is at " + snapToX + "," + snapToY);
                        obstacle7.setX(snapToX);
                        obstacle7.setY(snapToY);
                        obstacle7.setRotation(orientation % 360);
                        String direction = getDirection(orientation);
                        int xCoord = (int) (obstacle7.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
                        int yCoord = (int) (obstacle7.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
                        // (0,0) starts from top left hence invert y
                        int yCoordFinal = 20 - yCoord;
                        String infoToSend = "";
                        infoToSend = getObstacleSend(xCoord, yCoordFinal, 1, direction, "Obstacle7");
                        byte[] bytes = infoToSend.getBytes(Charset.defaultCharset());
                        BluetoothService.write(bytes);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        obstacle8.setOnTouchListener(new View.OnTouchListener() {
            int x = 0;
            int y = 0;
            int dx = 0;
            int dy = 0;
            int orientation;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!canSetObstacles) {
                    return false;
                }
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getX();
                        y = (int) event.getY();
                        orientation = (int) obstacle8.getRotation();
                        obstacle8.setRotation(0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = (int) event.getX() - x;
                        dy = (int) event.getY() - y;

                        obstacle8.setX(obstacle8.getX() + dx);
                        obstacle8.setY(obstacle8.getY() + dy);
                        break;
                    case MotionEvent.ACTION_UP:
                        int snapToX = ((int) ((obstacle8.getX() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        int snapToY = ((int) ((obstacle8.getY() + SNAP_GRID_INTERVAL / 2) / SNAP_GRID_INTERVAL))
                                * SNAP_GRID_INTERVAL;
                        // Log.d(TAG, "obstacle8 is at " + snapToX + "," + snapToY);
                        obstacle8.setX(snapToX);
                        obstacle8.setY(snapToY);
                        obstacle8.setRotation(orientation % 360);
                        String direction = getDirection(orientation);
                        int xCoord = (int) (obstacle8.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL - 1;
                        int yCoord = (int) (obstacle8.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
                        // (0,0) starts from top left hence invert y
                        int yCoordFinal = 20 - yCoord;
                        String infoToSend = "";
                        infoToSend = getObstacleSend(xCoord, yCoordFinal, 1, direction, "Obstacle8");
                        byte[] bytes = infoToSend.getBytes(Charset.defaultCharset());
                        BluetoothService.write(bytes);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    /*
     * Set obstacle ID images
     */
    private void setObstacleImage(int obstacleNumber, String image) {
        int orientation = (int) obstacles.get(obstacleNumber).getRotation();

        try {
            if (orientation == 0) {
                obstacles.get(obstacleNumber).setImageResource(Helper.resources.get(image + "n"));
            } else if (orientation == 90) {
                obstacles.get(obstacleNumber).setImageResource(Helper.resources.get(image + "e"));
            } else if (orientation == 180) {
                obstacles.get(obstacleNumber).setImageResource(Helper.resources.get(image + "s"));
            } else if (orientation == 270) {
                obstacles.get(obstacleNumber).setImageResource(Helper.resources.get(image + "w"));
            } else {
                obstacles.get(obstacleNumber).setImageResource(Helper.resources.get(image));
                obstacles.get(obstacleNumber).setRotation(0);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /*
     * Initializes the arrow buttons
     */
    private void initMovementButtons() {
        ImageButton forwardButton = (ImageButton) findViewById(R.id.forwardButton);
        forwardButton.setOnClickListener(v -> {
             Log.d(TAG, "forward");

            // Bluetooth message
            if (BluetoothService.BluetoothConnectionStatus) {
                byte[] bytes = "SF010".getBytes(Charset.defaultCharset());
                BluetoothService.write(bytes);
            }

            // Animation
            forwardButtonCommand(1);
        });

        ImageButton reverseButton = (ImageButton) findViewById(R.id.reverseButton);
        reverseButton.setOnClickListener(v -> {
            // Log.d(TAG, "reverse");

            // Bluetooth message
            if (BluetoothService.BluetoothConnectionStatus) {
                byte[] bytes = "SB010".getBytes(Charset.defaultCharset());
                BluetoothService.write(bytes);
            }

            // Animation
            reverseButtonCommand(1);
        });

        ImageButton leftButton = (ImageButton) findViewById(R.id.leftButton);
        leftButton.setOnClickListener(v -> {
            // Log.d(TAG, "left");

            if (BluetoothService.BluetoothConnectionStatus) {
                // 3 point turn
                byte[] bytes = "LF045RB045".getBytes(Charset.defaultCharset());
                BluetoothService.write(bytes);
            }
            int rotationVal = (int) ((car.getRotation() + 270) % 360);
            Log.d(TAG, "Rotating" + rotationVal);
            car.setRotation(rotationVal);
            updateXYDirText();
        });

        ImageButton rightButton = (ImageButton) findViewById(R.id.rightButton);
        rightButton.setOnClickListener(v -> {
            // Log.d(TAG, "right");

            if (BluetoothService.BluetoothConnectionStatus) {
                byte[] bytes = "RF045LB045".getBytes(Charset.defaultCharset());
                BluetoothService.write(bytes);
            }
            int rotationVal = (int) ((car.getRotation() + 90) % 360);
            Log.d(TAG, "Rotating" + rotationVal);
            car.setRotation(rotationVal);
            updateXYDirText();
        });
    }

    /**
     * Initalizes buttons, car and setup listeners
     */
    private void initButtons() {
        // Declarations
//        car = findViewById(R.id.car);
//        car_x = findViewById(R.id.x_tv);
//        car_y = findViewById(R.id.y_tv);
//        car_dir = findViewById(R.id.dir_tv);
        IRButton = findViewById(R.id.IRButton);
        SPButton = findViewById(R.id.SPBtn);
        resetButton = findViewById(R.id.resetButton);
//        preset1Button = findViewById(R.id.preset1Button);
        setButton = findViewById(R.id.setButton);
//        saveButton = findViewById(R.id.saveButton);
        timerButton = findViewById(R.id.timerButton);
        statusWindow = findViewById(R.id.statusWindowText);

        // Events
        IRButton.setOnClickListener(view -> beginIRTask());
        SPButton.setOnClickListener(view -> beginSPTask());
        resetButton.setOnClickListener(view -> setResetButton());
//        preset1Button.setOnClickListener(view -> setPreset1Button());
        setButton.setOnClickListener(view -> toggleSetMode());
//        saveButton.setOnClickListener(view -> sendObstacles());
        timerButton.setOnClickListener(view -> stopTimerButton());

//        // Initialize car to bottom left
//        car.setX(INITIAL_X);
//        car.setY(INITIAL_Y);
//        updateXYDirText();
    }

    /*
     * Function to wait for certain amount of time
     */
    private void sleepFor(int time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * Movement commands:
     * 0 - North
     * 1 - East
     * 2 - South
     * 3 - West
     */

    private void forwardButtonCommand(int noOfGrids) {
        int orientation = (int) car.getRotation();
        int new_x, new_y;
        ObjectAnimator animator;
        switch (((orientation / 90) % 4 + 4) % 4) {
            case 0:
                new_y = (int) car.getY() - noOfGrids * SNAP_GRID_INTERVAL;
                car.setY(new_y);
                animator = ObjectAnimator.ofFloat(car, "y", new_y);
                animator.setDuration(noOfGrids * ANIMATOR_DURATION);
                animator.start();
                updateXYDirText();
                break;
            case 1:
                new_x = (int) car.getX() + noOfGrids * SNAP_GRID_INTERVAL;
                car.setX(new_x);
                animator = ObjectAnimator.ofFloat(car, "x", new_x);
                animator.setDuration(noOfGrids * ANIMATOR_DURATION);
                animator.start();
                updateXYDirText();
                break;
            case 2:
                new_y = (int) car.getY() + noOfGrids * SNAP_GRID_INTERVAL;
                car.setY(new_y);
                animator = ObjectAnimator.ofFloat(car, "y", new_y);
                animator.setDuration(noOfGrids * ANIMATOR_DURATION);
                animator.start();
                updateXYDirText();
                break;
            case 3:
                new_x = (int) car.getX() - noOfGrids * SNAP_GRID_INTERVAL;
                car.setX(new_x);
                animator = ObjectAnimator.ofFloat(car, "x", new_x);
                animator.setDuration(noOfGrids * ANIMATOR_DURATION);
                animator.start();
                updateXYDirText();
                break;
            default:
                // Shouldn't reach this case
                break;
        }
    }

    private void reverseButtonCommand(int noOfGrids) {
        int orientation = (int) car.getRotation();
        int new_x, new_y;
        ObjectAnimator animator;
        switch (((orientation / 90) % 4 + 4) % 4) {
            case 0:
                new_y = (int) car.getY() + noOfGrids * SNAP_GRID_INTERVAL;
                car.setY(new_y);
                animator = ObjectAnimator.ofFloat(car, "y", new_y);
                animator.setDuration(noOfGrids * ANIMATOR_DURATION);
                animator.start();
                updateXYDirText();
                break;
            case 1:
                new_x = (int) car.getX() - noOfGrids * SNAP_GRID_INTERVAL;
                car.setX(new_x);
                animator = ObjectAnimator.ofFloat(car, "x", new_x);
                animator.setDuration(noOfGrids * ANIMATOR_DURATION);
                animator.start();
                updateXYDirText();
                break;
            case 2:
                new_y = (int) car.getY() - noOfGrids * SNAP_GRID_INTERVAL;
                car.setY(new_y);
                animator = ObjectAnimator.ofFloat(car, "y", new_y);
                animator.setDuration(noOfGrids * ANIMATOR_DURATION);
                animator.start();
                updateXYDirText();
                break;
            case 3:
                new_x = (int) car.getX() + noOfGrids * SNAP_GRID_INTERVAL;
                car.setX(new_x);
                animator = ObjectAnimator.ofFloat(car, "x", new_x);
                animator.setDuration(noOfGrids * ANIMATOR_DURATION);
                animator.start();
                updateXYDirText();
                break;
            default:
                // Shouldn't reach this case
                break;
        }
    }

    /*
     * Medium turn left
     */
    public void leftMidButtonCommand() {
        int orientation = (int) car.getRotation();
        int new_x, new_y;
        AnimatorSet animatorSet;
        ObjectAnimator moveStraightAnimator, turnAnimator, moveStraightAgainAnimator;

        switch (((orientation / 90) % 4 + 4) % 4) {
            case 0:
                new_y = (int) car.getY() - 2 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() - 4 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", -90);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(270);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 1:
                new_y = (int) car.getY() - 4 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() + 2 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 0);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(0);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 2:
                new_y = (int) car.getY() + 2 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() + 4 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 90);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(90);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 3:
                new_y = (int) car.getY() + 4 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() - 2 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 180);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(180);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            default:
                // Shouldn't reach this case
                break;
        }
    }

    /*
     * Medium turn right
     */
    public void rightMidButtonCommand() {
        int orientation = (int) car.getRotation();
        int new_x, new_y, rotationVal;
        AnimatorSet animatorSet;
        ObjectAnimator moveStraightAnimator, turnAnimator, moveStraightAgainAnimator;
        switch (((orientation / 90) % 4 + 4) % 4) {
            case 0:
                new_y = (int) car.getY() - 2 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() + 4 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 90);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(90);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 1:
                new_y = (int) car.getY() + 4 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() + 2 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 180);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(180);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 2:
                new_y = (int) car.getY() + 2 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() - 4 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 270);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(270);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 3:
                new_y = (int) car.getY() - 4 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() - 2 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 360);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(0);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            default:
                // Shouldn't reach this case
                break;
        }
    }


    /*
     * reverse left
     */
    public void leftMidReverseButtonCommand() {
        int orientation = (int) car.getRotation();
        int new_x, new_y;
        AnimatorSet animatorSet;
        ObjectAnimator moveStraightAnimator, turnAnimator, moveStraightAgainAnimator;

        switch (((orientation / 90) % 4 + 4) % 4) {
            case 0:
                new_y = (int) car.getY() + 4 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() - 2 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 90);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(90);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 1:
                new_y = (int) car.getY() - 2 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() - 4 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 180);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(180);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 2:
                new_y = (int) car.getY() - 4 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() + 2 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 270);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(270);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 3:
                new_y = (int) car.getY() + 2 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() + 4 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 360);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(0);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            default:
                // Shouldn't reach this case
                break;
        }
    }

    /*
     * reverse right
     */
    public void rightMidReverseButtonCommand() {
        int orientation = (int) car.getRotation();
        int new_x, new_y;
        AnimatorSet animatorSet;
        ObjectAnimator moveStraightAnimator, turnAnimator, moveStraightAgainAnimator;

        switch (((orientation / 90) % 4 + 4) % 4) {
            case 0:
                new_y = (int) car.getY() + 4 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() + 2 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", -90);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(270);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 1:
                new_y = (int) car.getY() + 2 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() - 4 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 0);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(0);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 2:
                new_y = (int) car.getY() - 4 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() - 2 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 90);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(90);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            case 3:
                new_y = (int) car.getY() - 2 * SNAP_GRID_INTERVAL;
                new_x = (int) car.getX() + 4 * SNAP_GRID_INTERVAL;

                moveStraightAnimator = ObjectAnimator.ofFloat(car, "x", new_x);
                moveStraightAnimator.setDuration(ANIMATOR_DURATION);

                turnAnimator = ObjectAnimator.ofFloat(car, "rotation", 180);
                turnAnimator.setDuration(500);

                moveStraightAgainAnimator = ObjectAnimator.ofFloat(car, "y", new_y);
                moveStraightAgainAnimator.setDuration(ANIMATOR_DURATION);

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(moveStraightAnimator, turnAnimator, moveStraightAgainAnimator);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        car.setY(new_y);
                        car.setX(new_x);
                        car.setRotation(180);
                        updateXYDirText();
                    }
                });
                animatorSet.start();
                break;
            default:
                // Shouldn't reach this case
                break;
        }
    }

    private void stopTimerButton() {
        Chronometer IRTimer = (Chronometer) findViewById(R.id.IRTimer);
        IRTimer.stop();
        updateStatusWindow("Ready");
    }

    private void beginIRTask() {
        String IRstart = "ALG:START";

        if (BluetoothService.BluetoothConnectionStatus) {
            // Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
            byte[] bytes = IRstart.getBytes(Charset.defaultCharset());
            BluetoothService.write(bytes);
            Toast.makeText(Arena.this, "Starting Task 1", Toast.LENGTH_SHORT).show();
            updateStatusWindow("IR Started");
        } else {
            updateStatusWindow("IR Not Started");
            Toast.makeText(Arena.this, "Please connect to Bluetooth.", Toast.LENGTH_SHORT).show();
            sleepFor(ANIMATOR_DURATION);
            updateStatusWindow("Ready");
            return;
        }

        Chronometer IRTimer = (Chronometer) findViewById(R.id.IRTimer);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        IRTimer.setBase(elapsedRealtime);
        IRTimer.start();
    }

    private void beginSPTask() {
        if (BluetoothService.BluetoothConnectionStatus) {
            byte[] bytes = "STM:sp".getBytes(Charset.defaultCharset());
            BluetoothService.write(bytes);
            Toast.makeText(Arena.this, "Task 2 Started.", Toast.LENGTH_SHORT).show();
            updateStatusWindow("SP Started");
        } else {
            updateStatusWindow("SP Not Started");
            Toast.makeText(Arena.this, "Please connect to Bluetooth.", Toast.LENGTH_SHORT).show();
            sleepFor(ANIMATOR_DURATION);
            updateStatusWindow("Ready");
            return;
        }

        Chronometer IRTimer = (Chronometer) findViewById(R.id.IRTimer);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        IRTimer.setBase(elapsedRealtime);
        IRTimer.start();
    }

    private void setResetButton() {
        // Reset Timer
        Chronometer IRTimer = (Chronometer) findViewById(R.id.IRTimer);
        IRTimer.setBase(SystemClock.elapsedRealtime());
        IRTimer.stop();
        updateStatusWindow("Ready");

        // Hard coded
        obstacle1.setTranslationX(0);
        obstacle1.setTranslationY(0);

        obstacle2.setTranslationX(0);
        obstacle2.setTranslationY(0);

        obstacle3.setTranslationX(0);
        obstacle3.setTranslationY(0);

        obstacle4.setTranslationX(0);
        obstacle4.setTranslationY(0);

        obstacle5.setTranslationX(0);
        obstacle5.setTranslationY(0);

        obstacle6.setTranslationX(0);
        obstacle6.setTranslationY(0);

        obstacle7.setTranslationX(0);
        obstacle7.setTranslationY(0);

        obstacle8.setTranslationX(0);
        obstacle8.setTranslationY(0);

//        car.setX(INITIAL_X);
//        car.setY(INITIAL_Y);
        car.setTranslationX(0);
        car.setTranslationY(0);
        car.setRotation(0);
        updateXYDirText();

        car.setImageResource(Helper.resources.get("car"));
        car.setTag(Helper.resources.get("car"));
        obstacle1.setImageResource(Helper.resources.get("o1n"));
        obstacle1.setTag(Helper.resources.get("o1n"));
        obstacle2.setImageResource(Helper.resources.get("o2n"));
        obstacle2.setTag(Helper.resources.get("o2n"));
        obstacle3.setImageResource(Helper.resources.get("o3n"));
        obstacle3.setTag(Helper.resources.get("o3n"));
        obstacle4.setImageResource(Helper.resources.get("o4n"));
        obstacle4.setTag(Helper.resources.get("o4n"));
        obstacle5.setImageResource(Helper.resources.get("o5n"));
        obstacle5.setTag(Helper.resources.get("o5n"));
        obstacle6.setImageResource(Helper.resources.get("o6n"));
        obstacle6.setTag(Helper.resources.get("o6n"));
        obstacle7.setImageResource(Helper.resources.get("o7n"));
        obstacle7.setTag(Helper.resources.get("o7n"));
        obstacle8.setImageResource(Helper.resources.get("o8n"));
        obstacle8.setTag(Helper.resources.get("o8n"));

        obstacle1.setRotation(0);
        obstacle2.setRotation(0);
        obstacle3.setRotation(0);
        obstacle4.setRotation(0);
        obstacle5.setRotation(0);
        obstacle6.setRotation(0);
        obstacle7.setRotation(0);
        obstacle8.setRotation(0);

        String infoToSend = "";
        byte[] bytes = null;
        infoToSend = "RESET";
        bytes = infoToSend.getBytes(Charset.defaultCharset());
        BluetoothService.write(bytes);
        // Toast.makeText(this, "Map Reset", Toast.LENGTH_SHORT).show();
    }

//    private void setPreset1Button() {
//        updateStatusWindow("Ready");
//        String toSend = "";
//        byte[] bytes = null;
//        String toSendFinal = "";
//
//        obstacle1.setX(35);
//        obstacle1.setY(105);
//        obstacle1.setRotation(90);
//        obstacle1.setImageResource(Helper.resources.get("o1e"));
//
//        obstacle2.setX(350);
//        obstacle2.setY(595);
//        obstacle2.setRotation(270);
//        obstacle2.setImageResource(Helper.resources.get("o2w"));
//
//        obstacle3.setX(210);
//        obstacle3.setY(490);
//        obstacle3.setRotation(90);
//        obstacle3.setImageResource(Helper.resources.get("o3e"));
//
//
//        obstacle4.setX(280);
//        obstacle4.setY(245);
//        obstacle4.setRotation(0);
//        obstacle4.setImageResource(Helper.resources.get("o4n"));
//
//        obstacle5.setX(560);
//        obstacle5.setY(525);
//        obstacle5.setRotation(270);
//        obstacle5.setImageResource(Helper.resources.get("o5w"));
//
//        obstacle6.setX(490);
//        obstacle6.setY(315);
//        obstacle6.setRotation(180);
//        obstacle6.setImageResource(Helper.resources.get("o6s"));
//
//        obstacle7.setX(280);
//        obstacle7.setY(35);
//        obstacle7.setRotation(180);
//        obstacle7.setImageResource(Helper.resources.get("o7s"));
//
//        obstacle8.setX(560);
//        obstacle8.setY(35);
//        obstacle8.setRotation(180);
//        obstacle8.setImageResource(Helper.resources.get("o8s"));
//
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        updateRobotPosition(1,18,0);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        toSend = getObstacleSend(1,16,1,"E","1");
//        toSendFinal = toSend + "\n";
//        bytes = toSendFinal.getBytes(Charset.defaultCharset());
//        BluetoothService.write(bytes);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        toSend = getObstacleSend(10,2,1,"W","2");
//        toSendFinal = toSend + "\n";
//        bytes = toSendFinal.getBytes(Charset.defaultCharset());
//        BluetoothService.write(bytes);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        toSend = getObstacleSend(6,5,1,"E","3");
//        toSendFinal = toSend + "\n";
//        bytes = toSendFinal.getBytes(Charset.defaultCharset());
//        BluetoothService.write(bytes);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        toSend = getObstacleSend(8,12,1,"N","4");
//        toSendFinal = toSend + "\n";
//        bytes = toSendFinal.getBytes(Charset.defaultCharset());
//        BluetoothService.write(bytes);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        toSend = getObstacleSend(16,4,1,"W","5");
//        toSendFinal = toSend + "\n";
//        bytes = toSendFinal.getBytes(Charset.defaultCharset());
//        BluetoothService.write(bytes);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        toSend = getObstacleSend(14,10,1,"S","6");
//        toSendFinal = toSend + "\n";
//        bytes = toSendFinal.getBytes(Charset.defaultCharset());
//        BluetoothService.write(bytes);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        toSend = getObstacleSend(8,18,1,"S","7");
//        toSendFinal = toSend + "\n";
//        bytes = toSendFinal.getBytes(Charset.defaultCharset());
//        BluetoothService.write(bytes);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        toSend = getObstacleSend(16,18,1,"S","8");
//        toSendFinal = toSend + "\n";
//        bytes = toSendFinal.getBytes(Charset.defaultCharset());
//        BluetoothService.write(bytes);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


        // Toast.makeText(Arena.this, "Preset 1 Applied", Toast.LENGTH_SHORT).show();
//    }

    private void toggleSetMode() {
        canSetObstacles = !canSetObstacles;
        if (curMode.equals("IDLE")) {
            curMode = "SET";
            setButton.setText("Done");
            // Toast.makeText(this, "In set mode", Toast.LENGTH_SHORT).show();
        } else if (curMode.equals("SET")) {
            curMode = "IDLE";
            setButton.setText("Set");
            // Toast.makeText(this, "Obstacles set", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateStatusWindow(String msg) {
        statusWindow.setText(msg);
        Log.d(TAG, "Status window: " + msg);
    }

    private void updateRobotPosition(int x, int y, int direction) {
        car.setX(x * SNAP_GRID_INTERVAL - SNAP_GRID_INTERVAL);
        car.setY(y * SNAP_GRID_INTERVAL - SNAP_GRID_INTERVAL);
        switch (direction) {
            case 7: // North-west
                car.setRotation(315);
                break;
            case 0: // North
                car.setRotation(0);
                break;
            case 1: // North-east
                car.setRotation(45);
                break;
            case 2: // East
                car.setRotation(90);
                break;
            case 3: // South-east
                car.setRotation(135);
                break;
            case 4: // South
                car.setRotation(180);
                break;
            case 5: // South-west
                car.setRotation(225);
                break;
            case 6: // West
                car.setRotation(270);
                break;
            default:
                // Shouldn't reach this case
                break;
        }

        updateXYDirText();
    }

    private void updateXYDirText() {
        int x = (int) (car.getX() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
        int y = (int) (car.getY() + SNAP_GRID_INTERVAL) / SNAP_GRID_INTERVAL;
        // (0,0) starts from top left hence invert y
        int new_y = 20 - y - 1;
        car_x.setText(String.valueOf(x));
        car_y.setText(String.valueOf(new_y));

        int direction = (int) car.getRotation();

        if (direction == 315)
            car_dir.setText("North-West");
        else if (direction == 0)
            car_dir.setText("North");
        else if (direction == 45)
            car_dir.setText("North-East");
        else if (direction == 90)
            car_dir.setText("East");
        else if (direction == 135)
            car_dir.setText("South-East");
        else if (direction == 180)
            car_dir.setText("South");
        else if (direction == 225)
            car_dir.setText("South-West");
        else if (direction == 270)
            car_dir.setText("West");
        else
            car_dir.setText("None");
    }

    // Broadcast Receiver for incoming messages
    TextView showReceived;

    BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("receivedMessage");
            String command;
            String old = showReceived.getText().toString();
            showReceived.setText(old + "\nROBOT:  " + message);
            Log.d(TAG, "Received message: " + message);

            try {
                command = message.substring(0, message.indexOf(','));
//                command = message.substring(0, message.indexOf(':'));
            } catch (IndexOutOfBoundsException e) {
                // Toast.makeText(Arena.this, "Invalid message format!",
                // Toast.LENGTH_SHORT).show();
                return;
            } catch (Exception e) {
                Log.d(TAG, "Exception: " + e.getMessage());
                return;
            }

            try {
                switch (command) {
                    // move robot
                    case Helper.ROBOT:
                        int startingIndex = message.indexOf("<");
                        int endingIndex = message.indexOf(">");
                        String x = message.substring(startingIndex + 1, endingIndex);

                        startingIndex = message.indexOf("<", endingIndex + 1);
                        endingIndex = message.indexOf(">", endingIndex + 1);
                        String y = message.substring(startingIndex + 1, endingIndex);
                        int adjusted_y = 19 - Integer.parseInt(y);

                        startingIndex = message.indexOf("<", endingIndex + 1);
                        endingIndex = message.indexOf(">", endingIndex + 1);
                        String direction = message.substring(startingIndex + 1, endingIndex);

                        Log.d("ROBOT", "(x: " + x + ") (y: " + adjusted_y + ") (direction: " + direction + ")");

                        int direction_int = 0;
                        switch (direction) {
                            case "N":
                                direction_int = 0;
                                break;
                            case "NE":
                                direction_int = 1;
                                break;
                            case "E":
                                direction_int = 2;
                                break;
                            case "SE":
                                direction_int = 3;
                                break;
                            case "S":
                                direction_int = 4;
                                break;
                            case "SW":
                                direction_int = 5;
                                break;
                            case "W":
                                direction_int = 6;
                                break;
                            case "NW":
                                direction_int = 7;
                                break;
                            default:
                                break;
                        }

                        // updateRobotPosition(Integer.parseInt(x), Integer.parseInt(y), direction_int);
                        updateRobotPosition(Integer.parseInt(x), adjusted_y, direction_int);
                        break;

                    // update obstacle ID (format - TARGET,obstacle_number,target_ID)
                    case Helper.TARGET:
                        int obstacleNumber = Character.getNumericValue(message.charAt(7));
                        Log.d(TAG,Integer.toString(obstacleNumber));
                        String solution = message.substring(9);
                        Log.d(TAG, "Solution value: " + solution);
                        if (Integer.parseInt(solution) == 0) {
                            Toast.makeText(Arena.this, "Image not recognized, trying again", Toast.LENGTH_SHORT).show();
                        } else {
                            setObstacleImage(obstacleNumber, solution);
                            // RMB TO PLUS 1 !!
//                            setObstacleImage(obstacleNumber + 1, solution);
                            Toast.makeText(Arena.this,
                                    "Obstacle " + obstacleNumber + " changed to Target ID: " + solution,
                                    Toast.LENGTH_SHORT).show();

                            String infoToSend = "Obstacle " + obstacleNumber + " changed to Target ID: " + solution;
                            byte[] bytes = infoToSend.getBytes(Charset.defaultCharset());
                        }
                        break;

                    // update status window
                    case Helper.STATUS:
                        String msg;
                        if (message.contains("\n")) {
                            msg = message.substring(message.indexOf(',') + 1, message.indexOf('\n'));
                        } else {
                            msg = message.substring(message.indexOf(',') + 1);
                        }
                        if (message.contains("COMPLETED")) {
                            Chronometer IRTimer = (Chronometer) findViewById(R.id.IRTimer);
                            IRTimer.stop();
                            updateStatusWindow("IR Completed");
                        } else {
                            updateStatusWindow(msg);
                        }
                        break;

                    // commands from RPI
                    case Helper.COMMAND:
                        String moveCommand = message.substring(message.indexOf(',') + 1); //
                        // substring after COMMANDS
                        Log.d(TAG, "Command received: " + moveCommand);

                        String prefix = moveCommand.substring(0, 2);
                        String distance = moveCommand.substring(2);
                        int convertedDistance, rotationVal;
                        Log.d(TAG, prefix + ";" + distance);

                        switch (prefix) {
                            // forward
                            case "SF":
                                convertedDistance = Integer.parseInt(distance) / 10;
                                Log.d(TAG, prefix + ";" + convertedDistance);
                                forwardButtonCommand(convertedDistance);
                                break;
                            // reverse
                            case "SB":
                                convertedDistance = Integer.parseInt(distance) / 10;
                                reverseButtonCommand(convertedDistance);
                                break;
                            // right forward
                            case "RF":
                                //Angle not distance
                                convertedDistance = Integer.parseInt(distance) / 10;
                                Log.d(TAG, prefix + ";" + convertedDistance);
                                switch(convertedDistance) {
                                    case 4:
                                        // 3 point turn
                                        rotationVal = (int) ((car.getRotation() + 90) % 360);
                                        Log.d(TAG, "Rotating" + rotationVal);
                                        car.setRotation(rotationVal);
                                        updateXYDirText();
                                        break;
//                                    case 9:
//                                        rightMidButtonCommand();
//                                        break;
                                    default:
                                        rightMidButtonCommand();
                                }
                                break;
                            // right backward
                            case "RB":
                                //Angle not distance
                                convertedDistance = Integer.parseInt(distance) / 10;
                                Log.d(TAG, prefix + ";" + convertedDistance);
                                switch(convertedDistance) {
                                    case 4:
                                        // 3 point turn
                                        break;
//                                    case 9:
//                                        rightMidButtonCommand();
//                                        break;
                                    default:
                                        rightMidReverseButtonCommand();
                                }
                                break;
                            // left forward
                            case "LF":
                                //Angle not distance
                                convertedDistance = Integer.parseInt(distance) / 10;
                                Log.d(TAG, prefix + ";" + convertedDistance);
                                switch(convertedDistance) {
                                    case 4:
                                        // 3 point turn
                                        rotationVal = (int) ((car.getRotation() + 270) % 360);
                                        Log.d(TAG, "Rotating" + rotationVal);
                                        car.setRotation(rotationVal);
                                        updateXYDirText();
                                        break;
//                                    case 9:
//                                        rightMidButtonCommand();
//                                        break;
                                    default:
                                        leftMidButtonCommand();
                                }

                                break;
                            // left backward
                            case "LB":
                                //Angle not distance
                                convertedDistance = Integer.parseInt(distance) / 10;
                                Log.d(TAG, prefix + ";" + convertedDistance);
                                switch(convertedDistance) {
                                    case 4:
                                        // 3 point turn
                                        break;
//                                    case 9:
//                                        rightMidButtonCommand();
//                                        break;
                                    default:
                                        leftMidReverseButtonCommand();
                                }
                                break;
                        }
                    default:
                        // for out of "ROBOT/TARGET/STATUS/COMMAND" cases
                        break;
                }
            } catch (Exception e) {
                // TODO: handle exception
                Log.d(TAG, "Exception: " + e.getMessage());
                return;
            }
        }
    };
}
