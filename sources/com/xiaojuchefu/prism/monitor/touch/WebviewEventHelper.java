package com.xiaojuchefu.prism.monitor.touch;

import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.xiaojuchefu.prism.monitor.PrismMonitor;
import com.xiaojuchefu.prism.monitor.model.EventData;

public class WebviewEventHelper {

    /* renamed from: a */
    private static final String f56133a = "!function(){\"use strict\";var e=new(function(){function e(){}return e.prototype.record=function(e){for(var t=this.getContent(e),n=[];e&&\"body\"!==e.nodeName.toLowerCase();){var r=e.nodeName.toLowerCase();if(e.id)r+=\"#\"+e.id;else{for(var i=e.className.split(\" \").filter((function(e){return\"\"!==e.trim()})).join(\".\"),o=!(null===i||\"\"===i),s=e,c=1;s.previousElementSibling;)s=s.previousElementSibling,o&&s.className.split(\" \").filter((function(e){return\"\"!==e.trim()})).join(\".\")===i&&(o=!1),c+=1;if(o)for(s=e;s.nextElementSibling;)if(s=s.nextElementSibling,o&&s.className.split(\" \").filter((function(e){return\"\"!==e.trim()})).join(\".\")===i){o=!1;break}o?r+=\".\"+i:c>1&&(r+=\":nth-child(\"+c+\")\")}n.unshift(r),e=e.parentElement} n.unshift(\"body\"); return n.join(\">\")+\">\"+t;},e.prototype.getContent=function(e){return e.innerText?this.getText(e):e.getAttribute(\"src\")?e.getAttribute(\"src\"):e.querySelectorAll(\"img\")&&e.querySelectorAll(\"img\").length>0?this.getImgSrc(e):\"\"},e.prototype.getText=function(e){if(!(e.childNodes&&e.childNodes.length>0))return e.innerText||e.nodeValue;for(var t=0;t<e.childNodes.length;t++)if(e.childNodes[t].childNodes){var n=this.getText(e.childNodes[t]);if(n)return n}},e.prototype.getImgSrc=function(e){var t=e.querySelectorAll(\"img\");return t&&t[0]&&t[0].src},e}()),t=!1;document.addEventListener(\"touchmove\",(function(){!0!==t&&(t=!0)})),document.addEventListener(\"touchend\",(function(n){if(!0!==t){if(n.target)try{omega_collect_js_click.onClick(e.record(n.target))}catch(e){}}else t=!1}))}();";

    /* renamed from: b */
    private static final String f56134b = "!function(){\"use strict\";var t=new(function(){function t(){}return t.prototype.play=function(t){var e=this,n=document.querySelector(t);n&&(n.scrollIntoView({behavior:\"smooth\",block:\"center\",inline:\"nearest\"}),this.change(n),setTimeout((function(){var t=n.getBoundingClientRect();e.sendTouchEvent((t.left+t.right)/2,(t.top+t.bottom)/2,n,\"touchstart\"),e.sendTouchEvent((t.left+t.right)/2,(t.top+t.bottom)/2,n,\"touchend\"),e.fireClick(n)}),200))},t.prototype.fireClick=function(t){if(document.createEvent){var e=document.createEvent(\"MouseEvents\");e.initEvent(\"click\",!0,!1),t.dispatchEvent(e)}},t.prototype.change=function(t){var e=t.getAttribute(\"style\"),n=\"background\",o=0,i=setTimeout((function c(){if(o)e?t.setAttribute(\"style\",e):t.setAttribute(\"style\",\"\"),clearTimeout(i);else{var r=\"background-color: rgba(255, 0, 0,0.3)\";if(e&&(e.indexOf(n)>=0||e.indexOf(\"background-color\")>=0)){var u=e.split(\";\"),a=u.findIndex((function(t){return-1!==t.indexOf(n)||-1!==t.indexOf(\"background-color\")}));-1!==a&&u.splice(a,1,\"background-color: rgba(255, 0, 0,0.3)\"),r=u.join(\";\")}t.setAttribute(\"style\",r),o=1,i=setTimeout(c,400)}}),0)},t.prototype.sendTouchEvent=function(t,e,n,o){var i=new Touch({identifier:Date.now(),target:n,clientX:t,clientY:e,screenX:t,screenY:e,pageX:t,pageY:e,radiusX:5.5,radiusY:5.5,rotationAngle:0,force:1}),c=new TouchEvent(o,{cancelable:!0,bubbles:!0,touches:[i],targetTouches:[i],changedTouches:[i],shiftKey:!0});n.dispatchEvent(c)},t}());\"object\"==typeof window&&(window.PRISM_PLAYBACK_PLAY=t.play.bind(t))}();";

    /* renamed from: c */
    private static final String f56135c = "Omega_webview_collect_js";

    /* renamed from: d */
    private static final String f56136d = "Omega_webview_play_js";

    /* renamed from: e */
    private static final String f56137e = "omega_collect_js_click";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static boolean f56138f;

    public static void startMonitor() {
        f56138f = true;
    }

    public static void addWebviewEventObject(WebView webView) {
        if (webView != null && f56138f) {
            webView.addJavascriptInterface(JSObject.getInstance(), f56137e);
        }
    }

    private static class JSObject {
        private static JSObject onlyone = new JSObject();

        private JSObject() {
        }

        /* access modifiers changed from: private */
        public static JSObject getInstance() {
            return onlyone;
        }

        @JavascriptInterface
        public void onClick(String str) {
            if (PrismMonitor.getInstance().isMonitoring() && WebviewEventHelper.f56138f && !TextUtils.isEmpty(str)) {
                int lastIndexOf = str.lastIndexOf(IMTextUtils.STREET_IMAGE_TAG_END);
                EventData eventData = new EventData(14);
                if (lastIndexOf > 0) {
                    eventData.f56108h5 = str.substring(0, lastIndexOf);
                    eventData.f56114vr = str.substring(lastIndexOf + 1, str.length());
                } else {
                    eventData.f56114vr = str;
                }
                PrismMonitor.getInstance().post(eventData);
            }
        }
    }

    public static void collectWebView(View view) {
        if (view != null && (view instanceof WebView) && f56138f) {
            m40402a((WebView) view, f56135c, f56133a);
        }
    }

    public static void playWebView(View view, String str) {
        if (view != null && (view instanceof WebView) && f56138f && !TextUtils.isEmpty(str)) {
            WebView webView = (WebView) view;
            m40402a(webView, f56136d, f56134b);
            webView.evaluateJavascript("javascript:PRISM_PLAYBACK_PLAY('" + str + "')", (ValueCallback) null);
        }
    }

    /* renamed from: a */
    private static void m40402a(WebView webView, String str, String str2) {
        if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && f56138f) {
            Object tag = webView.getTag(str.hashCode());
            if (tag == null || !(tag instanceof Boolean) || !((Boolean) tag).booleanValue()) {
                webView.getSettings().setJavaScriptEnabled(true);
                webView.evaluateJavascript("javascript:" + str2, (ValueCallback) null);
                webView.setTag(str.hashCode(), true);
            }
        }
    }
}
