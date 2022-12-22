package com.didi.component.substitute.call.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000ej\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\u000fX\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/component/substitute/call/adapter/IntroducesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/component/substitute/call/adapter/IntroducesHold;", "context", "Landroid/content/Context;", "list", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "mContext", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IntroducesAdapter.kt */
public final class IntroducesAdapter extends RecyclerView.Adapter<IntroducesHold> {

    /* renamed from: a */
    private Context f16032a;

    /* renamed from: b */
    private List<String> f16033b;

    /* renamed from: c */
    private ArrayList<String> f16034c;

    /* renamed from: d */
    private Context f16035d = this.f16032a;

    public IntroducesAdapter(Context context, List<String> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        this.f16032a = context;
        this.f16033b = list;
        ArrayList<String> arrayList = new ArrayList<>();
        this.f16034c = arrayList;
        arrayList.addAll(this.f16033b);
    }

    public final Context getContext() {
        return this.f16032a;
    }

    public final List<String> getList() {
        return this.f16033b;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.f16032a = context;
    }

    public final void setList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f16033b = list;
    }

    public IntroducesHold onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f16035d).inflate(R.layout.introduction_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mContext).inflate(R…tion_item, parent, false)");
        return new IntroducesHold(inflate);
    }

    public void onBindViewHolder(IntroducesHold introducesHold, int i) {
        Intrinsics.checkNotNullParameter(introducesHold, "holder");
        String str = this.f16034c.get(i);
        if (str != null) {
            introducesHold.getMtv().setText(str);
        }
    }

    public int getItemCount() {
        return this.f16034c.size();
    }
}
