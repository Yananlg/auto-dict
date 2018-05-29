package club.ensoul.autodict.runner;

import club.ensoul.autodict.jdbc.FetchData;
import club.ensoul.autodict.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.IOException;
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
        applicationArguments.getOptionValues("db").forEach(s -> System.out.println(s));
        applicationArguments.getOptionNames().forEach(s -> System.out.println(s));
    
        System.out.println("========================================================");
        
        // ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        // resolver.setPrefix("templates/");//模板所在目录，相对于当前classloader的classpath。
        // resolver.setSuffix(".html");//模板文件后缀
        // TemplateEngine templateEngine = new TemplateEngine();
        // templateEngine.setTemplateResolver(resolver);
        //
        // Map<String, List<Dict>> listMap = fetchData.query("mysql", "fz_aquatic_zf");
        // //构造上下文(Model)
        // Context context = new Context();
        // context.setVariable("dicts", listMap);
        //
        // //渲染模板
        // FileWriter write = null;
        // try {
        //     write = new FileWriter("result.html");
        // } catch(IOException e) {
        //     e.printStackTrace();
        // }
        // templateEngine.process("index", context, write);
       }
    
    
}
