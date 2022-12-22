package com.didi.beatles.p099im.module;

import com.didi.beatles.p099im.api.entity.IMConfig;
import com.didi.beatles.p099im.api.entity.IMConfigResponse;
import com.didi.beatles.p099im.protocol.model.IMBottomGuideConfig;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.IIMGlobalModule */
public interface IIMGlobalModule {
    List<IMBottomGuideConfig> getBtmGuideConfigList(int i);

    IMConfig.EggsInfo getBusinessEggsInfo(int i, int i2);

    IMConfigResponse.Config getCommonConfig();

    List<IMEmojiModule> getEmojiConfigList(int i, String str);

    void loadGlobalConfig(boolean z);

    IMConfig.EggsInfo matchBusinessEggsInfo(int i, String str);
}
