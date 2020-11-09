package csc439team6.blackjack;

import csc439team6.blackjack.controllers.MainController;
import csc439team6.blackjack.models.AbstractPlayer;
import csc439team6.blackjack.views.CLIView;

/**
 * @author Arseny Poga, Cory Bradford
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        CLIView cliView = new CLIView();
        MainController mainController = new MainController(cliView);

        mainController.playBlackjack();
    }
}