package com.gelitenight.waveview.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HeartShape extends FrameLayout {

    private Paint paint;
    public HeartShape(@NonNull Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        setWillNotDraw(false);
    }

    public HeartShape(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeartShape(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Path path = createHeartPath(canvas.getClipBounds().right,canvas.getClipBounds().bottom);

        canvas.drawPath(path,paint);

        super.onDraw(canvas);
    }

    private Path createHeartPath(int width, int height) {
        Path path = new Path();
        //path.lineTo(width/2f,height);

        float pX = width/2f;
        float pY = (height/100f)*33.33f;

        float x1 = (width/100f)*50;
        float y1 = (height/100f)*5;
        float x2 = (width/100f)*90;
        float y2 = (height/100f)*10;
        float x3 = (width/100f)*90;
        float y3 = (height/100f)*33.33f;

        path.moveTo(pX,pY);
        path.cubicTo(x1, y1, x2, y2, x3, y3);
        path.moveTo(x3,pY);

        x1 = (width/100f)*90;
        y1 = (height/100f)*55f;
        x2 = (width/100f)*65;
        y2 = (height/100f)*60f;
        x3 = (width/100f)*50;
        y3 = (height/100f)*90f;

        path.cubicTo(x1, y1, x2, y2, x3, y3);
        path.moveTo(pX,pY);


        x1 = (width/100f)*50;
        y1 = (height/100f)*5;
        x2 = (width/100f)*10;
        y2 = (height/100f)*10;
        x3 = (width/100f)*10;
        y3 = (height/100f)*33.33f;

        path.moveTo(pX,pY);
        path.cubicTo(x1, y1, x2, y2, x3, y3);
        path.moveTo(x3,pY);

        x1 = (width/100f)*10;
        y1 = (height/100f)*55f;
        x2 = (width/100f)*35f;
        y2 = (height/100f)*60f;
        x3 = (width/100f)*50f;
        y3 = (height/100f)*90f;

        path.cubicTo(x1, y1, x2, y2, x3, y3);
        path.moveTo(pX,pY);

        path.moveTo(x3,y3);
        path.close();

        return path;
    }


}