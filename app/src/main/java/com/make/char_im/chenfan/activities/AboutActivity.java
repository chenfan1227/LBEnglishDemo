package com.make.char_im.chenfan.activities;


import android.os.Build;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.make.char_im.chenfan.R;
import com.make.char_im.chenfan.adapters.SettingAdapter;
import com.make.char_im.chenfan.base.BaseActivity;
import com.make.char_im.chenfan.been.SettingBean;
import com.make.char_im.chenfan.interfaces.ItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/2 0002.
 **/

public class AboutActivity extends BaseActivity implements ItemClickListener {
    @BindView(R.id.gridView)
    RecyclerView gridView;
    private SettingAdapter adapter;
    private ArrayList<SettingBean> settingBeen = new ArrayList<>();//设置数据集合
    Class<?>[] listClass = {MoreActivity.class, MoreActivity.class, MoreActivity.class, MoreActivity.class, MoreActivity.class, MoreActivity.class, MoreActivity.class, MoreActivity.class, MoreActivity.class};
    //设置选项
    String[] names;
    // 图片封装成一个数组
    int[] image = new int[]{R.mipmap.about, R.mipmap.about, R.mipmap.about, R.mipmap.about, R.mipmap.about, R.mipmap.about, R.mipmap.about, R.mipmap.about, R.mipmap.about,};

    @Override
    protected void loadLayout() {
        setContentView(R.layout.activity_about);
        pageBack();
        swipeBackLayout.setEnablePullToBack(false);
        setTopBarTitle(mContext.getString(R.string.activity_about));
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        setGridView();
    }

    @Override
    protected void setAllClick() {
        adapter.setOnItemClickListener(this);
    }

    @Override
    protected void process() {

    }

    private void setGridView() {
        names = new String[]{"aaaa",
                "bbbb", "cccc",
                "dddd", "eeee",
                "ffff", "hhhh",
                "jjjj", "kkkk"};
        RecyclerView.LayoutManager manager = new GridLayoutManager(mContext, 3);
        gridView.setLayoutManager(manager);
        int length = listClass.length;
        SettingBean settingBean;
        for (int i = 0; i < length; i++) {
            settingBean = new SettingBean();
            settingBean.setName(names[i]);
            settingBean.setaClass(listClass[i]);
            settingBean.setImageId(image[i]);
            settingBeen.add(settingBean);
            adapter = new SettingAdapter(mContext, settingBeen);
            gridView.setAdapter(adapter);//设置adapter\
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        intentAc(listClass[position]);
    }
}
