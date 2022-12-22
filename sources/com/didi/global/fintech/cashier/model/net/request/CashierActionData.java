package com.didi.global.fintech.cashier.model.net.request;

import android.view.View;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bd\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bã\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 \u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010$J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010EJ\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010EJ\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010y\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\nHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jî\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0001J\u0017\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001R(\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R \u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R&\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010*\"\u0004\b8\u0010,R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010*\"\u0004\b:\u0010,R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010*\"\u0004\b<\u0010,R \u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010*\"\u0004\b>\u0010,R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR \u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010*\"\u0004\bD\u0010,R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\b\u0014\u0010E\"\u0004\bF\u0010GR \u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010*\"\u0004\bJ\u0010,R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010*\"\u0004\bL\u0010,R \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010*\"\u0004\bN\u0010,R \u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010*\"\u0004\bP\u0010,R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010*\"\u0004\bR\u0010,R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010*\"\u0004\bT\u0010,R \u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010*\"\u0004\bV\u0010,R \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010*\"\u0004\bX\u0010,R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010*\"\u0004\bZ\u0010,R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010*\"\u0004\b\\\u0010,R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010*\"\u0004\b^\u0010,R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\b_\u0010E\"\u0004\b`\u0010GR \u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010*\"\u0004\bb\u0010,R \u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010*\"\u0004\bd\u0010,R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010*\"\u0004\bf\u0010,¨\u0006\u0001"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/CashierActionData;", "Ljava/io/Serializable;", "qr_code_data", "", "threeDSResult", "", "reference", "vendor", "shopper", "action", "", "sessionId", "channelNameOf3ds", "cvvCardInfo", "Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "cardIndex", "cardNo", "productId", "status", "failReason", "isSet", "paySessionId", "scene", "brandName", "appId", "resourceId", "pubSource", "pageTitle", "title", "content", "bottom", "buttons", "", "Lcom/didi/global/fintech/cashier/model/net/request/ConfirmButton;", "url", "callbackStatus", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/util/Map;", "setAction", "(Ljava/util/Map;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getBottom", "setBottom", "getBrandName", "setBrandName", "getButtons", "()Ljava/util/List;", "setButtons", "(Ljava/util/List;)V", "getCallbackStatus", "setCallbackStatus", "getCardIndex", "setCardIndex", "getCardNo", "setCardNo", "getChannelNameOf3ds", "setChannelNameOf3ds", "getContent", "setContent", "getCvvCardInfo", "()Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "setCvvCardInfo", "(Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;)V", "getFailReason", "setFailReason", "()Ljava/lang/Integer;", "setSet", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPageTitle", "setPageTitle", "getPaySessionId", "setPaySessionId", "getProductId", "setProductId", "getPubSource", "setPubSource", "getQr_code_data", "setQr_code_data", "getReference", "setReference", "getResourceId", "setResourceId", "getScene", "setScene", "getSessionId", "setSessionId", "getShopper", "setShopper", "getStatus", "setStatus", "getThreeDSResult", "setThreeDSResult", "getTitle", "setTitle", "getUrl", "setUrl", "getVendor", "setVendor", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/didi/global/fintech/cashier/model/net/request/CashierActionData;", "equals", "", "other", "", "hashCode", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierAction.kt */
public final class CashierActionData implements Serializable {
    @SerializedName("action")
    private Map<?, ?> action;
    @SerializedName("app_id")
    private String appId;
    @SerializedName("bottom")
    private String bottom;
    @SerializedName("brand_name")
    private String brandName;
    @SerializedName("buttons")
    private List<ConfirmButton> buttons;
    @SerializedName("callback_status")
    private String callbackStatus;
    @SerializedName("card_index")
    private String cardIndex;
    @SerializedName("card_suffix")
    private String cardNo;
    @SerializedName("channelNameOf3ds")
    private String channelNameOf3ds;
    @SerializedName("content")
    private String content;
    @SerializedName("extra_info")
    private CVVCardInfo cvvCardInfo;
    @SerializedName("fail_reason")
    private String failReason;
    @SerializedName("is_set")
    private Integer isSet;
    @SerializedName("page_title")
    private String pageTitle;
    @SerializedName("pay_session_id")
    private String paySessionId;
    @SerializedName("product_id")
    private String productId;
    @SerializedName("pub_source")
    private String pubSource;
    @SerializedName("qr_code_data")
    private String qr_code_data;
    @SerializedName("reference")
    private String reference;
    @SerializedName("resource_id")
    private String resourceId;
    @SerializedName("scene")
    private String scene;
    @SerializedName("sessionId")
    private String sessionId;
    @SerializedName("shopper")
    private String shopper;
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private Integer threeDSResult;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("vendor")
    private String vendor;

    public CashierActionData() {
        this((String) null, (Integer) null, (String) null, (String) null, (String) null, (Map) null, (String) null, (String) null, (CVVCardInfo) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, 268435455, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CashierActionData copy$default(CashierActionData cashierActionData, String str, Integer num, String str2, String str3, String str4, Map map, String str5, String str6, CVVCardInfo cVVCardInfo, String str7, String str8, String str9, String str10, String str11, Integer num2, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, List list, String str22, String str23, int i, Object obj) {
        CashierActionData cashierActionData2 = cashierActionData;
        int i2 = i;
        return cashierActionData.copy((i2 & 1) != 0 ? cashierActionData2.qr_code_data : str, (i2 & 2) != 0 ? cashierActionData2.threeDSResult : num, (i2 & 4) != 0 ? cashierActionData2.reference : str2, (i2 & 8) != 0 ? cashierActionData2.vendor : str3, (i2 & 16) != 0 ? cashierActionData2.shopper : str4, (i2 & 32) != 0 ? cashierActionData2.action : map, (i2 & 64) != 0 ? cashierActionData2.sessionId : str5, (i2 & 128) != 0 ? cashierActionData2.channelNameOf3ds : str6, (i2 & 256) != 0 ? cashierActionData2.cvvCardInfo : cVVCardInfo, (i2 & 512) != 0 ? cashierActionData2.cardIndex : str7, (i2 & 1024) != 0 ? cashierActionData2.cardNo : str8, (i2 & 2048) != 0 ? cashierActionData2.productId : str9, (i2 & 4096) != 0 ? cashierActionData2.status : str10, (i2 & 8192) != 0 ? cashierActionData2.failReason : str11, (i2 & 16384) != 0 ? cashierActionData2.isSet : num2, (i2 & 32768) != 0 ? cashierActionData2.paySessionId : str12, (i2 & 65536) != 0 ? cashierActionData2.scene : str13, (i2 & 131072) != 0 ? cashierActionData2.brandName : str14, (i2 & 262144) != 0 ? cashierActionData2.appId : str15, (i2 & 524288) != 0 ? cashierActionData2.resourceId : str16, (i2 & 1048576) != 0 ? cashierActionData2.pubSource : str17, (i2 & 2097152) != 0 ? cashierActionData2.pageTitle : str18, (i2 & 4194304) != 0 ? cashierActionData2.title : str19, (i2 & 8388608) != 0 ? cashierActionData2.content : str20, (i2 & 16777216) != 0 ? cashierActionData2.bottom : str21, (i2 & 33554432) != 0 ? cashierActionData2.buttons : list, (i2 & View.STATUS_BAR_TRANSIENT) != 0 ? cashierActionData2.url : str22, (i2 & View.NAVIGATION_BAR_TRANSIENT) != 0 ? cashierActionData2.callbackStatus : str23);
    }

    public final String component1() {
        return this.qr_code_data;
    }

    public final String component10() {
        return this.cardIndex;
    }

    public final String component11() {
        return this.cardNo;
    }

    public final String component12() {
        return this.productId;
    }

    public final String component13() {
        return this.status;
    }

    public final String component14() {
        return this.failReason;
    }

    public final Integer component15() {
        return this.isSet;
    }

    public final String component16() {
        return this.paySessionId;
    }

    public final String component17() {
        return this.scene;
    }

    public final String component18() {
        return this.brandName;
    }

    public final String component19() {
        return this.appId;
    }

    public final Integer component2() {
        return this.threeDSResult;
    }

    public final String component20() {
        return this.resourceId;
    }

    public final String component21() {
        return this.pubSource;
    }

    public final String component22() {
        return this.pageTitle;
    }

    public final String component23() {
        return this.title;
    }

    public final String component24() {
        return this.content;
    }

    public final String component25() {
        return this.bottom;
    }

    public final List<ConfirmButton> component26() {
        return this.buttons;
    }

    public final String component27() {
        return this.url;
    }

    public final String component28() {
        return this.callbackStatus;
    }

    public final String component3() {
        return this.reference;
    }

    public final String component4() {
        return this.vendor;
    }

    public final String component5() {
        return this.shopper;
    }

    public final Map<?, ?> component6() {
        return this.action;
    }

    public final String component7() {
        return this.sessionId;
    }

    public final String component8() {
        return this.channelNameOf3ds;
    }

    public final CVVCardInfo component9() {
        return this.cvvCardInfo;
    }

    public final CashierActionData copy(String str, Integer num, String str2, String str3, String str4, Map<?, ?> map, String str5, String str6, CVVCardInfo cVVCardInfo, String str7, String str8, String str9, String str10, String str11, Integer num2, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, List<ConfirmButton> list, String str22, String str23) {
        return new CashierActionData(str, num, str2, str3, str4, map, str5, str6, cVVCardInfo, str7, str8, str9, str10, str11, num2, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, list, str22, str23);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CashierActionData)) {
            return false;
        }
        CashierActionData cashierActionData = (CashierActionData) obj;
        return Intrinsics.areEqual((Object) this.qr_code_data, (Object) cashierActionData.qr_code_data) && Intrinsics.areEqual((Object) this.threeDSResult, (Object) cashierActionData.threeDSResult) && Intrinsics.areEqual((Object) this.reference, (Object) cashierActionData.reference) && Intrinsics.areEqual((Object) this.vendor, (Object) cashierActionData.vendor) && Intrinsics.areEqual((Object) this.shopper, (Object) cashierActionData.shopper) && Intrinsics.areEqual((Object) this.action, (Object) cashierActionData.action) && Intrinsics.areEqual((Object) this.sessionId, (Object) cashierActionData.sessionId) && Intrinsics.areEqual((Object) this.channelNameOf3ds, (Object) cashierActionData.channelNameOf3ds) && Intrinsics.areEqual((Object) this.cvvCardInfo, (Object) cashierActionData.cvvCardInfo) && Intrinsics.areEqual((Object) this.cardIndex, (Object) cashierActionData.cardIndex) && Intrinsics.areEqual((Object) this.cardNo, (Object) cashierActionData.cardNo) && Intrinsics.areEqual((Object) this.productId, (Object) cashierActionData.productId) && Intrinsics.areEqual((Object) this.status, (Object) cashierActionData.status) && Intrinsics.areEqual((Object) this.failReason, (Object) cashierActionData.failReason) && Intrinsics.areEqual((Object) this.isSet, (Object) cashierActionData.isSet) && Intrinsics.areEqual((Object) this.paySessionId, (Object) cashierActionData.paySessionId) && Intrinsics.areEqual((Object) this.scene, (Object) cashierActionData.scene) && Intrinsics.areEqual((Object) this.brandName, (Object) cashierActionData.brandName) && Intrinsics.areEqual((Object) this.appId, (Object) cashierActionData.appId) && Intrinsics.areEqual((Object) this.resourceId, (Object) cashierActionData.resourceId) && Intrinsics.areEqual((Object) this.pubSource, (Object) cashierActionData.pubSource) && Intrinsics.areEqual((Object) this.pageTitle, (Object) cashierActionData.pageTitle) && Intrinsics.areEqual((Object) this.title, (Object) cashierActionData.title) && Intrinsics.areEqual((Object) this.content, (Object) cashierActionData.content) && Intrinsics.areEqual((Object) this.bottom, (Object) cashierActionData.bottom) && Intrinsics.areEqual((Object) this.buttons, (Object) cashierActionData.buttons) && Intrinsics.areEqual((Object) this.url, (Object) cashierActionData.url) && Intrinsics.areEqual((Object) this.callbackStatus, (Object) cashierActionData.callbackStatus);
    }

    public int hashCode() {
        String str = this.qr_code_data;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.threeDSResult;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.reference;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.vendor;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.shopper;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Map<?, ?> map = this.action;
        int hashCode6 = (hashCode5 + (map == null ? 0 : map.hashCode())) * 31;
        String str5 = this.sessionId;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.channelNameOf3ds;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        CVVCardInfo cVVCardInfo = this.cvvCardInfo;
        int hashCode9 = (hashCode8 + (cVVCardInfo == null ? 0 : cVVCardInfo.hashCode())) * 31;
        String str7 = this.cardIndex;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.cardNo;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.productId;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.status;
        int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.failReason;
        int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Integer num2 = this.isSet;
        int hashCode15 = (hashCode14 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str12 = this.paySessionId;
        int hashCode16 = (hashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.scene;
        int hashCode17 = (hashCode16 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.brandName;
        int hashCode18 = (hashCode17 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.appId;
        int hashCode19 = (hashCode18 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.resourceId;
        int hashCode20 = (hashCode19 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.pubSource;
        int hashCode21 = (hashCode20 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.pageTitle;
        int hashCode22 = (hashCode21 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.title;
        int hashCode23 = (hashCode22 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.content;
        int hashCode24 = (hashCode23 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.bottom;
        int hashCode25 = (hashCode24 + (str21 == null ? 0 : str21.hashCode())) * 31;
        List<ConfirmButton> list = this.buttons;
        int hashCode26 = (hashCode25 + (list == null ? 0 : list.hashCode())) * 31;
        String str22 = this.url;
        int hashCode27 = (hashCode26 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.callbackStatus;
        if (str23 != null) {
            i = str23.hashCode();
        }
        return hashCode27 + i;
    }

    public String toString() {
        return "CashierActionData(qr_code_data=" + this.qr_code_data + ", threeDSResult=" + this.threeDSResult + ", reference=" + this.reference + ", vendor=" + this.vendor + ", shopper=" + this.shopper + ", action=" + this.action + ", sessionId=" + this.sessionId + ", channelNameOf3ds=" + this.channelNameOf3ds + ", cvvCardInfo=" + this.cvvCardInfo + ", cardIndex=" + this.cardIndex + ", cardNo=" + this.cardNo + ", productId=" + this.productId + ", status=" + this.status + ", failReason=" + this.failReason + ", isSet=" + this.isSet + ", paySessionId=" + this.paySessionId + ", scene=" + this.scene + ", brandName=" + this.brandName + ", appId=" + this.appId + ", resourceId=" + this.resourceId + ", pubSource=" + this.pubSource + ", pageTitle=" + this.pageTitle + ", title=" + this.title + ", content=" + this.content + ", bottom=" + this.bottom + ", buttons=" + this.buttons + ", url=" + this.url + ", callbackStatus=" + this.callbackStatus + VersionRange.RIGHT_OPEN;
    }

    public CashierActionData(String str, Integer num, String str2, String str3, String str4, Map<?, ?> map, String str5, String str6, CVVCardInfo cVVCardInfo, String str7, String str8, String str9, String str10, String str11, Integer num2, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, List<ConfirmButton> list, String str22, String str23) {
        this.qr_code_data = str;
        this.threeDSResult = num;
        this.reference = str2;
        this.vendor = str3;
        this.shopper = str4;
        this.action = map;
        this.sessionId = str5;
        this.channelNameOf3ds = str6;
        this.cvvCardInfo = cVVCardInfo;
        this.cardIndex = str7;
        this.cardNo = str8;
        this.productId = str9;
        this.status = str10;
        this.failReason = str11;
        this.isSet = num2;
        this.paySessionId = str12;
        this.scene = str13;
        this.brandName = str14;
        this.appId = str15;
        this.resourceId = str16;
        this.pubSource = str17;
        this.pageTitle = str18;
        this.title = str19;
        this.content = str20;
        this.bottom = str21;
        this.buttons = list;
        this.url = str22;
        this.callbackStatus = str23;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CashierActionData(java.lang.String r30, java.lang.Integer r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.util.Map r35, java.lang.String r36, java.lang.String r37, com.didi.global.fintech.cashier.model.net.request.CVVCardInfo r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.Integer r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.util.List r55, java.lang.String r56, java.lang.String r57, int r58, kotlin.jvm.internal.DefaultConstructorMarker r59) {
        /*
            r29 = this;
            r0 = r58
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r30
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r31
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r32
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r33
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r34
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r35
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r36
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r37
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r38
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r39
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r40
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r41
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r42
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r43
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r44
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r45
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r46
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r47
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r48
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r49
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r50
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r51
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r52
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            r24 = 0
            goto L_0x00de
        L_0x00dc:
            r24 = r53
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = 0
            goto L_0x00e9
        L_0x00e7:
            r25 = r54
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f2
            r26 = 0
            goto L_0x00f4
        L_0x00f2:
            r26 = r55
        L_0x00f4:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fd
            r27 = 0
            goto L_0x00ff
        L_0x00fd:
            r27 = r56
        L_0x00ff:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r0 & r28
            if (r0 == 0) goto L_0x0107
            r0 = 0
            goto L_0x0109
        L_0x0107:
            r0 = r57
        L_0x0109:
            r30 = r29
            r31 = r1
            r32 = r3
            r33 = r4
            r34 = r5
            r35 = r6
            r36 = r7
            r37 = r8
            r38 = r9
            r39 = r10
            r40 = r11
            r41 = r12
            r42 = r13
            r43 = r14
            r44 = r15
            r45 = r2
            r46 = r16
            r47 = r17
            r48 = r18
            r49 = r19
            r50 = r20
            r51 = r21
            r52 = r22
            r53 = r23
            r54 = r24
            r55 = r25
            r56 = r26
            r57 = r27
            r58 = r0
            r30.<init>(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.request.CashierActionData.<init>(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.String, com.didi.global.fintech.cashier.model.net.request.CVVCardInfo, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getQr_code_data() {
        return this.qr_code_data;
    }

    public final void setQr_code_data(String str) {
        this.qr_code_data = str;
    }

    public final Integer getThreeDSResult() {
        return this.threeDSResult;
    }

    public final void setThreeDSResult(Integer num) {
        this.threeDSResult = num;
    }

    public final String getReference() {
        return this.reference;
    }

    public final void setReference(String str) {
        this.reference = str;
    }

    public final String getVendor() {
        return this.vendor;
    }

    public final void setVendor(String str) {
        this.vendor = str;
    }

    public final String getShopper() {
        return this.shopper;
    }

    public final void setShopper(String str) {
        this.shopper = str;
    }

    public final Map<?, ?> getAction() {
        return this.action;
    }

    public final void setAction(Map<?, ?> map) {
        this.action = map;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final String getChannelNameOf3ds() {
        return this.channelNameOf3ds;
    }

    public final void setChannelNameOf3ds(String str) {
        this.channelNameOf3ds = str;
    }

    public final CVVCardInfo getCvvCardInfo() {
        return this.cvvCardInfo;
    }

    public final void setCvvCardInfo(CVVCardInfo cVVCardInfo) {
        this.cvvCardInfo = cVVCardInfo;
    }

    public final String getCardIndex() {
        return this.cardIndex;
    }

    public final void setCardIndex(String str) {
        this.cardIndex = str;
    }

    public final String getCardNo() {
        return this.cardNo;
    }

    public final void setCardNo(String str) {
        this.cardNo = str;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final void setFailReason(String str) {
        this.failReason = str;
    }

    public final Integer isSet() {
        return this.isSet;
    }

    public final void setSet(Integer num) {
        this.isSet = num;
    }

    public final String getPaySessionId() {
        return this.paySessionId;
    }

    public final void setPaySessionId(String str) {
        this.paySessionId = str;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String str) {
        this.scene = str;
    }

    public final String getBrandName() {
        return this.brandName;
    }

    public final void setBrandName(String str) {
        this.brandName = str;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final String getPubSource() {
        return this.pubSource;
    }

    public final void setPubSource(String str) {
        this.pubSource = str;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final void setPageTitle(String str) {
        this.pageTitle = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getBottom() {
        return this.bottom;
    }

    public final void setBottom(String str) {
        this.bottom = str;
    }

    public final List<ConfirmButton> getButtons() {
        return this.buttons;
    }

    public final void setButtons(List<ConfirmButton> list) {
        this.buttons = list;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getCallbackStatus() {
        return this.callbackStatus;
    }

    public final void setCallbackStatus(String str) {
        this.callbackStatus = str;
    }
}
