package io.github.EvanWhite478.matrixlib;

public class Matrix implements MatrixInterface {
    //private may not be the best option here.
    // We only need to prevent external classes from modifying the variables directly
    protected int numRows;
    protected int numCols;
    protected int[][] data;

    // Constructors
    public Matrix(int numRows, int numCols) throws MatrixExceptions {
        this.numRows = numRows;
        this.numCols = numCols;
        if (numRows == numCols && numRows <= 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_SQUARE_MATRIX_SIZE);
        }
        if (numRows <= 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_NUM_ROWS);
        }
        if (numCols <= 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_NUM_COLS);
        }
        this.data = new int[numRows][numCols];
    }

    public Matrix(int[][] data) throws MatrixExceptions {
        this.numRows = data.length;
        this.numCols = data[0].length;
        for (int i = 1; i < numRows; i++) {
            if (data[i].length != numCols) {
                throw new MatrixExceptions(MatrixValidationErrorEnum.NOT_ALL_ROWS_SAME_LENGTH);
            }
        }
        this.data = data;
    }

    public int getEntry(int i, int j) throws MatrixExceptions {
        if (i < 0 || i >= numRows) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_ROW);
        }
        if (j < 0 || j >= numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_COL);
        }
        return data[i][j];
    }


    public int getNumRows() {
        return numRows;
    }


    public int getNumCols() {
        return numCols;
    }

    public void setEntry(int i, int j, int value) throws MatrixExceptions {
        if (i < 0 || i >= numRows) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_ROW);
        }
        if (j < 0 || j >= numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_COL);
        }
        data[i][j] = value;
    }
    // Static Methods for Operations


    public Matrix minor(int row, int col) throws MatrixExceptions {
        return new Matrix(MatrixInterface.minor(this, row, col).data);
    }


    public Matrix transpose() throws MatrixExceptions {
        return MatrixInterface.transpose(this);
    }

    // Instance Methods that utilize Static Methods
    public Matrix add(Matrix A) throws MatrixExceptions {
        return MatrixInterface.add(this, A);
    }

    public Matrix subtract(Matrix A) throws MatrixExceptions {
        return MatrixInterface.subtract(this, A);
    }

    public Matrix multiply(Matrix A) throws MatrixExceptions {
       return MatrixInterface.multiply(this, A);
    }

    public Matrix multiply(int scalar) throws MatrixExceptions {
        return MatrixInterface.multiply(this, scalar);
    }




}
