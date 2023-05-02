package practice;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyCustomTagHandlerSum  extends TagSupport {
	private int num1;
	private int num2;
	
	public int getNum1() {
		return num1;
	}

	public void setNum1(int a) {
		this.num1 = a;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int b) {
		this.num2 = b;
	}

	public int doStartTag() throws JspException {  
		
	    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    try{  
	     out.print(num1+num2);//printing date and time using JspWriter  
	    }catch(Exception e){System.out.println(e);}  
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
