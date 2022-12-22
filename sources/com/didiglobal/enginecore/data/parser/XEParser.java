package com.didiglobal.enginecore.data.parser;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.android.didi.bfflib.utils.TrackUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.enginecore.XEParserCallback;
import com.didiglobal.enginecore.XEngineInnerRequest;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.constant.XEngineConst;
import com.didiglobal.enginecore.data.exception.DataParseException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.data.parser.util.XEParserUtil;
import com.didiglobal.enginecore.template.nat.NativeComponent;
import com.didiglobal.enginecore.template.temp.IXEView;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.didiglobal.enginecore.template.temp.TemplateComponent;
import com.didiglobal.enginecore.template.temp.XETemplateComponent;
import com.didiglobal.enginecore.template.xml.XMLComponent;
import com.didiglobal.enginecore.view.AsyncViewLoadListener;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class XEParser {

    /* renamed from: e */
    private static Handler f50164e = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    private boolean f50165a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f50166b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final CopyOnWriteArrayList<String> f50167c = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile AtomicInteger f50168d = new AtomicInteger(0);

    public void parseFromNet(Context context, List<XETemplateComponent> list, String str, JsonObject jsonObject, XEParserCallback xEParserCallback) {
        parse(context, list, str, jsonObject, xEParserCallback);
    }

    public void parse(Context context, List<XETemplateComponent> list, String str, JsonObject jsonObject, XEParserCallback xEParserCallback) {
        if (jsonObject == null) {
            if (xEParserCallback != null) {
                xEParserCallback.onFail(new DataParseException("data is null"));
            }
        } else if (!jsonObject.has(XEParseConst.XE_JSON_KEY_COM_TYPE) || XEParserUtil.getAsInt(XEParseConst.XE_JSON_KEY_COM_TYPE, jsonObject, 0) != 2 || xEParserCallback == null) {
            try {
                if (jsonObject.has("list") || xEParserCallback == null) {
                    JsonArray asJsonArray = jsonObject.get("list") == null ? null : jsonObject.get("list").getAsJsonArray();
                    if (asJsonArray != null) {
                        m36147a(context, list, str, jsonObject, xEParserCallback, asJsonArray);
                    } else if (xEParserCallback != null) {
                        xEParserCallback.onFail(new DataParseException("list is null"));
                    }
                } else {
                    xEParserCallback.onSuccess(new XEngineData(str, jsonObject), (List<XEComponent>) null);
                }
            } catch (Exception e) {
                TrackUtil.trackError(e instanceof JsonParseException ? 1 : 5, "", e, jsonObject.toString());
                if (xEParserCallback != null) {
                    xEParserCallback.onFail(e);
                }
            }
        } else {
            xEParserCallback.onSuccess(new XEngineData(str, jsonObject), (List<XEComponent>) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36147a(Context context, List<XETemplateComponent> list, String str, JsonObject jsonObject, XEParserCallback xEParserCallback, JsonArray jsonArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Handler handler;
        CopyOnWriteArrayList copyOnWriteArrayList;
        String str10;
        XEParser xEParser = this;
        Context context2 = context;
        String str11 = str;
        JsonObject jsonObject2 = jsonObject;
        XEParserCallback xEParserCallback2 = xEParserCallback;
        JsonArray jsonArray2 = jsonArray;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        Handler handler2 = new Handler();
        int i = 0;
        while (true) {
            int size = jsonArray.size();
            str2 = XEngineConst.XE_XML_TEMPLATE;
            str3 = "id";
            str4 = "";
            str5 = "template";
            if (i >= size) {
                break;
            }
            JsonObject asJsonObject = jsonArray2.get(i).getAsJsonObject();
            if (asJsonObject.has(str5)) {
                String asString = XEParserUtil.getAsString(str5, asJsonObject, str4);
                String asString2 = XEParserUtil.getAsString(str3, asJsonObject, str4);
                if (asString.equals(str2) && !TextUtils.isEmpty(asString2)) {
                    xEParser.f50167c.add(asString2);
                    xEParser.f50168d.incrementAndGet();
                }
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        String str12 = ":";
        sb.append(str12);
        sb.append(xEParser.f50167c.size());
        SystemUtils.log(3, "renderSize:init", sb.toString(), (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser", 127);
        int i2 = 0;
        while (i2 < jsonArray.size()) {
            JsonObject asJsonObject2 = jsonArray2.get(i2).getAsJsonObject();
            JSONObject parseJSONObject = parseJSONObject(asJsonObject2);
            int i3 = i2;
            if (XEParserUtil.isDeferDispatch(asJsonObject2)) {
                SystemUtils.log(3, "defer:post", str12 + asJsonObject2, (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser", 134);
                String asString3 = XEParserUtil.getAsString(str5, asJsonObject2, str4);
                String asString4 = XEParserUtil.getAsString(str3, asJsonObject2, str4);
                String str13 = str12;
                if (asString3.equals(str2)) {
                    XMLComponent xMLComponent = new XMLComponent();
                    xMLComponent.createData(asJsonObject2);
                    xMLComponent.setData((JSONObject) null);
                    xMLComponent.setDefered(true);
                    xMLComponent.setId(asString4);
                    xMLComponent.setView(new View(context2));
                    copyOnWriteArrayList2.add(xMLComponent);
                    xEParser.f50167c.remove(asString4);
                    xEParser.f50168d.decrementAndGet();
                } else if (asString3.equals(XEngineConst.XE_NATIVE_TEMPLATE) || TextUtils.isEmpty(asString3)) {
                    NativeComponent nativeComponent = new NativeComponent();
                    nativeComponent.setId(asString4);
                    nativeComponent.setData((JSONObject) null);
                    nativeComponent.setDefered(true);
                    nativeComponent.setView((View) null);
                    copyOnWriteArrayList2.add(nativeComponent);
                } else {
                    TemplateComponent templateComponent = new TemplateComponent();
                    templateComponent.setTemplateId(asString3);
                    templateComponent.setId(asString4);
                    templateComponent.setView(new View(context2));
                    templateComponent.setData((JSONObject) null);
                    templateComponent.setDefered(true);
                    copyOnWriteArrayList2.add(templateComponent);
                }
                final JsonArray jsonArray3 = new JsonArray();
                JsonObject deepCopy = asJsonObject2.deepCopy();
                XEParserUtil.removeDeferSign(deepCopy);
                if (!deepCopy.has(XEParseConst.CHILD_UPDATE_MODE_TAG)) {
                    XEParserUtil.addChildModifySign(deepCopy);
                }
                jsonArray3.add((JsonElement) deepCopy);
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.add("list", jsonArray3);
                if (jsonObject2.has(XEParseConst.XE_JSON_KEY_COM_TYPE)) {
                    jsonObject3.addProperty(XEParseConst.XE_JSON_KEY_COM_TYPE, (Number) Integer.valueOf(jsonObject2.get(XEParseConst.XE_JSON_KEY_COM_TYPE).getAsInt()));
                }
                if (jsonObject2.has(str5)) {
                    jsonObject3.addProperty(str5, jsonObject2.get(str5).getAsString());
                }
                XEParserUtil.addUpdateSign(jsonObject3, 1);
                C168861 r14 = r0;
                Handler handler3 = f50164e;
                final Context context3 = context;
                String str14 = str5;
                final List<XETemplateComponent> list2 = list;
                String str15 = str4;
                final String str16 = str;
                Handler handler4 = handler2;
                String str17 = str3;
                final JsonObject jsonObject4 = jsonObject3;
                String str18 = str2;
                final XEParserCallback xEParserCallback3 = xEParserCallback;
                C168861 r0 = new Runnable() {
                    public void run() {
                        new XEParser().m36147a(context3, list2, str16, jsonObject4, xEParserCallback3, jsonArray3);
                    }
                };
                handler3.post(r14);
                copyOnWriteArrayList = copyOnWriteArrayList2;
                str9 = str18;
                str6 = str14;
                str7 = str15;
                handler = handler4;
                str10 = str13;
                xEParser = this;
                context2 = context;
                str8 = str17;
            } else {
                String str19 = str12;
                String str20 = str5;
                String str21 = str4;
                String str22 = str2;
                Handler handler5 = handler2;
                String str23 = str3;
                if (asJsonObject2.has(str20)) {
                    String asString5 = XEParserUtil.getAsString(str20, asJsonObject2, str21);
                    String asString6 = XEParserUtil.getAsString(str23, asJsonObject2, str21);
                    if (asString5.equals(str22)) {
                        XMLComponent xMLComponent2 = new XMLComponent();
                        asJsonObject2.addProperty("container_id", str11);
                        xMLComponent2.createData(asJsonObject2);
                        xMLComponent2.setData(parseJSONObject);
                        xMLComponent2.setId(asString6);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(xMLComponent2.getXMlCardData() == null);
                        sb2.append(str21);
                        SystemUtils.log(3, "renderSize:XMLCardData", sb2.toString(), (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser", 211);
                        if (xMLComponent2.getXMlCardData() == null || xMLComponent2.getXMlCardData().getData() == null || xMLComponent2.getXMlCardData().getData().getCdn() == null) {
                            copyOnWriteArrayList = copyOnWriteArrayList2;
                            str9 = str22;
                            str6 = str20;
                            str7 = str21;
                            handler = handler5;
                            str10 = str19;
                            xEParser = this;
                            context2 = context;
                            str8 = str23;
                        } else {
                            final XMLComponent xMLComponent3 = xMLComponent2;
                            final CopyOnWriteArrayList copyOnWriteArrayList3 = copyOnWriteArrayList2;
                            final int i4 = i3;
                            final String str24 = asString6;
                            final Handler handler6 = handler5;
                            str9 = str22;
                            C168872 r10 = r0;
                            final XEParserCallback xEParserCallback4 = xEParserCallback;
                            Handler handler7 = handler5;
                            str8 = str23;
                            final String str25 = str;
                            CopyOnWriteArrayList copyOnWriteArrayList4 = copyOnWriteArrayList2;
                            final JsonObject jsonObject5 = jsonObject;
                            C168872 r02 = new AsyncViewLoadListener() {
                                public void onAsyncViewLoad(View view) {
                                    if (view != null) {
                                        synchronized (XEParser.this) {
                                            xMLComponent3.setView(view);
                                            if (XEParser.m36152b(xMLComponent3, copyOnWriteArrayList3, i4)) {
                                                XEParser.this.f50167c.remove(str24);
                                                int decrementAndGet = XEParser.this.f50168d.decrementAndGet();
                                                SystemUtils.log(3, "renderSize:Async", ":" + decrementAndGet, (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser$2", 222);
                                                if (decrementAndGet <= 0) {
                                                    handler6.removeCallbacksAndMessages((Object) null);
                                                    if (xEParserCallback4 != null) {
                                                        xEParserCallback4.onRenderSuccess(new XEngineData(str25, jsonObject5), copyOnWriteArrayList3);
                                                        for (XEComponent xEComponent : copyOnWriteArrayList3) {
                                                            SystemUtils.log(3, "renderSize:Async", xEComponent.toString(), (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser$2", 228);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                public void onAsyncViewLoadFailed() {
                                    synchronized (XEParser.this) {
                                        XEParser.this.f50167c.remove(str24);
                                        int decrementAndGet = XEParser.this.f50168d.decrementAndGet();
                                        SystemUtils.log(3, "onAsyncViewLoadFailed", ":" + decrementAndGet, (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser$2", 242);
                                        if (decrementAndGet <= 0) {
                                            handler6.removeCallbacksAndMessages((Object) null);
                                            if (xEParserCallback4 != null) {
                                                xEParserCallback4.onRenderSuccess(new XEngineData(str25, jsonObject5), copyOnWriteArrayList3);
                                                for (XEComponent xEComponent : copyOnWriteArrayList3) {
                                                    SystemUtils.log(3, "onAsyncViewLoadFailed", xEComponent.toString(), (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser$2", 249);
                                                }
                                            }
                                        }
                                    }
                                }
                            };
                            xMLComponent2.setLoadListener(r10);
                            str7 = str21;
                            context2 = context;
                            xMLComponent2.getView(context2);
                            str6 = str20;
                            xEParser = this;
                            if (!xEParser.f50166b) {
                                final XMLComponent xMLComponent4 = xMLComponent2;
                                final Context context4 = context;
                                final CopyOnWriteArrayList copyOnWriteArrayList5 = copyOnWriteArrayList4;
                                final int i5 = i3;
                                final String str26 = asString6;
                                final Handler handler8 = handler7;
                                final XEParserCallback xEParserCallback5 = xEParserCallback;
                                final String str27 = str;
                                C168883 r142 = r0;
                                final JsonObject jsonObject6 = jsonObject;
                                C168883 r03 = new Runnable() {
                                    public void run() {
                                        synchronized (XEParser.this) {
                                            if (xMLComponent4.getView(context4).getView() != null) {
                                                xMLComponent4.setView(xMLComponent4.getView(context4).getView());
                                                boolean unused = XEParser.this.f50166b = true;
                                                if (XEParser.m36152b(xMLComponent4, copyOnWriteArrayList5, i5)) {
                                                    XEParser.this.f50167c.remove(str26);
                                                    int decrementAndGet = XEParser.this.f50168d.decrementAndGet();
                                                    SystemUtils.log(3, "renderSize:already", ":" + decrementAndGet, (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser$3", 268);
                                                    if (decrementAndGet <= 0) {
                                                        handler8.removeCallbacksAndMessages((Object) null);
                                                        if (xEParserCallback5 != null) {
                                                            xEParserCallback5.onRenderSuccess(new XEngineData(str27, jsonObject6), copyOnWriteArrayList5);
                                                            for (XEComponent xEComponent : copyOnWriteArrayList5) {
                                                                SystemUtils.log(3, "renderSize:already", xEComponent.toString(), (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser$3", 274);
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                xMLComponent4.getView(context4);
                                            }
                                        }
                                    }
                                };
                                handler = handler7;
                                handler.postDelayed(r142, 200);
                            } else {
                                handler = handler7;
                                if (xMLComponent2.getView(context2).getView() != null) {
                                    xMLComponent2.setView(xMLComponent2.getView(context2).getView());
                                    copyOnWriteArrayList = copyOnWriteArrayList4;
                                    copyOnWriteArrayList.add(xMLComponent2);
                                    xEParser.f50166b = true;
                                    StringBuilder sb3 = new StringBuilder();
                                    str10 = str19;
                                    sb3.append(str10);
                                    sb3.append(xEParser.f50167c.size());
                                    SystemUtils.log(3, "renderSize:already", sb3.toString(), (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser", 290);
                                    xEParser.f50167c.remove(asString6);
                                }
                            }
                            copyOnWriteArrayList = copyOnWriteArrayList4;
                            str10 = str19;
                        }
                    } else {
                        copyOnWriteArrayList = copyOnWriteArrayList2;
                        str9 = str22;
                        str6 = str20;
                        str7 = str21;
                        handler = handler5;
                        str10 = str19;
                        xEParser = this;
                        context2 = context;
                        str8 = str23;
                        if (asString5.equals(XEngineConst.XE_NATIVE_TEMPLATE) || TextUtils.isEmpty(asString5)) {
                            String nativeId = getNativeId(asJsonObject2);
                            NativeComponent nativeComponent2 = new NativeComponent();
                            nativeComponent2.setId(nativeId);
                            nativeComponent2.setData(parseJSONObject);
                            copyOnWriteArrayList.add(nativeComponent2);
                        } else {
                            xEParser.f50165a = false;
                            if (list != null) {
                                Iterator<XETemplateComponent> it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    XETemplateComponent next = it.next();
                                    if (asString5.equals(next.getTemplateId())) {
                                        xEParser.f50165a = true;
                                        TemplateComponent templateComponent2 = new TemplateComponent();
                                        templateComponent2.setTemplateId(asString5);
                                        templateComponent2.setId(asString6);
                                        asJsonObject2.addProperty("position", (Number) Integer.valueOf(i3));
                                        templateComponent2.setView(createView(context2, asJsonObject2, next));
                                        templateComponent2.setData(parseJSONObject);
                                        copyOnWriteArrayList.add(templateComponent2);
                                        break;
                                    }
                                }
                                if (!xEParser.f50165a) {
                                    TemplateComponent templateComponent3 = new TemplateComponent();
                                    templateComponent3.setTemplateId(asString5);
                                    templateComponent3.setId(asString6);
                                    templateComponent3.setData(parseJSONObject);
                                    copyOnWriteArrayList.add(templateComponent3);
                                }
                            }
                        }
                    }
                } else {
                    copyOnWriteArrayList = copyOnWriteArrayList2;
                    str9 = str22;
                    str6 = str20;
                    str7 = str21;
                    handler = handler5;
                    str10 = str19;
                    xEParser = this;
                    context2 = context;
                    str8 = str23;
                    String nativeId2 = getNativeId(asJsonObject2);
                    NativeComponent nativeComponent3 = new NativeComponent();
                    nativeComponent3.setId(nativeId2);
                    nativeComponent3.setData(parseJSONObject);
                    copyOnWriteArrayList.add(nativeComponent3);
                }
            }
            jsonObject2 = jsonObject;
            xEParserCallback2 = xEParserCallback;
            jsonArray2 = jsonArray;
            i2 = i3 + 1;
            str12 = str10;
            copyOnWriteArrayList2 = copyOnWriteArrayList;
            handler2 = handler;
            str2 = str9;
            str3 = str8;
            str4 = str7;
            str5 = str6;
        }
        String str28 = str12;
        Handler handler9 = handler2;
        final CopyOnWriteArrayList copyOnWriteArrayList6 = copyOnWriteArrayList2;
        XEParserCallback xEParserCallback6 = xEParserCallback2;
        if (xEParserCallback6 != null) {
            SystemUtils.log(3, "renderSize:final", str28 + xEParser.f50167c.size(), (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser", 346);
            if (xEParser.f50168d.get() <= 0) {
                xEParserCallback6.onSuccess(new XEngineData(str11, jsonObject), copyOnWriteArrayList6);
                return;
            }
            final JsonObject jsonObject7 = jsonObject;
            final XEParserCallback xEParserCallback7 = xEParserCallback;
            final String str29 = str;
            handler9.postDelayed(new Runnable() {
                public void run() {
                    xEParserCallback7.onRenderSuccess(new XEngineData(str29, jsonObject7), copyOnWriteArrayList6);
                }
            }, (long) XEngineInnerRequest.XE_CALLBACK_TIME_OUT);
        }
    }

    public static NativeComponent parseNativeComponents(String str, List<NativeComponent> list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            for (NativeComponent next : list) {
                if (str.equals(next.getId())) {
                    return next;
                }
            }
        }
        return null;
    }

    public static JSONObject parseJSONObject(JsonObject jsonObject) {
        String str;
        if (jsonObject == null || jsonObject.getAsJsonObject() == null) {
            str = "";
        } else {
            str = jsonObject.getAsJsonObject().toString();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            TrackUtil.trackError(1, "", e, jsonObject.toString());
            e.printStackTrace();
            return null;
        }
    }

    public static View createView(Context context, JsonObject jsonObject, XETemplateComponent xETemplateComponent) {
        IXEViewModel iXEViewModel = (IXEViewModel) new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            public boolean shouldSkipClass(Class<?> cls) {
                return false;
            }

            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return fieldAttributes.getName().contains("extension");
            }
        }).create().fromJson((JsonElement) jsonObject, xETemplateComponent.getModelClass());
        iXEViewModel.parseExtension(jsonObject);
        return newTemplateView(context, xETemplateComponent, iXEViewModel);
    }

    public static View newTemplateView(Context context, XETemplateComponent xETemplateComponent, IXEViewModel iXEViewModel) {
        try {
            IXEView iXEView = (IXEView) xETemplateComponent.getViewClass().newInstance();
            iXEView.initView(context);
            iXEView.bindData(iXEViewModel);
            return iXEView.getView();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getNativeId(JsonObject jsonObject) {
        return XEParserUtil.getAsString("id", jsonObject, "");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static <T extends XEComponent> boolean m36152b(T t, List<T> list, int i) {
        SystemUtils.log(3, "renderSize:add2List", t.toString(), (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser", 438);
        boolean z = false;
        for (T id : list) {
            if (id.getId().equals(t.getId())) {
                z = true;
            }
        }
        SystemUtils.log(3, "renderSize:add2List2", "isAdded::" + z, (Throwable) null, "com.didiglobal.enginecore.data.parser.XEParser", 444);
        if (z) {
            return false;
        }
        try {
            list.add(i, t);
        } catch (Exception unused) {
            list.add(t);
        }
        return true;
    }
}
