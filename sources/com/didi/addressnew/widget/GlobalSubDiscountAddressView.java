package com.didi.addressnew.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.view.enhance.DiscountAddressItemEnhancer;
import com.didi.addressnew.widget.SubAddressViewApi;
import com.didi.map.global.component.departure.view.RichTextInfo;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ6\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0012\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u001aH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/addressnew/widget/GlobalSubDiscountAddressView;", "Landroid/widget/LinearLayout;", "Lcom/didi/addressnew/widget/SubAddressViewApi;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enhancer", "Lcom/didi/addressnew/view/enhance/DiscountAddressItemEnhancer;", "firstItem", "Landroid/view/ViewGroup;", "mAddresses", "Ljava/util/ArrayList;", "Lcom/sdk/poibase/model/RpcPoi;", "mListener", "Lcom/didi/addressnew/widget/SubAddressViewApi$OnItemClickListener;", "root", "Landroid/view/View;", "fillData", "", "parent", "discountPois", "isVisible", "", "trackParams", "Lcom/sdk/poibase/model/recsug/RpcRecSug$TrackParameterForChild;", "Lcom/sdk/poibase/model/recsug/RpcRecSug;", "initView", "setOnItemClickLister", "listener", "setVisble", "visble", "global_sug_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalSubDiscountAddressView.kt */
public final class GlobalSubDiscountAddressView extends LinearLayout implements SubAddressViewApi {

    /* renamed from: a */
    private View f7667a;

    /* renamed from: b */
    private ViewGroup f7668b;

    /* renamed from: c */
    private ArrayList<RpcPoi> f7669c;

    /* renamed from: d */
    private final DiscountAddressItemEnhancer f7670d;

    /* renamed from: e */
    private SubAddressViewApi.OnItemClickListener f7671e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GlobalSubDiscountAddressView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GlobalSubDiscountAddressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalSubDiscountAddressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalSubDiscountAddressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        m4849a();
        this.f7670d = new DiscountAddressItemEnhancer();
    }

    /* renamed from: a */
    private final void m4849a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.poi_one_address_lowprice_poi, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.layout.poi_one_address_lowprice_poi, this)");
        this.f7667a = inflate;
        if (inflate != null) {
            View findViewById = inflate.findViewById(R.id.first_lowprice_item);
            Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.first_lowprice_item)");
            this.f7668b = (ViewGroup) findViewById;
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        throw null;
    }

    public void setVisble(boolean z) {
        View view = this.f7667a;
        if (view != null) {
            view.setVisibility(z ? 0 : 4);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            throw null;
        }
    }

    public void fillData(RpcPoi rpcPoi, ArrayList<RpcPoi> arrayList, boolean z, RpcRecSug.TrackParameterForChild trackParameterForChild) {
        ArrayList<RpcPoi> arrayList2 = arrayList;
        RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
        Intrinsics.checkNotNullParameter(trackParameterForChild2, "trackParams");
        this.f7669c = arrayList2;
        if (arrayList2 == null || arrayList.size() == 0 || !z) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ArrayList arrayList3 = new ArrayList();
        ViewGroup viewGroup = this.f7668b;
        if (viewGroup != null) {
            arrayList3.add(viewGroup);
            int size = arrayList3.size();
            int size2 = arrayList.size();
            if (size > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    ViewGroup viewGroup2 = (ViewGroup) arrayList3.get(i);
                    if (i <= size2 - 1) {
                        RpcPoi rpcPoi2 = arrayList2.get(i);
                        Intrinsics.checkNotNullExpressionValue(rpcPoi2, "discountPois[i]");
                        RpcPoi rpcPoi3 = rpcPoi2;
                        Intrinsics.checkNotNull(viewGroup2);
                        View findViewById = viewGroup2.findViewById(R.id.lowprice_poi_main_title);
                        if (findViewById != null) {
                            ((TextView) findViewById).setText(rpcPoi3.extend_info != null ? rpcPoi3.extend_info.title_tip : "");
                            viewGroup2.setVisibility(0);
                            String str = trackParameterForChild2.search_id;
                            AddressTrack.trackDiscountPoiShowOrClick(true, str, rpcPoi, rpcPoi3);
                            C3375x699d46f3 r16 = r0;
                            String str2 = "null cannot be cast to non-null type android.widget.TextView";
                            String str3 = str;
                            RpcPoi rpcPoi4 = rpcPoi3;
                            ViewGroup viewGroup3 = viewGroup2;
                            C3375x699d46f3 r0 = new View.OnClickListener(str3, rpcPoi, rpcPoi4, i) {
                                public final /* synthetic */ String f$1;
                                public final /* synthetic */ RpcPoi f$2;
                                public final /* synthetic */ RpcPoi f$3;
                                public final /* synthetic */ int f$4;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                    this.f$3 = r4;
                                    this.f$4 = r5;
                                }

                                public final void onClick(View view) {
                                    GlobalSubDiscountAddressView.m4850a(GlobalSubDiscountAddressView.this, this.f$1, this.f$2, this.f$3, this.f$4, view);
                                }
                            };
                            viewGroup3.setOnClickListener(r0);
                            if (rpcPoi4.extend_info != null) {
                                View findViewById2 = viewGroup3.findViewById(R.id.lowprice_poi_sub_title);
                                if (findViewById2 != null) {
                                    RichTextInfo richTextInfo = new RichTextInfo();
                                    richTextInfo.setInfo(rpcPoi4.extend_info.subTitleDesc);
                                    richTextInfo.bindTo((TextView) findViewById2);
                                    View findViewById3 = viewGroup3.findViewById(R.id.lowprice_poi_distance);
                                    if (findViewById3 != null) {
                                        TextView textView = (TextView) findViewById3;
                                        if (!TextUtils.isEmpty(rpcPoi4.extend_info.distance)) {
                                            textView.setVisibility(0);
                                            textView.setText(rpcPoi4.extend_info.distance);
                                        } else {
                                            textView.setVisibility(8);
                                        }
                                    } else {
                                        throw new NullPointerException(str2);
                                    }
                                } else {
                                    throw new NullPointerException(str2);
                                }
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                        }
                    } else {
                        ViewGroup viewGroup4 = viewGroup2;
                        Intrinsics.checkNotNull(viewGroup4);
                        viewGroup4.setVisibility(8);
                        viewGroup4.setOnClickListener((View.OnClickListener) null);
                    }
                    if (i2 < size) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("firstItem");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m4850a(GlobalSubDiscountAddressView globalSubDiscountAddressView, String str, RpcPoi rpcPoi, RpcPoi rpcPoi2, int i, View view) {
        Intrinsics.checkNotNullParameter(globalSubDiscountAddressView, "this$0");
        Intrinsics.checkNotNullParameter(rpcPoi2, "$address");
        if (globalSubDiscountAddressView.f7671e != null) {
            AddressTrack.trackDiscountPoiShowOrClick(false, str, rpcPoi, rpcPoi2);
            SubAddressViewApi.OnItemClickListener onItemClickListener = globalSubDiscountAddressView.f7671e;
            Intrinsics.checkNotNull(onItemClickListener);
            onItemClickListener.onItemClick(rpcPoi2, i);
        }
    }

    public void setOnItemClickLister(SubAddressViewApi.OnItemClickListener onItemClickListener) {
        this.f7671e = onItemClickListener;
    }
}
