package com.meiji.hencoderstudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hencoder.hencoderpracticedraw1.PageFragment;

import java.util.List;

/**
 * Created by Meiji on 2017/9/8.
 */

public class MainFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels;

    public static MainFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageModels = PageUtil.getPageList(getArguments().getInt("type"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                // 第一个练习项目展示 sample 和 practice (没有参考代码), 其余的都显示标准答案(尽量把文章出现的例子实现一遍)
                if (pageModel.sampleLayoutRes != 0) {
                    return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);

                } else {
                    return MyPageFragment.newInstance(pageModel.practiceLayoutRes);
                }
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }
}
