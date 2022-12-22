package com.didi.addressold.delegate;

import android.text.TextUtils;
import com.didi.address.FromType;
import com.didi.addressold.util.AddressTrack;
import com.didi.addressold.util.ApolloUtil;
import com.didi.addressold.util.CommonUtils;
import com.didi.addressold.view.SugSearchView;
import com.didi.addressold.widget.EditTextErasable;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.AddressParam;

public class SelectAddressByDraggedDelegate {

    /* renamed from: a */
    private SugSearchView f7742a;

    /* renamed from: b */
    private AddressParam f7743b;

    /* renamed from: c */
    private int f7744c;

    /* renamed from: d */
    private boolean f7745d = ApolloUtil.canSelectAddressByDragged();

    /* renamed from: e */
    private Address f7746e;

    /* renamed from: f */
    private Address f7747f;

    /* renamed from: g */
    private FromType f7748g;

    public SelectAddressByDraggedDelegate(AddressParam addressParam, FromType fromType) {
        this.f7743b = addressParam;
        this.f7748g = fromType;
        this.f7744c = addressParam.addressType;
    }

    public void setSugSearchView(SugSearchView sugSearchView) {
        this.f7742a = sugSearchView;
    }

    public void setCurrAddressType(int i) {
        this.f7744c = i;
    }

    public Address getStartAddressByDragged() {
        return this.f7746e;
    }

    public Address getEndAddressByDragged() {
        return this.f7747f;
    }

    public boolean canSelectAddressByDragged() {
        if (this.f7745d) {
            if (CommonUtils.isFromHomePage(this.f7748g) || CommonUtils.isFromConfirmPage(this.f7748g)) {
                return true;
            }
            if (!CommonUtils.isFromGetOnPage(this.f7748g) || this.f7744c != 1) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void onPinLoading(Address address) {
        int i = this.f7744c;
        if (i == 1) {
            this.f7746e = address;
            this.f7747f = null;
            this.f7742a.onStartPoiInfoFetchBefore();
        } else if (i == 2) {
            address.displayName = null;
            this.f7746e = null;
            this.f7747f = address;
            this.f7742a.onEndPoiInfoFetchBefore();
        }
    }

    public void onPinPoiChanged(Address address) {
        EditTextErasable editTextErasable;
        int i = this.f7744c;
        if (i == 1) {
            this.f7746e = address;
            editTextErasable = this.f7742a.getStartEditText();
            this.f7742a.onStartPoiInfoFetchAfter();
            AddressTrack.trackUserOperator(1, 1);
        } else if (i == 2) {
            this.f7747f = address;
            editTextErasable = this.f7742a.getEndEditText();
            this.f7742a.onEndPoiInfoFetchAfter();
            AddressTrack.trackUserOperator(2, 1);
        } else {
            editTextErasable = null;
        }
        if (editTextErasable != null && address != null) {
            editTextErasable.setText(address.displayName);
            if (!TextUtils.isEmpty(address.displayName)) {
                editTextErasable.setSelection(address.displayName.length());
            }
        }
    }

    public void onPinFetchPoiFailed(Address address) {
        EditTextErasable editTextErasable;
        int i = this.f7744c;
        if (i == 1) {
            this.f7746e = address;
            editTextErasable = this.f7742a.getStartEditText();
            this.f7742a.onStartPoiInfoFetchAfter();
            AddressTrack.trackUserOperator(1, 1);
        } else if (i == 2) {
            this.f7747f = address;
            editTextErasable = this.f7742a.getEndEditText();
            this.f7742a.onEndPoiInfoFetchAfter();
            AddressTrack.trackUserOperator(2, 1);
        } else {
            editTextErasable = null;
        }
        if (editTextErasable != null && address != null) {
            editTextErasable.setText(address.displayName);
            if (!TextUtils.isEmpty(address.displayName)) {
                editTextErasable.setSelection(address.displayName.length());
            }
        }
    }
}
