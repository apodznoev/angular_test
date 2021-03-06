package de.apodznoev.angular;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import de.apodznoev.angular.dao.Dao;
import de.apodznoev.angular.dao.StuffDao;

/**
 * Created by apodznoev
 * date 17.01.2017.
 */
public class Main extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        final ResourceConfig rc = new PackagesResourceConfig( "de.apodznoev.angular" );

        return Guice.createInjector( new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(new TypeLiteral<Dao<String>>() {}).to(StuffDao.class);

                for ( Class<?> resource : rc.getClasses() ) {
                    System.out.println( "Binding resource: " + resource.getName() );
                    bind( resource );
                }

                serve( "/rest/*" ).with( GuiceContainer.class );
            }
        } );
    }
}