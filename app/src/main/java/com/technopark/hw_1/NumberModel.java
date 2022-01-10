package com.technopark.hw_1;

import android.graphics.Color;

public class NumberModel {
    int mValue;
    int mColor;

    public NumberModel(int value, int color) {
        mValue = value;
        mColor = color;
    }

    public NumberModel(int value) {
        mValue = value;
        mColor = value % 2 == 0 ? Color.RED : Color.BLUE;
    }
}
