import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.odel.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
}
