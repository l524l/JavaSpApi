package com.sp.api.entity;

/**
 * @Author Pershin Andrew
 */
public class Time {
    private TimeOfDay timeOfDay;
    private int ticks;
    private String formated;

    public Time() {
    }

    public Time(TimeOfDay timeOfDay, int ticks, String formated) {
        this.timeOfDay = timeOfDay;
        this.ticks = ticks;
        this.formated = formated;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(TimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
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
        if (timeOfDay != time.timeOfDay) return false;
        return formated.equals(time.formated);
    }

    @Override
    public int hashCode() {
        int result = timeOfDay.hashCode();
        result = 31 * result + ticks;
        result = 31 * result + formated.hashCode();
        return result;
    }
}
