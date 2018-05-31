package club.ensoul.autodict.view;

import club.ensoul.autodict.jdbc.FetchData;
import club.ensoul.autodict.model.Dict;
import club.ensoul.autodict.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Controller
public class DictController {
    
    @Autowired
    private FetchData fetchData;
    
    // @RequestMapping("/")
    public String index(Model model) {
        Map<Table, List<Dict>> listMap = fetchData.query("mysql", "fz_aquatic_zf");
        model.addAttribute("dicts", listMap);
        return "index";
    }
    
}
