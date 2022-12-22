package com.iproov.sdk.bridge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.iproov.sdk.IProov;
import com.iproov.sdk.core.exception.InvalidOptionsException;
import java.util.List;
import org.json.JSONObject;
import p093switch.C3128try;
import rui.config.RConfigConstants;

public class OptionsBridge {
    public static final String ACTIVITY_REQUEST_CODE_KEY = "activity_compatibility_request_code";
    public static final String AUTO_START_DISABLED_KEY = "auto_start_disabled";
    public static final String BACKGROUND_COLOR_KEY = "background_color";
    public static final String CAMERA_KEY = "camera";
    public static final String CAPTURE_KEY = "capture";
    public static final String CERTIFICATES_KEY = "certificates";
    public static final String CUSTOM_VALUE = "custom";
    private static final IProov.Options DEFAULTS = new IProov.Options();
    public static final String DEFAULT_VALUE = "default";
    public static final String EMPTY_VALUE = "empty";
    public static final String ENABLE_SCREENSHOTS_KEY = "enable_screenshots";
    public static final String FACE_DETECTOR_KEY = "face_detector";
    public static final String FILTER_KEY = "filter";
    public static final String FLOATING_PROMPT_ENABLED = "floating_prompt_enabled";
    public static final String FONT_PATH_KEY = "font_path";
    public static final String FONT_RESOURCE_KEY = "font_resource";
    public static final String FOOTER_BACKGROUND_COLOR_KEY = "footer_background_color";
    public static final String FOOTER_TEXT_COLOR_KEY = "footer_text_color";
    public static final String GENUINE_PRESENCE_ASSURANCE_KEY = "genuine_presence_assurance";
    public static final String HEADER_BACKGROUND_COLOR_KEY = "header_background_color";
    public static final String HEADER_TEXT_COLOR_KEY = "header_text_color";
    public static final String LINE_COLOR_KEY = "line_color";
    public static final String LIVENESS_ASSURANCE_KEY = "liveness_assurance";
    public static final String LIVENESS_PRIMARY_TINT_COLOR_KEY = "primary_tint_color";
    public static final String LIVENESS_SCANNING_COLOR_KEY = "liveness_scanning_color";
    public static final String LIVENESS_SECONDARY_TINT_COLOR_KEY = "secondary_tint_color";
    public static final String LIVENESS_TINT_COLOR_KEY = "liveness_tint_color";
    public static final String LOGO_IMAGE_KEY = "logo_image";
    public static final String LOGO_IMAGE_RESOURCE_KEY = "logo_image_resource";
    public static final String MAX_PITCH_KEY = "max_pitch";
    public static final String MAX_ROLL_KEY = "max_roll";
    public static final String MAX_YAW_KEY = "max_yaw";
    public static final String NETWORK_KEY = "network";
    public static final String NOT_READY_TINT_COLOR_KEY = "not_ready_tint_color";
    public static final String NULL_VALUE = "null";
    public static final String ORIENTATION_KEY = "orientation";
    public static final String PATH_KEY = "path";
    public static final String PROGRESS_BAR_COLOR_KEY = "progress_bar_color";
    public static final String PROMPT_TEXT_COLOR_KEY = "prompt_text_color";
    public static final String READY_TINT_COLOR_KEY = "ready_tint_color";
    private static final String TAG = "OptionsBridge";
    public static final String TIMEOUT_KEY = "timeout";
    public static final String TITLE_KEY = "title";
    public static final String UI_KEY = "ui";

    static String asAnalytics(Object obj, Object obj2) {
        if (obj != null && obj.equals(obj2)) {
            return "default";
        }
        if (obj == null && obj2 == null) {
            return "default";
        }
        if ((obj instanceof List) && ((List) obj).isEmpty()) {
            return "empty";
        }
        if (!(obj instanceof String) || !((String) obj).isEmpty()) {
            return obj == null ? "null" : "custom";
        }
        return "empty";
    }

    private static IProov.Options.Capture captureOptionsFromJson(JSONObject jSONObject) {
        IProov.Options.Capture capture = new IProov.Options.Capture();
        if (jSONObject == null) {
            return capture;
        }
        capture.camera = C3128try.m4067do(jSONObject, "camera", capture.camera);
        capture.faceDetector = C3128try.m4068do(jSONObject, FACE_DETECTOR_KEY, capture.faceDetector);
        if (jSONObject.has(GENUINE_PRESENCE_ASSURANCE_KEY)) {
            capture.genuinePresenceAssurance = genuinePresenceAssuranceCaptureOptionsFromJSON(jSONObject.optJSONObject(GENUINE_PRESENCE_ASSURANCE_KEY));
        } else {
            IProov.Options.Capture.GenuinePresenceAssurance genuinePresenceAssurance = capture.genuinePresenceAssurance;
            genuinePresenceAssurance.maxYaw = C3128try.m4072do(jSONObject, MAX_YAW_KEY, genuinePresenceAssurance.maxYaw);
            IProov.Options.Capture.GenuinePresenceAssurance genuinePresenceAssurance2 = capture.genuinePresenceAssurance;
            genuinePresenceAssurance2.maxRoll = C3128try.m4072do(jSONObject, MAX_ROLL_KEY, genuinePresenceAssurance2.maxRoll);
            IProov.Options.Capture.GenuinePresenceAssurance genuinePresenceAssurance3 = capture.genuinePresenceAssurance;
            genuinePresenceAssurance3.maxPitch = C3128try.m4072do(jSONObject, MAX_PITCH_KEY, genuinePresenceAssurance3.maxPitch);
        }
        return capture;
    }

    private static JSONObject captureToJsonForAnalytics(IProov.Options.Capture capture) {
        JSONObject jSONObject = new JSONObject();
        C3128try.m4082if(jSONObject, "camera", capture.camera);
        C3128try.m4083if(jSONObject, FACE_DETECTOR_KEY, capture.faceDetector);
        JSONObject jSONObject2 = new JSONObject();
        C3128try.m4080do(jSONObject2, MAX_YAW_KEY, (Object) capture.genuinePresenceAssurance.maxYaw);
        C3128try.m4080do(jSONObject2, MAX_ROLL_KEY, (Object) capture.genuinePresenceAssurance.maxRoll);
        C3128try.m4080do(jSONObject2, MAX_PITCH_KEY, (Object) capture.genuinePresenceAssurance.maxPitch);
        C3128try.m4080do(jSONObject, GENUINE_PRESENCE_ASSURANCE_KEY, (Object) jSONObject2);
        return jSONObject;
    }

    public static IProov.Options fromJson(Context context, JSONObject jSONObject) throws InvalidOptionsException {
        IProov.Options options = new IProov.Options();
        if (jSONObject == null) {
            return options;
        }
        options.f53992ui = uiOptionsFromJson(context, jSONObject.optJSONObject(UI_KEY));
        options.capture = captureOptionsFromJson(jSONObject.optJSONObject(CAPTURE_KEY));
        options.network = networkOptionsFromJson(context, jSONObject.optJSONObject("network"));
        return options;
    }

    private static IProov.Options.Capture.GenuinePresenceAssurance genuinePresenceAssuranceCaptureOptionsFromJSON(JSONObject jSONObject) {
        IProov.Options.Capture.GenuinePresenceAssurance genuinePresenceAssurance = new IProov.Options.Capture.GenuinePresenceAssurance();
        if (jSONObject == null) {
            return genuinePresenceAssurance;
        }
        genuinePresenceAssurance.maxYaw = C3128try.m4072do(jSONObject, MAX_YAW_KEY, genuinePresenceAssurance.maxYaw);
        genuinePresenceAssurance.maxRoll = C3128try.m4072do(jSONObject, MAX_ROLL_KEY, genuinePresenceAssurance.maxRoll);
        genuinePresenceAssurance.maxPitch = C3128try.m4072do(jSONObject, MAX_PITCH_KEY, genuinePresenceAssurance.maxPitch);
        return genuinePresenceAssurance;
    }

    private static IProov.Options.C19751UI.GenuinePresenceAssurance genuinePresenceAssuranceUIOptionsFromJSON(JSONObject jSONObject) {
        IProov.Options.C19751UI.GenuinePresenceAssurance genuinePresenceAssurance = new IProov.Options.C19751UI.GenuinePresenceAssurance();
        if (jSONObject == null) {
            return genuinePresenceAssurance;
        }
        genuinePresenceAssurance.notReadyTintColor = C3128try.m4064do(jSONObject, NOT_READY_TINT_COLOR_KEY, genuinePresenceAssurance.notReadyTintColor);
        genuinePresenceAssurance.readyTintColor = C3128try.m4064do(jSONObject, READY_TINT_COLOR_KEY, genuinePresenceAssurance.readyTintColor);
        genuinePresenceAssurance.progressBarColor = C3128try.m4064do(jSONObject, PROGRESS_BAR_COLOR_KEY, genuinePresenceAssurance.progressBarColor);
        genuinePresenceAssurance.autoStartDisabled = jSONObject.optBoolean(AUTO_START_DISABLED_KEY, genuinePresenceAssurance.autoStartDisabled);
        return genuinePresenceAssurance;
    }

    private static IProov.Options.C19751UI.LivenessAssurance livenessAssuranceUIOptionsFromJSON(JSONObject jSONObject) {
        IProov.Options.C19751UI.LivenessAssurance livenessAssurance = new IProov.Options.C19751UI.LivenessAssurance();
        if (jSONObject == null) {
            return livenessAssurance;
        }
        livenessAssurance.primaryTintColor = C3128try.m4064do(jSONObject, LIVENESS_PRIMARY_TINT_COLOR_KEY, livenessAssurance.primaryTintColor);
        livenessAssurance.secondaryTintColor = C3128try.m4064do(jSONObject, LIVENESS_SECONDARY_TINT_COLOR_KEY, livenessAssurance.secondaryTintColor);
        return livenessAssurance;
    }

    private static IProov.Options.Network networkOptionsFromJson(Context context, JSONObject jSONObject) throws InvalidOptionsException {
        IProov.Options.Network network = new IProov.Options.Network();
        if (jSONObject == null) {
            return network;
        }
        network.path = jSONObject.optString("path", network.path);
        network.timeoutSecs = jSONObject.optInt("timeout", network.timeoutSecs);
        network.certificates = C3128try.m4076do(context, jSONObject, CERTIFICATES_KEY, network.certificates);
        return network;
    }

    private static JSONObject networkToJsonForAnalytics(IProov.Options.Network network) {
        JSONObject jSONObject = new JSONObject();
        List<Object> list = network.certificates;
        IProov.Options options = DEFAULTS;
        C3128try.m4080do(jSONObject, CERTIFICATES_KEY, (Object) asAnalytics(list, options.network.certificates));
        C3128try.m4080do(jSONObject, "path", (Object) asAnalytics(network.path, options.network.path));
        C3128try.m4080do(jSONObject, "timeout", (Object) Integer.valueOf(network.timeoutSecs));
        return jSONObject;
    }

    public static JSONObject toJsonForAnalytics(IProov.Options options) {
        JSONObject jSONObject = new JSONObject();
        C3128try.m4080do(jSONObject, UI_KEY, (Object) uiToJsonForAnalytics(options.f53992ui));
        C3128try.m4080do(jSONObject, CAPTURE_KEY, (Object) captureToJsonForAnalytics(options.capture));
        C3128try.m4080do(jSONObject, "network", (Object) networkToJsonForAnalytics(options.network));
        return jSONObject;
    }

    private static IProov.Options.C19751UI uiOptionsFromJson(Context context, JSONObject jSONObject) {
        IProov.Options.C19751UI ui = new IProov.Options.C19751UI();
        if (jSONObject == null) {
            return ui;
        }
        ui.filter = C3128try.m4069do(jSONObject, "filter", ui.filter);
        ui.lineColor = C3128try.m4064do(jSONObject, LINE_COLOR_KEY, ui.lineColor);
        ui.backgroundColor = C3128try.m4064do(jSONObject, BACKGROUND_COLOR_KEY, ui.backgroundColor);
        ui.headerBackgroundColor = C3128try.m4064do(jSONObject, HEADER_BACKGROUND_COLOR_KEY, ui.headerBackgroundColor);
        ui.footerBackgroundColor = C3128try.m4064do(jSONObject, FOOTER_BACKGROUND_COLOR_KEY, ui.footerBackgroundColor);
        ui.headerTextColor = C3128try.m4064do(jSONObject, HEADER_TEXT_COLOR_KEY, ui.headerTextColor);
        if (jSONObject.has(PROMPT_TEXT_COLOR_KEY)) {
            ui.promptTextColor = C3128try.m4064do(jSONObject, PROMPT_TEXT_COLOR_KEY, ui.getPromptTextColor());
        } else {
            ui.promptTextColor = C3128try.m4064do(jSONObject, FOOTER_TEXT_COLOR_KEY, ui.getPromptTextColor());
        }
        ui.title = C3128try.m4075do(jSONObject, "title", ui.title);
        ui.fontPath = C3128try.m4075do(jSONObject, FONT_PATH_KEY, ui.fontPath);
        ui.floatingPromptEnabled = jSONObject.optBoolean(FLOATING_PROMPT_ENABLED, ui.floatingPromptEnabled);
        if (jSONObject.has(GENUINE_PRESENCE_ASSURANCE_KEY)) {
            ui.genuinePresenceAssurance = genuinePresenceAssuranceUIOptionsFromJSON(jSONObject.optJSONObject(GENUINE_PRESENCE_ASSURANCE_KEY));
        } else {
            IProov.Options.C19751UI.GenuinePresenceAssurance genuinePresenceAssurance = ui.genuinePresenceAssurance;
            genuinePresenceAssurance.notReadyTintColor = C3128try.m4064do(jSONObject, NOT_READY_TINT_COLOR_KEY, genuinePresenceAssurance.notReadyTintColor);
            IProov.Options.C19751UI.GenuinePresenceAssurance genuinePresenceAssurance2 = ui.genuinePresenceAssurance;
            genuinePresenceAssurance2.readyTintColor = C3128try.m4064do(jSONObject, READY_TINT_COLOR_KEY, genuinePresenceAssurance2.readyTintColor);
            IProov.Options.C19751UI.GenuinePresenceAssurance genuinePresenceAssurance3 = ui.genuinePresenceAssurance;
            genuinePresenceAssurance3.progressBarColor = C3128try.m4064do(jSONObject, PROGRESS_BAR_COLOR_KEY, genuinePresenceAssurance3.progressBarColor);
            IProov.Options.C19751UI.GenuinePresenceAssurance genuinePresenceAssurance4 = ui.genuinePresenceAssurance;
            genuinePresenceAssurance4.autoStartDisabled = jSONObject.optBoolean(AUTO_START_DISABLED_KEY, genuinePresenceAssurance4.autoStartDisabled);
        }
        if (jSONObject.has(LIVENESS_ASSURANCE_KEY)) {
            ui.livenessAssurance = livenessAssuranceUIOptionsFromJSON(jSONObject.optJSONObject(LIVENESS_ASSURANCE_KEY));
        } else {
            IProov.Options.C19751UI.LivenessAssurance livenessAssurance = ui.livenessAssurance;
            livenessAssurance.primaryTintColor = C3128try.m4064do(jSONObject, LIVENESS_TINT_COLOR_KEY, livenessAssurance.primaryTintColor);
            IProov.Options.C19751UI.LivenessAssurance livenessAssurance2 = ui.livenessAssurance;
            livenessAssurance2.secondaryTintColor = C3128try.m4064do(jSONObject, LIVENESS_SCANNING_COLOR_KEY, livenessAssurance2.secondaryTintColor);
        }
        ui.fontResource = C3128try.m4063do(context, jSONObject, FONT_RESOURCE_KEY, "font", ui.fontResource);
        ui.logoImageResource = C3128try.m4063do(context, jSONObject, LOGO_IMAGE_RESOURCE_KEY, RConfigConstants.TYPE_DRAWABLE, ui.logoImageResource);
        Bitmap bitmap = C3128try.m4066do(jSONObject, LOGO_IMAGE_KEY, (Bitmap) null);
        if (bitmap != null) {
            ui.logoImageDrawable = new BitmapDrawable(context.getResources(), bitmap);
        }
        ui.enableScreenshots = jSONObject.optBoolean(ENABLE_SCREENSHOTS_KEY, ui.enableScreenshots);
        ui.orientation = C3128try.m4070do(jSONObject, ORIENTATION_KEY, ui.orientation);
        ui.activityCompatibilityRequestCode = C3128try.m4073do(jSONObject, ACTIVITY_REQUEST_CODE_KEY, ui.activityCompatibilityRequestCode);
        return ui;
    }

    private static JSONObject uiToJsonForAnalytics(IProov.Options.C19751UI ui) {
        JSONObject jSONObject = new JSONObject();
        C3128try.m4084if(jSONObject, "filter", ui.filter);
        C3128try.m4086if(jSONObject, LINE_COLOR_KEY, Integer.valueOf(ui.lineColor));
        C3128try.m4086if(jSONObject, BACKGROUND_COLOR_KEY, Integer.valueOf(ui.backgroundColor));
        C3128try.m4086if(jSONObject, HEADER_BACKGROUND_COLOR_KEY, Integer.valueOf(ui.headerBackgroundColor));
        C3128try.m4086if(jSONObject, FOOTER_BACKGROUND_COLOR_KEY, Integer.valueOf(ui.footerBackgroundColor));
        C3128try.m4086if(jSONObject, HEADER_TEXT_COLOR_KEY, Integer.valueOf(ui.headerTextColor));
        C3128try.m4086if(jSONObject, FOOTER_TEXT_COLOR_KEY, Integer.valueOf(ui.footerTextColor));
        C3128try.m4086if(jSONObject, PROMPT_TEXT_COLOR_KEY, Integer.valueOf(ui.promptTextColor));
        C3128try.m4080do(jSONObject, FLOATING_PROMPT_ENABLED, (Object) Boolean.valueOf(ui.floatingPromptEnabled));
        String str = ui.title;
        IProov.Options options = DEFAULTS;
        C3128try.m4080do(jSONObject, "title", (Object) asAnalytics(str, options.f53992ui.title));
        C3128try.m4080do(jSONObject, LOGO_IMAGE_KEY, (Object) asAnalytics(ui.logoImageDrawable, options.f53992ui.logoImageDrawable));
        C3128try.m4080do(jSONObject, LOGO_IMAGE_RESOURCE_KEY, (Object) asAnalytics(Integer.valueOf(ui.logoImageResource), Integer.valueOf(options.f53992ui.logoImageResource)));
        C3128try.m4080do(jSONObject, ACTIVITY_REQUEST_CODE_KEY, (Object) asAnalytics(ui.activityCompatibilityRequestCode, options.f53992ui.activityCompatibilityRequestCode));
        C3128try.m4085if(jSONObject, ORIENTATION_KEY, ui.orientation);
        JSONObject jSONObject2 = new JSONObject();
        C3128try.m4080do(jSONObject2, AUTO_START_DISABLED_KEY, (Object) Boolean.valueOf(ui.genuinePresenceAssurance.autoStartDisabled));
        C3128try.m4086if(jSONObject2, READY_TINT_COLOR_KEY, Integer.valueOf(ui.genuinePresenceAssurance.readyTintColor));
        C3128try.m4086if(jSONObject2, NOT_READY_TINT_COLOR_KEY, Integer.valueOf(ui.genuinePresenceAssurance.notReadyTintColor));
        C3128try.m4086if(jSONObject2, PROGRESS_BAR_COLOR_KEY, Integer.valueOf(ui.genuinePresenceAssurance.progressBarColor));
        JSONObject jSONObject3 = new JSONObject();
        C3128try.m4086if(jSONObject3, LIVENESS_PRIMARY_TINT_COLOR_KEY, Integer.valueOf(ui.livenessAssurance.primaryTintColor));
        C3128try.m4086if(jSONObject3, LIVENESS_SECONDARY_TINT_COLOR_KEY, Integer.valueOf(ui.livenessAssurance.secondaryTintColor));
        C3128try.m4080do(jSONObject, GENUINE_PRESENCE_ASSURANCE_KEY, (Object) jSONObject2);
        C3128try.m4080do(jSONObject, LIVENESS_ASSURANCE_KEY, (Object) jSONObject3);
        return jSONObject;
    }
}
