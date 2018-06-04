package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.meiji.hencoderstudy.practicedraw1.R;

/**
 * created by Meiji on 2018/6/4.
 * 百分比直线
 */
public class Practice13PercentLineView extends View {

    private static final String TAG = "Practice13PercentLineVi";
    private int mWidth;
    private int mHeight;

    private Paint mPaint;
    private float mTemp;

    private float mPercentage;
    private int mHalfHeight;
    private int mLineColor;
    private int mLineHeight;

    public Practice13PercentLineView(Context context) {
        this(context, null);
    }

    public Practice13PercentLineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice13PercentLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Practice13PercentLineView,
                defStyleAttr, 0);
        mLineColor = typedArray.getColor(R.styleable.Practice13PercentLineView_line_color, Color.RED);
        mLineHeight = typedArray.getDimensionPixelSize(R.styleable.Practice13PercentLineView_line_height, 10);
        mPercentage = typedArray.getFloat(R.styleable.Practice13PercentLineView_line_percentage, 1f);
        initPaint(mLineColor, mLineHeight);
        typedArray.recycle();
    }

    public Practice13PercentLineView setPercentage(float percentage) {
        this.mPercentage = percentage;
        invalidate();
        return this;
    }

    public Practice13PercentLineView setLinetColor(@ColorInt int color) {
        mPaint.setColor(color);
        invalidate();
        return this;
    }

    private void initPaint(int lineColor, int lineHeight) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(lineHeight);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(lineColor);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initParams();
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        initParams();
    }

    private void initParams() {
        mWidth = getWidth();
        mHeight = getHeight();
        mHalfHeight = mHeight / 2;
        // 分成 100 份太细，两端笔头涂抹掉
        mTemp = mWidth / 50;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float startX = mTemp;
        float startY = (mWidth - mTemp) * mPercentage;
        // 当 mPercentage 为 0.01f 会出现这种情况
        if (startY < startX) {
            startY = startX + mTemp * mPercentage;
        }
        canvas.drawLine(startX, mHalfHeight,
                startY, mHalfHeight,
                mPaint);
        Log.d(TAG, "onDraw: startY = " + startX + " startY = " + startY);
    }
}
