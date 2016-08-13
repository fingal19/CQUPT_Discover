package com.teamwork.discover.MyView.MWRateView;

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

public class MWRateRoundRect extends View {
    public MWRateRoundRect(Context context) {
        super(context);
    }

    public MWRateRoundRect(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MWRateRoundRect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.rate_man));
        RectF rectF = new RectF(100,50,170,120);
        canvas.drawRoundRect(rectF,10,10,paint);
        paint.setColor(getResources().getColor(R.color.paint_text));
        paint.setTextSize(50);
        canvas.drawText("男生",180,110,paint);
        paint.setColor(getResources().getColor(R.color.rate_male));
        RectF rectF1 = new RectF(600,50,670,120);
        canvas.drawRoundRect(rectF1,10,10,paint);
        paint.setColor(getResources().getColor(R.color.paint_text));
        paint.setTextSize(50);
        canvas.drawText("女生",680,110,paint);
    }
}
