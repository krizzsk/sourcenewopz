package com.didi.addressnew.framework.fragmentmarket.favorite;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.address.FromType;
import com.didi.addressnew.fastframe.IView;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl;
import com.didi.addressnew.framework.widget.loadingbutton.LoadableButton;
import com.didi.addressnew.presenter.CommonAddressPresenter;
import com.didi.addressnew.presenter.ICommonAddressPresenter;
import com.didi.addressnew.util.ToastHelper;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.view.ICommonAddressView;
import com.didi.addressnew.widget.DeleteDialog;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class EditFavoriteFragment extends FragmentImpl implements View.OnClickListener, ICommonAddressView {
    public static final int TYPE_ADD = 0;
    public static final int TYPE_EDIT = 1;

    /* renamed from: a */
    private RelativeLayout f4397a;

    /* renamed from: b */
    private ImageView f4398b;

    /* renamed from: c */
    private TextView f4399c;

    /* renamed from: d */
    private LoadableButton f4400d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ImageView f4401e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public EditText f4402f;

    /* renamed from: g */
    private TextView f4403g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public DeleteDialog f4404h;

    /* renamed from: i */
    private ImageView f4405i;

    /* renamed from: j */
    private int f4406j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ICommonAddressPresenter f4407k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public RpcCommonPoi f4408l = new RpcCommonPoi();

    /* renamed from: m */
    private List<RpcCommonPoi> f4409m = new ArrayList();

    public boolean getDragHandlerEnable() {
        return false;
    }

    public View getFallbackView() {
        return null;
    }

    public /* synthetic */ void showContentView() {
        IView.CC.$default$showContentView(this);
    }

    public /* synthetic */ void showEmptyView() {
        IView.CC.$default$showEmptyView(this);
    }

    public /* synthetic */ void showProgressDialog(String str, boolean z) {
        IView.CC.$default$showProgressDialog(this, str, z);
    }

    public void showProgressDialog(boolean z) {
    }

    public /* synthetic */ void showToastError(String str, boolean z) {
        IView.CC.$default$showToastError(this, str, z);
    }

    public /* synthetic */ void updateCommonAddress(ArrayList<RpcCommonPoi> arrayList) {
        ICommonAddressView.CC.$default$updateCommonAddress(this, arrayList);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_favorite_fragment_layout, viewGroup, false);
        this.f4397a = (RelativeLayout) inflate.findViewById(R.id.favorite_title_container);
        inflate.findViewById(R.id.favorite_back).setOnClickListener(this);
        LoadableButton loadableButton = (LoadableButton) inflate.findViewById(R.id.favorite_name_save);
        this.f4400d = loadableButton;
        loadableButton.setText(getContext().getResources().getString(R.string.global_sug_save));
        this.f4400d.setTextSize(20);
        this.f4400d.setTextStyle(Typeface.DEFAULT_BOLD);
        this.f4400d.setOnClickListener(this);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.edit_name_clear_button);
        this.f4401e = imageView;
        imageView.setOnClickListener(this);
        this.f4402f = (EditText) inflate.findViewById(R.id.edit_name);
        this.f4403g = (TextView) inflate.findViewById(R.id.address_name);
        this.f4399c = (TextView) inflate.findViewById(R.id.favorite_edit_title);
        this.f4398b = (ImageView) inflate.findViewById(R.id.favorite_edit_delete);
        this.f4405i = (ImageView) inflate.findViewById(R.id.address_icon);
        this.f4398b.setOnClickListener(this);
        m2744d();
        m2737a();
        return inflate;
    }

    /* renamed from: a */
    private void m2737a() {
        this.f4402f.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                EditFavoriteFragment.this.m2742c();
                if (editable.length() == 0) {
                    EditFavoriteFragment.this.f4401e.setVisibility(8);
                } else {
                    EditFavoriteFragment.this.f4401e.setVisibility(0);
                }
            }
        });
    }

    public void onPageExit() {
        super.onPageExit();
        m2740b();
        ViewUtils.hideInputMethodForEditText(getContext(), this.f4402f);
    }

    /* renamed from: b */
    private void m2740b() {
        this.f4406j = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2742c() {
        if (this.f4402f.getText().length() == 0) {
            this.f4400d.setEnabled(false);
            this.f4400d.setBgEnabled(false);
            return;
        }
        this.f4400d.setEnabled(true);
        this.f4400d.setBgEnabled(true);
    }

    /* renamed from: d */
    private void m2744d() {
        this.f4407k = new CommonAddressPresenter(getContext(), this);
        this.f4408l = getmResult().getCommonAddress();
        this.f4409m = getmResult().getCommonAddressList();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4397a.getLayoutParams();
        if (getmParam().fromType == FromType.SETTING) {
            layoutParams.setMargins(0, ViewUtils.dip2px(getContext(), 30.0f), 0, 0);
            this.f4397a.setLayoutParams(layoutParams);
        } else if (getmParam().fromType == FromType.HOME) {
            layoutParams.setMargins(0, 0, 0, 0);
            this.f4397a.setLayoutParams(layoutParams);
        }
        if (this.f4409m != null) {
            this.f4402f.setText(this.f4408l.displayName);
            this.f4403g.setText(this.f4408l.address);
            ((RequestBuilder) Glide.with(getContext().getApplicationContext()).load(this.f4408l.pre_logo_url).error((int) R.drawable.icon_position)).into(this.f4405i);
        }
        this.f4402f.selectAll();
        this.f4402f.setFocusable(true);
        this.f4402f.setFocusableInTouchMode(true);
        this.f4402f.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ViewUtils.showInputMethodForEditText(EditFavoriteFragment.this.getContext(), EditFavoriteFragment.this.f4402f);
                if (!EditFavoriteFragment.this.f4402f.getViewTreeObserver().isAlive()) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    EditFavoriteFragment.this.f4402f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    EditFavoriteFragment.this.f4402f.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
        if (!TextUtils.isEmpty(this.f4408l.primaryId)) {
            this.f4406j = 1;
        }
        if (this.f4406j == 1) {
            this.f4399c.setText(getContext().getResources().getString(R.string.GRider_Sug_2020_favoriteSetName_title));
            this.f4398b.setVisibility(0);
        }
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.EDIT_FAVORITE;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.favorite_name_save) {
            this.f4400d.playAnim();
            m2746e();
        } else if (id == R.id.favorite_edit_delete) {
            ViewUtils.hideInputWindow(getContext(), this.f4402f);
            DeleteDialog deleteDialog = new DeleteDialog(getContext());
            this.f4404h = deleteDialog;
            deleteDialog.setTitle(getContext().getResources().getString(R.string.GRider_Sug_2020_sidebar_delete_pop));
            this.f4404h.setOnDeleteDialogClickListener(new DeleteDialog.OnDeleteDialogClickListener() {
                public void onCancelClick() {
                    EditFavoriteFragment.this.f4404h.dismiss();
                }

                public void onConfirmClick() {
                    AddressParam clone = EditFavoriteFragment.this.getmParam().addressParam.clone();
                    clone.addressType = 5;
                    EditFavoriteFragment.this.f4407k.deletFavoritePlace(clone, EditFavoriteFragment.this.f4408l.primaryId);
                }
            });
            SystemUtils.showDialog(this.f4404h);
        } else if (id == R.id.edit_name_clear_button) {
            this.f4402f.setText("");
        } else if (id == R.id.favorite_back) {
            onCancel(getmParam(), getmResult());
            switchBack(getmParam(), getmResult());
        }
    }

    public void dismissProgressDialog() {
        this.f4400d.reset();
        DeleteDialog deleteDialog = this.f4404h;
        if (deleteDialog != null) {
            deleteDialog.refreshConfirmBtn();
            this.f4404h.dismiss();
        }
    }

    public void showToastComplete(String str) {
        computeOffset();
        switchBack(getmParam(), getmResult());
        this.f4400d.reset();
        ToastHelper.showSuccessful(getContext(), str);
    }

    public void showToastError(String str) {
        ToastHelper.showFail(getContext(), str);
        onCancel(getmParam(), getmResult());
        switchBack(getmParam(), getmResult());
    }

    public String getStringVal(int i) {
        try {
            return getContext().getString(i);
        } catch (Exception unused) {
            return "";
        }
    }

    public void onHttpRequestSuccess() {
        computeOffset();
        ToastHelper.showSuccessful(getContext(), getContext().getResources().getString(R.string.GRider_Sug_2020_common_addSuc));
        switchBack(getmParam(), getmResult());
    }

    /* renamed from: e */
    private void m2746e() {
        List<RpcCommonPoi> list;
        RpcCommonPoi rpcCommonPoi = this.f4408l;
        if (!(rpcCommonPoi == null || rpcCommonPoi.poi_id == null || (list = this.f4409m) == null)) {
            for (RpcCommonPoi rpcCommonPoi2 : list) {
                if (this.f4408l.poi_id.equals(rpcCommonPoi2.poi_id)) {
                    ToastHelper.showFail(getContext(), getContext().getResources().getString(R.string.GRider_Sug_2020_favoritePage_Repeat));
                    showToastComplete((String) null);
                    return;
                }
            }
        }
        this.f4408l.aliasName = this.f4402f.getText().toString();
        this.f4407k.updateFavoritePlace(getmParam().addressParam, this.f4408l, this.f4406j == 0);
    }
}
