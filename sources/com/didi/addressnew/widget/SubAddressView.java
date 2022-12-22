package com.didi.addressnew.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfoTag;
import com.taxis99.R;
import java.util.ArrayList;

public class SubAddressView extends LinearLayout {

    /* renamed from: a */
    private final int f7679a;

    /* renamed from: b */
    private RelativeLayout f7680b;

    /* renamed from: c */
    private RelativeLayout f7681c;

    /* renamed from: d */
    private RelativeLayout f7682d;

    /* renamed from: e */
    private ViewGroup f7683e;

    /* renamed from: f */
    private RelativeLayout f7684f;

    /* renamed from: g */
    private RelativeLayout f7685g;

    /* renamed from: h */
    private RelativeLayout f7686h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnItemClickListener f7687i;

    /* renamed from: j */
    private ArrayList<RpcPoi> f7688j;

    public interface OnItemClickListener {
        void onItemClick(RpcPoi rpcPoi, int i);
    }

    public SubAddressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SubAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7679a = 3;
        m4854a(context);
    }

    /* renamed from: a */
    private void m4854a(Context context) {
        setOrientation(1);
        View inflate = LayoutInflater.from(context).inflate(R.layout.poi_one_address_sub_poi, this);
        this.f7683e = (ViewGroup) inflate.findViewById(R.id.tv_bottom_row);
        this.f7680b = (RelativeLayout) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_left);
        this.f7681c = (RelativeLayout) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_middle);
        this.f7682d = (RelativeLayout) inflate.findViewById(R.id.tv_top_row).findViewById(R.id.tv_right);
        this.f7684f = (RelativeLayout) inflate.findViewById(R.id.tv_bottom_row).findViewById(R.id.tv_left);
        this.f7685g = (RelativeLayout) inflate.findViewById(R.id.tv_bottom_row).findViewById(R.id.tv_middle);
        this.f7686h = (RelativeLayout) inflate.findViewById(R.id.tv_bottom_row).findViewById(R.id.tv_right);
    }

    public void setOnItemClickLister(OnItemClickListener onItemClickListener) {
        this.f7687i = onItemClickListener;
    }

    public void fillData(ArrayList<RpcPoi> arrayList) {
        this.f7688j = arrayList;
        int i = 8;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f7680b);
        arrayList2.add(this.f7681c);
        arrayList2.add(this.f7682d);
        arrayList2.add(this.f7684f);
        arrayList2.add(this.f7685g);
        arrayList2.add(this.f7686h);
        int size = arrayList2.size();
        int size2 = arrayList.size();
        for (final int i2 = 0; i2 < size; i2++) {
            RelativeLayout relativeLayout = (RelativeLayout) arrayList2.get(i2);
            if (i2 <= size2 - 1) {
                final RpcPoi rpcPoi = arrayList.get(i2);
                TextView textView = (TextView) relativeLayout.findViewById(R.id.sub_item_tag);
                if (rpcPoi == null || rpcPoi.base_info.poi_tag == null || rpcPoi.base_info.poi_tag.isEmpty()) {
                    textView.setVisibility(8);
                } else {
                    RpcPoiBaseInfoTag rpcPoiBaseInfoTag = rpcPoi.base_info.poi_tag.get(0);
                    if ("2".equals(rpcPoiBaseInfoTag.type)) {
                        textView.setText(rpcPoiBaseInfoTag.name);
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                }
                ((TextView) relativeLayout.findViewById(R.id.sub_item_content)).setText(rpcPoi != null ? rpcPoi.base_info.displayname : "");
                relativeLayout.setVisibility(0);
                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (SubAddressView.this.f7687i != null) {
                            SubAddressView.this.f7687i.onItemClick(rpcPoi, i2);
                        }
                    }
                });
            } else {
                relativeLayout.setVisibility(4);
                relativeLayout.setOnClickListener((View.OnClickListener) null);
            }
        }
        ViewGroup viewGroup = this.f7683e;
        if (size2 > 3) {
            i = 0;
        }
        viewGroup.setVisibility(i);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.addresses = this.f7688j;
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
