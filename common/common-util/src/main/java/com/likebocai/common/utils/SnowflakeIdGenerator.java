package com.likebocai.common.utils;

public class SnowflakeIdGenerator {

    // ============================== 常量定义 ==============================
    private static final long START_TIMESTAMP = 1735142400000L; // 自定义起始时间戳 (2024-12-26 00:00:00)
    private static final long DATA_CENTER_ID_BITS = 5;          // 数据中心 ID 位数
    private static final long MACHINE_ID_BITS = 5;             // 机器 ID 位数
    private static final long SEQUENCE_BITS = 12;              // 序列号位数

    private static final long MAX_DATA_CENTER_ID = ~(-1L << DATA_CENTER_ID_BITS); // 最大数据中心 ID
    private static final long MAX_MACHINE_ID = ~(-1L << MACHINE_ID_BITS);         // 最大机器 ID
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);            // 最大序列号

    private static final long MACHINE_ID_SHIFT = SEQUENCE_BITS;                     // 机器 ID 左移位数
    private static final long DATA_CENTER_ID_SHIFT = SEQUENCE_BITS + MACHINE_ID_BITS; // 数据中心 ID 左移位数
    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + MACHINE_ID_BITS + DATA_CENTER_ID_BITS; // 时间戳左移位数

    // ============================== 成员变量 ==============================
    private final long dataCenterId; // 数据中心 ID
    private final long machineId;    // 机器 ID
    private long sequence = 0L;      // 当前序列号
    private long lastTimestamp = -1L;// 上一次生成 ID 的时间戳

    // ============================== 构造函数 ==============================
    public SnowflakeIdGenerator(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATA_CENTER_ID || dataCenterId < 0) {
            throw new IllegalArgumentException("DataCenterId must be in range [0, " + MAX_DATA_CENTER_ID + "]");
        }
        if (machineId > MAX_MACHINE_ID || machineId < 0) {
            throw new IllegalArgumentException("MachineId must be in range [0, " + MAX_MACHINE_ID + "]");
        }
        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }

    // ============================== 主方法 ==============================
    public synchronized long nextId() {
        long currentTimestamp = getCurrentTimestamp();

        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate ID.");
        }

        if (currentTimestamp == lastTimestamp) {
            // 相同毫秒内，递增序列号
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0) {
                // 序列号溢出，等待下一毫秒
                currentTimestamp = waitUntilNextMillis(lastTimestamp);
            }
        } else {
            // 不同毫秒，序列号置为 0
            sequence = 0L;
        }

        lastTimestamp = currentTimestamp;

        // 生成唯一 ID
        return ((currentTimestamp - START_TIMESTAMP) << TIMESTAMP_SHIFT) // 时间戳部分
                | (dataCenterId << DATA_CENTER_ID_SHIFT)                 // 数据中心部分
                | (machineId << MACHINE_ID_SHIFT)                        // 机器 ID 部分
                | sequence;                                              // 序列号部分
    }

    // ============================== 辅助方法 ==============================
    private long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    private long waitUntilNextMillis(long lastTimestamp) {
        long timestamp = getCurrentTimestamp();
        while (timestamp <= lastTimestamp) {
            timestamp = getCurrentTimestamp();
        }
        return timestamp;
    }

    // ============================== 测试方法 ==============================
    public static void main(String[] args) {
        SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(1, 1); // 数据中心 1，机器 1
        for (int i = 0; i < 10; i++) {
            System.out.println(idGenerator.nextId());
        }
    }
}
