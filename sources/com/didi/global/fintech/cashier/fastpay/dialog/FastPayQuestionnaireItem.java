package com.didi.global.fintech.cashier.fastpay.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.didi.global.fintech.cashier.fastpay.omega.FastPayOmegaConstants;
import com.didi.global.fintech.cashier.model.net.response.fastpay.Questionnaire;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayQuestionnaireItem;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "listener", "Lkotlin/Function1;", "", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "cb", "Landroid/widget/CheckBox;", "data", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Questionnaire$Answer;", "getData", "()Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Questionnaire$Answer;", "setData", "(Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Questionnaire$Answer;)V", "rootViewHolder", "Landroid/view/View;", "title", "Landroid/widget/TextView;", "bind", "checked", "getRootView", "Companion", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayQuestionnaireDrawer.kt */
public final class FastPayQuestionnaireItem {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Function1<Boolean, Unit> f21562a;

    /* renamed from: b */
    private final View f21563b;

    /* renamed from: c */
    private final TextView f21564c;

    /* renamed from: d */
    private final CheckBox f21565d;
    public Questionnaire.Answer data;

    public FastPayQuestionnaireItem(Context context, ViewGroup viewGroup, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(function1, "listener");
        this.f21562a = function1;
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_holder_questionnaire_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…aire_item, parent, false)");
        this.f21563b = inflate;
        View findViewById = inflate.findViewById(R.id.tv_item_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootViewHolder.findViewById(R.id.tv_item_title)");
        this.f21564c = (TextView) findViewById;
        View findViewById2 = this.f21563b.findViewById(R.id.cb_item_check);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootViewHolder.findViewById(R.id.cb_item_check)");
        this.f21565d = (CheckBox) findViewById2;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayQuestionnaireItem$Companion;", "", "()V", "newIns", "Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayQuestionnaireItem;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "listener", "Lkotlin/Function1;", "", "", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayQuestionnaireDrawer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FastPayQuestionnaireItem newIns(Context context, ViewGroup viewGroup, Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(function1, "listener");
            return new FastPayQuestionnaireItem(context, viewGroup, function1);
        }
    }

    public final View getRootView() {
        return this.f21563b;
    }

    public final Questionnaire.Answer getData() {
        Questionnaire.Answer answer = this.data;
        if (answer != null) {
            return answer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public final void setData(Questionnaire.Answer answer) {
        Intrinsics.checkNotNullParameter(answer, "<set-?>");
        this.data = answer;
    }

    public final void bind(Questionnaire.Answer answer) {
        Intrinsics.checkNotNullParameter(answer, "data");
        setData(answer);
        this.f21565d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FastPayQuestionnaireItem.m15777a(FastPayQuestionnaireItem.this, view);
            }
        });
        ViewKtxKt.content(this.f21564c, answer.getAnswer());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15777a(FastPayQuestionnaireItem fastPayQuestionnaireItem, View view) {
        Intrinsics.checkNotNullParameter(fastPayQuestionnaireItem, "this$0");
        fastPayQuestionnaireItem.f21562a.invoke(Boolean.valueOf(fastPayQuestionnaireItem.checked()));
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_QUIZ_ITEM_CK);
    }

    public final boolean checked() {
        return this.f21565d.isChecked();
    }
}
