package com.didi.app;

import android.text.TextUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterHelper;
import com.didi.drouter.store.IRegister;
import com.didi.drouter.store.RouterKey;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class GeneralPageRouter {
    public static final String EVENT_KEY_DELIVERY_CALLBACK = "event_key_delivery_callback";
    public static final String RECIPIENT_LIST = "recipient_list";

    /* renamed from: b */
    private static final String f8223b = "params";

    /* renamed from: c */
    private static final String f8224c = "response";

    /* renamed from: d */
    private static final String f8225d = "target";

    /* renamed from: e */
    private static final String f8226e = "((taxis99onetravel)|(GlobalOneTravel)|(globalOneTravel)|(taxis99OneTravel)|(globalonetravel))://one/general.*";

    /* renamed from: f */
    private static volatile GeneralPageRouter f8227f;

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<String> f8228a = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (GeneralPageRouter.this.f8229g != null) {
                if (!(GeneralPageRouter.this.f8230h == null || str2 == null)) {
                    GeneralPageRouter.this.f8230h.putExtra("response", str2);
                }
                RouterHelper.release(GeneralPageRouter.this.f8229g);
                Request unused = GeneralPageRouter.this.f8229g = null;
                Result unused2 = GeneralPageRouter.this.f8230h = null;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Request f8229g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Result f8230h;

    /* renamed from: i */
    private IRegister f8231i;

    private GeneralPageRouter() {
    }

    public static GeneralPageRouter getInstance() {
        if (f8227f == null) {
            synchronized (GeneralPageRouter.class) {
                if (f8227f == null) {
                    f8227f = new GeneralPageRouter();
                }
            }
        }
        return f8227f;
    }

    /* renamed from: a */
    private void m5357a() {
        this.f8231i = DRouter.register(RouterKey.build(f8226e).setHold(true), (IRouterHandler) new IRouterHandler() {
            public void handle(Request request, Result result) {
                Request unused = GeneralPageRouter.this.f8229g = request;
                Result unused2 = GeneralPageRouter.this.f8230h = result;
                String queryParameter = request.getUri().getQueryParameter("target");
                if (queryParameter == null) {
                    RouterHelper.release(request);
                    return;
                }
                char c = 65535;
                if (queryParameter.hashCode() == -330539260 && queryParameter.equals(GeneralPageRouter.RECIPIENT_LIST)) {
                    c = 0;
                }
                if (c != 0) {
                    RouterHelper.release(request);
                    return;
                }
                try {
                    DRouter.build(URLDecoder.decode(GeneralPageRouter.this.m5356a(request.getUri().getQueryParameter("params")), "utf-8")).start();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m5356a(String str) {
        StringBuilder sb = new StringBuilder("taxis99OneTravel://one/delivery/delivery_consignee?");
        sb.append("source=1&");
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    sb.append(next);
                    sb.append("=");
                    sb.append(string);
                    sb.append(ParamKeys.SIGN_AND);
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private void m5359b() {
        BaseEventPublisher.getPublisher().subscribe(EVENT_KEY_DELIVERY_CALLBACK, this.f8228a);
    }

    public void register() {
        m5359b();
        m5357a();
    }

    /* renamed from: c */
    private void m5360c() {
        BaseEventPublisher.getPublisher().unsubscribe(EVENT_KEY_DELIVERY_CALLBACK, this.f8228a);
    }

    /* renamed from: d */
    private void m5361d() {
        this.f8231i.unregister();
    }

    public void unregister() {
        m5360c();
        m5361d();
    }
}
