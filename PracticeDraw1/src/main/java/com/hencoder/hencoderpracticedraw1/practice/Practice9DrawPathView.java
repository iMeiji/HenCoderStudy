package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    Paint paint = new Paint();
    Path path = new Path();

    /**
     *  arcTo() 只用来画弧形而不画扇形，所以不再需要 useCenter 参数；
     *  而多出来的这个 forceMoveTo 参数的意思是，绘制是要「抬一下笔移动过去」，还是「直接拖着笔过去」，区别在于是否留下移动的痕迹。
     *
     *  addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo() 。
     */

    {
        // 使用 path 对图形进行描述
        path.addArc(300, 100, 400, 200, -225, 225); // 等于 path.arcTo(300, 100, 400, 200, -225, 225, true);
        path.arcTo(400, 100, 500, 200, -180, 225, false);
        path.lineTo(400, 282);
    }

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        canvas.drawPath(path, paint); // 绘制出 path 描述的图形（心形），大功告成
    }
}
