package com.example.booksale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTabHost;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.booksale.bean.Tab;
import com.example.booksale.fragment.CartFragment;
import com.example.booksale.fragment.CategoryFragment;
import com.example.booksale.fragment.HomeFragment;
import com.example.booksale.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private FragmentTabHost mTabhost;
    private LayoutInflater minflater;
    private FragmentManager mfragmentManager;
    private FragmentTransaction mTransaction;
    private ArrayList<Fragment> fragments;
    private BottomNavigationBar bottomNavigationBar;
    private int lastSelectedPosition = 0;
    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private CartFragment cartFragment;
    private MineFragment mineFragment;
    private String TAG = MainActivity.class.getSimpleName();

    //  List<Tab> mtablist = new ArrayList<>(4);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        init();

    }

    private void init() {
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        //设计按钮模式
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.home,"主页")).setActiveColor(R.color.orange)
                            .addItem(new BottomNavigationItem(R.mipmap.comments,"分类")).setActiveColor(R.color.blue)
                            .addItem(new BottomNavigationItem(R.mipmap.cart,"购物车")).setActiveColor(R.color.red)
                            .addItem(new BottomNavigationItem(R.mipmap.account,"我的")).setActiveColor(R.color.green)
                            .setFirstSelectedPosition(lastSelectedPosition)
                            .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        mfragmentManager = getSupportFragmentManager();
        mTransaction = mfragmentManager.beginTransaction();
        mTransaction.replace(R.id.fragment_content, HomeFragment.newInstance("主页"));
        mTransaction.commit();
    }


    @Override
    public void onTabSelected(int position) {
        mfragmentManager = getSupportFragmentManager();
        mTransaction = mfragmentManager.beginTransaction();
        switch (position){
            case 0 :
                if (homeFragment == null){
                    homeFragment = HomeFragment.newInstance("主页");
                }
                mTransaction.replace(R.id.fragment_content,homeFragment);
                break;
            case 1:
                if (categoryFragment == null){
                    categoryFragment=CategoryFragment.newInstance("分类");
                }
                mTransaction.replace(R.id.fragment_content,categoryFragment);
                break;
            case 2:
                if (cartFragment == null){
                    cartFragment= CartFragment.newInstance("购物车");
                }
                mTransaction.replace(R.id.fragment_content,cartFragment);
                break;
            case 3:
                if (mineFragment == null) {
                    mineFragment=MineFragment.newInstance("我的");
                }
                mTransaction.replace(R.id.fragment_content,mineFragment);
                break;
            default:
                    break;
        }
        mTransaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {
        Log.d(TAG, "onTabUnselected() called with: " + "position = [" + position + "]");
    }

    @Override
    public void onTabReselected(int position) {

    }



    /*private void initTab() {
        Tab tab_home = new Tab(R.string.home,R.mipmap.home,HomeFragment.class);
        Tab tab_cart = new Tab(R.string.cart,R.mipmap.cart, CartFragment.class);
        Tab tab_category = new Tab(R.string.category,R.mipmap.comments, CategoryFragment.class);
        Tab tab_mine = new Tab(R.string.mine,R.mipmap.account, MineFragment.class);

        mtablist.add(tab_home);
        mtablist.add(tab_cart);
        mtablist.add(tab_category);
        mtablist.add(tab_mine);

        minflater = LayoutInflater.from(this);
        mTabhost = findViewById(R.id.tab_host);
        mTabhost.setup(this,getSupportFragmentManager(),R.id.fragment_content);

        for (Tab tab : mtablist){
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(bulidIndicator(tab));
            mTabhost.addTab(tabSpec,tab.getFragmen(),null);
        }
    }
    private View bulidIndicator(Tab tab){

        View view=minflater.inflate(R.layout.indicator_tab,null);
        ImageView img_tab = findViewById(R.id.icon_tab);
        TextView tv_indicator = findViewById(R.id.tv_indicator);

        img_tab.setBackgroundResource(tab.getIcon());
        tv_indicator.setText(tab.getTitle());

        return view;
    }*/
}
