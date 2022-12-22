package com.didi.entrega.info.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.entrega.customer.widget.text.IconRichTextView;
import com.didi.entrega.info.helper.HideKeyBoardListener;
import com.didi.entrega.info.helper.InfoOmegaHelper;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.widget.RFEditText;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001a\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0002J\u001a\u0010'\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010!2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0002J\u0012\u0010-\u001a\u00020\u00162\b\u0010.\u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010/\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00100\u001a\u00020&H\u0002J \u00101\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\tR\u001a\u0010\r\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u00062"}, mo175978d2 = {"Lcom/didi/entrega/info/widget/EntregaCustomerInfoContactCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "eventSource", "getEventSource", "()I", "setEventSource", "(I)V", "pageSource", "getPageSource", "setPageSource", "setCallingCodeClickListener", "", "clickListener", "Landroid/view/View$OnClickListener;", "setPageParams", "setPoiClickListener", "setUpBuilding", "contact", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Contact;", "binderFusionChannel", "setUpEditHint", "hint", "", "eitView", "Lcom/didi/rfusion/widget/RFEditText;", "setUpFirstName", "isSender", "", "setUpIcon", "iconFont", "iconView", "Lcom/didi/rfusion/widget/RFIconView;", "setUpLastName", "setUpPhone", "setUpPhoneCode", "callingCode", "setUpPoi", "isSneder", "setUpWidgetEntity", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EntregaCustomerInfoContactCardView.kt */
public final class EntregaCustomerInfoContactCardView extends ConstraintLayout {

    /* renamed from: a */
    private int f20821a;

    /* renamed from: b */
    private int f20822b;

    public void _$_clearFindViewByIdCache() {
    }

    public final int getPageSource() {
        return this.f20821a;
    }

    public final void setPageSource(int i) {
        this.f20821a = i;
    }

    public final int getEventSource() {
        return this.f20822b;
    }

    public final void setEventSource(int i) {
        this.f20822b = i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntregaCustomerInfoContactCardView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.entrega_info_contact_edit_view, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntregaCustomerInfoContactCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.entrega_info_contact_edit_view, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntregaCustomerInfoContactCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.entrega_info_contact_edit_view, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntregaCustomerInfoContactCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        LayoutInflater.from(getContext()).inflate(R.layout.entrega_info_contact_edit_view, this);
    }

    public final void setPoiClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        ((CustomerAppCompatTextView) findViewById(R.id.tv_poi)).setOnClickListener(onClickListener);
    }

    public final void setCallingCodeClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_calling_code)).setOnClickListener(onClickListener);
        ((ImageView) findViewById(R.id.iv_down_arrow)).setOnClickListener(onClickListener);
    }

    public final void setPageParams(int i, int i2) {
        this.f20821a = i;
        this.f20822b = i2;
    }

    public final void setUpWidgetEntity(CommonInfoEntity.Contact contact, boolean z, int i) {
        if (contact == null) {
            setVisibility(8);
            return;
        }
        m15225a(contact, z);
        m15224a(contact, i);
        m15230b(contact, z);
        m15232c(contact, z);
        m15234d(contact, z);
        ((RFIconView) findViewById(R.id.ic_phone_clear)).setOnClickListener(new View.OnClickListener(z, this) {
            public final /* synthetic */ boolean f$0;
            public final /* synthetic */ EntregaCustomerInfoContactCardView f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                EntregaCustomerInfoContactCardView.m15228a(this.f$0, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15228a(boolean z, EntregaCustomerInfoContactCardView entregaCustomerInfoContactCardView, View view) {
        Intrinsics.checkNotNullParameter(entregaCustomerInfoContactCardView, "this$0");
        if (z) {
            InfoOmegaHelper.INSTANCE.trackSenderPhoneClearCK(entregaCustomerInfoContactCardView.getPageSource(), entregaCustomerInfoContactCardView.getEventSource());
        } else {
            InfoOmegaHelper.INSTANCE.trackReceiverPhoneClearCK(entregaCustomerInfoContactCardView.getPageSource(), entregaCustomerInfoContactCardView.getEventSource());
        }
        Editable text = ((RFEditText) entregaCustomerInfoContactCardView.findViewById(R.id.etv_phone)).getText();
        if (text != null) {
            text.clear();
        }
    }

    /* renamed from: a */
    private final void m15225a(CommonInfoEntity.Contact contact, boolean z) {
        Integer num;
        int i;
        AddressEntity.PoiEntity poiEntity;
        AddressEntity.PoiEntity poiEntity2;
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.cl_poi);
        String str2 = null;
        boolean z2 = false;
        if (contact.getAddress() == null) {
            num = null;
        } else {
            num = 0;
        }
        if (num == null) {
            EntregaCustomerInfoContactCardView entregaCustomerInfoContactCardView = this;
            i = ((Number) 8).intValue();
        } else {
            i = num.intValue();
        }
        constraintLayout.setVisibility(i);
        if (z) {
            ((ImageView) findViewById(R.id.iv_poi_icon)).setImageResource(R.drawable.entrega_info_icon_pickup);
            ((CustomerAppCompatTextView) findViewById(R.id.tv_poi)).setTextColor(ResourceHelper.getColor(R.color.rf_color_alert_green_69_1BB17C));
        } else {
            ((ImageView) findViewById(R.id.iv_poi_icon)).setImageResource(R.drawable.entrega_info_icon_dropoff);
            ((CustomerAppCompatTextView) findViewById(R.id.tv_poi)).setTextColor(ResourceHelper.getColor(R.color.rf_color_brands_1_100));
        }
        AddressEntity address = contact.getAddress();
        if (!(address == null || (poiEntity2 = address.poi) == null || (str = poiEntity2.displayName) == null)) {
            if (str.length() == 0) {
                z2 = true;
            }
        }
        if (!z2) {
            CustomerAppCompatTextView customerAppCompatTextView = (CustomerAppCompatTextView) findViewById(R.id.tv_poi);
            AddressEntity address2 = contact.getAddress();
            if (!(address2 == null || (poiEntity = address2.poi) == null)) {
                str2 = poiEntity.displayName;
            }
            customerAppCompatTextView.setText(str2);
            ((CustomerAppCompatTextView) findViewById(R.id.tv_poi)).setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
        } else if (z) {
            ((ImageView) findViewById(R.id.iv_poi_icon)).setImageResource(R.drawable.entrega_info_icon_pickup);
            ((CustomerAppCompatTextView) findViewById(R.id.tv_poi)).setText(ResourceHelper.getString(R.string.FoodC_info_Add_the_xdMQ));
        } else {
            ((ImageView) findViewById(R.id.iv_poi_icon)).setImageResource(R.drawable.entrega_info_icon_dropoff);
            ((CustomerAppCompatTextView) findViewById(R.id.tv_poi)).setText(ResourceHelper.getString(R.string.FoodC_info_Add_the_ELhz));
        }
    }

    /* renamed from: a */
    private final void m15224a(CommonInfoEntity.Contact contact, int i) {
        Unit unit;
        if (i == 4) {
            ((ConstraintLayout) findViewById(R.id.cl_building)).setVisibility(8);
            return;
        }
        CommonInfoEntity.BuildingAddress buildingAddress = contact.getBuildingAddress();
        if (buildingAddress == null) {
            unit = null;
        } else {
            ((ConstraintLayout) findViewById(R.id.cl_building)).setVisibility(0);
            String iconFont = buildingAddress.getIconFont();
            IconRichTextView iconRichTextView = (IconRichTextView) findViewById(R.id.itv_building);
            Intrinsics.checkNotNullExpressionValue(iconRichTextView, "itv_building");
            m15227a(iconFont, (RFIconView) iconRichTextView);
            String placeHolder = buildingAddress.getPlaceHolder();
            RFEditText rFEditText = (RFEditText) findViewById(R.id.etv_building);
            Intrinsics.checkNotNullExpressionValue(rFEditText, "etv_building");
            m15226a(placeHolder, rFEditText);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ((ConstraintLayout) findViewById(R.id.cl_building)).setVisibility(8);
        }
    }

    /* renamed from: b */
    private final void m15230b(CommonInfoEntity.Contact contact, boolean z) {
        Unit unit;
        CommonInfoEntity.PhoneNumber phoneNumber = contact.getPhoneNumber();
        if (phoneNumber == null) {
            unit = null;
        } else {
            ((ConstraintLayout) findViewById(R.id.cl_phone)).setVisibility(0);
            String iconFont = phoneNumber.getIconFont();
            IconRichTextView iconRichTextView = (IconRichTextView) findViewById(R.id.itv_phone);
            Intrinsics.checkNotNullExpressionValue(iconRichTextView, "itv_phone");
            m15227a(iconFont, (RFIconView) iconRichTextView);
            String placeHolder = phoneNumber.getPlaceHolder();
            RFEditText rFEditText = (RFEditText) findViewById(R.id.etv_phone);
            Intrinsics.checkNotNullExpressionValue(rFEditText, "etv_phone");
            m15226a(placeHolder, rFEditText);
            setUpPhoneCode(phoneNumber.getCallingCode());
            ((RFEditText) findViewById(R.id.etv_phone)).setOnFocusChangeListener(new View.OnFocusChangeListener(z, this) {
                public final /* synthetic */ boolean f$0;
                public final /* synthetic */ EntregaCustomerInfoContactCardView f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void onFocusChange(View view, boolean z) {
                    EntregaCustomerInfoContactCardView.m15229a(this.f$0, this.f$1, view, z);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ((ConstraintLayout) findViewById(R.id.cl_phone)).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15229a(boolean z, EntregaCustomerInfoContactCardView entregaCustomerInfoContactCardView, View view, boolean z2) {
        Intrinsics.checkNotNullParameter(entregaCustomerInfoContactCardView, "this$0");
        if (!z2) {
            return;
        }
        if (z) {
            InfoOmegaHelper.INSTANCE.trackSenderPhoneInputCK(entregaCustomerInfoContactCardView.getPageSource(), entregaCustomerInfoContactCardView.getEventSource());
        } else {
            InfoOmegaHelper.INSTANCE.trackReceiverPhoneInputCK(entregaCustomerInfoContactCardView.getPageSource(), entregaCustomerInfoContactCardView.getEventSource());
        }
    }

    private final void setUpPhoneCode(String str) {
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            CustomerAppCompatTextView customerAppCompatTextView = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_calling_code);
            String callingCode = LoginUtil.getCallingCode();
            if (callingCode == null) {
                callingCode = "";
            }
            customerAppCompatTextView.setText(callingCode);
            return;
        }
        ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_calling_code)).setText(charSequence);
    }

    /* renamed from: c */
    private final void m15232c(CommonInfoEntity.Contact contact, boolean z) {
        Unit unit;
        CommonInfoEntity.FirstName firstName = contact.getFirstName();
        if (firstName == null) {
            unit = null;
        } else {
            ((ConstraintLayout) findViewById(R.id.cl_first_name)).setVisibility(0);
            String iconFont = firstName.getIconFont();
            IconRichTextView iconRichTextView = (IconRichTextView) findViewById(R.id.itv_first_name);
            Intrinsics.checkNotNullExpressionValue(iconRichTextView, "itv_first_name");
            m15227a(iconFont, (RFIconView) iconRichTextView);
            String placeHolder = firstName.getPlaceHolder();
            RFEditText rFEditText = (RFEditText) findViewById(R.id.etv_first_name);
            Intrinsics.checkNotNullExpressionValue(rFEditText, "etv_first_name");
            m15226a(placeHolder, rFEditText);
            ((RFEditText) findViewById(R.id.etv_first_name)).setOnFocusChangeListener(new View.OnFocusChangeListener(z, this) {
                public final /* synthetic */ boolean f$0;
                public final /* synthetic */ EntregaCustomerInfoContactCardView f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void onFocusChange(View view, boolean z) {
                    EntregaCustomerInfoContactCardView.m15231b(this.f$0, this.f$1, view, z);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ((ConstraintLayout) findViewById(R.id.cl_first_name)).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15231b(boolean z, EntregaCustomerInfoContactCardView entregaCustomerInfoContactCardView, View view, boolean z2) {
        Intrinsics.checkNotNullParameter(entregaCustomerInfoContactCardView, "this$0");
        if (z2 && z) {
            InfoOmegaHelper.INSTANCE.trackSenderNameCK(entregaCustomerInfoContactCardView.getPageSource(), entregaCustomerInfoContactCardView.getEventSource(), 1);
        }
    }

    /* renamed from: d */
    private final void m15234d(CommonInfoEntity.Contact contact, boolean z) {
        Unit unit;
        CommonInfoEntity.LastName lastName = contact.getLastName();
        if (lastName == null) {
            unit = null;
        } else {
            ((ConstraintLayout) findViewById(R.id.cl_last_name)).setVisibility(0);
            String iconFont = lastName.getIconFont();
            IconRichTextView iconRichTextView = (IconRichTextView) findViewById(R.id.itv_last_name);
            Intrinsics.checkNotNullExpressionValue(iconRichTextView, "itv_last_name");
            m15227a(iconFont, (RFIconView) iconRichTextView);
            String placeHolder = lastName.getPlaceHolder();
            RFEditText rFEditText = (RFEditText) findViewById(R.id.etv_last_name);
            Intrinsics.checkNotNullExpressionValue(rFEditText, "etv_last_name");
            m15226a(placeHolder, rFEditText);
            ((RFEditText) findViewById(R.id.etv_last_name)).setOnFocusChangeListener(new View.OnFocusChangeListener(z, this) {
                public final /* synthetic */ boolean f$0;
                public final /* synthetic */ EntregaCustomerInfoContactCardView f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void onFocusChange(View view, boolean z) {
                    EntregaCustomerInfoContactCardView.m15233c(this.f$0, this.f$1, view, z);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ((ConstraintLayout) findViewById(R.id.cl_last_name)).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m15233c(boolean z, EntregaCustomerInfoContactCardView entregaCustomerInfoContactCardView, View view, boolean z2) {
        Intrinsics.checkNotNullParameter(entregaCustomerInfoContactCardView, "this$0");
        if (z2 && z) {
            InfoOmegaHelper.INSTANCE.trackSenderNameCK(entregaCustomerInfoContactCardView.getPageSource(), entregaCustomerInfoContactCardView.getEventSource(), 2);
        }
    }

    /* renamed from: a */
    private final void m15227a(String str, RFIconView rFIconView) {
        Unit unit;
        if (str == null) {
            unit = null;
        } else {
            rFIconView.setVisibility(0);
            rFIconView.setText(str);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            EntregaCustomerInfoContactCardView entregaCustomerInfoContactCardView = this;
            rFIconView.setVisibility(4);
        }
    }

    /* renamed from: a */
    private final void m15226a(String str, RFEditText rFEditText) {
        Unit unit;
        if (str == null) {
            unit = null;
        } else {
            rFEditText.setHint(str);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            EntregaCustomerInfoContactCardView entregaCustomerInfoContactCardView = this;
            rFEditText.setHint("");
        }
        rFEditText.setOnEditorActionListener(new HideKeyBoardListener());
    }
}
