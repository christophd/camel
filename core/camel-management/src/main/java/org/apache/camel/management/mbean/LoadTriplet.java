/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.management.mbean;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Holds the loads (inflight messages, not cpu) averaged over 1min, 5min, and 15min.
 */
public final class LoadTriplet {

    // Exponents for EWMA: exp(-INTERVAL / WINDOW) (in seconds)
    private static final double EXP_1 = Math.exp(-1 / (60.0));
    private static final double EXP_5 = Math.exp(-1 / (60.0 * 5.0));
    private static final double EXP_15 = Math.exp(-1 / (60.0 * 15.0));

    private static final Lock LOCK = new ReentrantLock();
    private double load01 = Double.NaN;
    private double load05 = Double.NaN;
    private double load15 = Double.NaN;

    /**
     * Update the load statistics
     *
     * @param currentReading the current reading
     */
    public void update(int currentReading) {
        LOCK.lock();
        try {
            load01 = updateLoad(currentReading, EXP_1, load01);
            load05 = updateLoad(currentReading, EXP_5, load05);
            load15 = updateLoad(currentReading, EXP_15, load15);
        } finally {
            LOCK.unlock();
        }
    }

    private double updateLoad(int reading, double exp, double recentLoad) {
        return Double.isNaN(recentLoad) ? reading : reading + exp * (recentLoad - reading);
    }

    public double getLoad1() {
        LOCK.lock();
        try {
            return load01;
        } finally {
            LOCK.unlock();
        }
    }

    public double getLoad5() {
        LOCK.lock();
        try {
            return load05;
        } finally {
            LOCK.unlock();
        }
    }

    public double getLoad15() {
        LOCK.lock();
        try {
            return load15;
        } finally {
            LOCK.unlock();
        }
    }

    public void reset() {
        LOCK.lock();
        try {
            load01 = Double.NaN;
            load05 = Double.NaN;
            load15 = Double.NaN;
        } finally {
            LOCK.unlock();
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f, %.2f, %.2f", getLoad1(), getLoad5(), getLoad15());
    }

}
