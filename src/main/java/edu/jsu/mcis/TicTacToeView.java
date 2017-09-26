package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeView extends JPanel implements ActionListener {
    
    TicTacToeModel model;

    private JButton[][] squares;
    private JPanel squaresPanel;
    private JLabel resultLabel;

    public TicTacToeView(TicTacToeModel model) {

        this.model = model;

        int width = model.getWidth();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        squares = new JButton[width][width];
        squaresPanel = new JPanel(new GridLayout(width,width));
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        
        
        /* INSERT CODE HERE */
		   for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                squares[i][j] = new JButton();
                squares[i][j].setName("Square"+i+j);
                squares[i][j].addActionListener(this);
                squares[i][j].setPreferredSize(new Dimension(64, 64));
                squaresPanel.add(squares[i][j]);
            }
        }
        
        add(squaresPanel);
        add(resultLabel);
        
        resultLabel.setText("Welcome to Tic-Tac-Toe!");

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        String name = ((JButton) event.getSource()).getName();
     

        /* INSERT CODE HERE */
		int r = Character.getNumericValue(name.charAt(6));
        int c = Character.getNumericValue(name.charAt(7));
           
        /* Call makeMark() to place the mark in the Model */
        
        /* INSERT CODE HERE */
		model.makeMark(r, c);

        

        updateSquares();

        /* Clear the "showResult" label at the bottom of the View */
        
        showResult(" ");
        
  
           
        /* INSERT CODE HERE */
		if(model.isGameover()){
			showResult(model.getResult().toString());
			for(int i=0; i < model.getWidth(); i++){
				for(int j=0; j < model.getWidth(); j++){
					squares[i][j].setEnabled(false);
				}
			}
			
		}
				
        
    }
        
    public void updateSquares() {

        /* INSERT CODE HERE */
		for( int i = 0; i < model.getWidth(); i++){
			for(int j = 0; j < model.getWidth(); j++){
				squares[i][j].setText(model.getMark(i , j).toString());
			}
		}
			

    }
        
    public void showResult(String message) {
        resultLabel.setText(message);
    }

}

