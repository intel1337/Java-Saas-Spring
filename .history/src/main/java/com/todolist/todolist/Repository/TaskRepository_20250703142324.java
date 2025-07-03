import org.springframework.data.mongodb.repository.MongoRepository;
import com.todolist.todolist.Repository.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
}
