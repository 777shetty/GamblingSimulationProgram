package com.bridgelabz.gamblingsim;

public class Gambling {
	public static final int STAKE = 100;
	public static final int MAXIMUM_MATCHES_PER_DAY = 1000;
	public static int GAMBLER_STAKE = 100;
	public static int UPPER_LIMIT = GAMBLER_STAKE + (GAMBLER_STAKE*50)/100;
	public static int LOWER_LIMIT = GAMBLER_STAKE - (GAMBLER_STAKE*50)/100;
	public static final int DAY_BETTING_PRICE = 1;
	public static final int NO_OF_DAYS = 20;
	public boolean winOrLose() {
		if ((Math.random() * 100) > 50) {
			return true;
		} else {
			return false;

		}
	}
	public boolean resignStake() {

		if (winOrLose()) {
			System.out.println("Win: " + GAMBLER_STAKE);
			GAMBLER_STAKE += 1;
		} else {
			System.out.println("Lose: " + GAMBLER_STAKE);
			GAMBLER_STAKE -= 1;

		}
		if (GAMBLER_STAKE == UPPER_LIMIT || GAMBLER_STAKE == LOWER_LIMIT)
			return true;
		else
			return false;
	}
	public void returns() {

		int winningAmount = 0, lostAmount = 0;
		for (int i = 0; i < NO_OF_DAYS; i++) {
			GAMBLER_STAKE = 100;
			while (!this.resignStake());
			if(GAMBLER_STAKE == UPPER_LIMIT) {
				winningAmount += (UPPER_LIMIT - STAKE);
			} else {
				lostAmount += (STAKE - LOWER_LIMIT);
			}
		}
		System.out.println("Total amount won: "+winningAmount);
		System.out.println("Total amount lost: "+lostAmount);
		System.out.println("Returns: "+(winningAmount-lostAmount));


	}
	public void returnsPerMonth() {

		int totalAmount = 0, lostAmount = 0,noOfMatches=0;
		for (int i = 0; i < 30; i++) {
			GAMBLER_STAKE = 100;
			noOfMatches=0;
			while (!this.resignStake() && noOfMatches != MAXIMUM_MATCHES_PER_DAY) {
				noOfMatches++;
			}
			int amountAfterPlay = (GAMBLER_STAKE-STAKE);
			totalAmount += amountAfterPlay;
			if(amountAfterPlay>0) {
				System.out.println("Day "+(i+1)+": PROFIT \t- "+amountAfterPlay);
				} else {
					System.out.println("Day "+(i+1)+": LOSS \t- "+Math.abs(amountAfterPlay));
				}
		}
		if(totalAmount>0) {
		System.out.println("Net Gain (per month): $"+totalAmount);
		} else {
			System.out.println("Net Loss (per month): $"+Math.abs(totalAmount));
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Gambling Simulation!");
		Gambling gambler = new Gambling();
		System.out.println("Stake:" + gambler.STAKE);
		System.out.println("Per day betting price:" + gambler.DAY_BETTING_PRICE);
		gambler.returns();

	}
}
