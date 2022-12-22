package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.gamingservices.model.ContextSwitchContent;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContextSwitchDialog extends FacebookDialogBase<ContextSwitchContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GamingContextSwitch.toRequestCode();
    /* access modifiers changed from: private */
    public FacebookCallback mCallback;

    public ContextSwitchDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public ContextSwitchDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public ContextSwitchDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private ContextSwitchDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    public boolean canShow(ContextSwitchContent contextSwitchContent) {
        if (!CloudGameLoginHandler.isRunningInCloud() && !new FacebookAppHandler().canShow(contextSwitchContent, true) && !new WebHandler().canShow(contextSwitchContent, true)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void showImpl(ContextSwitchContent contextSwitchContent, Object obj) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            showForCloud(contextSwitchContent, obj);
        } else {
            super.showImpl(contextSwitchContent, obj);
        }
    }

    private void showForCloud(ContextSwitchContent contextSwitchContent, Object obj) {
        Activity activityContext = getActivityContext();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to open ContextSwitchContent with an invalid access token");
        }
        C176041 r0 = new DaemonRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                if (ContextSwitchDialog.this.mCallback == null) {
                    return;
                }
                if (graphResponse.getError() != null) {
                    ContextSwitchDialog.this.mCallback.onError(new FacebookException(graphResponse.getError().getErrorMessage()));
                } else {
                    ContextSwitchDialog.this.mCallback.onSuccess(new Result(graphResponse));
                }
            }
        };
        String contextID = contextSwitchContent.getContextID();
        if (contextID == null) {
            FacebookCallback facebookCallback = this.mCallback;
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookException("Required string contextID not provided."));
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", contextID);
            DaemonRequest.executeAsync((Context) activityContext, jSONObject, (DaemonRequest.Callback) r0, SDKMessageEnum.CONTEXT_SWITCH);
        } catch (JSONException unused) {
            FacebookCallback facebookCallback2 = this.mCallback;
            if (facebookCallback2 != null) {
                facebookCallback2.onError(new FacebookException("Couldn't prepare Context Switch Dialog"));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback facebookCallback) {
        final C176052 r4;
        this.mCallback = facebookCallback;
        if (facebookCallback == null) {
            r4 = null;
        } else {
            r4 = new ResultProcessor(facebookCallback) {
                public void onSuccess(AppCall appCall, Bundle bundle) {
                    if (bundle == null) {
                        onCancel(appCall);
                    } else if (bundle.getString("error_message") != null) {
                        facebookCallback.onError(new FacebookException(bundle.getString("error_message")));
                    } else {
                        if (bundle.getString("id") != null) {
                            GamingContext.setCurrentGamingContext(new GamingContext(bundle.getString("id")));
                            facebookCallback.onSuccess(new Result(bundle.getString("id")));
                        } else if (bundle.getString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID) != null) {
                            GamingContext.setCurrentGamingContext(new GamingContext(bundle.getString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID)));
                            facebookCallback.onSuccess(new Result(bundle.getString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID)));
                        }
                        facebookCallback.onError(new FacebookException(bundle.getString("Invalid response received from server.")));
                    }
                }
            };
        }
        callbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() {
            public boolean onActivityResult(int i, Intent intent) {
                return ShareInternalUtility.handleActivityResult(ContextSwitchDialog.this.getRequestCode(), i, intent, r4);
            }
        });
    }

    /* access modifiers changed from: protected */
    public List<FacebookDialogBase<ContextSwitchContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FacebookAppHandler());
        arrayList.add(new WebHandler());
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    public static final class Result {
        String contextID;

        private Result(String str) {
            this.contextID = str;
        }

        private Result(GraphResponse graphResponse) {
            try {
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    this.contextID = null;
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                this.contextID = optJSONObject != null ? optJSONObject.getString("id") : null;
            } catch (JSONException unused) {
                this.contextID = null;
            }
        }

        public String getContextID() {
            return this.contextID;
        }
    }

    private class WebHandler extends FacebookDialogBase<ContextSwitchContent, Result>.ModeHandler {
        public boolean canShow(ContextSwitchContent contextSwitchContent, boolean z) {
            return true;
        }

        private WebHandler() {
            super(ContextSwitchDialog.this);
        }

        public AppCall createAppCall(ContextSwitchContent contextSwitchContent) {
            AppCall createBaseAppCall = ContextSwitchDialog.this.createBaseAppCall();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID, contextSwitchContent.getContextID());
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                bundle.putString("dialog_access_token", currentAccessToken.getToken());
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, "context", bundle);
            return createBaseAppCall;
        }
    }

    private class FacebookAppHandler extends FacebookDialogBase<ContextSwitchContent, Result>.ModeHandler {
        private FacebookAppHandler() {
            super(ContextSwitchDialog.this);
        }

        public boolean canShow(ContextSwitchContent contextSwitchContent, boolean z) {
            PackageManager packageManager = ContextSwitchDialog.this.getActivityContext().getPackageManager();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            boolean z2 = intent.resolveActivity(packageManager) != null;
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            boolean z3 = (currentAccessToken == null || currentAccessToken.getGraphDomain() == null || !FacebookSdk.GAMING.equals(currentAccessToken.getGraphDomain())) ? false : true;
            if (!z2 || !z3) {
                return false;
            }
            return true;
        }

        public AppCall createAppCall(ContextSwitchContent contextSwitchContent) {
            AppCall createBaseAppCall = ContextSwitchDialog.this.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString("deeplink", "CONTEXT_SWITCH");
            if (currentAccessToken != null) {
                bundle.putString("game_id", currentAccessToken.getApplicationId());
            } else {
                bundle.putString("game_id", FacebookSdk.getApplicationId());
            }
            if (contextSwitchContent.getContextID() != null) {
                bundle.putString("context_token_id", contextSwitchContent.getContextID());
            }
            NativeProtocol.setupProtocolRequestIntent(intent, createBaseAppCall.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle);
            createBaseAppCall.setRequestIntent(intent);
            return createBaseAppCall;
        }
    }
}
