package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        // 画X轴和Y轴
        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.WHITE);
        p1.setStrokeWidth(1);
        p1.setStyle(Paint.Style.STROKE);

        Path path1 = new Path();
        path1.moveTo(100, 10);
        path1.lineTo(100, 400);
        path1.lineTo(900, 400);
        canvas.drawPath(path1, p1);
//        等于上面 5 行代码的效果
//        canvas.drawLine(100, 10, 100, 400, p1);
//        canvas.drawLine(100, 400, 700, 400, p1);

        // 画矩形 宽度 90 间隔 10
        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.parseColor("#FF73B918"));
        canvas.drawRect(110, 398, 200, 400, p2); // Froyo
        canvas.drawRect(210, 385, 300, 400, p2); // GB
        canvas.drawRect(310, 385, 400, 400, p2); // ICS
        canvas.drawRect(410, 280, 500, 400, p2); // JB
        canvas.drawRect(510, 180, 600, 400, p2); // KitKat
        canvas.drawRect(610, 120, 700, 400, p2); // L
        canvas.drawRect(710, 290, 800, 400, p2); // M

//        等于上面 6 行代码的效果
//        Path path2 = new Path();
//        path2.addRect(190, 385, 255, 400, Path.Direction.CW);
//        path2.addRect(265, 385, 330, 400, Path.Direction.CW);
//        path2.addRect(340, 280, 405, 400, Path.Direction.CW);
//        path2.addRect(415, 180, 480, 400, Path.Direction.CW);
//        path2.addRect(490, 120, 555, 400, Path.Direction.CW);
//        path2.addRect(565, 290, 630, 400, Path.Direction.CW);
//        canvas.drawPath(path2, p2);

        // 画字
        Paint p3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p3.setTextSize(20);
        p3.setColor(Color.WHITE);
        canvas.drawText("Froyo", 130, 420, p3);
        canvas.drawText("GB", 240, 420, p3);
        canvas.drawText("ICS", 340, 420, p3);
        canvas.drawText("JB", 440, 420, p3);
        canvas.drawText("KitKat", 520, 420, p3);
        canvas.drawText("L", 645, 420, p3);
        canvas.drawText("M", 745, 420, p3);

        // 画字
        Paint p4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p4.setTextSize(36);
        p4.setColor(Color.WHITE);
        canvas.drawText("直方图", 450, 500, p4);

    }
}
