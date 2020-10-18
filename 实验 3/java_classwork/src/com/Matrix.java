package com;

public class Matrix {
    private int rows;
    private int cols;
    private double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                data[i][j] = 0;
            }
        }
    }

    public void setElement(int row, int col, double value){
        data[row][col] = value;
    }

    public double getElement(int row, int col){
        return data[row][col];
    }

    public Matrix add(Matrix m){
        if(m.rows != this.rows) return null;
        Matrix res = new Matrix(rows,cols);
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                res.data[i][j] = m.data[i][j] + this.data[i][j];
            }
        }
        return res;
    }

    public Matrix minus(Matrix m){
        if(m.rows != this.rows) return null;
        Matrix res = new Matrix(rows,cols);
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                res.data[i][j] =  this.data[i][j] - m.data[i][j];
            }
        }
        return res;
    }

    public Matrix multiple(Matrix m){
        if(m.rows != this.cols) return null;
        Matrix res = new Matrix(rows, m.cols);
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<m.cols; j++){
                for (int z = 0; z<rows; z++){
                    res.data[i][j] += this.data[i][z] * m.data[z][j];
                }
            }
        }
        return res;
    }

    public Matrix transposition(){
        Matrix res = new Matrix(cols, rows);
        for(int i = 0; i<cols; i++){
            for(int j = 0; j<rows; j++){
                res.data[i][j] =  this.data[j][i];
            }
        }
        return res;
    }

    public void display(){
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                System.out.printf("%.1f ", data[i][j]);
            }
            System.out.println();
        }
    }
}
