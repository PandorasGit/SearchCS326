package search_problems;

import core_search.Problem;
import core_search.Tuple;

import java.io.File;
import java.util.*;

public class TilePuzzle implements Problem<String,String> {

    private final PuzzleState INITIAL_3x3_STATE = new PuzzleState(List.of(7,2,4,5,0,6,8,3,1));
    private final PuzzleState GOAL_3x3_STATE = new PuzzleState(List.of(0,1,2,3,4,5,6,7,8));
    private final PuzzleState INITIAL_4x4_STATE = new PuzzleState(List.of(12,1,2,15,11,6,5,8,7,10,9,4,0,13,14,3));
    private final PuzzleState GOAL_4x4_STATE = new PuzzleState(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0));
    private final String MAP_FILE;
    private final String ESTIMATE_FILE;

    public TilePuzzle(String mapFile) {
        this.MAP_FILE = mapFile;
        this.ESTIMATE_FILE = null;
        buildTransitionModel();
    }

    public TilePuzzle(String mapFile, String estimateFile) {
        this.MAP_FILE = mapFile;
        this.ESTIMATE_FILE = estimateFile;
        buildTransitionModel();
        buildEstimatedDistances();
    }
    private final Map<String, List<Tuple<PuzzleState, String>>> transitionModel = new HashMap<>();
    private final Map<String, Integer> estimatedDistances = new HashMap<>();

    public PuzzleState initial3x3State(){
        return INITIAL_3x3_STATE;
    }
    public PuzzleState goal3x3State(){
        return GOAL_3x3_STATE;
    }
    public PuzzleState initial4x4State(){
        return INITIAL_4x4_STATE;
    }
    public PuzzleState goal4x4State(){
        return GOAL_4x4_STATE;
    }

    public List<Tuple<PuzzleState,String>> execution (PuzzleState state){
        return transitionModel.get(state);
    }

    private void buildTransitionModel(state){
        try{
            PuzzleState stateRight = move_right(state);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void move_right() {
    }

    private void buildEstimatedDistances(){
        try(Scanner sc = new Scanner(new File(ESTIMATE_FILE))){
            while(sc.hasNext()) {
                String[] a = sc.nextLine().split(":");
                String city = a[0];
                int estimate = Integer.parseInt(a[1]);
                    estimatedDistances.put(city, estimate);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //for testing only
    public static void main(String[] args){
        TilePuzzle t = new TilePuzzle("RomaniaMap.txt","RomaniaMapEstimates.txt");
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String,List<Tuple<String,String>>> entry : t.transitionModel.entrySet()){
            builder.append(builder.length() > 0 ? "\n" : "")
                    .append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue());
        }
        System.out.println(builder);
        StringBuilder builder2 = new StringBuilder();
        for(Map.Entry<String, Integer> entry : t.estimatedDistances.entrySet()){
            builder2.append(builder.length() > 0 ? "\n" : "")
                    .append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue());
        }
        System.out.println(builder2);
    }
    public int getEstimateDistances(String s) {
        return estimatedDistances.get(s);
    }

}
