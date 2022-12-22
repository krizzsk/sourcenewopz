package com.didi.global.fintech.cashier.fastpay.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.global.fintech.cashier.fastpay.dialog.FastPayQuestionnaireItem;
import com.didi.global.fintech.cashier.fastpay.omega.FastPayOmegaConstants;
import com.didi.global.fintech.cashier.model.net.response.fastpay.Questionnaire;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierBaseDrawer;
import com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 22\u00020\u0001:\u00012B+\u0012$\u0010\u0002\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\b\u0010*\u001a\u00020\u0006H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u001aH\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u000201H\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\u0002\n\u0000R,\u0010\u0002\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\n\"\u0004\b&\u0010\fR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\n\"\u0004\b)\u0010\f¨\u00063"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayQuestionnaireDrawer;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseDrawer;", "listener", "Lkotlin/Function2;", "", "", "", "(Lkotlin/jvm/functions/Function2;)V", "btn", "getBtn", "()Ljava/lang/String;", "setBtn", "(Ljava/lang/String;)V", "close", "Landroid/widget/ImageView;", "confirm", "Landroid/widget/Button;", "container", "Landroid/view/ViewGroup;", "data", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Questionnaire$Answer;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "items", "", "Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayQuestionnaireItem;", "question", "Landroid/widget/TextView;", "questionId", "getQuestionId", "setQuestionId", "title", "getTitle", "setTitle", "initData", "initView", "view", "Landroid/view/View;", "layout", "onItemClick", "selected", "", "Companion", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayQuestionnaireDrawer.kt */
public final class FastPayQuestionnaireDrawer extends GlobalCashierBaseDrawer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Function2<String, List<String>, Unit> f21551a;

    /* renamed from: b */
    private TextView f21552b;

    /* renamed from: c */
    private Button f21553c;

    /* renamed from: d */
    private ImageView f21554d;

    /* renamed from: e */
    private ViewGroup f21555e;

    /* renamed from: f */
    private List<Questionnaire.Answer> f21556f;

    /* renamed from: g */
    private String f21557g;

    /* renamed from: h */
    private String f21558h;

    /* renamed from: i */
    private String f21559i;

    /* renamed from: j */
    private final List<FastPayQuestionnaireItem> f21560j = new ArrayList();

    /* renamed from: k */
    private int f21561k;

    public int layout() {
        return R.layout.dialog_fast_pay_questionnaire;
    }

    public FastPayQuestionnaireDrawer(Function2<? super String, ? super List<String>, Unit> function2) {
        this.f21551a = function2;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042$\u0010\u0005\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¨\u0006\n"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayQuestionnaireDrawer$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayQuestionnaireDrawer;", "listener", "Lkotlin/Function2;", "", "", "", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayQuestionnaireDrawer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FastPayQuestionnaireDrawer newInstance(Function2<? super String, ? super List<String>, Unit> function2) {
            return new FastPayQuestionnaireDrawer(function2);
        }
    }

    public final List<Questionnaire.Answer> getData() {
        return this.f21556f;
    }

    public final void setData(List<Questionnaire.Answer> list) {
        this.f21556f = list;
    }

    public final String getBtn() {
        return this.f21557g;
    }

    public final void setBtn(String str) {
        this.f21557g = str;
    }

    public final String getTitle() {
        return this.f21558h;
    }

    public final void setTitle(String str) {
        this.f21558h = str;
    }

    public final String getQuestionId() {
        return this.f21559i;
    }

    public final void setQuestionId(String str) {
        this.f21559i = str;
    }

    public final int getIndex() {
        return this.f21561k;
    }

    public final void setIndex(int i) {
        this.f21561k = i;
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tv_title)");
        this.f21552b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.btn_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.btn_confirm)");
        this.f21553c = (Button) findViewById2;
        View findViewById3 = view.findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.iv_close)");
        this.f21554d = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.ll_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.ll_container)");
        this.f21555e = (ViewGroup) findViewById4;
        ImageView imageView = this.f21554d;
        Button button = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FastPayQuestionnaireDrawer.m15774a(FastPayQuestionnaireDrawer.this, view);
            }
        });
        Button button2 = this.f21553c;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
        } else {
            button = button2;
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FastPayQuestionnaireDrawer.m15776b(FastPayQuestionnaireDrawer.this, view);
            }
        });
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_QUIZ_SW);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15774a(FastPayQuestionnaireDrawer fastPayQuestionnaireDrawer, View view) {
        Intrinsics.checkNotNullParameter(fastPayQuestionnaireDrawer, "this$0");
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_QUIZ_CLOSE_CK);
        fastPayQuestionnaireDrawer.dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15776b(FastPayQuestionnaireDrawer fastPayQuestionnaireDrawer, View view) {
        String answerId;
        Intrinsics.checkNotNullParameter(fastPayQuestionnaireDrawer, "this$0");
        List arrayList = new ArrayList();
        for (FastPayQuestionnaireItem fastPayQuestionnaireItem : fastPayQuestionnaireDrawer.f21560j) {
            if (!((fastPayQuestionnaireItem.checked() ? fastPayQuestionnaireDrawer : null) == null || (answerId = fastPayQuestionnaireItem.getData().getAnswerId()) == null)) {
                arrayList.add(answerId);
            }
        }
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_QUIZ_CONFIRM_CK);
        Function2<String, List<String>, Unit> function2 = fastPayQuestionnaireDrawer.f21551a;
        if (function2 != null) {
            function2.invoke(fastPayQuestionnaireDrawer.getQuestionId(), arrayList);
        }
        fastPayQuestionnaireDrawer.dismissAllowingStateLoss();
    }

    public void initData() {
        FastPayQuestionnaireItem fastPayQuestionnaireItem;
        Button button = this.f21553c;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
            button = null;
        }
        button.setEnabled(false);
        Button button2 = this.f21553c;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
            button2 = null;
        }
        button2.setText(this.f21557g);
        TextView textView = this.f21552b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("question");
            textView = null;
        }
        textView.setText(this.f21558h);
        List<Questionnaire.Answer> list = this.f21556f;
        if (list != null) {
            for (Questionnaire.Answer answer : list) {
                Context context = getContext();
                if (context == null) {
                    fastPayQuestionnaireItem = null;
                } else {
                    FastPayQuestionnaireItem.Companion companion = FastPayQuestionnaireItem.Companion;
                    ViewGroup viewGroup = this.f21555e;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("container");
                        viewGroup = null;
                    }
                    fastPayQuestionnaireItem = companion.newIns(context, viewGroup, new FastPayQuestionnaireDrawer$initData$1$item$1$1(this));
                }
                if (fastPayQuestionnaireItem != null) {
                    ViewGroup viewGroup2 = this.f21555e;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("container");
                        viewGroup2 = null;
                    }
                    viewGroup2.addView(fastPayQuestionnaireItem.getRootView());
                    this.f21560j.add(fastPayQuestionnaireItem);
                }
                if (fastPayQuestionnaireItem != null) {
                    fastPayQuestionnaireItem.bind(answer);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15775a(boolean z) {
        FastPayQuestionnaireDrawer fastPayQuestionnaireDrawer = this;
        Button button = null;
        FastPayQuestionnaireDrawer fastPayQuestionnaireDrawer2 = z ? this : null;
        boolean z2 = true;
        if (fastPayQuestionnaireDrawer2 == null) {
            fastPayQuestionnaireDrawer2 = null;
        } else {
            fastPayQuestionnaireDrawer2.setIndex(fastPayQuestionnaireDrawer2.getIndex() + 1);
        }
        if (fastPayQuestionnaireDrawer2 == null) {
            fastPayQuestionnaireDrawer.setIndex(fastPayQuestionnaireDrawer.getIndex() - 1);
        }
        Button button2 = this.f21553c;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
        } else {
            button = button2;
        }
        if (this.f21561k <= 0) {
            z2 = false;
        }
        button.setEnabled(z2);
    }
}
