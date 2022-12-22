package com.didi.beatles.p099im.plugin;

import android.text.TextUtils;
import com.didi.beatles.p099im.event.IMSendAddressEvent;
import com.didi.beatles.p099im.protocol.host.IMHostService;
import com.didi.beatles.p099im.protocol.model.IMPluginMsgWrapper;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IMHostService.class})
/* renamed from: com.didi.beatles.im.plugin.IMHostServiceImpl */
public class IMHostServiceImpl implements IMHostService {

    /* renamed from: a */
    private static final String f9469a = IMHostServiceImpl.class.getSimpleName();

    public boolean invoke(String str, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            IMLog.m6632e(f9469a, "INVOKE with null methodName");
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1727934318:
                if (str.equals(IMHostService.ACTION_SEND_PLUGIN_MESSAGE)) {
                    c = 2;
                    break;
                }
                break;
            case -269920940:
                if (str.equals(IMHostService.ACTION_SEND_LOCATION_MESSAGE)) {
                    c = 4;
                    break;
                }
                break;
            case 441049442:
                if (str.equals(IMHostService.ACTION_SEND_STREET_MESSAGE)) {
                    c = 3;
                    break;
                }
                break;
            case 1174963788:
                if (str.equals(IMHostService.ACTION_SEND_TEXT_MESSAGE)) {
                    c = 1;
                    break;
                }
                break;
            case 1862666772:
                if (str.equals("navigation")) {
                    c = 0;
                    break;
                }
                break;
        }
        if (c == 0) {
            return m6425a(objArr);
        }
        if (c == 1) {
            return m6426b(objArr);
        }
        if (c == 2) {
            return m6427c(objArr);
        }
        if (c == 3) {
            return m6428d(objArr);
        }
        if (c == 4) {
            return m6429e(objArr);
        }
        IMLog.m6632e(f9469a, C4234I.m6591t("[invoke] action:", str, " not implemented yet."));
        return false;
    }

    /* renamed from: a */
    private boolean m6425a(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length >= 2) {
                    Integer num = objArr[0];
                    if (num instanceof Integer) {
                        if (num.intValue() > 0) {
                            String str = objArr[1];
                            if (str instanceof String) {
                                if (!TextUtils.isEmpty(str)) {
                                    return IMHostProxy.getInstance().navigation(num.intValue(), str);
                                }
                            }
                            IMLog.m6632e(f9469a, C4234I.m6591t("[invokeNavigation] invalid params type:", str));
                            return false;
                        }
                    }
                    IMLog.m6632e(f9469a, C4234I.m6591t("[invokeNavigation] invalid params pluginId:", num));
                    return false;
                }
            } catch (Exception e) {
                IMLog.m6632e(f9469a, "[invokeNavigation]", e);
                return false;
            }
        }
        IMLog.m6632e(f9469a, C4234I.m6591t("[invokeNavigation] invalid params size"));
        return false;
    }

    /* renamed from: b */
    private boolean m6426b(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length >= 2) {
                    Integer num = objArr[0];
                    if (num instanceof Integer) {
                        if (num.intValue() > 0) {
                            String str = objArr[1];
                            if (str instanceof String) {
                                if (!TextUtils.isEmpty(str)) {
                                    return IMHostProxy.getInstance().sendTextMessage(num.intValue(), str);
                                }
                            }
                            IMLog.m6632e(f9469a, C4234I.m6591t("[invokeSendTextMessage] invalid params type:", str));
                            return false;
                        }
                    }
                    IMLog.m6632e(f9469a, C4234I.m6591t("[invokeSendTextMessage] invalid params pluginId:", num));
                    return false;
                }
            } catch (Exception e) {
                IMLog.m6632e(f9469a, "[invokeSendTextMessage]", e);
                return false;
            }
        }
        IMLog.m6632e(f9469a, C4234I.m6591t("[invokeSendTextMessage] invalid params size"));
        return false;
    }

    /* renamed from: c */
    private boolean m6427c(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length >= 2) {
                    Integer num = objArr[0];
                    if (num instanceof Integer) {
                        if (num.intValue() > 0) {
                            IMPluginMsgWrapper iMPluginMsgWrapper = objArr[1];
                            if (!(iMPluginMsgWrapper instanceof IMPluginMsgWrapper)) {
                                IMLog.m6632e(f9469a, C4234I.m6591t("[invokeSendPluginMessage] invalid params msg wrapper:", iMPluginMsgWrapper));
                                return false;
                            }
                            IMPluginMsgWrapper iMPluginMsgWrapper2 = iMPluginMsgWrapper;
                            return IMHostProxy.getInstance().sendPluginMessage(num.intValue(), iMPluginMsgWrapper2.content, iMPluginMsgWrapper2.listText, iMPluginMsgWrapper2.eid);
                        }
                    }
                    IMLog.m6632e(f9469a, C4234I.m6591t("[invokeSendPluginMessage] invalid params pluginId:", num));
                    return false;
                }
            } catch (Exception e) {
                IMLog.m6632e(f9469a, "[invokeSendPluginMessage]", e);
                return false;
            }
        }
        IMLog.m6632e(f9469a, C4234I.m6591t("[invokeSendPluginMessage] invalid params size"));
        return false;
    }

    /* renamed from: d */
    private boolean m6428d(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length >= 1) {
                    Integer num = objArr[0];
                    if (num instanceof Integer) {
                        if (num.intValue() > 0) {
                            return IMHostProxy.getInstance().sendStreetViewMessage(num.intValue());
                        }
                    }
                    IMLog.m6632e(f9469a, C4234I.m6591t("[invokeSendStreetMessage] invalid params pluginId:", num));
                    return false;
                }
            } catch (Exception e) {
                IMLog.m6632e(f9469a, "[invokeSendStreetMessage]", e);
                return false;
            }
        }
        IMLog.m6632e(f9469a, C4234I.m6591t("[invokeSendStreetMessage] invalid params size"));
        return false;
    }

    /* renamed from: e */
    private boolean m6429e(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length >= 2) {
                    IMSendAddressEvent iMSendAddressEvent = objArr[0];
                    if (!(iMSendAddressEvent instanceof IMSendAddressEvent)) {
                        IMLog.m6632e(f9469a, C4234I.m6591t("[invokeSendLocationMessage] invalid params pluginId:", iMSendAddressEvent));
                        return false;
                    }
                    Boolean bool = objArr[1];
                    if (bool instanceof Boolean) {
                        return IMHostProxy.getInstance().sendLocationMessage(iMSendAddressEvent, bool.booleanValue());
                    }
                    IMLog.m6632e(f9469a, C4234I.m6591t("[invokeSendStreetMessage] invalid params needDialog:", bool));
                    return false;
                }
            } catch (Exception e) {
                IMLog.m6632e(f9469a, "[invokeSendLocationMessage]", e);
                return false;
            }
        }
        IMLog.m6632e(f9469a, C4234I.m6591t("[invokeSendLocationMessage] invalid params size"));
        return false;
    }
}
