package com.didi.soda.customer.component.floatingcarprovider;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0007H&J(\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/customer/component/floatingcarprovider/IFloatingCartProvider;", "", "getShoppingCartPosition", "", "isFloatingCartExpand", "", "playAddToCartAnimation", "", "isOpen", "requestCartInfo", "showFloatingCart", "reversion", "", "businessStatus", "", "biData", "needShowCartMenu", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFloatingCartProvider.kt */
public interface IFloatingCartProvider {
    int[] getShoppingCartPosition();

    boolean isFloatingCartExpand();

    void playAddToCartAnimation(boolean z);

    void requestCartInfo();

    void showFloatingCart(String str, int i, String str2, boolean z);
}
