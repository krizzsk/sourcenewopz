package com.jumio.defaultui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.jumio.commons.log.Log;
import com.jumio.sdk.document.JumioDocumentType;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001b\u001cB-\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\r0\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\n\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u001c\u0010\u000e\u001a\u00020\r2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R'\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\r0\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, mo175978d2 = {"Lcom/jumio/defaultui/view/DocumentSelectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jumio/defaultui/view/DocumentSelectionAdapter$ViewHolder;", "Lcom/jumio/sdk/document/JumioDocumentType;", "type", "", "getIconForDocumentType", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemViewType", "getItemCount", "", "documentTypes", "Ljava/util/List;", "Lkotlin/Function1;", "onclick", "Lkotlin/jvm/functions/Function1;", "getOnclick", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Companion", "ViewHolder", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: DocumentSelectionAdapter.kt */
public final class DocumentSelectionAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static String TAG = DocumentSelectionAdapter.class.getSimpleName();
    private final List<JumioDocumentType> documentTypes;
    private final Function1<JumioDocumentType, Unit> onclick;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/defaultui/view/DocumentSelectionAdapter$Companion;", "", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: DocumentSelectionAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R'\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00070\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0015\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, mo175978d2 = {"Lcom/jumio/defaultui/view/DocumentSelectionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "", "toString", "Landroid/view/View;", "v", "", "onClick", "Lkotlin/Function1;", "Lcom/jumio/sdk/document/JumioDocumentType;", "onclick", "Lkotlin/jvm/functions/Function1;", "getOnclick", "()Lkotlin/jvm/functions/Function1;", "Landroid/widget/TextView;", "documentName", "Landroid/widget/TextView;", "getDocumentName", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "documentIcon", "Landroid/widget/ImageView;", "getDocumentIcon", "()Landroid/widget/ImageView;", "view", "<init>", "(Lcom/jumio/defaultui/view/DocumentSelectionAdapter;Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: DocumentSelectionAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView documentIcon;
        private final TextView documentName;
        private final Function1<JumioDocumentType, Unit> onclick;
        public final /* synthetic */ DocumentSelectionAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(DocumentSelectionAdapter documentSelectionAdapter, View view, Function1<? super JumioDocumentType, Unit> function1) {
            super(view);
            Intrinsics.checkNotNullParameter(documentSelectionAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(function1, "onclick");
            this.this$0 = documentSelectionAdapter;
            this.onclick = function1;
            View findViewById = view.findViewById(R.id.item_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.item_name)");
            this.documentName = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.item_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.item_icon)");
            this.documentIcon = (ImageView) findViewById2;
            view.setOnClickListener(this);
        }

        public final ImageView getDocumentIcon() {
            return this.documentIcon;
        }

        public final TextView getDocumentName() {
            return this.documentName;
        }

        public final Function1<JumioDocumentType, Unit> getOnclick() {
            return this.onclick;
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            CharSequence text = this.documentName.getText();
            if (!(text == null || text.length() == 0)) {
                Function1<JumioDocumentType, Unit> function1 = this.onclick;
                JumioDocumentType.Companion companion = JumioDocumentType.Companion;
                String obj = this.documentName.getText().toString();
                Context context = this.documentName.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "documentName.context");
                function1.invoke(companion.fromLocalizedName(obj, context));
            }
            Log.m39456d(DocumentSelectionAdapter.TAG, "Click received");
        }

        public String toString() {
            return super.toString() + " '" + this.documentName.getText() + '\'';
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {}, mo175978d2 = {}, mo175979k = 3, mo175980mv = {1, 5, 1})
    /* compiled from: DocumentSelectionAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JumioDocumentType.values().length];
            iArr[JumioDocumentType.PASSPORT.ordinal()] = 1;
            iArr[JumioDocumentType.DRIVING_LICENSE.ordinal()] = 2;
            iArr[JumioDocumentType.ID_CARD.ordinal()] = 3;
            iArr[JumioDocumentType.VISA.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DocumentSelectionAdapter(List<? extends JumioDocumentType> list, Function1<? super JumioDocumentType, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onclick");
        this.documentTypes = list;
        this.onclick = function1;
    }

    private final int getIconForDocumentType(JumioDocumentType jumioDocumentType) {
        int i = WhenMappings.$EnumSwitchMapping$0[jumioDocumentType.ordinal()];
        if (i == 1) {
            return R.drawable.jumio_ic_passport;
        }
        if (i == 2) {
            return R.drawable.jumio_ic_driver_license;
        }
        if (i == 3) {
            return R.drawable.jumio_ic_id_card;
        }
        if (i == 4) {
            return R.drawable.jumio_ic_visa;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int getItemCount() {
        List<JumioDocumentType> list = this.documentTypes;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getItemViewType(int i) {
        List<JumioDocumentType> list = this.documentTypes;
        if (list != null && list.size() == 1) {
            return 2;
        }
        if (i == 0) {
            return -1;
        }
        List<JumioDocumentType> list2 = this.documentTypes;
        if (list2 != null && i == CollectionsKt.getLastIndex(list2)) {
            return 1;
        }
        return 0;
    }

    public final Function1<JumioDocumentType, Unit> getOnclick() {
        return this.onclick;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        List<JumioDocumentType> list = this.documentTypes;
        if (list != null) {
            JumioDocumentType jumioDocumentType = list.get(i);
            TextView documentName = viewHolder.getDocumentName();
            Context context = viewHolder.getDocumentName().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "holder.documentName.context");
            documentName.setText(jumioDocumentType.getLocalizedName(context));
            viewHolder.getDocumentIcon().setImageResource(getIconForDocumentType(jumioDocumentType));
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View access$inflate = DocumentSelectionAdapterKt.inflate(viewGroup, R.layout.fragment_document_selection_item, false);
        int i2 = R.drawable.jumio_list_item;
        if (i == -1) {
            i2 = R.drawable.jumio_rounded_top_list_item;
        } else if (i != 0) {
            if (i == 1) {
                i2 = R.drawable.jumio_rounded_bottom_list_item;
            } else if (i == 2) {
                i2 = R.drawable.jumio_rounded_list_item;
            }
        }
        access$inflate.setBackgroundResource(i2);
        return new ViewHolder(this, access$inflate, this.onclick);
    }
}
