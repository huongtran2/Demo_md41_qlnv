package controller;

import model.NhanVienModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.NhanVienService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class NhanVienController {
    @Autowired
    NhanVienService nhanVienService;

    @GetMapping("/nhanvien")
    public ModelAndView getALl(){
        ModelAndView modelAndView = new ModelAndView("shownhanvien");
        modelAndView.addObject("nhanvienshow",nhanVienService.nhanVienModels);
        return modelAndView;
    }

  @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/create");
        return modelAndView;
    }
    @PostMapping("/create")
    public void save(@ModelAttribute NhanVienModel nhanVienModel, HttpServletRequest request, HttpServletResponse response) throws IOException {
        nhanVienService.add(nhanVienModel);
        response.sendRedirect("/nhanvien");
    }


    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("nhanvienshow",NhanVienService.getNhanVienModel(id));
        return modelAndView;
    }


    @PostMapping ("/edit")
    public ModelAndView edit(@ModelAttribute NhanVienModel nhanVienModel, @RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/nhanvien");
        NhanVienService.edit(id, nhanVienModel);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        int index = NhanVienService.findIndexById(id);
        if (index >= 0) {
            NhanVienService.delete(index);
        }
        return "redirect:/nhanvien";
    }
}

