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
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.minjie.mmvvm.R;
import com.example.minjie.mmvvm.fragment.RecyclerFragment;
import com.example.minjie.mmvvm.model.TestP;
import com.example.minjie.mmvvm.service.CountServiceAIDL;
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
//		setContentView(R.layout.new2);
//		Button btn = (Button) findViewById(R.id.btn);
//		btn.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				recycler();
//			}
//		});

		getSupportFragmentManager().beginTransaction().replace(R.id.recycler, new RecyclerFragment()).commit();

//		Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
//		this.bindService(new Intent("com.example.minjie.mmvvm.service.CountService"), this.serviceConnection, BIND_AUTO_CREATE);
		System.out.println("----------------------onCreate----------------------");

//		TestP t = (TestP) getIntent().getParcelableExtra("test");
//		Toast.makeText(getApplicationContext(), t.getName(), Toast.LENGTH_SHORT).show();
	}
	public void recycler(){
		Intent intent = new Intent(this, RecyclerActivity.class);
		this.startActivity(intent);
	}

	@Override
	protected void onStart() {
		System.out.println("----------------------onStart----------------------");
		super.onStart();
	}

	@Override
	protected void onStop() {
		System.out.println("----------------------onStop----------------------");
		super.onStop();
	}

	@Override
	protected void onPause() {
		System.out.println("----------------------onPause----------------------");
		super.onPause();
	}

	@Override
	protected void onResume() {
		System.out.println("----------------------onResume----------------------");
		super.onResume();
	}

	@Override
	protected void onRestart() {
		System.out.println("----------------------onRestart----------------------");
		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		this.unbindService(serviceConnection);
		super.onDestroy();
	}


}
