package com.teamwork.discover.MyView.MWRateView.AfterGraduate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.teamwork.discover.R;

/**
 * Created by pcx on 2016/8/13.
 */

public class MyGraduateRoundRect extends View {
    public MyGraduateRoundRect(Context context) {
        super(context);
    }

    public MyGraduateRoundRect(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGraduateRoundRect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        canvas.drawText("签就业协议",180,130,paint);
        paint.setColor(getResources().getColor(R.color.rate_male));
        RectF rectF1 = new RectF(400,80,470,150);
        canvas.drawRoundRect(rectF1,10,10,paint);
        paint.setColor(getResources().getColor(R.color.paint_text));
        paint.setTextSize(40);
        canvas.drawText("升学出国",480,130,paint);
        paint.setColor(getResources().getColor(R.color.third));
        RectF rectF2 = new RectF(650,80,720,150);
        canvas.drawRoundRect(rectF2,10,10,paint);
        paint.setColor(getResources().getColor(R.color.paint_text));
        paint.setTextSize(40);
        canvas.drawText("其他",730,130,paint);
    }
}
