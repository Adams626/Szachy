package com.chess.engine.board;

public class BoardUtils {


    public static final boolean[] FIRST_COLUMN = initColumn(0);
    public static final boolean[]SECOND_COLUMN = initColumn(1);
    public static final boolean[] SEVENTH_COLUMN =initColumn(6);
    public static final boolean[] EIGHT_COLUMN =initColumn(7);

    public static final boolean[] SECOND_ROW=null;
    public static final boolean[] SEVENTH_ROW=null;

    public static final int NUM_TILES = 64;
    public static final int NUM_TILES_PER_ROW = 8;

    private BoardUtils(){
        throw new RuntimeException("You cannot instantiate me!");
    }


    //Metoda wybiera pole w danej kolumnie i ustawia wszytkie pola w niej na true aby metoda w np. (isFirstColumnExclusion knight) mogła poprawnie działać
    private static boolean[] initColumn(final int columnNumber) {
        final boolean[] column = new boolean[NUM_TILES];
        for (int i = 0; i < NUM_TILES_PER_ROW; i++)
            column[i*NUM_TILES_PER_ROW+columnNumber] = true;
        return column;
    }

    public static boolean isValidTileCoordinate(final int coordinate) {
        return coordinate>=0 &&coordinate<64;
    }
}
