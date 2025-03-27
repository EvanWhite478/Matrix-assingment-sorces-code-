package io.github.EvanWhite478.matrixlib;

public class MatrixExceptions  extends  Exception{
    public MatrixExceptions(MatrixValidationErrorEnum error) {
        super(error.toString());
    }

}
