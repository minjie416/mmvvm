package com.example.minjie.mmvvm.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

/**
 * Created by minjie on 20/04/2017.
 */

public class MoreApps extends BaseObservable {
	List<MoreApp> apps;

	@Bindable
	public List<MoreApp> getApps() {
		return apps;
	}

	public void setApps(List<MoreApp> apps) {
		this.apps = apps;
		notifyChange();
	}
}
