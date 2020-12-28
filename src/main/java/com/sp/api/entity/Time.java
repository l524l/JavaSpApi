package com.sp.api.entity;

/**
 * Author Pershin Andrew
 */
public class Time {
    private TimeOfDay time;
    private int ticks;

    public Time(TimeOfDay time, int ticks) {
        this.time = time;
        this.ticks = ticks;
    }

    public TimeOfDay getTime() {
        return time;
    }

    public int getTicks() {
        return ticks;
    }

    public String getFormated() {
        int s = (int) Math.floor(ticks / 1000);
        return String.format("%02d", s) + ":" + String.format("%02d", Math.round((ticks % 1000)*0.06));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        if (ticks != time.ticks) return false;
        return this.time == time.time;
    }

    @Override
    public int hashCode() {
        int result = time.hashCode();
        result = 31 * result + ticks;
        result = 31 * result;
        return result;
    }
}
