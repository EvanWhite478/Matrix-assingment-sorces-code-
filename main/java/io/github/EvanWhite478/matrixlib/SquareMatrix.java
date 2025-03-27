package io.github.EvanWhite478.matrixlib;

public class SquareMatrix extends Matrix {

    public SquareMatrix(int size) throws MatrixExceptions {
        super(size, size);
    }

    public SquareMatrix(int[][] data) throws MatrixExceptions {
        super(data);
        if (numRows != numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_SQUARE_MATRIX_SIZE);
        }
    }

    public SquareMatrix add(SquareMatrix A) throws MatrixExceptions {
        return new SquareMatrix(MatrixInterface.add(this, A).data);
    }

    public SquareMatrix subtract(SquareMatrix A) throws MatrixExceptions {
        return new SquareMatrix(MatrixInterface.subtract(this, A).data);
    }

    public SquareMatrix multiply(SquareMatrix A) throws MatrixExceptions {
        return new SquareMatrix(MatrixInterface.multiply(this, A).data);
    }

    public SquareMatrix multiply(int scalar) throws MatrixExceptions {
        return new SquareMatrix(MatrixInterface.multiply(this, scalar).data);
    }

    public SquareMatrix transpose() throws MatrixExceptions {
        Matrix result = super.transpose();
        return new SquareMatrix(result.data);
    }

    public int determinant() throws MatrixExceptions {
        return SquareMatrixInterface.determinant(this);
    }


    public SquareMatrix minor(int row, int col) throws MatrixExceptions {
        return new SquareMatrix(MatrixInterface.minor(this, row, col).data);
    }

    public int getSize() {
        return numRows;
    }

    //The body of this method is fine
    public SquareMatrix power(int n) throws MatrixExceptions {
        if (n < 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_POWER);
        }
        if (n == 0) {
            return SquareMatrixInterface.identity(numRows);
        }
        Matrix result = this;
        for (int i = 1; i < n; i++) {
            result = result.multiply(this);
        }
        return new SquareMatrix(result.data);
    }

}

