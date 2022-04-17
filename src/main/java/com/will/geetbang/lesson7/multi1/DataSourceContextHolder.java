package com.will.geetbang.lesson7.multi1;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/4/18 12:02 AM
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<Type> HOLDER = ThreadLocal.withInitial(() -> Type.MASTER);

    public static void setLookupKey(Type lookUpKey) {
        HOLDER.set(lookUpKey);
    }

    public static Type getLookupKey() {
        return HOLDER.get();
    }

    public static void clear() {
        HOLDER.remove();
    }
}
