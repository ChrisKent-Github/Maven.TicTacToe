package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    Character [][] board;
    char player;

    public Board(Character[][] matrix) {
        this.board = matrix;
    }

    public Boolean isInFavorOfX() {
        setPlayer('X');
        Character result = determiner();
        if(result == 'X'){
        return true;}
        return false;
    }

    public Boolean isInFavorOfO() {
        setPlayer('O');
        Character result = determiner();
        if(result == 'O'){
            return true;}
        return false;
    }

    public Boolean isTie() {
        setPlayer('X');
        Character xWinner = determiner();
        setPlayer('O');
        Character oWinner = determiner();
        if(xWinner == '\u0000' && oWinner == '\u0000'){
        return true;}
        return false;
    }

    public Character[] getRow(Integer value) {
        return this.board[value];
    }

    public Character[] getColumn(Integer value) {
        Character[] column = new Character[3];
        column[0] = board [0][value];
        column[1] = board [1][value];
        column[2] = board [2][value];
        return column;
    }

    public Boolean isRowHomogenous(Integer rowIndex) {
        if(this.board[rowIndex][0] == this.board[rowIndex][1] && this.board[rowIndex][1] == this.board[rowIndex][2]){
            return true;
        }
        return false;
    }

    public Boolean isColumnHomogeneous(Integer columnIndex) {
        if(getColumn(columnIndex)[0] == getColumn(columnIndex)[1] && getColumn(columnIndex)[1] == getColumn(columnIndex)[2])
        {
            return true;}
        return false;
    }

    public char setPlayer(char player){
        return this.player = player;
    }

    public Character getWinner() {
        Character result = '\u0000';
        if(isInFavorOfO() == true){
            result = 'O';
        }
        else if(isInFavorOfX() == true){
            result = 'X';
        }

    return result;
    }


public Character determiner(){
            for (int i = 0; i < 3; i++) {
                if(isRowHomogenous(i) && this.board[i][0].equals(this.player)){
                    return getRow(i)[2];
                }
            }

            for (int i = 0; i < 3; i++) {
                if(isColumnHomogeneous(i) && getColumn(i)[0].equals(this.player)){
                    return getColumn(i)[2];
                }
            }

            if(getRow(0)[0] == getRow(1)[1] && getRow(1)[1] == getRow(2)[2] && this.board[1][1].equals(this.player)){
                return getRow(1)[1];
            }

            if(getRow(0)[2] == getRow(1)[1] && getRow(1)[1] == getRow(2)[0] && this.board[1][1].equals(this.player)){
                return getRow(1)[1];
            }
            return '\u0000';
        }

}
