package com.example.minjie.mmvvm.service;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by minjie on 20/04/2017.
 */

public class ServeiceFactory {
	public static <T> T createService(final Class<T> clazz, final String url) {
		final Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(url)
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create(new Gson()))
				.build();
		return retrofit.create(clazz);
	}
}
