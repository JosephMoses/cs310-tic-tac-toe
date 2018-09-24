package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeController {

    private TicTacToeModel model;
    private TicTacToeView view;
    private Scanner keyboard;
    
    /* CONSTRUCTOR */

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        
        /* Initialize model and view */

        this.model = model;
        this.view = view;
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);

    }

    public void controlModel() {
        
        /* Prompt player for next move using view's showNextMovePrompt() */
        
        view.showNextMovePrompt();
        
        /* Receive and validate input, which should be read at the keyboard as
           two integers, the row and the column (for example, "1 1" for the
           center square of a 3 x 3 grid).  Make mark if input is valid, or show
           error message using view's showInputError() if input is invalid. */
		int row;
		int col;
		row = keyboard.nextInt();
		col = keyboard.nextInt();
		
		/*could not call private methods isSquareMarked or isValidSquare directly
		   only public method that called both was makeMark which is boolean
		   theory: makeMark checks for square validity and emptiness before placing a mark.
		   that noted, calling it should validate input then make the players mark*/
		if (!(model.makeMark(row, col))) { 
			view.showInputError();
		}else {
			model.makeMark(row, col);
		}
		
    }

}