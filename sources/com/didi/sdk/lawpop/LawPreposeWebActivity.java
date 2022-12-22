package com.didi.sdk.lawpop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.tool.WebURLWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LawPreposeWebActivity extends WebActivity {
    public static final String INTENT_REPLACE_PARAMS = "intent_replace_params";

    /* renamed from: a */
    private LawPreposeReplaceParams f36429a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onCreateBefore(Bundle bundle) {
        super.onCreateBefore(bundle);
        m25802b();
    }

    /* access modifiers changed from: protected */
    public String appendQueryParams(String str) {
        Map<String, String> map;
        Uri parse = Uri.parse(super.appendQueryParams(str));
        LawPreposeReplaceParams lawPreposeReplaceParams = this.f36429a;
        if (!(lawPreposeReplaceParams == null || (map = lawPreposeReplaceParams.replaceParamMap) == null)) {
            for (Map.Entry<String, String> key : map.entrySet()) {
                parse = WebURLWriter.deleteUriParameter(parse, (String) key.getKey());
            }
            parse = WebURLWriter.appendUriQuery(parse, m25801a(map));
        }
        return parse.toString();
    }

    /* renamed from: b */
    private void m25802b() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f36429a = (LawPreposeReplaceParams) intent.getSerializableExtra(INTENT_REPLACE_PARAMS);
        }
    }

    /* renamed from: a */
    private static List<Pair<String, String>> m25801a(Map<String, String> map) {
        LinkedList linkedList = new LinkedList();
        if (!(map == null || map.size() == 0)) {
            for (String next : map.keySet()) {
                if (!TextUtils.isEmpty(next) && !next.startsWith("__x_")) {
                    String str = map.get(next);
                    if (!TextUtils.isEmpty(str)) {
                        linkedList.add(new Pair(next, str));
                    }
                }
            }
        }
        return linkedList;
    }
}
