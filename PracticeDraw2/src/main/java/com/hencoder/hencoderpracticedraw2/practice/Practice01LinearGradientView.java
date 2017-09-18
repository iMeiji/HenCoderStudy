package com.hencoder.hencoderpracticedraw2.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Rect rect0 = new Rect(100, 100, 1000, 400);
    Rect rect1 = new Rect(100, 500, 1000, 800);
    Rect rect2 = new Rect(100, 900, 1000, 1200);

    /**
     * LinearGradient 线性渐变
     * 设置两个点和两种颜色，以这两个点作为端点，使用两种颜色的渐变来绘制颜色。
     */

    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Shader mirrorShader = new LinearGradient(100, 100, 300, 400,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"),
                Shader.TileMode.MIRROR);
        Shader clampShader = new LinearGradient(100, 500, 300, 800,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"),
                Shader.TileMode.CLAMP);
        Shader repeatShader = new LinearGradient(100, 900, 300, 1200,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"),
                Shader.TileMode.REPEAT);

        textPaint.setTextSize(32);

        canvas.drawText("MIRROR 是镜像模式", 100, 80, textPaint);
        paint.setShader(mirrorShader);
        canvas.drawRect(rect0, paint);

        canvas.drawText("CLAMP 会在端点之外延续端点处的颜色", 100, 480, textPaint);
        paint.setShader(clampShader);
        canvas.drawRect(rect1, paint);

        canvas.drawText("REPEAT 是重复模式", 100, 880, textPaint);
        paint.setShader(repeatShader);
        canvas.drawRect(rect2, paint);
    }
}
