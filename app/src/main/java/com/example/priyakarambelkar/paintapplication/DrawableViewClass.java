package com.example.priyakarambelkar.paintapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by priyakarambelkar on 6/9/15.
 */
public class DrawableViewClass extends View {
    public DrawableViewClass(Context context, AttributeSet attrs) {
        super(context, attrs);
        startDrawingCanvas();
    }

    private void startDrawingCanvas() {

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
