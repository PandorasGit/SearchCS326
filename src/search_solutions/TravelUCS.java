package search_solutions;

import core_search.*;
import search_problems.*;

public class TravelUCS extends BaseSearch<String, String> {
    public TravelUCS(String mapFile) {
        super(new Travel(mapFile), new SortedQueue<String, String>();
    }


    public static void main(String[] args) {
        search_solutions.TravelUCS t = new search_solutions.TravelUCS("RomaniaMap.txt");
        t.search();
    }
}