package de.apodznoev.angular.dao;

import java.util.Arrays;
import java.util.List;

/**
 * Created by apodznoev
 * date 17.01.2017.
 */
public class StuffDao implements Dao<String> {
    @Override
    public List<? extends String> getAll() {
        return Arrays.asList( "Stuff", "Something else", "Whatever" );
    }

    @Override
    public String getById( String id ) {
        return id;
    }
}
