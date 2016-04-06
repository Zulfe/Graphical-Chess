package Piece;

import Board.Coordinate;

public class Queen extends Piece {

	private Bishop bishopReference;
	private Rooke rookeReference;
	
	public Queen(String ID, String icon, boolean isWhite, char posX, char posY) {
		super(ID, icon, isWhite, posX, posY);
	}
	
	public boolean isMoveValid(Coordinate newPosition, Piece[][] chessBoard){
		bishopReference = new Bishop("QuB", "X", super.isWhite, super.currentPos.getGameX(), super.currentPos.getGameY());
		rookeReference = new Rooke("QuR", "X", super.isWhite, super.currentPos.getGameX(), super.currentPos.getGameY());
		System.out.println("Making new " + super.isWhite + " white references.");
		//if the queen's motion meets the criteria for the motion of either a rooke
		//or a bishop, allow the move
		if(bishopReference.isMoveValid(newPosition, chessBoard))
			return true;
		if(rookeReference.isMoveValid(newPosition, chessBoard))
			return true;
		return false;
	}
}
