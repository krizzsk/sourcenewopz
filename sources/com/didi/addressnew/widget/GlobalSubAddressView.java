package com.didi.addressnew.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.addressnew.view.enhance.SubAddressItemEnhancer;
import com.didi.addressnew.widget.SubAddressViewApi;
import com.didi.autotracker.AutoTrackHelper;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;

public class GlobalSubAddressView extends LinearLayout implements SubAddressViewApi {

    /* renamed from: a */
    private View f7655a;

    /* renamed from: b */
    private final int f7656b;

    /* renamed from: c */
    private ViewGroup f7657c;

    /* renamed from: d */
    private ViewGroup f7658d;

    /* renamed from: e */
    private ViewGroup f7659e;

    /* renamed from: f */
    private ViewGroup f7660f;

    /* renamed from: g */
    private SubAddressItemEnhancer f7661g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SubAddressViewApi.OnItemClickListener f7662h;

    /* renamed from: i */
    private ArrayList<RpcPoi> f7663i;

    /* renamed from: j */
    private RpcPoi f7664j;

    /* renamed from: k */
    private RpcRecSug.TrackParameterForChild f7665k;

    /* renamed from: l */
    private boolean f7666l;

    public GlobalSubAddressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalSubAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7656b = 3;
        this.f7661g = new SubAddressItemEnhancer();
        m4848a(context);
    }

    /* renamed from: a */
    private void m4848a(Context context) {
        setOrientation(1);
        View inflate = LayoutInflater.from(context).inflate(R.layout.poi_one_address_sub_poi_global, this);
        this.f7655a = inflate;
        this.f7657c = (ViewGroup) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_left);
        this.f7658d = (ViewGroup) this.f7655a.findViewById(R.id.tv_top_row).findViewById(R.id.tv_middle);
        this.f7659e = (ViewGroup) this.f7655a.findViewById(R.id.tv_top_row).findViewById(R.id.tv_right);
        this.f7660f = (ViewGroup) this.f7655a.findViewById(R.id.tv_top_row).findViewById(R.id.tv_backup);
    }

    public void setVisble(boolean z) {
        this.f7655a.setVisibility(z ? 0 : 4);
    }

    public void setOnItemClickLister(SubAddressViewApi.OnItemClickListener onItemClickListener) {
        this.f7662h = onItemClickListener;
    }

    public void fillData(RpcPoi rpcPoi, ArrayList<RpcPoi> arrayList, boolean z, RpcRecSug.TrackParameterForChild trackParameterForChild) {
        this.f7666l = z;
        this.f7664j = rpcPoi;
        this.f7665k = trackParameterForChild;
        this.f7663i = arrayList;
        if (arrayList == null || arrayList.size() == 0 || !z) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f7657c);
        arrayList2.add(this.f7658d);
        arrayList2.add(this.f7659e);
        arrayList2.add(this.f7660f);
        int size = arrayList2.size();
        int size2 = arrayList.size();
        for (final int i = 0; i < size; i++) {
            ViewGroup viewGroup = (ViewGroup) arrayList2.get(i);
            String str = null;
            if (i <= size2 - 1) {
                final RpcPoi rpcPoi2 = arrayList.get(i);
                TextView textView = (TextView) viewGroup.findViewById(R.id.sub_item_content);
                if (rpcPoi2 == null) {
                    str = "";
                } else if (rpcPoi2.base_info != null) {
                    str = rpcPoi2.base_info.displayname;
                }
                textView.setText(str);
                viewGroup.setVisibility(0);
                viewGroup.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (GlobalSubAddressView.this.f7662h != null) {
                            GlobalSubAddressView.this.f7662h.onItemClick(rpcPoi2, i);
                        }
                    }
                });
                this.f7661g.enhance(viewGroup, i, rpcPoi2);
                TextView textView2 = (TextView) viewGroup.findViewById(R.id.sub_item_distance);
                if (rpcPoi2.extend_info == null || TextUtils.isEmpty(rpcPoi2.extend_info.distance)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(rpcPoi2.extend_info.distance);
                }
            } else {
                viewGroup.setVisibility(8);
                viewGroup.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.addresses = this.f7663i;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            fillData(this.f7664j, savedState.addresses, this.f7666l, this.f7665k);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<RpcPoi> addresses;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSerializable(this.addresses);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.addresses = (ArrayList) parcel.readSerializable();
        }
    }
}
