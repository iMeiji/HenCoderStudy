package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class Practice11PieChartView extends View {

    private static final String TAG = "Practice11PieChartView";

    String GREY600 = "#FF546E7A";
    String RED = "#FFF44437";
    String YELLOW = "#FFFFC109";
    String PURPEL = "#FF9C27B0";
    String GREY = "#FF9E9E9E";
    String TEAL = "#FF009688";
    String BLUE = "#FF2196F3";

    private String[] name = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    private Integer[] percent = {4, 9, 7, 50, 110, 130, 50};
    private Integer[] color = {
            Color.BLACK,
            Color.parseColor(PURPEL),
            Color.parseColor(GREY),
            Color.parseColor(TEAL),
            Color.parseColor(BLUE),
            Color.parseColor(RED),
            Color.parseColor(YELLOW),
    };

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图


        // 文字 颜色 百分比
        List<String> nameList = Arrays.asList(name);
        List<Integer> colorList = Arrays.asList(color);
        List<Integer> precentList = Arrays.asList(percent);

        // 宽度 高度 半径
        int widthCenter = canvas.getWidth() / 2;
        int heightCenter = canvas.getHeight() / 2;
        int radius = (int) (heightCenter * 0.8);
        Log.d(TAG, "宽度 高度 半径: " + widthCenter + " , " + heightCenter + " , " + radius);


        // 普通矩形
        RectF rectF = new RectF(
                widthCenter - radius,
                heightCenter - radius,
                widthCenter + radius,
                heightCenter + radius);
        // 红色矩形 设置偏移量
        RectF rectFRed = new RectF(
                widthCenter - radius - 10,
                heightCenter - radius - 10,
                widthCenter + radius - 10,
                heightCenter + radius - 10);

        // 颜色绘制
        Paint paintColor = new Paint(Paint.ANTI_ALIAS_FLAG);
//        canvas.drawRect(rectF, paintColor); // 先画个矩形出来 确定位置

        // 直线绘制
        Paint paintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintLine.setStrokeWidth(2);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setColor(Color.LTGRAY);

        // 文字绘制
        Paint paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintText.setTextSize(26);
        paintText.setColor(Color.LTGRAY);

        // 起始角度 划过的角度
        float startAngle = 0;
        float sweepAngle = 0;

        // 从 0 角度开始画
        for (int i = 0; i < nameList.size(); i++) {
            // 获取颜色 百分比
            paintColor.setColor(colorList.get(i));
            sweepAngle = precentList.get(i);

            // 画扇形
            if (i == 5) {
                canvas.drawArc(rectFRed, startAngle, sweepAngle - 2, true, paintColor);
            } else {
                canvas.drawArc(rectF, startAngle, sweepAngle - 2, true, paintColor);
            }

            // 获取每个弧度中点
            float textAngle = startAngle + precentList.get(i) / 2;
            /**
             * 已知圆心, 半径, 角度, 求圆上的点坐标
             * 圆点坐标：(x0,y0)
             * 半径：r
             * 角度：a0
             * 则圆上任一点为：（x1,y1）
             * x1 = x0 + r * cos(ao * 3.14 / 180 )
             * y1 = y0 + r * sin(ao * 3.14 / 180 )
             */
            // 弧度中点的坐标
            float pointX = (float) ((float) widthCenter + radius * Math.cos(textAngle * Math.PI / 180));
            float pointY = (float) ((float) heightCenter + radius * Math.sin(textAngle * Math.PI / 180));
            // 弧度中点的延长坐标
            float lineX = 0;
            float lineY = 0;

            // 分情况讨论, 分成四个象限, 分别处理延长坐标
            if (textAngle < 90) {
                lineX = (float) ((float) widthCenter + 20 + radius * Math.cos(textAngle * Math.PI / 180));
                lineY = (float) ((float) heightCenter + 20 + radius * Math.sin(textAngle * Math.PI / 180));

            } else if (textAngle >= 90 && textAngle < 180) {
                lineX = (float) ((float) widthCenter - 20 + radius * Math.cos(textAngle * Math.PI / 180));
                lineY = (float) ((float) heightCenter + 20 + radius * Math.sin(textAngle * Math.PI / 180));

            } else if (textAngle >= 180 && textAngle < 270) {
                lineX = (float) ((float) widthCenter - 20 + radius * Math.cos(textAngle * Math.PI / 180));
                lineY = (float) ((float) heightCenter - 20 + radius * Math.sin(textAngle * Math.PI / 180));

            } else {
                lineX = (float) ((float) widthCenter + 20 + radius * Math.cos(textAngle * Math.PI / 180));
                lineY = (float) ((float) heightCenter - 20 + radius * Math.sin(textAngle * Math.PI / 180));
            }

            // 画斜线
            if (i == 5) {
                // 红色矩形 有偏移量
                canvas.drawLine(pointX - 10, pointY - 10, lineX - 10, lineY - 10, paintLine);
            } else {
                canvas.drawLine(pointX, pointY, lineX, lineY, paintLine);
            }

            // 画直线和文字
            if (i == 5) {
                canvas.drawLine(lineX - 10, lineY - 10, lineX - 60, lineY - 10, paintLine);
                canvas.drawText(nameList.get(i), lineX - 75, lineY, paintText);

            } else if (textAngle < 90) {
                canvas.drawLine(lineX, lineY, lineX + 40, lineY, paintLine);
                canvas.drawText(nameList.get(i), lineX + 45, lineY + 5, paintText);

            } else if (textAngle >= 90 && textAngle < 180) {
                canvas.drawLine(lineX, lineY, lineX - 40, lineY, paintLine);
                canvas.drawText(nameList.get(i), lineX - 95, lineY + 5, paintText);

            } else if (textAngle >= 180 && textAngle < 270) {
                canvas.drawLine(lineX, lineY, lineX - 40, lineY, paintLine);
                canvas.drawText(nameList.get(i), lineX - 95, lineY + 5, paintText);

            } else {
                canvas.drawLine(lineX, lineY, lineX + 40, lineY, paintLine);
                canvas.drawText(nameList.get(i), lineX + 45, lineY + 5, paintText);
            }

            // 起始角度 = 起始角度 + 划过的角度
            startAngle = startAngle + sweepAngle;

            Log.d(TAG, "角度: " + textAngle);
            Log.d(TAG, "斜线坐标: " + pointX + " , " + pointY + " , " + lineX + " , " + lineY);
        }

    }
}
