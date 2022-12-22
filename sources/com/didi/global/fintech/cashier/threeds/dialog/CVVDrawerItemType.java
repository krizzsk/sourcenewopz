package com.didi.global.fintech.cashier.threeds.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerItemType;", "", "(Ljava/lang/String;I)V", "Title", "Content", "Images", "Companion", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVDrawer.kt */
public enum CVVDrawerItemType {
    Title,
    Content,
    Images;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerItemType$Companion;", "", "()V", "parse", "Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerItemType;", "type", "", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierCVVDrawer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CVVDrawerItemType parse(String str) {
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1185250696) {
                    if (hashCode != 110371416) {
                        if (hashCode == 951530617 && str.equals("content")) {
                            return CVVDrawerItemType.Content;
                        }
                    } else if (str.equals("title")) {
                        return CVVDrawerItemType.Title;
                    }
                } else if (str.equals("images")) {
                    return CVVDrawerItemType.Images;
                }
            }
            return CVVDrawerItemType.Content;
        }
    }
}
