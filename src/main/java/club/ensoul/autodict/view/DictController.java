package club.ensoul.autodict.view;

import club.ensoul.autodict.jdbc.FetchData;
import club.ensoul.autodict.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class DictController {
    
    @Autowired
    private FetchData fetchData;
    
    @RequestMapping("/")
    public String index(Model model) {
        Map<String, List<Dict>> listMap = fetchData.query("mysql", "fz_aquatic_zf");
        model.addAttribute("dicts", listMap);
        return "index";
    }
    
}
