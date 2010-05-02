/*
 * Copyright (c) 2009 WiQuery team
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.odlabs.wiquery.ui.droppable;

import org.apache.wicket.markup.html.resources.JavascriptResourceReference;

/**
 * $Id: DroppableJavaScriptResourceReference.java 81 2009-05-28 20:05:12Z
 * lionel.armanet $
 * <p>
 * References the resource to apply draggable behavior on HTML components.
 * </p>
 * 
 * TODO RENAME
 * 
 * @author Lionel Armanet
 * @since 0.5
 */
public class DroppableJavaScriptResourceReference extends
		JavascriptResourceReference {
	// Constants
	/** Constant of serialization */
	private static final long serialVersionUID = 3704373328245392715L;
	
	/**
	 * Singleton instance.
	 */
	private static DroppableJavaScriptResourceReference instance = new DroppableJavaScriptResourceReference();;

	/**
	 * Builds a new instance of {@link DroppableJavaScriptResourceReference}.
	 */
	private DroppableJavaScriptResourceReference() {
		super(DroppableJavaScriptResourceReference.class, "ui.droppable.js");
	}

	/**
	 * Returns the {@link DroppableJavaScriptResourceReference} instance.
	 */
	public static DroppableJavaScriptResourceReference get() {
		return instance;
	}
}
