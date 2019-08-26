package com.android.thememarket.filter;

import com.android.thememarket.ComponentKey;

/**
 * Created by cczheng on 2019/8/26.
 */
public interface IconFilter {
    String TAG = IconFilter.class.getSimpleName();

    /**
     find the proper icon key by componentKey and
     * return the icon key we cached
     * @param componentKey
     * @return the fileName or key from theme archive
     */
    String filter(ComponentKey componentKey);
}
