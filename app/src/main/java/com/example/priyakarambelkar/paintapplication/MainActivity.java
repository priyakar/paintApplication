package com.example.priyakarambelkar.paintapplication;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    ImageButton palette;
    ImageButton brushSize;
    ImageButton resetCanvas;
    Button btnRedColor;
    Button btnPinkColor;
    Button btnBlueColor;
    Button btnGreenColor;
    Button btnBrushSmall;
    Button btnBrushMedium;
    Button btnBrushLarge;

    public boolean visible = false;
    public boolean brushVisible = false;
    private DrawableViewClass drawableView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseParameters();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        int clickBtnId = v.getId();
        switch(clickBtnId){
            case R.id.palette:
                if (visible) {
                    setColorInvisible();
                }
                else if (!visible) {
                    setColorVisible();
                }
                break;
            case R.id.red_color_btn:
                drawableView.setColor("RED");
                break;
            case R.id.green_color_btn:
                drawableView.setColor("GREEN");
                break;
            case R.id.pink_color_btn:
                drawableView.setColor("MAGENTA");
                break;
            case R.id.blue_color_btn:
                drawableView.setColor("BLUE");
                break;
            case R.id.reset_btn:
                drawableView.resetCanvas();
                break;
            case R.id.brush_btn:
                if (brushVisible) {
                    setBrushInvisible();
                }
                else if (!brushVisible) {
                    setBrushVisible();
                }
                break;
            case R.id.brush_small:
                drawableView.setBrushSize(10);
                break;
            case R.id.brush_medium:
                drawableView.setBrushSize(20);
                break;
            case R.id.brush_large:
                drawableView.setBrushSize(30);
                break;
        }

    }

    private void initialiseParameters() {
        palette = (ImageButton) findViewById(R.id.palette);
        resetCanvas = (ImageButton) findViewById(R.id.reset_btn);
        brushSize = (ImageButton) findViewById(R.id.brush_btn);
        drawableView = (DrawableViewClass) findViewById(R.id.drawCustomView);
        btnRedColor =  (Button) findViewById(R.id.red_color_btn);
        btnBlueColor =  (Button) findViewById(R.id.blue_color_btn);
        btnGreenColor =  (Button) findViewById(R.id.green_color_btn);
        btnPinkColor =  (Button) findViewById(R.id.pink_color_btn);
        btnBrushSmall = (Button) findViewById(R.id.brush_small);
        btnBrushMedium = (Button) findViewById(R.id.brush_medium);
        btnBrushLarge = (Button) findViewById(R.id.brush_large);


        btnPinkColor.setVisibility(View.INVISIBLE);
        btnRedColor.setVisibility(View.INVISIBLE);
        btnGreenColor.setVisibility(View.INVISIBLE);
        btnBlueColor.setVisibility(View.INVISIBLE);
        btnBrushSmall.setVisibility(View.INVISIBLE);
        btnBrushMedium.setVisibility(View.INVISIBLE);
        btnBrushLarge.setVisibility(View.INVISIBLE);


        palette.setOnClickListener(this);
        resetCanvas.setOnClickListener(this);
        brushSize.setOnClickListener(this);
        btnRedColor.setOnClickListener(this);
        btnBlueColor.setOnClickListener(this);
        btnGreenColor.setOnClickListener(this);
        btnPinkColor.setOnClickListener(this);
        btnBrushSmall.setOnClickListener(this);
        btnBrushMedium.setOnClickListener(this);
        btnBrushLarge.setOnClickListener(this);

    }

    private void setColorVisible() {
        btnPinkColor.setVisibility(View.VISIBLE);
        btnRedColor.setVisibility(View.VISIBLE);
        btnGreenColor.setVisibility(View.VISIBLE);
        btnBlueColor.setVisibility(View.VISIBLE);
        visible = true;
    }

    public void setColorInvisible(){
        btnPinkColor.setVisibility(View.INVISIBLE);
        btnRedColor.setVisibility(View.INVISIBLE);
        btnGreenColor.setVisibility(View.INVISIBLE);
        btnBlueColor.setVisibility(View.INVISIBLE);
        visible = false;
    }

    private void setBrushVisible() {
        btnBrushSmall.setVisibility(View.VISIBLE);
        btnBrushMedium.setVisibility(View.VISIBLE);
        btnBrushLarge.setVisibility(View.VISIBLE);
        brushVisible = true;
    }

    public void setBrushInvisible(){
        btnBrushSmall.setVisibility(View.INVISIBLE);
        btnBrushMedium.setVisibility(View.INVISIBLE);
        btnBrushLarge.setVisibility(View.INVISIBLE);
        brushVisible = false;
    }
}
