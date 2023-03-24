package com.tele2.tvshow.service;

import com.tele2.tvshow.dto.SimulationResult;
import com.tele2.tvshow.service.impl.SimulationRunnerServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationRunnerServiceTest {

    @Test
    public void testRunSimulation() {
        int numSimulations = 1000;
        SimulationResult result = new SimulationRunnerServiceImpl().runSimulation(numSimulations);

        // Check that the number of simulations run matches the input
        assertEquals(numSimulations, result.numSimulations());

        // Check that the number of switch wins and stay wins is greater than or equal to 0
        assertTrue(result.switchWins() >= 0);
        assertTrue(result.stayWins() >= 0);

        // Check that the switchWin & stayWin are not equal & switchWin > stayWin
        assertNotEquals( result.switchWins() , result.stayWins());
        assertTrue( result.switchWins() > result.stayWins());
    }

}
