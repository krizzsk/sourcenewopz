package com.didi.entrega.customer.foundation.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.List;

public final class ColorUtil {
    private ColorUtil() {
    }

    public static int getColorWithAlpha(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
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
