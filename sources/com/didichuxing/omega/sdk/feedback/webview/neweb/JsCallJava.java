package com.didichuxing.omega.sdk.feedback.webview.neweb;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.gson.Gson;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsCallJava {
    private static final String RETURN_RESULT_FORMAT = "{\"code\": %d, \"result\": %s}";
    private Gson mGson;
    private HashMap<String, Method> mMethodsMap;
    private String mPreloadInterfaceJS;

    public JsCallJava(String str, Class cls) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.mMethodsMap = new HashMap<>();
                Method[] declaredMethods = cls.getDeclaredMethods();
                StringBuilder sb = new StringBuilder("javascript:(function(b){console.log(\"");
                sb.append(str);
                sb.append(" initialization begin\");var a={queue:[],callback:function(){var d=Array.prototype.slice.call(arguments,0);var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
                for (Method method : declaredMethods) {
                    if (method.getModifiers() == 9) {
                        String genJavaMethodSign = genJavaMethodSign(method);
                        if (genJavaMethodSign != null) {
                            this.mMethodsMap.put(genJavaMethodSign, method);
                            sb.append(String.format("a.%s=", new Object[]{method.getName()}));
                        }
                    }
                }
                sb.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
                sb.append(str);
                sb.append(" call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++){var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\"){var d=a.queue.length;a.queue[d]=c;f[h]=d}}var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));if(g.code!=200){throw\"");
                sb.append(str);
                sb.append(" call error, code:\"+g.code+\", message:\"+g.result}return g.result};Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
                sb.append(str);
                sb.append("=a;var ev=document.createEvent('HTMLEvents'); ev.initEvent('DidiJSBridgeReady',false,false); document.dispatchEvent(ev); console.log(\"");
                sb.append(str);
                sb.append(" initialization end\")})(window);");
                this.mPreloadInterfaceJS = sb.toString();
                return;
            }
            throw new Exception("injected name can not be null");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String genJavaMethodSign(Method method) {
        String name = method.getName();
        Class<JsCallback>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        if (length < 1 || parameterTypes[0] != WebView.class) {
            return null;
        }
        for (int i = 1; i < length; i++) {
            Class<JsCallback> cls = parameterTypes[i];
            if (cls == String.class) {
                name = name + "_S";
            } else if (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                name = name + "_N";
            } else if (cls == Boolean.TYPE) {
                name = name + "_B";
            } else if (cls == JSONObject.class) {
                name = name + "_O";
            } else if (cls == JsCallback.class) {
                name = name + "_F";
            } else {
                name = name + "_P";
            }
        }
        return name;
    }

    public String getPreloadInterfaceJS() {
        return this.mPreloadInterfaceJS;
    }

    public String call(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return getReturn(500, "call data empty");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("method");
            JSONArray jSONArray = jSONObject.getJSONArray("types");
            JSONArray jSONArray2 = jSONObject.getJSONArray("args");
            int length = jSONArray.length();
            Object[] objArr = new Object[(length + 1)];
            int i = 0;
            objArr[0] = webView;
            int i2 = 0;
            while (true) {
                Object obj = null;
                if (i >= length) {
                    break;
                }
                String optString = jSONArray.optString(i);
                if (TypedValues.Custom.S_STRING.equals(optString)) {
                    string = string + "_S";
                    int i3 = i + 1;
                    if (!jSONArray2.isNull(i)) {
                        obj = jSONArray2.getString(i);
                    }
                    objArr[i3] = obj;
                } else if ("number".equals(optString)) {
                    string = string + "_N";
                    i2 = (i2 * 10) + i + 1;
                } else if (TypedValues.Custom.S_BOOLEAN.equals(optString)) {
                    string = string + "_B";
                    objArr[i + 1] = Boolean.valueOf(jSONArray2.getBoolean(i));
                } else if ("object".equals(optString)) {
                    string = string + "_O";
                    int i4 = i + 1;
                    if (!jSONArray2.isNull(i)) {
                        obj = jSONArray2.getJSONObject(i);
                    }
                    objArr[i4] = obj;
                } else {
                    string = string + "_P";
                }
                i++;
            }
            Method method = this.mMethodsMap.get(string);
            if (method == null) {
                return getReturn(500, "not found method(" + string + ") with valid parameters");
            }
            if (i2 > 0) {
                Class[] parameterTypes = method.getParameterTypes();
                while (i2 > 0) {
                    int i5 = i2 - ((i2 / 10) * 10);
                    Class cls = parameterTypes[i5];
                    if (cls == Integer.TYPE) {
                        objArr[i5] = Integer.valueOf(jSONArray2.getInt(i5 - 1));
                    } else if (cls == Long.TYPE) {
                        objArr[i5] = Long.valueOf(Long.parseLong(jSONArray2.getString(i5 - 1)));
                    } else {
                        objArr[i5] = Double.valueOf(jSONArray2.getDouble(i5 - 1));
                    }
                    i2 /= 10;
                }
            }
            return getReturn(200, method.invoke((Object) null, objArr));
        } catch (Exception e) {
            if (e.getCause() != null) {
                return getReturn(500, "method execute error:" + e.getCause().getMessage());
            }
            return getReturn(500, "method execute error:" + e.getMessage());
        }
    }

    private String getReturn(int i, Object obj) {
        String str;
        if (obj == null) {
            str = "null";
        } else if (obj instanceof String) {
            str = Const.jsQuote + ((String) obj).replace(Const.jsQuote, "\\\"") + Const.jsQuote;
        } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof JSONObject)) {
            str = String.valueOf(obj);
        } else {
            if (this.mGson == null) {
                this.mGson = new Gson();
            }
            str = this.mGson.toJson(obj);
        }
        return String.format(RETURN_RESULT_FORMAT, new Object[]{Integer.valueOf(i), str});
    }
}
