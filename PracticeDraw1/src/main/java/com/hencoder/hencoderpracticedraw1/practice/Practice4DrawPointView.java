package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        /**
         * x 和 y 是点的坐标。
         * 点的大小可以通过 paint.setStrokeWidth(width) 来设置；
         * 点的形状可以通过  paint.setStrokeCap(cap) 来设置：ROUND 画出来是圆形的点，SQUARE 或 BUTT 画出来是方形的点。
         */
        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setStrokeCap(Paint.Cap.ROUND);
        p1.setStrokeWidth(60);
        canvas.drawPoint(250, 200, p1);

        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setStrokeCap(Paint.Cap.BUTT);
        p2.setStrokeWidth(60);
        canvas.drawPoint(500, 200, p2);

        Paint p3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p3.setStrokeCap(Paint.Cap.ROUND);
        p3.setStrokeWidth(30);
        float[] points = {50, 50, 250, 300, 350, 300, 450, 300, 550, 300};
        // // 绘制四个点：(250, 300) (350, 300) (450, 300) (550, 300)
        canvas.drawPoints(
                points,
                2, // 跳过两个数，即前两个 0
                8, // 一共绘制 8 个数（4 个点）
                p3);
    }
}
