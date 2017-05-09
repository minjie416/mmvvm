package com.example.minjie.mmvvm.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.minjie.mmvvm.R;
import com.example.minjie.mmvvm.fragment.RecyclerFragment;
import com.example.minjie.mmvvm.service.ICountService;

/**
 * Created by minjie on 20/04/2017.
 */

public class RecyclerActivity extends AppCompatActivity {

	private ICountService countService;
	private ServiceConnection serviceConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
			countService = (ICountService) iBinder;
			Log.v("CountService", "on service connected, count is "+countService.getCount());
		}

		@Override
		public void onServiceDisconnected(ComponentName componentName) {
			countService=null;
		}
	};

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recycler_layout);

		getSupportFragmentManager().beginTransaction().replace(R.id.recycler, new RecyclerFragment()).commit();

		Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
		this.bindService(new Intent("com.example.minjie.mmvvm.service.CountService"), this.serviceConnection, BIND_AUTO_CREATE);
	}

	@Override
	protected void onDestroy() {
		this.unbindService(serviceConnection);
		super.onDestroy();
	}
}
