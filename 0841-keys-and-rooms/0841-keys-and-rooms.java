class Solution {
    void DFS(List<List<Integer>> rooms,int i,boolean[]visited){
        visited[i]=true;
        for(int j=0;j<rooms.get(i).size();j++){
           if(!visited[rooms.get(i).get(j)]) DFS(rooms,rooms.get(i).get(j),visited);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[]=new boolean[rooms.size()];
        DFS(rooms,0,visited); 
        for(boolean i:visited){
            if(!i)return false;
        }
        return true;
    }
}