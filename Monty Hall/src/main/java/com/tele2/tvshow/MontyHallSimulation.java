package com.tele2.tvshow;

import com.tele2.tvshow.service.SimulationRunnerService;
import com.tele2.tvshow.service.impl.SimulationRunnerServiceImpl;

import java.util.Scanner;

public class MontyHallSimulation {


    public static void main(String[] args) {
        SimulationRunnerService service =
                new SimulationRunnerServiceImpl();

        System.out.println("Please Enter Number Of Simulations");
        Scanner sc = new Scanner(System.in);

        int numSimulations = sc.nextInt();

        System.out.println(service.runSimulation(numSimulations));
    }



}
