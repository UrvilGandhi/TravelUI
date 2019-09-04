package com.example.sunshinetravel.CustomWidgets;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatRadioButton;

import com.example.sunshinetravel.Utilites.Constants;
import com.example.sunshinetravel.R;


public class CustomRadioButton extends AppCompatRadioButton {


    private Context mContext;
    private String mFont;

    public CustomRadioButton(Context context) {
        super(context, null);
        mContext = context;
        init();
    }

    public CustomRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTextView,
                0, 0);
        try {
            mFont = a.getString(R.styleable.CustomTextView_fontName);
        } finally {
            a.recycle();
        }
        init();
    }

    public void init() {
        if (mFont != null) {
            Typeface tf = null;
            switch (mFont) {
                case "Montserrat-Bold.ttf":
                    tf = Typeface.createFromAsset(mContext.getAssets(), Constants.montserratBold);
                    break;
                case "Montserrat-Light.ttf":
                    tf = Typeface.createFromAsset(mContext.getAssets(), Constants.montserratLight);
                    break;
                case "Montserrat-Regular.ttf":
                    tf = Typeface.createFromAsset(mContext.getAssets(), Constants.montserratRegular);
                    break;
                case "Montserrat-SemiBold.ttf":
                    tf = Typeface.createFromAsset(mContext.getAssets(), Constants.montserratSemiBold);
                    break;
            }
            setTypeface(tf, Typeface.NORMAL);
        }
    }
}
