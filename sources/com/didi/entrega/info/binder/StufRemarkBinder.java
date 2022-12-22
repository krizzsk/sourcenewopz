package com.didi.entrega.info.binder;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.entrega.info.model.StuffRemarkModel;
import com.didi.rfusion.widget.RFEditText;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0017J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u0010\u001b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, mo175978d2 = {"Lcom/didi/entrega/info/binder/StufRemarkBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/info/model/StuffRemarkModel;", "Lcom/didi/entrega/info/binder/StufRemarkBinder$ViewHolder;", "()V", "clickListener", "Lcom/didi/entrega/info/binder/StufRemarkBinder$StuffRemarkCardClickListener;", "getClickListener", "()Lcom/didi/entrega/info/binder/StufRemarkBinder$StuffRemarkCardClickListener;", "setClickListener", "(Lcom/didi/entrega/info/binder/StufRemarkBinder$StuffRemarkCardClickListener;)V", "currentCount", "", "getCurrentCount", "()I", "setCurrentCount", "(I)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "canVerticalScroll", "", "contentEt", "Lcom/didi/rfusion/widget/RFEditText;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "StuffRemarkCardClickListener", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StufRemarkBinder.kt */
public final class StufRemarkBinder extends ItemBinder<StuffRemarkModel, ViewHolder> {

    /* renamed from: a */
    private StuffRemarkCardClickListener f20768a;

    /* renamed from: b */
    private int f20769b;

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/StufRemarkBinder$StuffRemarkCardClickListener;", "", "onRemarkTextChange", "", "item", "Lcom/didi/entrega/info/model/StuffRemarkModel;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StufRemarkBinder.kt */
    public interface StuffRemarkCardClickListener {
        void onRemarkTextChange(StuffRemarkModel stuffRemarkModel);
    }

    public Class<StuffRemarkModel> bindDataType() {
        return StuffRemarkModel.class;
    }

    public final StuffRemarkCardClickListener getClickListener() {
        return this.f20768a;
    }

    public final void setClickListener(StuffRemarkCardClickListener stuffRemarkCardClickListener) {
        this.f20768a = stuffRemarkCardClickListener;
    }

    public final int getCurrentCount() {
        return this.f20769b;
    }

    public final void setCurrentCount(int i) {
        this.f20769b = i;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.entrega_info_stuff_remark_binder, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…rk_binder, parent, false)");
        return new ViewHolder(this, inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        r3 = (r3 = r7.getStuffEntityData()).getPlaceHolder();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.didi.entrega.info.binder.StufRemarkBinder.ViewHolder r6, com.didi.entrega.info.model.StuffRemarkModel r7) {
        /*
            r5 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.view.View r6 = r6.itemView
            r0 = 2131430604(0x7f0b0ccc, float:1.8482914E38)
            android.view.View r1 = r6.findViewById(r0)
            com.didi.rfusion.widget.RFEditText r1 = (com.didi.rfusion.widget.RFEditText) r1
            java.lang.String r2 = ""
            if (r7 != 0) goto L_0x0018
        L_0x0014:
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            goto L_0x0028
        L_0x0018:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Remark r3 = r7.getStuffEntityData()
            if (r3 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            java.lang.String r3 = r3.getPlaceHolder()
            if (r3 != 0) goto L_0x0026
            goto L_0x0014
        L_0x0026:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
        L_0x0028:
            r1.setHint(r3)
            r1 = 0
            if (r7 != 0) goto L_0x0030
        L_0x002e:
            r3 = 0
            goto L_0x0042
        L_0x0030:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Remark r3 = r7.getStuffEntityData()
            if (r3 != 0) goto L_0x0037
            goto L_0x002e
        L_0x0037:
            java.lang.String r3 = r3.getContent()
            if (r3 != 0) goto L_0x003e
            goto L_0x002e
        L_0x003e:
            int r3 = r3.length()
        L_0x0042:
            r5.setCurrentCount(r3)
            android.view.View r3 = r6.findViewById(r0)
            com.didi.rfusion.widget.RFEditText r3 = (com.didi.rfusion.widget.RFEditText) r3
            com.didi.entrega.info.binder.StufRemarkBinder$bind$1$1 r4 = new com.didi.entrega.info.binder.StufRemarkBinder$bind$1$1
            r4.<init>(r7, r5, r6)
            android.text.TextWatcher r4 = (android.text.TextWatcher) r4
            r3.addTextChangedListener(r4)
            r3 = 0
            if (r7 != 0) goto L_0x0059
            goto L_0x0074
        L_0x0059:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Remark r4 = r7.getStuffEntityData()
            if (r4 != 0) goto L_0x0060
            goto L_0x0074
        L_0x0060:
            java.lang.String r4 = r4.getContent()
            if (r4 != 0) goto L_0x0067
            goto L_0x0074
        L_0x0067:
            android.view.View r3 = r6.findViewById(r0)
            com.didi.rfusion.widget.RFEditText r3 = (com.didi.rfusion.widget.RFEditText) r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0074:
            if (r3 != 0) goto L_0x0082
            android.view.View r3 = r6.findViewById(r0)
            com.didi.rfusion.widget.RFEditText r3 = (com.didi.rfusion.widget.RFEditText) r3
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
        L_0x0082:
            android.view.View r3 = r6.findViewById(r0)
            com.didi.rfusion.widget.RFEditText r3 = (com.didi.rfusion.widget.RFEditText) r3
            android.view.View r4 = r6.findViewById(r0)
            com.didi.rfusion.widget.RFEditText r4 = (com.didi.rfusion.widget.RFEditText) r4
            android.text.Editable r4 = r4.getText()
            if (r4 != 0) goto L_0x0095
            goto L_0x0099
        L_0x0095:
            int r1 = r4.length()
        L_0x0099:
            r3.setSelection(r1)
            android.view.View r0 = r6.findViewById(r0)
            com.didi.rfusion.widget.RFEditText r0 = (com.didi.rfusion.widget.RFEditText) r0
            com.didi.entrega.info.binder.-$$Lambda$StufRemarkBinder$ZGta8oSO64gLiWmBq_KRpGbyc24 r1 = new com.didi.entrega.info.binder.-$$Lambda$StufRemarkBinder$ZGta8oSO64gLiWmBq_KRpGbyc24
            r1.<init>(r5)
            r0.setOnTouchListener(r1)
            r0 = 2131435390(0x7f0b1f7e, float:1.849262E38)
            android.view.View r0 = r6.findViewById(r0)
            com.didi.entrega.customer.widget.text.RichTextView r0 = (com.didi.entrega.customer.widget.text.RichTextView) r0
            if (r7 != 0) goto L_0x00b8
        L_0x00b5:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x00c9
        L_0x00b8:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Remark r7 = r7.getStuffEntityData()
            if (r7 != 0) goto L_0x00bf
            goto L_0x00b5
        L_0x00bf:
            java.lang.String r7 = r7.getTitle()
            if (r7 != 0) goto L_0x00c6
            goto L_0x00b5
        L_0x00c6:
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x00c9:
            r0.setText(r2)
            r7 = 2131435374(0x7f0b1f6e, float:1.8492588E38)
            android.view.View r6 = r6.findViewById(r7)
            com.didi.entrega.customer.widget.text.RichTextView r6 = (com.didi.entrega.customer.widget.text.RichTextView) r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r0 = r5.getCurrentCount()
            r7.append(r0)
            java.lang.String r0 = "/200"
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.binder.StufRemarkBinder.bind(com.didi.entrega.info.binder.StufRemarkBinder$ViewHolder, com.didi.entrega.info.model.StuffRemarkModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m15183a(View view, StufRemarkBinder stufRemarkBinder, View view2, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "$this_with");
        Intrinsics.checkNotNullParameter(stufRemarkBinder, "this$0");
        if (view2.getId() == ((RFEditText) view.findViewById(R.id.etv_remark)).getId()) {
            RFEditText rFEditText = (RFEditText) view.findViewById(R.id.etv_remark);
            Intrinsics.checkNotNullExpressionValue(rFEditText, "etv_remark");
            if (stufRemarkBinder.m15184a(rFEditText)) {
                view2.getParent().requestDisallowInterceptTouchEvent(true);
                if (motionEvent.getAction() == 1) {
                    view2.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private final boolean m15184a(RFEditText rFEditText) {
        int scrollY = rFEditText.getScrollY();
        int height = rFEditText.getLayout().getHeight() - ((rFEditText.getHeight() - rFEditText.getCompoundPaddingTop()) - rFEditText.getCompoundPaddingBottom());
        if (height == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height - 1;
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/StufRemarkBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/info/model/StuffRemarkModel;", "rootView", "Landroid/view/View;", "(Lcom/didi/entrega/info/binder/StufRemarkBinder;Landroid/view/View;)V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StufRemarkBinder.kt */
    public final class ViewHolder extends ItemViewHolder<StuffRemarkModel> {
        final /* synthetic */ StufRemarkBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(StufRemarkBinder stufRemarkBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(stufRemarkBinder, "this$0");
            Intrinsics.checkNotNullParameter(view, "rootView");
            this.this$0 = stufRemarkBinder;
        }
    }
}
