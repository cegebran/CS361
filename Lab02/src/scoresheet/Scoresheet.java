package scoresheet;
public class Scoresheet {
	
	private class Frame {
		private int pins = 0;
		private int score = 0;
		private boolean countStrike = false;
		private boolean countSpare = false;
	}
	
	private int currentFrame;
	private Frame[] scoreSheet;
	private boolean firstThrow;
	
	public Scoresheet() {
		currentFrame = 1;
		scoreSheet = new Frame[10];
		for (int i = 0; i < 10; i++) {
			scoreSheet[i] = new Frame();
		}
		firstThrow = true;
	}
	
	/**
     * Retrieves the score from a specific frame.
     * 
     *
     * @param frame  Takes the number frame from which the score is drawn.
     * @return int   Returns the score for the given frame.
     */
	public int getFrameScore(int frame) {
		if (frame < 1 || frame > 10) {
			throw new RuntimeException();
		}
		
		return scoreSheet[frame -1].score;
	}
	
	/**
     * Retrieves the total score from all ten frames.
     * 
     *
     * @return int   Returns the total score for the thrower's game.
     */
	public int getTotalScore() {
		int totalScore = 0;
		for (int i = 0; i < 10; i++) {
			totalScore += scoreSheet[i].score;
		}
		
		return totalScore;
	}
	
	/**
     * Retrieves the number of the current frame.
     * 
     *
     * @return int   Returns the number for which frame is currently being thrown.
     */
	public int getCurrentFrame() {
		return currentFrame;
	}
	
	/**
     * Simulates a go at rolling the bowling ball.
     * 
     *
     * @param pins   Takes the number of pins knocked down on the simulated throw.
     */
	public void throwBall(int pins) {
		if (pins < 0 | pins > 10) {
			throw new RuntimeException();
		}
		if (currentFrame > 10) {
			throw new RuntimeException();
		}
		if (firstThrow == true && pins < 10) {
			firstThrow = false;
			scoreSheet[currentFrame - 1].pins += pins;
			scoreSheet[currentFrame - 1].score += pins;
			if (currentFrame > 1 && scoreSheet[currentFrame - 2].countSpare == true) {
				scoreSheet[currentFrame - 2].score += pins;
			}
			if (currentFrame > 1 && scoreSheet[currentFrame - 2].countStrike == true) {
				scoreSheet[currentFrame - 2].score += pins;
			}
			if (currentFrame > 2 && scoreSheet[currentFrame - 3].countStrike == true) {
				scoreSheet[currentFrame - 3].score += pins;
			}
		}
		else if (firstThrow == true && pins == 10) {
			scoreSheet[currentFrame - 1].pins += pins;
			scoreSheet[currentFrame - 1].score += pins;
			if (currentFrame < 9) {
				scoreSheet[currentFrame - 1].countStrike = true;
			}
			if (currentFrame > 1 && scoreSheet[currentFrame - 2].countSpare == true) {
				scoreSheet[currentFrame - 2].score += pins;
			}
			if (currentFrame > 1 && scoreSheet[currentFrame - 2].countStrike == true) {
				scoreSheet[currentFrame - 2].score += pins;
			}
			if (currentFrame > 2 && scoreSheet[currentFrame - 3].countStrike == true) {
				scoreSheet[currentFrame - 3].score += pins;
			}
			currentFrame++;
		}
		else if (firstThrow == false && pins + scoreSheet[currentFrame - 1].pins < 10) {
			firstThrow = true;
			scoreSheet[currentFrame - 1].pins += pins;
			scoreSheet[currentFrame - 1].score += pins;
			if (currentFrame > 1 && scoreSheet[currentFrame - 2].countSpare == true) {
				scoreSheet[currentFrame - 2].score += pins;
			}
			if (currentFrame > 1 && scoreSheet[currentFrame - 2].countStrike == true) {
				scoreSheet[currentFrame - 2].score += pins;
			}
			if (currentFrame > 2 && scoreSheet[currentFrame - 3].countStrike == true) {
				scoreSheet[currentFrame - 3].score += pins;
			}
			currentFrame++;
		}
		else if (firstThrow == false && pins + scoreSheet[currentFrame - 1].pins == 10) {
			firstThrow = true;
			scoreSheet[currentFrame - 1].pins += pins;
			scoreSheet[currentFrame - 1].score += pins;
			if (currentFrame < 10) {
				scoreSheet[currentFrame - 1].countSpare = true;
			}
			if (currentFrame > 1 && scoreSheet[currentFrame - 2].countSpare == true) {
				scoreSheet[currentFrame - 2].score += pins;
			}
			if (currentFrame > 1 && scoreSheet[currentFrame - 2].countStrike == true) {
				scoreSheet[currentFrame - 2].score += pins;
			}
			if (currentFrame > 2 && scoreSheet[currentFrame - 3].countStrike == true) {
				scoreSheet[currentFrame - 3].score += pins;
			}
			currentFrame++;
		}
	}
}
