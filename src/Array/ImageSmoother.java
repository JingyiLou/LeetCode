package Array;

public class ImageSmoother {
    //1. 1*1
    //2. 1*n
    //3. N*1
    //4. others(consider corners, edges and insider
    public int[][] imageSmoother(int[][] M) {
        int colLen = M[0].length;
        int rowLen = M.length;
        int [][] grey = new int[rowLen][colLen];
        if(colLen == 1 && rowLen == 1){
            grey[0][0] = M[0][0];
        }else if(colLen == 1){
            grey[0][0] = (M[0][0]+M[1][0])/2;
            for(int i=1; i<rowLen-1; i++){
                grey[i][0] = (M[i-1][0] + M[i][0] + M[i+1][0])/3;
            }
            grey[rowLen-1][0] = (M[rowLen-2][0]+M[rowLen-1][0])/2;
        }else if(rowLen == 1){
            grey[0][0] = (M[0][0]+M[0][1])/2;
            for(int i=1; i<colLen-1; i++){
                grey[0][i] = (M[0][i-1] + M[0][i] + M[0][i+1])/3;
            }
            grey[0][colLen-1] = (M[0][colLen-2]+M[0][colLen-1])/2;
        }else{
            for(int i=0; i<colLen; i++){
                for(int j=0; j<rowLen; j++){
                    grey[j][i] = avgGrey(i, j, M);
                }
            }
        }
        return grey;
    }

    public int avgGrey(int col, int row, int[][] M){
        if(row == 0 || col == 0 || row == M.length-1 || col == M[0].length-1){
            if( row==0 && col==0 ){
                return (M[row][col] + M[row][col+1] + M[row+1][col] + M[row+1][col+1])/4;
            }else if(row==0 && col==M[0].length-1){
                return (M[row][col-1] + M[row][col] + M[row+1][col-1] + M[row+1][col])/4;
            }else if(row==M.length-1 && col==0 ){
                return (M[row-1][col] + M[row-1][col+1] + M[row][col] + M[row][col+1])/4;
            }else if(row==M.length-1 && col==M[0].length-1){
                return (M[row-1][col-1] + M[row-1][col] + M[row][col-1] + M[row][col])/4;
            }else if(row == 0){
                return (M[row][col-1]+M[row][col]+M[row][col+1]
                        +M[row+1][col-1]+M[row+1][col]+M[row+1][col+1])/6;
            }else if(col == 0){
                return (M[row-1][col]+M[row-1][col+1]+M[row][col]
                        +M[row][col+1]+M[row+1][col]+M[row+1][col+1])/6;
            }else if(row == M.length-1){
                return (M[row-1][col-1]+M[row-1][col]+M[row-1][col+1]
                        +M[row][col-1]+M[row][col]+M[row][col+1])/6;
            }else if(col == M[0].length-1){
                return (M[row-1][col-1]+M[row-1][col]+M[row][col-1]
                        +M[row][col]+M[row+1][col-1]+M[row+1][col])/6;
            }
        }else{
            return ( M[row-1][col-1]+M[row-1][col]+M[row-1][col+1]
                    +M[row][col-1]+M[row][col]+M[row][col+1]
                    +M[row+1][col-1]+M[row+1][col]+M[row+1][col+1] )/9;
        }
        return 0;
    }
}
