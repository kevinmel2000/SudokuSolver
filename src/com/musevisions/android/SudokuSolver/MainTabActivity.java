/**
 * JSON Sudoku solver is covered under the Creative Commons Attribution 3.0 Unported License
 * http://creativecommons.org/licenses/by/3.0/
 * 
 * @author www.androidcookers.co.cc
 * {@link www.androidcookers.co.cc}
 */
package com.musevisions.android.SudokuSolver;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainTabActivity extends TabActivity {
	
	SudokuLoaderActivity mLoaderActivity;
	SudokuSolverActivity mSolverActivity;
	
	/** Called when the activity is first created. */	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		setTabs() ;
	}
	
	public void setLoaderActivity(SudokuLoaderActivity activity) {
		mLoaderActivity = activity;
	}
	public void setSolverActivity(SudokuSolverActivity activity) {
		mSolverActivity = activity;	
	}
	
	public SudokuSolverActivity getSolverActivity() {
		return mSolverActivity;
	}
	
	private void setTabs()
	{
		addTab("Game", R.drawable.tab_home, SudokuSolverActivity.class);
		addTab("Load", R.drawable.tab_search, SudokuLoaderActivity.class);

		//To add more tabs just use addTab() method here like previous line.
	}
	
	private void addTab(String labelId, int drawableId, Class<?> c)
	{
		TabHost tabHost = getTabHost();
		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);	
		
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
		title.setText(labelId);
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);
		
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}
}