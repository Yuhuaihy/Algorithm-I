// union(p,q) set p's root points to q'root
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class QuickUnionUF{
    int[] id;
    QuickUnionUF(int n){
        id = new int[n];
        for(int i = 0; i< n ; i++){
            id[i] = i;
        } 
    }
    int findRoot(int p){
        while(id[p] != p){
            p = id[p];    
        }
        return p;
    }
    void union(int p, int q){
        int m = findRoot(p);
        int n = findRoot(q);
        id[m] = n;
    }
    boolean connected(int p, int q){
        return findRoot(p) == findRoot(q);    
    }
    public static void main(String[] args){
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(!uf.connected(p,q)){
                StdOut.println(p+"xx    "+q);
                uf.union(p,q);
            }
            
        }
    }
}