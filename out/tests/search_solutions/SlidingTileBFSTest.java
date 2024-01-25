package search_solutions;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

// informed note, estimate position based on desired position
// do this for all the tiles // move based on what tbhe owest numbers of steps are
// SUM OF DISTANCES IS A MUST
// or number of tiles not in correction
public class SlidingTileBFSTest {

    @Test
    void test_case_one(){
        
        LinkedList<Integer> top_row = new LinkedList<Integer>();
        top_row.addLast(7);
        top_row.addLast(2);
        top_row.addLast(4);
        LinkedList<Integer> mid_row = new LinkedList<Integer>();
        mid_row.addLast(5);
        mid_row.addLast(0);
        mid_row.addLast(6);
        LinkedList<Integer> bottom_row = new LinkedList<Integer>();
        bottom_row.addLast(8);
        bottom_row.addLast(3);
        bottom_row.addLast(1);
        LinkedList<LinkedList> dataSet = new LinkedList<>();
        dataSet.addLast(top_row);
        dataSet.addLast(mid_row);
        dataSet.addLast(bottom_row);


        SlidingTileBFS sildingTileBFS = new SlidingTileBFS(dataSet);
        assert.equals(empty 1 2 3 4 5 6 7 8,slidingTile.search());
    }
}
