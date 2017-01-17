package de.apodznoev.angular.server;

import com.google.inject.Singleton;
import de.apodznoev.angular.dao.Dao;

import javax.inject.Inject;

/**
 * Created by apodznoev
 * date 17.01.2017.
 */
@Singleton
public class StuffServiceImpl implements StuffService {

    private Dao<String> dao;

    @Inject
    public StuffServiceImpl(Dao<String> dao) {
        this.dao = dao;
    }

    @Override
    public String getAll() {
        System.out.println("Requested to get All");
        String html = "<h2>All stuff</h2><ul>";
        for (String stuff : dao.getAll()) {
            html += "<li>" + stuff + "</li>";
        }
        html += "</ul>";
        return html;
    }

    @Override
    public String getById(String id) {
        System.out.println("Requested to get ID = " + id);
        String stuff = dao.getById(id);
        if (stuff == null) return notFound();
        else return "<html><body><div>" + stuff + "</div></body></html>";
    }

    private String notFound() {
        return "<html><body><div>Not Found</div></body></html>";
    }

}