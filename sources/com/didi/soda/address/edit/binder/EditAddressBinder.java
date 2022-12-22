package com.didi.soda.address.edit.binder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.address.edit.binder.EditAddressBinder;
import com.didi.soda.address.manager.AddressKeyboardStatus;
import com.didi.soda.address.manager.AutoShowType;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00015B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J \u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u001a\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000fH&J\b\u0010\"\u001a\u00020#H&J\b\u0010$\u001a\u00020#H&J\b\u0010%\u001a\u00020#H&J\b\u0010&\u001a\u00020\bH&J\u0010\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u000fH&J \u0010)\u001a\u00020\b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+H&J\u0016\u0010-\u001a\u00020\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020/H&J\u0010\u00100\u001a\u00020\b2\u0006\u00101\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u00104\u001a\u00020\b2\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00066"}, mo175978d2 = {"Lcom/didi/soda/address/edit/binder/EditAddressBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/address/edit/binder/EditAddressModel;", "Lcom/didi/soda/address/edit/binder/EditAddressBinder$ViewHolder;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "bind", "", "holder", "editAddressModel", "bindAddressTag", "bindDataType", "Ljava/lang/Class;", "cauTotalHeight", "", "view", "Landroid/view/View;", "checkShowAddressTips", "addressTipContainer", "checkShowKeyboard", "buildNameView", "Landroid/widget/EditText;", "apartmentNumberView", "clickTag", "v", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "getExpandMarginHeight", "getFirstViewHeight", "firstHeight", "isAddressClickable", "", "isUseNewAddressArrow", "needShowAddressTips", "onAddressClick", "onBindFinish", "height", "onHouseBuildChanged", "houseName", "", "buildName", "onSaveAddress", "action", "Lkotlin/Function0;", "setMiniWidth", "textView", "Landroid/widget/TextView;", "setTagStyle", "setTypeFont", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressBinder.kt */
public abstract class EditAddressBinder extends ItemBinder<EditAddressModel, ViewHolder> {
    private final ScopeContext scopeContext;

    public Class<EditAddressModel> bindDataType() {
        return EditAddressModel.class;
    }

    public abstract void getFirstViewHeight(int i);

    public abstract boolean isAddressClickable();

    public abstract boolean isUseNewAddressArrow();

    public abstract boolean needShowAddressTips();

    public abstract void onAddressClick();

    public abstract void onBindFinish(int i);

    public abstract void onHouseBuildChanged(String str, String str2);

    public abstract void onSaveAddress(Function0<EditAddressModel> function0);

    public EditAddressBinder(ScopeContext scopeContext2) {
        Intrinsics.checkNotNullParameter(scopeContext2, "scopeContext");
        this.scopeContext = scopeContext2;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.customer_binder_edit_address_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ress_item, parent, false)");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, EditAddressModel editAddressModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(editAddressModel, "editAddressModel");
        viewHolder.getBuildNameView().addTextChangedListener(new EditAddressTextWatch(viewHolder.getBuildNameView(), viewHolder.getCancelBuildNameView(), new EditAddressBinder$bind$1(this, viewHolder)));
        viewHolder.getApartmentNumberView().addTextChangedListener(new EditAddressTextWatch(viewHolder.getApartmentNumberView(), viewHolder.getCancelHouseNumView(), new EditAddressBinder$bind$2(this, viewHolder)));
        if (editAddressModel.isValid()) {
            viewHolder.getAddressNameView().setText(editAddressModel.getAddressDisplayName());
            if (!TextUtils.isEmpty(editAddressModel.getAddressAll())) {
                viewHolder.getAddressDetailNameView().setText(editAddressModel.getAddressAll());
                viewHolder.getAddressDetailNameView().setVisibility(0);
            } else {
                viewHolder.getAddressDetailNameView().setVisibility(4);
            }
            viewHolder.getBuildNameView().setText(editAddressModel.getBuildingName());
            viewHolder.getApartmentNumberView().setText(editAddressModel.getHouseNumber());
        } else {
            viewHolder.getAddressNameView().setText(ResourceHelper.getString(R.string.FoodC_toast_Error_description_JCQZ));
            viewHolder.getAddressDetailNameView().setText("");
            viewHolder.getAddressDetailNameView().setVisibility(0);
            viewHolder.getBuildNameView().setText("");
            viewHolder.getApartmentNumberView().setText("");
        }
        bindAddressTag(viewHolder, editAddressModel);
        if (!isAddressClickable()) {
            viewHolder.getArrowLayout().setVisibility(8);
        } else {
            if (isUseNewAddressArrow()) {
                viewHolder.getArrowIcon().setVisibility(8);
                viewHolder.getArrowIconNew().setVisibility(0);
            } else {
                viewHolder.getArrowIcon().setVisibility(0);
                viewHolder.getArrowIconNew().setVisibility(8);
            }
            viewHolder.getAddressNameView().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    EditAddressBinder.m46727bind$lambda0(EditAddressBinder.this, view);
                }
            });
            viewHolder.getAddressDetailNameView().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    EditAddressBinder.m46728bind$lambda1(EditAddressBinder.this, view);
                }
            });
            viewHolder.getArrowLayout().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    EditAddressBinder.m46729bind$lambda2(EditAddressBinder.this, view);
                }
            });
        }
        onSaveAddress(new EditAddressBinder$bind$6(viewHolder, editAddressModel));
        viewHolder.itemView.getViewTreeObserver().addOnPreDrawListener(new EditAddressBinder$bind$7(viewHolder, this));
        viewHolder.getBuildNameView().setImeOptions(5);
        if (editAddressModel.getShowImeActionNext()) {
            viewHolder.getApartmentNumberView().setImeOptions(5);
        } else {
            viewHolder.getApartmentNumberView().setImeOptions(6);
        }
        checkShowKeyboard(viewHolder.getBuildNameView(), viewHolder.getApartmentNumberView());
        checkShowAddressTips(viewHolder.getAddressTipContainer());
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m46727bind$lambda0(EditAddressBinder editAddressBinder, View view) {
        Intrinsics.checkNotNullParameter(editAddressBinder, "this$0");
        editAddressBinder.onAddressClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1  reason: not valid java name */
    public static final void m46728bind$lambda1(EditAddressBinder editAddressBinder, View view) {
        Intrinsics.checkNotNullParameter(editAddressBinder, "this$0");
        editAddressBinder.onAddressClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-2  reason: not valid java name */
    public static final void m46729bind$lambda2(EditAddressBinder editAddressBinder, View view) {
        Intrinsics.checkNotNullParameter(editAddressBinder, "this$0");
        editAddressBinder.onAddressClick();
    }

    private final void checkShowAddressTips(View view) {
        if (needShowAddressTips()) {
            view.setVisibility(0);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    EditAddressBinder.m46732checkShowAddressTips$lambda3(EditAddressBinder.this, view);
                }
            });
            return;
        }
        view.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: checkShowAddressTips$lambda-3  reason: not valid java name */
    public static final void m46732checkShowAddressTips$lambda3(EditAddressBinder editAddressBinder, View view) {
        Intrinsics.checkNotNullParameter(editAddressBinder, "this$0");
        editAddressBinder.onAddressClick();
    }

    /* access modifiers changed from: private */
    public final int getExpandMarginHeight() {
        if (needShowAddressTips()) {
            return DisplayUtils.dip2px(GlobalContext.getContext(), 9.0f);
        }
        return DisplayUtils.dip2px(GlobalContext.getContext(), 20.0f);
    }

    private final void checkShowKeyboard(EditText editText, EditText editText2) {
        Object object = this.scopeContext.getObject(Const.PageParams.ADDRESS_KEYBOARD_ENTITY);
        AddressKeyboardStatus addressKeyboardStatus = object instanceof AddressKeyboardStatus ? (AddressKeyboardStatus) object : null;
        if (addressKeyboardStatus != null && AutoShowType.Address == addressKeyboardStatus.getShowType() && !addressKeyboardStatus.getAlreadyLoaded()) {
            CharSequence text = editText.getText();
            if (text == null || text.length() == 0) {
                editText.post(new Runnable(editText) {
                    public final /* synthetic */ EditText f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void run() {
                        EditAddressBinder.m46733checkShowKeyboard$lambda6$lambda4(this.f$0);
                    }
                });
            } else {
                editText2.post(new Runnable(editText2) {
                    public final /* synthetic */ EditText f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void run() {
                        EditAddressBinder.m46734checkShowKeyboard$lambda6$lambda5(this.f$0);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkShowKeyboard$lambda-6$lambda-4  reason: not valid java name */
    public static final void m46733checkShowKeyboard$lambda6$lambda4(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$buildNameView");
        KeyboardUtils.showSoftInput(editText.getContext(), editText);
    }

    /* access modifiers changed from: private */
    /* renamed from: checkShowKeyboard$lambda-6$lambda-5  reason: not valid java name */
    public static final void m46734checkShowKeyboard$lambda6$lambda5(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$apartmentNumberView");
        KeyboardUtils.showSoftInput(editText.getContext(), editText);
    }

    /* access modifiers changed from: private */
    public final int cauTotalHeight(View view) {
        int measuredHeight = view.getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
        int i = 0;
        int i2 = measuredHeight + (marginLayoutParams2 != null ? marginLayoutParams2.bottomMargin : 0);
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = layoutParams2;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams3 = marginLayoutParams;
        if (marginLayoutParams3 != null) {
            i = marginLayoutParams3.topMargin;
        }
        return i2 + i;
    }

    private final void bindAddressTag(ViewHolder viewHolder, EditAddressModel editAddressModel) {
        setMiniWidth(viewHolder.getAddressHomeTag());
        setMiniWidth(viewHolder.getAddressOfficeTag());
        setTagStyle(viewHolder, editAddressModel);
        viewHolder.getAddressHomeTag().setTag(1);
        viewHolder.getAddressOfficeTag().setTag(2);
        viewHolder.getAddressHomeTag().setOnClickListener(new View.OnClickListener(viewHolder, editAddressModel) {
            public final /* synthetic */ EditAddressBinder.ViewHolder f$1;
            public final /* synthetic */ EditAddressModel f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                EditAddressBinder.m46730bindAddressTag$lambda7(EditAddressBinder.this, this.f$1, this.f$2, view);
            }
        });
        viewHolder.getAddressOfficeTag().setOnClickListener(new View.OnClickListener(viewHolder, editAddressModel) {
            public final /* synthetic */ EditAddressBinder.ViewHolder f$1;
            public final /* synthetic */ EditAddressModel f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                EditAddressBinder.m46731bindAddressTag$lambda8(EditAddressBinder.this, this.f$1, this.f$2, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: bindAddressTag$lambda-7  reason: not valid java name */
    public static final void m46730bindAddressTag$lambda7(EditAddressBinder editAddressBinder, ViewHolder viewHolder, EditAddressModel editAddressModel, View view) {
        Intrinsics.checkNotNullParameter(editAddressBinder, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNullParameter(editAddressModel, "$editAddressModel");
        Intrinsics.checkNotNullExpressionValue(view, "it");
        editAddressBinder.clickTag(viewHolder, view, editAddressModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindAddressTag$lambda-8  reason: not valid java name */
    public static final void m46731bindAddressTag$lambda8(EditAddressBinder editAddressBinder, ViewHolder viewHolder, EditAddressModel editAddressModel, View view) {
        Intrinsics.checkNotNullParameter(editAddressBinder, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNullParameter(editAddressModel, "$editAddressModel");
        Intrinsics.checkNotNullExpressionValue(view, "it");
        editAddressBinder.clickTag(viewHolder, view, editAddressModel);
    }

    private final void setTagStyle(ViewHolder viewHolder, EditAddressModel editAddressModel) {
        int type = editAddressModel.getType();
        if (type == 1) {
            viewHolder.getAddressHomeTag().setSelected(true);
            viewHolder.getAddressOfficeTag().setSelected(false);
        } else if (type != 2) {
            viewHolder.getAddressHomeTag().setSelected(false);
            viewHolder.getAddressOfficeTag().setSelected(false);
        } else {
            viewHolder.getAddressHomeTag().setSelected(false);
            viewHolder.getAddressOfficeTag().setSelected(true);
        }
        setTypeFont(viewHolder.getAddressHomeTag());
        setTypeFont(viewHolder.getAddressOfficeTag());
    }

    public static /* synthetic */ void onHouseBuildChanged$default(EditAddressBinder editAddressBinder, String str, String str2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            editAddressBinder.onHouseBuildChanged(str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onHouseBuildChanged");
    }

    private final void clickTag(ViewHolder viewHolder, View view, EditAddressModel editAddressModel) {
        view.requestFocus();
        Object tag = view.getTag();
        if (tag != null) {
            int intValue = ((Integer) tag).intValue();
            if (intValue == editAddressModel.getType()) {
                editAddressModel.setType(0);
            } else {
                editAddressModel.setType(intValue);
            }
            setTagStyle(viewHolder, editAddressModel);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void setMiniWidth(TextView textView) {
        textView.setMinWidth((int) (textView.getPaint().measureText(textView.getText().toString()) + ((float) DisplayUtils.dip2px(textView.getContext(), 28.0f))));
    }

    private final void setTypeFont(TextView textView) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(textView, textView.isSelected() ? IToolsService.FontType.MEDIUM : IToolsService.FontType.LIGHT);
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0005R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000bR\u001a\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0005R\u001a\u0010%\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0005R\u001a\u0010(\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001a\u0010+\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0005R\u001a\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0005¨\u00061"}, mo175978d2 = {"Lcom/didi/soda/address/edit/binder/EditAddressBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/address/edit/binder/EditAddressModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "addressDetailNameView", "Landroid/widget/TextView;", "getAddressDetailNameView", "()Landroid/widget/TextView;", "setAddressDetailNameView", "(Landroid/widget/TextView;)V", "addressHomeTag", "getAddressHomeTag", "setAddressHomeTag", "addressNameView", "getAddressNameView", "setAddressNameView", "addressOfficeTag", "getAddressOfficeTag", "setAddressOfficeTag", "addressTipContainer", "getAddressTipContainer", "()Landroid/view/View;", "setAddressTipContainer", "apartmentNumberView", "Landroid/widget/EditText;", "getApartmentNumberView", "()Landroid/widget/EditText;", "setApartmentNumberView", "(Landroid/widget/EditText;)V", "arrowIcon", "getArrowIcon", "setArrowIcon", "arrowIconNew", "getArrowIconNew", "setArrowIconNew", "arrowLayout", "getArrowLayout", "setArrowLayout", "buildNameView", "getBuildNameView", "setBuildNameView", "cancelBuildNameView", "getCancelBuildNameView", "setCancelBuildNameView", "cancelHouseNumView", "getCancelHouseNumView", "setCancelHouseNumView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: EditAddressBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<EditAddressModel> {
        private TextView addressDetailNameView;
        private TextView addressHomeTag;
        private TextView addressNameView;
        private TextView addressOfficeTag;
        private View addressTipContainer;
        private EditText apartmentNumberView;
        private TextView arrowIcon;
        private View arrowIconNew;
        private View arrowLayout;
        private EditText buildNameView;
        private View cancelBuildNameView;
        private View cancelHouseNumView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.customer_tv_edit_address_title_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…_edit_address_title_icon)");
            this.arrowIcon = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.customer_tv_edit_address_title_icon_new);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…t_address_title_icon_new)");
            this.arrowIconNew = findViewById2;
            View findViewById3 = view.findViewById(R.id.customer_tv_edit_address_title_icon_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.…ddress_title_icon_layout)");
            this.arrowLayout = findViewById3;
            View findViewById4 = view.findViewById(R.id.customer_tv_edit_address_name_detail);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.…edit_address_name_detail)");
            this.addressNameView = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.customer_tv_edit_address_title_detail);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.…dit_address_title_detail)");
            this.addressDetailNameView = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.customer_custom_edit_address_building_number);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.…_address_building_number)");
            this.buildNameView = (EditText) findViewById6;
            View findViewById7 = view.findViewById(R.id.customer_custom_edit_address_house_number);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.…dit_address_house_number)");
            this.apartmentNumberView = (EditText) findViewById7;
            View findViewById8 = view.findViewById(R.id.customer_ll_address_type_home);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.…mer_ll_address_type_home)");
            this.addressHomeTag = (TextView) findViewById8;
            View findViewById9 = view.findViewById(R.id.customer_ll_address_type_office);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.…r_ll_address_type_office)");
            this.addressOfficeTag = (TextView) findViewById9;
            View findViewById10 = view.findViewById(R.id.customer_iv_cancel_build_name);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.…mer_iv_cancel_build_name)");
            this.cancelBuildNameView = findViewById10;
            View findViewById11 = view.findViewById(R.id.customer_iv_cancel_house_number);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(R.…r_iv_cancel_house_number)");
            this.cancelHouseNumView = findViewById11;
            View findViewById12 = view.findViewById(R.id.customer_ctl_edit_address_tip);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "itemView.findViewById(R.…mer_ctl_edit_address_tip)");
            this.addressTipContainer = findViewById12;
        }

        public final TextView getArrowIcon() {
            return this.arrowIcon;
        }

        public final void setArrowIcon(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.arrowIcon = textView;
        }

        public final View getArrowIconNew() {
            return this.arrowIconNew;
        }

        public final void setArrowIconNew(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.arrowIconNew = view;
        }

        public final View getArrowLayout() {
            return this.arrowLayout;
        }

        public final void setArrowLayout(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.arrowLayout = view;
        }

        public final TextView getAddressNameView() {
            return this.addressNameView;
        }

        public final void setAddressNameView(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.addressNameView = textView;
        }

        public final TextView getAddressDetailNameView() {
            return this.addressDetailNameView;
        }

        public final void setAddressDetailNameView(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.addressDetailNameView = textView;
        }

        public final EditText getBuildNameView() {
            return this.buildNameView;
        }

        public final void setBuildNameView(EditText editText) {
            Intrinsics.checkNotNullParameter(editText, "<set-?>");
            this.buildNameView = editText;
        }

        public final EditText getApartmentNumberView() {
            return this.apartmentNumberView;
        }

        public final void setApartmentNumberView(EditText editText) {
            Intrinsics.checkNotNullParameter(editText, "<set-?>");
            this.apartmentNumberView = editText;
        }

        public final TextView getAddressHomeTag() {
            return this.addressHomeTag;
        }

        public final void setAddressHomeTag(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.addressHomeTag = textView;
        }

        public final TextView getAddressOfficeTag() {
            return this.addressOfficeTag;
        }

        public final void setAddressOfficeTag(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.addressOfficeTag = textView;
        }

        public final View getCancelBuildNameView() {
            return this.cancelBuildNameView;
        }

        public final void setCancelBuildNameView(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.cancelBuildNameView = view;
        }

        public final View getCancelHouseNumView() {
            return this.cancelHouseNumView;
        }

        public final void setCancelHouseNumView(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.cancelHouseNumView = view;
        }

        public final View getAddressTipContainer() {
            return this.addressTipContainer;
        }

        public final void setAddressTipContainer(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.addressTipContainer = view;
        }
    }
}
