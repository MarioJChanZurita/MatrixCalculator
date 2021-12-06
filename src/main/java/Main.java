import com.cds.matrixcalculator.Controller.Logic;
import com.cds.matrixcalculator.Model.Matrix;
import com.cds.matrixcalculator.View.Interface;

/**
 *
 * @author reyes
 */
public class Main {
    
    public static void main(String args[]) {
        Matrix A = new Matrix(2, 3);
        
        double aux[][] = {{3,-2,1},{1,5,3}};
        
        A.setMatrix(aux);
        
        //Logic.scalarMult(A,2).printMatrix();
        
        Logic.systemOfEquationsCramer(A,2).printMatrix();
    }
    
}
