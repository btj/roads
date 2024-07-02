package roads;

import java.util.HashSet;
import java.util.Set;

// Note: in English, "crossroads" is a singular noun: "one crossroads".
// The name of this class therefore complies with the general guideline
// that the name of a class shall be a singular noun.
/**
 * Each instance of this class represents a crossroads in a graph of roads and crossroads.
 */
public class Crossroads { 
	
	/**
	 * @invar | startingRoads != null
	 * @invar | startingRoads.stream().allMatch(r -> r != null && r.startCrossroads == this)
	 * @invar | endingRoads != null
	 * @invar | endingRoads.stream().allMatch(r -> r != null && r.endCrossroads == this)
	 * 
	 * @representationObject
	 * @peerObjects
	 */
	Set<Road> startingRoads = new HashSet<>();
	/**
	 * @representationObject
	 * @peerObjects
	 */
	Set<Road> endingRoads = new HashSet<>();
	
	/**
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Road> getStartingRoads() { return Set.copyOf(startingRoads); }

	/**
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Road> getEndingRoads() { return Set.copyOf(endingRoads); }

	/**
	 * @post | getStartingRoads().isEmpty()
	 * @post | getEndingRoads().isEmpty()
	 */
	public Crossroads() {}
	
}
