package com.didi.safetoolkit.business.share.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.activity.BaseActivity;
import com.android.didi.safetoolkit.activity.permisstion.AuthorizationInfo;
import com.android.didi.safetoolkit.activity.permisstion.callback.IPermissionRequest;
import com.android.didi.safetoolkit.activity.permisstion.callback.PermissionCallback;
import com.android.didi.safetoolkit.presenter.AbsPresenter;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.safetoolkit.business.contacts.SimpleDividerDecoration;
import com.didi.safetoolkit.business.share.SfContactsAdapter;
import com.didi.safetoolkit.business.share.SfIContactsView;
import com.didi.safetoolkit.business.share.store.ISfContactsStore;
import com.didi.safetoolkit.business.share.store.SfCallback;
import com.didi.safetoolkit.business.share.store.SfContactsStore;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.util.SfAppUtils;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.widget.SfCommonTitleBar;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didiglobal.privacy.disclosure.PositiveResultReason;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureBaseDialog;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureManager;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.List;

public abstract class SfBaseController extends AbsPresenter<SfIContactsView> {
    protected static final String TAG = "SfContactsActivity";
    protected LEGODrawer drawer;
    private boolean isBackFromSystemPage = false;
    protected SfContactsAdapter mAdapter;
    protected SfCallback mCallback;
    protected boolean mIsRemember = false;
    private ViewGroup mListLayout;
    private TextView mNoPermissionContTV;
    private ViewGroup mNoPermissionLayout;
    protected RecyclerView mRecyclerView;
    private TextView mRequestPermissionBtn;
    private EditText mSearchEt;
    protected ISfContactsStore mStore;
    protected SfCommonTitleBar mTitleBar;
    protected ArrayList<SfContactsModel> selectList;

    /* access modifiers changed from: protected */
    public abstract void getDataList();

    /* access modifiers changed from: protected */
    public void onDataLoaded(List<SfContactsModel> list) {
    }

    /* access modifiers changed from: protected */
    public void onPermissionGranted() {
    }

    /* access modifiers changed from: protected */
    public void onPermissionRefused(boolean z) {
    }

    /* access modifiers changed from: protected */
    public abstract void onSelectDateChanged(int i);

    public SfBaseController(SfIContactsView sfIContactsView) {
        super(sfIContactsView);
        init();
    }

    private void init() {
        findViews();
        setListener();
        initObjects();
        showPrivacyDisclosureDialog();
    }

    private void showPrivacyDisclosureDialog() {
        if (getContext() instanceof FragmentActivity) {
            PrivacyDisclosureManager.getInstance().openPrivacyDisclosureDialog((FragmentActivity) getContext(), PrivacyTypeEnum.READ_CONTACTS, new PrivacyDisclosureBaseDialog.Callback() {
                public void onPositiveResult(PositiveResultReason positiveResultReason) {
                    SfBaseController.this.requestPermission();
                }

                public void onNegativeResult() {
                    if (SfBaseController.this.getContext() instanceof Activity) {
                        ((Activity) SfBaseController.this.getContext()).finish();
                    }
                }
            });
        } else {
            requestPermission();
        }
    }

    private void showConfirmDialog() {
        final Context context = getContext();
        if (context != null) {
            final LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(ResourcesHelper.getString(context, R.string.GRider_adjustment_Privacy_Notice_ibyJ), new LEGOBtnTextAndCallback(ResourcesHelper.getString(context, R.string.GRider_adjustment_Agree_tHbn), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    SfBaseController.this.drawer.dismiss();
                    SfBaseController.this.requestPermission();
                }
            }));
            lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(ResourcesHelper.getString(context, R.string.GRider_adjustment_Refusal_SMsG), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    Context context = context;
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            }));
            lEGODrawerModel1.setSubTitle(ResourcesHelper.getString(context, R.string.GRider_adjustment_To_facilitate_pGOr)).setIsShowCloseImg(false).setClickOutsideCanCancel(false);
            lEGODrawerModel1.setmBackPressedEnabled(false);
            UiThreadHandler.getsUiHandler().postDelayed(new Runnable() {
                public void run() {
                    SfBaseController.this.drawer = LEGOUICreator.showDrawerTemplate(context, lEGODrawerModel1);
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.mNoPermissionLayout = (ViewGroup) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.no_permission_layout);
        this.mRequestPermissionBtn = (TextView) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.request_per_btn);
        ((TextView) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.no_permission_main_title)).setText(String.format(SfStringGetter.getString(R.string.sf_cannot_access), new Object[]{SfAppUtils.getAppName()}));
        this.mNoPermissionContTV = (TextView) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.no_permission_sub_title);
        this.mListLayout = (ViewGroup) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.list_layout);
        this.mTitleBar = (SfCommonTitleBar) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.share_title_bar);
        this.mSearchEt = (EditText) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.search_et);
        RecyclerView recyclerView = (RecyclerView) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.rv);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(((SfIContactsView) this.mView).getContext(), 1, false));
        this.mRecyclerView.addItemDecoration(new SimpleDividerDecoration(((SfIContactsView) this.mView).getContext()));
        this.mSearchEt.setHint(SfStringGetter.getString(R.string.sf_search_contacts));
        this.mSearchEt.setCursorVisible(true);
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        C117465 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.request_per_btn) {
                    if (SfBaseController.this.mIsRemember) {
                        SfBaseController.this.gotoSystemPermissionPage();
                    } else {
                        SfBaseController.this.requestPermission();
                    }
                } else if (view.getId() == R.id.sf_left_btn) {
                    ((SfIContactsView) SfBaseController.this.mView).finish();
                }
            }
        };
        this.mRequestPermissionBtn.setOnClickListener(r0);
        this.mTitleBar.setLeftBtnClickListener(r0);
        this.mSearchEt.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                SfBaseController.this.mStore.getMatchList(editable.toString(), new SfCallback() {
                    public void onFailed(String str) {
                    }

                    public void onSucceed(List<SfContactsModel> list) {
                        SfBaseController.this.mAdapter.updateSystemData(list);
                    }
                });
            }
        });
    }

    private void initObjects() {
        this.mStore = SfContactsStore.getInstance();
        SfContactsAdapter sfContactsAdapter = new SfContactsAdapter();
        this.mAdapter = sfContactsAdapter;
        this.mRecyclerView.setAdapter(sfContactsAdapter);
        this.mCallback = new SfCallback() {
            public void onSucceed(List<SfContactsModel> list) {
                SfBaseController.this.closePDialog();
                SfBaseController.this.onDataLoaded(list);
                SfBaseController.this.mAdapter.addData(list);
            }

            public void onFailed(String str) {
                SfBaseController.this.closePDialog();
                SfBaseController.this.onDataLoaded((List<SfContactsModel>) null);
                SfLog.m24404e(SfBaseController.TAG, "get data list onFailed! msg  = " + str);
            }
        };
        this.selectList = new ArrayList<>();
        this.mAdapter.setListener(new SfContactsAdapter.SfCheckedChangedListener() {
            public void onCheckedChanged(SfContactsModel sfContactsModel, boolean z) {
                if (z) {
                    SfBaseController.this.selectList.add(sfContactsModel);
                } else {
                    SfBaseController.this.selectList.remove(sfContactsModel);
                }
                SfBaseController.this.updateCheckable();
                SfBaseController sfBaseController = SfBaseController.this;
                sfBaseController.onSelectDateChanged(sfBaseController.selectList.size());
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (this.isBackFromSystemPage) {
            requestPermission();
            this.isBackFromSystemPage = false;
        }
    }

    /* access modifiers changed from: private */
    public void updateCheckable() {
        ArrayList<SfContactsModel> arrayList = this.selectList;
        if (arrayList != null) {
            if (arrayList.size() >= ((SfIContactsView) this.mView).getThreshold()) {
                this.mAdapter.updateCheckable(false);
            } else {
                this.mAdapter.updateCheckable(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void showNoPermissionPage(boolean z) {
        SfLog.m24402d("hkc_test", "isRemember  " + z);
        this.mIsRemember = z;
        this.mNoPermissionLayout.setVisibility(0);
        this.mListLayout.setVisibility(8);
        if (this.mIsRemember) {
            this.mNoPermissionContTV.setText(String.format(SfStringGetter.getString(R.string.sf_setting_contact_permissions), new Object[]{SfAppUtils.getAppName()}));
            this.mRequestPermissionBtn.setText(SfStringGetter.getString(R.string.sf_setting));
            return;
        }
        this.mNoPermissionContTV.setText(String.format(SfStringGetter.getString(R.string.sf_cannot_access_cont), new Object[]{SfAppUtils.getAppName()}));
        this.mRequestPermissionBtn.setText(SfStringGetter.getString(R.string.sf_use_phone_contacts));
    }

    /* access modifiers changed from: protected */
    public void showContractList() {
        this.mNoPermissionLayout.setVisibility(8);
        this.mListLayout.setVisibility(0);
        ((SfIContactsView) this.mView).showLoading();
        getDataList();
    }

    /* access modifiers changed from: private */
    public void requestPermission() {
        ((SfIContactsView) this.mView).requestPermission(new PermissionCallback() {
            public void onBeforeGranted(List<AuthorizationInfo> list, IPermissionRequest iPermissionRequest) {
                iPermissionRequest.proceed();
            }

            public void onGranted(List<AuthorizationInfo> list) {
                SfBaseController.this.onPermissionGranted();
                SfBaseController.this.showContractList();
            }

            public void onRefuse(List<AuthorizationInfo> list) {
                AuthorizationInfo authorizationInfo;
                if (list != null && list.size() != 0 && (authorizationInfo = list.get(0)) != null) {
                    SfBaseController.this.mIsRemember = authorizationInfo.isDoNotAskAgain();
                    SfBaseController.this.onPermissionRefused(authorizationInfo.isDoNotAskAgain());
                }
            }
        }, Permission.READ_CONTACTS);
    }

    /* access modifiers changed from: protected */
    public void setResultAndFinish(Intent intent) {
        ((Activity) ((SfIContactsView) this.mView).getContext()).setResult(-1, intent);
        ((Activity) ((SfIContactsView) this.mView).getContext()).finish();
    }

    /* access modifiers changed from: protected */
    public void gotoSystemPermissionPage() {
        if (((SfIContactsView) this.mView).getContext() instanceof BaseActivity) {
            ((BaseActivity) ((SfIContactsView) this.mView).getContext()).launchPermissionSetting();
            this.isBackFromSystemPage = true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mStore.clearData();
    }
}
