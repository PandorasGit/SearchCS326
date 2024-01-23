package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.*;

import java.util.Comparator;

public class TravelAStar extends BaseSearch<String, String> {
    public TravelAStar(String mapFile, String estimates){
        super(getTravel(mapFile, estimates), getFrontier(getTravel(mapFile, estimates)));
    }

    private static SortedQueue<String, String> getFrontier(Travel travel) {
        return new SortedQueue<String, String>(new Comparator<Node<String, String>>() {
            @Override
            public int compare(Node<String, String> o1, Node<String, String> o2) {

                if (getSumOfNode(travel, o1) > getSumOfNode(travel, o2)) {
                    return 1;
                }
                if (getSumOfNode(travel, o1) == getSumOfNode(travel, o2)) {
                    return 0;
                } else {
                    return -1;
                }
            }

            private static int getSumOfNode(Travel travel, Node<String, String> node) {
                return travel.getEstimateDistances(node.getState()) + node.getPathCost();
            }
        });
    }

    private static Travel getTravel(String mapFile, String estimates) {
        return new Travel(mapFile, estimates);
    }


    public static void main(String[] args) {
        TravelAStar t = new TravelAStar("RomaniaMap.txt", "RomaniaMapEstimates.txt");
        t.search();
    }
}

