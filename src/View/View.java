package View;

import Presenter.Presenter;

public interface View {
	Presenter getPresenter();
	void setPresenter(Presenter presenter);
	
	void updateModelFromView();
	void updateViewFromModel();
	
	void open();
	void close();
}
