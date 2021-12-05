import com.cds.matrixcalculator.Controller.Logic;
import com.cds.matrixcalculator.Model.Matrix;

/**
 *
 * @author reyes
 */
public class Main {
    
    public static void main(String args[]) {
        Matrix A = new Matrix(2);
        Matrix B = new Matrix(2);
        
        double aux[][] = {{1,2},{2,1}};
        
        A.setMatrix(aux);
        B.setMatrix(aux);
        
        Logic.subtract(A,B).printMatrix();
    }
    
}
