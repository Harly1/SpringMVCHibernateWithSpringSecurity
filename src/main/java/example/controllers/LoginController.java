package example.controllers;

import example.models.Role;
import example.models.User;
import example.service_abstract.RoleService;
import example.service_abstract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = { "/admin"}, method = RequestMethod.GET)
    public String adminPage(ModelMap model) {

        return "admin";
    }

    @RequestMapping(value = { "/user"}, method = RequestMethod.GET)
    public String userPage(ModelMap model) {

        return "user";
    }

    @RequestMapping(value = { "/admin/list"}, method = RequestMethod.GET)
    public String userList(ModelMap model) {

            model.addAttribute("listUsers",userService.getAllUser());

        return "list";
    }

    @RequestMapping(value = { "/admin/add"}, method = RequestMethod.GET)
    public String userAddGet(ModelMap model) {
        return "add";
    }

    @RequestMapping(value = { "/admin/add"}, method = RequestMethod.POST)
    public String userAddPost(@RequestParam String username,@RequestParam String password,@RequestParam String role ) {

        Role newRole = new Role();
        newRole.setName(role);
        roleService.addRole(newRole);

        User newUser = new User();
        newUser.setLogin(username);
        newUser.setPassword(password);
        Set<Role> newUserRoles = new HashSet<>();
        newUserRoles.add(newRole);
        newUser.setRoles(newUserRoles);
        userService.addUser(newUser);

        return "redirect:/admin/list";
    }

    @RequestMapping(value = { "/admin/delete"}, method = RequestMethod.GET)
    public String userDelete(@RequestParam Long id) {
        User user = userService.getUserById(id);
        Set<Role> roles = user.getRoles();
        roles.forEach(a-> {
                    Long roleId = a.getId();
                    roleService.deleteRoleById(roleId);
        } );


        userService.deleteUserById(id);
        return "redirect:/admin/list";
    }

    @RequestMapping(value = { "/admin/edit"}, method = RequestMethod.GET)
    public String userEditGet(ModelMap model, @RequestParam Long id ) {
        User user = userService.getUserById(id);
        model.addAttribute("user",user);

        return "edit";
    }

    @RequestMapping(value = { "/admin/edit"}, method = RequestMethod.POST)
    public String userEditPost(
            ModelMap model,
            @RequestParam Long id,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String role) {

        User user = userService.getUserById(id);
        user.setLogin(username);
        user.setPassword(password);

        Set<Role> curRoles = user.getRoles();
        Set<Role> newSet = user.getRoles();

   /*     for(Role item : curRoles){
            if(!item.getName().equals(role)){
                Role newRole = new Role();
                newRole.setName(role);
                newSet.add(newRole);
                roleService.addRole(newRole);
            }
        }*/

        curRoles.forEach(a->{
            if(!a.getName().equals(role)){
                Role newRole = new Role();
                newRole.setName(role);
                newSet.add(newRole);
                roleService.addRole(newRole);
            }
        });

        user.setRoles(newSet);
        userService.updateUser(user);

        return "redirect:/admin/list";
    }


}
