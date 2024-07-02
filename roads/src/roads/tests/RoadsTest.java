package roads.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import roads.Crossroads;
import roads.Road;

class RoadsTest {

	Crossroads naamsepoort = new Crossroads();
	Road kardinaalMercierlaan = new Road();
	Crossroads kantineplein = new Crossroads();

	@Test
	void testRoadConstructor() {
		assertNull(kardinaalMercierlaan.getStartCrossroads());
		assertNull(kardinaalMercierlaan.getEndCrossroads());
	}
	
	@Test
	void testCrossroadsConstructor() {
		assertEquals(Set.of(), kantineplein.getStartingRoads());
		assertEquals(Set.of(), kantineplein.getEndingRoads());
	}
	
	@Test
	void testSetStartCrossroads() {
		kardinaalMercierlaan.setStartCrossroads(naamsepoort);
		assertSame(naamsepoort, kardinaalMercierlaan.getStartCrossroads());
		assertEquals(Set.of(kardinaalMercierlaan), naamsepoort.getStartingRoads());
	}
	
	@Test
	void testClearStartCrossroads() {
		kardinaalMercierlaan.setStartCrossroads(naamsepoort);
		kardinaalMercierlaan.clearStartCrossroads();
		assertNull(kardinaalMercierlaan.getStartCrossroads());
		assertEquals(Set.of(), naamsepoort.getStartingRoads());
	}
	
	@Test
	void testSetEndCrossroads() {
		kardinaalMercierlaan.setEndCrossroads(kantineplein);
		assertSame(kantineplein, kardinaalMercierlaan.getEndCrossroads());
		assertEquals(Set.of(kardinaalMercierlaan), kantineplein.getEndingRoads());
	}
	
	@Test
	void testClearEndCrossroads() {
		kardinaalMercierlaan.setEndCrossroads(kantineplein);
		kardinaalMercierlaan.clearEndCrossroads();
		assertNull(kardinaalMercierlaan.getEndCrossroads());
		assertEquals(Set.of(), kantineplein.getEndingRoads());
	}

}
