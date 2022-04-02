package ospan.sale.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ospan.sale.User;
import ospan.sale.UserRepostitory;

import java.util.List;


    @Controller
    public class WebController {
        @Autowired
        UserRepostitory repostitory;

        @GetMapping("/")
        public String showUserList(Model model) {
            List<User> users =repostitory.findAll();
            model.addAttribute("users", users);
            return "index";
        }

        @PostMapping("/adduser")
        public String createUser(@ModelAttribute User user){
            addUser(user);
            return "redirect:/";
        }

        @PostMapping("/update/{id}")
        public String updateUser(@PathVariable("id") long id, User user) {
            updateUser(user);
            return "redirect:/";
        }

        @GetMapping("/delete/{id}")
        public String deleteUser(@PathVariable("id") long id) {
            deleteById(id);
            return "redirect:/";
        }

        @GetMapping("/signup")
        public String showSignUpForm(User user) {
            return "adduser";
        }

        @GetMapping("/edit/{id}")
        public String showUpdateForm(@PathVariable("id") long id, Model model) {
            User user = repostitory.getById(id);
            model.addAttribute("user", user);
            return "update";
        }

        private  void deleteById(long id) {repostitory.deleteById(id);}

        private void addUser(User newUser) {
            repostitory.save(newUser);
        }

        private  void updateUser(User updateUser) {

            User olduser=repostitory.getById(updateUser.getId());
            olduser.setName(updateUser.getName());
            olduser.setSurname(updateUser.getSurname());
            olduser.setEmail(updateUser.getEmail());
            repostitory.save(olduser);
        }

        private User getById(long id) {
            return repostitory.getById(id);
        }
    }


