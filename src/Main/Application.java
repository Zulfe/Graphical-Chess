package Main;

import Model.*;
import Presenter.*;
import View.*;

public class Application {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Model spModel = new SinglePlayerModel();
                Presenter spPresenter = new SinglePlayerPresenter();
                spPresenter.setModel(spModel);
                View spView = new SinglePlayerView();
                spPresenter.setView(spView);
    
                spPresenter.run();
            }
        });
    }
}
