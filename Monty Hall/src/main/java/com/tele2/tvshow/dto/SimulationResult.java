package com.tele2.tvshow.dto;

public record SimulationResult(int numSimulations, int switchWins, int stayWins){
    @Override
    public String toString() {
        return "Number of simulations =  "+ numSimulations +"\n"
                + "Number of times staying wins = " + switchWins +"\n"
                + "Number of times switching wins: " + switchWins +"\n"
                + "Winning probability if staying: " + ((double) stayWins / numSimulations) +"\n"
                + "Winning probability if switching: " + ((double) switchWins / numSimulations) +"\n"
                + "Switching gives a better chance of winning: " + (switchWins > stayWins);
    }
}
