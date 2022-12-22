package com.didi.soda.customer.foundation.rpc.entity.cart;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoPriceEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "cartFavorPrice", "", "getCartFavorPrice", "()I", "setCartFavorPrice", "(I)V", "cartFavorPriceDisplay", "", "getCartFavorPriceDisplay", "()Ljava/lang/String;", "setCartFavorPriceDisplay", "(Ljava/lang/String;)V", "cartPriceDesc", "getCartPriceDesc", "setCartPriceDesc", "currency", "getCurrency", "setCurrency", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartInfoPriceEntity.kt */
public final class CartInfoPriceEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 6409871820149865414L;
    private int cartFavorPrice;
    private String cartFavorPriceDisplay;
    private String cartPriceDesc;
    private String currency;

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final String getCartPriceDesc() {
        return this.cartPriceDesc;
    }

    public final void setCartPriceDesc(String str) {
        this.cartPriceDesc = str;
    }

    public final String getCartFavorPriceDisplay() {
        return this.cartFavorPriceDisplay;
    }

    public final void setCartFavorPriceDisplay(String str) {
        this.cartFavorPriceDisplay = str;
    }

    public final int getCartFavorPrice() {
        return this.cartFavorPrice;
    }

    public final void setCartFavorPrice(int i) {
        this.cartFavorPrice = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoPriceEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartInfoPriceEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String toString() {
        return "CartInfoPriceEntity(currency=" + this.currency + ", cartPriceDesc=" + this.cartPriceDesc + ", cartFavorPriceDisplay=" + this.cartFavorPriceDisplay + ", cartFavorPrice=" + this.cartFavorPrice + VersionRange.RIGHT_OPEN;
    }
}
