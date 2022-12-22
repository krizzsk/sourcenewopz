package com.jumio.defaultui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.jumio.core.data.country.Country;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioDocumentType;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p001a.C0010a;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016R\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, mo175978d2 = {"Lcom/jumio/defaultui/view/DocumentSelectionFragment;", "Lcom/jumio/defaultui/view/BaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/jumio/sdk/document/JumioDocumentType;", "documentType", "", "adapterOnClick", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "createLayout", "onResume", "onDestroyView", "v", "onClick", "La/a;", "jumioViewModel$delegate", "Lkotlin/Lazy;", "getJumioViewModel", "()La/a;", "jumioViewModel", "selectedDocumentType", "Lcom/jumio/sdk/document/JumioDocumentType;", "Lcom/jumio/defaultui/view/JumioBottomSheet;", "bottomSheet", "Lcom/jumio/defaultui/view/JumioBottomSheet;", "Landroidx/appcompat/widget/AppCompatTextView;", "tvCountrySelection", "Landroidx/appcompat/widget/AppCompatTextView;", "<init>", "()V", "Companion", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: DocumentSelectionFragment.kt */
public final class DocumentSelectionFragment extends BaseFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static String TAG = DocumentSelectionFragment.class.getSimpleName();
    private JumioBottomSheet bottomSheet;
    private final Lazy jumioViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, C21490Reflection.getOrCreateKotlinClass(C0010a.class), new C20072x73e5b777(this), new C20073x73e5b778(this));
    private JumioDocumentType selectedDocumentType;
    private AppCompatTextView tvCountrySelection;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/defaultui/view/DocumentSelectionFragment$Companion;", "", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: DocumentSelectionFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: com.jumio.defaultui.view.DocumentSelectionFragment$a */
    /* compiled from: DocumentSelectionFragment.kt */
    public static final class C20071a extends Lambda implements Function1<JumioDocumentType, Unit> {

        /* renamed from: a */
        public final /* synthetic */ DocumentSelectionFragment f55034a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C20071a(DocumentSelectionFragment documentSelectionFragment) {
            super(1);
            this.f55034a = documentSelectionFragment;
        }

        /* renamed from: a */
        public final void mo163284a(JumioDocumentType jumioDocumentType) {
            this.f55034a.adapterOnClick(jumioDocumentType);
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163284a((JumioDocumentType) obj);
            return Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = r0.getCountries();
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void adapterOnClick(com.jumio.sdk.document.JumioDocumentType r11) {
        /*
            r10 = this;
            a.a r0 = r10.getJumioViewModel()
            com.jumio.sdk.credentials.JumioCredential r0 = r0.mo44g()
            com.jumio.sdk.credentials.JumioIDCredential r0 = (com.jumio.sdk.credentials.JumioIDCredential) r0
            r1 = 0
            if (r0 != 0) goto L_0x000e
            goto L_0x0014
        L_0x000e:
            java.util.Map r0 = r0.getCountries()
            if (r0 != 0) goto L_0x0016
        L_0x0014:
            r0 = r1
            goto L_0x0024
        L_0x0016:
            a.a r2 = r10.getJumioViewModel()
            java.lang.String r2 = r2.mo51n()
            java.lang.Object r0 = r0.get(r2)
            java.util.List r0 = (java.util.List) r0
        L_0x0024:
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0029
            goto L_0x004b
        L_0x0029:
            java.util.Iterator r4 = r0.iterator()
        L_0x002d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0046
            java.lang.Object r5 = r4.next()
            r6 = r5
            com.jumio.sdk.document.JumioDocument r6 = (com.jumio.sdk.document.JumioDocument) r6
            com.jumio.sdk.document.JumioDocumentType r6 = r6.getType()
            if (r6 != r11) goto L_0x0042
            r6 = 1
            goto L_0x0043
        L_0x0042:
            r6 = 0
        L_0x0043:
            if (r6 == 0) goto L_0x002d
            goto L_0x0047
        L_0x0046:
            r5 = r1
        L_0x0047:
            com.jumio.sdk.document.JumioDocument r5 = (com.jumio.sdk.document.JumioDocument) r5
            if (r5 != 0) goto L_0x004d
        L_0x004b:
            r4 = r1
            goto L_0x0051
        L_0x004d:
            com.jumio.sdk.document.JumioDocumentType r4 = r5.getType()
        L_0x0051:
            r10.selectedDocumentType = r4
            if (r0 == 0) goto L_0x0138
            if (r4 == 0) goto L_0x0138
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x005f
            r5 = 0
            goto L_0x0085
        L_0x005f:
            java.util.Iterator r4 = r0.iterator()
            r5 = 0
        L_0x0064:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0085
            java.lang.Object r6 = r4.next()
            com.jumio.sdk.document.JumioDocument r6 = (com.jumio.sdk.document.JumioDocument) r6
            com.jumio.sdk.document.JumioDocumentType r6 = r6.getType()
            com.jumio.sdk.document.JumioDocumentType r7 = r10.selectedDocumentType
            if (r6 != r7) goto L_0x007a
            r6 = 1
            goto L_0x007b
        L_0x007a:
            r6 = 0
        L_0x007b:
            if (r6 == 0) goto L_0x0064
            int r5 = r5 + 1
            if (r5 >= 0) goto L_0x0064
            kotlin.collections.CollectionsKt.throwCountOverflow()
            goto L_0x0064
        L_0x0085:
            if (r5 <= r2) goto L_0x0101
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            androidx.fragment.app.FragmentActivity r2 = r10.getActivity()
            if (r2 != 0) goto L_0x0093
            goto L_0x00a4
        L_0x0093:
            android.view.WindowManager r2 = r2.getWindowManager()
            if (r2 != 0) goto L_0x009a
            goto L_0x00a4
        L_0x009a:
            android.view.Display r2 = r2.getDefaultDisplay()
            if (r2 != 0) goto L_0x00a1
            goto L_0x00a4
        L_0x00a1:
            r2.getMetrics(r0)
        L_0x00a4:
            android.content.Context r0 = r10.getContext()
            if (r0 == 0) goto L_0x0138
            com.jumio.defaultui.view.VariantBottomSheet$Companion r2 = com.jumio.defaultui.view.VariantBottomSheet.Companion
            com.jumio.sdk.document.JumioDocumentType r3 = r10.selectedDocumentType
            android.content.Context r0 = r10.getContext()
            if (r0 != 0) goto L_0x00b6
            r0 = r1
            goto L_0x00bd
        L_0x00b6:
            r4 = 2131955962(0x7f1310fa, float:1.9548466E38)
            java.lang.String r0 = r0.getString(r4)
        L_0x00bd:
            java.lang.String r4 = ""
            if (r0 != 0) goto L_0x00c2
            r0 = r4
        L_0x00c2:
            r5 = 0
            android.content.Context r6 = r10.getContext()
            if (r6 != 0) goto L_0x00cb
            r6 = r1
            goto L_0x00d2
        L_0x00cb:
            r7 = 2131955961(0x7f1310f9, float:1.9548464E38)
            java.lang.String r6 = r6.getString(r7)
        L_0x00d2:
            if (r6 != 0) goto L_0x00d5
            r6 = r4
        L_0x00d5:
            android.content.Context r7 = r10.getContext()
            if (r7 != 0) goto L_0x00dd
            r7 = r1
            goto L_0x00e4
        L_0x00dd:
            r8 = 2131955960(0x7f1310f8, float:1.9548462E38)
            java.lang.String r7 = r7.getString(r8)
        L_0x00e4:
            if (r7 != 0) goto L_0x00e7
            r7 = r4
        L_0x00e7:
            r8 = 4
            r9 = 0
            r4 = r0
            com.jumio.defaultui.view.VariantBottomSheet r0 = com.jumio.defaultui.view.VariantBottomSheet.Companion.newInstance$default(r2, r3, r4, r5, r6, r7, r8, r9)
            r10.bottomSheet = r0
            if (r0 != 0) goto L_0x00f3
            goto L_0x0138
        L_0x00f3:
            androidx.fragment.app.FragmentActivity r2 = r10.requireActivity()
            androidx.fragment.app.FragmentManager r2 = r2.getSupportFragmentManager()
            java.lang.String r3 = "dialog"
            r0.show((androidx.fragment.app.FragmentManager) r2, (java.lang.String) r3)
            goto L_0x0138
        L_0x0101:
            android.content.Context r4 = r10.getContext()
            if (r4 == 0) goto L_0x0138
            if (r11 == 0) goto L_0x0138
            a.a r4 = r10.getJumioViewModel()
            a.a r5 = r10.getJumioViewModel()
            java.lang.String r5 = r5.mo51n()
            java.util.Iterator r0 = r0.iterator()
        L_0x0119:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0132
            java.lang.Object r6 = r0.next()
            r7 = r6
            com.jumio.sdk.document.JumioDocument r7 = (com.jumio.sdk.document.JumioDocument) r7
            com.jumio.sdk.document.JumioDocumentType r7 = r7.getType()
            if (r7 != r11) goto L_0x012e
            r7 = 1
            goto L_0x012f
        L_0x012e:
            r7 = 0
        L_0x012f:
            if (r7 == 0) goto L_0x0119
            goto L_0x0133
        L_0x0132:
            r6 = r1
        L_0x0133:
            com.jumio.sdk.document.JumioDocument r6 = (com.jumio.sdk.document.JumioDocument) r6
            r4.mo28a((java.lang.String) r5, (com.jumio.sdk.document.JumioDocument) r6)
        L_0x0138:
            java.lang.String r0 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onClick: document "
            r2.append(r3)
            if (r11 != 0) goto L_0x0147
            goto L_0x014b
        L_0x0147:
            java.lang.String r1 = r11.name()
        L_0x014b:
            r2.append(r1)
            java.lang.String r11 = " triggered"
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            com.jumio.commons.log.Log.m39456d((java.lang.String) r0, (java.lang.String) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.DocumentSelectionFragment.adapterOnClick(com.jumio.sdk.document.JumioDocumentType):void");
    }

    private final C0010a getJumioViewModel() {
        return (C0010a) this.jumioViewModel$delegate.getValue();
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_document_selection, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_document_list);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.layout_country_selection);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.item_arrow);
        JumioCredential g = getJumioViewModel().mo44g();
        if (g != null) {
            Map<String, List<JumioDocument>> countries = ((JumioIDCredential) g).getCountries();
            this.tvCountrySelection = (AppCompatTextView) inflate.findViewById(R.id.tv_country_selection_value);
            ArrayList arrayList = null;
            if (getJumioViewModel().mo51n().length() > 0) {
                AppCompatTextView appCompatTextView = this.tvCountrySelection;
                if (appCompatTextView != null) {
                    appCompatTextView.setText(new Country(getJumioViewModel().mo51n(), false, 2, (DefaultConstructorMarker) null).getName());
                }
            } else {
                AppCompatTextView appCompatTextView2 = this.tvCountrySelection;
                if (appCompatTextView2 != null) {
                    Map.Entry entry = (Map.Entry) CollectionsKt.firstOrNull(countries.entrySet());
                    if (entry == null || (str = (String) entry.getKey()) == null) {
                        str = "USA";
                    }
                    appCompatTextView2.setText(new Country(str, false, 2, (DefaultConstructorMarker) null).getName());
                }
            }
            if (countries.size() > 1) {
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                linearLayout.setOnClickListener(this);
            } else if (imageView != null) {
                imageView.setVisibility(8);
            }
            if ((getJumioViewModel().mo44g() instanceof JumioIDCredential) && getContext() != null) {
                List list = countries.get(getJumioViewModel().mo51n());
                if (list != null) {
                    HashSet hashSet = new HashSet();
                    ArrayList<JumioDocument> arrayList2 = new ArrayList<>();
                    for (Object next : list) {
                        if (hashSet.add(((JumioDocument) next).getType())) {
                            arrayList2.add(next);
                        }
                    }
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    for (JumioDocument type : arrayList2) {
                        arrayList.add(type.getType());
                    }
                }
                if (recyclerView != null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                    recyclerView.setAdapter(new DocumentSelectionAdapter(arrayList, new C20071a(this)));
                }
            }
            return inflate;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.jumio.sdk.credentials.JumioIDCredential");
    }

    public void onClick(View view) {
        JumioFragmentCallback callback;
        AutoTrackHelper.trackViewOnClick(view);
        if ((view != null && view.getId() == R.id.layout_country_selection) && (callback = getCallback()) != null) {
            callback.startCountrySelection();
        }
    }

    public void onDestroyView() {
        this.bottomSheet = null;
        this.tvCountrySelection = null;
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        AppCompatTextView appCompatTextView = this.tvCountrySelection;
        if (appCompatTextView != null) {
            appCompatTextView.setText(new Country(getJumioViewModel().mo51n(), false, 2, (DefaultConstructorMarker) null).getName());
        }
    }
}
