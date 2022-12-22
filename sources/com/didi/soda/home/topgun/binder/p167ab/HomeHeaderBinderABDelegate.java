package com.didi.soda.home.topgun.binder.p167ab;

import android.content.Context;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;
import com.taxis99.R;

/* renamed from: com.didi.soda.home.topgun.binder.ab.HomeHeaderBinderABDelegate */
public interface HomeHeaderBinderABDelegate {
    int getAddressLayoutPaddingBottom(Context context);

    int getHeaderOffset(Context context);

    /* renamed from: com.didi.soda.home.topgun.binder.ab.HomeHeaderBinderABDelegate$HomeHeaderBinderConfigB */
    public static class HomeHeaderBinderConfigB implements HomeHeaderBinderABDelegate {
        public int getHeaderOffset(Context context) {
            return GlobalContext.isEmbed() ? DisplayUtils.dip2px(context, 16.0f) : (int) context.getResources().getDimension(R.dimen.customer_topgun_home_header_sticky_offset);
        }

        public int getAddressLayoutPaddingBottom(Context context) {
            return DisplayUtils.dip2px(context, 15.0f);
        }
    }

    /* renamed from: com.didi.soda.home.topgun.binder.ab.HomeHeaderBinderABDelegate$HomeHeaderBinderConfigA */
    public static class HomeHeaderBinderConfigA implements HomeHeaderBinderABDelegate {
        public int getHeaderOffset(Context context) {
            return (int) context.getResources().getDimension(R.dimen.customer_topgun_home_header_sticky_offset);
        }

        public int getAddressLayoutPaddingBottom(Context context) {
            return DisplayUtils.dip2px(context, 25.0f);
        }
    }
}
