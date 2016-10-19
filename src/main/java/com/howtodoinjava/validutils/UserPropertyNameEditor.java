package com.howtodoinjava.validutils;

import java.beans.PropertyEditorSupport;

public class UserPropertyNameEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text.contains("Mr.") || text.contains("Ms.")) {
			setValue(text);
		} else {
			text = "hello  my dear :" + text;
			setValue(text);
		}

	}

}
