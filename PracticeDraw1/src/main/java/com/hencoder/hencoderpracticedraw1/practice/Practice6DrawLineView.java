package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice6DrawLineView extends View {

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线

        // startX, startY, stopX, stopY 分别是线的起点和终点坐标。
        // 由于直线不是封闭图形，所以 setStyle(style) 对直线没有影响。

        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setStrokeWidth(6);
        canvas.drawLine(250, 250, 500, 380, p1);

        // 咦，不小心打出两个汉字。——是汉字吧？
        float[] lines = {
                50, 50, 250, 50,
                150, 50, 150, 200,
                50, 200, 250, 200,

                300, 50, 450, 50,
                300, 50, 300, 200,
                450, 50, 450, 200,
                300, 200, 450, 200
        };
        canvas.drawLines(lines, p1);
    }
}
