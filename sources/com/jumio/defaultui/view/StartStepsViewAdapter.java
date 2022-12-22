package com.jumio.defaultui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u00182\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0018\u0019B\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0011\u001a\u00020\u00102\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, mo175978d2 = {"Lcom/jumio/defaultui/view/StartStepsViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jumio/defaultui/view/StartStepsViewAdapter$ViewHolder;", "Lcom/jumio/sdk/credentials/JumioCredentialCategory;", "type", "Landroid/content/Context;", "context", "", "getDescriptionForCategory", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "", "credentialCategoryList", "Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Companion", "ViewHolder", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: StartStepsViewAdapter.kt */
public final class StartStepsViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static String TAG = StartStepsViewAdapter.class.getSimpleName();
    private final List<JumioCredentialCategory> credentialCategoryList;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/defaultui/view/StartStepsViewAdapter$Companion;", "", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: StartStepsViewAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\r"}, mo175978d2 = {"Lcom/jumio/defaultui/view/StartStepsViewAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "categoryNumber", "Landroid/widget/TextView;", "getCategoryNumber", "()Landroid/widget/TextView;", "categoryDescription", "getCategoryDescription", "Landroid/view/View;", "view", "<init>", "(Lcom/jumio/defaultui/view/StartStepsViewAdapter;Landroid/view/View;)V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: StartStepsViewAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView categoryDescription;
        private final TextView categoryNumber;
        public final /* synthetic */ StartStepsViewAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(StartStepsViewAdapter startStepsViewAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(startStepsViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = startStepsViewAdapter;
            View findViewById = view.findViewById(R.id.item_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.item_icon)");
            this.categoryNumber = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.item_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.item_name)");
            this.categoryDescription = (TextView) findViewById2;
        }

        public final TextView getCategoryDescription() {
            return this.categoryDescription;
        }

        public final TextView getCategoryNumber() {
            return this.categoryNumber;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {}, mo175978d2 = {}, mo175979k = 3, mo175980mv = {1, 5, 1})
    /* compiled from: StartStepsViewAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JumioCredentialCategory.values().length];
            iArr[JumioCredentialCategory.ID.ordinal()] = 1;
            iArr[JumioCredentialCategory.DOCUMENT.ordinal()] = 2;
            iArr[JumioCredentialCategory.FACE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public StartStepsViewAdapter(List<? extends JumioCredentialCategory> list) {
        Intrinsics.checkNotNullParameter(list, "credentialCategoryList");
        this.credentialCategoryList = list;
    }

    private final String getDescriptionForCategory(JumioCredentialCategory jumioCredentialCategory, Context context) {
        int i = WhenMappings.$EnumSwitchMapping$0[jumioCredentialCategory.ordinal()];
        if (i == 1) {
            String string = context.getString(R.string.jumio_start_step_id);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.jumio_start_step_id)");
            return string;
        } else if (i == 2) {
            String string2 = context.getString(R.string.jumio_start_step_doc);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.jumio_start_step_doc)");
            return string2;
        } else if (i == 3) {
            String string3 = context.getString(R.string.jumio_start_step_identity);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…umio_start_step_identity)");
            return string3;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public int getItemCount() {
        return this.credentialCategoryList.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        viewHolder.getCategoryNumber().setText(String.valueOf(i + 1));
        TextView categoryDescription = viewHolder.getCategoryDescription();
        Context context = viewHolder.getCategoryDescription().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "holder.categoryDescription.context");
        categoryDescription.setText(getDescriptionForCategory(this.credentialCategoryList.get(i), context));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new ViewHolder(this, StartStepsViewAdapterKt.inflate(viewGroup, R.layout.fragment_start_item, false));
    }
}
