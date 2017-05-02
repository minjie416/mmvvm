package com.example.minjie.mmvvm.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.minjie.mmvvm.BR;

/**
 * Created by minjie on 18/04/2017.
 */

public class Text extends BaseObservable{
	private String a;
	private String b;

	public Text(String a, String b) {
		this.a = a;
		this.b = b;
	}

	@Bindable
	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
		notifyPropertyChanged(BR.a);
	}

	@Bindable
	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
		notifyPropertyChanged(BR.b);
	}
}
