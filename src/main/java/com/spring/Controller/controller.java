package com.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.Entity.Expense;
import com.spring.Entity.Users;
import com.spring.Service.ExpenseService;
import com.spring.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class controller {

	@Autowired
	private AuthenticationManager auth;

	@Autowired
	private BCryptPasswordEncoder passencode;

	@Autowired
	private ExpenseService ExpenseService;
	@Autowired
	private UserService UserService;

	@GetMapping("/loginpage")
	public String loginPage() {
		return "login.jsp";
	}

	@GetMapping("/register")
	public String Register(Model model) {

		model.addAttribute("user", new Users());

		return "register.jsp";
	}

	@GetMapping("/addexp")
	public String Saveexpense(Model model) {
		model.addAttribute("exp", new Expense());
		return "expense.jsp";

	}

	@GetMapping("/update")
	public String getExpByuser(Model modle, @RequestParam Integer eid) {

		Expense exp = ExpenseService.findByid(eid);

		modle.addAttribute("exp", exp);
		return "updateExpense.jsp";

	}

	@PostMapping("/register")
	public String saveUser(Users user, Model model) {

		user.setPassword(passencode.encode(user.getPassword()));
		boolean save = UserService.save(user);

		if (save) {
			model.addAttribute("suceed", "Registered Sucessfully");
		} else {

			model.addAttribute("errormsg", "username " + user.getUserName() + "is already Registered");
		}
		return "login.jsp";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest req, Model model) {

		String un = req.getParameter("userName");
		String pwd = req.getParameter("password");

		UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(un, pwd);
		Authentication authentication = auth.authenticate(authtoken);

		if (authentication.isAuthenticated()) {

			HttpSession session = req.getSession(true);
			session.setAttribute("userName", un);
			return "welcomePage.jsp";
		} else {
			model.addAttribute("errmsg", "Invalid credentials");
			return "login.jsp";
		}

	}

	@PostMapping("/addexp")
	public String Saveexp(Model model, Expense expense, HttpServletRequest req) {

		HttpSession session = req.getSession(false);

		String userName = (String) session.getAttribute("userName");

		Users user = UserService.findByuserName(userName);

		expense.setUser(user);
		Integer id = ExpenseService.Save(expense);

		model.addAttribute("msg", "expense save with uer id = " + id);

		return "welcomePage.jsp";
	}

	@GetMapping("/Expenselist")
	public String getExpByuser(Model modle, HttpServletRequest req) {
		HttpSession session = req.getSession(false);

		String userName = (String) session.getAttribute("userName");

		Users user = UserService.findByuserName(userName);
		modle.addAttribute("exp", user.getExpenses());

		return "listexp.jsp";
	}

	@GetMapping("/updatelist")
	public String updateExpByuser(Model modle, HttpServletRequest req) {
		HttpSession session = req.getSession(false);

		String userName = (String) session.getAttribute("userName");

		Users user = UserService.findByuserName(userName);
		modle.addAttribute("exp", user.getExpenses());

		return "expenseList.jsp";

	}

	@PostMapping("/update")
	public String UpdateExpByuser(Model modle, Expense exp) {
		String msg = ExpenseService.updateExpense(exp);

		modle.addAttribute("msg", msg);
		return "welcomePage.jsp";

	}

	@GetMapping("/delete")
	public String DeleteExpense(@RequestParam Integer eid, Model model) {

		String msg = ExpenseService.Delete(eid);

		model.addAttribute("msg", msg);
		return "welcomePage.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		// for destroy session that we have created.

		return "login.jsp";

	}
}
