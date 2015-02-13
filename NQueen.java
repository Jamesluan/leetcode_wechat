public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> ret = new ArrayList<String[]> ();
        Board board= new Board(n);
        ret= solveNQueens(0,n,board);
        return ret;
    }
    
    public List<String[]> solveNQueens(int x,int n, Board board) {
        List<String[]> ret = new ArrayList<String[]> ();
        int i=x;
        for(int j=0;j<n;j++){
            if(isPuttable(i,j,board)){
                if(i!=n-1){
                    Board nb=new Board(board,i,j);
                    ret.addAll(solveNQueens(i+1,n,nb));
                }
                else{
                    Board nb=new Board(board,i,j);
                    ret.add(nb.toStringarray());
                }
            }
        }
        return ret;
    }
    public boolean isPuttable(int x,int y,Board b){
        for(int i=0;i<b.n;i++){
            for(int j=0;j<b.n;j++){
                if(b.board[i][j]){
                    if(i==x || y==j){
                        return false;
                    }
                    else if(Math.abs(x-i)==Math.abs(y-j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public class Board{
        int n;
        boolean [][] board;
        public Board(int n){
            board= new boolean [n][n];
            this.n=n;
        }
        public Board(Board b, int x, int y){
            board= new boolean [b.n][b.n];
            this.n=b.n;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(x==i && y==j){
                        board[x][y]=true;
                    }
                    else{
                        board[i][j]=b.board[i][j];
                    }
                }
            }
        }
        public void set(int x,int y){
            if(x<n && y<n){
                board[x][y]=true;
            }
        }
        public boolean isSet(int x,int y){
            return board[x][y];
        }
        public String[] toStringarray(){
            String [] str= new String[n];
            for(int i=0;i<n;i++){
                str[i]=new String("");
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    
                    if(board[i][j]){
                        str[i]+='Q';
                    }
                    else{
                        str[i]+='.';
                    }
                }
            }
            return str;
        }
    }
}