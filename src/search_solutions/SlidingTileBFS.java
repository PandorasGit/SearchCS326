package search_solutions;

import core_search.BaseSearch;
import core_search.FIFOQueue;
import search_problems.SlidingTile;

import java.util.ArrayList;

public class SlidingTileBFS extends BaseSearch<ArrayList<Integer>, ArrayList<Integer>> {
    public SlidingTileBFS(ArrayList<Integer> data) {
        super((new SlidingTile(data)), new FIFOQueue<>());
    }
}
