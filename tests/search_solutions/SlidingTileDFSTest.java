package search_solutions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


// informed note, estimate position based on desired position
// do this for all the tiles // move based on what tbhe owest numbers of steps are
// SUM OF DISTANCES IS A MUST
// or number of tiles not in correction
public class SlidingTileDFSTest {

    @Test
    void test_case_one(){
        ArrayList<Integer> dataSet = new ArrayList<Integer>(Arrays.asList(7,2,4,5,0,6,8,3,1));
        ArrayList<Integer> solved = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8));
        SlidingTileDFS slidingTileDFS = new SlidingTileDFS(dataSet);
        assertEquals(true, slidingTileDFS.search());
    }
}
