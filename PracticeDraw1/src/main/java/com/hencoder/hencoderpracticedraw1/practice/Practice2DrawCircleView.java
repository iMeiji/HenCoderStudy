package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {


    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        /**
         * setStyle(Style style) 这个方法设置的是绘制的 Style 。
         * Style 具体来说有三种： FILL, STROKE 和  FILL_AND_STROKE 。
         * FILL 是填充模式，STROKE 是画线模式（即勾边模式），FILL_AND_STROKE 是两种模式一并使用：既画线又填充。
         * 它的默认值是 FILL，填充模式。
         */

        /**
         * 开启抗锯齿来让图形和文字的边缘更加平滑
         * Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
         * 另外，你也可以使用 Paint.setAntiAlias(boolean aa) 来动态开关抗锯齿。
         */

        Paint p1 = new Paint();
        p1.setColor(Color.BLACK);
        p1.setAntiAlias(true);
        canvas.drawCircle(250, 100, 100, p1);

        Paint p2 = new Paint();
        p2.setStrokeWidth(2);  // 线条宽度为 2 像素
        p2.setColor(Color.BLACK);
        p2.setAntiAlias(true);
        p2.setStyle(Paint.Style.STROKE); // Style 修改为画线模式
        canvas.drawCircle(500, 100, 100, p2);

        Paint p3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p3.setColor(Color.parseColor("#FF4B91E2"));
        canvas.drawCircle(250, 350, 100, p3);

        Paint p4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p4.setStyle(Paint.Style.STROKE);
        p4.setStrokeWidth(40);
        canvas.drawCircle(500, 350, 100, p4);
    }
}
