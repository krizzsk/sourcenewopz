package global.didi.pay.installment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.component.presenter.PayInfoManager;
import com.didi.unifiedPay.sdk.model.InstallmentModel;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.util.DeviceUtil;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder;
import global.didi.pay.installment.viewholder.InstallmentListItemViewHolder;
import global.didi.pay.web.UniPayWebModel;
import global.didi.pay.web.UniPayWebUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u00108\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00109\u001a\u00020/H\u0016J\b\u0010:\u001a\u000205H\u0016J*\u0010;\u001a$\u0012\f\u0012\n =*\u0004\u0018\u00010<0< =*\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010<0<0>0\u001dH\u0002J\b\u0010?\u001a\u000205H\u0016J\u0012\u0010@\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010BH\u0014J\b\u0010C\u001a\u000205H\u0002J\u0010\u00109\u001a\u00020/2\u0006\u00109\u001a\u00020/H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020&X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001a\u0010.\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006E"}, mo175978d2 = {"Lglobal/didi/pay/installment/InstallmentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/didi/unifiedPay/component/IViewCallback;", "()V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mContainerBody", "Landroid/view/ViewGroup;", "getMContainerBody", "()Landroid/view/ViewGroup;", "setMContainerBody", "(Landroid/view/ViewGroup;)V", "mContainerTitle", "getMContainerTitle", "setMContainerTitle", "mHeaderServiceItem", "Lglobal/didi/pay/installment/viewholder/InstallmentHeaderItemViewHolder;", "getMHeaderServiceItem", "()Lglobal/didi/pay/installment/viewholder/InstallmentHeaderItemViewHolder;", "setMHeaderServiceItem", "(Lglobal/didi/pay/installment/viewholder/InstallmentHeaderItemViewHolder;)V", "mHeaderTotalItem", "getMHeaderTotalItem", "setMHeaderTotalItem", "mListItem", "", "Lglobal/didi/pay/installment/viewholder/InstallmentListItemViewHolder;", "getMListItem", "()Ljava/util/List;", "mOid", "", "mPayParam", "Lcom/didi/unifiedPay/component/model/PayParam;", "mTvBottomTip", "Landroid/widget/TextView;", "getMTvBottomTip", "()Landroid/widget/TextView;", "setMTvBottomTip", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "selectIndex", "", "getSelectIndex", "()I", "setSelectIndex", "(I)V", "callStartActivity", "", "intent", "Landroid/content/Intent;", "callStartActivityForResult", "requestCode", "closeView", "getInstallment", "Lcom/didi/unifiedPay/sdk/model/InstallmentModel;", "kotlin.jvm.PlatformType", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshHeaderItem", "Companion", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InstallmentActivity.kt */
public final class InstallmentActivity extends AppCompatActivity implements IViewCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String INSTALLMENT_NUMBER = "INSTALLMENT_NUMBER";
    public static final String INSTALLMENT_URL = "INSTALLMENT_URL";
    public Button mBtnConfirm;
    public ViewGroup mContainerBody;
    public ViewGroup mContainerTitle;
    public InstallmentHeaderItemViewHolder mHeaderServiceItem;
    public InstallmentHeaderItemViewHolder mHeaderTotalItem;
    private final List<InstallmentListItemViewHolder> mListItem = new ArrayList();
    private String mOid;
    private PayParam mPayParam;
    public TextView mTvBottomTip;
    public TextView mTvTitle;
    private int selectIndex;

    public void callStartActivity(Intent intent) {
    }

    public void closeView() {
    }

    public int requestCode(int i) {
        return 0;
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lglobal/didi/pay/installment/InstallmentActivity$Companion;", "", "()V", "INSTALLMENT_NUMBER", "", "INSTALLMENT_URL", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "payParam", "Lcom/didi/unifiedPay/component/model/PayParam;", "number", "url", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InstallmentActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(Context context, PayParam payParam, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(payParam, "payParam");
            Intrinsics.checkNotNullParameter(str, "number");
            Intent intent = new Intent(context, InstallmentActivity.class);
            intent.putExtra("pay_param", payParam);
            intent.putExtra(InstallmentActivity.INSTALLMENT_NUMBER, str);
            intent.putExtra(InstallmentActivity.INSTALLMENT_URL, str2);
            return intent;
        }
    }

    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        throw null;
    }

    public final void setMTvTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBtnConfirm");
        throw null;
    }

    public final void setMBtnConfirm(Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final ViewGroup getMContainerTitle() {
        ViewGroup viewGroup = this.mContainerTitle;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainerTitle");
        throw null;
    }

    public final void setMContainerTitle(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.mContainerTitle = viewGroup;
    }

    public final ViewGroup getMContainerBody() {
        ViewGroup viewGroup = this.mContainerBody;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainerBody");
        throw null;
    }

    public final void setMContainerBody(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.mContainerBody = viewGroup;
    }

    public final InstallmentHeaderItemViewHolder getMHeaderTotalItem() {
        InstallmentHeaderItemViewHolder installmentHeaderItemViewHolder = this.mHeaderTotalItem;
        if (installmentHeaderItemViewHolder != null) {
            return installmentHeaderItemViewHolder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHeaderTotalItem");
        throw null;
    }

    public final void setMHeaderTotalItem(InstallmentHeaderItemViewHolder installmentHeaderItemViewHolder) {
        Intrinsics.checkNotNullParameter(installmentHeaderItemViewHolder, "<set-?>");
        this.mHeaderTotalItem = installmentHeaderItemViewHolder;
    }

    public final InstallmentHeaderItemViewHolder getMHeaderServiceItem() {
        InstallmentHeaderItemViewHolder installmentHeaderItemViewHolder = this.mHeaderServiceItem;
        if (installmentHeaderItemViewHolder != null) {
            return installmentHeaderItemViewHolder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHeaderServiceItem");
        throw null;
    }

    public final void setMHeaderServiceItem(InstallmentHeaderItemViewHolder installmentHeaderItemViewHolder) {
        Intrinsics.checkNotNullParameter(installmentHeaderItemViewHolder, "<set-?>");
        this.mHeaderServiceItem = installmentHeaderItemViewHolder;
    }

    public final TextView getMTvBottomTip() {
        TextView textView = this.mTvBottomTip;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTvBottomTip");
        throw null;
    }

    public final void setMTvBottomTip(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mTvBottomTip = textView;
    }

    public final List<InstallmentListItemViewHolder> getMListItem() {
        return this.mListItem;
    }

    public final int getSelectIndex() {
        return this.selectIndex;
    }

    public final void setSelectIndex(int i) {
        this.selectIndex = i;
    }

    private final List<InstallmentModel> getInstallment() {
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(this.mOid);
        List<InstallmentModel> list = payInfo == null ? null : payInfo.installmentModel;
        return list == null ? new ArrayList<>() : list;
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004a, code lost:
        r9 = r9.getStringExtra(INSTALLMENT_NUMBER);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            com.didi.sdk.apm.SystemUtils.hookOnlyFullscreenOpaque(r8)
            super.onCreate(r9)
            r9 = 2132017535(0x7f14017f, float:1.9673351E38)
            r8.setTheme(r9)
            r9 = r8
            android.app.Activity r9 = (android.app.Activity) r9
            android.content.res.Resources r0 = r8.getResources()
            r1 = 2131101241(0x7f060639, float:1.7814886E38)
            int r0 = r0.getColor(r1)
            r1 = 1
            com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat.setStatusBarBgLightning(r9, r1, r0)
            r9 = 2131625160(0x7f0e04c8, float:1.887752E38)
            r8.setContentView((int) r9)
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r0 = "pay_param"
            java.io.Serializable r9 = r9.getSerializableExtra(r0)
            if (r9 == 0) goto L_0x0224
            com.didi.unifiedPay.component.model.PayParam r9 = (com.didi.unifiedPay.component.model.PayParam) r9
            r8.mPayParam = r9
            java.lang.String r0 = ""
            if (r9 != 0) goto L_0x003a
        L_0x0038:
            r9 = r0
            goto L_0x003f
        L_0x003a:
            java.lang.String r9 = r9.oid
            if (r9 != 0) goto L_0x003f
            goto L_0x0038
        L_0x003f:
            r8.mOid = r9
            android.content.Intent r9 = r8.getIntent()
            r2 = 0
            if (r9 != 0) goto L_0x004a
        L_0x0048:
            r9 = 0
            goto L_0x0058
        L_0x004a:
            java.lang.String r3 = "INSTALLMENT_NUMBER"
            java.lang.String r9 = r9.getStringExtra(r3)
            if (r9 != 0) goto L_0x0053
            goto L_0x0048
        L_0x0053:
            int r9 = java.lang.Integer.parseInt(r9)
            int r9 = r9 - r1
        L_0x0058:
            r8.selectIndex = r9
            r9 = 2131427899(0x7f0b023b, float:1.8477427E38)
            android.view.View r3 = r8.findViewById(r9)
            global.didi.pay.installment.-$$Lambda$InstallmentActivity$uYWcdohubcIenu2i364TkGZL0II r4 = new global.didi.pay.installment.-$$Lambda$InstallmentActivity$uYWcdohubcIenu2i364TkGZL0II
            r4.<init>()
            r3.setOnClickListener(r4)
            r3 = 2131431769(0x7f0b1159, float:1.8485277E38)
            android.view.View r3 = r8.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            global.didi.pay.installment.-$$Lambda$InstallmentActivity$57xs03OVcR3TxYxQrcitf0nC8Qs r4 = new global.didi.pay.installment.-$$Lambda$InstallmentActivity$57xs03OVcR3TxYxQrcitf0nC8Qs
            r4.<init>()
            r3.setOnClickListener(r4)
            r3 = 2131431840(0x7f0b11a0, float:1.848542E38)
            android.view.View r4 = r8.findViewById(r3)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.Intent r5 = r8.getIntent()
            r6 = 0
            java.lang.String r7 = "INSTALLMENT_URL"
            if (r5 != 0) goto L_0x008e
            r5 = r6
            goto L_0x0092
        L_0x008e:
            java.lang.String r5 = r5.getStringExtra(r7)
        L_0x0092:
            if (r5 == 0) goto L_0x0096
            r5 = 0
            goto L_0x0098
        L_0x0096:
            r5 = 8
        L_0x0098:
            r4.setVisibility(r5)
            android.content.Intent r4 = r8.getIntent()
            if (r4 != 0) goto L_0x00a2
            goto L_0x00b7
        L_0x00a2:
            java.lang.String r4 = r4.getStringExtra(r7)
            if (r4 != 0) goto L_0x00a9
            goto L_0x00b7
        L_0x00a9:
            android.view.View r3 = r8.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            global.didi.pay.installment.-$$Lambda$InstallmentActivity$ib7LIIgYelZpzNwsQZj5S1ZC2X8 r5 = new global.didi.pay.installment.-$$Lambda$InstallmentActivity$ib7LIIgYelZpzNwsQZj5S1ZC2X8
            r5.<init>(r4)
            r3.setOnClickListener(r5)
        L_0x00b7:
            r3 = 2131434603(0x7f0b1c6b, float:1.8491025E38)
            android.view.View r3 = r8.findViewById(r3)
            java.lang.String r4 = "findViewById(R.id.title_installment)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r8.setMTvTitle(r3)
            android.view.View r9 = r8.findViewById(r9)
            java.lang.String r3 = "findViewById(R.id.btn_installment)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            android.widget.Button r9 = (android.widget.Button) r9
            r8.setMBtnConfirm(r9)
            r9 = 2131428328(0x7f0b03e8, float:1.8478297E38)
            android.view.View r9 = r8.findViewById(r9)
            java.lang.String r3 = "findViewById(R.id.container_title_installment)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            r8.setMContainerTitle(r9)
            r9 = 2131428320(0x7f0b03e0, float:1.8478281E38)
            android.view.View r9 = r8.findViewById(r9)
            java.lang.String r3 = "findViewById(R.id.container_body_installment)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            r8.setMContainerBody(r9)
            global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder$Companion r9 = global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder.Companion
            r3 = r8
            android.content.Context r3 = (android.content.Context) r3
            android.view.ViewGroup r4 = r8.getMContainerTitle()
            global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder r9 = r9.newIns(r3, r4)
            r8.setMHeaderTotalItem(r9)
            android.view.ViewGroup r9 = r8.getMContainerTitle()
            global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder r4 = r8.getMHeaderTotalItem()
            android.view.View r4 = r4.getRootView()
            r9.addView(r4)
            global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder r9 = r8.getMHeaderTotalItem()
            android.content.res.Resources r4 = r8.getResources()
            r5 = 2131952719(0x7f13044f, float:1.9541889E38)
            java.lang.String r4 = r4.getString(r5)
            java.lang.String r5 = "resources.getString(R.string.GRider_installment_Boleto_Amount_HOCc)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r9.setTitle(r4)
            r9 = 2131435129(0x7f0b1e79, float:1.8492091E38)
            android.view.View r9 = r8.findViewById(r9)
            java.lang.String r4 = "findViewById(R.id.tv_installment_item_bottom_tip)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r4)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r8.setMTvBottomTip(r9)
            global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder$Companion r9 = global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder.Companion
            android.view.ViewGroup r4 = r8.getMContainerTitle()
            global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder r9 = r9.newIns(r3, r4)
            r8.setMHeaderServiceItem(r9)
            android.view.ViewGroup r9 = r8.getMContainerTitle()
            global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder r4 = r8.getMHeaderServiceItem()
            android.view.View r4 = r4.getRootView()
            r9.addView(r4)
            global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder r9 = r8.getMHeaderServiceItem()
            android.content.res.Resources r4 = r8.getResources()
            r5 = 2131952729(0x7f130459, float:1.9541909E38)
            java.lang.String r4 = r4.getString(r5)
            java.lang.String r5 = "resources.getString(R.string.GRider_installment_actual_monthly_Ains)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r9.setTitle(r4)
            global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder r9 = r8.getMHeaderServiceItem()
            r9.setVisible(r2)
            global.didi.pay.installment.viewholder.InstallmentHeaderItemViewHolder r9 = r8.getMHeaderTotalItem()
            java.util.List r4 = r8.getInstallment()
            java.lang.Object r4 = kotlin.collections.CollectionsKt.firstOrNull(r4)
            com.didi.unifiedPay.sdk.model.InstallmentModel r4 = (com.didi.unifiedPay.sdk.model.InstallmentModel) r4
            if (r4 != 0) goto L_0x018a
            goto L_0x0192
        L_0x018a:
            java.lang.String r4 = r4.getEachAmount()
            if (r4 != 0) goto L_0x0191
            goto L_0x0192
        L_0x0191:
            r0 = r4
        L_0x0192:
            r9.setPrice(r0)
            android.widget.TextView r9 = r8.getMTvBottomTip()
            java.util.List r0 = r8.getInstallment()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.lastOrNull(r0)
            com.didi.unifiedPay.sdk.model.InstallmentModel r0 = (com.didi.unifiedPay.sdk.model.InstallmentModel) r0
            if (r0 != 0) goto L_0x01a6
            goto L_0x01aa
        L_0x01a6:
            java.lang.String r6 = r0.getInfo()
        L_0x01aa:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x01c0
            android.content.res.Resources r0 = r8.getResources()
            r4 = 2131952726(0x7f130456, float:1.9541903E38)
            java.lang.String r0 = r0.getString(r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x01cd
        L_0x01c0:
            android.content.res.Resources r0 = r8.getResources()
            r4 = 2131952720(0x7f130450, float:1.954189E38)
            java.lang.String r0 = r0.getString(r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x01cd:
            r9.setText(r0)
            java.util.List r9 = r8.getInstallment()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
            r0 = 0
        L_0x01db:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x0223
            java.lang.Object r4 = r9.next()
            int r5 = r0 + 1
            if (r0 >= 0) goto L_0x01ec
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x01ec:
            com.didi.unifiedPay.sdk.model.InstallmentModel r4 = (com.didi.unifiedPay.sdk.model.InstallmentModel) r4
            global.didi.pay.installment.viewholder.InstallmentListItemViewHolder$Companion r6 = global.didi.pay.installment.viewholder.InstallmentListItemViewHolder.Companion
            android.view.ViewGroup r7 = r8.getMContainerBody()
            global.didi.pay.installment.viewholder.InstallmentListItemViewHolder r6 = r6.newIns(r3, r7)
            int r7 = r8.getSelectIndex()
            if (r0 != r7) goto L_0x0200
            r7 = 1
            goto L_0x0201
        L_0x0200:
            r7 = 0
        L_0x0201:
            r6.bind(r4, r7)
            global.didi.pay.installment.-$$Lambda$InstallmentActivity$QgE8Lz1RODmxDc50DQ051wIKT1k r4 = new global.didi.pay.installment.-$$Lambda$InstallmentActivity$QgE8Lz1RODmxDc50DQ051wIKT1k
            r4.<init>(r0, r8)
            r6.click(r4)
            r8.refreshHeaderItem()
            java.util.List r0 = r8.getMListItem()
            r0.add(r6)
            android.view.ViewGroup r0 = r8.getMContainerBody()
            android.view.View r4 = r6.getRootView()
            r0.addView(r4)
            r0 = r5
            goto L_0x01db
        L_0x0223:
            return
        L_0x0224:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type com.didi.unifiedPay.component.model.PayParam"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.installment.InstallmentActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m47648onCreate$lambda1(InstallmentActivity installmentActivity, View view) {
        Intrinsics.checkNotNullParameter(installmentActivity, "this$0");
        if (installmentActivity.getInstallment().size() > installmentActivity.getSelectIndex()) {
            Intent intent = new Intent();
            intent.putExtra(INSTALLMENT_NUMBER, installmentActivity.getInstallment().get(installmentActivity.getSelectIndex()).getNumber());
            Unit unit = Unit.INSTANCE;
            installmentActivity.setResult(-1, intent);
        } else {
            installmentActivity.setResult(0);
        }
        installmentActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m47649onCreate$lambda2(InstallmentActivity installmentActivity, View view) {
        Intrinsics.checkNotNullParameter(installmentActivity, "this$0");
        installmentActivity.setResult(0);
        installmentActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4$lambda-3  reason: not valid java name */
    public static final void m47650onCreate$lambda4$lambda3(InstallmentActivity installmentActivity, String str, View view) {
        String str2;
        Intrinsics.checkNotNullParameter(installmentActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "$url");
        OmegaSDKAdapter.trackEvent("ibt_didipay_installment_cashback_sw", (String) null, (Map<String, Object>) null);
        UniPayWebModel uniPayWebModel = new UniPayWebModel();
        uniPayWebModel.context = installmentActivity;
        uniPayWebModel.url = str;
        PayParam payParam = installmentActivity.mPayParam;
        String str3 = "";
        if (!(payParam == null || (str2 = payParam.sid) == null)) {
            str3 = str2;
        }
        uniPayWebModel.sid = str3;
        uniPayWebModel.intentFlag = View.STATUS_BAR_TRANSIENT;
        uniPayWebModel.requestCode = -1;
        UniPayWebUtil.startWebPage(uniPayWebModel, installmentActivity);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-7$lambda-6$lambda-5  reason: not valid java name */
    public static final void m47651onCreate$lambda7$lambda6$lambda5(int i, InstallmentActivity installmentActivity, View view) {
        Intrinsics.checkNotNullParameter(installmentActivity, "this$0");
        if (i != installmentActivity.getSelectIndex()) {
            installmentActivity.getMListItem().get(installmentActivity.getSelectIndex()).selected(false);
            installmentActivity.setSelectIndex(i);
            installmentActivity.getMListItem().get(installmentActivity.getSelectIndex()).selected(true);
            installmentActivity.refreshHeaderItem();
        }
    }

    private final void refreshHeaderItem() {
        getMHeaderServiceItem().setVisible(this.selectIndex != 0);
        InstallmentHeaderItemViewHolder mHeaderServiceItem2 = getMHeaderServiceItem();
        String serviceCharge = getInstallment().get(this.selectIndex).getServiceCharge();
        if (serviceCharge == null) {
            serviceCharge = "";
        }
        mHeaderServiceItem2.setPrice(serviceCharge);
    }

    public void callStartActivityForResult(Intent intent, int i) {
        Intrinsics.checkNotNull(intent);
        intent.setPackage(DeviceUtil.getPackageName(this));
        startActivityForResult(intent, i);
    }
}
