package com.chess.engine;


//Enum to typ wyliczeniowy, który umożliwia w Javie zadeklarowanie ograniczonej liczby możliwych wartości. Przydatny np. w przypadku deklaracji statusów procesu.

public enum Alliance {
    WHITE{
        @Override
        public int getDirection(){
            return -1;
        }

        @Override
        public boolean isWhite() {
            return true;
        }

        @Override
        public boolean isBlack() {
            return false;
        }
    },
    BLACK{
        @Override
        public int getDirection(){
            return 1;
        }

        @Override
        public boolean isWhite() {
            return false;
        }

        @Override
        public boolean isBlack() {
            return true;
        }
    };

    //Metoda używana do poruszania się pionów w odpowiednią stronę
    public abstract int getDirection();
    public abstract boolean isWhite();
    public abstract boolean isBlack();
}
