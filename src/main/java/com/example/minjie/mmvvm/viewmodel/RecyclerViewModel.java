package com.example.minjie.mmvvm.viewmodel;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.minjie.mmvvm.adapter.RecyclerListAdapter;
import com.example.minjie.mmvvm.model.MoreApp;
import com.example.minjie.mmvvm.model.MoreApps;
import com.example.minjie.mmvvm.service.MoreAppsService;
import com.example.minjie.mmvvm.service.ServeiceFactory;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by minjie on 20/04/2017.
 */

public class RecyclerViewModel {
	public MoreApps apps;
	private Subscription subscription;

	public RecyclerViewModel(){
		apps = new MoreApps();
		getApps();
	}

	public void getApps() {
		if (subscription != null && !subscription.isUnsubscribed()) {
			subscription.unsubscribe();
		}

		MoreAppsService service = ServeiceFactory.createService(MoreAppsService.class, MoreAppsService.SERVICE_ENDPOINT);

		subscription = service.getMoreApps()
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<MoreApps>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onNext(MoreApps moreApps) {
						if(apps!=null){
							apps.setApps(moreApps.getApps());
						}
					}
				});
	}

	@BindingAdapter("app:items")
	public static void bind(RecyclerView recyclerView, List<MoreApp> apps){
		final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
		recyclerView.setLayoutManager(linearLayoutManager);
		RecyclerListAdapter adapter = new RecyclerListAdapter(apps);
		adapter.setOnItemClickListener(new RecyclerListAdapter.OnItemClickListener() {

			@Override
			public void onItemClick(View view, int position, RecyclerListAdapter.ListHolder holder) {
				Toast.makeText(holder.itemView.getContext(), holder.binding.getApp().getAppname(), Toast.LENGTH_SHORT).show();
			}
		});
		recyclerView.setAdapter(adapter);
	}



}
