package com.didi.component.evaluateentrance.evaluate.toolkit;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;

public final class ViewToolKit {

    /* renamed from: a */
    private final View f13504a;

    /* renamed from: b */
    private final SparseArray<View> f13505b = new SparseArray<>();

    private ViewToolKit(View view) {
        this.f13504a = view;
    }

    public static ViewToolKit create(View view) {
        return new ViewToolKit(view);
    }

    public void setTextViewText(int i, CharSequence charSequence, CharSequence charSequence2) {
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = charSequence2;
        }
        setTextViewText(i, charSequence);
    }

    public void setTextViewText(int i, CharSequence charSequence, int i2) {
        if (TextUtils.isEmpty(charSequence)) {
            setTextViewText(i, i2);
        } else {
            setTextViewText(i, charSequence);
        }
    }

    public void setTextViewText(int i, CharSequence charSequence) {
        try {
            ((TextView) findViewById(i)).setText(charSequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTextViewTextWithEmptyGone(int i, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            setViewVisible(i, false);
        } else {
            setTextViewText(i, charSequence);
        }
    }

    public void setTextViewText(int i, int i2) {
        try {
            ((TextView) findViewById(i)).setText(i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setImageView(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ImageView imageView = (ImageView) findViewById(i);
                Glide.with(imageView.getContext()).load(str).into(imageView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setImageView(int i, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            ((ImageView) findViewById(i)).setImageResource(i2);
            return;
        }
        try {
            ImageView imageView = (ImageView) findViewById(i);
            ((RequestBuilder) Glide.with(imageView.getContext()).load(str).placeholder(i2)).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setViewVisible(int i, boolean z) {
        try {
            findViewById(i).setVisibility(z ? 0 : 8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnClickListener(int i, View.OnClickListener onClickListener) {
        try {
            findViewById(i).setOnClickListener(onClickListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setViewVisible(int i, int i2) {
        try {
            findViewById(i).setVisibility(i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final <T extends View> T findViewById(int i) {
        T t = (View) this.f13505b.get(i);
        if (t != null) {
            return t;
        }
        T findViewById = this.f13504a.findViewById(i);
        this.f13505b.put(i, findViewById);
        return findViewById;
    }
}
