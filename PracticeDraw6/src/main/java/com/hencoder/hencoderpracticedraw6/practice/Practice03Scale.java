package com.hencoder.hencoderpracticedraw6.practice;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.meiji.hencoderstudy.practicedraw6.R;


public class Practice03Scale extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    int state = 0;

    public Practice03Scale(Context context) {
        super(context);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);

        animateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // 在这里处理点击事件，通过 View.animate().scaleX/Y() 来让 View 放缩
                switch (state) {
                    case 0:
                        imageView.animate().scaleX(1.5f);
                        break;
                    case 1:
                        ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 1);
                        scaleX.start();
                        break;
                    case 2:
                        imageView.animate().scaleY(.5f);
                        break;
                    case 3:
                        ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 1);
                        scaleY.start();
                        break;
                }
                state++;
                if (state == 4) {
                    state = 0;
                }
            }
        });
    }
}
