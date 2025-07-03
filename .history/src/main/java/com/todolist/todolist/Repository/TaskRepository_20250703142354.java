import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.Model.;


public interface TaskRepository extends MongoRepository<Task, String> {
}
