package com.teamwork.discover.MyView.MWRateView.DifficultRateView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.teamwork.discover.R;

import com.teamwork.discover.data.DifficultSubjectRate;

/**
 * Created by pcx on 2016/8/13.
 */

public class MySubjectRoudRect extends View {
    private DifficultSubjectRate difficultSubjectRate = new DifficultSubjectRate();
    private int data;
    public MySubjectRoudRect(Context context) {
        super(context);
    }

    public MySubjectRoudRect(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySubjectRoudRect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setData(int data){
        this.data = data;
        invalidate();
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.rate_man));
        RectF rectF = new RectF(100,80,170,150);
        canvas.drawRoundRect(rectF,10,10,paint);
        paint.setColor(getResources().getColor(R.color.paint_text));
        paint.setTextSize(40);
        canvas.drawText(difficultSubjectRate.subject1[data],180,130,paint);
        paint.setColor(getResources().getColor(R.color.rate_male));
        RectF rectF1 = new RectF(350,80,420,150);
        canvas.drawRoundRect(rectF1,10,10,paint);
        paint.setColor(getResources().getColor(R.color.paint_text));
        paint.setTextSize(40);
        canvas.drawText(difficultSubjectRate.subject2[data],430,130,paint);
        paint.setColor(getResources().getColor(R.color.third));
        RectF rectF2 = new RectF(600,80,670,150);
        canvas.drawRoundRect(rectF2,10,10,paint);
        paint.setColor(getResources().getColor(R.color.paint_text));
        paint.setTextSize(40);
        canvas.drawText(difficultSubjectRate.subject3[data],670,130,paint);
    }
}
