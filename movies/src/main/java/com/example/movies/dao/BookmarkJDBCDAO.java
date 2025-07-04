package com.example.movies.dao;

import com.example.movies.model.Bookmark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookmarkJDBCDAO implements DAO<Bookmark>{

    private static final Logger log= LoggerFactory.getLogger(BookmarkJDBCDAO.class);

    RowMapper<Bookmark> rowMapper= (rs, rowNum)->{
        Bookmark bookmark=new Bookmark();
        bookmark.setEmail(rs.getString("email"));
        bookmark.setMovieId(rs.getString("movieId"));
        return bookmark;
    };

    private JdbcTemplate jdbcTemplate;

    public BookmarkJDBCDAO(JdbcTemplate jdbcTemplate){
        try{
            this.jdbcTemplate=jdbcTemplate;
        }catch(Exception e){
            this.jdbcTemplate=null;
        }
    }

    @Override
    public List<Bookmark> list() {

       String sql="select * from Bookmarks";
       return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Bookmark> ListOf(Bookmark bm){
        String sql="select * from Bookmarks where email=? order by movieId" ;
        List<Bookmark> bookmarks=jdbcTemplate.query(sql,rowMapper,bm.getEmail());
        return bookmarks;
    }
    @Override
    public boolean Create(Bookmark bookmark) {
        String sql="insert into Bookmarks values (?,?)";
        log.info("Email bm "+bookmark.getEmail());
        int insert=jdbcTemplate.update(sql,bookmark.getEmail(),bookmark.getMovieId());
        if (insert==1){
            log.info("The movie with Id "+bookmark.getMovieId()+" has been added to your bookmark");
            return true;
        }
        log.info("That user already exists");
        return false;

    }

    @Override
    public Optional<Bookmark> get(Bookmark bm) {
        return null;
    }

    @Override
    public Optional<Bookmark> getUnique(Bookmark bookmark) {
        try {
            String sql = "Select for Bookmarks where email=? and movieId=? order by movieId";
            Bookmark bookmark1 = jdbcTemplate.queryForObject(sql, rowMapper, bookmark.getEmail(), bookmark.getMovieId());
            return Optional.ofNullable(bookmark1);
        }catch(DataAccessException ex){
            log.info("This bookmark does not exist");
        }
        return null;
    }

    @Override
    public void update(Bookmark bm) {

    }

    @Override
    public void delete(Bookmark bm) {
            String sql = "delete from Bookmarks where movieId=? and email=? ";
            jdbcTemplate.update(sql,bm.getMovieId(),bm.getEmail());
            log.info("Successfully deleted movie with ID: "+ bm.getMovieId());
    }
}
