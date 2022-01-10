package com.technopark.hw_1;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private final List<NumberModel> mData;

    public DataSource(int size) {
        mData = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            NumberModel model = new NumberModel(i, i % 2 == 0 ? Color.RED : Color.BLUE);
            mData.add(model);
        }
    }

    public void AddNextNumber() {
        int nextNumber = mData.size() + 1;
        NumberModel numberModel = new NumberModel(nextNumber);
        mData.add(numberModel);
    }

    public List<NumberModel> getData() {
        return mData;
    }

    public int getSize() {
        return mData.size();
    }
}
