/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package planetsudoai;

import configuration.parameter.CommandParameterParser;
import configuration.parameter.PrintHelpCommand;
import configuration.parameter.SetDebugModeCommand;
import java.io.IOException;
import java.util.logging.Level;
import logging.Logger;
import planetsudo.main.clc.SetLevelPathCommand;
import planetsudo.main.clc.SetStrategyPathCommand;
import planetsudo.main.clc.SetTeamPathCommand;

/**
 *
 * @author divine
 */
public class Main {

    /**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		CommandParameterParser.setProgramName("PlanetSudo");
		CommandParameterParser.addCommand(new PrintHelpCommand());
		CommandParameterParser.addCommand(new SetTeamPathCommand());
		CommandParameterParser.addCommand(new SetStrategyPathCommand());
		CommandParameterParser.addCommand(new SetDebugModeCommand());
		CommandParameterParser.addCommand(new SetLevelPathCommand());

		if (!CommandParameterParser.analyse(args)) {
			CommandParameterParser.printHelp();
			System.out.println("Exit...");
			System.exit(255);
		}

		new Logger(false);
		Logger.setPrintExceptionStackTrace(true);
		Logger.setDisplayExceptionDialog(true);

		new planetsudo.main.Main();
	}

}
