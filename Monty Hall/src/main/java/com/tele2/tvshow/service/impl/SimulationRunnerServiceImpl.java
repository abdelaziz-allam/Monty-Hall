package com.tele2.tvshow.service.impl;

import com.tele2.tvshow.dto.SimulationResult;
import com.tele2.tvshow.game.Game;
import com.tele2.tvshow.model.GameSettings;
import com.tele2.tvshow.service.SimulationRunnerService;

public class SimulationRunnerServiceImpl implements SimulationRunnerService {

    @Override
    public SimulationResult runSimulation(int numSimulations) {
            int stayWins = 0;
            int switchWins = 0;

            for (int i = 0; i < numSimulations; i++) {
                Game game = new Game();
                GameSettings settings = game.getSettings();
                // select random number each iteration
                int chosenBoxIndex = settings.getRandom().nextInt(GameSettings.NUMBER_OF_BOXES);
                game.pickBox(chosenBoxIndex);
                game.openOtherBox();

                // get boolean randomly to represent player selection
                boolean switchChoice = settings.getRandom().nextBoolean();

                // switch in case of decision is true
                if (switchChoice) {
                    game.switchBox();
                }

                // check if the current chosen box hasMoney exist
                if (game.hasWon()) {
                    //Increment switch choice otherwise che
                    if (switchChoice) {
                        switchWins++;
                    } else {
                        stayWins++;
                    }
                }
            }
            return new SimulationResult(numSimulations,switchWins,stayWins);

    }

}
