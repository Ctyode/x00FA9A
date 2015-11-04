package org.flamierawieo.x00FA9A.shared;

public interface Tickable {

    /**
     * Called for every new update cycle
     * @param delta difference between last tick time and current tick time (in seconds)
     */
    void tick(double delta);

}
