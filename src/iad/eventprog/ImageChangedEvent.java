/**
 * 
 */
package iad.eventprog;

import java.util.Date;

/**
 * @author benjamin guilbert
 *
 */
public class ImageChangedEvent extends java.util.EventObject {


	private String _name;
	private Date _date;

	/**
	 * Constructor
	 */
	public ImageChangedEvent(Object source, String name, Date date) {
		super(source);
		_name = name;
		_date = date;
	}

	public String name(){
		return _name;
	}
	
	public Date date(){
		return _date;
	}

}
