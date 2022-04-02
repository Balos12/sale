package ospan.sale;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import ospan.sale.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepostitory extends JpaRepository <User,Long> {
    List <User> findByEmailContaining(String email);
    List<User> findByNameStartsWith(String name);
    List<User> findBySurnameStartsWith(String surname);
    @Query(value = "select * from users order by name",nativeQuery = true)
    List<User> findUsersByCustomQuery();
    @Query(value = "SELECT * FROM ( SELECT * FROM users ORDER BY id DESC LIMIT 2 ) users",nativeQuery = true)
    List<User> findUsersByCustom();
    List<User> findAllByOrderByNameDesc();
    List <User> findByEmailNotContaining(String email);
    @Query(value = "select * from users where name=surname",nativeQuery = true)
    List<User> findUsersByCust();
    @Query(value = "select * from users where email like '%narxoz%' or email like '%list%' or email like '%ssss%' ",nativeQuery = true)
    List<User> findUsersByCusts();
    @Query(value = "select distinct on (name) * from users  ",nativeQuery = true)
    List<User> findUsersByCus();






}

