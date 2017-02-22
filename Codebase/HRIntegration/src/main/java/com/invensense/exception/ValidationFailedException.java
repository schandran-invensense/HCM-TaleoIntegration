/**
 * 
 */
package com.invensense.exception;

/**
 * @author Sumitha
 *
 */

public class ValidationFailedException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationFailedException(String vfEx)
	{
		super(vfEx);
	}
}
