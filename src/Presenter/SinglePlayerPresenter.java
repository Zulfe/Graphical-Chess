package Presenter;

import Model.*;
import View.*;

public class SinglePlayerPresenter implements Presenter {

	private Model singlePlayerModel;
	private View singlePlayerView;
	
	public SinglePlayerPresenter(){
		
	}
	
	@Override
	public Model getModel() {
		return singlePlayerModel;
	}

	@Override
	public void setModel(Model model) {
		singlePlayerModel = model;
		
	}

	@Override
	public View getView() {
		return singlePlayerView;
	}

	@Override
	public void setView(View view) {
		singlePlayerView = view;
	}
	
	public void setOnMultiplayer(Runnable onMultiplayer){
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		singlePlayerView.setPresenter(this);
		singlePlayerView.updateViewFromModel();
		singlePlayerView.open();
	}

}
