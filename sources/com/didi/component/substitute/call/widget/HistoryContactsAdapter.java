package com.didi.component.substitute.call.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.substitute.call.contacts.HistoryItemCallback;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/component/substitute/call/widget/HistoryContactsAdapter;", "Lcom/didi/component/substitute/call/widget/BaseAdapter;", "Lcom/didi/travel/psnger/model/response/estimate/daijiao/FriendItem;", "Lcom/didi/component/substitute/call/widget/FriendItemVH;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mCallback", "Lcom/didi/component/substitute/call/contacts/HistoryItemCallback;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallback", "callback", "setCallback$comp_substitute_call_release", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HistoryContactsAdapter.kt */
public final class HistoryContactsAdapter extends BaseAdapter<FriendItem, FriendItemVH> {

    /* renamed from: a */
    private final Context f16107a;

    /* renamed from: b */
    private HistoryItemCallback f16108b;

    public HistoryContactsAdapter(Context context) {
        this.f16107a = context;
    }

    public FriendItemVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.substitute_contacts_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…acts_item, parent, false)");
        return new FriendItemVH(inflate, this.f16107a);
    }

    public void onBindViewHolder(FriendItemVH friendItemVH, int i) {
        Intrinsics.checkNotNullParameter(friendItemVH, "holder");
        super.onBindViewHolder(friendItemVH, i);
        HistoryItemCallback historyItemCallback = this.f16108b;
        if (historyItemCallback != null) {
            friendItemVH.setCallback(historyItemCallback);
        }
    }

    public final void setCallback$comp_substitute_call_release(HistoryItemCallback historyItemCallback) {
        Intrinsics.checkNotNullParameter(historyItemCallback, "callback");
        this.f16108b = historyItemCallback;
    }
}
