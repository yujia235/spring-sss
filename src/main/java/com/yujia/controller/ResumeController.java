package com.yujia.controller;

import com.yujia.model.ResponseInfo;
import com.yujia.pojo.Resume;
import com.yujia.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private IResumeService resumeService;

    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public ModelAndView toList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/resume/list");
        return mv;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseInfo<List<Resume>> findAllSortById() {
        return ResponseInfo.success(resumeService.findAllSortById());
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(Long id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        Resume resume = resumeService.findById(id);
        mv.addObject("resume", resume);
        mv.setViewName("/resume/edit");
        return mv;
    }

    @RequestMapping(value = "/toCreate", method = RequestMethod.GET)
    public ModelAndView toCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/resume/create");
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseInfo<Resume> create(Resume resume) {
        resumeService.save(resume);
        return ResponseInfo.success(resume);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseInfo deleteById(Long id) {
        resumeService.deleteById(id);
        return ResponseInfo.success();
    }
}
