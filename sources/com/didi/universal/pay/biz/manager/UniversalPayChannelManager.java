package com.didi.universal.pay.biz.manager;

public class UniversalPayChannelManager {
    public static boolean isPlatformPayChannel(int i) {
        return i == 108 || i == 115 || i == 118 || i == 121 || i == 123 || i == 126 || i == 161;
    }

    public static boolean isThirdPayChannel(int i) {
        if (!(i == 127 || i == 128 || i == 144 || i == 150 || i == 152 || i == 162 || i == 166 || i == 180 || i == 190 || i == 192 || i == 9100)) {
            switch (i) {
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                    break;
                default:
                    switch (i) {
                        case 170:
                        case 171:
                        case 172:
                        case 173:
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    public static boolean isPayChannelEnabled(int i) {
        return isPlatformPayChannel(i) || isThirdPayChannel(i);
    }
}
