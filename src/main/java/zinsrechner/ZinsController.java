package zinsrechner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class ZinsController {
   @GetMapping("/")
    public String index(Zinsdaten zinsdaten){
       return "zinsform";
   }

   @PostMapping("/zins")
    public String berchnen(@Valid Zinsdaten zinsdaten, BindingResult bindingResult, boolean tabelle, Model m ){
       if (bindingResult.hasErrors()){
         return "zinsform";
      }
       m.addAttribute("zinsdaten", zinsdaten);
       System.out.println(zinsdaten);
       System.out.println(tabelle);
       return "zinsform";
   }
}
