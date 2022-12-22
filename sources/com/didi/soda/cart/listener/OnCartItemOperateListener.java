package com.didi.soda.cart.listener;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J1\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\f¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/cart/listener/OnCartItemOperateListener;", "", "onCartItemCheckoutClick", "", "shopId", "", "cartId", "onCartItemRemoveClick", "onCartItemShopClick", "businessType", "", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OnCartItemOperateListener.kt */
public interface OnCartItemOperateListener {
    void onCartItemCheckoutClick(String str, String str2);

    void onCartItemRemoveClick(String str);

    void onCartItemShopClick(String str, String str2, Integer num, String str3);
}
