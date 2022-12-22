package com.cardinalcommerce.p060a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* renamed from: com.cardinalcommerce.a.setLastBaselineToBottomHeight */
public final class setLastBaselineToBottomHeight {
    public int ASN1ObjectIdentifier;
    public int Cardinal;
    public char[] CardinalActionCode;
    public char[] CardinalConfigurationParameters;
    public char[] CardinalEnvironment;
    public char[] CardinalError;
    public char[] CardinalInitService;
    public char[] CardinalRenderType;
    public char[] CardinalUiType;
    public int CardinalValidateReceiver;
    public int DSA;
    public int Payment;
    public int PrivateKeyInfo;
    public int ValidateResponse;
    public int cca_continue;
    public int cleanup;
    public int configure;
    public int getActionCode;
    public int getChallengeTimeout;
    public char[] getEnvironment;
    public char[] getErrorDescription;
    public char[] getErrorNumber;
    public char[] getExtendedData;
    public int getInstance;
    public int getJSON;
    public int getPayment;
    public char[] getProcessorTransactionId;
    public char[] getProxyAddress;
    public char[] getRenderType;
    public int getRequestTimeout;
    public char[] getSDKVersion;
    public char[] getString;
    public char[] getThreeDSRequestorAppURL;
    public int getType;
    public int getUICustomization;
    public char[] getUiType;
    public char[] getWarnings;
    public char[] init;
    public int isEnableDFSync;
    public char[] isEnableLogging;
    public char[] isLocationDataConsentGiven;
    public int isValidated;
    public char[] onSetupCompleted;
    public int onValidated;
    public char[] setChallengeTimeout;
    public int setEnableDFSync;
    public char[] setEnableLogging;
    public char[] setEnvironment;
    public int setLocationDataConsentGiven;
    public int setProxyAddress;
    public char[] setRenderType;
    public int setRequestTimeout;
    public char[] setThreeDSRequestorAppURL;
    public int setUICustomization;
    public char[] setUiType;
    public char[] valueOf;
    public char[] values;

    setLastBaselineToBottomHeight(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        this.configure = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", -1);
        this.getInstance = Settings.System.getInt(context.getContentResolver(), "bluetooth_discoverability", 0);
        this.cca_continue = Settings.System.getInt(context.getContentResolver(), "bluetooth_discoverability_timeout", 0);
        this.Cardinal = Settings.System.getInt(context.getContentResolver(), "date_format", 0);
        if (Build.VERSION.SDK_INT >= 23) {
            this.getEnvironment = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "dtmf_tone_type"));
        }
        this.init = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "dtmf_tone"));
        this.cleanup = Settings.System.getInt(context.getContentResolver(), "end_button_behavior", 0);
        this.getWarnings = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "font_scale"));
        this.values = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "haptic_feedback_enabled"));
        this.CardinalError = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "mode_ringer_streams_affected"));
        this.getSDKVersion = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "notification_sound"));
        this.CardinalEnvironment = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "mute_streams_affected"));
        this.CardinalRenderType = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "ringtone"));
        this.CardinalUiType = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "screen_brightness"));
        this.CardinalActionCode = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "screen_brightness_mode"));
        this.valueOf = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "screen_off_timeout"));
        this.CardinalConfigurationParameters = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "sound_effects_enabled"));
        this.getActionCode = Settings.System.getInt(context.getContentResolver(), "auto_caps", 0);
        this.setRequestTimeout = Settings.System.getInt(context.getContentResolver(), "auto_punctuate", -1);
        this.getRequestTimeout = Settings.System.getInt(context.getContentResolver(), "auto_replace", 0);
        this.getString = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "show_password"));
        this.setChallengeTimeout = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "time_12_24"));
        this.getProxyAddress = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "user_rotation"));
        this.getChallengeTimeout = Settings.System.getInt(context.getContentResolver(), "vibrate_on", 0);
        if (Build.VERSION.SDK_INT >= 23) {
            this.setEnvironment = setHorizontallyScrolling.getInstance(Settings.System.getString(context.getContentResolver(), "vibrate_when_ringing"));
        }
        this.isEnableLogging = setHorizontallyScrolling.getInstance(Settings.Global.getString(contentResolver, "adb_enabled"));
        this.isLocationDataConsentGiven = setHorizontallyScrolling.getInstance(Settings.Global.getString(contentResolver, "airplane_mode_radios"));
        this.setLocationDataConsentGiven = Settings.Global.getInt(contentResolver, "always_finish_activities", 0);
        this.getPayment = Settings.Global.getInt(contentResolver, "animator_duration_scale", 1);
        this.setEnableLogging = setHorizontallyScrolling.getInstance(Settings.Global.getString(contentResolver, "auto_time"));
        this.setThreeDSRequestorAppURL = setHorizontallyScrolling.getInstance(Settings.Global.getString(contentResolver, "auto_time_zone"));
        this.getExtendedData = setHorizontallyScrolling.getInstance(Settings.Global.getString(contentResolver, "development_settings_enabled"));
        this.getType = Settings.Global.getInt(contentResolver, "http_proxy", 0);
        this.getJSON = Settings.Global.getInt(contentResolver, "network_preference", 0);
        this.getProcessorTransactionId = setHorizontallyScrolling.getInstance(Settings.Global.getString(contentResolver, "stay_on_while_plugged_in"));
        this.Payment = Settings.Global.getInt(contentResolver, "transition_animation_scale", 0);
        this.getErrorNumber = setHorizontallyScrolling.getInstance(Settings.Global.getString(contentResolver, "usb_mass_storage_enabled"));
        this.ValidateResponse = Settings.Global.getInt(contentResolver, "use_google_mail", 0);
        this.isValidated = Settings.Global.getInt(contentResolver, "wait_for_debugger", 0);
        this.getErrorDescription = setHorizontallyScrolling.getInstance(Settings.Global.getString(contentResolver, "wifi_networks_available_notification_on"));
        this.setRenderType = setHorizontallyScrolling.getInstance(Settings.Secure.getString(contentResolver, "accessibility_enabled"));
        this.getUiType = setHorizontallyScrolling.getInstance(Settings.Secure.getString(contentResolver, "speak_password"));
        this.getRenderType = setHorizontallyScrolling.getInstance(Settings.Secure.getString(contentResolver, "allowed_geolocation_origins"));
        this.setUiType = setHorizontallyScrolling.getInstance(Settings.Secure.getString(contentResolver, "default_input_method"));
        this.setUICustomization = Settings.Secure.getInt(contentResolver, "enabled_input_methods", 0);
        this.setProxyAddress = Settings.Secure.getInt(contentResolver, "input_method_selector_visibility", 0);
        this.getThreeDSRequestorAppURL = setHorizontallyScrolling.getInstance(Settings.Secure.getString(contentResolver, "install_non_market_apps"));
        this.DSA = Settings.Secure.getInt(contentResolver, "location_mode", 0);
        this.PrivateKeyInfo = Settings.Secure.getInt(contentResolver, "accessibility_display_inversion_enabled", 0);
        this.onValidated = Settings.Secure.getInt(contentResolver, "enabled_accessibility_services", 0);
        this.CardinalValidateReceiver = Settings.Secure.getInt(contentResolver, "skip_first_use_hints", 0);
        this.ASN1ObjectIdentifier = Settings.Secure.getInt(contentResolver, "tts_default_pitch", 0);
        this.getUICustomization = Settings.Secure.getInt(contentResolver, "tts_default_rate", 0);
        this.setEnableDFSync = Settings.Secure.getInt(contentResolver, "tts_default_synth", 0);
        this.isEnableDFSync = Settings.Secure.getInt(contentResolver, "tts_enabled_plugins", 0);
        if (Build.VERSION.SDK_INT <= 30) {
            this.onSetupCompleted = setHorizontallyScrolling.getInstance(Settings.Global.getString(contentResolver, "data_roaming"));
        }
        this.CardinalInitService = setHorizontallyScrolling.getInstance(Settings.Secure.getString(contentResolver, "device_provisioned"));
    }
}
