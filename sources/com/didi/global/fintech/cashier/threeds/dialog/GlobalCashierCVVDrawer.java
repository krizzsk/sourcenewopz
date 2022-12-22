package com.didi.global.fintech.cashier.threeds.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.global.fintech.cashier.model.net.response.CVVDrawerData;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierBaseDrawer;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.threeds.dialog.CVVDrawerBaseItem;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/dialog/GlobalCashierCVVDrawer;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseDrawer;", "()V", "confirm", "Landroid/widget/Button;", "container", "Landroid/view/ViewGroup;", "data", "Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData;", "getData", "()Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData;", "setData", "(Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData;)V", "title", "Landroid/widget/TextView;", "initData", "", "initView", "view", "Landroid/view/View;", "layout", "", "Companion", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVDrawer.kt */
public final class GlobalCashierCVVDrawer extends GlobalCashierBaseDrawer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private CVVDrawerData f21676a;

    /* renamed from: b */
    private TextView f21677b;

    /* renamed from: c */
    private Button f21678c;

    /* renamed from: d */
    private ViewGroup f21679d;

    public int layout() {
        return R.layout.dialog_global_cashier_cvv;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/dialog/GlobalCashierCVVDrawer$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/threeds/dialog/GlobalCashierCVVDrawer;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierCVVDrawer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierCVVDrawer newInstance() {
            return new GlobalCashierCVVDrawer();
        }
    }

    public final CVVDrawerData getData() {
        return this.f21676a;
    }

    public final void setData(CVVDrawerData cVVDrawerData) {
        this.f21676a = cVVDrawerData;
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tv_title)");
        this.f21677b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.btn_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.btn_confirm)");
        this.f21678c = (Button) findViewById2;
        View findViewById3 = view.findViewById(R.id.ll_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.ll_container)");
        this.f21679d = (ViewGroup) findViewById3;
        Button button = this.f21678c;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GlobalCashierCVVDrawer.m15807a(GlobalCashierCVVDrawer.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15807a(GlobalCashierCVVDrawer globalCashierCVVDrawer, View view) {
        Intrinsics.checkNotNullParameter(globalCashierCVVDrawer, "this$0");
        globalCashierCVVDrawer.dismissAllowingStateLoss();
    }

    public void initData() {
        List<CVVDrawerData.LineData> lines;
        CVVDrawerBaseItem cVVDrawerBaseItem;
        TextView textView = this.f21677b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        CVVDrawerData cVVDrawerData = this.f21676a;
        ViewKtxKt.content(textView, cVVDrawerData == null ? null : cVVDrawerData.getTitle());
        CVVDrawerData cVVDrawerData2 = this.f21676a;
        if (cVVDrawerData2 != null && (lines = cVVDrawerData2.getLines()) != null) {
            for (CVVDrawerData.LineData lineData : lines) {
                Context context = getContext();
                if (context == null) {
                    cVVDrawerBaseItem = null;
                } else {
                    CVVDrawerBaseItem.Companion companion = CVVDrawerBaseItem.Companion;
                    ViewGroup viewGroup = this.f21679d;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("container");
                        viewGroup = null;
                    }
                    cVVDrawerBaseItem = companion.getInstance(context, viewGroup, CVVDrawerItemType.Companion.parse(lineData.getType()));
                }
                if (cVVDrawerBaseItem != null) {
                    ViewGroup viewGroup2 = this.f21679d;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("container");
                        viewGroup2 = null;
                    }
                    viewGroup2.addView(cVVDrawerBaseItem.getRootViewHolder());
                }
                if (cVVDrawerBaseItem != null) {
                    cVVDrawerBaseItem.bind(lineData);
                }
            }
        }
    }
}
