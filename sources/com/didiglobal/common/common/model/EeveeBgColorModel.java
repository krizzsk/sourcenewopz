package com.didiglobal.common.common.model;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.component.never.common.util.UIUtils;
import java.util.List;

public class EeveeBgColorModel implements BffGsonStruct {
    public List<String> colors;
    public int direction;
    public int type;

    public void bindView(View view, int i) {
        if (view != null) {
            if (this.type == 0) {
                List<String> list = this.colors;
                if (list == null || list.size() <= 0) {
                    view.setBackgroundColor(0);
                } else if (!TextUtils.isEmpty(this.colors.get(0))) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(UIUtils.dip2px(view.getContext(), (float) i));
                    gradientDrawable.setColor(Color.parseColor(this.colors.get(0)));
                    view.setBackground(gradientDrawable);
                } else {
                    view.setBackgroundColor(0);
                }
            } else {
                view.setBackground(getBackgroundDrawable(view.getContext(), i));
            }
        }
    }

    private GradientDrawable getBackgroundDrawable(Context context, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(UIUtils.dip2px(context, (float) i));
        gradientDrawable.setOrientation(this.direction == 0 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.TOP_BOTTOM);
        List<String> list = this.colors;
        if (list == null || list.size() != 2 || TextUtils.isEmpty(this.colors.get(0)) || TextUtils.isEmpty(this.colors.get(1))) {
            gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        } else {
            try {
                gradientDrawable.setColors(new int[]{Color.parseColor(this.colors.get(0)), Color.parseColor(this.colors.get(1))});
            } catch (Exception e) {
                e.printStackTrace();
                gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
            }
        }
        return gradientDrawable;
    }
}
