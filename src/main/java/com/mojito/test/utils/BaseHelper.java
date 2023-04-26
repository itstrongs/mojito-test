package com.mojito.test.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liufq
 * @since 2021-07-12 11:01:52
 */
public class BaseHelper {

    public static <T, R> T r2t(R resource, Class<T> target) {
        if (resource != null) {
            try {
                T t = target.newInstance();
                BeanUtils.copyProperties(resource, t);
                return t;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T, R> List<T> r2t(List<R> resourceList, Class<T> target) {
        List<T> tList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(resourceList)) {
            resourceList.forEach(resource -> {
                T t1 = r2t(resource, target);
                tList.add(t1);
            });
        }
        return tList;
    }
}
