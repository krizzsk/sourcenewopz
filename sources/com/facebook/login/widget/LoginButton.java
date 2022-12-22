package com.facebook.login.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.LoginTargetApp;
import com.facebook.login.widget.ToolTipPopup;
import com.taxis99.R;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class LoginButton extends FacebookButtonBase {
    private static final int MAX_BUTTON_TRANSPARENCY = 255;
    private static final int MIN_BUTTON_TRANSPARENCY = 0;
    private static final String TAG = LoginButton.class.getName();
    private AccessTokenTracker accessTokenTracker;
    /* access modifiers changed from: private */
    public CallbackManager callbackManager = null;
    /* access modifiers changed from: private */
    public boolean confirmLogout;
    private Float customButtonRadius;
    private int customButtonTransparency = 255;
    private final String loggerID = UUID.randomUUID().toString();
    /* access modifiers changed from: private */
    public String loginLogoutEventName = AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE;
    private LoginManager loginManager;
    private String loginText;
    private String logoutText;
    protected LoginButtonProperties properties = new LoginButtonProperties();
    private boolean toolTipChecked;
    private long toolTipDisplayTime = 6000;
    private ToolTipMode toolTipMode;
    private ToolTipPopup toolTipPopup;
    private ToolTipPopup.Style toolTipStyle = ToolTipPopup.Style.BLUE;

    /* access modifiers changed from: protected */
    public int getDefaultStyleResource() {
        return R.style.com_facebook_loginview_default_style;
    }

    /* access modifiers changed from: protected */
    public int getLoginButtonContinueLabel() {
        return R.string.com_facebook_loginview_log_in_button_continue;
    }

    public enum ToolTipMode {
        AUTOMATIC(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);
        
        public static ToolTipMode DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            ToolTipMode toolTipMode;
            DEFAULT = toolTipMode;
        }

        public static ToolTipMode fromInt(int i) {
            for (ToolTipMode toolTipMode : values()) {
                if (toolTipMode.getValue() == i) {
                    return toolTipMode;
                }
            }
            return null;
        }

        private ToolTipMode(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public String toString() {
            return this.stringValue;
        }

        public int getValue() {
            return this.intValue;
        }
    }

    static class LoginButtonProperties {
        private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
        private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
        private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        private String messengerPageId;
        /* access modifiers changed from: private */
        public List<String> permissions = Collections.emptyList();
        private boolean resetMessengerState;
        private boolean shouldSkipAccountDeduplication = false;
        private LoginTargetApp targetApp = LoginTargetApp.FACEBOOK;

        LoginButtonProperties() {
        }

        public void setDefaultAudience(DefaultAudience defaultAudience2) {
            this.defaultAudience = defaultAudience2;
        }

        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public void setPermissions(List<String> list) {
            this.permissions = list;
        }

        /* access modifiers changed from: package-private */
        public List<String> getPermissions() {
            return this.permissions;
        }

        public void clearPermissions() {
            this.permissions = null;
        }

        public void setLoginBehavior(LoginBehavior loginBehavior2) {
            this.loginBehavior = loginBehavior2;
        }

        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public void setLoginTargetApp(LoginTargetApp loginTargetApp) {
            this.targetApp = loginTargetApp;
        }

        public LoginTargetApp getLoginTargetApp() {
            return this.targetApp;
        }

        public String getAuthType() {
            return this.authType;
        }

        public void setAuthType(String str) {
            this.authType = str;
        }

        /* access modifiers changed from: protected */
        public void setShouldSkipAccountDeduplication(boolean z) {
            this.shouldSkipAccountDeduplication = z;
        }

        public boolean getShouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        public String getMessengerPageId() {
            return this.messengerPageId;
        }

        public void setMessengerPageId(String str) {
            this.messengerPageId = str;
        }

        public boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public void setResetMessengerState(boolean z) {
            this.resetMessengerState = z;
        }
    }

    public LoginButton(Context context) {
        super(context, (AttributeSet) null, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    protected LoginButton(Context context, AttributeSet attributeSet, int i, int i2, String str, String str2) {
        super(context, attributeSet, i, i2, str, str2);
    }

    public void setLoginText(String str) {
        this.loginText = str;
        setButtonText();
    }

    public void setLogoutText(String str) {
        this.logoutText = str;
        setButtonText();
    }

    public void setDefaultAudience(DefaultAudience defaultAudience) {
        this.properties.setDefaultAudience(defaultAudience);
    }

    public DefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    public void setReadPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    public void setReadPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public void setPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    public void setPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public void setPublishPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    public void setPublishPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public void clearPermissions() {
        this.properties.clearPermissions();
    }

    public void setLoginBehavior(LoginBehavior loginBehavior) {
        this.properties.setLoginBehavior(loginBehavior);
    }

    public LoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    public void setLoginTargetApp(LoginTargetApp loginTargetApp) {
        this.properties.setLoginTargetApp(loginTargetApp);
    }

    public LoginTargetApp getLoginTargetApp() {
        return this.properties.getLoginTargetApp();
    }

    public String getAuthType() {
        return this.properties.getAuthType();
    }

    public String getMessengerPageId() {
        return this.properties.getMessengerPageId();
    }

    public boolean getResetMessengerState() {
        return this.properties.getResetMessengerState();
    }

    public void setAuthType(String str) {
        this.properties.setAuthType(str);
    }

    public void setMessengerPageId(String str) {
        this.properties.setMessengerPageId(str);
    }

    public void setResetMessengerState(boolean z) {
        this.properties.setResetMessengerState(z);
    }

    public void setToolTipStyle(ToolTipPopup.Style style) {
        this.toolTipStyle = style;
    }

    public void setToolTipMode(ToolTipMode toolTipMode2) {
        this.toolTipMode = toolTipMode2;
    }

    public ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    public void setToolTipDisplayTime(long j) {
        this.toolTipDisplayTime = j;
    }

    public boolean getShouldSkipAccountDeduplication() {
        return this.properties.getShouldSkipAccountDeduplication();
    }

    public long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    public String getLoggerID() {
        return this.loggerID;
    }

    public void dismissToolTip() {
        ToolTipPopup toolTipPopup2 = this.toolTipPopup;
        if (toolTipPopup2 != null) {
            toolTipPopup2.dismiss();
            this.toolTipPopup = null;
        }
    }

    public void registerCallback(CallbackManager callbackManager2, FacebookCallback<LoginResult> facebookCallback) {
        getLoginManager().registerCallback(callbackManager2, facebookCallback);
        CallbackManager callbackManager3 = this.callbackManager;
        if (callbackManager3 == null) {
            this.callbackManager = callbackManager2;
        } else if (callbackManager3 != callbackManager2) {
            SystemUtils.log(5, TAG, "You're registering a callback on the one Facebook login button with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.", (Throwable) null, "com.facebook.login.widget.LoginButton", 640);
        }
    }

    public void unregisterCallback(CallbackManager callbackManager2) {
        getLoginManager().unregisterCallback(callbackManager2);
    }

    public CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onAttachedToWindow();
                if (this.accessTokenTracker != null && !this.accessTokenTracker.isTracking()) {
                    this.accessTokenTracker.startTracking();
                    setButtonText();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onDraw(canvas);
                if (!this.toolTipChecked && !isInEditMode()) {
                    this.toolTipChecked = true;
                    checkToolTipSettings();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void showToolTipPerSettings(FetchedAppSettings fetchedAppSettings) {
        if (!CrashShieldHandler.isObjectCrashing(this) && fetchedAppSettings != null) {
            try {
                if (fetchedAppSettings.getNuxEnabled() && getVisibility() == 0) {
                    displayToolTip(fetchedAppSettings.getNuxContent());
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void displayToolTip(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                ToolTipPopup toolTipPopup2 = new ToolTipPopup(str, this);
                this.toolTipPopup = toolTipPopup2;
                toolTipPopup2.setStyle(this.toolTipStyle);
                this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
                this.toolTipPopup.show();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* renamed from: com.facebook.login.widget.LoginButton$3 */
    static /* synthetic */ class C177443 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.login.widget.LoginButton$ToolTipMode[] r0 = com.facebook.login.widget.LoginButton.ToolTipMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode = r0
                com.facebook.login.widget.LoginButton$ToolTipMode r1 = com.facebook.login.widget.LoginButton.ToolTipMode.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.login.widget.LoginButton$ToolTipMode r1 = com.facebook.login.widget.LoginButton.ToolTipMode.DISPLAY_ALWAYS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.login.widget.LoginButton$ToolTipMode r1 = com.facebook.login.widget.LoginButton.ToolTipMode.NEVER_DISPLAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.widget.LoginButton.C177443.<clinit>():void");
        }
    }

    private void checkToolTipSettings() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                int i = C177443.$SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[this.toolTipMode.ordinal()];
                if (i == 1) {
                    final String metadataApplicationId = Utility.getMetadataApplicationId(getContext());
                    FacebookSdk.getExecutor().execute(new Runnable() {
                        public void run() {
                            if (!CrashShieldHandler.isObjectCrashing(this)) {
                                try {
                                    final FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(metadataApplicationId, false);
                                    LoginButton.this.getActivity().runOnUiThread(new Runnable() {
                                        public void run() {
                                            if (!CrashShieldHandler.isObjectCrashing(this)) {
                                                try {
                                                    LoginButton.this.showToolTipPerSettings(queryAppSettings);
                                                } catch (Throwable th) {
                                                    CrashShieldHandler.handleThrowable(th, this);
                                                }
                                            }
                                        }
                                    });
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        }
                    });
                } else if (i == 2) {
                    displayToolTip(getResources().getString(R.string.com_facebook_tooltip_default));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onLayout(z, i, i2, i3, i4);
                setButtonText();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onDetachedFromWindow();
                if (this.accessTokenTracker != null) {
                    this.accessTokenTracker.stopTracking();
                }
                dismissToolTip();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onVisibilityChanged(view, i);
                if (i != 0) {
                    dismissToolTip();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<String> getPermissions() {
        return this.properties.getPermissions();
    }

    /* access modifiers changed from: package-private */
    public void setProperties(LoginButtonProperties loginButtonProperties) {
        this.properties = loginButtonProperties;
    }

    /* access modifiers changed from: protected */
    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.configureButton(context, attributeSet, i, i2);
                setInternalOnClickListener(getNewLoginClickListener());
                parseLoginButtonAttributes(context, attributeSet, i, i2);
                if (isInEditMode()) {
                    setBackgroundColor(getResources().getColor(R.color.com_facebook_blue));
                    this.loginText = "Continue with Facebook";
                } else {
                    this.accessTokenTracker = new AccessTokenTracker() {
                        /* access modifiers changed from: protected */
                        public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                            LoginButton.this.setButtonText();
                            LoginButton.this.setButtonIcon();
                        }
                    };
                }
                setButtonText();
                setButtonRadius();
                setButtonTransparency();
                setButtonIcon();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public LoginClickListener getNewLoginClickListener() {
        return new LoginClickListener();
    }

    /* access modifiers changed from: protected */
    public void parseLoginButtonAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.toolTipMode = ToolTipMode.DEFAULT;
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C10448R.styleable.com_facebook_login_view, i, i2);
                this.confirmLogout = obtainStyledAttributes.getBoolean(0, true);
                this.loginText = obtainStyledAttributes.getString(3);
                this.logoutText = obtainStyledAttributes.getString(4);
                this.toolTipMode = ToolTipMode.fromInt(obtainStyledAttributes.getInt(5, ToolTipMode.DEFAULT.getValue()));
                if (obtainStyledAttributes.hasValue(1)) {
                    this.customButtonRadius = Float.valueOf(obtainStyledAttributes.getDimension(1, 0.0f));
                }
                int integer = obtainStyledAttributes.getInteger(2, 255);
                this.customButtonTransparency = integer;
                if (integer < 0) {
                    this.customButtonTransparency = 0;
                }
                if (this.customButtonTransparency > 255) {
                    this.customButtonTransparency = 255;
                }
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
                int compoundPaddingTop = getCompoundPaddingTop() + ((int) Math.ceil((double) (Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom)))) + getCompoundPaddingBottom();
                Resources resources = getResources();
                int loginButtonWidth = getLoginButtonWidth(i);
                String str = this.logoutText;
                if (str == null) {
                    str = resources.getString(R.string.com_facebook_loginview_log_out_button);
                }
                setMeasuredDimension(resolveSize(Math.max(loginButtonWidth, measureButtonWidth(str)), i), compoundPaddingTop);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getLoginButtonWidth(int i) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            Resources resources = getResources();
            String str = this.loginText;
            if (str == null) {
                str = resources.getString(R.string.com_facebook_loginview_log_in_button_continue);
                int measureButtonWidth = measureButtonWidth(str);
                if (resolveSize(measureButtonWidth, i) < measureButtonWidth) {
                    str = resources.getString(R.string.com_facebook_loginview_log_in_button);
                }
            }
            return measureButtonWidth(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    private int measureButtonWidth(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return getCompoundPaddingLeft() + getCompoundDrawablePadding() + measureTextWidth(str) + getCompoundPaddingRight();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void setButtonText() {
        String str;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Resources resources = getResources();
                if (!isInEditMode() && AccessToken.isCurrentAccessTokenActive()) {
                    if (this.logoutText != null) {
                        str = this.logoutText;
                    } else {
                        str = resources.getString(R.string.com_facebook_loginview_log_out_button);
                    }
                    setText(str);
                } else if (this.loginText != null) {
                    setText(this.loginText);
                } else {
                    String string = resources.getString(getLoginButtonContinueLabel());
                    int width = getWidth();
                    if (width != 0 && measureButtonWidth(string) > width) {
                        string = resources.getString(R.string.com_facebook_loginview_log_in_button);
                    }
                    setText(string);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setButtonIcon() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setButtonRadius() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.customButtonRadius != null) {
                    Drawable background = getBackground();
                    if (Build.VERSION.SDK_INT >= 29 && (background instanceof StateListDrawable)) {
                        StateListDrawable stateListDrawable = (StateListDrawable) background;
                        for (int i = 0; i < stateListDrawable.getStateCount(); i++) {
                            GradientDrawable gradientDrawable = (GradientDrawable) stateListDrawable.getStateDrawable(i);
                            if (gradientDrawable != null) {
                                gradientDrawable.setCornerRadius(this.customButtonRadius.floatValue());
                            }
                        }
                    }
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setCornerRadius(this.customButtonRadius.floatValue());
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setButtonTransparency() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                getBackground().setAlpha(this.customButtonTransparency);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getDefaultRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public LoginManager getLoginManager() {
        if (this.loginManager == null) {
            this.loginManager = LoginManager.getInstance();
        }
        return this.loginManager;
    }

    /* access modifiers changed from: package-private */
    public void setLoginManager(LoginManager loginManager2) {
        this.loginManager = loginManager2;
    }

    protected class LoginClickListener implements View.OnClickListener {
        /* access modifiers changed from: protected */
        public boolean isFamilyLogin() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
            }
            return false;
        }

        protected LoginClickListener() {
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    LoginButton.this.callExternalOnClickListener(view);
                    AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                    if (AccessToken.isCurrentAccessTokenActive()) {
                        performLogout(LoginButton.this.getContext());
                    } else {
                        performLogin();
                    }
                    InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(LoginButton.this.getContext());
                    Bundle bundle = new Bundle();
                    int i = 0;
                    bundle.putInt("logging_in", currentAccessToken != null ? 0 : 1);
                    if (AccessToken.isCurrentAccessTokenActive()) {
                        i = 1;
                    }
                    bundle.putInt("access_token_expired", i);
                    internalAppEventsLogger.logEventImplicitly(LoginButton.this.loginLogoutEventName, bundle);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void performLogin() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    LoginManager loginManager = getLoginManager();
                    if (LoginButton.this.getAndroidxActivityResultRegistryOwner() != null) {
                        loginManager.logIn(LoginButton.this.getAndroidxActivityResultRegistryOwner(), LoginButton.this.callbackManager != null ? LoginButton.this.callbackManager : new CallbackManagerImpl(), LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                    } else if (LoginButton.this.getFragment() != null) {
                        loginManager.logIn(LoginButton.this.getFragment(), (Collection<String>) LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                    } else if (LoginButton.this.getNativeFragment() != null) {
                        loginManager.logIn(LoginButton.this.getNativeFragment(), (Collection<String>) LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                    } else {
                        loginManager.logIn(LoginButton.this.getActivity(), (Collection<String>) LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void performLogout(Context context) {
            String str;
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    final LoginManager loginManager = getLoginManager();
                    if (LoginButton.this.confirmLogout) {
                        String string = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_log_out_action);
                        String string2 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_cancel_action);
                        Profile currentProfile = Profile.getCurrentProfile();
                        if (currentProfile == null || currentProfile.getName() == null) {
                            str = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
                        } else {
                            str = String.format(LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_as), new Object[]{currentProfile.getName()});
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage(str).setCancelable(true).setPositiveButton(string, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                                loginManager.logOut();
                            }
                        }).setNegativeButton(string2, (DialogInterface.OnClickListener) null);
                        SystemUtils.showDialog(builder.create());
                        return;
                    }
                    loginManager.logOut();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        /* access modifiers changed from: protected */
        public LoginManager getLoginManager() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                LoginManager instance = LoginManager.getInstance();
                instance.setDefaultAudience(LoginButton.this.getDefaultAudience());
                instance.setLoginBehavior(LoginButton.this.getLoginBehavior());
                instance.setLoginTargetApp(getLoginTargetApp());
                instance.setAuthType(LoginButton.this.getAuthType());
                instance.setFamilyLogin(isFamilyLogin());
                instance.setShouldSkipAccountDeduplication(LoginButton.this.getShouldSkipAccountDeduplication());
                instance.setMessengerPageId(LoginButton.this.getMessengerPageId());
                instance.setResetMessengerState(LoginButton.this.getResetMessengerState());
                return instance;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public LoginTargetApp getLoginTargetApp() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return LoginTargetApp.FACEBOOK;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }
}
