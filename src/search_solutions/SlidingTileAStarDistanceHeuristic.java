package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.SlidingTile;

import java.util.ArrayList;
import java.util.Comparator;

public class SlidingTileAStarDistanceHeuristic extends BaseSearch<ArrayList<Integer>, String> {
    public SlidingTileAStarDistanceHeuristic(ArrayList<Integer> state){
        super(getProblem(state), getFrontier(getProblem(state)));
    }

    private static SortedQueue<ArrayList<Integer>, String> getFrontier(SlidingTile problem) {
        return new SortedQueue<ArrayList<Integer>, String>(new Comparator<Node<ArrayList<Integer>, String>>() {
            @Override
            public int compare(Node<ArrayList<Integer>, String> o1, Node<ArrayList<Integer>, String> o2) {

                if ((problem.distanceToGoal(o1.getState()) + o1.getPathCost()) > (problem.distanceToGoal(o2.getState()) + o2.getPathCost())) {
                    return 1;
                }
                if ((problem.distanceToGoal(o1.getState()) + o1.getPathCost()) == (problem.distanceToGoal(o2.getState()) + o2.getPathCost())) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    private static SlidingTile getProblem(ArrayList<Integer> data) {
        return new SlidingTile(data);
    }

}

