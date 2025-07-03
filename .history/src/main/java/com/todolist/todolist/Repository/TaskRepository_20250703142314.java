import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
}
