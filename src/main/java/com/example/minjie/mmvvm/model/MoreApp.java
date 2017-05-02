package com.example.minjie.mmvvm.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.minjie.mmvvm.BR;


/**
 * Created by minjie on 20/04/2017.
 */

public class MoreApp extends BaseObservable {
	private String appname;
	private String appauthor;
	private String appicon;

	@Bindable
	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
		notifyPropertyChanged(BR.appname);
	}

	@Bindable
	public String getAppauthor() {
		return appauthor;
	}

	public void setAppauthor(String appauthor) {
		this.appauthor = appauthor;
		notifyPropertyChanged(BR.appauthor);
	}

	@Bindable
	public String getAppicon() {
		return appicon;
	}

	public void setAppicon(String appicon) {
		this.appicon = appicon;
		notifyPropertyChanged(BR.appicon);
	}
}
