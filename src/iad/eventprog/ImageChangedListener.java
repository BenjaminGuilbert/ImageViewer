package iad.eventprog;

import java.util.EventListener;

public interface ImageChangedListener extends EventListener {
	
	/**
     * Invoked when an image changing occurs.
     */
    public void imageChanged(ImageChangedEvent e);
}
