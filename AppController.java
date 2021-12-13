package net.codejava;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	
	@Autowired
	private DriveRepository driveRepo;
	
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/logout")
	public String viewHomePageForLogout() {
		return "index";
	}
	
	@GetMapping("/SuccessAdminLogin")
	public String SuccessAdminLogin() {
		return "AdminLoginSuccess";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());	
		return "signup_form";
	}
	
	@GetMapping("/LoginAdmin")
	public String adminLogin(Model model) {
		model.addAttribute("user", new User());	
		return "AdminLogin";
	}
	
	@GetMapping("/SignIn")
	public String showLoginForm(Model model) {
		model.addAttribute("user", new UserLogin());
		return "StudentLogin";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		user.setIsAdmin("0");
		userRepo.save(user);
		return "register_success";
	}
	
	@PostMapping("/drive_register")
	public String processDriveRegister(Drive drive) {
		driveRepo.save(drive);
		return "drive_success_register";
	}
	
	
	@GetMapping("/driveRegister")
	public String showDriveRegister(Model model) {
		List<Drive> listDrive = driveRepo.findAll();
		model.addAttribute("listDrives", listDrive);
		return "DriveModification";
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAlLStudents();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/drives")
	public String listDrives(Model model) {
		List<Drive> listDrive = driveRepo.findAll();
		model.addAttribute("listDrives", listDrive);
		return "Drive";
	}
	
	@PostMapping("/UserSignIn")
	public String signIn(UserLogin userLogin,Model model) {
			return listDrives(model);
		
	}
	
	@GetMapping("/showUpdateDrive")
	public String showUpdateDriveDetailsPage(Drive drive,Model model) {
		System.out.println("drive----update"+drive.toString());
			return "DriveUpdateDetails";
	}
	
	@RequestMapping(path =  {"/drive/edit","/drive/edit/{id}"})
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) 
	{
		System.out.println("id---"+id);
		if (id.isPresent()) {
			 Optional<Drive> entity = driveRepo.findById(id.get());
			model.addAttribute("drive", entity);
		} else {
			model.addAttribute("drive", new Drive());
		}
		return "DriveUpdateDetails";
	}
	
	@RequestMapping(path = "/drive/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id) 
	{
		System.out.println("Deleting by drive ID :"+id);
		driveRepo.deleteById(id);
		return "redirect:/";
	}

	
	
}
