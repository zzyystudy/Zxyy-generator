import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FreeMakerTest {

    @Test
    public void test() throws IOException, TemplateException {
        //创建freemaker Configuration对象 参数为FreeMaker版本号
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

        //指定模板文件所在根路径
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/template"));

        //设置字符集
        cfg.setDefaultEncoding("UTF-8");

        //创建模板对象加载指定模板
        Template template = cfg.getTemplate("demo.ftl");

        template.process(null, new java.io.StringWriter());

    }

}
