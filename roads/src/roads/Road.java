package roads;

import logicalcollections.LogicalSet;

/**
 * Each instance of this class represents a road in a graph of roads and crossroads.
 * Each road has at most one start crossroads and at most one end crossroads.
 */
public class Road {
	
	/**
	 * @invar | true
	 * @invar | startCrossroads == null || startCrossroads.startingRoads.contains(this)
	 * @invar | endCrossroads == null || endCrossroads.endingRoads.contains(this)
	 * 
	 * @peerObject
	 */
	Crossroads startCrossroads;
	/**
	 * @peerObject
	 */
	Crossroads endCrossroads;
	
	/**
	 * @peerObject
	 */
	public Crossroads getStartCrossroads() { return startCrossroads; }
	
	/**
	 * @peerObject
	 */
	public Crossroads getEndCrossroads() { return endCrossroads; }
	
	/**
	 * @post | getStartCrossroads() == null
	 * @post | getEndCrossroads() == null
	 */
	public Road() {}
	
	/**
	 * @throws IllegalArgumentException | crossroads == null
	 * @throws IllegalStateException | getStartCrossroads() != null
	 * @mutates_properties | getStartCrossroads(), crossroads.getStartingRoads()
	 * @post | getStartCrossroads() == crossroads
	 * @post | crossroads.getStartingRoads().equals(LogicalSet.plus(old(crossroads.getStartingRoads()), this))
	 */
	public void setStartCrossroads(Crossroads crossroads) {
		if (crossroads == null)
			throw new IllegalArgumentException("`crossroads` is null");
		if (startCrossroads != null)
			throw new IllegalStateException("This road already has a start crossroads");
		
		startCrossroads = crossroads;
		crossroads.startingRoads.add(this);
	}
	
	/**
	 * @pre | getStartCrossroads() != null
	 * @mutates_properties | getStartCrossroads(), getStartCrossroads().getStartingRoads()
	 * @post | getStartCrossroads() == null
	 * @post | old(getStartCrossroads()).getStartingRoads().equals(LogicalSet.minus(old(getStartCrossroads().getStartingRoads()), this))
	 */
	public void clearStartCrossroads() {
		startCrossroads.startingRoads.remove(this);
		startCrossroads = null;
	}

	/**
	 * @pre | crossroads != null
	 * @pre | getEndCrossroads() == null
	 * @mutates_properties | getEndCrossroads(), crossroads.getEndingRoads()
	 * @post | getEndCrossroads() == crossroads
	 * @post | crossroads.getEndingRoads().equals(LogicalSet.plus(old(crossroads.getEndingRoads()), this))
	 */
	public void setEndCrossroads(Crossroads crossroads) {
		endCrossroads = crossroads;
		endCrossroads.endingRoads.add(this);
	}

	/**
	 * @pre | getEndCrossroads() != null
	 * @mutates_properties | getEndCrossroads(), getEndCrossroads().getEndingRoads()
	 * @post | getEndCrossroads() == null
	 * @post | old(getEndCrossroads()).getEndingRoads().equals(LogicalSet.minus(old(getEndCrossroads().getEndingRoads()), this))
	 */
	public void clearEndCrossroads() {
		endCrossroads.endingRoads.remove(this);
		endCrossroads = null;
	}

}
