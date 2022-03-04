package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

import static com.chess.engine.board.BoardUtils.NUM_TILES;

public abstract class Tile {
    protected final int tileCoordinate;

    private static final Map<Integer,EmptyTile> EMPTY_TILE_CACHE = createAllPossibleEmptyTiles();


    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        //tworzenie mapy pól do planszy
        final Map<Integer,EmptyTile> emptyTileMap= new HashMap<>();

        for(int i =0;i<NUM_TILES;i++){
            emptyTileMap.put(i,new EmptyTile(i));
        }
        // Zewnętrzna biblioteka od googla uniemożliwiająca zmianę dodania lub usunięcia obiektu
        //Użyteczna do towrzenia wielu Thread - ów
        // Możliwe też użycie 
        // return Collections.unmodifiableMap(emptyTileMap);
        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece){
        return piece!= null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILE_CACHE.get(tileCoordinate);
    }
    private Tile(final int tileCoordinate){
        this.tileCoordinate=tileCoordinate;
    }
    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile{
        EmptyTile(final int coordinate){
            super (coordinate);
        }

        @Override
        public boolean isTileOccupied(){
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }
    }
    public static final class OccupiedTile extends Tile{
        private final Piece pieceOnTile;

        private OccupiedTile(int tileCoordinate, final Piece pieceOnTile){
            super(tileCoordinate);
            this.pieceOnTile=pieceOnTile;
        }

        @Override
        public boolean isTileOccupied(){
            return true;
        }
        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }
}