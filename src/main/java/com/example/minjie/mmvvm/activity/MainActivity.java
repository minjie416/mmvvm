package com.example.minjie.mmvvm.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.minjie.mmvvm.BR;
import com.example.minjie.mmvvm.R;
import com.example.minjie.mmvvm.databinding.ActivityMainBinding;
import com.example.minjie.mmvvm.model.DaoUtil;
import com.example.minjie.mmvvm.model.LoveDao;
import com.example.minjie.mmvvm.model.Shop;
import com.example.minjie.mmvvm.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;
	private MainViewModel mainViewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mainViewModel = new MainViewModel(this);
		mainViewModel.setUrl("http://images2015.cnblogs.com/news/24442/201704/24442-20170418140643727-710809625.png");
		mainViewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
			@Override
			public void onPropertyChanged(Observable observable, int i) {
				if(i== BR.a){
					Toast.makeText(getBaseContext(), mainViewModel.getA(), Toast.LENGTH_SHORT).show();
				}
			}
		});
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		binding.setMainVM(mainViewModel);

		DaoUtil.setupDatabase(getBaseContext());
	}

	public void click(View view){
		Shop shop = new Shop();
		shop.setName("Min");
		LoveDao.insertLove(shop);
	}

	public void click2(View view){
		List<Shop> list = LoveDao.queryAll();
		Toast.makeText(getBaseContext(), list.get(0).getName(), Toast.LENGTH_SHORT).show();
	}

	public void clickImage(View view){
		Toast.makeText(this, "CLICK", Toast.LENGTH_SHORT).show();
	}

	public void recycler(View view){
		Intent intent = new Intent(this, RecyclerActivity.class);
		this.startActivity(intent);
	}
}
