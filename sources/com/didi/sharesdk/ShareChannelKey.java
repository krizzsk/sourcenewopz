package com.didi.sharesdk;

public class ShareChannelKey {
    private static volatile ShareChannelKey instance;
    private String channelKey = "share_media";

    private ShareChannelKey() {
    }

    public static ShareChannelKey getInstance() {
        if (instance == null) {
            synchronized (ShareChannelKey.class) {
                if (instance == null) {
                    instance = new ShareChannelKey();
                }
            }
        }
        return instance;
    }

    public String getChannelKey() {
        return this.channelKey;
    }

    public void setChannelKey(String str) {
        this.channelKey = str;
    }
}
