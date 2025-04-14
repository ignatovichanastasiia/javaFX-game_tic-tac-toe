package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/*
 * Game controller from javaFX GUI. 
 * 
 */
public class Controller {
	@FXML
	private ImageView rock;
	@FXML
	private ImageView scissors;
	@FXML
	private ImageView paper;
	@FXML
	private ImageView gameMonitor;
	@FXML
	private ImageView playerMoveImg;
	@FXML
	private ImageView computerMoveImg;
	@FXML
	private ImageView ImgVstart;
	@FXML
	private Label gameInfo;
	@FXML
	private Label playerScore;
	@FXML
	private Label computerScore;
	@FXML
	private Label timeNumber;
	@FXML
	private Label newGame;

	private Image plMoveImg;
	private Image comMoveImg;
	private int computerScoreInt = 0;
	private int playerScoreInt = 0;
	private int time = 4;

	/*
	 * Click from rock-button rock == 1
	 * 
	 */
	@FXML
	public void rockClick(MouseEvent e) {
		System.out.println("Rock!");
		makeMove(1);
	}

	/*
	 * Click from scissors-button scissors == 3
	 * 
	 */
	@FXML
	public void scissorsClick(MouseEvent e) {
		System.out.println("Scissors!");
		makeMove(3);
	}

	/*
	 * Click from paper-button rock == 2
	 * 
	 */
	@FXML
	public void paperClick(MouseEvent e) {
		System.out.println("Paper!");
		makeMove(2);
	}

	@FXML
	public void clickToStart(MouseEvent e) {
		System.out.println("New game!");
		Image playerMoveStarter = new Image(getClass().getResourceAsStream("fon-jelt.jpg"));
		Image computerMoveStarter = new Image(getClass().getResourceAsStream("fon-feo.jpg"));
		playerMoveImg.setImage(playerMoveStarter);
		computerMoveImg.setImage(computerMoveStarter);
		playerScoreInt = 0;
		computerScoreInt = 0;
		playerScore.setText("" + playerScoreInt);
		System.out.println("Change score 1");
		computerScore.setText("" + computerScoreInt);
		System.out.println("Change score 2");
		time = 0;
		timeNumber.setText("Time: " + time);
		gameInfo.setText("Choice now!");
	}

	public void makeMove(int move) {
		timeNumber.setText("Time: " + (++time));
		setPlayerMoveImg(move);
		int move2 = Integer.valueOf(getRandom());
		setComputerMoveImg(move2);
		int res = getResultOfMove(move, move2);
		String resText = takeResultOfMove(res);
		if (time == 3) {
			if (playerScoreInt > computerScoreInt) {
				gameInfo.setText("You win!");
			}
			if (playerScoreInt < computerScoreInt) {
				gameInfo.setText("Computer win!");
			}
			if (playerScoreInt == computerScoreInt) {
				gameInfo.setText("Dead heat! Try new game!");
			}
			return;
		}
		if(time>3) {
			gameInfo.setText("Click new game!");
			return;
		}
		gameInfo.setText(resText + "\nMake choose!");
	}

	public void error() {
		gameInfo.setText("Error game!");
	}

	public void setPlayerMoveImg(int move) {
		if (move == 1) {
			plMoveImg = new Image(getClass().getResourceAsStream("kamen-komp.jpg"));
		}
		if (move == 2) {
			plMoveImg = new Image(getClass().getResourceAsStream("bumaga_komp.jpg"));
		}
		if (move == 3) {
			plMoveImg = new Image(getClass().getResourceAsStream("nojn_komp.jpg"));
		}
		if (move == 0) {
			error();
		}
		playerMoveImg.setImage(plMoveImg);
	}

	public void setComputerMoveImg(int move) {
		if (move == 1) {
			comMoveImg = new Image(getClass().getResourceAsStream("kamen-us.jpg"));
		}
		if (move == 2) {
			comMoveImg = new Image(getClass().getResourceAsStream("bumaga_us.jpg"));
		}
		if (move == 3) {
			comMoveImg = new Image(getClass().getResourceAsStream("nojn_us.jpg"));
		}
		if (move == 0) {
			error();
		}
		computerMoveImg.setImage(comMoveImg);
	}

	public String takeResultOfMove(int winner) {
		String win = new String();
		if (winner == 1) {
			playerScoreInt += 10;
			playerScore.setText("" + playerScoreInt);
			win = "You +10!";
		}
		if (winner == 2) {
			computerScoreInt += 10;
			computerScore.setText("" + computerScoreInt);
			win = "Computer +10!";
		}
		return win;

	}

	private int getRandom() {
		return (int) (Math.random() * 3) + 1;
	}

	private int getResultOfMove(int first, int second) {
		if (first == 1 && second == 1)
			return 0;
		if (first == 1 && second == 2)
			return 2;
		if (first == 1 && second == 3)
			return 1;

		if (first == 2 && second == 1)
			return 1;
		if (first == 2 && second == 2)
			return 0;
		if (first == 2 && second == 3)
			return 2;

		if (first == 3 && second == 1)
			return 2;
		if (first == 3 && second == 2)
			return 1;
		if (first == 3 && second == 3)
			return 0;
		return 0;
	}
}
