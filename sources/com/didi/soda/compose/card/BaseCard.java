package com.didi.soda.compose.card;

import com.didi.soda.compose.service.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006$"}, mo175978d2 = {"Lcom/didi/soda/compose/card/BaseCard;", "", "()V", "mCardId", "", "getMCardId", "()Ljava/lang/String;", "setMCardId", "(Ljava/lang/String;)V", "mData", "getMData", "()Ljava/lang/Object;", "setMData", "(Ljava/lang/Object;)V", "mLayoutType", "getMLayoutType", "setMLayoutType", "mPosition", "", "getMPosition", "()I", "setMPosition", "(I)V", "mRenderType", "getMRenderType", "setMRenderType", "mServiceManager", "Lcom/didi/soda/compose/service/ServiceManager;", "getMServiceManager", "()Lcom/didi/soda/compose/service/ServiceManager;", "setMServiceManager", "(Lcom/didi/soda/compose/service/ServiceManager;)V", "mTemplate", "getMTemplate", "setMTemplate", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseCard.kt */
public final class BaseCard {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_CARD_ID = "card_id";
    public static final String KEY_HYBRID = "hybrid";
    public static final String KEY_NATIVE = "native";
    public static final String KEY_RENDER_TYPE = "render_type";
    public static final String KEY_TEMPLATE = "template";

    /* renamed from: a */
    private ServiceManager f40114a;

    /* renamed from: b */
    private Object f40115b;

    /* renamed from: c */
    private String f40116c;

    /* renamed from: d */
    private String f40117d;

    /* renamed from: e */
    private String f40118e;

    /* renamed from: f */
    private String f40119f;

    /* renamed from: g */
    private int f40120g;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/compose/card/BaseCard$Companion;", "", "()V", "KEY_CARD_ID", "", "KEY_HYBRID", "KEY_NATIVE", "KEY_RENDER_TYPE", "KEY_TEMPLATE", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BaseCard.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final ServiceManager getMServiceManager() {
        return this.f40114a;
    }

    public final void setMServiceManager(ServiceManager serviceManager) {
        this.f40114a = serviceManager;
    }

    public final Object getMData() {
        return this.f40115b;
    }

    public final void setMData(Object obj) {
        this.f40115b = obj;
    }

    public final String getMLayoutType() {
        return this.f40116c;
    }

    public final void setMLayoutType(String str) {
        this.f40116c = str;
    }

    public final String getMTemplate() {
        return this.f40117d;
    }

    public final void setMTemplate(String str) {
        this.f40117d = str;
    }

    public final String getMCardId() {
        return this.f40118e;
    }

    public final void setMCardId(String str) {
        this.f40118e = str;
    }

    public final String getMRenderType() {
        return this.f40119f;
    }

    public final void setMRenderType(String str) {
        this.f40119f = str;
    }

    public final int getMPosition() {
        return this.f40120g;
    }

    public final void setMPosition(int i) {
        this.f40120g = i;
    }
}
