package zinsrechner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ZinsController {
   @GetMapping("/zins")
    public String index(Zinsdaten zinsdaten){
       return "zinsform";
   }

   @PostMapping("/zins")
    public String berchnen(@Valid Zinsdaten zinsdaten, BindingResult bindingResult, boolean tabelle, Model m){
       if (bindingResult.hasErrors()){
         return "zinsform";
      }
       System.out.println(tabelle);
       ZinsBerechnung zinsBerechnung = new ZinsBerechnung(zinsdaten);
       m.addAttribute("zinsdaten",zinsdaten);
       List<JahrKapital> jahrKapitalTabelle = zinsBerechnung.berechnen();
       m.addAttribute("jahrKapitalTabelle",jahrKapitalTabelle);
       m.addAttribute("endKapital",jahrKapitalTabelle.get(zinsdaten.zeit()-1).endKapital());
       m.addAttribute("tabelleAnzeigen",tabelle);
       return "zinsform";
   }
}
