package com.didi.addressold.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.address.AddressResult;
import com.didi.address.FromType;
import com.didi.address.model.SugMapConstants;
import com.didi.address.model.SugParams;
import com.didi.addressold.presenter.CommonAddressPresenter;
import com.didi.addressold.util.ViewUtils;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class EditFavoritePlaceActivity extends BaseActivity implements ICommonAddressView {
    public static final String BUNDLE_RPC_COMMON_POI = "bundle_rpc_common_poi";
    public static final String BUNDLE_RPC_COMMON_POI_LIST = "bundle_rpc_common_poi_list";
    public static final int TYPE_ADD = 0;
    public static final int TYPE_EDIT = 1;

    /* renamed from: a */
    private static final int f7895a = 101;

    /* renamed from: b */
    private int f7896b = 0;

    /* renamed from: c */
    private RpcCommonPoi f7897c = new RpcCommonPoi();

    /* renamed from: d */
    private List<RpcCommonPoi> f7898d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugParams f7899e;

    /* renamed from: f */
    private Address f7900f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EditText f7901g;

    /* renamed from: h */
    private TextView f7902h;

    /* renamed from: i */
    private TextView f7903i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ImageView f7904j;

    /* renamed from: k */
    private CommonAddressPresenter f7905k;

    public void loadContentView(Bundle bundle) {
    }

    public void updateCommonAddress(ArrayList<RpcCommonPoi> arrayList) {
    }

    public static Intent getIntent(Context context, SugParams sugParams) {
        Intent intent = new Intent(context, EditFavoritePlaceActivity.class);
        intent.putExtra(SugMapConstants.EXTRA_ADDRESS_PARAM, sugParams);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.old_layout_edit_favorite_place);
        setToolbarVisibility(0);
        setTitle(getString(R.string.global_edit_favorite_place_title_save));
        this.f7901g = (EditText) findViewById(R.id.edit_name);
        this.f7902h = (TextView) findViewById(R.id.edit_address);
        TextView textView = (TextView) findViewById(R.id.save_button);
        this.f7903i = textView;
        textView.setEnabled(false);
        this.f7904j = (ImageView) findViewById(R.id.edit_name_clear_button);
        m5082a();
        m5085c();
        this.f7901g.postDelayed(new Runnable() {
            public void run() {
                EditFavoritePlaceActivity editFavoritePlaceActivity = EditFavoritePlaceActivity.this;
                ViewUtils.showInputMethodForEditText(editFavoritePlaceActivity, editFavoritePlaceActivity.f7901g);
            }
        }, 100);
    }

    /* renamed from: a */
    private void m5082a() {
        this.f7902h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SugParams clone = EditFavoritePlaceActivity.this.f7899e.clone();
                clone.addressParam.addressType = 5;
                clone.fromType = FromType.SETTING;
                EditFavoritePlaceActivity editFavoritePlaceActivity = EditFavoritePlaceActivity.this;
                editFavoritePlaceActivity.startActivityForResult(SugContainerActivity.getIntent(editFavoritePlaceActivity, clone), 101);
            }
        });
        this.f7902h.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                EditFavoritePlaceActivity.this.m5084b();
            }
        });
        this.f7901g.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                EditFavoritePlaceActivity.this.m5084b();
                if (editable.length() == 0) {
                    EditFavoritePlaceActivity.this.f7904j.setVisibility(8);
                } else {
                    EditFavoritePlaceActivity.this.f7904j.setVisibility(0);
                }
            }
        });
        this.f7904j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EditFavoritePlaceActivity.this.f7901g.setText("");
            }
        });
        this.f7903i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EditFavoritePlaceActivity.this.m5088d();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5084b() {
        if (this.f7901g.getText().length() == 0 || this.f7902h.getText().length() == 0 || getString(R.string.global_edit_favorite_place_address_edit_hint).equals(this.f7902h.getText().toString())) {
            this.f7903i.setEnabled(false);
        } else {
            this.f7903i.setEnabled(true);
        }
    }

    /* renamed from: c */
    private void m5085c() {
        this.f7905k = new CommonAddressPresenter(this, this);
        if (getIntent().hasExtra(BUNDLE_RPC_COMMON_POI_LIST)) {
            this.f7898d = (List) getIntent().getSerializableExtra(BUNDLE_RPC_COMMON_POI_LIST);
        }
        if (!getIntent().hasExtra(BUNDLE_RPC_COMMON_POI) || !(getIntent().getSerializableExtra(BUNDLE_RPC_COMMON_POI) instanceof RpcCommonPoi)) {
            this.f7896b = 0;
        } else {
            this.f7896b = 1;
            RpcCommonPoi rpcCommonPoi = (RpcCommonPoi) getIntent().getSerializableExtra(BUNDLE_RPC_COMMON_POI);
            this.f7897c = rpcCommonPoi;
            this.f7901g.setText(rpcCommonPoi.aliasName);
            this.f7902h.setText(this.f7897c.address);
            this.f7902h.setTextColor(getResources().getColor(R.color.black));
        }
        if (getIntent().hasExtra(SugMapConstants.EXTRA_ADDRESS_PARAM) && (getIntent().getSerializableExtra(SugMapConstants.EXTRA_ADDRESS_PARAM) instanceof AddressParam)) {
            this.f7899e = (SugParams) getIntent().getSerializableExtra(SugMapConstants.EXTRA_ADDRESS_PARAM);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5088d() {
        List<RpcCommonPoi> list;
        String obj = this.f7901g.getText().toString();
        boolean z = true;
        if (!obj.equals(this.f7897c.aliasName) && (list = this.f7898d) != null) {
            for (RpcCommonPoi rpcCommonPoi : list) {
                if (obj.equals(rpcCommonPoi.aliasName)) {
                    ToastHelper.showLongInfo((Context) this, getString(R.string.global_edit_favorite_place_toast_exists, new Object[]{obj}));
                    return;
                }
            }
        }
        this.f7897c.aliasName = this.f7901g.getText().toString();
        CommonAddressPresenter commonAddressPresenter = this.f7905k;
        AddressParam addressParam = this.f7899e.addressParam;
        RpcCommonPoi rpcCommonPoi2 = this.f7897c;
        if (this.f7896b != 0) {
            z = false;
        }
        commonAddressPresenter.updateFavoritePlace(addressParam, rpcCommonPoi2, z);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AddressResult addressResult;
        super.onActivityResult(i, i2, intent);
        if (intent != null && i2 == -1 && 101 == i && (addressResult = (AddressResult) intent.getSerializableExtra("result")) != null) {
            Address address = addressResult.common;
            this.f7900f = address;
            if (address != null) {
                this.f7902h.setText(address.address);
                this.f7902h.setTextColor(getResources().getColor(R.color.black));
                RpcCommonPoi rpcCommonPoi = this.f7897c;
                String str = rpcCommonPoi != null ? rpcCommonPoi.primaryId : "";
                RpcCommonPoi a = m5081a(this.f7900f, this.f7897c);
                this.f7897c = a;
                a.primaryId = str;
            }
        }
    }

    /* renamed from: a */
    private RpcCommonPoi m5081a(Address address, RpcCommonPoi rpcCommonPoi) {
        RpcCommonPoi rpcCommonPoi2 = new RpcCommonPoi();
        if (address != null) {
            rpcCommonPoi2.address = address.address;
            rpcCommonPoi2.longitude = address.longitude;
            rpcCommonPoi2.latitude = address.latitude;
            rpcCommonPoi2.displayName = address.displayName;
            rpcCommonPoi2.cityId = address.cityId;
            rpcCommonPoi2.poi_id = address.poiId;
            rpcCommonPoi2.countryID = address.countryID;
            rpcCommonPoi2.countryCode = address.countryCode;
            if (rpcCommonPoi != null) {
                rpcCommonPoi2.primaryId = rpcCommonPoi.primaryId;
                rpcCommonPoi2.aliasName = rpcCommonPoi.aliasName;
            }
        }
        return rpcCommonPoi2;
    }

    public void onHttpRequestSuccess() {
        setResult(-1);
        finish();
    }
}
