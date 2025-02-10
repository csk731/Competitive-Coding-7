// 359. Logger Rate Limiter Design a logger system that receive stream of messages along with its timestamps,each message should be printed if and only if it is not printed in the last 10 seconds.
// Given a message and a timestamp(in seconds granularity),return true if the message should be printed in the given timestamp,otherwise returns false.
// It is possible that several messages arrive roughly at the same time

// Example:
// Logger logger = new Logger();
// logger.shouldPrintMessage(1,"foo"); returns true;
// logger.shouldPrintMessage(2,"bar"); returns true;
// logger.shouldPrintMessage(3,"foo"); returns false;
// logger.shouldPrintMessage(8,"bar"); returns false;
// logger.shouldPrintMessage(10,"foo"); returns false;
// logger.shouldPrintMessage(11,"foo"); returns true;

// Time Complexity: O(1)
// Space Complexity: O(n) where n is the number of unique messages

import java.util.HashMap;

public class LC359 {
    private static HashMap<String, Integer> msgToLastOccuredTime;

    private boolean shouldPrintMessage(int timestamp, String message) {
        Integer lastTimeOccured = msgToLastOccuredTime.get(message);
        if (lastTimeOccured!=null && timestamp - lastTimeOccured < 10) return false;
        msgToLastOccuredTime.put(message, timestamp);
        return true;
    }

    public static void main(String[] args) {
        msgToLastOccuredTime = new HashMap<>();
        LC359 obj = new LC359();

        // Example 1
        int[] timestamps = { 1, 2, 3, 8, 10, 11 };
        String[] messages = { "foo", "bar", "foo", "bar", "foo", "foo" };

        for (int i = 0; i < timestamps.length; i++) {
            System.out.println(obj.shouldPrintMessage(timestamps[i], messages[i]));
        }
    }
}
