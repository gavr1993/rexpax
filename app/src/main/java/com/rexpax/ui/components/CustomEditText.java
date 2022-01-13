package com.rexpax.ui.components;


import android.widget.EditText;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;


/**
 * Created by Anton on 31.7.15.
 */
public class CustomEditText extends EditText {

    public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        String font = null;
        if (attrs != null) {
//            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomFontView);
//            font = (String) a.getText(R.styleable.CustomFontView_customFont);

//            a.recycle();
        }
        if (TextUtils.isEmpty(font)) {
//            font = FontsStorage.FONT_HELVETICA;
        }
        applyFont(font);
    }

    public CustomEditText(Context context) {
        this(context, null, android.R.attr.editTextStyle);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public void applyFont(String fontName) {
        if (fontName != null) {
            if (!isInEditMode()) {
//                FontsStorage.applyFont(getContext(), fontName, this);
            }
        }
    }
}
