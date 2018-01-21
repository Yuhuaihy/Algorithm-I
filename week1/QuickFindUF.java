import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class QuickFindUF{
    int[] id;
    QuickFindUF(int n){
        id = new int[n];
        for (int i = 0;i<n;i++){
            id[i] = i;  
        }        
    }
    void union(int p, int q){
        //change id[p] to id[q]
        int m = id[q];
        int n = id[p];
        for(int i = 0; i < id.length;i++){
            if(id[i] == n)
                id[i] = m;
        }   
    }
    boolean connected(int p, int q)
    {
        if (id[p]==id[q]){
            return true;
        }
        else
            return false;
    }
    public static void main(String[] args){
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(! uf.connected(p,q)){
                StdOut.println(p+"  "+q);
                uf.union(p,q);
            }
        }
    }
}