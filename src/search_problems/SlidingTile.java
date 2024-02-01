package search_problems;

import core_search.*;

import java.util.*;

public class SlidingTile implements Problem<ArrayList<Integer>, String> {

    //empty cell is zero
    private final ArrayList<Integer> initial;
    private final ArrayList<Integer> goal_state;

    // Size of the board, 3 = 3x3 board
    private final int SIZE;

    public SlidingTile(ArrayList<Integer> data) {
        this.initial = data;
        if (data.size() == 9){
            this.goal_state = new ArrayList<Integer>(Arrays.asList(0,1,2, 3,4,5, 6,7,8));
        }
        else{ // dependency alert assumed 4x4
            this.goal_state = new ArrayList<Integer>(Arrays.asList(1,2,3,4, 5,6,7,8, 9,10,11,12, 13,14,15,0));
        }
        SIZE = (int) Math.sqrt(data.size());
    }

    public ArrayList<Integer> initialState(){
        return initial;
    }
    public ArrayList<Integer> goalState(){
        return goal_state;
    }


    public List<Tuple<ArrayList<Integer>, String>> execution(ArrayList<Integer> state) {
        List<Tuple<ArrayList<Integer>, String>> result = new ArrayList<Tuple<ArrayList<Integer>, String>>();
        int zero_position = state.indexOf(0);
        int row_number = zero_position/SIZE;
        int column_number = zero_position % SIZE;

        // up
        if (row_number != 0){
            int target_position = zero_position-SIZE;
            int target = state.get(target_position);
            ArrayList<Integer> copy = (ArrayList<Integer>) state.clone();
            copy.set(target_position, 0);
            copy.set(zero_position, target);
            result.add(new Tuple<ArrayList<Integer>, String>(copy, "up", 1));
        }
        //down
        if (row_number != SIZE-1){
            int target_position = zero_position+SIZE;
            int target = state.get(target_position);
            ArrayList<Integer> copy = (ArrayList<Integer>) state.clone();
            copy.set(target_position, 0);
            copy.set(zero_position, target);
            result.add(new Tuple<ArrayList<Integer>, String>(copy, "down", 1));
        }
        // left
        if (column_number != 0){
            int target_position = zero_position-1;
            int target = state.get(target_position);
            ArrayList<Integer> copy = (ArrayList<Integer>) state.clone();
            copy.set(target_position, 0);
            copy.set(zero_position, target);
            result.add(new Tuple<ArrayList<Integer>, String>(copy, "right", 1));
        }
        // right
        if (column_number != SIZE-1){
            int target_position = zero_position+1;
            int target = state.get(target_position);
            ArrayList<Integer> copy = (ArrayList<Integer>) state.clone();
            copy.set(target_position, 0);
            copy.set(zero_position, target);
            result.add(new Tuple<ArrayList<Integer>, String>(copy, "right", 1));
        }
        return result;
    }

    public void printState(ArrayList<Integer> state){
        for (int tile: state){
            if (tile != 0){
                System.out.printf("%3s", tile+"");
            } else {
                System.out.print("   ");
            }
            if (state.indexOf(tile) % SIZE == SIZE -1){
                System.out.println();
            }
        }
    }

    public int misplacedTiles(ArrayList<Integer> state){
        int count = 0;
        for (int tile: state){
            if (tile == 0){
                continue;
            } else {
                if (tile != goal_state.get(state.indexOf(tile))){
                    count++;
                }
            }
        }
        return count;
    }



}
