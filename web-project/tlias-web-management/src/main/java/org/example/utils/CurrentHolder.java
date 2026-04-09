package org.example.utils;

public class CurrentHolder {
    // ThreadLocal 存储当前登录用户ID
    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();

    /**
     * 设置当前用户ID
     * @param employeeId 员工ID
     */
    public static void setCurrentId(Integer employeeId) {
        CURRENT_LOCAL.set(employeeId);
    }

    /**
     * 获取当前用户ID
     * @return 当前登录员工ID
     */
    public static Integer getCurrentId() {
        return CURRENT_LOCAL.get();
    }

    /**
     * 移除当前用户ID，防止内存泄漏
     */
    public static void remove() {
        CURRENT_LOCAL.remove();
    }
}