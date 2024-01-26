package search_problems;

import core_search.Problem;
import core_search.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingTile implements Problem<ArrayList<Integer>, ArrayList<Integer>> {


    private final ArrayList<Integer> initial;
    private final ArrayList<Integer> goal_state;

    public SlidingTile(ArrayList<Integer> data) {
        this.initial = data;
        if (data.size() == 9){
            this.goal_state = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8));
        }
        else{
            this.goal_state = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0));
        }
    }

    public ArrayList<Integer> initialState(){
        return initial;
    }
    public ArrayList<Integer> goalState(){
        return goal_state;
    }

    public List<Tuple<ArrayList<Integer>, ArrayList<Integer>>> execution(ArrayList<Integer> state) {
        return null;
    }
}
