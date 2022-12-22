package com.didi.beatles.p099im.access.utils;

import android.text.TextUtils;
import com.didi.beatles.p099im.access.msg.OperationMsgT1;
import com.didi.beatles.p099im.access.msg.OperationMsgT2;
import com.didi.beatles.p099im.access.msg.OperationMsgT3;
import com.didi.beatles.p099im.api.entity.IMMessageDownExtend;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMParseUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.beatles.im.access.utils.Parser */
public class Parser {

    /* renamed from: a */
    private static final String f8884a = "im-sdk";

    public static final int parsePluginViewType(int i) {
        if (i > 0) {
            return i + 2000;
        }
        return -1;
    }

    /* renamed from: a */
    private static long m5918a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getLong(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: b */
    private static String m5920b(JSONObject jSONObject, String str) {
        return jSONObject.optString(str);
    }

    public static OperationMsgT1 parseOperationMsgT1(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            OperationMsgT1 operationMsgT1 = new OperationMsgT1();
            if (jSONObject.has("title")) {
                operationMsgT1.title = m5920b(jSONObject, "title");
            }
            if (jSONObject.has("content")) {
                operationMsgT1.content = m5920b(jSONObject, "content");
            }
            if (jSONObject.has("timestamp")) {
                operationMsgT1.timeStamp = m5918a(jSONObject, "timestamp");
            }
            if (jSONObject.has("action")) {
                operationMsgT1.action = m5920b(jSONObject, "action");
            }
            if (jSONObject.has("luncherMode")) {
                operationMsgT1.luncherMode = jSONObject.optInt("luncherMode");
            }
            if (jSONObject.has("action_type")) {
                operationMsgT1.actionType = jSONObject.optInt("action_type");
            }
            return operationMsgT1;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static OperationMsgT3 parseOperationMsgT3(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("list");
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            OperationMsgT3 operationMsgT3 = new OperationMsgT3();
            operationMsgT3.items = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                OperationMsgT3.OperationMsgT3Item a = m5919a(jSONArray.getJSONObject(i));
                if (a != null) {
                    operationMsgT3.items.add(a);
                }
            }
            return operationMsgT3;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static final OperationMsgT3.OperationMsgT3Item m5919a(JSONObject jSONObject) {
        try {
            OperationMsgT3.OperationMsgT3Item operationMsgT3Item = new OperationMsgT3.OperationMsgT3Item();
            operationMsgT3Item.title = jSONObject.getString("title");
            operationMsgT3Item.icon = jSONObject.getString("icon");
            operationMsgT3Item.action = jSONObject.getString("action");
            return operationMsgT3Item;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String parseSubType(String str) {
        try {
            return new JSONObject(str).optString("subtype");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final int parseViewType(String str) {
        try {
            return new JSONObject(str).getInt("datatype");
        } catch (JSONException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static final int parseType(String str) {
        try {
            return new JSONObject(str).getInt("type");
        } catch (JSONException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static final int parseTemplate(String str) {
        try {
            return new JSONObject(str).getInt("template");
        } catch (JSONException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static final long parsePeerSessionId(String str) {
        try {
            long parseLong = IMParseUtil.parseLong(new JSONObject(str).getString("peer_sid"));
            if (parseLong == 0) {
                return -1;
            }
            return parseLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static final int parsePluginId(IMMessage iMMessage, int i) {
        try {
            IMMessageDownExtend parsedMessageExtend = iMMessage.getParsedMessageExtend();
            return parsedMessageExtend != null ? parsedMessageExtend.getPluginId() : i;
        } catch (Exception e) {
            IMLog.m6633e(e);
            return i;
        }
    }

    public static final boolean parseIsAnonRobotMessage(IMMessage iMMessage) {
        if (iMMessage == null || iMMessage.getType() != 393223) {
            return false;
        }
        try {
            IMMessageDownExtend parsedMessageExtend = iMMessage.getParsedMessageExtend();
            if (parsedMessageExtend == null) {
                return false;
            }
            int pluginId = parsedMessageExtend.getPluginId();
            boolean z = new JSONObject(iMMessage.getContent()).optInt("is_anon", 0) == 1;
            if (pluginId != 3 || !z) {
                return false;
            }
            return true;
        } catch (Exception e) {
            IMLog.m6633e(e);
            return false;
        }
    }

    public static final boolean parseIsRobotMessage(IMMessage iMMessage) {
        if (iMMessage == null || iMMessage.getType() != 393223) {
            return false;
        }
        try {
            IMMessageDownExtend parsedMessageExtend = iMMessage.getParsedMessageExtend();
            if (parsedMessageExtend != null && parsedMessageExtend.getPluginId() == 3) {
                return true;
            }
            return false;
        } catch (Exception e) {
            IMLog.m6633e(e);
            return false;
        }
    }

    public static final String getDispatchMessageActionUrl(IMMessage iMMessage) {
        if (iMMessage == null) {
            return null;
        }
        try {
            if (iMMessage.getType() != 528385) {
                return null;
            }
            String content = iMMessage.getContent();
            if (TextUtils.isEmpty(content)) {
                IMLog.m6631d(f8884a, "[getDispatchMessageActionUrl] NULL content.");
                return null;
            }
            int parseType = parseType(content);
            if (parseType != 1) {
                IMLog.m6631d(f8884a, "[getDispatchMessageActionUrl] Invalid type:" + parseType);
                return null;
            }
            int parseTemplate = parseTemplate(content);
            if (parseTemplate == 1) {
                OperationMsgT1 parseOperationMsgT1 = parseOperationMsgT1(content);
                if (parseOperationMsgT1 != null && parseOperationMsgT1.actionType == 1 && !TextUtils.isEmpty(parseOperationMsgT1.action)) {
                    return parseOperationMsgT1.action;
                }
            } else if (parseTemplate == 2) {
                OperationMsgT2 operationMsgT2 = (OperationMsgT2) IMJsonUtil.objectFromJson(content, OperationMsgT2.class);
                if (operationMsgT2 != null && operationMsgT2.actionType == 1 && !TextUtils.isEmpty(operationMsgT2.action)) {
                    return operationMsgT2.action;
                }
            } else {
                IMLog.m6631d(f8884a, "[getDispatchMessageActionUrl] Invalid template:" + parseTemplate);
            }
            return null;
        } catch (Exception e) {
            IMLog.m6632e("Parser", "[getDispatchMessageActionUrl]", e);
        }
    }
}
