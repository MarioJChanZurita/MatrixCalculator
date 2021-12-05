package com.cds.matrixcalculator.Controller;

import com.cds.matrixcalculator.Model.Matrix;

/**
 * Manage the logic operations between the Model and the View
 * @author reyes
 */
public class Logic {

    /**
     * Do an addition from the Matrix A -> B
     * @param A A Matrix Object
     * @param B A Matrix Object
     * @return 
     */
    public static Matrix add(Matrix A, Matrix B) {
        
        if ( A.isSquare() && B.isSquare() ) {
            
            Matrix result = new Matrix(A.getRows());
            
            for (int row = 0; row < result.getRows(); row++) {
                for (int column = 0; column < result.getColumns(); column++) {
                    double value = A.secureGetMatrix()[row][column] + B.secureGetMatrix()[row][column];
                    result.setIndividualMatrix(value, row, column);
                }
            }
            
            return result;
        
        } else {
        
            throw new ArithmeticException("Cannot perform this action.");
        
        }
        
    }
    
    /**
     * Do a subtraction from the Matrix A -> B
     * @param A
     * @param B
     * @return 
     */
    public static Matrix subtract(Matrix A, Matrix B) {
        
        if ( A.isSquare() && B.isSquare() ) {
            
            Matrix result = new Matrix(A.getRows());
            
            for (int row = 0; row < result.getRows(); row++) {
                for (int column = 0; column < result.getColumns(); column++) {
                    double value = A.secureGetMatrix()[row][column] - B.secureGetMatrix()[row][column];
                    result.setIndividualMatrix(value, row, column);
                }
            }
            
            return result;
        
        } else {
        
            throw new ArithmeticException("Cannot perform this action.");
        
        }
        
    }
    
}
