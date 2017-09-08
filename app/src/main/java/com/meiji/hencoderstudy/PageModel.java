package com.meiji.hencoderstudy;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

/**
 * Created by Meiji on 2017/9/8.
 */

public class PageModel {
    @StringRes
    int titleRes;
    @LayoutRes
    int practiceLayoutRes;
    @LayoutRes
    int sampleLayoutRes;

    PageModel(@StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
        this.titleRes = titleRes;
        this.practiceLayoutRes = practiceLayoutRes;
    }

    PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
        this.sampleLayoutRes = sampleLayoutRes;
        this.titleRes = titleRes;
        this.practiceLayoutRes = practiceLayoutRes;
    }
}
