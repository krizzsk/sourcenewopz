package p242io.flutter.embedding.engine.systemchannels;

import android.os.Bundle;
import com.didi.entrega.customer.app.constant.Const;
import com.facebook.GraphRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.plugin.common.JSONMethodCodec;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.editing.TextEditingDelta;

/* renamed from: io.flutter.embedding.engine.systemchannels.TextInputChannel */
public class TextInputChannel {

    /* renamed from: b */
    private static final String f57740b = "TextInputChannel";

    /* renamed from: a */
    final MethodChannel.MethodCallHandler f57741a = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            Bundle bundle;
            MethodCall methodCall2 = methodCall;
            MethodChannel.Result result2 = result;
            if (TextInputChannel.this.f57742c != null) {
                String str = methodCall2.method;
                Object obj = methodCall2.arguments;
                Log.m41140v(TextInputChannel.f57740b, "Received '" + str + "' message.");
                char c = 65535;
                switch (str.hashCode()) {
                    case -1779068172:
                        if (str.equals("TextInput.setPlatformViewClient")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1015421462:
                        if (str.equals("TextInput.setEditingState")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -37561188:
                        if (str.equals("TextInput.setClient")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 270476819:
                        if (str.equals("TextInput.hide")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 270803918:
                        if (str.equals("TextInput.show")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 649192816:
                        if (str.equals("TextInput.sendAppPrivateCommand")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 1204752139:
                        if (str.equals("TextInput.setEditableSizeAndTransform")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1727570905:
                        if (str.equals("TextInput.finishAutofillContext")) {
                            c = 9;
                            break;
                        }
                        break;
                    case 1904427655:
                        if (str.equals("TextInput.clearClient")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 2113369584:
                        if (str.equals("TextInput.requestAutofill")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        TextInputChannel.this.f57742c.show();
                        result2.success((Object) null);
                        return;
                    case 1:
                        TextInputChannel.this.f57742c.hide();
                        result2.success((Object) null);
                        return;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            TextInputChannel.this.f57742c.setClient(jSONArray.getInt(0), Configuration.fromJson(jSONArray.getJSONObject(1)));
                            result2.success((Object) null);
                            return;
                        } catch (NoSuchFieldException | JSONException e) {
                            result2.error("error", e.getMessage(), (Object) null);
                            return;
                        }
                    case 3:
                        TextInputChannel.this.f57742c.requestAutofill();
                        result2.success((Object) null);
                        return;
                    case 4:
                        try {
                            JSONObject jSONObject = (JSONObject) obj;
                            TextInputChannel.this.f57742c.setPlatformViewClient(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                            result2.success((Object) null);
                            return;
                        } catch (JSONException e2) {
                            result2.error("error", e2.getMessage(), (Object) null);
                            return;
                        }
                    case 5:
                        try {
                            TextInputChannel.this.f57742c.setEditingState(TextEditState.fromJson((JSONObject) obj));
                            result2.success((Object) null);
                            return;
                        } catch (JSONException e3) {
                            result2.error("error", e3.getMessage(), (Object) null);
                            return;
                        }
                    case 6:
                        try {
                            JSONObject jSONObject2 = (JSONObject) obj;
                            double d = jSONObject2.getDouble("width");
                            double d2 = jSONObject2.getDouble("height");
                            JSONArray jSONArray2 = jSONObject2.getJSONArray(Const.BillClickType.TRANSFORM);
                            double[] dArr = new double[16];
                            for (int i = 0; i < 16; i++) {
                                dArr[i] = jSONArray2.getDouble(i);
                            }
                            TextInputChannel.this.f57742c.setEditableSizeAndTransform(d, d2, dArr);
                            result2.success((Object) null);
                            return;
                        } catch (JSONException e4) {
                            result2.error("error", e4.getMessage(), (Object) null);
                            return;
                        }
                    case 7:
                        TextInputChannel.this.f57742c.clearClient();
                        result2.success((Object) null);
                        return;
                    case 8:
                        try {
                            JSONObject jSONObject3 = (JSONObject) obj;
                            String string = jSONObject3.getString("action");
                            String string2 = jSONObject3.getString("data");
                            if (string2 == null || string2.isEmpty()) {
                                bundle = null;
                            } else {
                                bundle = new Bundle();
                                bundle.putString("data", string2);
                            }
                            TextInputChannel.this.f57742c.sendAppPrivateCommand(string, bundle);
                            result2.success((Object) null);
                            return;
                        } catch (JSONException e5) {
                            result2.error("error", e5.getMessage(), (Object) null);
                            return;
                        }
                    case 9:
                        TextInputChannel.this.f57742c.finishAutofillContext(((Boolean) obj).booleanValue());
                        result2.success((Object) null);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextInputMethodHandler f57742c;
    public final MethodChannel channel;

    /* renamed from: io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputMethodHandler */
    public interface TextInputMethodHandler {
        void clearClient();

        void finishAutofillContext(boolean z);

        void hide();

        void requestAutofill();

        void sendAppPrivateCommand(String str, Bundle bundle);

        void setClient(int i, Configuration configuration);

        void setEditableSizeAndTransform(double d, double d2, double[] dArr);

        void setEditingState(TextEditState textEditState);

        void setPlatformViewClient(int i, boolean z);

        void show();
    }

    public TextInputChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.f57741a);
    }

    public void requestExistingInputState() {
        this.channel.invokeMethod("TextInputClient.requestExistingInputState", (Object) null);
    }

    /* renamed from: a */
    private static HashMap<Object, Object> m41513a(String str, int i, int i2, int i3, int i4) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i));
        hashMap.put("selectionExtent", Integer.valueOf(i2));
        hashMap.put("composingBase", Integer.valueOf(i3));
        hashMap.put("composingExtent", Integer.valueOf(i4));
        return hashMap;
    }

    /* renamed from: a */
    private static HashMap<Object, Object> m41514a(ArrayList<TextEditingDelta> arrayList) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        Iterator<TextEditingDelta> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJSON());
        }
        hashMap.put("deltas", jSONArray);
        return hashMap;
    }

    public void updateEditingState(int i, String str, int i2, int i3, int i4, int i5) {
        Log.m41140v(f57740b, "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i2 + "\nSelection end: " + i3 + "\nComposing start: " + i4 + "\nComposing end: " + i5);
        HashMap<Object, Object> a = m41513a(str, i2, i3, i4, i5);
        this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(new Serializable[]{Integer.valueOf(i), a}));
    }

    public void updateEditingStateWithDeltas(int i, ArrayList<TextEditingDelta> arrayList) {
        Log.m41140v(f57740b, "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        HashMap<Object, Object> a = m41514a(arrayList);
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(new Serializable[]{Integer.valueOf(i), a}));
    }

    public void updateEditingStateWithTag(int i, HashMap<String, TextEditState> hashMap) {
        Log.m41140v(f57740b, "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next : hashMap.entrySet()) {
            TextEditState textEditState = (TextEditState) next.getValue();
            hashMap2.put((String) next.getKey(), m41513a(textEditState.text, textEditState.selectionStart, textEditState.selectionEnd, -1, -1));
        }
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(new Serializable[]{Integer.valueOf(i), hashMap2}));
    }

    public void newline(int i) {
        Log.m41140v(f57740b, "Sending 'newline' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.newline"}));
    }

    /* renamed from: go */
    public void mo172681go(int i) {
        Log.m41140v(f57740b, "Sending 'go' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.go"}));
    }

    public void search(int i) {
        Log.m41140v(f57740b, "Sending 'search' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.search"}));
    }

    public void send(int i) {
        Log.m41140v(f57740b, "Sending 'send' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.send"}));
    }

    public void done(int i) {
        Log.m41140v(f57740b, "Sending 'done' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.done"}));
    }

    public void next(int i) {
        Log.m41140v(f57740b, "Sending 'next' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.next"}));
    }

    public void previous(int i) {
        Log.m41140v(f57740b, "Sending 'previous' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.previous"}));
    }

    public void unspecifiedAction(int i) {
        Log.m41140v(f57740b, "Sending 'unspecified' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.unspecified"}));
    }

    public void performPrivateCommand(int i, String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    hashMap2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    hashMap2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            hashMap.put("data", hashMap2);
        }
        this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(new Serializable[]{Integer.valueOf(i), hashMap}));
    }

    public void setTextInputMethodHandler(TextInputMethodHandler textInputMethodHandler) {
        this.f57742c = textInputMethodHandler;
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.TextInputChannel$Configuration */
    public static class Configuration {
        public final String actionLabel;
        public final boolean autocorrect;
        public final Autofill autofill;
        public final boolean enableDeltaModel;
        public final boolean enableIMEPersonalizedLearning;
        public final boolean enableSuggestions;
        public final Configuration[] fields;
        public final Integer inputAction;
        public final InputType inputType;
        public final boolean obscureText;
        public final TextCapitalization textCapitalization;

        public static Configuration fromJson(JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            Configuration[] configurationArr;
            JSONObject jSONObject2 = jSONObject;
            String string = jSONObject2.getString("inputAction");
            if (string != null) {
                Autofill autofill2 = null;
                if (!jSONObject2.isNull(GraphRequest.FIELDS_PARAM)) {
                    JSONArray jSONArray = jSONObject2.getJSONArray(GraphRequest.FIELDS_PARAM);
                    int length = jSONArray.length();
                    Configuration[] configurationArr2 = new Configuration[length];
                    for (int i = 0; i < length; i++) {
                        configurationArr2[i] = fromJson(jSONArray.getJSONObject(i));
                    }
                    configurationArr = configurationArr2;
                } else {
                    configurationArr = null;
                }
                Integer inputActionFromTextInputAction = inputActionFromTextInputAction(string);
                boolean optBoolean = jSONObject2.optBoolean("obscureText");
                boolean optBoolean2 = jSONObject2.optBoolean("autocorrect", true);
                boolean optBoolean3 = jSONObject2.optBoolean("enableSuggestions");
                boolean optBoolean4 = jSONObject2.optBoolean("enableIMEPersonalizedLearning");
                boolean optBoolean5 = jSONObject2.optBoolean("enableDeltaModel");
                TextCapitalization fromValue = TextCapitalization.fromValue(jSONObject2.getString("textCapitalization"));
                InputType fromJson = InputType.fromJson(jSONObject2.getJSONObject("inputType"));
                String string2 = jSONObject2.isNull("actionLabel") ? null : jSONObject2.getString("actionLabel");
                if (!jSONObject2.isNull("autofill")) {
                    autofill2 = Autofill.fromJson(jSONObject2.getJSONObject("autofill"));
                }
                return new Configuration(optBoolean, optBoolean2, optBoolean3, optBoolean4, optBoolean5, fromValue, fromJson, inputActionFromTextInputAction, string2, autofill2, configurationArr);
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
            if (r11.equals("TextInputAction.newline") != false) goto L_0x0073;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.Integer inputActionFromTextInputAction(java.lang.String r11) {
            /*
                int r0 = r11.hashCode()
                r1 = 7
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 6
                r7 = 0
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r9 = 1
                java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
                switch(r0) {
                    case -810971940: goto L_0x0068;
                    case -737377923: goto L_0x005e;
                    case -737089298: goto L_0x0054;
                    case -737080013: goto L_0x004a;
                    case -736940669: goto L_0x0040;
                    case 469250275: goto L_0x0036;
                    case 1241689507: goto L_0x002c;
                    case 1539450297: goto L_0x0023;
                    case 2110497650: goto L_0x0018;
                    default: goto L_0x0017;
                }
            L_0x0017:
                goto L_0x0072
            L_0x0018:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 8
                goto L_0x0073
            L_0x0023:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                goto L_0x0073
            L_0x002c:
                java.lang.String r0 = "TextInputAction.go"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 4
                goto L_0x0073
            L_0x0036:
                java.lang.String r0 = "TextInputAction.search"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 5
                goto L_0x0073
            L_0x0040:
                java.lang.String r0 = "TextInputAction.send"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 6
                goto L_0x0073
            L_0x004a:
                java.lang.String r0 = "TextInputAction.none"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 1
                goto L_0x0073
            L_0x0054:
                java.lang.String r0 = "TextInputAction.next"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 7
                goto L_0x0073
            L_0x005e:
                java.lang.String r0 = "TextInputAction.done"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 3
                goto L_0x0073
            L_0x0068:
                java.lang.String r0 = "TextInputAction.unspecified"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 2
                goto L_0x0073
            L_0x0072:
                r7 = -1
            L_0x0073:
                switch(r7) {
                    case 0: goto L_0x0096;
                    case 1: goto L_0x0096;
                    case 2: goto L_0x0095;
                    case 3: goto L_0x0090;
                    case 4: goto L_0x008b;
                    case 5: goto L_0x0086;
                    case 6: goto L_0x0081;
                    case 7: goto L_0x007c;
                    case 8: goto L_0x0077;
                    default: goto L_0x0076;
                }
            L_0x0076:
                return r8
            L_0x0077:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
                return r11
            L_0x007c:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r2)
                return r11
            L_0x0081:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
                return r11
            L_0x0086:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
                return r11
            L_0x008b:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
                return r11
            L_0x0090:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
                return r11
            L_0x0095:
                return r8
            L_0x0096:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.inputActionFromTextInputAction(java.lang.String):java.lang.Integer");
        }

        /* renamed from: io.flutter.embedding.engine.systemchannels.TextInputChannel$Configuration$Autofill */
        public static class Autofill {
            public final TextEditState editState;
            public final String hintText;
            public final String[] hints;
            public final String uniqueIdentifier;

            public static Autofill fromJson(JSONObject jSONObject) throws JSONException, NoSuchFieldException {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    strArr[i] = translateAutofillHint(jSONArray.getString(i));
                }
                return new Autofill(string, strArr, string2, TextEditState.fromJson(jSONObject2));
            }

            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
                if (r0.equals(com.didi.global.fintech.cashier.model.net.request.CashierAction.ACTION_PASSWORD) != false) goto L_0x01af;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.lang.String translateAutofillHint(java.lang.String r16) {
                /*
                    r0 = r16
                    int r1 = android.os.Build.VERSION.SDK_INT
                    r2 = 26
                    if (r1 >= r2) goto L_0x0009
                    return r0
                L_0x0009:
                    int r3 = r16.hashCode()
                    java.lang.String r4 = "postalCode"
                    java.lang.String r5 = "postalAddress"
                    java.lang.String r6 = "password"
                    java.lang.String r7 = "newUsername"
                    java.lang.String r8 = "username"
                    java.lang.String r9 = "creditCardExpirationYear"
                    java.lang.String r10 = "creditCardExpirationDate"
                    java.lang.String r11 = "creditCardNumber"
                    java.lang.String r12 = "gender"
                    java.lang.String r13 = "creditCardExpirationDay"
                    java.lang.String r14 = "creditCardSecurityCode"
                    java.lang.String r15 = "newPassword"
                    java.lang.String r1 = "creditCardExpirationMonth"
                    switch(r3) {
                        case -2058889126: goto L_0x01a4;
                        case -1917283616: goto L_0x0199;
                        case -1844815832: goto L_0x0190;
                        case -1825589953: goto L_0x0185;
                        case -1821235109: goto L_0x017c;
                        case -1757573738: goto L_0x0173;
                        case -1682373820: goto L_0x016a;
                        case -1658955742: goto L_0x015f;
                        case -1567118045: goto L_0x0154;
                        case -1476752575: goto L_0x014a;
                        case -1413737489: goto L_0x013e;
                        case -1377792129: goto L_0x0133;
                        case -1249512767: goto L_0x0129;
                        case -1186060294: goto L_0x011d;
                        case -1151034798: goto L_0x0113;
                        case -835992323: goto L_0x0107;
                        case -818219584: goto L_0x00fb;
                        case -747304516: goto L_0x00ef;
                        case -613980922: goto L_0x00e6;
                        case -613352043: goto L_0x00dc;
                        case -549230602: goto L_0x00d0;
                        case -265713450: goto L_0x00c6;
                        case 3373707: goto L_0x00ba;
                        case 96619420: goto L_0x00ae;
                        case 253202685: goto L_0x00a3;
                        case 588174851: goto L_0x0098;
                        case 798554127: goto L_0x008c;
                        case 892233837: goto L_0x0080;
                        case 991032982: goto L_0x0076;
                        case 1069376125: goto L_0x006b;
                        case 1216985755: goto L_0x0063;
                        case 1469046696: goto L_0x0057;
                        case 1662667945: goto L_0x004d;
                        case 1921869058: goto L_0x0041;
                        case 2011152728: goto L_0x0037;
                        case 2011773919: goto L_0x002c;
                        default: goto L_0x002a;
                    }
                L_0x002a:
                    goto L_0x01ae
                L_0x002c:
                    java.lang.String r2 = "birthdayDay"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 3
                    goto L_0x01af
                L_0x0037:
                    boolean r2 = r0.equals(r4)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 30
                    goto L_0x01af
                L_0x0041:
                    java.lang.String r2 = "postalAddressExtended"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 28
                    goto L_0x01af
                L_0x004d:
                    boolean r2 = r0.equals(r5)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 27
                    goto L_0x01af
                L_0x0057:
                    java.lang.String r2 = "givenName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 17
                    goto L_0x01af
                L_0x0063:
                    boolean r3 = r0.equals(r6)
                    if (r3 == 0) goto L_0x01ae
                    goto L_0x01af
                L_0x006b:
                    java.lang.String r2 = "birthday"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 2
                    goto L_0x01af
                L_0x0076:
                    boolean r2 = r0.equals(r7)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 24
                    goto L_0x01af
                L_0x0080:
                    java.lang.String r2 = "telephoneNumber"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 31
                    goto L_0x01af
                L_0x008c:
                    java.lang.String r2 = "familyName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 14
                    goto L_0x01af
                L_0x0098:
                    java.lang.String r2 = "birthdayMonth"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 4
                    goto L_0x01af
                L_0x00a3:
                    java.lang.String r2 = "addressState"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 1
                    goto L_0x01af
                L_0x00ae:
                    java.lang.String r2 = "email"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 13
                    goto L_0x01af
                L_0x00ba:
                    java.lang.String r2 = "name"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 20
                    goto L_0x01af
                L_0x00c6:
                    boolean r2 = r0.equals(r8)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 35
                    goto L_0x01af
                L_0x00d0:
                    java.lang.String r2 = "telephoneNumberCountryCode"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 32
                    goto L_0x01af
                L_0x00dc:
                    boolean r2 = r0.equals(r9)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 10
                    goto L_0x01af
                L_0x00e6:
                    boolean r2 = r0.equals(r10)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 7
                    goto L_0x01af
                L_0x00ef:
                    java.lang.String r2 = "nameSuffix"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 22
                    goto L_0x01af
                L_0x00fb:
                    java.lang.String r2 = "middleName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 19
                    goto L_0x01af
                L_0x0107:
                    java.lang.String r2 = "namePrefix"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 21
                    goto L_0x01af
                L_0x0113:
                    boolean r2 = r0.equals(r11)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 11
                    goto L_0x01af
                L_0x011d:
                    java.lang.String r2 = "postalAddressExtendedPostalCode"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 29
                    goto L_0x01af
                L_0x0129:
                    boolean r2 = r0.equals(r12)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 16
                    goto L_0x01af
                L_0x0133:
                    java.lang.String r2 = "addressCity"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 0
                    goto L_0x01af
                L_0x013e:
                    java.lang.String r2 = "middleInitial"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 18
                    goto L_0x01af
                L_0x014a:
                    java.lang.String r2 = "countryName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 6
                    goto L_0x01af
                L_0x0154:
                    java.lang.String r2 = "telephoneNumberDevice"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 33
                    goto L_0x01af
                L_0x015f:
                    java.lang.String r2 = "fullStreetAddress"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 15
                    goto L_0x01af
                L_0x016a:
                    boolean r2 = r0.equals(r13)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 8
                    goto L_0x01af
                L_0x0173:
                    boolean r2 = r0.equals(r14)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 12
                    goto L_0x01af
                L_0x017c:
                    boolean r2 = r0.equals(r15)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 23
                    goto L_0x01af
                L_0x0185:
                    java.lang.String r2 = "telephoneNumberNational"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 34
                    goto L_0x01af
                L_0x0190:
                    boolean r2 = r0.equals(r1)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 9
                    goto L_0x01af
                L_0x0199:
                    java.lang.String r2 = "oneTimeCode"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 25
                    goto L_0x01af
                L_0x01a4:
                    java.lang.String r2 = "birthdayYear"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 5
                    goto L_0x01af
                L_0x01ae:
                    r2 = -1
                L_0x01af:
                    switch(r2) {
                        case 0: goto L_0x0202;
                        case 1: goto L_0x01ff;
                        case 2: goto L_0x01fc;
                        case 3: goto L_0x01f9;
                        case 4: goto L_0x01f6;
                        case 5: goto L_0x01f3;
                        case 6: goto L_0x01f0;
                        case 7: goto L_0x01ef;
                        case 8: goto L_0x01ee;
                        case 9: goto L_0x01ed;
                        case 10: goto L_0x01ec;
                        case 11: goto L_0x01eb;
                        case 12: goto L_0x01ea;
                        case 13: goto L_0x01e7;
                        case 14: goto L_0x01e4;
                        case 15: goto L_0x01e1;
                        case 16: goto L_0x01e0;
                        case 17: goto L_0x01dd;
                        case 18: goto L_0x01da;
                        case 19: goto L_0x01d7;
                        case 20: goto L_0x01d4;
                        case 21: goto L_0x01d1;
                        case 22: goto L_0x01ce;
                        case 23: goto L_0x01cd;
                        case 24: goto L_0x01cc;
                        case 25: goto L_0x01c9;
                        case 26: goto L_0x01c8;
                        case 27: goto L_0x01c7;
                        case 28: goto L_0x01c4;
                        case 29: goto L_0x01c1;
                        case 30: goto L_0x01c0;
                        case 31: goto L_0x01bd;
                        case 32: goto L_0x01ba;
                        case 33: goto L_0x01b7;
                        case 34: goto L_0x01b4;
                        case 35: goto L_0x01b3;
                        default: goto L_0x01b2;
                    }
                L_0x01b2:
                    return r0
                L_0x01b3:
                    return r8
                L_0x01b4:
                    java.lang.String r0 = "phoneNational"
                    return r0
                L_0x01b7:
                    java.lang.String r0 = "phoneNumberDevice"
                    return r0
                L_0x01ba:
                    java.lang.String r0 = "phoneCountryCode"
                    return r0
                L_0x01bd:
                    java.lang.String r0 = "phoneNumber"
                    return r0
                L_0x01c0:
                    return r4
                L_0x01c1:
                    java.lang.String r0 = "extendedPostalCode"
                    return r0
                L_0x01c4:
                    java.lang.String r0 = "extendedAddress"
                    return r0
                L_0x01c7:
                    return r5
                L_0x01c8:
                    return r6
                L_0x01c9:
                    java.lang.String r0 = "smsOTPCode"
                    return r0
                L_0x01cc:
                    return r7
                L_0x01cd:
                    return r15
                L_0x01ce:
                    java.lang.String r0 = "personNameSuffix"
                    return r0
                L_0x01d1:
                    java.lang.String r0 = "personNamePrefix"
                    return r0
                L_0x01d4:
                    java.lang.String r0 = "personName"
                    return r0
                L_0x01d7:
                    java.lang.String r0 = "personMiddleName"
                    return r0
                L_0x01da:
                    java.lang.String r0 = "personMiddleInitial"
                    return r0
                L_0x01dd:
                    java.lang.String r0 = "personGivenName"
                    return r0
                L_0x01e0:
                    return r12
                L_0x01e1:
                    java.lang.String r0 = "streetAddress"
                    return r0
                L_0x01e4:
                    java.lang.String r0 = "personFamilyName"
                    return r0
                L_0x01e7:
                    java.lang.String r0 = "emailAddress"
                    return r0
                L_0x01ea:
                    return r14
                L_0x01eb:
                    return r11
                L_0x01ec:
                    return r9
                L_0x01ed:
                    return r1
                L_0x01ee:
                    return r13
                L_0x01ef:
                    return r10
                L_0x01f0:
                    java.lang.String r0 = "addressCountry"
                    return r0
                L_0x01f3:
                    java.lang.String r0 = "birthDateYear"
                    return r0
                L_0x01f6:
                    java.lang.String r0 = "birthDateMonth"
                    return r0
                L_0x01f9:
                    java.lang.String r0 = "birthDateDay"
                    return r0
                L_0x01fc:
                    java.lang.String r0 = "birthDateFull"
                    return r0
                L_0x01ff:
                    java.lang.String r0 = "addressRegion"
                    return r0
                L_0x0202:
                    java.lang.String r0 = "addressLocality"
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.Autofill.translateAutofillHint(java.lang.String):java.lang.String");
            }

            public Autofill(String str, String[] strArr, String str2, TextEditState textEditState) {
                this.uniqueIdentifier = str;
                this.hints = strArr;
                this.hintText = str2;
                this.editState = textEditState;
            }
        }

        public Configuration(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, TextCapitalization textCapitalization2, InputType inputType2, Integer num, String str, Autofill autofill2, Configuration[] configurationArr) {
            this.obscureText = z;
            this.autocorrect = z2;
            this.enableSuggestions = z3;
            this.enableIMEPersonalizedLearning = z4;
            this.enableDeltaModel = z5;
            this.textCapitalization = textCapitalization2;
            this.inputType = inputType2;
            this.inputAction = num;
            this.actionLabel = str;
            this.autofill = autofill2;
            this.fields = configurationArr;
        }
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.TextInputChannel$InputType */
    public static class InputType {
        public final boolean isDecimal;
        public final boolean isSigned;
        public final TextInputType type;

        public static InputType fromJson(JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            return new InputType(TextInputType.fromValue(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }

        public InputType(TextInputType textInputType, boolean z, boolean z2) {
            this.type = textInputType;
            this.isSigned = z;
            this.isDecimal = z2;
        }
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType */
    public enum TextInputType {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none");
        
        private final String encodedName;

        static TextInputType fromValue(String str) throws NoSuchFieldException {
            for (TextInputType textInputType : values()) {
                if (textInputType.encodedName.equals(str)) {
                    return textInputType;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }

        private TextInputType(String str) {
            this.encodedName = str;
        }
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.TextInputChannel$TextCapitalization */
    public enum TextCapitalization {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        
        private final String encodedName;

        static TextCapitalization fromValue(String str) throws NoSuchFieldException {
            for (TextCapitalization textCapitalization : values()) {
                if (textCapitalization.encodedName.equals(str)) {
                    return textCapitalization;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }

        private TextCapitalization(String str) {
            this.encodedName = str;
        }
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState */
    public static class TextEditState {
        public final int composingEnd;
        public final int composingStart;
        public final int selectionEnd;
        public final int selectionStart;
        public final String text;

        public static TextEditState fromJson(JSONObject jSONObject) throws JSONException {
            return new TextEditState(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public TextEditState(String str, int i, int i2, int i3, int i4) throws IndexOutOfBoundsException {
            if (!(i == -1 && i2 == -1) && (i < 0 || i2 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i) + ", " + String.valueOf(i2) + ")");
            } else if (!(i3 == -1 && i4 == -1) && (i3 < 0 || i3 > i4)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i3) + ", " + String.valueOf(i4) + ")");
            } else if (i4 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i3));
            } else if (i > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i));
            } else if (i2 <= str.length()) {
                this.text = str;
                this.selectionStart = i;
                this.selectionEnd = i2;
                this.composingStart = i3;
                this.composingEnd = i4;
            } else {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i2));
            }
        }

        public boolean hasSelection() {
            return this.selectionStart >= 0;
        }

        public boolean hasComposing() {
            int i = this.composingStart;
            return i >= 0 && this.composingEnd > i;
        }
    }
}
