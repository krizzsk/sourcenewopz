package com.didi.payment.commonsdk.p129ui.helper;

import android.content.Context;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOImgModel;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.sdk.util.TextUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010A\u001a\u00020\u00002\b\b\u0002\u0010B\u001a\u00020\u0006J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0012J\u0016\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u001bJ\u000e\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\fJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\fJ\u0016\u0010J\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u0012J\u000e\u00108\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u001bJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0012J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0006J\u0006\u0010N\u001a\u00020,J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u001bJ\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u001bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR\u001a\u0010)\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000e\"\u0004\b*\u0010\u0010R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u0010\u0004R\u001c\u00105\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u0016R\u001c\u00108\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010\u001fR\u001c\u0010;\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001d\"\u0004\b=\u0010\u001fR\u001c\u0010>\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001d\"\u0004\b@\u0010\u001f¨\u0006O"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/ui/helper/NLEGODialogBuilder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "btnOrientation", "", "getBtnOrientation", "()I", "setBtnOrientation", "(I)V", "clickOutsideCanCancel", "", "getClickOutsideCanCancel", "()Z", "setClickOutsideCanCancel", "(Z)V", "closeBtnClickListener", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "getCloseBtnClickListener", "()Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "setCloseBtnClickListener", "(Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;)V", "confirmBtnClickListener", "getConfirmBtnClickListener", "setConfirmBtnClickListener", "confirmBtnText", "", "getConfirmBtnText", "()Ljava/lang/String;", "setConfirmBtnText", "(Ljava/lang/String;)V", "drawerModel", "Lcom/didi/global/globaluikit/drawer/templatemodel/LEGOBaseDrawerModel;", "getDrawerModel", "()Lcom/didi/global/globaluikit/drawer/templatemodel/LEGOBaseDrawerModel;", "setDrawerModel", "(Lcom/didi/global/globaluikit/drawer/templatemodel/LEGOBaseDrawerModel;)V", "imageID", "getImageID", "setImageID", "isShowCloseImage", "setShowCloseImage", "legoDrawer", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "getLegoDrawer", "()Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "setLegoDrawer", "(Lcom/didi/global/globaluikit/drawer/LEGODrawer;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "negativeBtnClickListener", "getNegativeBtnClickListener", "setNegativeBtnClickListener", "negativeBtnText", "getNegativeBtnText", "setNegativeBtnText", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "build", "dialogType", "closeAction", "listener", "confirmAction", "btnText", "isClickOutsideCanCancel", "canCancel", "isShow", "negativeAction", "negetiveBtnClickListener", "setImageResource", "image", "show", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.commonsdk.ui.helper.NLEGODialogBuilder */
/* compiled from: NLEGODialogBuilder.kt */
public final class NLEGODialogBuilder {

    /* renamed from: a */
    private Context f30183a;

    /* renamed from: b */
    private LEGODrawer f30184b;

    /* renamed from: c */
    private String f30185c;

    /* renamed from: d */
    private String f30186d;
    public LEGOBaseDrawerModel drawerModel;

    /* renamed from: e */
    private String f30187e = "";

    /* renamed from: f */
    private DoubleCheckOnClickListener f30188f;

    /* renamed from: g */
    private String f30189g = "";

    /* renamed from: h */
    private DoubleCheckOnClickListener f30190h;

    /* renamed from: i */
    private DoubleCheckOnClickListener f30191i;

    /* renamed from: j */
    private int f30192j = 1;

    /* renamed from: k */
    private boolean f30193k;

    /* renamed from: l */
    private int f30194l;

    /* renamed from: m */
    private boolean f30195m = true;

    public NLEGODialogBuilder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f30183a = context;
    }

    public final Context getMContext() {
        return this.f30183a;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.f30183a = context;
    }

    public final LEGODrawer getLegoDrawer() {
        return this.f30184b;
    }

    public final void setLegoDrawer(LEGODrawer lEGODrawer) {
        this.f30184b = lEGODrawer;
    }

    public final String getTitle() {
        return this.f30185c;
    }

    public final void setTitle(String str) {
        this.f30185c = str;
    }

    public final String getSubTitle() {
        return this.f30186d;
    }

    public final void setSubTitle(String str) {
        this.f30186d = str;
    }

    public final String getConfirmBtnText() {
        return this.f30187e;
    }

    public final void setConfirmBtnText(String str) {
        this.f30187e = str;
    }

    public final DoubleCheckOnClickListener getConfirmBtnClickListener() {
        return this.f30188f;
    }

    public final void setConfirmBtnClickListener(DoubleCheckOnClickListener doubleCheckOnClickListener) {
        this.f30188f = doubleCheckOnClickListener;
    }

    public final String getNegativeBtnText() {
        return this.f30189g;
    }

    public final void setNegativeBtnText(String str) {
        this.f30189g = str;
    }

    public final DoubleCheckOnClickListener getNegativeBtnClickListener() {
        return this.f30190h;
    }

    public final void setNegativeBtnClickListener(DoubleCheckOnClickListener doubleCheckOnClickListener) {
        this.f30190h = doubleCheckOnClickListener;
    }

    public final DoubleCheckOnClickListener getCloseBtnClickListener() {
        return this.f30191i;
    }

    public final void setCloseBtnClickListener(DoubleCheckOnClickListener doubleCheckOnClickListener) {
        this.f30191i = doubleCheckOnClickListener;
    }

    public final int getBtnOrientation() {
        return this.f30192j;
    }

    public final void setBtnOrientation(int i) {
        this.f30192j = i;
    }

    public final boolean isShowCloseImage() {
        return this.f30193k;
    }

    public final void setShowCloseImage(boolean z) {
        this.f30193k = z;
    }

    public final int getImageID() {
        return this.f30194l;
    }

    public final void setImageID(int i) {
        this.f30194l = i;
    }

    public final boolean getClickOutsideCanCancel() {
        return this.f30195m;
    }

    public final void setClickOutsideCanCancel(boolean z) {
        this.f30195m = z;
    }

    public final NLEGODialogBuilder title(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f30185c = str;
        return this;
    }

    public final NLEGODialogBuilder subTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f30186d = str;
        return this;
    }

    public final NLEGODialogBuilder confirmAction(String str, DoubleCheckOnClickListener doubleCheckOnClickListener) {
        Intrinsics.checkNotNullParameter(str, "btnText");
        Intrinsics.checkNotNullParameter(doubleCheckOnClickListener, "listener");
        this.f30187e = str;
        this.f30188f = doubleCheckOnClickListener;
        return this;
    }

    public final NLEGODialogBuilder confirmBtnText(String str) {
        Intrinsics.checkNotNullParameter(str, "btnText");
        this.f30187e = str;
        return this;
    }

    public final NLEGODialogBuilder confirmBtnClickListener(DoubleCheckOnClickListener doubleCheckOnClickListener) {
        Intrinsics.checkNotNullParameter(doubleCheckOnClickListener, "listener");
        this.f30188f = doubleCheckOnClickListener;
        return this;
    }

    public final NLEGODialogBuilder negativeAction(String str, DoubleCheckOnClickListener doubleCheckOnClickListener) {
        Intrinsics.checkNotNullParameter(str, "btnText");
        Intrinsics.checkNotNullParameter(doubleCheckOnClickListener, "listener");
        this.f30189g = str;
        this.f30190h = doubleCheckOnClickListener;
        return this;
    }

    public final NLEGODialogBuilder closeAction(DoubleCheckOnClickListener doubleCheckOnClickListener) {
        Intrinsics.checkNotNullParameter(doubleCheckOnClickListener, "listener");
        this.f30191i = doubleCheckOnClickListener;
        return this;
    }

    public final NLEGODialogBuilder negativeBtnText(String str) {
        Intrinsics.checkNotNullParameter(str, "btnText");
        this.f30189g = str;
        return this;
    }

    public final NLEGODialogBuilder negetiveBtnClickListener(DoubleCheckOnClickListener doubleCheckOnClickListener) {
        Intrinsics.checkNotNullParameter(doubleCheckOnClickListener, "listener");
        this.f30190h = doubleCheckOnClickListener;
        return this;
    }

    public final NLEGODialogBuilder isShowCloseImage(boolean z) {
        this.f30193k = z;
        return this;
    }

    public final NLEGODialogBuilder setImageResource(int i) {
        this.f30194l = i;
        return this;
    }

    public final NLEGODialogBuilder isClickOutsideCanCancel(boolean z) {
        this.f30195m = z;
        return this;
    }

    public final LEGOBaseDrawerModel getDrawerModel() {
        LEGOBaseDrawerModel lEGOBaseDrawerModel = this.drawerModel;
        if (lEGOBaseDrawerModel != null) {
            return lEGOBaseDrawerModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("drawerModel");
        return null;
    }

    public final void setDrawerModel(LEGOBaseDrawerModel lEGOBaseDrawerModel) {
        Intrinsics.checkNotNullParameter(lEGOBaseDrawerModel, "<set-?>");
        this.drawerModel = lEGOBaseDrawerModel;
    }

    public static /* synthetic */ NLEGODialogBuilder build$default(NLEGODialogBuilder nLEGODialogBuilder, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return nLEGODialogBuilder.build(i);
    }

    public final NLEGODialogBuilder build(int i) {
        if (i == 1) {
            String str = this.f30185c;
            Intrinsics.checkNotNull(str);
            setDrawerModel(new NLEGODialogBuilder$build$1(this, str, new LEGOBtnTextAndCallback(this.f30187e, new NLEGODialogBuilder$build$2(this))));
        } else {
            String str2 = this.f30185c;
            Intrinsics.checkNotNull(str2);
            setDrawerModel(new LEGODrawerModel1(str2, new LEGOBtnTextAndCallback(this.f30187e, new NLEGODialogBuilder$build$3(this))));
        }
        if (!TextUtil.isEmpty(this.f30186d)) {
            getDrawerModel().setSubTitle(this.f30186d);
        }
        if (!TextUtil.isEmpty(this.f30189g)) {
            getDrawerModel().addMinorBtn(new LEGOBtnTextAndCallback(this.f30189g, new NLEGODialogBuilder$build$4(this)));
        }
        if (this.f30194l > 0) {
            getDrawerModel().setImgModel(new LEGOImgModel().setImgResId(this.f30194l));
        }
        getDrawerModel().setClickOutsideCanCancel(this.f30195m);
        if (this.f30193k) {
            getDrawerModel().setIsShowCloseImg(this.f30193k);
            getDrawerModel().setShowCloseImgListener(new NLEGODialogBuilder$build$5(this));
        }
        setDrawerModel(getDrawerModel());
        return this;
    }

    public final LEGODrawer show() {
        LEGODrawer showDrawerTemplate = LEGOUICreator.showDrawerTemplate(getMContext(), getDrawerModel());
        setLegoDrawer(showDrawerTemplate);
        Intrinsics.checkNotNullExpressionValue(showDrawerTemplate, "innerDrawer");
        return showDrawerTemplate;
    }
}
