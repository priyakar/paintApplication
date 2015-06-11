package com.example.priyakarambelkar.paintapplication;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {
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
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
               View view = inflater.inflate(R.layout.fragment_main, container, false);
        initialiseParameters(view);
        return view;
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

    private void initialiseParameters(View view) {
        palette = (ImageButton) view.findViewById(R.id.palette);
        resetCanvas = (ImageButton) view.findViewById(R.id.reset_btn);
        brushSize = (ImageButton) view.findViewById(R.id.brush_btn);
        drawableView = (DrawableViewClass) view.findViewById(R.id.drawCustomView);
        btnRedColor =  (Button) view.findViewById(R.id.red_color_btn);
        btnBlueColor =  (Button) view.findViewById(R.id.blue_color_btn);
        btnGreenColor =  (Button) view.findViewById(R.id.green_color_btn);
        btnPinkColor =  (Button) view.findViewById(R.id.pink_color_btn);
        btnBrushSmall = (Button) view.findViewById(R.id.brush_small);
        btnBrushMedium = (Button) view.findViewById(R.id.brush_medium);
        btnBrushLarge = (Button) view.findViewById(R.id.brush_large);


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
