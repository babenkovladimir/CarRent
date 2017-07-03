package init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Владимир on 28.06.2017.
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();

        // для работы аспектов, интерсепторов, исключений и др. необходим слушатель событий ContextLoaderListener
        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic dispatcher = servletContext
                .addServlet("DispatcherServlet", new DispatcherServlet(context));

        dispatcher.setLoadOnStartup(1);
        // Куда меппим DispatcherServlet
        dispatcher.addMapping("/");
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        ///вся інша конфігураційна інформація знаходиться в config
        context.setConfigLocation("config");
        return context;
    }

}
