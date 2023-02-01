package br.com.jccf.spring.repo;

import br.com.jccf.spring.entity.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface StudentRepository extends MongoRepository<StudentDocument, String> {
}
