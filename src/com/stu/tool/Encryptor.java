package com.stu.tool;

public class Encryptor {
    
    private static final String v = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    
    public Encryptor() {
    }

    public static String encrypt(String s) {
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        int j = s.length();
        int k = ((j + 2) / 3) * 4;
        int l = k + 2 * (k / 60 + 1);
        k = 0;
        while (j > 0) {
            char c = s.charAt(i++);
            char c3 = v.charAt(c >> 2);
            char c1;
            if (--j > 0) {
                c1 = s.charAt(i++);
            } else {
                c1 = '\0';
            }
            char c4 = v.charAt((c << 4) + (c1 >> 4) & 0x3f);
            char c2;
            char c5;
            if (j > 0) {
                if (--j > 0) {
                    c2 = s.charAt(i++);
                } else {
                    c2 = '\0';
                }
                c5 = v.charAt((c1 << 2) + (c2 >> 6) & 0x3f);
            } else {
                c2 = '\0';
                c5 = '=';
            }
            char c6;
            if (j > 0) {
                c6 = v.charAt(c2 & 0x3f);
            } else {
                c6 = '=';
            }
            stringbuffer.append(c3).append(c4).append(c5).append(c6);
            if (j > 0) {
                j--;
            }
            if (++k == 15) {
                k = 0;
                stringbuffer.append("\r\n");
            }
        }
        stringbuffer.append("\r\n");
        if (stringbuffer.length() != l) {
            return null;
        } else {
            return stringbuffer.toString();
        }
    }
}
