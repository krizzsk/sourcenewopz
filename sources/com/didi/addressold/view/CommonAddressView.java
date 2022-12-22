package com.didi.addressold.view;

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
import com.didi.addressold.util.CommonUtils;
import com.didi.sdk.address.address.entity.Address;
import com.taxis99.R;

public class CommonAddressView extends LinearLayout {

    /* renamed from: a */
    private LinearLayout f7881a;

    /* renamed from: b */
    private ViewGroup f7882b;

    /* renamed from: c */
    private TextView f7883c;

    /* renamed from: d */
    private ViewGroup f7884d;

    /* renamed from: e */
    private TextView f7885e;

    /* renamed from: f */
    private ViewGroup f7886f;

    /* renamed from: g */
    private Address f7887g;

    /* renamed from: h */
    private Address f7888h;

    /* renamed from: i */
    private TextView f7889i;

    /* renamed from: j */
    private TextView f7890j;

    /* renamed from: k */
    private LinearLayout f7891k;

    /* renamed from: l */
    private TextView f7892l;

    /* renamed from: m */
    private LinearLayout f7893m;

    /* renamed from: n */
    private TextView f7894n;

    public CommonAddressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommonAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7882b = null;
        this.f7883c = null;
        this.f7884d = null;
        this.f7885e = null;
        this.f7886f = null;
        this.f7887g = null;
        this.f7888h = null;
        this.f7889i = null;
        this.f7890j = null;
        this.f7891k = null;
        this.f7892l = null;
        this.f7893m = null;
        this.f7894n = null;
        LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_common_address_view, this);
        this.f7881a = (LinearLayout) findViewById(R.id.home_company_layout);
        this.f7882b = (ViewGroup) findViewById(R.id.layout_home);
        this.f7883c = (TextView) findViewById(R.id.text_home_content);
        this.f7889i = (TextView) findViewById(R.id.text_home_title);
        this.f7884d = (ViewGroup) findViewById(R.id.layout_company);
        this.f7885e = (TextView) findViewById(R.id.text_company_content);
        this.f7890j = (TextView) findViewById(R.id.text_company_title);
        this.f7886f = (ViewGroup) findViewById(R.id.favorite_place_layout);
        this.f7891k = (LinearLayout) findViewById(R.id.home_container);
        this.f7892l = (TextView) findViewById(R.id.text_home_not_set);
        this.f7893m = (LinearLayout) findViewById(R.id.company_container);
        this.f7894n = (TextView) findViewById(R.id.text_company_not_set);
    }

    public void setHomeCompanyLayoutVisibility(int i) {
        this.f7881a.setVisibility(i);
    }

    public void setCommonAddressLayoutVisibility(int i) {
        this.f7886f.setVisibility(i);
    }

    public void setHome(Address address) {
        this.f7887g = address;
        if (this.f7883c == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(address) || TextUtils.isEmpty(address.displayName)) {
            this.f7892l.setVisibility(0);
            this.f7891k.setVisibility(8);
            this.f7892l.setText(R.string.global_sug_add_home);
            return;
        }
        this.f7891k.setVisibility(0);
        this.f7892l.setVisibility(8);
        this.f7883c.setText(address.displayName);
    }

    public void setCompany(Address address) {
        this.f7888h = address;
        if (this.f7885e == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(address) || TextUtils.isEmpty(address.displayName)) {
            this.f7894n.setVisibility(0);
            this.f7893m.setVisibility(8);
            this.f7894n.setText(R.string.global_sug_add_company);
            return;
        }
        this.f7893m.setVisibility(0);
        this.f7894n.setVisibility(8);
        this.f7885e.setText(address.displayName);
    }

    public Address getHomeAddress() {
        return this.f7887g;
    }

    public Address getCompanyAddress() {
        return this.f7888h;
    }

    public void setHomeClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f7882b;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public void setCompanyClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f7884d;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public void setCommonAddressClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f7886f;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.savedHomeAddress = this.f7887g;
        savedState.savedCompanyAddress = this.f7888h;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setHome(savedState.savedHomeAddress);
            setCompany(savedState.savedCompanyAddress);
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
        Address savedCompanyAddress;
        Address savedHomeAddress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.savedHomeAddress = null;
            this.savedCompanyAddress = null;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSerializable(this.savedHomeAddress);
            parcel.writeSerializable(this.savedCompanyAddress);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.savedHomeAddress = null;
            this.savedCompanyAddress = null;
            this.savedHomeAddress = (Address) parcel.readSerializable();
            this.savedCompanyAddress = (Address) parcel.readSerializable();
        }
    }
}
