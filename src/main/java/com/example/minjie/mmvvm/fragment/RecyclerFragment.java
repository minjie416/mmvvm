package com.example.minjie.mmvvm.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minjie.mmvvm.R;
import com.example.minjie.mmvvm.databinding.FragmentRecyclerBinding;
import com.example.minjie.mmvvm.viewmodel.RecyclerViewModel;

/**
 * Created by minjie on 20/04/2017.
 */

public class RecyclerFragment extends Fragment {
	private FragmentRecyclerBinding binding;
	private RecyclerViewModel recyclerViewModel;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_recycler, container, false);
		binding = FragmentRecyclerBinding.bind(view);
		recyclerViewModel = new RecyclerViewModel();
		binding.setRecyclerViewModel(recyclerViewModel);
		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		binding.unbind();
	}

}
