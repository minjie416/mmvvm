package com.example.minjie.mmvvm.adapter;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.minjie.mmvvm.R;
import com.example.minjie.mmvvm.databinding.ItemsBinding;
import com.example.minjie.mmvvm.model.MoreApp;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by minjie on 20/04/2017.
 */

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ListHolder> {

	private List<MoreApp> apps;

	public RecyclerListAdapter(List<MoreApp> apps) {
		this.apps = apps;
	}

	@Override
	public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
		return new ListHolder(view);
	}

	@Override
	public void onBindViewHolder(final ListHolder holder, int position) {
		MoreApp moreApp = apps.get(position);
		holder.binding.setApp(moreApp);
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (onItemClickListener != null) {
					onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition(), holder);
				}
			}
		});
	}

	@Override
	public int getItemCount() {
		return apps == null ? 0 : apps.size();
	}

	public static class ListHolder extends RecyclerView.ViewHolder {
		public ItemsBinding binding;

		public ListHolder(View itemView) {
			super(itemView);
			binding = ItemsBinding.bind(itemView);
		}
	}

	@BindingAdapter("app:imageUrl")
	public static void bind(ImageView view, String url){
		Picasso.with(view.getContext()).load(url).fit().into(view);
	}

	public interface OnItemClickListener {
		void onItemClick(View view, int position, ListHolder holder);
	}

	private OnItemClickListener onItemClickListener;

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}
}
