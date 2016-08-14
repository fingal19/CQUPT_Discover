package com.teamwork.discover.MyView.MWRateView.AfterGraduate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.teamwork.discover.R;

import com.teamwork.discover.data.GraduateRate;

/**
 * Created by pcx on 2016/8/13.
 */

public class GraduatePieView extends View {
    private final int white_circle = 70;
    private int data;
    private GraduateRate graduateRate = new GraduateRate();
    public GraduatePieView(Context context) {
        super(context);
    }

    public GraduatePieView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GraduatePieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setData(int data){
        this.data = data;
        invalidate();
    }

    private double getRadian(double d){
        return Math.toRadians(d);
    }
    private double getRadian(int d){
        return Math.toRadians(d);
    }

    public void onDraw(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;
        float r = (float) (Math.sin(getRadian(2)) / (1 + Math.sin(getRadian(2))) * radius);

        if (graduateRate.graduate_college[data] != null) {
            Log.d("---------------->",graduateRate.graduate_college[data]);
            canvas.drawCircle(width / 2, height / 2, radius, paint);
            paint.setColor(getResources().getColor(R.color.rate_man));
            RectF rectF1 = new RectF(width / 2 - radius, height / 2 - radius, width / 2 + radius, height / 2 + radius);
            RectF rectF = new RectF(width / 2 - radius + r, height / 2 - radius + r,
                    width / 2 + radius - r, height / 2 + radius - r);
            canvas.drawArc(rectF1, 2, (float) (360 * graduateRate.work[data] - 4), true, paint);
            canvas.drawArc(rectF, 0, 2, true, paint);
            canvas.drawArc(rectF, (float) (360 * graduateRate.work[data] - 2), 2, true, paint);

            canvas.drawCircle((float) (width / 2 + Math.cos(getRadian(2)) * (radius - r)),
                    (float) (height / 2 + Math.sin(getRadian(2)) * (radius - r)), r, paint);
            Double hd2 = getRadian((360 * graduateRate.work[data] - 2));
            canvas.drawCircle((float) (width / 2 + Math.cos(hd2) * (radius - r)),
                    (float) (height / 2 + Math.sin(hd2) * (radius - r)), r, paint);

            paint.setColor(getResources().getColor(R.color.rate_male));
            canvas.drawArc(rectF1, (float) (360 * graduateRate.work[data] + 2),
                    (float) ( 360 * graduateRate.go_abroad[data] - 4), true, paint);
            canvas.drawArc(rectF, (float) (360 * graduateRate.work[data]), 2, true, paint);
            canvas.drawArc(rectF, (float) ( 360 * graduateRate.work[data] +
                    360 * graduateRate.go_abroad[data] - 2), 2, true, paint);
            Double hd3 = getRadian((360 * graduateRate.work[data]) + 2);
            canvas.drawCircle((float) (width / 2 + Math.cos(hd3) * (radius - r)),
                    (float) (height / 2 + Math.sin(hd3) * (radius - r)), r, paint);
            Double hd4 = getRadian(360 * graduateRate.work[data] +
                    360 * graduateRate.go_abroad[data] - 2);
            canvas.drawCircle((float) (width / 2 + Math.cos(hd4) * (radius - r)),
                    (float) (height / 2 + Math.sin(hd4) * (radius - r)), r, paint);

            paint.setColor(getResources().getColor(R.color.third));
            canvas.drawArc(rectF1, (float) (360 * graduateRate.work[data] +
                            360 * graduateRate.go_abroad[data] + 2),
                    (float) ( 360 - 360 * graduateRate.work[data] -
                            360 * graduateRate.go_abroad[data] - 4), true, paint);
            canvas.drawArc(rectF, (float) (360 * graduateRate.work[data] +
                    360 * graduateRate.go_abroad[data]), 2, true, paint);
            canvas.drawArc(rectF, (float) ( 360 - 2), 2, true, paint);
            Double hd5 = getRadian(360 * graduateRate.work[data] +
                    360 * graduateRate.go_abroad[data] + 2);
            canvas.drawCircle((float) (width / 2 + Math.cos(hd5) * (radius - r)),
                    (float) (height / 2 + Math.sin(hd5) * (radius - r)), r, paint);
            Double hd6 = getRadian(360 - 2);
            canvas.drawCircle((float) (width / 2 + Math.cos(hd6) * (radius - r)),
                    (float) (height / 2 + Math.sin(hd6) * (radius - r)), r, paint);

            paint.setColor(Color.WHITE);
            canvas.drawCircle(width / 2,height / 2,white_circle,paint);
        } else {
            paint.setColor(Color.GRAY);
            paint.setTextSize(50);
            canvas.drawText(getResources().getString(R.string.choose), width/2, height/2, paint);
        }
    }
}
