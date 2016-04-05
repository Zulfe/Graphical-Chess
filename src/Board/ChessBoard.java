package Board;

import java.util.HashMap;

import Piece.*;

public class ChessBoard {
	
	private Piece[][] chessBoard;
	public static HashMap<Character, Integer> coordinateMap;
	
	public ChessBoard(){
		coordinateMap = new HashMap<Character, Integer>();	
		coordinateMap.put('A', 0);
		coordinateMap.put('B', 1);
		coordinateMap.put('C', 2);
		coordinateMap.put('D', 3);
		coordinateMap.put('E', 4);
		coordinateMap.put('F', 5);
		coordinateMap.put('G', 6);
		coordinateMap.put('H', 7);
		coordinateMap.put('8', 0);
		coordinateMap.put('7', 1);
		coordinateMap.put('6', 2);
		coordinateMap.put('5', 3);
		coordinateMap.put('4', 4);
		coordinateMap.put('3', 5);
		coordinateMap.put('2', 6);
		coordinateMap.put('1', 7);
		build();
	}


	/**
	 * Creates all of the pieces and sets them in their initial positions.
	 * In this configuration, white pieces are on the bottom while the
	 * black pieces are on the top.
	 */
	public void build(){
		chessBoard = new Piece[8][8];
		
		//black pieces
		chessBoard[0][0] = new Rooke("BR1", "t", false, 'A', '8');
		chessBoard[0][1] = new Knight("BK1", "m", false, 'B', '8');
		chessBoard[0][2] = new Bishop("BB1", "v", false, 'C', '8');
		chessBoard[0][3] = new Queen("BQu", "w", false, 'D', '8');
		chessBoard[0][4] = new King("BKi", "l", false, 'E', '8');
		chessBoard[0][5] = new Bishop("BB2", "v", false, 'F', '8');
		chessBoard[0][6] = new Knight("BK2", "m", false, 'G', '8');
		chessBoard[0][7] = new Rooke("BR2", "t", false, 'H', '8');
		chessBoard[1][0] = new Pawn("BP1", "o", false, 'A', '7');
		chessBoard[1][1] = new Pawn("BP2", "o", false, 'B', '7');
		chessBoard[1][2] = new Pawn("BP3", "o", false, 'C', '7');
		chessBoard[1][3] = new Pawn("BP4", "o", false, 'D', '7');
		chessBoard[1][4] = new Pawn("BP5", "o", false, 'E', '7');
		chessBoard[1][5] = new Pawn("BP6", "o", false, 'F', '7');
		chessBoard[1][6] = new Pawn("BP7", "o", false, 'G', '7');
		chessBoard[1][7] = new Pawn("BP8", "o", false, 'H', '7');
		
		//white pieces
		chessBoard[7][0] = new Rooke("WR2", "r", true, 'A', '1');
		chessBoard[7][1] = new Knight("WK2", "n", true, 'B', '1');
		chessBoard[7][2] = new Bishop("WB2", "b", true, 'C', '1');
		chessBoard[7][3] = new Queen("WQu", "q", true, 'D', '1');
		chessBoard[7][4] = new King("WKi", "k", true, 'E', '1');
		chessBoard[7][5] = new Bishop("WB1", "b", true, 'F', '1');
		chessBoard[7][6] = new Knight("WK1", "n", true, 'G', '1');
		chessBoard[7][7] = new Rooke("WR1", "r", true, 'H', '1');
		chessBoard[6][0] = new Pawn("WP8", "p", true, 'A', '2'); 
		chessBoard[6][1] = new Pawn("WP7", "p", true, 'B', '2');
		chessBoard[6][2] = new Pawn("WP6", "p", true, 'C', '2');
		chessBoard[6][3] = new Pawn("WP5", "p", true, 'D', '2');
		chessBoard[6][4] = new Pawn("WP4", "p", true, 'E', '2');
		chessBoard[6][5] = new Pawn("WP3", "p", true, 'F', '2');
		chessBoard[6][6] = new Pawn("WP2", "p", true, 'G', '2');
		chessBoard[6][7] = new Pawn("WP1", "p", true, 'H', '2');
	}
	
	/**
	 * Returns the array of Piece objects that is the chessboard.
	 * @return an array of Piece objects
	 */
	public Piece[][] getBoard(){
		return chessBoard;
	}
	
	/**
	 * Moves a game piece from its current position to a new position. This function
	 * integrates the Piece isMoveValid() function. 
	 * @param piece the Piece object that is to be moved
	 * @param newPosition the Coordinate position where the piece is to be moved
	 */
	public void movePiece(Piece piece, Coordinate newPosition){
		if(piece != null)
			if(piece.isMoveValid(newPosition, chessBoard)){
				Piece pieceCopy = piece;
				chessBoard[newPosition.getY()][newPosition.getX()] = pieceCopy;
				chessBoard[piece.getY()][piece.getX()] = null;
				piece.updatePosition(newPosition);
				System.out.println(piece.ID + " has been moved to " + newPosition);
			} else{
				System.out.println("Invalid move request for " + piece.ID);
			}
	}
	
	/**
	 * Returns the Piece object for a submitted Piece ID.
	 * @param ID The unique ID that every piece on the board has
	 * @return The Piece object to which the specified ID is assigned
	 */
	public Piece getPieceByID(String ID){
		for(Piece[] row : chessBoard)
			for(Piece piece : row)
				if(piece != null && piece.ID == ID)
					return piece;
		return null;
	}
	
	/**
	 * Returns the Piece object for a submitted Coordinate position.
	 * @param position as specified by a Coordinate object
	 * @return The Piece object at the Coordinate position specified
	 */
	public Piece getPieceByPos(Coordinate position){
		System.out.println("Getting piece at " + position);
		return chessBoard[position.getY()][position.getX()];
	}
	
}