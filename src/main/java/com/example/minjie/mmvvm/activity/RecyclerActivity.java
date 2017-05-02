package com.example.minjie.mmvvm.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.minjie.mmvvm.R;
import com.example.minjie.mmvvm.fragment.RecyclerFragment;

/**
 * Created by minjie on 20/04/2017.
 */

public class RecyclerActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recycler_layout);

		getSupportFragmentManager().beginTransaction().replace(R.id.recycler, new RecyclerFragment()).commit();
	}


}
