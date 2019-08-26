package com.android.thememarket;

import android.content.ComponentName;
import android.content.Context;
import android.os.UserHandle;
import android.support.v4.os.UserManagerCompat;
import android.support.v4.util.Preconditions;

import java.util.Arrays;

/**
 * Created by cczheng on 2019/8/26.
 */
public class ComponentKey {


    public final ComponentName componentName;
    public final UserHandle user;

    private final int mHashCode;

    public ComponentKey(ComponentName componentName, UserHandle user) {
        //Preconditions.assertNotNull(componentName);
        //Preconditions.assertNotNull(user);
        this.componentName = componentName;
        this.user = user;
        mHashCode = Arrays.hashCode(new Object[] {componentName, user});
    }

    /**
     * Creates a new component key from an encoded component key string in the form of
     * [flattenedComponentString#userId].  If the userId is not present, then it defaults
     * to the current user.
     */
    public ComponentKey(Context context, String componentKeyStr) {
        int userDelimiterIndex = componentKeyStr.indexOf("#");
        if (userDelimiterIndex != -1) {
            String componentStr = componentKeyStr.substring(0, userDelimiterIndex);
            Long componentUser = Long.valueOf(componentKeyStr.substring(userDelimiterIndex + 1));
            componentName = ComponentName.unflattenFromString(componentStr);
            //user = UserManagerCompat.getInstance(context).getUserForSerialNumber(componentUser.longValue());
        } else {
            // No user provided, default to the current user
            componentName = ComponentName.unflattenFromString(componentKeyStr);
        }
        user = android.os.Process.myUserHandle();
        //Preconditions.assertNotNull(componentName);
        //Preconditions.assertNotNull(user);
        mHashCode = Arrays.hashCode(new Object[] {componentName, user});
    }


    @Override
    public int hashCode() {
        return mHashCode;
    }

    @Override
    public boolean equals(Object o) {
        ComponentKey other = (ComponentKey) o;
        return other.componentName.equals(componentName) && other.user.equals(user);
    }

    /**
     * Encodes a component key as a string of the form [flattenedComponentString#userId].
     */
    @Override
    public String toString() {
        return componentName.flattenToString() + "#" + user;
    }
}
