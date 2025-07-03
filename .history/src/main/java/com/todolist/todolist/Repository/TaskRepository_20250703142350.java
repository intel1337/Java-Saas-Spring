import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.Repository.;


public interface TaskRepository extends MongoRepository<Task, String> {
}
