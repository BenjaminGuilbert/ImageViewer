package iad.eventprog;

public class LogImageChanged implements ImageChangedListener{

	
	
	public LogImageChanged() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void imageChanged(ImageChangedEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.name() + " : " + e.date());
	}

}
