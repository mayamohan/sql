package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.CompanyDAO;

@Controller
public class CompanyController {
	CompanyDAO cdao = new CompanyDAO();

	
	@RequestMapping("frontpage.do")
	public ModelAndView FrontPage() {
    	ModelAndView mv = new ModelAndView();
		mv.setViewName("query.jsp");
		return mv;
	}
	
	@RequestMapping("process.do")
	public ModelAndView processData1(@RequestParam("data") String s) throws SQLException, ClassNotFoundException {
		ArrayList<ArrayList<String>> table = cdao.getQuery(s);
    	ModelAndView mv = new ModelAndView();
		mv.setViewName("view.jsp");
		mv.addObject("result", table);
		return mv;
	}
	@RequestMapping("update.do")
	public ModelAndView updateData(@RequestParam("data") String s) throws SQLException, ClassNotFoundException {
		int update = cdao.getUpdate(s);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("query.jsp");
		mv.addObject("result", update);
		return mv;
	}
	
	
}
