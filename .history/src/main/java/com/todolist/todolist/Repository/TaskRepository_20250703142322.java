import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.repositor.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
}
