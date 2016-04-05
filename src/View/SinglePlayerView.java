package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Board.Coordinate;
import Piece.Piece;
import Presenter.Presenter;

@SuppressWarnings("serial")
public class SinglePlayerView extends JFrame implements View {

	private Presenter singlePlayerPresenter;
	
	private final int SQUARE_CELL = 80;
	private BoardCellRenderer customRender = new BoardCellRenderer();
	
	private JFrame frame;
	private JPanel gamePanel;
	private JTextField textBox;
	private BoardTable gameBoard;
	
	private Coordinate movePiece;
	private Coordinate movePosition;
	
	public SinglePlayerView(){
		initComponents();
	}
	
	public void initComponents(){
		frame = new JFrame();
		gamePanel = new JPanel();
		gameBoard = new BoardTable(){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		textBox = new JTextField(40);
		
		//adjust the chessboard's look
		for(int i = 0; i < 8; i++){
			gameBoard.getColumnModel().getColumn(i).setMinWidth(SQUARE_CELL);
			gameBoard.getColumnModel().getColumn(i).setPreferredWidth(SQUARE_CELL);
			gameBoard.getColumnModel().getColumn(i).setMaxWidth(SQUARE_CELL);
			gameBoard.getColumnModel().getColumn(i).setCellRenderer(customRender);
		}
		gameBoard.setRowHeight(SQUARE_CELL);
		gameBoard.setBorder(BorderFactory.createEmptyBorder());
		gameBoard.setIntercellSpacing(new Dimension(0, 0));
		
		//change the font to the piece font
		try {
			gameBoard.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/MAYAFONT.TTF")).deriveFont(Font.PLAIN, 70));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gameBoard.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gameBoard.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
					spacePressed();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//adjust the panel's look
		gamePanel.setBackground(new Color(112, 128, 144));
		
		//put the pieces on the board
		//updateViewFromModel();
		
		//fit everything together
		gamePanel.add(gameBoard);
		gamePanel.add(textBox);
		//gamePanel.add(multiplayer);
		frame.add(gamePanel);
		
		frame.setMinimumSize(new Dimension(SQUARE_CELL*9, SQUARE_CELL*9));
		frame.setVisible(true);
	}
	
	@Override
	public Presenter getPresenter() {
		return singlePlayerPresenter;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		singlePlayerPresenter = presenter;
	}

	@Override
	public void updateModelFromView() {
		getPresenter().getModel().getBoard().movePiece(getPresenter().getModel().getBoard().getPieceByPos(movePiece), movePosition);
		updateViewFromModel();
	}

	@Override
	public void updateViewFromModel() {
		Piece[][] pieceArray;
		for(int i = 0; i < (pieceArray = getPresenter().getModel().getPieceArray()).length; i++)
			for(int k = 0; k < pieceArray[i].length; k++)
				if(pieceArray[i][k] != null)
					gameBoard.setValueAt(pieceArray[i][k].getIcon(), i, k);
				else
					gameBoard.setValueAt("", i, k);
	}

	private void spacePressed(){
		if(movePiece == null){
			if(getPresenter().getModel().getBoard().getPieceByPos(new Coordinate(gameBoard.getSelectedColumn(), gameBoard.getSelectedRow())) != null){
				System.out.println("Selected piece position: " + gameBoard.getSelectedRow() + ", " + gameBoard.getSelectedColumn());
				movePiece = new Coordinate(gameBoard.getSelectedColumn(), gameBoard.getSelectedRow());
				textBox.setText("Player has selected " + singlePlayerPresenter.getModel().getBoard().getPieceByPos(movePiece).ID + " at (" + movePiece.getGameX() + ", " + movePiece.getGameY() + ")");
			}
		} else{
			System.out.println("Selected move position: " + gameBoard.getSelectedRow() + ", " + gameBoard.getSelectedColumn());
			movePosition = new Coordinate(gameBoard.getSelectedColumn(), gameBoard.getSelectedRow());
			textBox.setText("Player has moved " + getPresenter().getModel().getBoard().getPieceByPos(movePiece).ID + " from (" + movePiece.getGameX() + ", " + movePiece.getGameY() + ") to (" + movePosition.getGameX() + ", " + movePosition.getGameY() + ")");
			updateModelFromView();
			movePiece = null;
			movePosition = null;
		}
	}
	
	@Override
	public void open() {
		setVisible(true);
	}

	@Override
	public void close() {
		setVisible(false);
	}
	
}
