package com.bridgelabz.gamblingsim;

public class Gambling {
	static final int stake = 100;
	static final int dayBettingPrice = 1;

	public static void main(String[] args) {
		
	System.out.println("Welcome to Gambling Simulation!");
	Gambling gambler = new Gambling();
	System.out.println("Stake:"+ gambler.stake);
	System.out.println("Per day betting price:"+ gambler.dayBettingPrice);

}
	}

