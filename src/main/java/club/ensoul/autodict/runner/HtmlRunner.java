package club.ensoul.autodict.runner;

import club.ensoul.autodict.jdbc.FetchData;
import club.ensoul.autodict.model.Dict;
import club.ensoul.autodict.model.Table;
import club.ensoul.autodict.util.JarToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

@Component
@Order(value = 1)
public class HtmlRunner implements CommandLineRunner {
    
    @Autowired
    private FetchData fetchData;
    
    @Override
    public void run(String... args) {
        
        ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
        String db = applicationArguments.getOptionValues("db").get(0);
        String dialect = applicationArguments.getOptionValues("dialect").get(0);
        
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");//模板所在目录，相对于当前classloader的classpath。
        resolver.setSuffix(".html");//模板文件后缀
        resolver.setCharacterEncoding("UTF-8");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        
        Map<Table, List<Dict>> listMap = fetchData.query(dialect, db);
        //构造上下文(Model)
        Context context = new Context();
        context.setVariable("dicts", listMap);
        
        //渲染模板
        BufferedWriter writer = null;
        try {
            String filePath = JarToolUtil.springBoot() + "/result.html";
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        templateEngine.process("index", context, writer);
    }
    
    
}
