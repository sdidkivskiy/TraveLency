package org.TraveLency.security.controller;

import org.TraveLency.model.Role;
import org.TraveLency.repository.UserRepository;
import org.TraveLency.security.model.UserPrincipal;
import org.TraveLency.security.model.dto.SignInDto;
import org.TraveLency.security.model.dto.SignUpDto;
import org.TraveLency.model.User;
import org.TraveLency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserDetailsService userDetailsService;

    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailsService, UserRepository userRepository) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    //Sign-in form
    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public ModelAndView signInGET() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sign-in");
        return modelAndView;
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public ModelAndView signInPOST(@ModelAttribute("userDto") SignInDto signIn, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();

        HttpSession session = request.getSession(false);

        if(userRepository.existsByLoginOrEmailAndPassword(signIn.getLoginOrEmail(), signIn.getLoginOrEmail(), bCryptPasswordEncoder.encode(signIn.getPassword()))) {
            UserPrincipal userPrincipal = (UserPrincipal) userDetailsService.loadUserByUsername(signIn.getLoginOrEmail());
            session.setAttribute("login", userPrincipal.getLogin());

            if(userPrincipal.getRoleSet().contains(Role.ROLE_ADMIN)) {
                session.setAttribute("role", "ROLE_ADMIN");
            } else {
                session.setAttribute("role", "ROLE_USER");
            }

            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

    //Sign-up form
    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public ModelAndView signUpGET() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sign-up");
        return modelAndView;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ModelAndView signUpPOST(@ModelAttribute("userDto") SignUpDto signUpDto) {
        ModelAndView modelAndView = new ModelAndView();
;

        User user = new User();
        user.setLogin(signUpDto.getLogin());
        user.setPassword(bCryptPasswordEncoder.encode(signUpDto.getPassword()));
        user.setFirstname(signUpDto.getFirstName());
        user.setLastname(signUpDto.getLastName());
        user.setEmail(signUpDto.getEmail());
        Role userRole = Role.ROLE_USER;
        user.setRoleSet(Collections.singleton(userRole));

        userService.add(user);

        modelAndView.setViewName("redirect:/auth/sign-in");
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        HttpSession httpSession = request.getSession(false);
        httpSession.removeAttribute("login");
        httpSession.removeAttribute("role");

        modelAndView.setViewName("hotels");
        return modelAndView;
    }
}
