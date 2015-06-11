package com.example.priyakarambelkar.paintapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by priyakarambelkar on 6/9/15.
 */
public class DrawableViewClass extends View {

    private Path drawingPath;
    Paint drawingPaint, drawingOnCanvas;
    private Canvas drawingCanvas;
    private Bitmap canvasBitmap = null;
    private HashMap<Path, Integer> saveColorPath = new HashMap<Path, Integer>();
    private int initColor = Color.BLACK, initBrushSize = 20;
    public DrawableViewClass(Context context, AttributeSet attrs) {
        super(context, attrs);
        startDrawingCanvas();
    }

    private void startDrawingCanvas() {
        drawingPath = new Path();
        drawingPaint = new Paint();
        drawingPaint.setColor(initColor);
        drawingPaint.setStrokeWidth(initBrushSize);
        drawingPaint.setStyle(Paint.Style.STROKE);
        drawingOnCanvas = new Paint (Paint.DITHER_FLAG);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
        drawingCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawingCanvas.drawColor(Color.WHITE);
        canvas.drawBitmap(canvasBitmap, 0, 0, drawingOnCanvas);
        canvas.drawPath(drawingPath, drawingPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float drawX = event.getX();
        float drawY = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                drawingPath.moveTo(drawX,drawY);
                break;
            case MotionEvent.ACTION_MOVE:
                drawingPath.lineTo(drawX, drawY);
                break;
            case MotionEvent.ACTION_UP:
                drawingCanvas.drawPath(drawingPath, drawingPaint);
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    public void setColor(String colorName) {
        invalidate();

        initColor = Color.parseColor(colorName);
        drawingPaint.setColor(initColor);
    }

    public void setBrushSize(float mlarge) {
        invalidate();
        drawingPaint.setStrokeWidth(mlarge);
    }

    public void resetCanvas() {
        drawingPath.reset();
        invalidate();
    }
}
