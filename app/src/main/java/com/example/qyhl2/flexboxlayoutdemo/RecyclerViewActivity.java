package com.example.qyhl2.flexboxlayoutdemo;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<Integer> mDatas = new ArrayList<Integer>();
    private List<String> mDatas2 = new ArrayList<String>();
    private CommonAdapter<String> madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);



        mDatas2.add("娱乐新闻");
        mDatas2.add("体育新闻去是");
        mDatas2.add("娱乐");
        mDatas2.add("松岛枫松asd岛枫新闻");
        mDatas2.add("接近是");
        mDatas2.add("闻");

        mDatas2.add("胜多负少娱乐新闻");
        mDatas2.add("藤原拓实打实的饭海新闻");
        mDatas2.add("娱斯达都让人");
        mDatas2.add("娱乐新闻");

        mDatas2.add("娱乐是我藤原新闻");
        mDatas2.add("娱乐新闻");

        mDatas2.add("娱乐新一UIUS");
        mDatas2.add("㛑");
        mDatas2.add("了圣啊实打实大实打实大所大诞节");


//        mDatas.add(R.drawable.bleach_1);
//        mDatas.add(R.drawable.bleach_2);
//        mDatas.add(R.drawable.bleach_3);
//        mDatas.add(R.drawable.bleach_4);
//        mDatas.add(R.drawable.bleach_5);
//        mDatas.add(R.drawable.bleach_6);
//        mDatas.add(R.drawable.bleach_7);
//        mDatas.add(R.drawable.bleach_8);
//        mDatas.add(R.drawable.bleach_9);
//        mDatas.add(R.drawable.bleach_10);
//        mDatas.add(R.drawable.bleach_11);
//        mDatas.add(R.drawable.bleach_12);


        mDatas.add(R.drawable.cat_1);
        mDatas.add(R.drawable.cat_2);
        mDatas.add(R.drawable.cat_3);
        mDatas.add(R.drawable.cat_4);
        mDatas.add(R.drawable.cat_5);
        mDatas.add(R.drawable.cat_6);
        mDatas.add(R.drawable.cat_7);
        mDatas.add(R.drawable.cat_8);
        mDatas.add(R.drawable.cat_9);
        mDatas.add(R.drawable.bleach_9);
        mDatas.add(R.drawable.cat_10);
        mDatas.add(R.drawable.cat_11);
        mDatas.add(R.drawable.cat_12);
        mDatas.add(R.drawable.cat_13);
        mDatas.add(R.drawable.cat_14);
        mDatas.add(R.drawable.bleach_16);
        mDatas.add(R.drawable.bleach_15);
        mDatas.add(R.drawable.cat_15);
        mDatas.add(R.drawable.bleach_14);
        mDatas.add(R.drawable.cat_16);
        mDatas.add(R.drawable.cat_17);
        mDatas.add(R.drawable.bleach_15);
        mDatas.add(R.drawable.cat_18);
        mDatas.add(R.drawable.cat_19);
        initView();
    }


    /**
     * 初始化
     */
    private void initView() {
        mRecyclerView = (RecyclerView)findViewById(R.id.test_recyclerView);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager();
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setAlignItems(AlignItems.STRETCH);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        mRecyclerView.setLayoutManager(layoutManager);

//        mRecyclerView.setAdapter(madapter= new CommonAdapter<String>(this, R.layout.flexbox_item, mDatas2)
//        {
//            @Override
//            protected void convert(ViewHolder holder, String s, int position) {
//
//                TextView te = holder.getView(R.id.imageview);
//                te.setText(s);
//                ViewGroup.LayoutParams lp = te.getLayoutParams();
//                if (lp instanceof FlexboxLayoutManager.LayoutParams) {
//                    FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) lp;
//                    flexboxLp.setFlexGrow(1.0f);
//                }
//            }
//        });

        mRecyclerView.setAdapter(new CommonAdapter<Integer>(this, R.layout.flexbox_item, mDatas)
        {
            @Override
            protected void convert(ViewHolder holder, Integer s, int position) {
                int pos = position % mDatas.size();
                Drawable drawable = ResourcesCompat.getDrawable(mContext.getResources(),
                        mDatas.get(pos), null);
                ImageView mImageView = (ImageView)holder.getView(R.id.imageview);
                mImageView.setImageDrawable(drawable);

                ViewGroup.LayoutParams lp = mImageView.getLayoutParams();
                if (lp instanceof FlexboxLayoutManager.LayoutParams) {
                    FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) lp;
                    Random random = new Random();
                    //随机宽度
                    int width  =random.nextInt(300)+200;
                    flexboxLp.width=width;
                    flexboxLp.setFlexGrow(1.0f);
                }
            }
        });


//        madapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
//                Toast.makeText(RecyclerViewActivity.this,mDatas2.get(position),Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
//                return false;
//            }
//        });

    }

}
