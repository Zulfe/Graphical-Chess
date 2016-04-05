package Model;

import Board.ChessBoard;
import Piece.Piece;

public class SinglePlayerModel implements Model {
	
	ChessBoard board;
	
	public SinglePlayerModel(){
		board = new ChessBoard();
		board.build();
	}
	
	public ChessBoard getBoard(){
		return board;
	}
	
	public Piece[][] getPieceArray(){
		return board.getBoard();
	}
}
