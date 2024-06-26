package com.artsem.leetcode.easy;

public class CountTestedDevicesAfterTestOperations {

    public int countTestedDevicesOneLoop(int[] batteryPercentages) {
        int count = 0;
        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage - count > 0) {
                count++;
            }
        }
        return count;
    }

    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int count = 0;
        for(int i = 0; i<n; i++){
            if(batteryPercentages[i]>0){
                count++;
                for(int j = i+1; j<n; j++){
                    batteryPercentages[j] = Math.max(0,batteryPercentages[j]-1);
                }
            }
        }
        return count;
    }
}
