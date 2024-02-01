package search_solutions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


// informed note, estimate position based on desired position
// do this for all the tiles // move based on what tbhe owest numbers of steps are
// SUM OF DISTANCES IS A MUST
// or number of tiles not in correction
public class SlidingTileAStarTest {

    @Test
    void test_case_one(){
        ArrayList<Integer> dataSet = new ArrayList<Integer>(Arrays.asList(7,2,4,5,0,6,8,3,1));
        SlidingTileAStar tileAStar = new SlidingTileAStar(dataSet);
        assertEquals(true, tileAStar.search());
    }

    @Test
    void test_case_two(){
        ArrayList<Integer> dataSet = new ArrayList<Integer>(Arrays.asList(12,1,2,15,11,6,5,8,7,10,9,4,0,13,14,3));
        SlidingTileAStar tileAStar = new SlidingTileAStar(dataSet);
        assertEquals(true, tileAStar.search());
    }
}
