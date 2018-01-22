import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class WeightedQuickUnionUF{
    int[] id;
    // no need to return int[]
//      int[] sz;
//     WeightedQuickUnionUF(int n){
//         id = new int[n];
//         sz = new int[n];
//         for(int i = 0; i< n ; i++){
//             id[i] = i;
//             sz[i] = 1;
//         } 
//     }
//     int findRoot(int p){
//         int num = 1;
//         int q = p;
//         while(id[q] != q){
//             q = id[q]; 
//             num +=1;
//         }
//         sz[p] = num;
//         return q;
//     }
//     void union(int p, int q){
//         int m = findRoot(p);
//         int n = findRoot(q);
//         if (sz[p] < sz[q])
//             id[m] = n;
//         else
//             id[n] = m;
     
//     }
    
    WeightedQuickUnionUF(int n){
        id = new int[n];
        for(int i = 0; i< n ; i++){
            id[i] = i;
        } 
    }
    int[] findRoot(int p){    // find lgN
        int[] result;
        result = new int[2];
        int num = 1;
        while(id[p] != p){
            p = id[p]; 
            num +=1;
        }
        result[0] = p;
        result[1] = num;
        return result;
    }
    void union(int p, int q){    // union  lgN+
        int[] m = findRoot(p);
        int[] n = findRoot(q);
        if (m[1]<n[1])
            id[m[0]] = n[0];
        else
            id[n[0]] = m[0];
     
    }
    boolean connected(int p, int q){
        return findRoot(p)[0] == findRoot(q)[0];    
    }
    public static void main(String[] args){
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
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
