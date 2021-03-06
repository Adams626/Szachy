package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

import static com.chess.engine.board.Board.*;

public abstract class Move {
    final Board board;
    final Piece movedPiece;
    final int destinationCoordinate;


    private Move(final Board board,
         final Piece movedPiece,
         final int destinationCoordinate){
        this.board =board;
        this.movedPiece=movedPiece;
        this.destinationCoordinate=destinationCoordinate;

    }
    public int getDestinationCoordinate(){
        return this.destinationCoordinate;
    }

    public Piece getMovedPiece(){
        return this.movedPiece;
    }

    public abstract Board execute();

    public static final class MajorMove extends Move{


        public MajorMove(final Board board, final Piece movedPiece, final int destinationCoordinate) {
            super(board, movedPiece, destinationCoordinate);
        }

        @Override
        public Board execute() {
            //tworzy nową plansze przy wykonaniu ruchu. Przejdziemy przez wszystkie figury current player i sprawdzimy dostępne figury. Następnie robimy to samo dla drugiego gracza.
            final Builder builder = new Builder();
            for(final Piece piece : this.board.currentPlayer().getActivePieces()){
                //TODO hashcode
                if(!this.movedPiece.equals(piece)){
                    builder.setPiece(piece);
                }
            }
            for (final Piece piece : this.board.currentPlayer().getOpponent().getActivePieces()){
                builder.setPiece(piece);
            }
            //robi ruch a następnie przekazuje current player do drugiego gracza
            builder.setPiece(this.movedPiece.movePiece(this));
            builder.setMoveMaker(this.board.currentPlayer().getAlliance());
            return builder.build();
        }
    }
    public static final class AttackMove extends Move {

        final Piece attackedPiece;

        public AttackMove(final Board board, final Piece movedPiece, final int destinationCoordinate, final Piece attackedPiece) {
            super(board, movedPiece, destinationCoordinate);
            this.attackedPiece = attackedPiece;
        }

        @Override
        public Board execute() {
            return null;
        }
    }
}
