package com.didi.component.substitute.call.widget;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.component.common.widget.CircleImageView;
import com.didi.component.substitute.call.contacts.HistoryItemCallback;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\tJ\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/component/substitute/call/widget/FriendItemVH;", "Lcom/didi/component/substitute/call/widget/BaseVH;", "Lcom/didi/travel/psnger/model/response/estimate/daijiao/FriendItem;", "itemView", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/view/View;Landroid/content/Context;)V", "mCallback", "Lcom/didi/component/substitute/call/contacts/HistoryItemCallback;", "mContext", "scContactName", "Landroid/widget/TextView;", "scContactSelectBtn", "Landroid/widget/CheckBox;", "scPortrait", "Lcom/didi/component/common/widget/CircleImageView;", "bindData", "", "data", "setCallback", "callback", "updateViewByCheckStatus", "checked", "", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FriendItemVH.kt */
public final class FriendItemVH extends BaseVH<FriendItem> {

    /* renamed from: a */
    private Context f16102a;

    /* renamed from: b */
    private CircleImageView f16103b;

    /* renamed from: c */
    private TextView f16104c;

    /* renamed from: d */
    private CheckBox f16105d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public HistoryItemCallback f16106e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FriendItemVH(View view, Context context) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.f16102a = context;
        this.f16103b = (CircleImageView) view.findViewById(R.id.substitute_call_portrait);
        this.f16104c = (TextView) view.findViewById(R.id.substitute_call_contact_name);
        this.f16105d = (CheckBox) view.findViewById(R.id.substitute_call_contact_select_btn);
    }

    public final void setCallback(HistoryItemCallback historyItemCallback) {
        Intrinsics.checkNotNullParameter(historyItemCallback, "callback");
        this.f16106e = historyItemCallback;
    }

    public void bindData(FriendItem friendItem) {
        CircleImageView circleImageView;
        Intrinsics.checkNotNullParameter(friendItem, "data");
        Context context = this.f16102a;
        if (!(context == null || (circleImageView = this.f16103b) == null)) {
            Glide.with(context).load(friendItem.getPortrait()).into((ImageView) circleImageView);
        }
        TextView textView = this.f16104c;
        if (textView != null) {
            textView.setText(friendItem.getName());
        }
        CheckBox checkBox = this.f16105d;
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        CheckBox checkBox2 = this.f16105d;
        boolean z = false;
        if (checkBox2 != null) {
            checkBox2.setClickable(false);
        }
        if (friendItem.isSelected() == 1) {
            z = true;
        }
        m11805a(z);
        this.itemView.setOnClickListener(new FriendItemVH$bindData$2(this, friendItem));
        this.itemView.setOnLongClickListener(new FriendItemVH$bindData$3(this, friendItem));
    }

    /* renamed from: a */
    private final void m11805a(boolean z) {
        CheckBox checkBox = this.f16105d;
        if (checkBox != null) {
            checkBox.setChecked(z);
        }
    }
}
