package com.didi.global.ninja.strategy;

public class StrategyConfigs {
    public static final String FACEBOOK_LOGIN_CONFIG = "{    \"FACEBOOK_LOGIN\": [        \"com.facebook.login.LoginManager\",        \"com.facebook.FacebookSdk\"    ]\n}";
    public static final String FACE_SHARE_CONFIG = "{    \"FACEBOOK_SHARE\":[\n        \"com.didi.onekeyshare.wrapper.FacebookPlatform\",        \"com.didi.onekeyshare.wrapper.DispatchFacebookShareCbActivity\",        \"com.facebook.share.widget.ShareDialog\",        \"com.facebook.internal.FacebookDialogBase\",        \"com.didi.sharesdk.ShareApi\",        \"com.facebook.FacebookSdk\"    ]}";
    public static final String GOOGLE_LOGIN_CONFIG = "{    \"GOOGLE_LOGIN\": [        \"com.didi.googlelogin.GoogleLoginHelper\",        \"com.google.android.gms.auth.api.signin\"    ]}";
    public static final String NINJA_DEMO = "{\"test\": [\"com.didi.global.ninja.test\"]}";
    public static final String SHARE_CONFIG = "{    \"COPYLINK_SHARE\":[       \"com.didi.onekeyshare.wrapper.CopyLinkPlatform\"    ],    \"EMAIL_SHARE\":[       \"com.didi.onekeyshare.wrapper.EmailPlatform\"    ],    \"SAVEIMAGE_SHARE\":[       \"com.didi.onekeyshare.wrapper.SaveImagePlatForm\"    ],    \"INTERNATIONAL_SHARE\":[       \"com.didi.onekeyshare.wrapper.InternationalPlatform\"    ]}";
}
