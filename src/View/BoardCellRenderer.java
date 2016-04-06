package View;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Board.Coordinate;

@SuppressWarnings("serial")
public class BoardCellRenderer extends DefaultTableCellRenderer {
	
	private ArrayList<Coordinate> possibleMoves = new ArrayList<Coordinate>();
	private ImageIcon test = new ImageIcon("resources/images/light_square.png");
	
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        setHorizontalAlignment(SwingConstants.CENTER);
        
        Color darkSquare = new Color(155, 155, 155);
        
        if(row % 2 == 0 && column % 2 == 1)
        	setBackground(darkSquare);
        	//setIcon(test);
        else if(row % 2 == 1 && column % 2 == 0)
        	setBackground(darkSquare);
        	//setIcon(test);
        else
        	setBackground(Color.WHITE);
        	//setIcon(test);

        
        for(Coordinate move : possibleMoves)
        	if(column == move.getX() && row == move.getY()){
        		setBackground(new Color(255, 51, 51, 50));
        		System.out.println("Highlighting (" + row + ", " + column + ")");
        	}
        
        if(hasFocus){
        	setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
        	System.out.println("hasFocus [array]: " + row + ", " + column);
        	System.out.println("hasFocus [coordinate]: " + column + ", " + row);
        }
        if(isSelected)
        	setBorder(new MatteBorder(2, 2, 2, 2, Color.BLUE));

        
        return this;
    }
    
    public void setPossibleMoves(ArrayList<Coordinate> possibleMoves){
    	this.possibleMoves = possibleMoves;
    }
}
