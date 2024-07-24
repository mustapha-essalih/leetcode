import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    
    public static void main(String[] args) 
    {
        char[][] board = 
        {{'5','3','.','.','7','.','.','.','7'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'},};

 
        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(char[][] board) 
    {
        Map<Integer,List<Character>> mapOfColumns = new HashMap<>();
        List<Character> rows = new ArrayList<>();
 
        int x = 0; int z = 3; int v = 0; int s = 3;
        
        for (int w = 0; w < 9; w++) 
        {
            List<Character> list = new ArrayList<>();
            int t = 0;
            for (int i = v; i < s; i++) 
            {
                List<Character> columns = new ArrayList<>();
                for (int j = x ; j < z; j++) 
                {
                    if (board[i][j] != '.') 
                    {
                        if (mapOfColumns.getOrDefault(i, null) == null)// if array of index i is empty
                        {
                            columns.add(board[i][j]);
                            list.add(board[i][j]);
                            mapOfColumns.put(i, columns);
                        }
                        else if (!mapOfColumns.get(i).contains(board[i][j])) 
                        {
                            list.add(board[i][j]);
                            mapOfColumns.get(i).add(board[i][j]);
                        }
                        else return false;
                    }
                    if (board[t][w] != '.') 
                    {
                        if (!rows.contains(board[t][w])) rows.add(board[t][w]);
                        else return false;
                    }
                    t++;
                }
            }
            rows.clear();
            Set<Character> set = new HashSet<>(list);
            if (set.size() != list.size()) return false;// check duplacate in sub-boxes
            list.clear();
            x += 3; z += 3;
            if(z == 12) {x = 0;z = 3;v += 3;s += 3;}
        }
        return true;
    }
}


// here i work on each sub-boxes and is same time check the columns if are duplicate or not
// also in sime time check the rows if are duplicate or not