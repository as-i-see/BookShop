package dism3mb3r.shop.model.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    private UserService userService;
    @Value("${error.message}")
    private String errorMessage;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getLoginPage(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap modelMap, HttpServletRequest request, @ModelAttribute("user") User user) {
        if (userService.checkCredentials(user))
            return "redirect:/books";
        modelMap.addAttribute("errorMessage", errorMessage);
        return "login";
    }
}
