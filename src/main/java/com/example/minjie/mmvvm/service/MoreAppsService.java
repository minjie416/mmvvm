package com.example.minjie.mmvvm.service;

import com.example.minjie.mmvvm.model.MoreApps;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by minjie on 20/04/2017.
 */

public interface MoreAppsService {
	String SERVICE_ENDPOINT = "https://sites.google.com/site/nwanvu/source/";

	@GET("moreapps")
	Observable<MoreApps> getMoreApps();
}
