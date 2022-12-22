package com.didi.entrega.customer.map.marker;

import android.content.Context;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.map.infowindow.AbInfoWindowView;
import com.didi.entrega.order.widgets.MarkerInfoWindowView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/entrega/customer/map/marker/InfoWindowViewFactory;", "", "()V", "createInfoViewByCategory", "Lcom/didi/entrega/customer/map/infowindow/AbInfoWindowView;", "ctx", "Landroid/content/Context;", "infoWindowViewBuildConfig", "Lcom/didi/entrega/customer/map/marker/InfoWindowViewBuildConfig;", "Companion", "InfoViewCategory", "SingletonHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoWindowViewFactory.kt */
public final class InfoWindowViewFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final InfoWindowViewFactory f20201a = SingletonHolder.INSTANCE.getHolder();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int f20202b = (DisplayUtils.getScreenWidth(GlobalContext.getContext()) - DisplayUtils.dip2px(GlobalContext.getContext(), 40.0f));

    public /* synthetic */ InfoWindowViewFactory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/entrega/customer/map/marker/InfoWindowViewFactory$Companion;", "", "()V", "instance", "Lcom/didi/entrega/customer/map/marker/InfoWindowViewFactory;", "getInstance", "()Lcom/didi/entrega/customer/map/marker/InfoWindowViewFactory;", "markerInfoMaxWidth", "", "getMarkerInfoMaxWidth", "()I", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InfoWindowViewFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InfoWindowViewFactory getInstance() {
            return InfoWindowViewFactory.f20201a;
        }

        public final int getMarkerInfoMaxWidth() {
            return InfoWindowViewFactory.f20202b;
        }
    }

    private InfoWindowViewFactory() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/customer/map/marker/InfoWindowViewFactory$SingletonHolder;", "", "()V", "holder", "Lcom/didi/entrega/customer/map/marker/InfoWindowViewFactory;", "getHolder", "()Lcom/didi/entrega/customer/map/marker/InfoWindowViewFactory;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InfoWindowViewFactory.kt */
    private static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();
        private static final InfoWindowViewFactory holder = new InfoWindowViewFactory((DefaultConstructorMarker) null);

        private SingletonHolder() {
        }

        public final InfoWindowViewFactory getHolder() {
            return holder;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, mo175978d2 = {"Lcom/didi/entrega/customer/map/marker/InfoWindowViewFactory$InfoViewCategory;", "", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: InfoWindowViewFactory.kt */
    public @interface InfoViewCategory {
        public static final int BILL_RECEIVER = 2;
        public static final int BILL_SENDER = 1;
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int ORDER_RIDER = 3;

        @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/customer/map/marker/InfoWindowViewFactory$InfoViewCategory$Companion;", "", "()V", "BILL_RECEIVER", "", "BILL_SENDER", "ORDER_RIDER", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: InfoWindowViewFactory.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int BILL_RECEIVER = 2;
            public static final int BILL_SENDER = 1;
            public static final int ORDER_RIDER = 3;

            private Companion() {
            }
        }
    }

    public final AbInfoWindowView createInfoViewByCategory(Context context, InfoWindowViewBuildConfig infoWindowViewBuildConfig) {
        AbInfoWindowView abInfoWindowView;
        Intrinsics.checkNotNullParameter(context, "ctx");
        if (infoWindowViewBuildConfig == null) {
            return null;
        }
        int category = infoWindowViewBuildConfig.getCategory();
        if (category == 1 || category == 2) {
            abInfoWindowView = new BillInfoWindowView(context);
        } else if (category != 3) {
            return null;
        } else {
            abInfoWindowView = new MarkerInfoWindowView(context);
        }
        return abInfoWindowView;
    }
}
