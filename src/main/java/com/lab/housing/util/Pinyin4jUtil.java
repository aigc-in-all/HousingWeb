package com.lab.housing.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public final class Pinyin4jUtil {
    private static final HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();

    private Pinyin4jUtil() {
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    }

    public static String toPinyinAtFirstWord(String chinese) {
        try {
            char c = chinese.charAt(0);
            return PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat)[0];
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
            return "";
        }
    }

}
