package base.database;

import org.springframework.data.repository.CrudRepository;

import base.data.Student;

/**
 * Combines the CRUD and custom functionality and makes it available to clients.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
public interface StudentRepository
    extends CrudRepository<Student, String>, StudentRepositoryCustom {

}
