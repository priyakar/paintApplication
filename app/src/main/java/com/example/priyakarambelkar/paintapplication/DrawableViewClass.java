package com.example.priyakarambelkar.paintapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by priyakarambelkar on 6/9/15.
 */
public class DrawableViewClass extends View {

    Path drawingPath;
    Paint drawingPaint, drawingOnCanvas;
    Canvas drawingCanvas;
    Path uniquePath = new Path();
    Paint uniquePaint = new Paint();
    int i=0;
    Bitmap canvasBitmap = null;
    List <RecordPath> recordPaths = new ArrayList<RecordPath>();
    int initColor = Color.BLACK;
    float initBrushSize = 20;
    public DrawableViewClass(Context context, AttributeSet attrs) {
        super(context, attrs);
        startDrawingCanvas();
    }

    private void startDrawingCanvas() {
        drawingPath = new Path();
        drawingPaint = new Paint();
        drawingPaint.setColor(initColor);
        drawingPaint.setAntiAlias(true);
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
        drawingCanvas.drawColor(Color.WHITE);
        canvas.drawBitmap(canvasBitmap, 0, 0, drawingPaint);
        if (recordPaths.size()>0) {
            for (int i = 0; i < recordPaths.size() ; i++) {
                canvas.drawPath(recordPaths.get(i).getSavePath(), recordPaths.get(i).getSavePaint());
            }
        } else {
            canvas.drawPath(drawingPath, drawingPaint);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float drawX = event.getX();
        float drawY = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                uniquePath = new Path();
                uniquePaint = new Paint();
                uniquePaint.setColor(initColor);
                uniquePaint.setStrokeWidth(initBrushSize);
                uniquePaint.setStyle(Paint.Style.STROKE);
                uniquePath.moveTo(drawX, drawY);
                recordPaths.add(new RecordPath(uniquePath, uniquePaint));
                break;
            case MotionEvent.ACTION_MOVE:
                uniquePath.lineTo(drawX, drawY);
                break;
            case MotionEvent.ACTION_UP:
                drawingCanvas.drawPath(uniquePath, uniquePaint);
                i++;
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }


    public void setColor(String colorName) {
//        invalidate();
        //saveColorPath.put(drawingPath, drawingPaint.getColor());
        //drawingPath = drawingCanvas.drawPath(saveColorPath.get(drawingPath));
        initColor = Color.parseColor(colorName);
        drawingPaint.setColor(initColor);
    }

    public void setBrushSize(float mlarge) {
//        invalidate();
        initBrushSize = mlarge;
        drawingPaint.setStrokeWidth(mlarge);

    }

    public void resetCanvas() {
        for (int i = 0; i < recordPaths.size(); i++) {
            recordPaths.get(i).getSavePath().reset();
        }
        invalidate();
    }

    public Bitmap getCanvasBitmap() {
        return canvasBitmap;
    }

    public void setBitmap(Bitmap saveBitmap) {
        canvasBitmap = saveBitmap;
        invalidate();
    }
}
