package q.rorbin.verticaltablayoutdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import q.rorbin.verticaltablayout.TabAdapter;
import q.rorbin.verticaltablayout.VerticalTabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab0();
        initTab1();
        initTab2();
        initTab3();
    }

    private void initTab0() {
        VerticalTabLayout tablayout = (VerticalTabLayout) findViewById(R.id.tablayout0);
        tablayout.setTabAdapter(new MyTabAdapter(this));
    }

    private void initTab1() {
        VerticalTabLayout tablayout = (VerticalTabLayout) findViewById(R.id.tablayout1);
        tablayout.setTabAdapter(new MyTabAdapter(this));
    }

    private void initTab2() {
        VerticalTabLayout tablayout = (VerticalTabLayout) findViewById(R.id.tablayout2);
        tablayout.setTabAdapter(new MyTabAdapter(this));
    }

    private void initTab3() {
        VerticalTabLayout tablayout = (VerticalTabLayout) findViewById(R.id.tablayout);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setAdapter(new MyPagerAdapter(this));
        tablayout.setupWithViewPager(viewpager);
    }

    class MyTabAdapter implements TabAdapter {

        List<String> titles;
        Context context;

        MyTabAdapter(Context context){
            this.context = context;
        }


        {
            titles = new ArrayList<String>();
            Collections.addAll(titles, "Android", "IOS", "Web", "JAVA", "C++",
                    ".NET", "JavaScript", "Swift", "PHP", "Python", "C#", "Groovy", "SQL", "Ruby");
        }

        @Override
        public int getCount() {
            return 14;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getTabItemView(int position) {
            LayoutInflater li = LayoutInflater.from(this.context);
            View v = li.inflate(R.layout.view_tab_item, null);
            TextView titleTv = v.findViewById(R.id.titleTv);
            titleTv.setText(titles.get(position));
            return v;
        }
    }

    class MyPagerAdapter extends PagerAdapter implements TabAdapter {
        List<MenuBean> menus;

        Context context;

        public MyPagerAdapter(Context context) {
            this.context = context;

            menus = new ArrayList<>();
            Collections.addAll(menus, new MenuBean(R.drawable.man_01_pressed, R.drawable.man_01_none, "汇总")
                    , new MenuBean(R.drawable.man_02_pressed, R.drawable.man_02_none, "图表")
                    , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "收藏")
                    , new MenuBean(R.drawable.man_04_pressed, R.drawable.man_04_none, "竞拍"));
        }

        @Override
        public int getCount() {
            return 4;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getTabItemView(int position) {
            LayoutInflater li = LayoutInflater.from(this.context);
            View v = li.inflate(R.layout.view_tab_item, null);
            TextView titleTv = v.findViewById(R.id.titleTv);
            ImageView imgView = v.findViewById(R.id.imgView);

            MenuBean menu = menus.get(position);
            titleTv.setText(menu.mTitle);
            imgView.setImageResource(menu.mNormalIcon);

            return v;
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(MainActivity.this);
            tv.setText("" + position);
            container.addView(tv);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
