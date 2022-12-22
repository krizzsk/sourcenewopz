package com.didi.sdk.sidebar.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.account.manager.ProcessPictureManager;
import com.didi.sdk.sidebar.account.store.AccountStore;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.AvatarComponentView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.actionsheet.ActionSheet;
import com.didi.sdk.view.actionsheet.ActionSheetNew;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.privacy.disclosure.PositiveResultReason;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureBaseDialog;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureManager;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@ComponentType(name = "account_edit_avatar")
public class EditAvatarComponent extends AbsComponent<AvatarComponentView> implements ProcessPictureManager.OnFinishPictureCallBack, ActionSheet.ActionSheetCallback {

    /* renamed from: a */
    private ImageView f37198a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ProcessPictureManager f37199b;

    public void onDestroy() {
    }

    public EditAvatarComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
        ProcessPictureManager processPictureManager = new ProcessPictureManager((FragmentActivity) this.businessContext.getContext());
        this.f37199b = processPictureManager;
        processPictureManager.setOnFinishPictureCallBack(this);
    }

    /* access modifiers changed from: protected */
    public AvatarComponentView createComponentView() {
        return new AvatarComponentView(this.businessContext.getContext());
    }

    /* access modifiers changed from: protected */
    public void initData(AvatarComponentView avatarComponentView) {
        this.f37198a = avatarComponentView.getAvatarView();
        avatarComponentView.setDes(this.sidebarItem.getDes());
        this.f37198a.setImageResource(R.drawable.global_default_head);
        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(this.f37198a.getContext());
        if (userInfo != null) {
            if (!TextUtils.isEmpty(userInfo.getAvatar())) {
                loadImage(userInfo.getAvatar());
            } else if (!TextUtils.isEmpty(userInfo.getHead_url())) {
                loadImage(userInfo.getHead_url());
            }
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        HashMap hashMap = new HashMap();
        hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
        hashMap.put("country_code", NationTypeUtil.getNationComponentData().getLocCountry());
        OmegaSDKAdapter.trackEvent("pas_profile_portraitedit_ck", (Map<String, Object>) hashMap);
        m26374a();
    }

    /* renamed from: a */
    private void m26374a() {
        ActionSheetNew actionSheetNew = new ActionSheetNew();
        Bundle bundle = new Bundle();
        bundle.putStringArray(ActionSheet.KEY_LIST_ITEM_ARRAY, ResourcesHelper.getStringArray(this.businessContext.getContext(), R.array.avatar_menu));
        actionSheetNew.setArguments(bundle);
        actionSheetNew.setActionSheetCallback(this);
        m26375a(actionSheetNew, bundle);
    }

    /* renamed from: a */
    private void m26375a(Fragment fragment, Bundle bundle) {
        if (fragment != null) {
            FragmentTransaction beginTransaction = ((FragmentActivity) this.businessContext.getContext()).getSupportFragmentManager().beginTransaction();
            if (bundle != null) {
                fragment.setArguments(bundle);
            }
            beginTransaction.add(fragment, fragment.getClass().getName());
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public void loadImage(String str) {
        ((RequestBuilder) Glide.with((Context) DIDIApplication.getAppContext()).asBitmap().load(str).transform((Transformation<Bitmap>) new GlideRoundTransform(DIDIApplication.getAppContext(), 100))).into(this.f37198a);
    }

    public void onItemSelected(int i, String str) {
        if (this.f37199b != null) {
            if (i == 0) {
                PrivacyDisclosureManager.getInstance().openPrivacyDisclosureDialog((FragmentActivity) this.businessContext.getContext(), PrivacyTypeEnum.CAMERA, new String[]{Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, new PrivacyDisclosureBaseDialog.Callback() {
                    public void onNegativeResult() {
                    }

                    public void onPositiveResult(PositiveResultReason positiveResultReason) {
                        EditAvatarComponent.this.f37199b.takePhotoByCamera();
                    }
                });
            } else if (i == 1) {
                PrivacyDisclosureManager.getInstance().openPrivacyDisclosureDialog((FragmentActivity) this.businessContext.getContext(), PrivacyTypeEnum.ALBUM, new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, new PrivacyDisclosureBaseDialog.Callback() {
                    public void onNegativeResult() {
                    }

                    public void onPositiveResult(PositiveResultReason positiveResultReason) {
                        EditAvatarComponent.this.f37199b.selectPhotoFromGallery();
                    }
                });
            }
        }
    }

    public void notifyPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.notifyPermissionsResult(i, strArr, iArr);
        boolean z = true;
        if (i == 1008) {
            int i2 = 0;
            while (true) {
                if (i2 < iArr.length) {
                    if (iArr[i2] != 0 && strArr.length > i2) {
                        break;
                    }
                    i2++;
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                this.f37199b.isAllGranted();
            }
        } else if (i == 1009) {
            int i3 = 0;
            while (true) {
                if (i3 < iArr.length) {
                    if (iArr[i3] != 0 && strArr.length > i3) {
                        break;
                    }
                    i3++;
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                this.f37199b.allGalleryAccess();
            }
        }
    }

    public void onCropFinish(File file) {
        if (file != null) {
            m26376a(file.getAbsolutePath());
        }
    }

    public int getImageViewSize() {
        return Math.max(this.f37198a.getWidth(), this.f37198a.getHeight());
    }

    public void loadImageFromFile(String str) {
        ((RequestBuilder) Glide.with((Context) DIDIApplication.getAppContext()).asBitmap().load(new File(str)).transform((Transformation<Bitmap>) new GlideRoundTransform(DIDIApplication.getAppContext(), 100))).into(this.f37198a);
    }

    /* renamed from: a */
    private void m26376a(String str) {
        if (!TextUtils.isEmpty(str)) {
            loadImageFromFile(str);
        }
        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        progressDialogFragment.setContent(((FragmentActivity) this.businessContext.getContext()).getApplicationContext().getString(R.string.userinfo_update), false);
        progressDialogFragment.show(((FragmentActivity) this.businessContext.getContext()).getSupportFragmentManager(), "loading");
        AccountStore.getInstance().modifyAvatarWithoutDialog(this.businessContext.getContext(), new File(str), progressDialogFragment);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1005:
                    this.f37199b.processPhotoFromGallery(intent);
                    return;
                case 1006:
                    this.f37199b.processPhotoFromCamera();
                    return;
                case 1007:
                    this.f37199b.processCropPhoto();
                    return;
                default:
                    return;
            }
        }
    }
}
