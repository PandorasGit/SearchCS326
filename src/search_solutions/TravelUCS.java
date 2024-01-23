package search_solutions;

import core_search.*;
import search_problems.*;

import java.util.Comparator;

public class TravelUCS extends BaseSearch<String, String> {
    public TravelUCS(String mapFile) {
        super(new Travel(mapFile), new SortedQueue<String, String>(new Comparator<Node<String, String>>() {
            @Override
            public int compare(Node<String, String> o1, Node<String, String> o2) {
                if (o1.getPathCost() > o2.getPathCost()) {
                    return 1;
                }
                if (o1.getPathCost() == o2.getPathCost()){
                    return 0;
                }
                else {
                    return -1;
                }
            }
        }));
    }


    public static void main(String[] args) {
        search_solutions.TravelUCS t = new search_solutions.TravelUCS("RomaniaMap.txt");
        t.search();
    }
}