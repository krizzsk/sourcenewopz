package com.didi.entrega.customer.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.foundation.storage.AppConfigStorage;
import com.didi.entrega.customer.foundation.storage.model.AppConfig;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.SingletonFactory;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.entrega.customer.widget.loading.SodaLoadingView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001KB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\n\u00100\u001a\u0004\u0018\u00010/H\u0016J\b\u00101\u001a\u000202H\u0002J\u000e\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u000205J\u0018\u00106\u001a\u00020\u001a2\u0006\u00104\u001a\u0002052\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u000202H\u0016J\b\u0010:\u001a\u000202H\u0016J\b\u0010;\u001a\u000202H\u0016J\u0010\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020>H\u0002J\u0018\u0010A\u001a\u0002022\b\u0010B\u001a\u0004\u0018\u00010\n2\u0006\u0010C\u001a\u00020>J\u0012\u0010D\u001a\u0002022\b\u0010B\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010E\u001a\u0002022\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020\nH\u0002J\u0010\u0010G\u001a\u0002022\u0006\u0010@\u001a\u00020>H\u0002J\u0010\u0010H\u001a\u0002022\u0006\u0010@\u001a\u00020>H\u0002J\b\u0010I\u001a\u000202H\u0002J\u0012\u0010J\u001a\u0002022\b\u0010)\u001a\u0004\u0018\u00010\nH\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#8B@BX\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R(\u0010*\u001a\u0004\u0018\u00010\n2\b\u0010)\u001a\u0004\u0018\u00010\n8B@BX\u000e¢\u0006\f\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010-¨\u0006L"}, mo175978d2 = {"Lcom/didi/entrega/customer/widget/dialog/CustomerNumProtectDialog;", "Lcom/didi/app/nova/skeleton/dialog/Dialog;", "context", "Landroid/content/Context;", "numProtectModel", "Lcom/didi/entrega/customer/widget/dialog/NumProtectModel;", "onNumProtectCallListener", "Lcom/didi/entrega/customer/widget/dialog/CustomerNumProtectDialog$OnNumProtectCallListener;", "(Landroid/content/Context;Lcom/didi/entrega/customer/widget/dialog/NumProtectModel;Lcom/didi/entrega/customer/widget/dialog/CustomerNumProtectDialog$OnNumProtectCallListener;)V", "callingCode", "", "getCallingCode", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "mAction1", "Landroid/widget/TextView;", "mAction2", "mActionLoading", "Lcom/didi/entrega/customer/widget/loading/SodaLoadingView;", "mActionParent", "Landroid/widget/LinearLayout;", "mContent", "mDelete", "Landroid/widget/ImageView;", "mDivider1", "Landroid/view/View;", "mDivider2", "mEditParent", "mLoading", "mPhoneNum", "Landroid/widget/EditText;", "mRoot", "mTvCode", "shown", "", "numPhoneDialogShown", "getNumPhoneDialogShown", "()Z", "setNumPhoneDialogShown", "(Z)V", "phone", "phoneNum", "getPhoneNum", "setPhoneNum", "(Ljava/lang/String;)V", "getEnterAnimation", "Lcom/didi/app/nova/skeleton/dialog/TransformAnimation;", "getExitAnimation", "init", "", "initRootView", "inflater", "Landroid/view/LayoutInflater;", "onCreate", "parent", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "onShow", "setAction2Text", "contentId", "", "setActionLoadingVisibility", "visibility", "setCallingCode", "calling", "country", "setCallingCodeText", "setContent", "content", "setLoadingVisibility", "setPhoneEditVisibility", "setPhoneInfo", "setPhoneNumText", "OnNumProtectCallListener", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerNumProtectDialog.kt */
public final class CustomerNumProtectDialog extends Dialog {

    /* renamed from: a */
    private final Context f20418a;

    /* renamed from: b */
    private final NumProtectModel f20419b;

    /* renamed from: c */
    private final OnNumProtectCallListener f20420c;

    /* renamed from: d */
    private View f20421d;

    /* renamed from: e */
    private ImageView f20422e;

    /* renamed from: f */
    private SodaLoadingView f20423f;

    /* renamed from: g */
    private TextView f20424g;

    /* renamed from: h */
    private LinearLayout f20425h;

    /* renamed from: i */
    private TextView f20426i;

    /* renamed from: j */
    private EditText f20427j;

    /* renamed from: k */
    private View f20428k;

    /* renamed from: l */
    private View f20429l;

    /* renamed from: m */
    private LinearLayout f20430m;

    /* renamed from: n */
    private TextView f20431n;

    /* renamed from: o */
    private TextView f20432o;

    /* renamed from: p */
    private SodaLoadingView f20433p;

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/entrega/customer/widget/dialog/CustomerNumProtectDialog$OnNumProtectCallListener;", "", "confirm", "", "dialog", "Lcom/didi/app/nova/skeleton/dialog/Dialog;", "phone", "", "callingCode", "onCancel", "Lcom/didi/entrega/customer/widget/dialog/CustomerNumProtectDialog;", "onChooseCountryList", "countryId", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerNumProtectDialog.kt */
    public interface OnNumProtectCallListener {
        void confirm(Dialog dialog, String str, String str2);

        void onCancel(CustomerNumProtectDialog customerNumProtectDialog);

        void onChooseCountryList(CustomerNumProtectDialog customerNumProtectDialog, int i);
    }

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    public void onDestroy() {
    }

    public final Context getContext() {
        return this.f20418a;
    }

    public CustomerNumProtectDialog(Context context, NumProtectModel numProtectModel, OnNumProtectCallListener onNumProtectCallListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(numProtectModel, "numProtectModel");
        this.f20418a = context;
        this.f20419b = numProtectModel;
        this.f20420c = onNumProtectCallListener;
    }

    /* renamed from: e */
    private final String m14962e() {
        EditText editText = this.f20427j;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
            editText = null;
        }
        return editText.getText().toString();
    }

    /* renamed from: a */
    private final void m14951a(String str) {
        this.f20419b.setPhoneNum(str);
        m14958c(m14962e());
    }

    /* renamed from: f */
    private final String m14964f() {
        return this.f20419b.getCallingCode();
    }

    /* renamed from: g */
    private final boolean m14965g() {
        return ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mNumProtectShown;
    }

    /* renamed from: a */
    private final void m14952a(boolean z) {
        AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
        AppConfig data = appConfigStorage.getData();
        data.mNumProtectShown = z;
        appConfigStorage.setData(data);
    }

    public final void setCallingCode(String str, int i) {
        this.f20419b.setCallingCode(str);
        this.f20419b.setCountryId(i);
        m14966h();
    }

    public final View initRootView(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_dialog_num_protect, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…dialog_num_protect, null)");
        this.f20421d = inflate;
        m14967i();
        View view = this.f20421d;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        return null;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_dialog_num_protect, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…m_protect, parent, false)");
        this.f20421d = inflate;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = DisplayUtils.dip2px(this.f20418a, 50.0f);
        layoutParams.rightMargin = DisplayUtils.dip2px(this.f20418a, 50.0f);
        layoutParams.gravity = 17;
        View view = this.f20421d;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view = null;
        }
        view.setLayoutParams(layoutParams);
        m14967i();
        View view2 = this.f20421d;
        if (view2 != null) {
            return view2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        return null;
    }

    public void onDismiss() {
        Context context = this.f20418a;
        EditText editText = this.f20427j;
        SodaLoadingView sodaLoadingView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
            editText = null;
        }
        KeyboardUtils.hideSoftInput(context, editText);
        SodaLoadingView sodaLoadingView2 = this.f20433p;
        if (sodaLoadingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionLoading");
            sodaLoadingView2 = null;
        }
        sodaLoadingView2.stop();
        SodaLoadingView sodaLoadingView3 = this.f20423f;
        if (sodaLoadingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoading");
        } else {
            sodaLoadingView = sodaLoadingView3;
        }
        sodaLoadingView.stop();
    }

    public void onShow() {
        m14966h();
        if (!m14965g()) {
            m14959d((int) R.string.FoodC_phonesafe_Encryption_protection_VWUW);
            m14948a(8);
            m14963e(R.string.FoodC_up_Confirmation_hKaf);
        } else {
            m14959d((int) R.string.FoodC_phonesafe_Encrypted_by_BZSj);
            m14948a(0);
            m14963e(R.string.FoodC_phonesafe_Call_ivWZ);
        }
        m14953b(4);
    }

    /* renamed from: a */
    private final void m14948a(int i) {
        LinearLayout linearLayout = this.f20425h;
        View view = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditParent");
            linearLayout = null;
        }
        linearLayout.setVisibility(i);
        View view2 = this.f20428k;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDivider1");
        } else {
            view = view2;
        }
        view.setVisibility(i);
    }

    /* renamed from: b */
    private final void m14953b(int i) {
        SodaLoadingView sodaLoadingView = this.f20423f;
        SodaLoadingView sodaLoadingView2 = null;
        if (sodaLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoading");
            sodaLoadingView = null;
        }
        sodaLoadingView.setVisibility(i);
        if (i == 4 || i == 8) {
            TextView textView = this.f20424g;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContent");
                textView = null;
            }
            textView.setVisibility(0);
            LinearLayout linearLayout = this.f20430m;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionParent");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
            View view = this.f20429l;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDivider2");
                view = null;
            }
            view.setVisibility(0);
            SodaLoadingView sodaLoadingView3 = this.f20423f;
            if (sodaLoadingView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoading");
            } else {
                sodaLoadingView2 = sodaLoadingView3;
            }
            sodaLoadingView2.stop();
            return;
        }
        TextView textView2 = this.f20424g;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
            textView2 = null;
        }
        textView2.setVisibility(8);
        LinearLayout linearLayout2 = this.f20430m;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionParent");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(8);
        View view2 = this.f20429l;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDivider2");
            view2 = null;
        }
        view2.setVisibility(8);
        LinearLayout linearLayout3 = this.f20425h;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditParent");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(8);
        View view3 = this.f20428k;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDivider1");
            view3 = null;
        }
        view3.setVisibility(8);
        SodaLoadingView sodaLoadingView4 = this.f20423f;
        if (sodaLoadingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoading");
        } else {
            sodaLoadingView2 = sodaLoadingView4;
        }
        sodaLoadingView2.start();
    }

    /* renamed from: c */
    private final void m14956c(int i) {
        SodaLoadingView sodaLoadingView = null;
        if (i == 4 || i == 8) {
            SodaLoadingView sodaLoadingView2 = this.f20433p;
            if (sodaLoadingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionLoading");
                sodaLoadingView2 = null;
            }
            sodaLoadingView2.stop();
            LinearLayout linearLayout = this.f20430m;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionParent");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
        } else {
            LinearLayout linearLayout2 = this.f20430m;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionParent");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
            SodaLoadingView sodaLoadingView3 = this.f20433p;
            if (sodaLoadingView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionLoading");
                sodaLoadingView3 = null;
            }
            if (!sodaLoadingView3.isRunning()) {
                SodaLoadingView sodaLoadingView4 = this.f20433p;
                if (sodaLoadingView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mActionLoading");
                    sodaLoadingView4 = null;
                }
                sodaLoadingView4.start();
            }
        }
        SodaLoadingView sodaLoadingView5 = this.f20433p;
        if (sodaLoadingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionLoading");
        } else {
            sodaLoadingView = sodaLoadingView5;
        }
        sodaLoadingView.setVisibility(i);
    }

    /* renamed from: b */
    private final void m14955b(String str) {
        TextView textView = this.f20424g;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
            textView = null;
        }
        textView.setText(str);
    }

    /* renamed from: d */
    private final void m14959d(int i) {
        TextView textView = this.f20424g;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
            textView = null;
        }
        textView.setText(ResourceHelper.getString(i));
    }

    /* renamed from: e */
    private final void m14963e(int i) {
        TextView textView = this.f20432o;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAction2");
            textView = null;
        }
        textView.setText(ResourceHelper.getString(i));
    }

    /* renamed from: c */
    private final void m14958c(String str) {
        EditText editText = this.f20427j;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
            editText = null;
        }
        editText.setText(str);
    }

    /* renamed from: d */
    private final void m14961d(String str) {
        TextView textView = this.f20426i;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvCode");
            textView = null;
        }
        textView.setText(str);
    }

    /* renamed from: h */
    private final void m14966h() {
        m14958c(this.f20419b.getPhoneNum());
        m14961d(this.f20419b.getCallingCode());
    }

    /* renamed from: i */
    private final void m14967i() {
        View view = this.f20421d;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view = null;
        }
        View findViewById = view.findViewById(R.id.customer_custom_loading_dot_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRoot.findViewById(R.id.…_custom_loading_dot_view)");
        this.f20423f = (SodaLoadingView) findViewById;
        View view2 = this.f20421d;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.customer_tv_dialog_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRoot.findViewById(R.id.…stomer_tv_dialog_content)");
        this.f20424g = (TextView) findViewById2;
        View view3 = this.f20421d;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.customer_ll_dialog_edit);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRoot.findViewById(R.id.customer_ll_dialog_edit)");
        this.f20425h = (LinearLayout) findViewById3;
        View view4 = this.f20421d;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.customer_tv_calling_code);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRoot.findViewById(R.id.customer_tv_calling_code)");
        this.f20426i = (TextView) findViewById4;
        View view5 = this.f20421d;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.customer_et_phone_num);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRoot.findViewById(R.id.customer_et_phone_num)");
        this.f20427j = (EditText) findViewById5;
        View view6 = this.f20421d;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view6 = null;
        }
        View findViewById6 = view6.findViewById(R.id.customer_iv_num_protect_dialog_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRoot.findViewById(R.id.…um_protect_dialog_delete)");
        this.f20422e = (ImageView) findViewById6;
        View view7 = this.f20421d;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view7 = null;
        }
        View findViewById7 = view7.findViewById(R.id.customer_view_dialog_divider1);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRoot.findViewById(R.id.…mer_view_dialog_divider1)");
        this.f20428k = findViewById7;
        View view8 = this.f20421d;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view8 = null;
        }
        View findViewById8 = view8.findViewById(R.id.customer_view_dialog_divider2);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRoot.findViewById(R.id.…mer_view_dialog_divider2)");
        this.f20429l = findViewById8;
        View view9 = this.f20421d;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view9 = null;
        }
        View findViewById9 = view9.findViewById(R.id.customer_ll_num_protect_dialog_action);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRoot.findViewById(R.id.…um_protect_dialog_action)");
        this.f20430m = (LinearLayout) findViewById9;
        View view10 = this.f20421d;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view10 = null;
        }
        View findViewById10 = view10.findViewById(R.id.customer_tv_common_dialog_sub_action1);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRoot.findViewById(R.id.…ommon_dialog_sub_action1)");
        this.f20431n = (TextView) findViewById10;
        View view11 = this.f20421d;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view11 = null;
        }
        View findViewById11 = view11.findViewById(R.id.customer_tv_common_dialog_sub_action2);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRoot.findViewById(R.id.…ommon_dialog_sub_action2)");
        this.f20432o = (TextView) findViewById11;
        View view12 = this.f20421d;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view12 = null;
        }
        View findViewById12 = view12.findViewById(R.id.customer_custom_action_loading_dot_view);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRoot.findViewById(R.id.…_action_loading_dot_view)");
        this.f20433p = (SodaLoadingView) findViewById12;
        ImageView imageView = this.f20422e;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDelete");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerNumProtectDialog.m14950a(CustomerNumProtectDialog.this, view);
            }
        });
        TextView textView2 = this.f20431n;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAction1");
            textView2 = null;
        }
        textView2.setText(ResourceHelper.getString(R.string.FoodC_up_Cancel_anHR));
        TextView textView3 = this.f20432o;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAction2");
            textView3 = null;
        }
        textView3.setText(ResourceHelper.getString(R.string.FoodC_up_Confirmation_hKaf));
        TextView textView4 = this.f20431n;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAction1");
            textView4 = null;
        }
        textView4.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerNumProtectDialog.m14954b(CustomerNumProtectDialog.this, view);
            }
        });
        TextView textView5 = this.f20432o;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAction2");
            textView5 = null;
        }
        textView5.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerNumProtectDialog.m14957c(CustomerNumProtectDialog.this, view);
            }
        });
        TextView textView6 = this.f20426i;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvCode");
        } else {
            textView = textView6;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerNumProtectDialog.m14960d(CustomerNumProtectDialog.this, view);
            }
        });
        setCancelable(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14950a(CustomerNumProtectDialog customerNumProtectDialog, View view) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "this$0");
        EditText editText = customerNumProtectDialog.f20427j;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
            editText = null;
        }
        editText.setText((CharSequence) null);
        customerNumProtectDialog.f20419b.setPhoneNum((String) null);
        Context context = customerNumProtectDialog.getContext();
        EditText editText3 = customerNumProtectDialog.f20427j;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
        } else {
            editText2 = editText3;
        }
        KeyboardUtils.showSoftInput(context, editText2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m14954b(CustomerNumProtectDialog customerNumProtectDialog, View view) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "this$0");
        OnNumProtectCallListener onNumProtectCallListener = customerNumProtectDialog.f20420c;
        if (onNumProtectCallListener != null) {
            onNumProtectCallListener.onCancel(customerNumProtectDialog);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m14957c(CustomerNumProtectDialog customerNumProtectDialog, View view) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "this$0");
        boolean z = true;
        if (!customerNumProtectDialog.m14965g()) {
            customerNumProtectDialog.m14953b(0);
            UiHandlerUtil.postDelayed(new Runnable() {
                public final void run() {
                    CustomerNumProtectDialog.m14949a(CustomerNumProtectDialog.this);
                }
            }, 2000);
            customerNumProtectDialog.m14952a(true);
        } else if (customerNumProtectDialog.f20420c != null) {
            customerNumProtectDialog.f20419b.setPhoneNum(customerNumProtectDialog.m14962e());
            CharSequence e = customerNumProtectDialog.m14962e();
            if (!(e == null || e.length() == 0)) {
                z = false;
            }
            if (!z) {
                customerNumProtectDialog.m14956c(0);
                customerNumProtectDialog.f20420c.confirm(customerNumProtectDialog, customerNumProtectDialog.m14962e(), customerNumProtectDialog.m14964f());
            } else {
                customerNumProtectDialog.f20420c.onCancel(customerNumProtectDialog);
            }
            Context context = customerNumProtectDialog.getContext();
            EditText editText = customerNumProtectDialog.f20427j;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPhoneNum");
                editText = null;
            }
            KeyboardUtils.hideSoftInput(context, editText);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14949a(CustomerNumProtectDialog customerNumProtectDialog) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "this$0");
        customerNumProtectDialog.onShow();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m14960d(CustomerNumProtectDialog customerNumProtectDialog, View view) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "this$0");
        OnNumProtectCallListener onNumProtectCallListener = customerNumProtectDialog.f20420c;
        if (onNumProtectCallListener != null) {
            onNumProtectCallListener.onChooseCountryList(customerNumProtectDialog, customerNumProtectDialog.f20419b.getCountryId());
        }
    }
}
