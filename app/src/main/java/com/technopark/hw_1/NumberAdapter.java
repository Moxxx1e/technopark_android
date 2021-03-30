package com.technopark.hw_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NumberAdapter extends RecyclerView.Adapter<NumberViewHolder> {

    List<NumberModel> mData = DataSource.getInstance().getData();

    private final View.OnClickListener mOnNumberClickListener;

    public NumberAdapter(View.OnClickListener onNumberClickListener) {
        mOnNumberClickListener = onNumberClickListener;
    }


    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_layout, parent, false);

        return new NumberViewHolder(view, mOnNumberClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        NumberModel numberModel = mData.get(position);
        holder.Bind(numberModel);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


}
