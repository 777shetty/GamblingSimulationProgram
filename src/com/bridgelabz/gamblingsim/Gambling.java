package com.bridgelabz.gamblingsim;

public class Gambling {
	public static final int STAKE = 100;
	public static int GAMBLER_STAKE = 100;
	public static final int DAY_BETTING_PRICE = 1;
	public boolean play() {

		if((Math.random()*100)>50) {
			System.out.println("Win");
			GAMBLER_STAKE += 1;
		}else {
			System.out.println("Lose");
			GAMBLER_STAKE -= 1;

		}
		if (GAMBLER_STAKE > 150 || GAMBLER_STAKE < 50)
			
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {

		System.out.println("Welcome to Gambling Simulation!");
		Gambling gambler = new Gambling();
		System.out.println("Stake:"+ gambler.STAKE);
		System.out.println("Per day betting price:"+ gambler.DAY_BETTING_PRICE);
		while (gambler.play());

	}
}


