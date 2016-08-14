package com.teamwork.discover.MyView.MWRateView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.teamwork.discover.R;

import com.teamwork.discover.data.MWRate;

/**
 * Created by pcx on 2016/8/11.
 */

public class MyMWRatePieView extends View {
    private final int white_circle = 70;
    private MWRate mwRate = new MWRate();
    public int mark ;

    public MyMWRatePieView(Context context) {
        super(context);
    }

    public MyMWRatePieView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyMWRatePieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setData(int mark){
        this.mark = mark;
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas){
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor( Color.WHITE);
        int width = getWidth();
        int height = getHeight();
        int radius =Math.min(width,height) / 2;
        Double hd1 =  Math.toRadians(3);
        float r = (float) (Math.sin(hd1) / (1 + Math.sin(hd1)) * radius);


        if (mark != 0x1) {
            canvas.drawCircle(width / 2,height / 2,radius,paint);
            paint.setColor(getResources().getColor(R.color.rate_man));
            RectF rectF1 = new RectF(width / 2 - radius , height / 2 - radius, width / 2 + radius, height / 2 + radius);
            RectF rectF = new RectF(width / 2 - radius + r, height / 2 - radius + r,
                    width / 2 + radius - r, height / 2 + radius - r);
            canvas.drawArc(rectF1, 3, (float) (360 * mwRate.mwRate[mark] - 6), true, paint);
            canvas.drawArc(rectF, 0, 3, true, paint);
            canvas.drawArc(rectF, (float) (360 * mwRate.mwRate[mark] - 3), 3, true, paint);
            canvas.drawCircle((float) (width / 2 + Math.cos(hd1) * (radius - r)),
                    (float) (height / 2 + Math.sin(hd1) * (radius - r)), r, paint);
            Double hd2 = Math.toRadians((360 * mwRate.mwRate[mark] - 3));
            canvas.drawCircle((float) (width / 2 + Math.cos(hd2) * (radius - r)),
                    (float) (height / 2 + Math.sin(hd2) * (radius - r)), r, paint);

            paint.setColor(getResources().getColor(R.color.rate_male));
            canvas.drawArc(rectF1, (float) (360 * mwRate.mwRate[mark] + 3),
                    (float) (360 - 360 * mwRate.mwRate[mark] - 6), true, paint);
            canvas.drawArc(rectF, (float) (360 * mwRate.mwRate[mark]), 3, true, paint);
            canvas.drawArc(rectF, 360 - 3, 3, true, paint);
            Double hd3 = Math.toRadians((360 * mwRate.mwRate[mark]) + 3);
            canvas.drawCircle((float) (width / 2 + Math.cos(hd3) * (radius - r)),
                    (float) (height / 2 + Math.sin(hd3) * (radius - r)), r, paint);
            Double hd4 = Math.toRadians(360 - 3);
            canvas.drawCircle((float) (width / 2 + Math.cos(hd4) * (radius - r)),
                    (float) (height / 2 + Math.sin(hd4) * (radius - r)), r, paint);
            paint.setColor(Color.WHITE);
            canvas.drawCircle(width / 2,height / 2,white_circle,paint);
        }if (mark == 0x1){
            paint.setColor(Color.GRAY);
            paint.setTextSize(24);
            canvas.drawText(getResources().getString(R.string.choose), width/2, height/2, paint);
        }
    }
}
