package com.didi.component.payment.activity;

import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "category", "", "kotlin.jvm.PlatformType", "event"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UnipaymentActivity.kt */
final class UnipaymentActivity$payEventListener$1<T> implements BaseEventPublisher.OnEventListener {
    final /* synthetic */ UnipaymentActivity this$0;

    UnipaymentActivity$payEventListener$1(UnipaymentActivity unipaymentActivity) {
        this.this$0 = unipaymentActivity;
    }

    public final void onEvent(String str, String str2) {
        if (TextUtils.equals(str, BaseEventKeys.Pay.CATEGORY)) {
            this.this$0.finish();
        }
    }
}
