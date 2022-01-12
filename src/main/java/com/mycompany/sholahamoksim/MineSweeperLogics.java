/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sholahamoksim;

import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author 05267
 */
public class MineSweeperLogics {

    private final static int boom = 9;
    /*
    mines are the bombs
     */
    private int mines;
    /*
    colms are the columns in the board
     */
    private int colms;
    /*
    rows are the rows in the board
     */
    private int rows;
    /*
    the max number of rows that can be put by the user
     */
    private final int MAXROWS = 20;
    /**
     * the max number of rows that can be put by the user
     */
    private final int MAXCOLMS = 20;
    /**
     * the board[][] is the board
     */
    private int[][] boardDB;

    /**
     * the logic of the game
     *
     * @param mines the number of mines
     * @param colms the number of columns
     * @param rows the number of rows
     * @throws Exception in case the user put wrong values
     */
    public MineSweeperLogics(int mines, int colms, int rows) throws Exception {
        checkValidations(mines, colms, rows);
        this.colms = colms;
        this.mines = mines;
        this.rows = rows;
        createBoard();
        printArray();
    }

    /**
     * create the board
     */
    private void createBoard() {
        int i, j;
        boardDB = new int[this.colms][this.rows];
        randomizeMines();
        for (i = 0; i < boardDB.length; i++) {
            for (j = 0; j < boardDB[i].length; j++) {
                if (boardDB[i][j] != boom) {
                    boardDB[i][j] = -1;
                }

            }
        }
    }

    /**
     * put the mines in a randomized place
     */
    public void randomizeMines() {
        Random r = new Random();
        int j, i;
        //
        while (mines != 0) {
            //System.out.println(mines);
            i = r.nextInt(colms);
            System.out.println(i);
            j = r.nextInt(rows);
            System.out.println(j);
            if (boardDB[i][j] == 9) {
                continue;
            }
            boardDB[i][j] = 9;
            mines--;
            //System.out.println(mines);
        }
    }

    /**
     * a function for the case the user step on a mine
     *
     * @param i the columns
     * @param j the rows
     * @return
     */
    public boolean isBoom(int i, int j) {
        if (boardDB[i][j] == boom) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * check and put the number of mines around the spot, inside the spot.
     */
    public void checkNoOfMines() {
        

    }

    /**
     * a function in case the user chooses a place that is in the corner
     * or on the side.
     * 
     * @return the sum of the mines around the place the user choose
     */
    public int getNearFields() {

        int tempColms;
        int tempRows;
        int sumOfMines = 0;
        for (tempColms = 0; tempColms < boardDB.length; tempColms++) {
            for (tempRows = 0; tempRows < boardDB[tempColms].length; tempRows++) {
                if (boardDB[tempColms--][tempRows--] != boom && boardDB[tempColms--][tempRows--] != -1 || boardDB[tempColms][tempRows--] != boom && boardDB[tempColms][tempRows--] != -1 || boardDB[tempColms++][tempRows--] != boom && boardDB[tempColms++][tempRows--] != -1 || boardDB[tempColms--][tempRows] != boom && boardDB[tempColms--][tempRows] != -1 || boardDB[tempColms--][tempRows++] != boom && boardDB[tempColms--][tempRows++] != -1 || boardDB[tempColms][tempRows++] != boom && boardDB[tempColms][tempRows++] != -1 || boardDB[tempColms++][tempRows++] != boom && boardDB[tempColms++][tempRows++] != -1 || boardDB[tempColms++][tempRows] != boom && boardDB[tempColms++][tempRows] != -1) {
                    continue;
                }
                if (boardDB[tempColms--][tempRows--] == boom || boardDB[tempColms--][tempRows] == boom || boardDB[tempColms--][tempRows++] == boom || boardDB[tempColms][tempRows--] == boom || boardDB[tempColms++][tempRows--] == boom || boardDB[tempColms++][tempRows] == boom || boardDB[tempColms++][tempRows++] == boom || boardDB[tempColms][tempRows++] == boom) {
                    sumOfMines++;
                }
            }
        }

        return sumOfMines;
    }

    /**
     * shows the board
     */
    private void printArray() {
        int i, j;
        for (i = 0; i < boardDB.length; i++) {
            for (j = 0; j < boardDB[i].length; j++) {
                System.out.print(boardDB[i][j] + " ");
            }
            System.out.println();
        }

    }
    //public 

    /**
     * check if the values are valid or not
     *
     * @param mines the number of mines
     * @param colms the number of columns
     * @param rows the number of row
     * @throws Exception
     */
    private void checkValidations(int mines, int colms, int rows) throws Exception {
        if (colms > MAXCOLMS || rows > MAXROWS || rows <= 0 || colms <= 0) {
            throw new Exception("the values are invalid");
        }
        if (mines >= (rows * colms) || mines <= 0) {
            throw new Exception("the values are invalid");
        }
    }

}
