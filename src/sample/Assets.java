package sample;


import sample.piece.*;

public class Assets {

    private static Piece[][] pieces = new Piece[8][4];

    public static void initPieces(ChessBoard chessBoard) {
        pieces[0][0] = new PieceRook(1, 0, 0, chessBoard);
        pieces[0][1] = new PiecePawn(1, 0, 0, chessBoard);
        pieces[0][2] = new PiecePawn(2, 0, 0, chessBoard);
        pieces[0][3] = new PieceRook(2, 0, 0, chessBoard);

        pieces[1][0] = new PieceKnight(1, 0, 0, chessBoard);
        pieces[1][1] = new PiecePawn(1, 0, 0, chessBoard);
        pieces[1][2] = new PiecePawn(2, 0, 0, chessBoard);
        pieces[1][3] = new PieceKnight(2, 0, 0, chessBoard);

        pieces[2][0] = new PieceBishop(1, 0, 0, chessBoard);
        pieces[2][1] = new PiecePawn(1, 0, 0, chessBoard);
        pieces[2][2] = new PiecePawn(2, 0, 0, chessBoard);
        pieces[2][3] = new PieceBishop(2, 0, 0, chessBoard);

        pieces[3][0] = new PieceQueen(1, 0, 0, chessBoard);
        pieces[3][1] = new PiecePawn(1, 0, 0, chessBoard);
        pieces[3][2] = new PiecePawn(2, 0, 0, chessBoard);
        pieces[3][3] = new PieceQueen(2, 0, 0, chessBoard);

        pieces[4][0] = new PieceKing(1, 0, 0, chessBoard);
        pieces[4][1] = new PiecePawn(1, 0, 0, chessBoard);
        pieces[4][2] = new PiecePawn(2, 0, 0, chessBoard);
        pieces[4][3] = new PieceKing(2, 0, 0, chessBoard);

        pieces[5][0] = new PieceBishop(1, 0, 0, chessBoard);
        pieces[5][1] = new PiecePawn(1, 0, 0, chessBoard);
        pieces[5][2] = new PiecePawn(2, 0, 0, chessBoard);
        pieces[5][3] = new PieceBishop(2, 0, 0, chessBoard);

        pieces[6][0] = new PieceKnight(1, 0, 0, chessBoard);
        pieces[6][1] = new PiecePawn(1, 0, 0, chessBoard);
        pieces[6][2] = new PiecePawn(2, 0, 0, chessBoard);
        pieces[6][3] = new PieceKnight(2, 0, 0, chessBoard);

        pieces[7][0] = new PieceRook(1, 0, 0, chessBoard);
        pieces[7][1] = new PiecePawn(1, 0, 0, chessBoard);
        pieces[7][2] = new PiecePawn(2, 0, 0, chessBoard);
        pieces[7][3] = new PieceRook(2, 0, 0, chessBoard);
    }

    public static Piece[][] getPieces() {
        return pieces;
    }

}
