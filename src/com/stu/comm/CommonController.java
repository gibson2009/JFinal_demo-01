package com.stu.comm;

import com.jfinal.core.Controller;

/**
 * CommonController
 */
public class CommonController extends Controller {
	
	public void index() {
		render("/comm-html/index.html");
	}
	
	public void signin() {
		render("/comm-html/signin.html");
	}
	
	public void test() {
		render("/comm-html/test.html");
	}

}
