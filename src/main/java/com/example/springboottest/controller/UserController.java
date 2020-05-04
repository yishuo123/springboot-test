package com.example.springboottest.controller;

import com.example.springboottest.anno.WebLogger;
import com.example.springboottest.model.User;
import com.example.springboottest.service.UserService;
import com.example.springboottest.util.BaseResult;
import com.example.springboottest.util.Page;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制层
 */
//@RestController
@Controller
@RequestMapping("/user")
public class UserController extends BaseResult {

    private Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("/selectAll")
    @ResponseBody
    public Page<Map<String,Object>> selectAll(User user,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer rows){

        Page<Map<String,Object>> pages  = new Page<Map<String, Object>>();

        try {

            Map<String,Object> map = getMapParams(user,page,rows);

            // 从数据库中查询
            pages = userService.selectAll(map);

            pages.setPageIndex(page);
            pages.setMaxResult(rows);

        }catch (Exception e){
            log.error("selectAll error" , e);
        }
        return pages;

    }

    private Map<String, Object> getMapParams(User user, Integer page, Integer rows){

        Map<String, Object> params = new HashMap<String, Object>();

        if(user != null){
            if(!user.getName().equals("")){
                params.put("name", "%"+ user.getName() +"%");
            }
        }

        params.put("page", (page-1) * rows);
        params.put("rows", rows);

        return params;

    }


    @WebLogger("登录的逻辑层")
    @RequestMapping("/add")
    @ResponseBody
    public BaseResult add(){
        BaseResult baseResult = new BaseResult();
        baseResult.setState(BaseResult.MESSAGE_ERROR);
        try{
            // 执行完成

            baseResult.setState(BaseResult.MESSAGE_ERROR);

        }catch (Exception e){
        log.error("add error " , e);
        }
        return baseResult;
    }


    @RequestMapping("/findAll")
    public void findAll(){
        List<User> userList = userService.findAll();
        System.out.println(userList);
    }

    /**
     * 拦截后跳转的页面
     * @return
     */
    @RequestMapping("/tologin")
    public String tologin(){return "user/info";}

    /**
     * 用户登录跳转的也面
     * @return
     */
    @RequestMapping("/login")
    public String findUserInfo() { return "user/login";}

    /**
     * 用户添加
     * @return
     */
    @RequestMapping("/insert")
    public String insert(){
        return "user/insert";
    }

    /**
     * 用户修改
     * @return
     */
    @RequestMapping("/update")
    public String update(){
        return "user/update";
    }

    /**
     * 未授权跳转的页面
     * @return
     */
    @RequestMapping("/noAuthc")
    public String noAuthc(){
        return "user/noAuthc";
    }

    @RequestMapping("/loginInfo")
    public String loginInfo(String name , String password, Model model){

        /**
         * 使用Shiro  认证操作
         */
        Subject subject = SecurityUtils.getSubject();

        // 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);

        try {

            subject.login(token); //登录成功跳转到页面的路径
            return "user/login"; // 页面的路径
        } catch (UnknownAccountException e) {
//            e.printStackTrace();
            //用户名不存在
            model.addAttribute("msg","用户名错误");
            return "user/info";
        }catch (IncorrectCredentialsException e){
            //密码错误
            model.addAttribute("msg","密码错误");
            return "user/info";
        }

    }


    /**
     * 导入
     * @param myFile
     * @return
     */
    @RequestMapping(value="/importExcel",method= RequestMethod.POST)
    public String importExcel(@RequestParam("myfile") MultipartFile myFile) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Integer num = userService.importExcel(myFile);
        } catch (Exception e) {
            modelAndView.addObject("msg", e.getMessage());
            return "index";
        }
        modelAndView.addObject("msg", "数据导入成功");

        return "index";
    }

    /**
     * 导出
     * @param response
     */
    @RequestMapping(value="/exportExcel",method=RequestMethod.GET)
    public void exportExcel(HttpServletResponse response) {
        try {
            userService.exportExcel(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
