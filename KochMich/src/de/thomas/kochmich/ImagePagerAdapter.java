package de.thomas.kochmich;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImagePagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
	
	private final ViewPager mViewPager;
	private final Context mContext;
	
	public ImagePagerAdapter(Activity activity, ViewPager pager) {
		mViewPager = pager;
		mContext = activity;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		mViewPager.removeView((View)object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		LinearLayout layout = new LinearLayout(mContext);
		layout.setGravity(Gravity.CENTER);
		LayoutParams params = new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		TextView tv = new TextView(mContext);
		tv.setText("Test "+position);
		tv.setTextColor(Color.WHITE);
		layout.addView(tv, params);
		mViewPager.addView(layout);
        return layout;
	}

	@Override
	public int getCount() {
		return 6;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		System.out.println("Scrolled");
	}

	@Override
	public void onPageSelected(int arg0) {
		Log.i("", "selected");
	}

}
