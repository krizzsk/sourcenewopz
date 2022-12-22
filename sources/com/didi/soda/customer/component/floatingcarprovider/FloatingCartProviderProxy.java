package com.didi.soda.customer.component.floatingcarprovider;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J(\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/customer/component/floatingcarprovider/FloatingCartProviderProxy;", "Lcom/didi/soda/customer/component/floatingcarprovider/IFloatingCartProvider;", "provider", "(Lcom/didi/soda/customer/component/floatingcarprovider/IFloatingCartProvider;)V", "mReference", "Ljava/lang/ref/WeakReference;", "getShoppingCartPosition", "", "isFloatingCartExpand", "", "playAddToCartAnimation", "", "isOpen", "requestCartInfo", "showFloatingCart", "reversion", "", "businessStatus", "", "biData", "needShowCartMenu", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FloatingCartProviderProxy.kt */
public final class FloatingCartProviderProxy implements IFloatingCartProvider {

    /* renamed from: a */
    private final WeakReference<IFloatingCartProvider> f40788a;

    public FloatingCartProviderProxy(IFloatingCartProvider iFloatingCartProvider) {
        this.f40788a = new WeakReference<>(iFloatingCartProvider);
    }

    public void showFloatingCart(String str, int i, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "reversion");
        Intrinsics.checkNotNullParameter(str2, "biData");
        IFloatingCartProvider iFloatingCartProvider = (IFloatingCartProvider) this.f40788a.get();
        if (iFloatingCartProvider != null) {
            iFloatingCartProvider.showFloatingCart(str, i, str2, z);
        }
    }

    public boolean isFloatingCartExpand() {
        IFloatingCartProvider iFloatingCartProvider = (IFloatingCartProvider) this.f40788a.get();
        if (iFloatingCartProvider == null) {
            return false;
        }
        return iFloatingCartProvider.isFloatingCartExpand();
    }

    public void requestCartInfo() {
        IFloatingCartProvider iFloatingCartProvider = (IFloatingCartProvider) this.f40788a.get();
        if (iFloatingCartProvider != null) {
            iFloatingCartProvider.requestCartInfo();
        }
    }

    public void playAddToCartAnimation(boolean z) {
        IFloatingCartProvider iFloatingCartProvider = (IFloatingCartProvider) this.f40788a.get();
        if (iFloatingCartProvider != null) {
            iFloatingCartProvider.playAddToCartAnimation(z);
        }
    }

    public int[] getShoppingCartPosition() {
        int[] iArr;
        IFloatingCartProvider iFloatingCartProvider = (IFloatingCartProvider) this.f40788a.get();
        if (iFloatingCartProvider == null) {
            iArr = null;
        } else {
            iArr = iFloatingCartProvider.getShoppingCartPosition();
        }
        return iArr == null ? new int[2] : iArr;
    }
}
