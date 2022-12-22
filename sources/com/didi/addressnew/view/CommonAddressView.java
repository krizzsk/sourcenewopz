package com.didi.addressnew.view;

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
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.ViewUtils;
import com.didi.sdk.address.address.entity.Address;
import com.taxis99.R;

public class CommonAddressView extends LinearLayout {

    /* renamed from: a */
    private LinearLayout f7499a;

    /* renamed from: b */
    private ViewGroup f7500b;

    /* renamed from: c */
    private TextView f7501c;

    /* renamed from: d */
    private ViewGroup f7502d;

    /* renamed from: e */
    private TextView f7503e;

    /* renamed from: f */
    private ViewGroup f7504f;

    /* renamed from: g */
    private Address f7505g;

    /* renamed from: h */
    private Address f7506h;

    /* renamed from: i */
    private LinearLayout f7507i;

    /* renamed from: j */
    private LinearLayout f7508j;

    public CommonAddressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommonAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7500b = null;
        this.f7501c = null;
        this.f7502d = null;
        this.f7503e = null;
        this.f7504f = null;
        this.f7505g = null;
        this.f7506h = null;
        this.f7507i = null;
        this.f7508j = null;
        LayoutInflater.from(getContext()).inflate(R.layout.poi_one_address_common_address_view, this);
        this.f7499a = (LinearLayout) findViewById(R.id.home_company_layout);
        this.f7500b = (ViewGroup) findViewById(R.id.layout_home);
        this.f7501c = (TextView) findViewById(R.id.text_home_content);
        this.f7502d = (ViewGroup) findViewById(R.id.layout_company);
        this.f7503e = (TextView) findViewById(R.id.text_company_content);
        this.f7504f = (ViewGroup) findViewById(R.id.layout_favorite);
        this.f7507i = (LinearLayout) findViewById(R.id.layout_home);
        this.f7508j = (LinearLayout) findViewById(R.id.layout_company);
    }

    public void setHomeCompanyLayoutVisibility(int i) {
        this.f7499a.setVisibility(i);
    }

    public void setCommonAddressLayoutVisibility(int i) {
        this.f7504f.setVisibility(i);
    }

    public void setHome(Address address) {
        this.f7505g = address;
        if (this.f7501c == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(address) || TextUtils.isEmpty(address.displayName)) {
            this.f7507i.setVisibility(0);
            this.f7501c.setText(getContext().getString(R.string.GRider_Sug_2020_home));
            if (ViewUtils.isRTL()) {
                this.f7501c.setCompoundDrawablesWithIntrinsicBounds(R.drawable.poi_one_address_arrow_right, 0, 0, 0);
            } else {
                this.f7501c.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.poi_one_address_arrow_right, 0);
            }
        } else {
            this.f7507i.setVisibility(0);
            this.f7501c.setText(address.displayName);
            this.f7501c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public void setCompany(Address address) {
        this.f7506h = address;
        if (this.f7503e == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(address) || TextUtils.isEmpty(address.displayName)) {
            this.f7508j.setVisibility(0);
            this.f7503e.setText(getContext().getString(R.string.GRider_Sug_2020_work));
            if (ViewUtils.isRTL()) {
                this.f7503e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.poi_one_address_arrow_right, 0, 0, 0);
            } else {
                this.f7503e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.poi_one_address_arrow_right, 0);
            }
        } else {
            this.f7508j.setVisibility(0);
            this.f7503e.setText(address.displayName);
            this.f7503e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public Address getHomeAddress() {
        return this.f7505g;
    }

    public Address getCompanyAddress() {
        return this.f7506h;
    }

    public void setHomeClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f7500b;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public void setCompanyClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f7502d;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public void setCommonAddressClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f7504f;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.savedHomeAddress = this.f7505g;
        savedState.savedCompanyAddress = this.f7506h;
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
