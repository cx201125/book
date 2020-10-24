package com.chenxin.blog.controller;

import com.chenxin.blog.entity.Tag;
import com.chenxin.blog.entity.Type;
import com.chenxin.blog.service.TagServiceImpl;
import com.chenxin.blog.service.TypeServiceImpl;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admain")
public class AdmainTagController {
    @Autowired
    TagServiceImpl tagService;
    @GetMapping("/listtags")
    public String tags(Integer pageNum, Model model){
        if(pageNum==null){
            pageNum=1;
        }
        Page<Tag> byPage = tagService.findByPage(pageNum);
        model.addAttribute("page",byPage);
        return "admain/tags";
    }
    @PostMapping("/savetag")
    public String savetype(Tag tag, Model model, RedirectAttributes redirectAttributes){
        //校验类别有没有重复的名称
        Tag tl=tagService.getByName(tag);
        if(tl!=null){
            redirectAttributes.addFlashAttribute("hint","提示：已经存在该标签");
            //model.addAttribute("hint","提示：已经存在该博客类别");
            return "redirect:/admain/tags-input";
        }
        //保存类别
        int i=tagService.saveTag(tag);
        if(i<1){
            redirectAttributes.addFlashAttribute("hint","保存失败");
        }else{
            redirectAttributes.addFlashAttribute("hint","保存成功");
        }

        return "redirect:/admain/listtags";
    }
    @GetMapping("/tags-input")
    public String taginputpage(Long id,Model model){
        Tag tag1 =null;
     if(id!=null) {
     tag1=tagService.findById(id);
    }
        model.addAttribute("tag", tag1);
        return "admain/tags-input";
    }
    @PostMapping("/edittag")
    public String tags(Tag tag,RedirectAttributes redirectAttributes){

        int i=tagService.editTag(tag);
        if(i<1){
            redirectAttributes.addFlashAttribute("hint","更新失败");
        }else{
            redirectAttributes.addFlashAttribute("hint","更新成功");
        }

        return "redirect:/admain/listtags";
    }

    @GetMapping("/removetag")
    public String removetag(Long id,Model model, RedirectAttributes redirectAttributes){
        int i=tagService.removeTag(id);

        if(i<1){
            redirectAttributes.addFlashAttribute("hint","删除失败");
        }else{
            redirectAttributes.addFlashAttribute("hint","删除成功");
        }
        redirectAttributes.addFlashAttribute("pageNumber");
        return "redirect:/admain/listtags";
    }

}
