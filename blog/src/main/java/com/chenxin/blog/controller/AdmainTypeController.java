package com.chenxin.blog.controller;

import com.chenxin.blog.entity.Type;
import com.chenxin.blog.service.TypeServiceImpl;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admain")
public class AdmainTypeController {
    @Autowired
    TypeServiceImpl typeService;
    @GetMapping("/listtypes")
    public String types(Integer pageNum, Model model){
        int i=1;
        if(pageNum!=null){
            i=pageNum;

        }
        Page<Type> byPage = typeService.findByPage(i);
        model.addAttribute("page",byPage);
        return "admain/types";
    }
    @PostMapping("/savetype")
    public String savetype(Type type, Model model, RedirectAttributes redirectAttributes){
        //校验类别有没有重复的名称
        Type tl=typeService.getByName(type);
        if(tl!=null){
            redirectAttributes.addFlashAttribute("hint","提示：已经存在该博客类别");
            //model.addAttribute("hint","提示：已经存在该博客类别");
            return "redirect:/admain/types-input";
        }
        //保存类别
        int i=typeService.saveType(type);
        if(i<1){
            redirectAttributes.addFlashAttribute("hint","保存失败");
        }else{
            redirectAttributes.addFlashAttribute("hint","保存成功");
        }

        return "redirect:/admain/listtypes";
    }
    @GetMapping("/types-input")
    public String typeinputpage(Long id,Model model){
        Type type1 =null;
     if(id!=null) {
     type1=typeService.findById(id);
    }
        model.addAttribute("type", type1);
        return "admain/types-input";
    }
    @PostMapping("/edittype")
    public String types(Type type,RedirectAttributes redirectAttributes){

        int i=typeService.editType(type);
        if(i<1){
            redirectAttributes.addFlashAttribute("hint","更新失败");
        }else{
            redirectAttributes.addFlashAttribute("hint","更新成功");
        }

        return "redirect:/admain/listtypes";
    }

    @GetMapping("/removetype")
    public String removetype(Long id,Model model, RedirectAttributes redirectAttributes){
        int i=typeService.removeType(id);

        if(i<1){
            redirectAttributes.addFlashAttribute("hint","删除失败");
        }else{
            redirectAttributes.addFlashAttribute("hint","删除成功");
        }
        redirectAttributes.addFlashAttribute("pageNumber");
        return "redirect:/admain/listtypes";
    }

}
