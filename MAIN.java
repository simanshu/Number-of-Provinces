/*Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

Example 1:

Input:
[
 [1, 0, 1],
 [0, 1, 0],
 [1, 0, 1]
]

Output:
2
Explanation:
The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.
Example 2:
Input:
[
 [1, 1],
 [1, 1]
]

Output :
1*/



//{ Driver Code Starts
import java.io.*;
import java.util.*;

class MAIN {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends



class Solution {
    
   
    void dfs(ArrayList<ArrayList<Integer>> M, int[] visited, int i)
    {
        
        for (int j = 0; j < M.size(); j++)
        {
           
            if (i!=j && M.get(i).get(j) == 1 && visited[j] == 0)
            {
                
                visited[j] = 1;
               
                dfs(M, visited, j);
            }
        }
    }
    
    
    int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
       
        int[] visited = new int[adj.size()];
       
        int count = 0;
        
        
        for (int i = 0; i < adj.size(); i++)
        {
           
            if (visited[i] == 0)
            {
                dfs(adj, visited, i);
                count++;
            }
        }
        
        
        return count;
    }
};