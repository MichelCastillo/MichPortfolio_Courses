package Tema5_Concurrency_Challenges_Solutions;

public class Clase02_Challenge {

    // Add all necessary member variables
    private volatile long minValue;
    private volatile long maxValue;

    /**
     * Initializes all member variables
     */
    public Clase02_Challenge() {
        // Add code here
        this.minValue = Long.MIN_VALUE;
        this.maxValue = Long.MAX_VALUE;
    }

    /**
     * Adds a new sample to our metrics.
     */
    public void addSample(long newSample) {
        // Add code here
        this.minValue = Math.min(newSample, this.minValue);
        this.maxValue = Math.max(newSample, this.maxValue);
    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        return this.minValue;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        return this.maxValue;
    }
}
