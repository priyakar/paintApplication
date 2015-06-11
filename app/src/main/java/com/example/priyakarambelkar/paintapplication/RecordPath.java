package com.example.priyakarambelkar.paintapplication;

import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by priyakarambelkar on 6/11/15.
 */
public class RecordPath {
    private Path savePath;
    private  Paint savePaint;

    public RecordPath (Path path, Paint paint){
        savePath = path;
        savePaint = paint;
    }

    public Path getSavePath() {
        return savePath;
    }
    public Paint getSavePaint(){
        return savePaint;
    }
}
