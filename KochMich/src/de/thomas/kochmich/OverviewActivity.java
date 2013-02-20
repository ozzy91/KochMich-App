package de.thomas.kochmich;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridView;

public class OverviewActivity extends Activity {

	ViewPager pager;
	GridView grid;
	ImagePagerAdapter adapter;
	Animation slideL;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_overview);

		pager = (ViewPager) findViewById(R.id.pager);
		adapter = new ImagePagerAdapter(this, pager);
		pager.setAdapter(adapter);
		slideL = AnimationUtils.loadAnimation(this, R.animator.slide_in_from_right);
		pager.setLayoutAnimation(new LayoutAnimationController(slideL));
		grid = (GridView) findViewById(R.id.grid);
		grid.setAdapter(new ImageAdapter(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_overview, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_rotate:
			if (pager.getCurrentItem() < 5) {
				pager.setCurrentItem(pager.getCurrentItem() + 1);
			} else {
				pager.setCurrentItem(0);
			}
		}
		return super.onOptionsItemSelected(item);
	}

}
