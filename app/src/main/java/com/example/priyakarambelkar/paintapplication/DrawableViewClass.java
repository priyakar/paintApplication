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
import android.widget.Toast;

/**
 * Created by priyakarambelkar on 6/9/15.
 */
public class DrawableViewClass extends View {

    private Path drawingPath;
    private Paint drawingPaint, drawingOnCanvas;
    private Canvas drawingCanvas;
    private Bitmap canvasBitmap = null;
    int initColor = 0x0066FF;

    public DrawableViewClass(Context context, AttributeSet attrs) {
        super(context, attrs);
        startDrawingCanvas();
    }

    private void startDrawingCanvas() {
        drawingPath = new Path();
        drawingPaint = new Paint();
        drawingPaint.setAntiAlias(true);
        drawingPaint.setColor(Color.BLUE);
        drawingPaint.setStrokeWidth(50);
        drawingPaint.setStyle(Paint.Style.STROKE);
        drawingPaint.setStrokeCap(Paint.Cap.ROUND);
        drawingPaint.setStrokeJoin(Paint.Join.ROUND);
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
}
