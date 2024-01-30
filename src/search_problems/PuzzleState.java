//package search_problems;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//import static java.lang.Math.abs;
//
//public class PuzzleState {
//
//    public ArrayList<ArrayList<Integer>> state = new ArrayList<>();
//    public ArrayList<Integer> row1;
//    public ArrayList<Integer> row2;
//    public ArrayList<Integer> row3;
//    public ArrayList<Integer> row4;
//
//    public PuzzleState(List<Integer> integers) {
//        if (integers.size() == 9){
//            create3x3(integers);
//        } else if (integers.size() == 16){
//            create4x4(integers);
//        }
//    }
//
//    public int distanceTo3x3Goal(){
//        int totalDistance = 0;
//        for (ArrayList<Integer> row: state){
//            for (int tile: row){
//                totalDistance += abs(tile%3 - row.indexOf(tile));
//                totalDistance += abs(tile/3 - state.indexOf(row));
//            }
//        }
//        return totalDistance;
//    }
//
//    public int distanceTo4x4Goal(){
//        int totalDistance = 0;
//        for (ArrayList<Integer> row: state){
//            for (int tile: row){
//                totalDistance += abs(tile%4 - row.indexOf(tile));
//                totalDistance += abs(tile/4 - state.indexOf(row));
//            }
//        }
//        return totalDistance;
//    }
//
//    public int get3x3Tile(int index) {
//        return state.get(index/3).get(index%3);
//    }
//
//    public int get4x4Tile(int index) {
//        return state.get(index/4).get(index%4);
//    }
//
//    private void create3x3(List<Integer> integers) {
//        row1.addAll(List.of(integers.get(0), integers.get(1),integers.get(2)));
//        row2.addAll(List.of(integers.get(3), integers.get(4),integers.get(5)));
//        row3.addAll(List.of(integers.get(6), integers.get(7),integers.get(8)));
//        state.addAll(Set.of(row1, row2, row3));
//    }
//
//    private void create4x4(List<Integer> integers) {
//        row1.addAll(List.of(integers.get(0), integers.get(1),integers.get(2), integers.get(3)));
//        row2.addAll(List.of(integers.get(4), integers.get(5),integers.get(6), integers.get(7)));
//        row3.addAll(List.of(integers.get(8), integers.get(9),integers.get(10), integers.get(11)));
//        row4.addAll(List.of(integers.get(12), integers.get(13),integers.get(14), integers.get(15)));
//        state.addAll(Set.of(row1, row2, row3, row4));
//    }
//
//}
