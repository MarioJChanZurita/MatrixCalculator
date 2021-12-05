package com.cds.matrixcalculator.Model;

/**
 * Mathematic matrix abstraction
 * @author reyes
 */
public class Matrix {
    
    private double matrix[][];
    private final int rows;
    private final int columns;

    /**
     * Create a Matrix with the same number of columns and rows
     * @param size Size of the matrix
     */
    public Matrix(int size) {
        
        this.matrix = new double[size][size];
        this.rows = size;
        this.columns = size;
    
    }
    
    /**
     * Create a Rectangular Matrix with specific number of columns and rows
     * @param rows Number of rows for the matrix
     * @param columns Number of columns for the matrix
     */
    public Matrix(int rows, int columns) {
        
        this.matrix = new double[rows][columns];
        this.rows = rows;
        this.columns = columns;
    
    }
    
    /**
     * Get the number of rows of the current matrix
     * @return 
     */
    public int getRows() {
        
        return this.rows;
        
    }
    
    /**
     * Get the number of columns of the current matrix
     * @return 
     */
    public int getColumns() {
        
        return this.columns;
        
    }
    
    /**
     * Get a copy from the current Matrix, this is safer
     * @return 
     */
    public double[][] secureGetMatrix() {
        
        double matrixCopy[][] = new double[this.rows][this.columns];
        
        for (int i = 0; i < rows; i++) {
            
            double auxMatrix[] = this.matrix[i];
            int currentRowSize = auxMatrix.length;
            matrixCopy[i] = new double[currentRowSize];
            System.arraycopy(auxMatrix, 0, matrixCopy[i], 0, currentRowSize);
            
        }
        
        return matrixCopy;
    }
    
    /**
     * Get the current Matrix, this is unsafe because you can modify the real matrix
     * @return 
     */
    public double[][] getMatrix() {
        
        return this.matrix;
    
    }
    
    /**
     * Set the values of the new Matrix
     * @param newValue The new values for the current matrix
     */
    public void setMatrix(double newValue[][]) {
        
        this.matrix = newValue;
    
    }
    
    /**
     * Set the value of an individual cell of the Matrix with the given row and column
     * @param value The new value to set
     * @param row Row to be selected
     * @param column Column to be selected
     */
    public void setIndividualMatrix(double value, int row, int column) {
        
        this.matrix[row][column] = value;
        
    }
    
    /**
     * Print the current Matrix
     */
    public void printMatrix() {
        
        for (int row = 0; row < this.rows; row++) {
            String currentRow = "[";
            for (int column = 0; column < this.columns; column++) {
                if (column < this.columns - 1) {
                    currentRow += this.matrix[row][column] + ", ";
                } else {
                    currentRow += this.matrix[row][column];
                }
            }
            currentRow += "]";
            System.out.println(currentRow);
        }
        
    }
    
    /**
     * Determine if the current Matrix is in a square form
     * @return 
     */
    public boolean isSquare() {
        
        return this.matrix.length == this.matrix[0].length;
        
    }
}
