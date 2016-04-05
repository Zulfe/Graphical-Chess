package Model;

import Piece.Piece;
import Board.ChessBoard;

public interface Model {
	public ChessBoard getBoard();
	public Piece[][] getPieceArray();
}
