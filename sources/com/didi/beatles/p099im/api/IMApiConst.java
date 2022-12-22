package com.didi.beatles.p099im.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.api.IMApiConst */
public class IMApiConst {
    public static final int MsgCategoryGroup = 2;
    public static final int MsgCategorySingle = 1;
    public static final int MsgTypeBusiness = 327681;
    public static final int MsgTypeCloseShareLocation = 10485762;
    public static final int MsgTypeCmd = 524289;
    public static final int MsgTypeCustomFace = 327680;
    public static final int MsgTypeExtend = 528385;
    public static final int MsgTypeFile = 262144;
    public static final int MsgTypeHelper = 393220;
    public static final int MsgTypeHelperPicture = 393221;
    public static final int MsgTypeImage = 196608;
    public static final int MsgTypeOderStatusChange = 393219;
    public static final int MsgTypePlugin = 393223;
    public static final int MsgTypePushSystemMsg = 393222;
    public static final int MsgTypeRichInfo = 458752;
    public static final int MsgTypeSendLocation = 10486017;
    public static final int MsgTypeShareLocation = 10485761;
    public static final int MsgTypeSyncSessionStatus = 12;
    public static final int MsgTypeSystem = 393217;
    public static final int MsgTypeSystemAudio = 393224;
    public static final int MsgTypeText = 65536;
    public static final int MsgTypeTextRecommend = 65537;
    public static final int MsgTypeUnknow = 589824;
    public static final int MsgTypeVoice = 131072;
    public static final int OpTypeCheckSessionEnable = 15;
    public static final int OpTypeCloseSession = 13;
    public static final int OpTypeCreateSession = 7;
    public static final int OpTypeDeleteMsg = 4;
    public static final int OpTypeDeleteSession = 6;
    public static final int OpTypeDriverSendStreet = 339;
    public static final int OpTypeForbid = 311;
    public static final int OpTypeGetConfig = 261;
    public static final int OpTypeGetSessionInfo = 5;
    public static final int OpTypeGetUserInfo = 8;
    public static final int OpTypeInvokePhone = 24;
    public static final int OpTypePassengerGetStreet = 338;
    public static final int OpTypePullDetailMsg = 1;
    public static final int OpTypePullSessionList = 2;
    public static final int OpTypeSendActionTip = 20;
    public static final int OpTypeSendExtendMsg = 14;
    public static final int OpTypeSendMsg = 3;
    public static final int OpTypeSendRdAck = 9;
    public static final int OpTypeSyncSessionInfo = 12;
    public static final int OptypeGetReadStatus = 18;
    public static final int OptypePushReadStatus = 17;
    public static final int OptypeUsfulExpression = 16;
    public static final int PULL_SCENE_ADMIN = 0;
    public static final int PULL_SCENE_FIRST = 7;
    public static final int PULL_SCENE_GETUI = 5;
    public static final int PULL_SCENE_LONG = 1;
    public static final int PULL_SCENE_OTHER = 6;
    public static final int PULL_SCENE_PAGE = 2;
    public static final int PULL_SCENE_POLL = 3;
    public static final int PULL_SCENE_XIAOMI = 4;
    public static final int RspTypeAsync = 2;
    public static final int RspTypeCloseConnection = 11;
    public static final int RspTypeErrorToken = 3;
    public static final int RspTypeForbidden = 4;
    public static final int RspTypeInvalidRequest = 5;
    public static final int RspTypeNoChange = 6;
    public static final int RspTypeOK = 1;
    public static final int RspTypeOverload = 7;
    public static final int RspTypeProcTimeout = 8;
    public static final int RspTypeServerError = 9;
    public static final int RspTypeServiceUnavailable = 10;
    public static final int TYPE_COMMON_WORD_USER = 2;
    public static final int TYPE__COMMON_WORD_SYSTEM = 1;
    public static long oid;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.api.IMApiConst$PullScene */
    public @interface PullScene {
    }
}
