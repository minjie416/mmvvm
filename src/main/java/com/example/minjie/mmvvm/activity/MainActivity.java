package com.example.minjie.mmvvm.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.minjie.mmvvm.BR;
import com.example.minjie.mmvvm.R;
import com.example.minjie.mmvvm.databinding.ActivityMainBinding;
import com.example.minjie.mmvvm.model.DaoUtil;
import com.example.minjie.mmvvm.model.Person;
import com.example.minjie.mmvvm.model.PersonDaoUtil;
import com.example.minjie.mmvvm.model.TestP;
import com.example.minjie.mmvvm.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;
	private MainViewModel mainViewModel;
	int i = 0;

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

//		TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
//		tm.getLine1Number();
	}

	public void insert(View view){
//		Shop shop = new Shop();
//		shop.setName("Min" + i);
//		i++;
		//		LoveDao.insertLove(shop);

		Person p = new Person();
		p.setName("p" + i);
		p.setAge(i * 10);
		i++;
		PersonDaoUtil.insertPerson(p);
	}

	public void query(View view){
//		List<Shop> list = LoveDao.queryAll();
//		StringBuilder sb = new StringBuilder("");
//		for(Shop shop : list){
//			sb.append(shop.getName() + " ");
//		}
//		Toast.makeText(getBaseContext(), sb.toString(), Toast.LENGTH_SHORT).show();

		List<Person> list = PersonDaoUtil.querryAllPerson();
		if (list != null && list.size() != 0) {
			StringBuilder sb = new StringBuilder("");
			for (Person p : list) {
				sb.append(p.getId() + ":" + p.getName() + ":" + p.getAge() + "\n");
			}
			Toast.makeText(getBaseContext(), sb.toString(), Toast.LENGTH_SHORT).show();
		}
	}

	public void update(View view){
		Person p = new Person((long) 1, "bbb", 33);
		PersonDaoUtil.updatePerson(p);
	}

	public void delete(View view){
		PersonDaoUtil.deletePerson((long) 1);
	}

	public void clickImage(View view){
		Toast.makeText(this, "CLICK", Toast.LENGTH_SHORT).show();
	}

	public void recycler(View view){
		TestP t = new TestP("AAA", 10);
		Intent intent = new Intent(this, RecyclerActivity.class);
		intent.putExtra("test", t);
		this.startActivity(intent);
	}

	public void aidl(View view){
		Intent intent = new Intent(this, AidlActivity.class);
		this.startActivity(intent);
	}

	public void personAidl(View view){
		Intent intent = new Intent(this, PersonAIDLActivity.class);
		this.startActivity(intent);
	}
}
