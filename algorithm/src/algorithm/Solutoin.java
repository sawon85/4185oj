class Solution {
	
	Node[] tree;
	
	int sheep = 0;
	int wolf = 0;
	
	public void Check(Node parent) {
		
		if(!parent.isSheep) wolf++;
		else sheep++;
		
		if(wolf==sheep) return;
		
		
		
		
	}
	
	
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        tree = new Node[info.length];
        
        for(int i=0; i<info.length; i++) {
        	tree[i] = new Node(info[i]);
        }
        
        int p,c;
        for(int i=0; i<edges.length; i++) {
        	
        	p = edges[i][0];
        	c = edges[i][1];
        	
        	if(p<c) tree[p].right = tree[c];
        	else tree[p].left = tree[c];
        	
        }
        
        return answer;
    }
    
    
    class Node{
    	boolean isSheep;
    	Node left, right;
    	
    	Node(int n){
    		if(n==1) this.isSheep = false;
    		else this.isSheep = true;
    	}
    }
    
    class Info{
    	int sheep;
    	int wolf;
    	
    	Info(int sheep, int wolf){
    		this.sheep=sheep; this.wolf = wolf;
    	}
    }
}