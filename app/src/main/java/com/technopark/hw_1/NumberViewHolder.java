package com.technopark.hw_1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberViewHolder extends RecyclerView.ViewHolder {
    private final TextView mNumberTextView;
    private NumberModel mNumberModel;

    public NumberViewHolder(@NonNull View itemView, OnNumberClickListener onNumberClickListener) {
        super(itemView);
        mNumberTextView = itemView.findViewById(R.id.number_text_view);

        mNumberTextView.setOnClickListener((view) -> onNumberClickListener.onNumberClick(mNumberModel));
    }

    public void Bind(@NonNull NumberModel numberModel) {
        mNumberTextView.setText(String.valueOf(numberModel.mValue));
        mNumberTextView.setTextColor(numberModel.mColor);

        mNumberModel = numberModel;
    }
}
