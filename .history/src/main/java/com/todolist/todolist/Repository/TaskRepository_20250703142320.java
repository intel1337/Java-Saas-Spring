import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.Re.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
}
