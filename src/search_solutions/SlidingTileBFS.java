package search_solutions;

import core_search.BaseSearch;
import core_search.FIFOQueue;
import search_problems.Travel;

public class SlidingTileBFS extends BaseSearch<Integer, Integer> {
    public SlidingTileBFS(List data) {
        super(new Sliding(data), new FIFOQueue<>());
    }
}
