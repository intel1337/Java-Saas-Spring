import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.repository.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
}
