package com.didi.addressold.widget;

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
import com.didi.addressold.view.enhance.SubAddressItemEnhancer;
import com.didi.addressold.widget.SubAddressViewApi;
import com.didi.autotracker.AutoTrackHelper;
import com.sdk.poibase.model.RpcPoi;
import com.taxis99.R;
import java.util.ArrayList;

public class GlobalSubAddressView extends LinearLayout implements SubAddressViewApi {

    /* renamed from: a */
    private final int f8070a;

    /* renamed from: b */
    private ViewGroup f8071b;

    /* renamed from: c */
    private ViewGroup f8072c;

    /* renamed from: d */
    private ViewGroup f8073d;

    /* renamed from: e */
    private ViewGroup f8074e;

    /* renamed from: f */
    private SubAddressItemEnhancer f8075f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SubAddressViewApi.OnItemClickListener f8076g;

    /* renamed from: h */
    private ArrayList<RpcPoi> f8077h;

    public GlobalSubAddressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalSubAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8070a = 3;
        this.f8075f = new SubAddressItemEnhancer();
        m5246a(context);
    }

    /* renamed from: a */
    private void m5246a(Context context) {
        setOrientation(1);
        View inflate = LayoutInflater.from(context).inflate(R.layout.old_poi_one_address_sub_poi_global, this);
        this.f8071b = (ViewGroup) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_left);
        this.f8072c = (ViewGroup) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_middle);
        this.f8073d = (ViewGroup) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_right);
        this.f8074e = (ViewGroup) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_backup);
    }

    public void setOnItemClickLister(SubAddressViewApi.OnItemClickListener onItemClickListener) {
        this.f8076g = onItemClickListener;
    }

    public void fillData(ArrayList<RpcPoi> arrayList) {
        this.f8077h = arrayList;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f8071b);
        arrayList2.add(this.f8072c);
        arrayList2.add(this.f8073d);
        arrayList2.add(this.f8074e);
        int size = arrayList2.size();
        int size2 = arrayList.size();
        for (final int i = 0; i < size; i++) {
            ViewGroup viewGroup = (ViewGroup) arrayList2.get(i);
            if (i <= size2 - 1) {
                final RpcPoi rpcPoi = arrayList.get(i);
                ((TextView) viewGroup.findViewById(R.id.sub_item_content)).setText(rpcPoi != null ? rpcPoi.base_info.displayname : "");
                viewGroup.setVisibility(0);
                viewGroup.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (GlobalSubAddressView.this.f8076g != null) {
                            GlobalSubAddressView.this.f8076g.onItemClick(rpcPoi, i);
                        }
                    }
                });
                this.f8075f.enhance(viewGroup, i, rpcPoi);
                TextView textView = (TextView) viewGroup.findViewById(R.id.sub_item_distance);
                if (!TextUtils.isEmpty(rpcPoi.extend_info.distance)) {
                    textView.setVisibility(0);
                    textView.setText(rpcPoi.extend_info.distance);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                viewGroup.setVisibility(8);
                viewGroup.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.addresses = this.f8077h;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            fillData(savedState.addresses);
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
