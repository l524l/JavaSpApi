package com.sp.api.entity;

/**
 * @Author Pershin Andrew
 */
public class Time {
    private TimeOfDay time;
    private int ticks;
    private String formated;

    public Time() {
    }

    public Time(TimeOfDay time, int ticks, String formated) {
        this.time = time;
        this.ticks = ticks;
        this.formated = formated;
    }

    public TimeOfDay getTime() {
        return time;
    }

    public void setTime(TimeOfDay time) {
        this.time = time;
    }

    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    public String getFormated() {
        return formated;
    }

    public void setFormated(String formated) {
        this.formated = formated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        if (ticks != time.ticks) return false;
        if (this.time != time.time) return false;
        return formated.equals(time.formated);
    }

    @Override
    public int hashCode() {
        int result = time.hashCode();
        result = 31 * result + ticks;
        result = 31 * result + formated.hashCode();
        return result;
    }
}
