package com.technopark.hw_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private final NumberModel mNumberModel;

    public SecondFragment(NumberModel numberModel) {
        mNumberModel = numberModel;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView bigNumberView = view.findViewById(R.id.big_number);
        bigNumberView.setText(String.valueOf(mNumberModel.mValue));
        bigNumberView.setTextColor(mNumberModel.mColor);
    }
}