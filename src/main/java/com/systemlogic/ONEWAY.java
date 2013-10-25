package com.systemlogic;

import javax.annotation.Resource;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class ONEWAY {
	@Resource
	WebServiceContext context;
	@Oneway
	public void adding(int a, int b){
		int sum = a + b ;
		System.out.print(sum);
		ServletContext ctx = (ServletContext)context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		ctx.setAttribute("TempData", sum);
	}	
	public int returnAddResult(int d){
		ServletContext ctx = (ServletContext)context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		int sum = (Integer)ctx.getAttribute("TempData");
		sum = sum + d;
		System.out.print(sum);
		return sum ;
	}
}
