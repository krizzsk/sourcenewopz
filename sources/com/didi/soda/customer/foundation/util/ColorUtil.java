package com.didi.soda.customer.foundation.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.google.gson.JsonSyntaxException;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public final class ColorUtil {
    private ColorUtil() {
    }

    public static int getColorWithAlpha(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }

    public static ColorStateList getTagTextColorStateList(Context context) {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842913}, new int[]{-16842913}}, new int[]{SkinUtil.getBrandPrimaryColor(), SkinUtil.getBrandPrimaryColor(), context.getResources().getColor(R.color.rf_color_gery_2_40_666666)});
    }

    public static List<Integer> parseColors(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                List list = (List) GsonUtil.fromJson(str, ArrayList.class);
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(Integer.valueOf(Color.parseColor(list.get(i).toString())));
                }
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                arrayList.clear();
            }
            if (arrayList.size() == 1) {
                arrayList.add(Integer.valueOf(((Integer) arrayList.get(0)).intValue()));
            }
        }
        return arrayList;
    }
}
