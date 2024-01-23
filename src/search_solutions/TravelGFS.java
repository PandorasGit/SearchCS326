package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.*;

import java.util.Comparator;

public class TravelGFS extends BaseSearch<String, String> {
    public TravelGFS(String mapFile, String estimates){
        super(getTravel(mapFile, estimates), getFrontier(getTravel(mapFile, estimates)));
    }

    private static SortedQueue<String, String> getFrontier(Travel travel) {
        return new SortedQueue<String, String>(new Comparator<Node<String, String>>() {
            @Override
            public int compare(Node<String, String> o1, Node<String, String> o2) {

                if (travel.getEstimateDistances(o1.getState()) > travel.getEstimateDistances(o2.getState())) {
                    return 1;
                }
                if (travel.getEstimateDistances(o1.getState()) == travel.getEstimateDistances(o2.getState())) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    private static Travel getTravel(String mapFile, String estimates) {
        return new Travel(mapFile, estimates);
    }


    public static void main(String[] args) {
        TravelGFS t = new TravelGFS("RomaniaMap.txt", "RomaniaMapEstimates.txt");
        t.search();
    }
}

