package csc439team6.blackjack;

import csc439team6.blackjack.controllers.MainController;
import csc439team6.blackjack.views.CLIView;

import java.io.IOException;

/**
 * @author Arseny Poga, Cory Bradford
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws IOException {
        CLIView cliView = new CLIView();
        MainController mainController = new MainController(cliView);

        mainController.playBlackjack();
    }
}