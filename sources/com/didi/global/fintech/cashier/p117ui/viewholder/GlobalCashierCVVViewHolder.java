package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCVVViewHolder;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0016J\u001c\u0010/\u001a\u00020,2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020,01H\u0016J&\u00102\u001a\u00020,2\b\u00103\u001a\u0004\u0018\u00010*2\b\u00104\u001a\u0004\u0018\u00010*2\b\u0010\u0017\u001a\u0004\u0018\u00010*H\u0016J \u00105\u001a\u00020,2\b\u0010\u0014\u001a\u0004\u0018\u00010*2\f\u00106\u001a\b\u0012\u0004\u0012\u00020,07H\u0016J\u0012\u00108\u001a\u00020,2\b\u0010&\u001a\u0004\u0018\u00010*H\u0016J\u0012\u00109\u001a\u00020,2\b\u0010&\u001a\u0004\u0018\u00010*H\u0016R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR\u001a\u0010&\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010\r¨\u0006;"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCVVViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "cardSuffix", "Landroid/widget/TextView;", "getCardSuffix", "()Landroid/widget/TextView;", "setCardSuffix", "(Landroid/widget/TextView;)V", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "entrance", "getEntrance", "setEntrance", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "input", "Landroid/widget/EditText;", "getInput", "()Landroid/widget/EditText;", "setInput", "(Landroid/widget/EditText;)V", "subtitle", "getSubtitle", "setSubtitle", "title", "getTitle", "setTitle", "getCvvContent", "", "initView", "", "layout", "", "registerTextChangeListener", "listener", "Lkotlin/Function1;", "updateCardInfo", "prefix", "suffix", "updateDrawerEntrance", "click", "Lkotlin/Function0;", "updateSubTile", "updateTile", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierCVVViewHolder */
/* compiled from: GlobalCashierCVVViewHolder.kt */
public final class GlobalCashierCVVViewHolder extends GlobalCashierBaseViewHolder implements IGlobalCashierCVVViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public TextView cardSuffix;
    public View container;
    public TextView entrance;
    public ImageView icon;
    public EditText input;
    public TextView subtitle;
    public TextView title;

    public int layout() {
        return R.layout.viewholder_global_cashier_cvv;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierCVVViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCVVViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCVVViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierCVVViewHolder$Companion */
    /* compiled from: GlobalCashierCVVViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierCVVViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierCVVViewHolder(context, viewGroup);
        }
    }

    public final TextView getTitle() {
        TextView textView = this.title;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("title");
        return null;
    }

    public final void setTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.title = textView;
    }

    public final TextView getSubtitle() {
        TextView textView = this.subtitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subtitle");
        return null;
    }

    public final void setSubtitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.subtitle = textView;
    }

    public final View getContainer() {
        View view = this.container;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("container");
        return null;
    }

    public final void setContainer(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.container = view;
    }

    public final ImageView getIcon() {
        ImageView imageView = this.icon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("icon");
        return null;
    }

    public final void setIcon(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.icon = imageView;
    }

    public final TextView getCardSuffix() {
        TextView textView = this.cardSuffix;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cardSuffix");
        return null;
    }

    public final void setCardSuffix(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.cardSuffix = textView;
    }

    public final EditText getInput() {
        EditText editText = this.input;
        if (editText != null) {
            return editText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("input");
        return null;
    }

    public final void setInput(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<set-?>");
        this.input = editText;
    }

    public final TextView getEntrance() {
        TextView textView = this.entrance;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("entrance");
        return null;
    }

    public final void setEntrance(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.entrance = textView;
    }

    public void initView() {
        super.initView();
        setTitle((TextView) getView(R.id.tv_title));
        setSubtitle((TextView) getView(R.id.tv_sub_title));
        setContainer(getView(R.id.rl_card_info));
        setIcon((ImageView) getView(R.id.iv_cvv_card));
        setCardSuffix((TextView) getView(R.id.tv_cvv_card));
        setInput((EditText) getView(R.id.et_cvv_card));
        setEntrance((TextView) getView(R.id.tv_entrance));
    }

    public void registerTextChangeListener(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "listener");
        getInput().addTextChangedListener(new GlobalCashierCVVViewHolder$registerTextChangeListener$1(function1));
    }

    public void updateTile(String str) {
        ViewKtxKt.content(getTitle(), str);
    }

    public void updateSubTile(String str) {
        ViewKtxKt.content(getSubtitle(), str);
    }

    public void updateCardInfo(String str, String str2, String str3) {
        getContainer().setVisibility(0);
        ViewKtxKt.load(getIcon(), str3);
        ViewKtxKt.content(getCardSuffix(), Intrinsics.stringPlus("**** **** **** ", str2));
        UiThreadHandler.postDelayed(new Runnable() {
            public final void run() {
                GlobalCashierCVVViewHolder.m15826a(GlobalCashierCVVViewHolder.this);
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15826a(GlobalCashierCVVViewHolder globalCashierCVVViewHolder) {
        Intrinsics.checkNotNullParameter(globalCashierCVVViewHolder, "this$0");
        globalCashierCVVViewHolder.getInput().requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) globalCashierCVVViewHolder.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(globalCashierCVVViewHolder.getInput(), 1);
        }
    }

    public void updateDrawerEntrance(String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "click");
        ViewKtxKt.content(getEntrance(), str);
        ViewKtxKt.click$default(getEntrance(), 0, new GlobalCashierCVVViewHolder$updateDrawerEntrance$1(function0), 1, (Object) null);
    }

    public String getCvvContent() {
        Editable text = getInput().getText();
        if (text == null) {
            return null;
        }
        return text.toString();
    }
}
