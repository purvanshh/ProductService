package in.purvanshh.projectservice;

import in.purvanshh.projectservice.models.Category
import in.purvanshh.projectservice.models.Product
import in.purvanshh.projectservice.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class ProjectServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(ProjectServiceApplication.class, args);
    }

}