package sample;

import java.util.Random;

class LogicsVer2 {

    private static byte[][] interimArray;

    static byte[][] creatadRandomArrayVer2(int n, int m, int k) {
        byte[][] array = new byte[n][m];
        interimArray = new byte[n][m];
        if (k >= n * m) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = 1;
                }
            }
            return array;
        }
        int count = 0;
        Random rnd = new Random();
        while (count<k) {
            int a = rnd.nextInt(n);
            int b = rnd.nextInt(m);
            if (array[a][b]==0){array[a][b]=1;AroundSum(a,b,array,interimArray);count++;}
        }

        return array;
    }

    private static void AroundSum(int x, int y, byte[][] matrix1, byte[][] matrix2)
    {
        if (x<matrix1.length-1){matrix2[x+1][y]+=1;}
        if (x>0) {matrix2[x-1][y]+=1;}
        if (y<matrix1[x].length-1){matrix2[x][y+1]+=1;}
        if (y>0){matrix2[x][y-1]+=1;}

        if (x<matrix1.length-1 && y<matrix1[x].length-1){matrix2[x+1][y+1]+=1;}
        if (x>0 && y>0) {matrix2[x-1][y-1]+=1;}
        if (x<matrix1.length-1 && y>0){matrix2[x+1][y-1]+=1;}
        if (x>0 && y<matrix1[x].length-1) {matrix2[x-1][y+1]+=1;}

    }

    static byte[][] matrixIteration_life(byte[][] matrix){
        byte[][] matrixCopy=matrix.clone();
        for (int i = 0; i < matrix.length; i++) {
            matrixCopy[i] = matrix[i].clone();
        }
        byte[][] array2Copy=interimArray.clone();
        for (int i = 0; i < interimArray.length; i++) {
            array2Copy[i] = interimArray[i].clone();
        }
        for (int i=0;i<matrixCopy.length;i++){
            for (int j=0;j<matrixCopy[i].length;j++){
                if (interimArray[i][j]==3 && matrix[i][j]==0){matrixCopy[i][j]=1;AroundSum(i,j,interimArray,array2Copy);}
            }
        }
        interimArray=array2Copy;
        return matrixCopy;

    }

    static byte[][] matrixIteration_death(byte[][] matrix){
        byte[][] matrixCopy=matrix.clone();
        for (int i = 0; i < matrix.length; i++) {
            matrixCopy[i] = matrix[i].clone();
        }
        byte[][] array2Copy=interimArray.clone();
        for (int i = 0; i < interimArray.length; i++) {
            array2Copy[i] = interimArray[i].clone();
        }
        for (int i=0;i<matrixCopy.length;i++){
            for (int j=0;j<matrixCopy[i].length;j++){
                if (!(interimArray[i][j]==3 || interimArray[i][j]==2) && matrix[i][j]==1){matrixCopy[i][j]=0;AroundSum(i,j,interimArray,array2Copy);}
            }
        }
        interimArray=array2Copy;
        return matrixCopy;
    }
}