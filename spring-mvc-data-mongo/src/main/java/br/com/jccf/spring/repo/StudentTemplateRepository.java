package br.com.jccf.spring.repo;

import br.com.jccf.spring.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.*;

@Repository
public class StudentTemplateRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public StudentTemplateRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public StudentDocument insert(StudentDocument studentDocument) {
        return mongoTemplate.insert(studentDocument);
    }

    public StudentDocument findById(String id) {
        return mongoTemplate.findById(id, StudentDocument.class);
    }
}
