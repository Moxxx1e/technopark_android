package com.technopark.hw_1;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static DataSource isInstance;
    private final List<NumberModel> mData;

    public DataSource() {
        mData = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
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

    public synchronized static DataSource getInstance() {
        if (isInstance == null) {
            isInstance = new DataSource();
        }
        return isInstance;
    }

    public int getSize() {
        return mData.size();
    }

}
