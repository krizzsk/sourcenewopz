package com.didi.beatles.p099im.views.feed;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import rui.config.RConfigConstants;

/* renamed from: com.didi.beatles.im.views.feed.IMListTraceVHolder */
public abstract class IMListTraceVHolder extends RecyclerView.ViewHolder {
    public abstract void traceHolder();

    IMListTraceVHolder(View view) {
        super(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo44266a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String append : list) {
            sb.append(append);
            sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
        }
        return sb.substring(0, sb.length() - 1);
    }
}
