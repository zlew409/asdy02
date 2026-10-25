public class minHeap {
    int n;
    edge[] A;


    public minHeap() {
        n = 1;
        A = new edge[16];
    }


    public void addEdge(String ends, int val){
        if(n>15) return;
        A[n] = new edge(ends,val);
        upHeap();
        n++;
    }

    public void upHeap(){
        int i = n;
        while(true){
            if(i<=1) break;
            if(A[i/2].val <= A[i].val) break;
            edge temp = A[i];
            A[i] = A[i/2];
            A[i/2] = temp;
            i = i/2;
        }
    }

    public edge delEdge(){
        if(isEmpty()) return null;

        n--;
        edge ans = A[1];
        A[1] = A[n];
        A[n] = null;
        downHeap(1);
        return ans;
    }

    public void downHeap(int i){
        while(true){
            if(2*i>n-1) break;
            int k = 2*i;
            if(k+1<=n-1 && A[k+1].val < A[k].val){
                k = k+1;
            }
            if(A[k].val >= A[i].val) break;
            edge temp = A[i];
            A[i] = A[k];
            A[k] = temp;
            i = k;
        }
    }

    public boolean isEmpty(){
       return n==1;
    }

    public void showHeap(){
        if(isEmpty()) return;;
        for(int i=1; i<=n-1; i++){
            System.out.println(A[i].ends + " " + A[i].val);
        }
    }

    public edge peek(){
        return A[1];
    }

    public void delHeap(){
        int x = n-1;
        for(int i=1;i<=x;i++){
            delEdge();
        }
    }
}
