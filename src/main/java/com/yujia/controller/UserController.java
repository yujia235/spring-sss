package com.yujia.controller;

import com.yujia.model.ResponseInfo;
import com.yujia.pojo.User;
import com.yujia.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/test")
    public String test() {
        return "hello spring-sss";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseInfo login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> userList = userService.selectBySql(username, password);
        if (CollectionUtils.isEmpty(userList)) {
            return ResponseInfo.paramError("用户名或者密码错误");
        }
        // 把简易token放入session
        request.getSession().setAttribute("token", username + "/" + password);
        return ResponseInfo.success();
    }

    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public ModelAndView toList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/list");
        return mv;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseInfo<List<User>> findAllSortById() {
        return ResponseInfo.success(userService.findAllSortById());
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(Integer id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        User user = userService.findById(id);
        mv.addObject("user", user);
        mv.setViewName("/user/edit");
        return mv;
    }

    @RequestMapping(value = "/toCreate", method = RequestMethod.GET)
    public ModelAndView toCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/create");
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseInfo<User> create(User user) {
        userService.save(user);
        return ResponseInfo.success(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseInfo deleteById(Integer id) {
        userService.deleteById(id);
        return ResponseInfo.success();
    }
}
