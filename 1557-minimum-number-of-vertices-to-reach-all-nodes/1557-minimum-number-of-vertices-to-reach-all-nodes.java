class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] incoming=new int[n];
        int[] outgoing=new int[n];
        for(List<Integer> edge:edges){
            int u=edge.get(0);
            int v=edge.get(1);
            outgoing[u]=1;
            incoming[v]=1;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(incoming[i]!=1){
                ans.add(i);
            }
        }
        return ans;
    }
}