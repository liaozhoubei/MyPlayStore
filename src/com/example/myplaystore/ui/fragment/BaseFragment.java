package com.example.myplaystore.ui.fragment;

import com.example.myplaystore.ui.view.LoadingPager;
import com.example.myplaystore.ui.view.LoadingPager.ResultState;
import com.example.myplaystore.utils.UIUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	
	private LoadingPager mLoadingPager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mLoadingPager = new LoadingPager(UIUtils.getContext()){

			@Override
			public View onCreateSuccessView() {
				
				return BaseFragment.this.onCreateSuccessView();
			}

			@Override
			public ResultState onLoad() {
				// TODO Auto-generated method stub
				return BaseFragment.this.onLoad();
			}
			
		};
		
		return mLoadingPager;
	}
	
	public abstract View onCreateSuccessView();
	
	public abstract ResultState onLoad();
	
	public void loadData(){
		if (mLoadingPager != null) {
			mLoadingPager.loadData();
		}
	}

}
