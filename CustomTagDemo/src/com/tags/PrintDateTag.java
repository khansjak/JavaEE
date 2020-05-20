package com.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintDateTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {

		getJspContext().getOut().write(
				"<h3> Current Date is " + new SimpleDateFormat("dd-mm-yyyy hh:mm:ss EEE").format(new Date()) + "</h3");
	}

}
