package com.didi.soda.address.edit.binder;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.didi.raven.config.RavenKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J(\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/address/edit/binder/EditAddressTextWatch;", "Landroid/text/TextWatcher;", "mTargetView", "Landroid/widget/EditText;", "mCancelView", "Landroid/view/View;", "afterTextChange", "Lkotlin/Function0;", "", "(Landroid/widget/EditText;Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "getAfterTextChange", "()Lkotlin/jvm/functions/Function0;", "setAfterTextChange", "(Lkotlin/jvm/functions/Function0;)V", "getMCancelView", "()Landroid/view/View;", "setMCancelView", "(Landroid/view/View;)V", "getMTargetView", "()Landroid/widget/EditText;", "setMTargetView", "(Landroid/widget/EditText;)V", "afterTextChanged", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressTextWatch.kt */
public final class EditAddressTextWatch implements TextWatcher {

    /* renamed from: a */
    private EditText f38724a;

    /* renamed from: b */
    private View f38725b;

    /* renamed from: c */
    private Function0<Unit> f38726c;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, RavenKey.STACK);
    }

    public EditAddressTextWatch(EditText editText, View view, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(editText, "mTargetView");
        Intrinsics.checkNotNullParameter(view, "mCancelView");
        Intrinsics.checkNotNullParameter(function0, "afterTextChange");
        this.f38724a = editText;
        this.f38725b = view;
        this.f38726c = function0;
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditAddressTextWatch.m27427a(EditAddressTextWatch.this, view);
            }
        });
        this.f38724a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                EditAddressTextWatch.m27428a(EditAddressTextWatch.this, view, z);
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditAddressTextWatch(EditText editText, View view, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(editText, view, (i & 4) != 0 ? C133831.INSTANCE : function0);
    }

    public final Function0<Unit> getAfterTextChange() {
        return this.f38726c;
    }

    public final View getMCancelView() {
        return this.f38725b;
    }

    public final EditText getMTargetView() {
        return this.f38724a;
    }

    public final void setAfterTextChange(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.f38726c = function0;
    }

    public final void setMCancelView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.f38725b = view;
    }

    public final void setMTargetView(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<set-?>");
        this.f38724a = editText;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        if ((r3.length() == 0) == false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTextChanged(java.lang.CharSequence r3, int r4, int r5, int r6) {
        /*
            r2 = this;
            java.lang.String r4 = "s"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            int r4 = r3.length()
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x0010
            r4 = 1
            goto L_0x0011
        L_0x0010:
            r4 = 0
        L_0x0011:
            if (r4 == 0) goto L_0x0025
            java.lang.Class<com.didi.soda.customer.service.IToolsService> r4 = com.didi.soda.customer.service.IToolsService.class
            com.didi.soda.customer.service.IService r4 = com.didi.soda.customer.service.CustomerServiceManager.getService(r4)
            com.didi.soda.customer.service.IToolsService r4 = (com.didi.soda.customer.service.IToolsService) r4
            android.widget.EditText r0 = r2.f38724a
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.didi.soda.customer.service.IToolsService$FontType r1 = com.didi.soda.customer.service.IToolsService.FontType.LIGHT
            r4.setTypeface(r0, r1)
            goto L_0x0036
        L_0x0025:
            java.lang.Class<com.didi.soda.customer.service.IToolsService> r4 = com.didi.soda.customer.service.IToolsService.class
            com.didi.soda.customer.service.IService r4 = com.didi.soda.customer.service.CustomerServiceManager.getService(r4)
            com.didi.soda.customer.service.IToolsService r4 = (com.didi.soda.customer.service.IToolsService) r4
            android.widget.EditText r0 = r2.f38724a
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.didi.soda.customer.service.IToolsService$FontType r1 = com.didi.soda.customer.service.IToolsService.FontType.MEDIUM
            r4.setTypeface(r0, r1)
        L_0x0036:
            android.widget.EditText r4 = r2.f38724a
            boolean r4 = r4.hasFocus()
            if (r4 == 0) goto L_0x004a
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0046
            r3 = 1
            goto L_0x0047
        L_0x0046:
            r3 = 0
        L_0x0047:
            if (r3 != 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r5 = 0
        L_0x004b:
            android.view.View r3 = r2.f38725b
            if (r5 == 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r6 = 4
        L_0x0051:
            r3.setVisibility(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.binder.EditAddressTextWatch.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, RavenKey.STACK);
        this.f38726c.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27427a(EditAddressTextWatch editAddressTextWatch, View view) {
        Intrinsics.checkNotNullParameter(editAddressTextWatch, "this$0");
        editAddressTextWatch.getMTargetView().setText("");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        if ((r3 == null || r3.length() == 0) == false) goto L_0x0024;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m27428a(com.didi.soda.address.edit.binder.EditAddressTextWatch r1, android.view.View r2, boolean r3) {
        /*
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 1
            r0 = 0
            if (r3 == 0) goto L_0x0023
            android.widget.EditText r3 = r1.getMTargetView()
            android.text.Editable r3 = r3.getText()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x001f
            int r3 = r3.length()
            if (r3 != 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            goto L_0x0020
        L_0x001f:
            r3 = 1
        L_0x0020:
            if (r3 != 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            android.view.View r1 = r1.getMCancelView()
            if (r2 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = 4
        L_0x002c:
            r1.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.binder.EditAddressTextWatch.m27428a(com.didi.soda.address.edit.binder.EditAddressTextWatch, android.view.View, boolean):void");
    }
}
