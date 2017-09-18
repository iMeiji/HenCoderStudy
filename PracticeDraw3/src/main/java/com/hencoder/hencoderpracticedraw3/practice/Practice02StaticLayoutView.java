package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class Practice02StaticLayoutView extends View {
    TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
    StaticLayout staticLayout1;
    String text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";
    StaticLayout staticLayout2;

    {
        textPaint.setTextSize(60);
        staticLayout1 = new StaticLayout(text1, textPaint, 600,
                Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        staticLayout2 = new StaticLayout(text2, textPaint, 600,
                Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
    }

    /**
     * StaticLayout 的构造方法是 StaticLayout(CharSequence source, TextPaint paint, int width, Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad)，其中参数里：
     * width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
     * align 是文字的对齐方向；
     * spacingmult 是行间距的倍数，通常情况下填 1 就好；
     * spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
     * includeadd 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。
     */

    public Practice02StaticLayoutView(Context context) {
        super(context);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
        canvas.save();
        canvas.translate(50, 100);
        staticLayout1.draw(canvas);
        canvas.translate(0, 500);
        staticLayout2.draw(canvas);
        canvas.restore();

    }
}
