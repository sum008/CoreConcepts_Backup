package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetMazePaths {
	
	static int count=0;
    private static void getAllMazePaths(List<List<List<Integer>>> result, List<List<Integer>> stackVal, int cRow, int cCol, int nRow, int nCol) {
        if (cRow==nRow || cCol==nCol) return;
        stackVal.add(Arrays.asList(cRow, cCol));
        getAllMazePaths(result, stackVal, cRow, cCol+1, nRow, nCol);
        getAllMazePaths(result, stackVal, cRow+1, cCol, nRow, nCol);
        
        if (cRow==nRow-1 && cCol==nCol-1) {
            result.add(stackVal);
            stackVal.clear();
            count+=1;
        }
    }
    
    private static void getAllMazePaths(List<String> result, String move, int cRow, int cCol, int nRow, int nCol) {
        if (cRow==nRow || cCol==nCol) return;
        getAllMazePaths(result, move + "F", cRow, cCol+1, nRow, nCol);
        getAllMazePaths(result, move + "D", cRow+1, cCol, nRow, nCol);
        if (cRow==nRow-1 && cCol==nCol-1) {
            result.add(move);
            count+=1;
        }
    }
    
    public static void main(String[] args) {
        List<List<List<Integer>>> result = new ArrayList<>();
        List<String> result1 = new ArrayList<>();
        int nRow=3;
        int nCol=4;
//        getAllMazePaths(result, new ArrayList<>(), 0, 0, nRow, nCol);
         getAllMazePaths(result1, "", 0, 0, nRow, nCol);
        System.out.println(result1); 
        System.out.println(count);
    }

}
