package com.didi.sdk.sidebar.account.store;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.push.http.BaseObject;
import com.didi.sdk.sidebar.account.model.UserSettingInfo;
import com.didi.sdk.sidebar.compatible.SideBarAdapterStore;
import com.didi.sdk.sidebar.http.response.AgeListResponse;
import com.didi.sdk.sidebar.http.response.UploadAvatarResponse;
import com.didi.sdk.sidebar.sdk.api.model.CommonDispatchMessage;
import com.didi.sdk.sidebar.sdk.commonapi.CommonAPIPublicParamCombiner;
import com.didi.sdk.sidebar.sdk.commonapi.Consts;
import com.didi.sdk.sidebar.util.SideBarBusinessUtil;
import com.didi.sdk.util.FileUtil;
import com.didi.sdk.util.SingletonHolder;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.http.MultipartSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.taxis99.R;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccountStore extends SideBarAdapterStore {
    public static final String ACTION_AGE_LIST = "com.didi.passenger.ACTION_AGE_LIST";
    public static final String ACTION_MODIFY_AGE = "com.didi.passenger.ACTION_MODIFY_AGE";
    public static final String ACTION_MODIFY_ALL_INFO = "com.didi.passenger.ACTION_MODIFY_ALL_INFO";
    public static final String ACTION_MODIFY_GENDER = "com.didi.passenger.ACTION_MODIFY_GENDER";
    public static final String ACTION_MODIFY_JOB = "com.didi.passenger.ACTION_MODIFY_JOB";
    public static final String ACTION_MODIFY_TRADE = "com.didi.passenger.ACTION_MODIFY_TRADE";
    public static final String ACTION_MODIFY_USERAVATAR = "com.didi.passenger.ACTION_MODIFY_USERAVATAR";
    public static final String ACTION_MODIFY_USERNICK = "com.didi.passenger.ACTION_MODIFY_USERNICK";
    public static final String ACTION_MODIFY_USERSIGN = "com.didi.passenger.ACTION_MODIFY_USERSIGN";
    public static final String ACTION_MODIFY_USER_TO_SIDEBAR = "com.didi.passenger.ACTION_MODIFY_USERAVATAR_TO_SIDEBAR";

    public interface AccountService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/comm/api/getcfglist")
        @Deserialization(GsonDeserializer.class)
        Object getAgeList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<AgeListResponse> callback);

        @Serialization(GsonSerializer.class)
        @Path("/common/v6/passenger/updateprofile")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object modifyAll(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<BaseObject> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/common/v6/passenger/updateprofile")
        @Post(contentType = "multipart/form-data", headers = {"User-Agent: OneNet/2.x"})
        @Deserialization(GsonDeserializer.class)
        void uploadImage(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, RpcService.Callback<UploadAvatarResponse> callback);
    }

    public static AccountStore getInstance() {
        return (AccountStore) SingletonHolder.getInstance(AccountStore.class);
    }

    public void getAgeList(final Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("list_type", "2");
        CommonAPIPublicParamCombiner.combineUserInfo(hashMap);
        CommonAPIPublicParamCombiner.combineSystemInfo(hashMap, context);
        ((AccountService) getService(context, AccountService.class, Consts.getCommonApiByEnviroment(context))).getAgeList(hashMap, new RpcService.Callback<AgeListResponse>() {
            public void onSuccess(AgeListResponse ageListResponse) {
                if (ageListResponse.errno == 0) {
                    AccountStore.this.dispatch(AccountStore.ACTION_AGE_LIST, CommonDispatchMessage.getSuccessMessage(ageListResponse));
                } else if (!SideBarBusinessUtil.isRedirectToLogin(context, ageListResponse)) {
                    AccountStore.this.dispatch(AccountStore.ACTION_AGE_LIST, CommonDispatchMessage.getErrorMessage(ageListResponse));
                }
            }

            public void onFailure(IOException iOException) {
                AccountStore.this.dispatch(AccountStore.ACTION_AGE_LIST, CommonDispatchMessage.getNetworkErrorMessage());
            }
        });
    }

    public void modifyAll(final FragmentActivity fragmentActivity, final UserSettingInfo userSettingInfo, boolean z) {
        if (userSettingInfo != null && fragmentActivity != null) {
            HashMap hashMap = new HashMap();
            if (userSettingInfo.nick != null) {
                hashMap.put("nick", userSettingInfo.nick);
            }
            if (userSettingInfo.sex != null) {
                hashMap.put("gender", userSettingInfo.sex);
            }
            if (userSettingInfo.age != null) {
                hashMap.put("age", String.valueOf(userSettingInfo.age.getList_id()));
            }
            if (userSettingInfo.trade != null) {
                hashMap.put("trade", userSettingInfo.trade.tradeId);
            }
            if (userSettingInfo.company != null) {
                hashMap.put("corp", userSettingInfo.company);
            }
            if (userSettingInfo.job != null) {
                hashMap.put("employ", userSettingInfo.job);
            }
            if (userSettingInfo.sign != null) {
                hashMap.put("sign", userSettingInfo.sign);
            }
            if (userSettingInfo.lang != null) {
                hashMap.put("lang", userSettingInfo.lang);
            }
            if (userSettingInfo.firstName != null) {
                hashMap.put(ParamConst.PARAM_FIRST_NAME, userSettingInfo.firstName);
            }
            if (userSettingInfo.lastName != null) {
                hashMap.put(ParamConst.PARAM_LAST_NAME, userSettingInfo.lastName);
            }
            CommonAPIPublicParamCombiner.combineUserInfo(hashMap);
            CommonAPIPublicParamCombiner.combineSystemInfo(hashMap, fragmentActivity.getApplicationContext());
            final ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
            if (z) {
                progressDialogFragment.setContent(fragmentActivity.getApplicationContext().getString(R.string.userinfo_update), false);
                progressDialogFragment.show(fragmentActivity.getSupportFragmentManager(), "loading");
            }
            ((AccountService) getService(fragmentActivity.getApplicationContext(), AccountService.class, Consts.getCommonApiByEnviroment(fragmentActivity.getApplicationContext()))).modifyAll(hashMap, new RpcService.Callback<BaseObject>() {
                public void onSuccess(BaseObject baseObject) {
                    if (baseObject.errno == 0) {
                        if (!TextUtils.isEmpty(userSettingInfo.loaclImageUrl)) {
                            AccountStore.getInstance().modifyAvatarWithoutDialog(fragmentActivity.getApplicationContext(), new File(userSettingInfo.loaclImageUrl), progressDialogFragment);
                            return;
                        }
                        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(fragmentActivity.getApplicationContext());
                        if (userInfo != null) {
                            userInfo.setLast_name(userSettingInfo.lastName);
                            userInfo.setFirst_name(userSettingInfo.firstName);
                        }
                        UserCenterFacade.getIns().setUserInfo(fragmentActivity, userInfo);
                        AccountStore.this.dispatch(AccountStore.ACTION_MODIFY_ALL_INFO, CommonDispatchMessage.getSuccessMessage(baseObject));
                        if (baseObject.getErrorCode() == 0) {
                            AccountStore.this.dispatch(AccountStore.ACTION_MODIFY_USER_TO_SIDEBAR, CommonDispatchMessage.getSuccessMessage(baseObject));
                        }
                        progressDialogFragment.dismiss();
                    } else if (SideBarBusinessUtil.isRedirectToLogin(fragmentActivity.getApplicationContext(), baseObject)) {
                        progressDialogFragment.dismiss();
                    } else if (!TextUtils.isEmpty(userSettingInfo.loaclImageUrl)) {
                        AccountStore.getInstance().modifyAvatarWithoutDialog(fragmentActivity.getApplicationContext(), new File(userSettingInfo.loaclImageUrl), progressDialogFragment);
                    } else {
                        AccountStore.this.dispatch(AccountStore.ACTION_MODIFY_ALL_INFO, CommonDispatchMessage.getCustomMessage(baseObject.errno, baseObject));
                        progressDialogFragment.dismiss();
                    }
                }

                public void onFailure(IOException iOException) {
                    if (!TextUtils.isEmpty(userSettingInfo.loaclImageUrl)) {
                        AccountStore.getInstance().modifyAvatarWithoutDialog(fragmentActivity.getApplicationContext(), new File(userSettingInfo.loaclImageUrl), progressDialogFragment);
                        return;
                    }
                    AccountStore.this.dispatch(AccountStore.ACTION_MODIFY_ALL_INFO, CommonDispatchMessage.getNetworkErrorMessage());
                    progressDialogFragment.dismiss();
                }
            });
        }
    }

    public void modifyAvatarWithoutDialog(final Context context, File file, final ProgressDialogFragment progressDialogFragment) {
        HashMap hashMap = new HashMap();
        hashMap.put("head_file", file);
        hashMap.put("ext", FileUtil.getExtensionName(file.getName()));
        HashMap hashMap2 = new HashMap();
        CommonAPIPublicParamCombiner.combineUserInfo(hashMap2);
        CommonAPIPublicParamCombiner.combineSystemInfo(hashMap2, context);
        ((AccountService) getService(context, AccountService.class, Consts.getCommonApiByEnviroment(context))).uploadImage(hashMap2, hashMap, new RpcService.Callback<UploadAvatarResponse>() {
            public void onSuccess(UploadAvatarResponse uploadAvatarResponse) {
                if (uploadAvatarResponse.errno == 0) {
                    ProgressDialogFragment progressDialogFragment = progressDialogFragment;
                    if (progressDialogFragment != null) {
                        progressDialogFragment.dismiss();
                    }
                    UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(DIDIApplication.getAppContext());
                    if (userInfo != null) {
                        userInfo.setHead_url(uploadAvatarResponse.getHead_url());
                        userInfo.setAvatar(uploadAvatarResponse.getAvatarUrl());
                    }
                    AccountStore.this.dispatch(AccountStore.ACTION_MODIFY_USERAVATAR, CommonDispatchMessage.getSuccessMessage(uploadAvatarResponse));
                    AccountStore.this.dispatch(AccountStore.ACTION_MODIFY_ALL_INFO, CommonDispatchMessage.getSuccessMessage(uploadAvatarResponse));
                    if (uploadAvatarResponse.getErrorCode() == 0) {
                        AccountStore.this.dispatch(AccountStore.ACTION_MODIFY_USER_TO_SIDEBAR, CommonDispatchMessage.getSuccessMessage(uploadAvatarResponse));
                        return;
                    }
                    return;
                }
                ProgressDialogFragment progressDialogFragment2 = progressDialogFragment;
                if (progressDialogFragment2 != null) {
                    progressDialogFragment2.dismiss();
                }
                if (!SideBarBusinessUtil.isRedirectToLogin(context, uploadAvatarResponse)) {
                    AccountStore.this.dispatch(AccountStore.ACTION_MODIFY_USERAVATAR, CommonDispatchMessage.getErrorMessage(uploadAvatarResponse));
                    AccountStore.this.dispatch(AccountStore.ACTION_MODIFY_ALL_INFO, CommonDispatchMessage.getErrorMessage(uploadAvatarResponse));
                }
            }

            public void onFailure(IOException iOException) {
                ProgressDialogFragment progressDialogFragment = progressDialogFragment;
                if (progressDialogFragment != null) {
                    progressDialogFragment.dismiss();
                }
                AccountStore.this.dispatch(AccountStore.ACTION_MODIFY_USERAVATAR, CommonDispatchMessage.getNetworkErrorMessage());
                AccountStore.this.dispatch(AccountStore.ACTION_MODIFY_ALL_INFO, CommonDispatchMessage.getNetworkErrorMessage());
            }
        });
    }
}
