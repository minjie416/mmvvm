package com.example.minjie.mmvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.minjie.mmvvm.BR;
import com.squareup.picasso.Picasso;

/**
 * Created by minjie on 18/04/2017.
 */

public class MainViewModel extends BaseObservable {
	private String a;
	private String b;
	private String url;

	@Bindable
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		notifyPropertyChanged(BR.url);
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

	public MainViewModel(Context context) {
		this.a = "aaa";
		this.b = "bbb";
	}

	@BindingAdapter("app:url")
	public static void bindImage(ImageView view, String url){
		Picasso.with(view.getContext())
				.load(url)
				.fit()
				.into(view);
	}
}
