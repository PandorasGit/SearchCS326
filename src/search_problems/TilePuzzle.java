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
    private final Map<String, List<Tuple<String, String>>> transitionModel = new HashMap<>();
    private final Map<String, Integer> estimatedDistances = new HashMap<>();

    public String initialState(){
        return INITIAL_STATE;
    }
    public String goalState(){
        return GOAL_STATE;
    }
    private void buildTransitionModel(){
        try(Scanner sc = new Scanner(new File(MAP_FILE))){
            while(sc.hasNext()) {
                String[] a = sc.nextLine().split(":");
                String cityA = a[0];
                String cityB = a[1];
                int cost = Integer.parseInt(a[2]);
                if (transitionModel.containsKey(cityA)) {
                    List<Tuple<String, String>> l = transitionModel.get(cityA);
                    l.add(new Tuple<>(cityB, "to" + cityB, cost));
                    transitionModel.replace(cityA, l);
                } else {
                    List<Tuple<String, String>> l = new ArrayList<>();
                    l.add(new Tuple<>(cityB, "to" + cityB, cost));
                    transitionModel.put(cityA, l);
                }
                if (transitionModel.containsKey(cityB)) {
                    List<Tuple<String, String>> l = transitionModel.get(cityB);
                    l.add(new Tuple<>(cityA, "to" + cityA, cost));
                    transitionModel.replace(cityB, l);
                } else {
                    List<Tuple<String, String>> l = new ArrayList<>();
                    l.add(new Tuple<>(cityA, "to" + cityA, cost));
                    transitionModel.put(cityB, l);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
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

    public List<Tuple<String,String>> execution (String city){
        return transitionModel.get(city);
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
