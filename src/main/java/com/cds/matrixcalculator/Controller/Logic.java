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
        
        if ( isSameDimesions(A, B) ) {
            
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
     * @param A A Matrix Object
     * @param B A Matrix Object
     * @return 
     */
    public static Matrix subtract(Matrix A, Matrix B) {
        
        if ( isSameDimesions(A, B) ) {
            
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
    
    /**
     * Perform a scalar multiplication for the matrix A
     * @param A A Matrix Object
     * @param scalar A scalar of type double
     * @return 
     */
    public static Matrix scalarMult(Matrix A, double scalar) {
        
        Matrix result = new Matrix(A.getRows(), A.getColumns());
        
        for (int row = 0; row < result.getRows(); row++) {
            for (int column = 0; column < result.getColumns(); column++) {
                double currentCellValue = A.secureGetMatrix()[row][column] * scalar;
                result.setIndividualMatrix(currentCellValue, row, column);
            }
        }
        
        return result;
        
    }
    
    /**
     * Perform a multiplication between matrix A and matrix B
     * @param A
     * @param B 
     * @return 
     */
    public static Matrix multiplication(Matrix A, Matrix B){
        
        if ( canMult(A, B) ) {
            
            Matrix result = new Matrix(A.getRows(), B.getColumns());
            
            for (int row = 0; row < result.getRows(); row++) {
                for (int column = 0; column < result.getColumns(); column++) {
                    double value = A.secureGetMatrix()[row][column] * B.secureGetMatrix()[column][row];
                    result.setIndividualMatrix(value, row, column);
                }
            }
            
            return result;
            
        } else {
            
            throw new ArithmeticException("Cannot perform this action.");
            
        }
        
    }
    
    /**
     * Perform the inverse of a matrix by the Gauss-Jordan method
     * @param A 
     * @return 
     */
    public static Matrix inverse(Matrix A) {
        
        if ( A.isSquare() && !(isSingular(A)) ) {
            
            Matrix result = new Matrix(A.getRows(), A.getColumns());
            Matrix identity = new Matrix(A.getRows(), A.getColumns() * 2);
            
            double[][] aux = A.secureGetMatrix();
            int rows = A.getRows();
            int columns = A.getColumns();
            
            for (int row = 0; row < rows; ++row) {
                System.arraycopy(aux[row], 0, identity.getMatrix()[row], 0, columns);
                for (int column = columns; column < columns * 2; ++column)
                    identity.getMatrix()[row][column] = (column== row + columns) ? 1.0 : 0 ;
            }
            identity = reduceEchelonForm(identity);
            
            for (int row = 0; row < rows; ++row)
                System.arraycopy(identity.secureGetMatrix()[row], columns, result.getMatrix()[row], 0, columns);
            
            return result;
                
        } else {
            
            throw new ArithmeticException("Cannot perform this action.");
            
        }
        
    }
    

    public static Matrix reduceEchelonForm(Matrix A) {
                
        int rows = A.getRows();
        int columns = A.getColumns();
        Matrix result = new Matrix(rows, columns);
        result.setMatrix(A.secureGetMatrix());
        double aux[][] = result.getMatrix();
        
        for (int row = 0, lead = 0; row < rows && lead < columns; ++row, ++lead) {
            int i = row;
            while (aux[i][lead] == 0) {
                if (++i == rows) {
                    i = row;
                    if (++lead == columns)
                        return result;
                }
            }
            swapRows(A, i, row);
            if (aux[row][lead] != 0) {
                double f = aux[row][lead];
                for (int column = 0; column < columns; ++column)
                    aux[row][column] /= f;
            }
            for (int j = 0; j < rows; ++j) {
                if (j == row)
                    continue;
                double f = aux[j][lead];
                for (int column = 0; column < columns; ++column)
                    aux[j][column] -= f * aux[row][column];
            }
        }
        
        return result;
    }
    
    /**
     * Perform the rows swap
     * @param A Matrix object
     * @param rowA row to be swapped
     * @param rowB row to be swapped
     */
    private static void swapRows(Matrix A, int rowA, int rowB) {
        double[] tmp = A.getMatrix()[rowA];
        A.getMatrix()[rowA] = A.getMatrix()[rowB];
        A.getMatrix()[rowB] = tmp;
    }
    
    /**
     * Check if the first matrix has the same number of columns than number of rows of the second matrix 
     * @param A Matrix object
     * @param B Matrix object
     * @return 
     */
    public static boolean canMult(Matrix A, Matrix B) {
        
        return A.getColumns() == B.getRows();
        
    }
    
    /**
     * Check if two matrices have same dimesions
     * @param A Matrix object
     * @param B Matrix object
     * @return 
     */
    public static boolean isSameDimesions(Matrix A, Matrix B) {
        
        return ( A.getRows() == B.getRows() ) && ( A.getColumns() == B.getColumns() );
        
    }
    
    /**
     * Check if matrix is singular
     * @param A Matrix object
     * @return 
     */
    public static boolean isSingular(Matrix A) {
        
        return determinant(A) == 0;
        
    }
    
    /**
     * Get matrix determinant 
     * @param A Matrix object
     * @return 
     */
    public static double determinant(Matrix A) {
        
        double result = 0;
        double[][] aux = A.secureGetMatrix();
        switch ( A.getRows() ) {
            
            case 2: 
                result = (
                        (aux[0][0] * aux[1][1])
                    -
                        (aux[1][0] * aux[0][1])
                    );
                break;
            case 3:
                result = (
                        (aux[0][0])*(aux[1][1])*(aux[2][2])+
                        (aux[1][0])*(aux[2][1])*(aux[0][2])+
                        (aux[2][0])*(aux[0][1])*(aux[1][2])
                    )-(
                        (aux[2][0])*(aux[1][1])*(aux[0][2])+
                        (aux[1][0])*(aux[0][1])*(aux[2][2])+
                        (aux[0][0])*(aux[2][1])*(aux[1][2])
                    );
                break;
            default:
                for(int row = 0; row < A.getRows() ; row++){
                    result += (aux[row][0] * adjoint( A, row, 0));
                }

        }
        
        return result;
        
    }
    
    /**
     * Get matrix adjoint
     * @param A Matrix object
     * @param i
     * @param j
     * @return 
     */
    public static double adjoint(Matrix A, int i, int j){
        
        double result = 0;
        Matrix y = new Matrix( A.getRows() - 1, A.getRows() - 1);
        int m,n;
        
        for(int k=0;k<y.getRows();k++){	
            m = (k<i) ? k : k+1;
            for(int l=0;l<y.getRows();l++){
                n = (l<j) ? l :  l+1;
                double value = A.secureGetMatrix()[m][n];
                y.setIndividualMatrix( value, k, l);
            }
        }
        result = (int)Math.pow(-1,i+j) * determinant(y);	
        
        return result;				
        
    }
    
    /**
     * Perform system of equations by the Gauss Jordan method
     * @param A Matrix object
     * @param order matrix order 
     * @return 
     */
    public static Matrix systemOfEquationGauss(Matrix A, int order){
        int c;

        Matrix result = new Matrix(A.getRows(), A.getColumns());
        result.setMatrix(A.secureGetMatrix());
        double aux[][] = result.getMatrix();
        
        for (int i = 0; i < order; i++){
            if (aux[i][i] == 0){
                c = 1;
                while ((i + c) < order && aux[i + c][i] == 0)
                    c++;           
                if ((i + c) == order) {
                    break;
                }
                for (int j = i, k = 0; k <= order; k++)
                    swapValues(result, j, k, j+c, k);
            }

            result = reduceEchelonForm(result);
        }
        
        return result;
        
    }
    
    /**
     * Check if system of equations has infinite solutions or no solutions 
     * @param A Matrix object
     * @param order matrix order
     * @return 
     * flag = true (infinite solutions)
     * flag = false (no solution)
     */
    public static boolean canSolve(Matrix A, int order){
        int i, j;
        double sum;

        double aux[][] = A.secureGetMatrix();
        
        boolean flag = false;
        for (i = 0; i < order; i++){
            sum = 0;
            for (j = 0; j < order; j++)       
                sum = sum + aux[i][j];
            if (sum == aux[i][j])
                flag = true;       
        }
        return flag;
    }
    
    /**
     * Perform swap between values 
     * @param A Matrix object
     * @param Ax row first value
     * @param Ay column first value
     * @param Bx row second value
     * @param By column second value
     */
    public static void swapValues(Matrix A, int Ax, int Ay, int Bx, int By){
    
        double aux[][] = A.getMatrix();
        
        double tmp = aux[Ax][Ay];
        aux[Ax][Ay] = aux[Bx][By];
        aux[Bx][By] = tmp;
        
    }
    
    /**
     * Perform system of equations by Cramer method
     * @param A Matrix object
     * @param order matrix order
     * @return 
     */
    public static Matrix systemOfEquationsCramer(Matrix A, int order){
        
        Matrix result = new Matrix(A.getRows(), A.getColumns());
        result.setMatrix(A.secureGetMatrix());
        
        double detA = determinant(A);
        double results[] = new double[ result.getRows() ];
                
        for (int coeff = 0; coeff < A.getColumns() - 1; coeff++){
            
            Matrix matrixCoe = swapColumns(result, coeff, result.getColumns() - 1);
            double det = determinant(matrixCoe);
            double value = det / detA;
            
            results[coeff] = value;
            
        }
        
        for (int row = 0; row < result.getRows(); row++){
            result.setIndividualMatrix(results[row], row, result.getColumns() - 1);
        }
        
        for (int row = 0; row < result.getRows(); row++){
            for (int column = 0; column < result.getColumns() - 1; column++){
                if (row == column){
                    result.setIndividualMatrix(1, row, column);
                } else {
                    result.setIndividualMatrix(0, row, column);
                }
            }
        }
        
        return result;
        
    }
    
    /**
     * Perform a matrix columns swap 
     * @param A Matrix object
     * @param columnA index of first column
     * @param columnB index of second column
     * @return 
     */
    public static Matrix swapColumns(Matrix A, int columnA, int columnB){
        
        Matrix result = new Matrix(A.getRows(), A.getColumns());
        result.setMatrix(A.secureGetMatrix());
        
        for (int row = 0; row < result.getRows(); row++){
            
            double tmp = result.getMatrix()[row][columnB];
            result.setIndividualMatrix(result.getMatrix()[row][columnA], row, columnB);
            result.setIndividualMatrix(tmp, row, columnA);
            
        }
        
        return result;
        
    }
    
    
    //Checar que determinantes distintos a 0 
    // == 0 infinite solutions los tres
    // != 0 no solution los tres
    
    //Checar determinant con isSquare
    
    
}
