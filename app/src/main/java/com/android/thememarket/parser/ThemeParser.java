package com.android.thememarket.parser;

import com.android.thememarket.entity.ThemeEntity;

/**
 * Created by cczheng on 2019/8/26.
 */
public interface ThemeParser<T extends ThemeEntity> {
    String TAG = ThemeParser.class.getSimpleName();

    /**
     *  parse the theme archieve or apk or something else in future
     * @param path
     * @return the Theme wrap entity
     */
    T parse(String path);
}
