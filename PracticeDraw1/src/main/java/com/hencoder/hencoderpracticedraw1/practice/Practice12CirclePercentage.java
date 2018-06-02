package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Meiji on 2018/5/30.
 */
public class Practice12CirclePercentage extends View {

    private Paint mPaint;
    private List<Integer> mColorList;
    private List<Float> mAngleList;
    private int startAngle;

    {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);

        mColorList = new ArrayList<>();
        mAngleList = new ArrayList<>();
        startAngle = -90;
    }

    public Practice12CirclePercentage(Context context) {
        super(context);
    }

    public Practice12CirclePercentage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CirclePercentage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void show() {
        invalidate();
    }

    public Practice12CirclePercentage addItem(int color, float percentage) {
        mColorList.add(color);
        mAngleList.add(percentage);
        return this;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int largeRadius = Math.min(width, height);
        int smallRadius = largeRadius / 4;

        RectF rectF = new RectF(
                width / 2 - smallRadius,
                height / 2 - smallRadius,
                width / 2 + smallRadius,
                height / 2 + smallRadius);
        if (mAngleList == null || mColorList == null) {
            return;
        }

        float count = 0;
        for (float f : mAngleList) {
            count += f;
        }

        if (count == 0) {
            return;
        }

        // 计算权值
        for (int i = 0; i < mAngleList.size(); i++) {
            mAngleList.set(i, mAngleList.get(i) / count * 360);
        }

        for (int i = 0; i < mAngleList.size(); i++) {
            mPaint.setColor(mColorList.get(i));
            canvas.drawArc(rectF, startAngle, mAngleList.get(i), true, mPaint);
            startAngle += mAngleList.get(i);
        }

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(width / 2, height / 2, smallRadius / 2, mPaint);
    }
}