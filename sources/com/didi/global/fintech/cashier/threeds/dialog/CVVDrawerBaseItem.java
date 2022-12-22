package com.didi.global.fintech.cashier.threeds.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.model.net.response.CVVDrawerData;
import com.didi.global.fintech.cashier.p117ui.kts.ContextKtxKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\u0014\u0010\u0018\u001a\u00020\u0010*\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u001aH\u0016J\u0014\u0010\u001b\u001a\u00020\u0010*\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerBaseItem;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "getContext", "()Landroid/content/Context;", "rootViewHolder", "Landroid/view/View;", "getRootViewHolder", "()Landroid/view/View;", "setRootViewHolder", "(Landroid/view/View;)V", "bind", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData$LineData;", "initView", "layout", "", "type", "Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerItemType;", "color", "Landroid/widget/TextView;", "", "size", "Landroid/widget/ImageView;", "Companion", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVDrawer.kt */
public abstract class CVVDrawerBaseItem {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Context f21670a;

    /* renamed from: b */
    private final ViewGroup f21671b;

    /* renamed from: c */
    private View f21672c;

    public abstract void bind(CVVDrawerData.LineData lineData);

    public abstract int layout();

    public abstract CVVDrawerItemType type();

    public CVVDrawerBaseItem(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f21670a = context;
        this.f21671b = viewGroup;
    }

    public final Context getContext() {
        return this.f21670a;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerBaseItem$Companion;", "", "()V", "getInstance", "Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerBaseItem;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "type", "Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerItemType;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierCVVDrawer.kt */
    public static final class Companion {

        @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: GlobalCashierCVVDrawer.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CVVDrawerItemType.values().length];
                iArr[CVVDrawerItemType.Title.ordinal()] = 1;
                iArr[CVVDrawerItemType.Content.ordinal()] = 2;
                iArr[CVVDrawerItemType.Images.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CVVDrawerBaseItem getInstance(Context context, ViewGroup viewGroup, CVVDrawerItemType cVVDrawerItemType) {
            CVVDrawerBaseItem cVVDrawerBaseItem;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(cVVDrawerItemType, "type");
            int i = WhenMappings.$EnumSwitchMapping$0[cVVDrawerItemType.ordinal()];
            if (i == 1) {
                cVVDrawerBaseItem = new CVVDrawerTitleItem(context, viewGroup);
            } else if (i == 2) {
                cVVDrawerBaseItem = new CVVDrawerContentItem(context, viewGroup);
            } else if (i == 3) {
                cVVDrawerBaseItem = new CVVDrawerImagesItem(context, viewGroup);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            cVVDrawerBaseItem.initView();
            return cVVDrawerBaseItem;
        }
    }

    public View getRootViewHolder() {
        return this.f21672c;
    }

    public void setRootViewHolder(View view) {
        this.f21672c = view;
    }

    public void initView() {
        setRootViewHolder(LayoutInflater.from(this.f21670a).inflate(layout(), this.f21671b, false));
    }

    public void color(TextView textView, String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(str, "color");
        if (Intrinsics.areEqual((Object) str, (Object) "grey")) {
            textView.setTextColor(-7829368);
        } else if (Intrinsics.areEqual((Object) str, (Object) "black")) {
            textView.setTextColor(-16777216);
        } else {
            textView.setTextColor(-16777216);
        }
    }

    public void size(ImageView imageView, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, "size");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (Intrinsics.areEqual((Object) str, (Object) "big")) {
            layoutParams.width = -1;
        } else {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            layoutParams.width = ContextKtxKt.dp2px(context, 70.0f);
        }
        imageView.setLayoutParams(layoutParams);
    }
}
