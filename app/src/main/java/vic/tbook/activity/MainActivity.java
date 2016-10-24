package vic.tbook.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vic.tbook.fragment.MineFragment;
import vic.tbook.fragment.ShoppingCartFragment;
import vic.tbook.fragment.StoreFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_store)
    RadioButton mBtnStore;
    @BindView(R.id.btn_cart)
    RadioButton mBtnCart;
    @BindView(R.id.btn_mine)
    RadioButton mBtnMine;
    @BindView(R.id.vp_content)
    ViewPager mVpContent;

    private ArrayList<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setAdapter();
        setListener();
    }

    private void setListener() {
        mVpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0 :
                        mBtnStore.setChecked(true);
                        break;
                    case 1 :
                        mBtnCart.setChecked(true);
                        break;
                    case 2 :
                        mBtnMine.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setAdapter() {
        list = new ArrayList<>();

        list.add(new StoreFragment());
        list.add(new ShoppingCartFragment());
        list.add(new MineFragment());
        mVpContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()){

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }
        });
    }

    @OnClick({R.id.btn_store, R.id.btn_cart, R.id.btn_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_store:
                mVpContent.setCurrentItem(0);
                break;
            case R.id.btn_cart:
                mVpContent.setCurrentItem(1);
                break;
            case R.id.btn_mine:
                mVpContent.setCurrentItem(2);
                break;
        }
    }
}
