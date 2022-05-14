package com.company;

import java.util.Iterator;

class MatrixIndexException extends RuntimeException {}
class MatrixOperationException extends RuntimeException {}

public class Matrix implements Iterable<Double> {
    private double m[][];

    public Matrix(){
    }

    public Matrix (int rows, int cols){
        m = new double[rows][cols];
    }

    public double get(int r, int c){
        int rows = m.length;
        int cols = m[0].length;
        if (r<0 || r >= rows || c<0 || c>= cols){
            throw new MatrixIndexException();
        }
        return m[r][c];
    }

    public void set(int r, int c, double v) {
        int rows = m.length;
        int cols = m[0].length;
        if (r<0 || r >= rows || c<0 || c>= cols){
            throw new MatrixIndexException();
        }
        m[r][c] = v;
    }

    public int getNumberOfRows(){
        return m.length;
    }

    public int getNumberOfCols(){
        return m[0].length;
    }

    public Matrix add(Matrix m){
        if(this.m.length != m.m.length || this.m[0].length != m.m[0].length){
            throw new MatrixOperationException();
        }
        Matrix sum = new Matrix(this.m.length,this.m[0].length);
        for(int i = 0; i < this.m.length; i++)
            for (int j = 0; j < this.m[0].length; j++) {
                sum.set(i, j, this.m[i][j] + m.m[i][j]);
            }
        return sum;
    }

    public Matrix mull(Matrix m){
        if(this.m.length != m.m.length || this.m[0].length != m.m[0].length){
            throw new MatrixOperationException();
        }
        Matrix mull = new Matrix(this.m.length,this.m[0].length);
        double result;
        for(int i = 0; i < this.m.length; i++)
            for (int j = 0; j < this.m[0].length; j++){
                result = 0;
                for (int k = 0; k < m.m[0].length; k++) {
                    result += this.m[i][k] * m.m[k][j];
                }
                mull.set(i,j,result);
            }
        return mull;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(double[] row:m) {
            for (double v: row){
                sb.append(String.format("%5.2f, ",v));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Double> iterator() {
        //return new DefaultIterator();
        return new Iterator<Double>() {
            int pos; // = 0; by default
            @Override
            public boolean hasNext() {
                int rows = m.length;
                int cols = m[0].length;
                return pos<rows*cols;
            }
            @Override
            public Double next() {
                int cols = m[0].length;
                int irow = pos / cols;
                int icol = pos % cols;
                double v = m[irow][icol];
                ++pos;
                return v;
            }
        };
    }

    public Iterator<Matrix> rows(){
        return new Iterator<Matrix>() {
            int pos;
            @Override
            public boolean hasNext() {
                int rows = m.length;
                return pos<rows;
            }

            @Override
            public Matrix next() {
                int cols = m[0].length;
                Matrix mm = new Matrix(1,cols);
                for(int i = 0; i < cols; i++){
                    mm.set(1,i, m[pos][i]);
                }
                pos++;
                return mm;
            }
        };

    }

}

