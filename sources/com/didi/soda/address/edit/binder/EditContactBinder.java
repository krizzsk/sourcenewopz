package com.didi.soda.address.edit.binder;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.raven.config.RavenKey;
import com.didi.soda.address.edit.binder.EditContactBinder;
import com.didi.soda.address.manager.AddressKeyboardStatus;
import com.didi.soda.address.manager.AutoShowType;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\bH&J\u0018\u0010\u001d\u001a\u00020\f2\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001fH$J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H$J\u000e\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u000bJ\u0010\u0010%\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didi/soda/address/edit/binder/EditContactBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;", "Lcom/didi/soda/address/edit/binder/EditContactBinder$ViewHolder;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "isCheckNameEmpty", "", "nameErrorListener", "Lkotlin/Function1;", "", "", "bind", "holder", "item", "bindDataType", "Ljava/lang/Class;", "checkShowKeyboard", "firstNameEt", "Landroid/widget/EditText;", "lastNameEt", "phoneEt", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "isTypeAid", "onSaveContract", "action", "Lkotlin/Function0;", "onSelectCountry", "countryId", "", "showNameCheckFailed", "msg", "showNameEmpty", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditContactBinder.kt */
public abstract class EditContactBinder extends ItemBinder<ContactEntity, ViewHolder> {
    /* access modifiers changed from: private */
    public final boolean isCheckNameEmpty;
    private Function1<? super String, Unit> nameErrorListener;
    private final ScopeContext scopeContext;

    public Class<ContactEntity> bindDataType() {
        return ContactEntity.class;
    }

    public abstract boolean isTypeAid();

    /* access modifiers changed from: protected */
    public abstract void onSaveContract(Function0<? extends ContactEntity> function0);

    /* access modifiers changed from: protected */
    public abstract void onSelectCountry(int i);

    public EditContactBinder(ScopeContext scopeContext2) {
        Intrinsics.checkNotNullParameter(scopeContext2, "scopeContext");
        this.scopeContext = scopeContext2;
        this.isCheckNameEmpty = scopeContext2.getBundle().getBoolean(Const.PageParams.NAME_COMPLETE_STRATEGY);
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m46740bind$lambda0(ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        viewHolder.getPhone().setText("");
    }

    public void bind(ViewHolder viewHolder, ContactEntity contactEntity) {
        String str;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(contactEntity, "item");
        viewHolder.getClearPhoneView().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditContactBinder.m46740bind$lambda0(EditContactBinder.ViewHolder.this, view);
            }
        });
        EditText phone = viewHolder.getPhone();
        phone.setOnFocusChangeListener(new View.OnFocusChangeListener(phone) {
            public final /* synthetic */ EditText f$1;

            {
                this.f$1 = r2;
            }

            public final void onFocusChange(View view, boolean z) {
                EditContactBinder.m46741bind$lambda2$lambda1(EditContactBinder.ViewHolder.this, this.f$1, view, z);
            }
        });
        EditText firstName = viewHolder.getFirstName();
        String firstName2 = contactEntity.getFirstName();
        String str2 = null;
        boolean z = true;
        if (firstName2 == null) {
            str = null;
        } else {
            CharSequence charSequence = firstName2;
            int length = charSequence.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = Intrinsics.compare((int) charSequence.charAt(!z2 ? i : length), 32) <= 0;
                if (!z2) {
                    if (!z3) {
                        z2 = true;
                    } else {
                        i++;
                    }
                } else if (!z3) {
                    break;
                } else {
                    length--;
                }
            }
            str = charSequence.subSequence(i, length + 1).toString();
        }
        firstName.setText(str);
        EditText lastName = viewHolder.getLastName();
        String lastName2 = contactEntity.getLastName();
        if (lastName2 != null) {
            CharSequence charSequence2 = lastName2;
            int length2 = charSequence2.length() - 1;
            int i2 = 0;
            boolean z4 = false;
            while (i2 <= length2) {
                boolean z5 = Intrinsics.compare((int) charSequence2.charAt(!z4 ? i2 : length2), 32) <= 0;
                if (!z4) {
                    if (!z5) {
                        z4 = true;
                    } else {
                        i2++;
                    }
                } else if (!z5) {
                    break;
                } else {
                    length2--;
                }
            }
            str2 = charSequence2.subSequence(i2, length2 + 1).toString();
        }
        lastName.setText(str2);
        if (this.isCheckNameEmpty) {
            this.nameErrorListener = new EditContactBinder$bind$5(viewHolder);
            CharSequence charSequence3 = contactEntity.nameErrorMsg;
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                z = false;
            }
            if (!z) {
                Function1<? super String, Unit> function1 = this.nameErrorListener;
                if (function1 != null) {
                    function1.invoke(contactEntity.nameErrorMsg);
                }
            } else if (isTypeAid()) {
                showNameEmpty(viewHolder);
            } else {
                viewHolder.getNameErrorHintView().setVisibility(4);
                viewHolder.showNameLineBg(viewHolder.getFirstNameLine(), false);
                viewHolder.showNameLineBg(viewHolder.getLastNameLine(), false);
            }
        }
        viewHolder.getPhone().setText(contactEntity.phone);
        viewHolder.getTvCode().setText(contactEntity.callingCode);
        viewHolder.getTvCode().setOnClickListener(new View.OnClickListener(contactEntity) {
            public final /* synthetic */ ContactEntity f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                EditContactBinder.m46742bind$lambda5(EditContactBinder.this, this.f$1, view);
            }
        });
        onSaveContract(new EditContactBinder$bind$7(viewHolder, contactEntity, this));
        checkShowKeyboard(viewHolder.getFirstName(), viewHolder.getLastName(), viewHolder.getPhone());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        if ((r2 == null || r2.length() == 0) == false) goto L_0x0044;
     */
    /* renamed from: bind$lambda-2$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m46741bind$lambda2$lambda1(com.didi.soda.address.edit.binder.EditContactBinder.ViewHolder r1, android.widget.EditText r2, android.view.View r3, boolean r4) {
        /*
            java.lang.String r3 = "$holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "$this_apply"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            if (r4 == 0) goto L_0x002a
            android.widget.TextView r3 = r1.getPhoneErrorHintView()
            java.lang.String r0 = ""
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.setText(r0)
            android.widget.TextView r3 = r1.getPhoneErrorHintView()
            r0 = 8
            r3.setVisibility(r0)
            android.view.View r3 = r1.getPhoneLine()
            r0 = 2131101496(0x7f060738, float:1.7815403E38)
            r3.setBackgroundResource(r0)
        L_0x002a:
            r3 = 1
            r0 = 0
            if (r4 == 0) goto L_0x0043
            android.text.Editable r2 = r2.getText()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x003f
            int r2 = r2.length()
            if (r2 != 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r2 = 0
            goto L_0x0040
        L_0x003f:
            r2 = 1
        L_0x0040:
            if (r2 != 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            android.view.View r1 = r1.getClearPhoneView()
            if (r3 == 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r0 = 4
        L_0x004c:
            r1.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.binder.EditContactBinder.m46741bind$lambda2$lambda1(com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder, android.widget.EditText, android.view.View, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-5  reason: not valid java name */
    public static final void m46742bind$lambda5(EditContactBinder editContactBinder, ContactEntity contactEntity, View view) {
        Intrinsics.checkNotNullParameter(editContactBinder, "this$0");
        Intrinsics.checkNotNullParameter(contactEntity, "$item");
        editContactBinder.onSelectCountry(contactEntity.countryId);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showNameEmpty(com.didi.soda.address.edit.binder.EditContactBinder.ViewHolder r10) {
        /*
            r9 = this;
            android.widget.EditText r0 = r10.getFirstName()
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r1 = r0.length()
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0017:
            r6 = 32
            if (r4 > r1) goto L_0x003c
            if (r5 != 0) goto L_0x001f
            r7 = r4
            goto L_0x0020
        L_0x001f:
            r7 = r1
        L_0x0020:
            char r7 = r0.charAt(r7)
            int r7 = kotlin.jvm.internal.Intrinsics.compare((int) r7, (int) r6)
            if (r7 > 0) goto L_0x002c
            r7 = 1
            goto L_0x002d
        L_0x002c:
            r7 = 0
        L_0x002d:
            if (r5 != 0) goto L_0x0036
            if (r7 != 0) goto L_0x0033
            r5 = 1
            goto L_0x0017
        L_0x0033:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0036:
            if (r7 != 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            int r1 = r1 + -1
            goto L_0x0017
        L_0x003c:
            int r1 = r1 + r2
            java.lang.CharSequence r0 = r0.subSequence(r4, r1)
            java.lang.String r0 = r0.toString()
            android.widget.EditText r1 = r10.getLastName()
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r4 = r1.length()
            int r4 = r4 - r2
            r5 = 0
            r7 = 0
        L_0x005a:
            if (r5 > r4) goto L_0x007d
            if (r7 != 0) goto L_0x0060
            r8 = r5
            goto L_0x0061
        L_0x0060:
            r8 = r4
        L_0x0061:
            char r8 = r1.charAt(r8)
            int r8 = kotlin.jvm.internal.Intrinsics.compare((int) r8, (int) r6)
            if (r8 > 0) goto L_0x006d
            r8 = 1
            goto L_0x006e
        L_0x006d:
            r8 = 0
        L_0x006e:
            if (r7 != 0) goto L_0x0077
            if (r8 != 0) goto L_0x0074
            r7 = 1
            goto L_0x005a
        L_0x0074:
            int r5 = r5 + 1
            goto L_0x005a
        L_0x0077:
            if (r8 != 0) goto L_0x007a
            goto L_0x007d
        L_0x007a:
            int r4 = r4 + -1
            goto L_0x005a
        L_0x007d:
            int r4 = r4 + r2
            java.lang.CharSequence r1 = r1.subSequence(r5, r4)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0093
            int r4 = r0.length()
            if (r4 != 0) goto L_0x0091
            goto L_0x0093
        L_0x0091:
            r4 = 0
            goto L_0x0094
        L_0x0093:
            r4 = 1
        L_0x0094:
            if (r4 == 0) goto L_0x00af
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x00a4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            r4 = 0
            goto L_0x00a5
        L_0x00a4:
            r4 = 1
        L_0x00a5:
            if (r4 == 0) goto L_0x00af
            r0 = 2131951944(0x7f130148, float:1.9540317E38)
            java.lang.String r0 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r0)
            goto L_0x00df
        L_0x00af:
            if (r0 == 0) goto L_0x00ba
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00b8
            goto L_0x00ba
        L_0x00b8:
            r0 = 0
            goto L_0x00bb
        L_0x00ba:
            r0 = 1
        L_0x00bb:
            if (r0 == 0) goto L_0x00c5
            r0 = 2131951946(0x7f13014a, float:1.954032E38)
            java.lang.String r0 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r0)
            goto L_0x00df
        L_0x00c5:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00d2
            int r0 = r1.length()
            if (r0 != 0) goto L_0x00d0
            goto L_0x00d2
        L_0x00d0:
            r0 = 0
            goto L_0x00d3
        L_0x00d2:
            r0 = 1
        L_0x00d3:
            if (r0 == 0) goto L_0x00dd
            r0 = 2131951945(0x7f130149, float:1.9540319E38)
            java.lang.String r0 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r0)
            goto L_0x00df
        L_0x00dd:
            java.lang.String r0 = ""
        L_0x00df:
            android.widget.TextView r1 = r10.getNameErrorHintView()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            if (r0 == 0) goto L_0x00f3
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00f1
            goto L_0x00f3
        L_0x00f1:
            r0 = 0
            goto L_0x00f4
        L_0x00f3:
            r0 = 1
        L_0x00f4:
            if (r0 != 0) goto L_0x010c
            android.widget.TextView r0 = r10.getNameErrorHintView()
            r0.setVisibility(r3)
            android.view.View r0 = r10.getFirstNameLine()
            r10.showNameLineBg(r0, r2)
            android.view.View r0 = r10.getLastNameLine()
            r10.showNameLineBg(r0, r2)
            goto L_0x0122
        L_0x010c:
            android.widget.TextView r0 = r10.getNameErrorHintView()
            r1 = 4
            r0.setVisibility(r1)
            android.view.View r0 = r10.getFirstNameLine()
            r10.showNameLineBg(r0, r3)
            android.view.View r0 = r10.getLastNameLine()
            r10.showNameLineBg(r0, r3)
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.binder.EditContactBinder.showNameEmpty(com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder):void");
    }

    private final void checkShowKeyboard(EditText editText, EditText editText2, EditText editText3) {
        Object object = this.scopeContext.getObject(Const.PageParams.ADDRESS_KEYBOARD_ENTITY);
        AddressKeyboardStatus addressKeyboardStatus = object instanceof AddressKeyboardStatus ? (AddressKeyboardStatus) object : null;
        if (addressKeyboardStatus != null && AutoShowType.Contact == addressKeyboardStatus.getShowType() && !addressKeyboardStatus.getAlreadyLoaded()) {
            CharSequence text = editText.getText();
            boolean z = false;
            if (text == null || text.length() == 0) {
                editText.post(new Runnable(editText) {
                    public final /* synthetic */ EditText f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void run() {
                        EditContactBinder.m46744checkShowKeyboard$lambda11$lambda8(this.f$0);
                    }
                });
                return;
            }
            CharSequence text2 = editText2.getText();
            if (text2 == null || text2.length() == 0) {
                z = true;
            }
            if (z) {
                editText2.post(new Runnable(editText2) {
                    public final /* synthetic */ EditText f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void run() {
                        EditContactBinder.m46745checkShowKeyboard$lambda11$lambda9(this.f$0);
                    }
                });
            } else {
                editText3.post(new Runnable(editText3) {
                    public final /* synthetic */ EditText f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void run() {
                        EditContactBinder.m46743checkShowKeyboard$lambda11$lambda10(this.f$0);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkShowKeyboard$lambda-11$lambda-8  reason: not valid java name */
    public static final void m46744checkShowKeyboard$lambda11$lambda8(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$firstNameEt");
        KeyboardUtils.showSoftInput(editText.getContext(), editText);
    }

    /* access modifiers changed from: private */
    /* renamed from: checkShowKeyboard$lambda-11$lambda-9  reason: not valid java name */
    public static final void m46745checkShowKeyboard$lambda11$lambda9(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$lastNameEt");
        KeyboardUtils.showSoftInput(editText.getContext(), editText);
    }

    /* access modifiers changed from: private */
    /* renamed from: checkShowKeyboard$lambda-11$lambda-10  reason: not valid java name */
    public static final void m46743checkShowKeyboard$lambda11$lambda10(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$phoneEt");
        KeyboardUtils.showSoftInput(editText.getContext(), editText);
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        boolean z = this.isCheckNameEmpty;
        View inflate = layoutInflater.inflate(R.layout.customer_binder_edit_address_contact, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…s_contact, parent, false)");
        return new ViewHolder(z, inflate);
    }

    public final void showNameCheckFailed(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        Function1<? super String, Unit> function1 = this.nameErrorListener;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    @Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0004R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0011\u0010 \u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\"\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\nR\u0011\u0010$\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001d¨\u0006*"}, mo175978d2 = {"Lcom/didi/soda/address/edit/binder/EditContactBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;", "isCheckNameEmpty", "", "itemView", "Landroid/view/View;", "(ZLandroid/view/View;)V", "clearFirstNameView", "getClearFirstNameView", "()Landroid/view/View;", "clearLastNameView", "getClearLastNameView", "clearPhoneView", "getClearPhoneView", "firstName", "Landroid/widget/EditText;", "getFirstName", "()Landroid/widget/EditText;", "firstNameLine", "getFirstNameLine", "()Z", "lastName", "getLastName", "lastNameLine", "getLastNameLine", "nameErrorHintView", "Landroid/widget/TextView;", "getNameErrorHintView", "()Landroid/widget/TextView;", "phone", "getPhone", "phoneErrorHintView", "getPhoneErrorHintView", "phoneLine", "getPhoneLine", "tvCode", "getTvCode", "showNameLineBg", "", "view", "isWarning", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: EditContactBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<ContactEntity> {
        private final View clearFirstNameView;
        private final View clearLastNameView;
        private final View clearPhoneView;
        private final EditText firstName;
        private final View firstNameLine;
        private final boolean isCheckNameEmpty;
        private final EditText lastName;
        private final View lastNameLine;
        private final TextView nameErrorHintView;
        private final EditText phone;
        private final TextView phoneErrorHintView;
        private final View phoneLine;
        private final TextView tvCode;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(boolean z, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.isCheckNameEmpty = z;
            Object findViewById = findViewById(R.id.customer_custom_contacts_first_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…stom_contacts_first_name)");
            this.firstName = (EditText) findViewById;
            Object findViewById2 = findViewById(R.id.customer_custom_contacts_last_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…ustom_contacts_last_name)");
            this.lastName = (EditText) findViewById2;
            Object findViewById3 = findViewById(R.id.customer_custom_contacts_phone);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_custom_contacts_phone)");
            this.phone = (EditText) findViewById3;
            Object findViewById4 = findViewById(R.id.customer_tv_calling_code);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_calling_code)");
            this.tvCode = (TextView) findViewById4;
            Object findViewById5 = findViewById(R.id.customer_tv_phone_num_input_line);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…_tv_phone_num_input_line)");
            this.phoneLine = (View) findViewById5;
            Object findViewById6 = findViewById(R.id.customer_tv_phone_num_error_hint);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.custom…_tv_phone_num_error_hint)");
            this.phoneErrorHintView = (TextView) findViewById6;
            Object findViewById7 = findViewById(R.id.customer_iv_cancel_first_name);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_iv_cancel_first_name)");
            this.clearFirstNameView = (View) findViewById7;
            Object findViewById8 = findViewById(R.id.customer_iv_cancel_last_name);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.customer_iv_cancel_last_name)");
            this.clearLastNameView = (View) findViewById8;
            Object findViewById9 = findViewById(R.id.customer_iv_cancel_phone);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.customer_iv_cancel_phone)");
            this.clearPhoneView = (View) findViewById9;
            Object findViewById10 = findViewById(R.id.customer_tv_first_name_num_input_line);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.custom…irst_name_num_input_line)");
            this.firstNameLine = (View) findViewById10;
            Object findViewById11 = findViewById(R.id.customer_tv_last_name_num_input_line);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.custom…last_name_num_input_line)");
            this.lastNameLine = (View) findViewById11;
            Object findViewById12 = findViewById(R.id.customer_tv_name_error_hint);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.customer_tv_name_error_hint)");
            this.nameErrorHintView = (TextView) findViewById12;
            EditText editText = this.firstName;
            editText.addTextChangedListener(new EditAddressTextWatch(editText, this.clearFirstNameView, (Function0) null, 4, (DefaultConstructorMarker) null));
            EditText editText2 = this.lastName;
            editText2.addTextChangedListener(new EditAddressTextWatch(editText2, this.clearLastNameView, (Function0) null, 4, (DefaultConstructorMarker) null));
            this.phone.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ ViewHolder this$0;

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Intrinsics.checkNotNullParameter(charSequence, RavenKey.STACK);
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Intrinsics.checkNotNullParameter(charSequence, RavenKey.STACK);
                }

                {
                    this.this$0 = r1;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
                    if ((r6.length() == 0) == false) goto L_0x0059;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void afterTextChanged(android.text.Editable r6) {
                    /*
                        r5 = this;
                        java.lang.String r0 = "s"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                        java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                        int r0 = r6.length()
                        r1 = 1
                        r2 = 0
                        if (r0 != 0) goto L_0x0012
                        r0 = 1
                        goto L_0x0013
                    L_0x0012:
                        r0 = 0
                    L_0x0013:
                        if (r0 == 0) goto L_0x002b
                        java.lang.Class<com.didi.soda.customer.service.IToolsService> r0 = com.didi.soda.customer.service.IToolsService.class
                        com.didi.soda.customer.service.IService r0 = com.didi.soda.customer.service.CustomerServiceManager.getService(r0)
                        com.didi.soda.customer.service.IToolsService r0 = (com.didi.soda.customer.service.IToolsService) r0
                        com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r3 = r5.this$0
                        android.widget.EditText r3 = r3.getPhone()
                        android.widget.TextView r3 = (android.widget.TextView) r3
                        com.didi.soda.customer.service.IToolsService$FontType r4 = com.didi.soda.customer.service.IToolsService.FontType.LIGHT
                        r0.setTypeface(r3, r4)
                        goto L_0x0040
                    L_0x002b:
                        java.lang.Class<com.didi.soda.customer.service.IToolsService> r0 = com.didi.soda.customer.service.IToolsService.class
                        com.didi.soda.customer.service.IService r0 = com.didi.soda.customer.service.CustomerServiceManager.getService(r0)
                        com.didi.soda.customer.service.IToolsService r0 = (com.didi.soda.customer.service.IToolsService) r0
                        com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r3 = r5.this$0
                        android.widget.EditText r3 = r3.getPhone()
                        android.widget.TextView r3 = (android.widget.TextView) r3
                        com.didi.soda.customer.service.IToolsService$FontType r4 = com.didi.soda.customer.service.IToolsService.FontType.MEDIUM
                        r0.setTypeface(r3, r4)
                    L_0x0040:
                        com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r0 = r5.this$0
                        android.widget.EditText r0 = r0.getPhone()
                        boolean r0 = r0.hasFocus()
                        if (r0 == 0) goto L_0x0058
                        int r6 = r6.length()
                        if (r6 != 0) goto L_0x0054
                        r6 = 1
                        goto L_0x0055
                    L_0x0054:
                        r6 = 0
                    L_0x0055:
                        if (r6 != 0) goto L_0x0058
                        goto L_0x0059
                    L_0x0058:
                        r1 = 0
                    L_0x0059:
                        com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r6 = r5.this$0
                        android.view.View r6 = r6.getClearPhoneView()
                        if (r1 == 0) goto L_0x0062
                        goto L_0x0063
                    L_0x0062:
                        r2 = 4
                    L_0x0063:
                        r6.setVisibility(r2)
                        com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r6 = r5.this$0
                        android.widget.TextView r6 = r6.getPhoneErrorHintView()
                        java.lang.String r0 = ""
                        java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                        r6.setText(r0)
                        com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r6 = r5.this$0
                        android.widget.TextView r6 = r6.getPhoneErrorHintView()
                        r0 = 8
                        r6.setVisibility(r0)
                        com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r6 = r5.this$0
                        android.view.View r6 = r6.getPhoneLine()
                        r0 = 2131101496(0x7f060738, float:1.7815403E38)
                        r6.setBackgroundResource(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.binder.EditContactBinder.ViewHolder.C133841.afterTextChanged(android.text.Editable):void");
                }
            });
            if (this.isCheckNameEmpty) {
                TextWatcher editContactBinder$ViewHolder$nameTextChangeListener$1 = new EditContactBinder$ViewHolder$nameTextChangeListener$1(this);
                this.firstName.addTextChangedListener(editContactBinder$ViewHolder$nameTextChangeListener$1);
                this.lastName.addTextChangedListener(editContactBinder$ViewHolder$nameTextChangeListener$1);
            }
        }

        public final boolean isCheckNameEmpty() {
            return this.isCheckNameEmpty;
        }

        public final EditText getFirstName() {
            return this.firstName;
        }

        public final EditText getLastName() {
            return this.lastName;
        }

        public final EditText getPhone() {
            return this.phone;
        }

        public final TextView getTvCode() {
            return this.tvCode;
        }

        public final View getPhoneLine() {
            return this.phoneLine;
        }

        public final TextView getPhoneErrorHintView() {
            return this.phoneErrorHintView;
        }

        public final View getClearFirstNameView() {
            return this.clearFirstNameView;
        }

        public final View getClearLastNameView() {
            return this.clearLastNameView;
        }

        public final View getClearPhoneView() {
            return this.clearPhoneView;
        }

        public final View getFirstNameLine() {
            return this.firstNameLine;
        }

        public final View getLastNameLine() {
            return this.lastNameLine;
        }

        public final TextView getNameErrorHintView() {
            return this.nameErrorHintView;
        }

        public final void showNameLineBg(View view, boolean z) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (z) {
                view.setBackgroundResource(R.color.rf_color_v2_secondary_3_100);
            } else {
                view.setBackgroundResource(R.color.rf_color_gery_5_90_E5E5E5);
            }
        }
    }
}
