package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.minidev.asm.ConvertDate;
import java.util.Date;

/* renamed from: com.cardinalcommerce.a.setInitialScale */
public abstract class setInitialScale<T> extends setWebViewRenderProcessClient<T> {
    public static setWebViewRenderProcessClient<Date> Cardinal = new setSafeBrowsingWhitelist<Date>() {
        public final /* synthetic */ Object init(Object obj) {
            return ConvertDate.convertToDate(obj);
        }
    };
}
