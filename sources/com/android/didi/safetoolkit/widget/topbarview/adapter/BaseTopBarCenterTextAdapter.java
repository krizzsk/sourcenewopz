package com.android.didi.safetoolkit.widget.topbarview.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class BaseTopBarCenterTextAdapter extends BaseTopBarAdapter {
    protected String centerTextStr = "";

    public View getLeftView(View view, ViewGroup viewGroup) {
        return null;
    }

    public View getRightView(View view, ViewGroup viewGroup) {
        return null;
    }

    public BaseTopBarCenterTextAdapter(Activity activity) {
        super(activity);
    }

    public View getCenterView(View view, ViewGroup viewGroup) {
        TextView textView;
        TextView textView2;
        String str;
        Context context = viewGroup.getContext();
        if (view == null) {
            textView = new TextView(context);
            textView.setTextColor(-13421773);
            textView.setTextSize(2, 18.0f);
            textView.setMaxLines(1);
            textView.setGravity(17);
            textView2 = textView;
        } else {
            textView2 = view;
            textView = (TextView) view;
        }
        if (!TextUtils.isEmpty(this.centerTextStr)) {
            textView.setText(this.centerTextStr);
        } else {
            CharSequence string = context.getString(R.string.app_name);
            if (context instanceof Activity) {
                string = ((Activity) context).getTitle();
            }
            if (string == null) {
                str = "";
            } else {
                str = string.toString();
            }
            this.centerTextStr = str;
            if (!TextUtils.isEmpty(string)) {
                textView.setText(string);
            }
        }
        return textView2;
    }

    public String getCenterTextStr() {
        return this.centerTextStr;
    }

    public void setCenterTextStr(String str) {
        this.centerTextStr = str;
        notifyItemChanged(1);
    }
}
