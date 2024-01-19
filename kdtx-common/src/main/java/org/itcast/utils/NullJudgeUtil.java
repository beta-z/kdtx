package org.itcast.utils;


import org.itcast.exception.ParamIllegalException;

import java.lang.reflect.Field;

/**
 * 非空判断工具类
 */
public class NullJudgeUtil {
    public static Boolean judge(Object o,String... names){
        Class<?> clazz = o.getClass();
        if (names.length == 0){
            for (Field f : clazz.getDeclaredFields()) {
                try {
                    f.setAccessible(true);
                    if (f.get(o)==null)
                        return true;
                } catch (Exception e) {
                    throw new ParamIllegalException("参数不合法");
                }
            }
            return false;
        }
        for (String name : names) {
            try {
                Field f = clazz.getDeclaredField(name);
                f.setAccessible(true);
                if (f.get(o)==null)
                    return true;
            } catch (Exception e) {
                throw new ParamIllegalException("参数不合法");
            }
        }
        return false;
    }
}
