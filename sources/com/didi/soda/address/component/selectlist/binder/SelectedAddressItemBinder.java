package com.didi.soda.address.component.selectlist.binder;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.soda.address.component.feed.binder.AddressAnimUtil;
import com.didi.soda.address.component.feed.view.AddressItemViewHolder;
import com.didi.soda.address.component.selectlist.binder.SelectedAddressItemBinder;
import com.didi.soda.customer.foundation.rpc.entity.OrderAddressListEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.widget.cart.CustomerMaxCartAddressTagView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0011H&J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0011H&¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/address/component/selectlist/binder/SelectedAddressItemBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/address/component/selectlist/binder/SelectedAddressItemRvModel;", "Lcom/didi/soda/address/component/selectlist/binder/SelectedAddressItemBinder$ViewHolder;", "()V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "isAidSelected", "", "aid", "", "onEditClick", "address", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "isSelected", "onItemClick", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity;", "isCurrSelected", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SelectedAddressItemBinder.kt */
public abstract class SelectedAddressItemBinder extends ItemBinder<SelectedAddressItemRvModel, ViewHolder> {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SelectedAddressItemBinder.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TypeCorner.values().length];
            iArr[TypeCorner.ALL.ordinal()] = 1;
            iArr[TypeCorner.NONE.ordinal()] = 2;
            iArr[TypeCorner.BOTTOM.ordinal()] = 3;
            iArr[TypeCorner.TOP.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Class<SelectedAddressItemRvModel> bindDataType() {
        return SelectedAddressItemRvModel.class;
    }

    public abstract boolean isAidSelected(String str);

    public abstract void onEditClick(AddressEntity addressEntity, boolean z);

    public abstract void onItemClick(OrderAddressListEntity.AddrOptionStructEntity addrOptionStructEntity, boolean z);

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.customer_item_address_selection_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…tion_item, parent, false)");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, SelectedAddressItemRvModel selectedAddressItemRvModel) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(selectedAddressItemRvModel, "item");
        OrderAddressListEntity.AddrOptionStructEntity entity = selectedAddressItemRvModel.getEntity();
        viewHolder.itemView.setEnabled(entity.getDisable() == 0);
        CustomerMaxCartAddressTagView tagView = viewHolder.getTagView();
        OrderAddressListEntity.AddrOptionStructEntity.TagEntity addrTag = entity.getAddrTag();
        String str = null;
        CharSequence content = addrTag == null ? null : addrTag.getContent();
        int i3 = 8;
        if (content == null || content.length() == 0) {
            i = 8;
        } else {
            CustomerMaxCartAddressTagView tagView2 = viewHolder.getTagView();
            OrderAddressListEntity.AddrOptionStructEntity.TagEntity addrTag2 = entity.getAddrTag();
            tagView2.setText(addrTag2 == null ? null : addrTag2.getContent());
            i = 0;
        }
        tagView.setVisibility(i);
        TextView msgTv = viewHolder.getMsgTv();
        CharSequence disableTag = entity.getDisableTag();
        if (disableTag == null || disableTag.length() == 0) {
            i2 = 8;
        } else {
            viewHolder.getMsgTv().setText(entity.getDisableTag());
            i2 = 0;
        }
        msgTv.setVisibility(i2);
        AddressEntity address = entity.getAddress();
        if (address != null) {
            viewHolder.itemView.setSelected(isAidSelected(address.aid));
            viewHolder.getTitleTv().setText(address.getBusinessDepartPoi());
            viewHolder.getSubtitleTv().setText("");
            if (!TextUtils.isEmpty(address.name)) {
                String str2 = address.name;
                Intrinsics.checkNotNullExpressionValue(str2, "address.name");
                if (StringsKt.trim(str2).toString().length() > 0) {
                    viewHolder.getSubtitleTv().setText(Intrinsics.stringPlus(address.name, " "));
                }
            }
            TextView subtitleTv = viewHolder.getSubtitleTv();
            CharSequence text = viewHolder.getSubtitleTv().getText();
            if (text != null) {
                str = text.toString();
            }
            String str3 = address.phone;
            if (str3 == null) {
                str3 = "";
            }
            subtitleTv.setText(Intrinsics.stringPlus(str, str3));
            TextView subtitleTv2 = viewHolder.getSubtitleTv();
            if (!Intrinsics.areEqual((Object) viewHolder.getSubtitleTv().getText(), (Object) "")) {
                i3 = 0;
            }
            subtitleTv2.setVisibility(i3);
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[selectedAddressItemRvModel.getBgType().ordinal()];
        if (i4 == 1) {
            viewHolder.getDiv().setVisibility(4);
            viewHolder.itemView.setBackgroundResource(R.drawable.customer_selector_f0_top_bottom_12_corners);
        } else if (i4 == 2) {
            viewHolder.getDiv().setVisibility(0);
            viewHolder.itemView.setBackgroundResource(R.drawable.customer_selector_f0_12_corners);
        } else if (i4 == 3) {
            viewHolder.getDiv().setVisibility(4);
            viewHolder.itemView.setBackgroundResource(R.drawable.customer_selector_f0_bottom_12_corners);
        } else if (i4 == 4) {
            viewHolder.getDiv().setVisibility(0);
            viewHolder.itemView.setBackgroundResource(R.drawable.customer_selector_f0_top_12_corners);
        }
        viewHolder.getClickLayout().setOnClickListener(new View.OnClickListener(entity, viewHolder) {
            public final /* synthetic */ OrderAddressListEntity.AddrOptionStructEntity f$1;
            public final /* synthetic */ SelectedAddressItemBinder.ViewHolder f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                SelectedAddressItemBinder.m46721bind$lambda3$lambda1(SelectedAddressItemBinder.this, this.f$1, this.f$2, view);
            }
        });
        viewHolder.getMAddressEditView().setOnClickListener(new View.OnClickListener(entity, viewHolder) {
            public final /* synthetic */ OrderAddressListEntity.AddrOptionStructEntity f$1;
            public final /* synthetic */ SelectedAddressItemBinder.ViewHolder f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                SelectedAddressItemBinder.m46722bind$lambda3$lambda2(SelectedAddressItemBinder.this, this.f$1, this.f$2, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-3$lambda-1  reason: not valid java name */
    public static final void m46721bind$lambda3$lambda1(SelectedAddressItemBinder selectedAddressItemBinder, OrderAddressListEntity.AddrOptionStructEntity addrOptionStructEntity, ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(selectedAddressItemBinder, "this$0");
        Intrinsics.checkNotNullParameter(addrOptionStructEntity, "$entity");
        Intrinsics.checkNotNullParameter(viewHolder, "$this_apply");
        selectedAddressItemBinder.onItemClick(addrOptionStructEntity, viewHolder.itemView.isSelected());
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-3$lambda-2  reason: not valid java name */
    public static final void m46722bind$lambda3$lambda2(SelectedAddressItemBinder selectedAddressItemBinder, OrderAddressListEntity.AddrOptionStructEntity addrOptionStructEntity, ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(selectedAddressItemBinder, "this$0");
        Intrinsics.checkNotNullParameter(addrOptionStructEntity, "$entity");
        Intrinsics.checkNotNullParameter(viewHolder, "$this_apply");
        selectedAddressItemBinder.onEditClick(addrOptionStructEntity.getAddress(), viewHolder.itemView.isSelected());
    }

    @Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0016J(\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020+2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u000203H\u0016J\b\u00106\u001a\u00020)H\u0016J\b\u00107\u001a\u00020)H\u0016J\u0010\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020+H\u0002R\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\u0005R\u001a\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\u0005R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001b¨\u0006:"}, mo175978d2 = {"Lcom/didi/soda/address/component/selectlist/binder/SelectedAddressItemBinder$ViewHolder;", "Lcom/didi/soda/address/component/feed/view/AddressItemViewHolder;", "Lcom/didi/soda/address/component/selectlist/binder/SelectedAddressItemRvModel;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "clickLayout", "getClickLayout", "()Landroid/view/View;", "setClickLayout", "div", "getDiv", "setDiv", "mAddressEditView", "getMAddressEditView", "setMAddressEditView", "mAnimation", "Landroid/animation/ValueAnimator;", "getMAnimation", "()Landroid/animation/ValueAnimator;", "setMAnimation", "(Landroid/animation/ValueAnimator;)V", "msgTv", "Landroid/widget/TextView;", "getMsgTv", "()Landroid/widget/TextView;", "setMsgTv", "(Landroid/widget/TextView;)V", "subtitleTv", "getSubtitleTv", "setSubtitleTv", "tagView", "Lcom/didi/soda/customer/widget/cart/CustomerMaxCartAddressTagView;", "getTagView", "()Lcom/didi/soda/customer/widget/cart/CustomerMaxCartAddressTagView;", "setTagView", "(Lcom/didi/soda/customer/widget/cart/CustomerMaxCartAddressTagView;)V", "titleTv", "getTitleTv", "setTitleTv", "cancelAnimation", "", "getMaxMoveX", "", "getMoveDirections", "isInAnimation", "", "isMovable", "onMove", "horizontalDirection", "absMoveX", "", "verticalDirection", "absMoveY", "onMoveFinished", "onMoveIn", "startAnim", "dragStatus", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SelectedAddressItemBinder.kt */
    public static final class ViewHolder extends AddressItemViewHolder<SelectedAddressItemRvModel> {
        private View clickLayout;
        private View div;
        private View mAddressEditView;
        private ValueAnimator mAnimation;
        private TextView msgTv;
        private TextView subtitleTv;
        private CustomerMaxCartAddressTagView tagView;
        private TextView titleTv;

        public int getMoveDirections() {
            return 12;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Object findViewById = findViewById(R.id.customer_item_address_selection_tag);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…em_address_selection_tag)");
            this.tagView = (CustomerMaxCartAddressTagView) findViewById;
            Object findViewById2 = findViewById(R.id.customer_item_address_selection_title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…_address_selection_title)");
            this.titleTv = (TextView) findViewById2;
            Object findViewById3 = findViewById(R.id.customer_item_address_selection_subtitle);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…dress_selection_subtitle)");
            this.subtitleTv = (TextView) findViewById3;
            Object findViewById4 = findViewById(R.id.customer_item_address_selection_msg);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…em_address_selection_msg)");
            this.msgTv = (TextView) findViewById4;
            Object findViewById5 = findViewById(R.id.customer_item_address_selection_devi);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…m_address_selection_devi)");
            this.div = (View) findViewById5;
            Object findViewById6 = findViewById(R.id.customer_ib_address_edit);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_ib_address_edit)");
            this.mAddressEditView = (View) findViewById6;
            Object findViewById7 = findViewById(R.id.customer_item_address_selection_ck_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.custom…ress_selection_ck_layout)");
            this.clickLayout = (View) findViewById7;
        }

        public final CustomerMaxCartAddressTagView getTagView() {
            return this.tagView;
        }

        public final void setTagView(CustomerMaxCartAddressTagView customerMaxCartAddressTagView) {
            Intrinsics.checkNotNullParameter(customerMaxCartAddressTagView, "<set-?>");
            this.tagView = customerMaxCartAddressTagView;
        }

        public final TextView getTitleTv() {
            return this.titleTv;
        }

        public final void setTitleTv(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.titleTv = textView;
        }

        public final TextView getSubtitleTv() {
            return this.subtitleTv;
        }

        public final void setSubtitleTv(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.subtitleTv = textView;
        }

        public final TextView getMsgTv() {
            return this.msgTv;
        }

        public final void setMsgTv(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.msgTv = textView;
        }

        public final View getDiv() {
            return this.div;
        }

        public final void setDiv(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.div = view;
        }

        public final View getMAddressEditView() {
            return this.mAddressEditView;
        }

        public final void setMAddressEditView(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mAddressEditView = view;
        }

        public final ValueAnimator getMAnimation() {
            return this.mAnimation;
        }

        public final void setMAnimation(ValueAnimator valueAnimator) {
            this.mAnimation = valueAnimator;
        }

        public final View getClickLayout() {
            return this.clickLayout;
        }

        public final void setClickLayout(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.clickLayout = view;
        }

        public int getMaxMoveX() {
            return this.mAddressEditView.getWidth();
        }

        public boolean isMovable() {
            return super.isMovable() && !isInAnimation() && this.itemView.isEnabled();
        }

        public void onMove(int i, float f, int i2, float f2) {
            if (i != 4) {
                if (i == 8 && ((SelectedAddressItemRvModel) getItem()).isDragOut()) {
                    this.itemView.scrollTo(getMaxMoveX() - ((int) f), 0);
                }
            } else if (!((SelectedAddressItemRvModel) getItem()).isDragOut()) {
                this.itemView.scrollTo((int) f, 0);
            }
        }

        public void onMoveIn() {
            cancelAnimation();
            startAnim(0);
        }

        public void onMoveFinished() {
            int maxMoveX = getMaxMoveX();
            int scrollX = this.itemView.getScrollX();
            int i = 1;
            if (!((SelectedAddressItemRvModel) getItem()).isDragOut() ? scrollX <= maxMoveX / 8 : scrollX <= (maxMoveX * 7) / 8) {
                i = 0;
            }
            startAnim(i);
        }

        public final void cancelAnimation() {
            ValueAnimator valueAnimator;
            if (isInAnimation() && (valueAnimator = this.mAnimation) != null) {
                valueAnimator.cancel();
            }
        }

        private final void startAnim(int i) {
            ValueAnimator recoverAnimator = AddressAnimUtil.getRecoverAnimator(this.itemView, 300, i, getMaxMoveX(), new AddressAnimUtil.Callback() {
                public final void onSaveState(int i) {
                    SelectedAddressItemBinder.ViewHolder.m46724startAnim$lambda0(SelectedAddressItemBinder.ViewHolder.this, i);
                }
            });
            this.mAnimation = recoverAnimator;
            if (recoverAnimator != null) {
                recoverAnimator.start();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: startAnim$lambda-0  reason: not valid java name */
        public static final void m46724startAnim$lambda0(ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "this$0");
            ((SelectedAddressItemRvModel) viewHolder.getItem()).setMDragStatus(i);
        }

        private final boolean isInAnimation() {
            ValueAnimator valueAnimator = this.mAnimation;
            if (valueAnimator == null) {
                return false;
            }
            return valueAnimator.isRunning();
        }
    }
}
