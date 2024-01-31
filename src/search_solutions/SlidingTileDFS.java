package search_solutions;

import core_search.BaseSearch;
import core_search.FIFOQueue;
import core_search.LIFOQueue;
import search_problems.SlidingTile;

import java.util.ArrayList;

public class SlidingTileDFS extends BaseSearch<ArrayList<Integer>, String> {
    public SlidingTileDFS(ArrayList<Integer> data) {
        super((new SlidingTile(data)), new LIFOQueue<>());
    }
}
