package com.didi.soda.bill.component.deliverymethod;

import android.view.View;
import android.widget.ScrollView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;

/* renamed from: com.didi.soda.bill.component.deliverymethod.a */
/* compiled from: ScrollViewHelper */
class C13399a {
    C13399a() {
    }

    /* renamed from: a */
    public static void m27650a(ScrollView scrollView, View view) {
        scrollView.post(new Runnable(scrollView, view) {
            public final /* synthetic */ ScrollView f$0;
            public final /* synthetic */ View f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                C13399a.m27653d(this.f$0, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m27653d(ScrollView scrollView, View view) {
        scrollView.fullScroll(130);
        view.setPadding(0, 0, 0, 0);
    }

    /* renamed from: b */
    public static void m27651b(ScrollView scrollView, View view) {
        scrollView.post(new Runnable(scrollView, view) {
            public final /* synthetic */ ScrollView f$0;
            public final /* synthetic */ View f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                C13399a.m27652c(this.f$0, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m27652c(ScrollView scrollView, View view) {
        scrollView.fullScroll(33);
        view.setPadding(0, 0, 0, DisplayUtils.dip2px(GlobalContext.getContext(), 94.0f));
    }
}
