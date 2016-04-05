package Presenter;

import Model.Model;
import View.View;

public interface Presenter {
	Model getModel();
	void setModel(Model model);
	
	View getView();
	void setView(View view);
	
	void run();
}
