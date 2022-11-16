package controller;

import model.NhanVienModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
        ModelAndView modelAndView = new ModelAndView("/shownhanvien");
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

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("nhanvien",NhanVienService.getNhanVienModel(id));
        return modelAndView;
    }


    @PostMapping ("/edit/{id}")
    public ModelAndView edit(@ModelAttribute NhanVienModel nhanVienModel, @PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/nhanvien");
        NhanVienService.edit(NhanVienService.findIndexById(id), nhanVienModel);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        int index = NhanVienService.findIndexById(id);
        if (id >= 0) {
            NhanVienService.delete(index);
        }
        return "redirect:/nhanvien";
    }
}

